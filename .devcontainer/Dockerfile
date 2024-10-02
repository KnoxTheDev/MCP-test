FROM gitpod/workspace-full-vnc

# Dependences for chrome
RUN sudo apt-get update \
 && sudo DEBIAN_FRONTEND=noninteractive apt-get install -y \
   libgtk2.0-0 \
   libgtk-3-0 \
   libnotify-dev \
   libgconf-2-4 \
   libnss3 \
   libxss1 \
   libasound2 \
   libxtst6 \
   xauth \
   xvfb \
   python2.7 \
   astyle \
   openjdk-8-jdk \
   rsync \
   scala \
 && sudo rm -rf /var/lib/apt/lists/* \
 && export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64 \
 && export PATH=$JAVA_HOME/bin:$PATH
