# Compilation Guide for JavaFX Application

This guide explains how to compile and package the JavaFX application for Linux and Windows using Maven profiles.

## Prerequisites

- Java 21 or later
- Maven 3.6 or later
- JavaFX 21.0.1 (automatically downloaded via Maven)

## Project Structure

- `src/main/java/org/example/Main.java`: Main application class
- `src/main/java/org/example/Controller.java`: FXML controller
- `src/main/resources/sample.fxml`: FXML layout file
- `pom.xml`: Maven configuration with profiles

## Compilation

The project uses Maven profiles to set the correct JavaFX platform classifier for compilation.

### Compile for Linux

Run the following command to compile the application for Linux:

```bash
mvn clean compile -Plinux
```

This activates the `linux` profile, setting `javafx.platform` to `linux`, which downloads the Linux-specific JavaFX JARs.

### Compile for Windows

Run the following command to compile the application for Windows:

```bash
mvn clean compile -Pwindows
```

This activates the `windows` profile, setting `javafx.platform` to `win`, which downloads the Windows-specific JavaFX JARs.

Note: Cross-compilation is possible since JavaFX provides platform-specific JARs. You can compile on Linux for Windows and vice versa.

## Creating Executable Files

To create a standalone executable that doesn't require Java to be installed on the target system, use `jlink` to build a runtime image with the application.

### For Linux

```bash
mvn clean javafx:jlink -Plinux
```

This creates a runtime image in `target/image/`. The executable is located at `target/image/bin/MyApp`.

You can run it directly:

```bash
./target/image/bin/MyApp
```

### For Windows

```bash
mvn clean javafx:jlink -Pwindows
```

This creates a runtime image in `target/image/`. The executable is located at `target/image/bin/MyApp.exe`.

You can run it directly on Windows.

## Running the Application

After compilation, you can run the application using the JavaFX Maven plugin:

```bash
mvn javafx:run -Plinux  # On Linux
mvn javafx:run -Pwindows  # On Windows
```

Or run directly with Java (ensure JavaFX is in the module path):

```bash
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp target/classes org.example.Main
```

## Packaging

The project includes profiles for creating installers.

### Package for Linux (.deb)

Run the following to create a Linux .deb installer:

```bash
mvn clean package -Plinux-package
```

This uses `jlink` to create a runtime image and `jpackage` to build the .deb file.

Note: Requires `fakeroot` for .deb creation on Linux.

### Package for Windows (.exe and .msi)

Run the following to create a Windows app-image and MSI installer:

```bash
mvn clean package -Pwindows-package
```

This uses `jlink` to create a runtime image and `jpackage` to build the portable app-image (containing `MyApp.exe`) and MSI installer.

The app-image is located in `target/MyApp/`, and the MSI installer in `target/`.

You can run the `.exe` directly on Windows without installing Java.

Note: Cross-packaging may require the appropriate jpackage tool for the target platform.

## Troubleshooting

- Ensure JavaFX dependencies are correctly downloaded based on the platform.
- For packaging, verify that `jpackage` is available (part of JDK 14+).
- If running from IDE, add VM options: `--module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml`

## Visual UI Editing

To edit the UI visually:

1. Download and install JavaFX Scene Builder from Gluon.
2. Open `src/main/resources/sample.fxml` in Scene Builder.
3. Make changes and save.
4. Update `Controller.java` for any new event handlers.

The current UI includes a simple button that prints to console on click.
