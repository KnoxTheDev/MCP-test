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
   astyle \
   openjdk-8-jdk \
   rsync \
   scala \
   python2.7 \
 && sudo rm -rf /var/lib/apt/lists/*
