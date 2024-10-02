FROM gitpod/workspace-full-vnc

# Dependencies for chrome
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
 && sudo rm -rf /var/lib/apt/lists/*

# Install legacylauncher from the provided URL
RUN wget https://llaun.ch/repo/downloads/TL_legacy.deb \
 && sudo dpkg -i TL_legacy.deb \
 && sudo apt-get install -f \
 && rm TL_legacy.deb

# Run gp-vncsession in the background
CMD gp-vncsession & tail -f /dev/null
