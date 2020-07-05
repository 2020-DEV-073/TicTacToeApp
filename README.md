# Tic Tac Toe Kotlin

## Rules

- X always goes first.

- Players cannot play on a played position.

- Players alternate placing X’s and O’s on the board until either:

    - One player has three in a row, horizontally, vertically or diagonally

    - All nine squares are filled.

- If a player is able to draw three X’s or three O’s in a row, that player wins.

- If all nine squares are filled and neither player has three in a row, the game is a draw.

## Run Application
The project is built with Gradle. All tasks and options can be invoked from Android Studio.
For the command line, run Gradle to build the project and to run the tests using the following command on Unix/macOS:
```bash
$ ./gradlew <tasks-and-options>
```
or the following command on Windows:
```bash
$ gradlew <tasks-and-options>
```

### For example:
- to clean the app:
```bash
$ ./gradlew clean
```

- to build and install the app:
```bash
$ ./gradlew install
```

- to run the tests the app:
```bash
$ ./gradlew test
```
