# Music Information System
*A Java-Based Object-Oriented Database*

![Java](https://img.shields.io/badge/Java-Object%20Oriented-red)
![Status](https://img.shields.io/badge/Status-Complete-success)
![Focus](https://img.shields.io/badge/Focus-OOP%20Design-purple)

---

## Overview

This project is a **Java-based music information system** built around a collection of real album data, implemented using an object-oriented design approach.

The project was developed as part of **CMP-4008Y Programming 1**, with a strong emphasis on **class design, encapsulation, abstraction, and the use of Java collections and standard libraries**, rather than simply producing correct query output.

---

## Key Features

- Parses a structured plain-text album database (`albums.txt`) into a collection of Java objects
- Hierarchical object model: `AlbumCollection` → `Album` → `Track` → `Duration`
- Albums displayed in alphabetical order by artist, then ascending by release year
- Query: total play time of all Kraftwerk albums in the collection
- Query: album with the shortest title
- Query: longest track across the entire collection
- `Duration` implements `Comparable<Duration>` for natural ordering via total seconds conversion
- Duration arithmetic via an `add()` method for accumulating track times
- Clean `toString()` overrides throughout for readable, numbered output
- File parsing via `Scanner` with character-based line detection (`isLetter` / `isDigit`)
- Each class includes its own `main()` test harness for isolated unit testing
- Designed for zero keyboard input — fully automated output pipeline

---

## Class Structure

| Class | Responsibility |
|-------|---------------|
| `Duration` | Stores hours, minutes, seconds; implements `Comparable<Duration>`; supports `add()` |
| `Track` | Stores a track title and its `Duration` |
| `Album` | Stores artist, title, release year, and an `ArrayList` of `Track` objects; computes total duration |
| `AlbumCollection` | Stores all `Album` objects; provides sort, query, and display methods |
| `AlbumDatabase` | Entry point; reads `albums.txt` via `Scanner` and runs all queries |

---

## Core Functionality

The program performs the following steps:

1. Read and parse `albums.txt` into an `AlbumCollection` of `Album` and `Track` objects using `Scanner`
2. Sort and display the full collection alphabetically by artist, then by release year using a lambda comparator
3. Calculate and display the total play time of all Kraftwerk albums
4. Find and display the album with the shortest title
5. Find and display the longest track across all albums in the collection

---

## Sample Data

The system is loaded with 20 albums from artists including:

| Artist | Album | Year |
|--------|-------|------|
| The Beatles | Rubber Soul | 1965 |
| Pink Floyd | Dark Side of the Moon | 1973 |
| Led Zeppelin | Led Zeppelin IV | 1971 |
| Miles Davis | Kind of Blue | 1959 |
| Kraftwerk | The Man Machine | 1978 |
| Kraftwerk | Trans Europe Express | 1977 |
| Blondie | Parallel Lines | 1978 |
| Pulp | Different Class | 1995 |

---

## Tech Stack

- **Java 17**
- **Java Standard Libraries** — `Scanner`, `File`, `ArrayList`, `Collections`, `StringBuilder`
- **IntelliJ IDEA** — development environment

---

## Project Structure

| File | Description |
|------|-------------|
| `Duration.java` | Duration model with `compareTo()` and `add()` logic |
| `Track.java` | Track model with title and duration |
| `Album.java` | Album model with track list and total duration calculation |
| `AlbumCollection.java` | Collection model with sort and query methods |
| `AlbumDatabase.java` | Main entry point — parses file and runs all queries |
| `albums.txt` | Source data file (20 albums, 200+ tracks) |

---

## Skills Demonstrated

- Object-oriented design (encapsulation, abstraction, cohesion)
- Multi-class Java program architecture
- File-based I/O with `Scanner`
- Java collections (`ArrayList`, `Collections.sort()`) with lambda comparators
- Implementing `Comparable` for custom duration ordering
- Duration arithmetic (accumulation via `add()`)
- Per-class `main()` test harnesses for bottom-up testing
- Top-down design, bottom-up implementation

---

## Academic Context

This project was completed as part of **CMP-4008Y Programming 1** at the University of East Anglia, focusing on the design and implementation of object-oriented programs in Java.

While academic in origin, the project reflects real-world principles of modular software design and data modelling used in production systems.

---

## License

This project is shared for educational and portfolio purposes only.
Please do not submit this work (or derivatives) as your own for academic assessment.

---

## Author

**Kurt Canillas**  
Computer Science Undergraduate
