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
docker run loginapp
```

### Note: this is a GUI app

Since this app opens Swing windows, the container needs access to a display
to actually show them on screen.

**Linux (X11):**

```bash
docker run -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix loginapp
```

**Windows/Mac:** requires an X server (e.g. VcXsrv on Windows, XQuartz on Mac)
running and reachable, with `DISPLAY` set accordingly.

Without a display connection, the container will fail to open the GUI windows.
