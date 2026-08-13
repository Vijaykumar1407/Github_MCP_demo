# Login App

A simple Java Swing desktop app with three screens:

1. **Login Screen** — enter username & password
2. **Details Screen** — enter full name & email
3. **Output Screen** — displays all four values, read back via getters

Values are stored in a single `UserData` object (with getters/setters) that is
passed from screen to screen.

## Files

| File | Purpose |
|---|---|
| `Main.java` | Entry point, launches the Login screen |
| `UserData.java` | Model class with getters/setters for the collected fields |
| `LoginScreen.java` | Screen 1 — username & password |
| `DetailsScreen.java` | Screen 2 — full name & email |
| `OutputScreen.java` | Screen 3 — shows all stored values |
| `Dockerfile` | Builds and runs the app in a container |

## Run locally (without Docker)

Requires a JDK (17+) on your machine.

```bash
javac *.java
java Main
```

## Build and run with Docker

```bash
docker build -t loginapp .
docker run -p 5900:5900 loginapp
```

### Note: this is a GUI app

Since this app opens Swing windows, the container needs a display to actually
show them on screen. The image bundles `Xvfb` (a virtual display) and
`x11vnc` (serves that display over VNC), so no display is required on the
host — the container provides its own.

Once the container is running, connect a VNC client (e.g. TigerVNC, RealVNC)
to:

```
<host-ip>:5900
```

This works the same way whether you're running Docker locally or on a
headless remote server (e.g. an EC2 instance) — you'll see and can click
through the Login, Details, and Output screens over VNC.

**Alternative — forwarding your own X server instead of VNC:**

If you're on Linux and prefer to forward your local display instead:

```bash
docker run -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix loginapp
```

This requires an X server reachable from the container (built-in on Linux;
on Windows/Mac you'd need VcXsrv/XQuartz), so VNC is the simpler default,
especially for remote/headless servers.
