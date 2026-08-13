FROM eclipse-temurin:17-jdk

RUN apt-get update && \
    apt-get install -y xvfb x11vnc && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY *.java ./

RUN javac *.java

EXPOSE 5900

CMD Xvfb :99 -screen 0 1024x768x16 & \
    x11vnc -display :99 -forever -nopw -rfbport 5900 & \
    DISPLAY=:99 java Main
