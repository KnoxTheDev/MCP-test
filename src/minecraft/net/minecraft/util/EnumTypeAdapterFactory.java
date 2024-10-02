package net.minecraft.util;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class EnumTypeAdapterFactory implements TypeAdapterFactory
{
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type)
    {
        Class<? super T> rawType = type.getRawType();

        if (!rawType.isEnum())
        {
            return null;
        }
        else
        {
            final Map<String, T> map = Maps.newHashMap();

            // Cast rawType to Class<T> safely after confirming it's an enum
            @SuppressWarnings("unchecked")
            Class<T> enumClass = (Class<T>) rawType;

            for (T t : enumClass.getEnumConstants())
            {
                map.put(this.toLowerCase(t), t);
            }

            return new TypeAdapter<T>()
            {
                @Override
                public void write(JsonWriter out, T value) throws IOException
                {
                    if (value == null)
                    {
                        out.nullValue();
                    }
                    else
                    {
                        out.value(EnumTypeAdapterFactory.this.toLowerCase(value));
                    }
                }

                @Override
                public T read(JsonReader in) throws IOException
                {
                    if (in.peek() == JsonToken.NULL)
                    {
                        in.nextNull();
                        return null;
                    }
                    else
                    {
                        return map.get(in.nextString());
                    }
                }
            };
        }
    }

    private String toLowerCase(Object obj)
    {
        return obj instanceof Enum ? ((Enum<?>) obj).name().toLowerCase(Locale.US) : obj.toString().toLowerCase(Locale.US);
    }
}
