# Java Practice

[![CI](https://github.com/MakmotRobin/java-practice/actions/workflows/ci.yml/badge.svg)](https://github.com/MakmotRobin/java-practice/actions/workflows/ci.yml)
[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://adoptium.net/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5.11.4-25a162)](https://junit.org/junit5/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A single Maven project holding the Java and SQL exercises I wrote while learning
object-oriented programming. The original work was spread over 21 separate
repositories, one per topic. They are consolidated here so the code can be
built, tested and read in one place.

Every exercise is a real, compiling class with a `main` demo, and the behaviour
is pinned down by **72 JUnit tests** across **14 test classes**. CI builds and
tests the project on Java 17 and Java 21.

## Requirements

- JDK 17 or newer (built and tested with JDK 21)
- Maven 3.9+

## Build and test

```bash
mvn test        # compile everything and run the 72 tests
mvn package     # also produce target/java-practice-1.0.0.jar
```

## Running a demo

Each topic has a `*Demo` class with a `main` method. Run one with the
`exec-maven-plugin`:

```bash
mvn -q exec:java -Dexec.mainClass=io.github.makmotrobin.practice.vehicles.RentalDemo
```

| Demo | What it shows |
| --- | --- |
| `enums.MonthDemo` | Iterating an enum and the implicit `name()`/`values()` API |
| `oop.abstractclasses.VehicleDemo` | Abstract classes, `super` calls and overridden behaviour |
| `oop.interfaces.CollegeDemo` | Multiple interfaces on one class (`LearningPerson` + `TeachingPerson`) |
| `oop.overloading.ShapeDemo` | Constructor overloading |
| `oop.polymorphism.AnimalDemo` | Runtime dispatch through a base-type array |
| `oop.objectmethods.SmartphoneDemo` | `equals`, `hashCode`, `toString` and a deep `clone` |
| `collections.SetDemo` | `HashSet` vs `LinkedHashSet` ordering |
| `study.StudentDemo` | Averages, grade assignment and stream filtering |
| `customers.CustomerDemo` | Inheritance plus entity equality |
| `interview.InterviewDemo` | SIM card call log — total minutes and calls per number |
| `interview.ProductDemo` | Applying a 5% discount to a product price |
| `phone.PhoneDemo` | Call and text history behind an interface |
| `phone.DefangIpAddress` | Defanging an IPv4 address |
| `streams.Exercises` | Small debugger exercises (factorial, reverse, positive check) |
| `streams.FileReaderDemo` | Reading a classpath resource line by line |
| `vehicles.RentalDemo` | A vehicle rental system with history and state checks |

## Project layout

```
src/main/java/io/github/makmotrobin/practice/
├── collections/      SetDemo
├── customers/        Person, Customer, Manager + demo
├── enums/            Month + demo
├── interview/        Call, SIM, Product + demos
├── math/             MathOperations (target of the JUnit exercise)
├── oop/
│   ├── abstractclasses/  Vehicle, Car, Boat + demo
│   ├── interfaces/       CollegePerson hierarchy + demo
│   ├── objectmethods/    Smartphone/SmartphonePrice + demo
│   ├── overloading/      Shape + demo
│   └── polymorphism/     Animal, Lion, Cow + demo
├── phone/            Phone, OnePhone, RobinPhone, DefangIpAddress + demo
├── streams/          Exercises, FileReaderDemo
├── study/            Student, Professor + demo
└── vehicles/         Vehicle, AbstractVehicle, Car, Motorcycle, Sedan, SportBike + demo
```

`src/main/resources/file.txt` is the sample file read by `FileReaderDemo`; it is
loaded from the classpath so the demo works from the IDE, Maven and the
packaged jar alike.

## SQL exercises

The `sql/` directory holds the database work, written in portable ANSI SQL:

| File | Purpose |
| --- | --- |
| `sql/schema.sql` | `ingredients` and `meals` tables |
| `sql/seed.sql` | Sample rows used by the queries and by the tests |
| `sql/queries.sql` | The ten `WHERE`-clause exercises |
| `sql/archive/interview-dump.sql` | A phpMyAdmin dump kept for reference only |

`SqlScriptTest` executes `schema.sql` and `seed.sql` against an in-memory H2
database, then runs all ten queries and asserts their row counts. The scripts
cannot silently rot: rename a column and CI fails.

## What changed from the original repositories

This is a consolidated and cleaned-up version of the homework, not a verbatim
copy. The original files were single-purpose scripts, often with several public
classes in one file and `Scanner`-driven `main` methods. Consolidating them into
one Maven module meant changing a few things:

- **Packages.** Every class now lives under `io.github.makmotrobin.practice.*`.
  The `oop` exercises are split into `abstractclasses`, `interfaces`,
  `objectmethods`, `overloading` and `polymorphism`.
- **Name collisions resolved.** `Student`/`Professor` existed in two unrelated
  exercises; the interface-based ones are now `CollegeStudent` and
  `CollegeProfessor`, and the assistant is `TeachingAssistant`. `Cari` became
  `Car`.
- **One public type per file.** Classes that shared a file (for example
  `Shape`/`ShapeTest`) were split, and `*Test` demo classes became `*Demo` so
  they no longer clash with the JUnit test naming convention.
- **No test assertions in production code.** The debugger exercises originally
  called `Assertions.assertEquals` from `main`; the logic moved into plain
  static methods in `streams.Exercises` and is asserted from
  `ExercisesTest`.
- **No interactive input.** Methods that read from `System.in` now take their
  arguments, so they can be called from tests.
- **Resource loading.** `FileReader` read a path relative to the working
  directory, which only worked inside the IDE. It now loads `/file.txt` from
  the classpath.

### Bugs fixed along the way

- `Customer` and `Manager` compared equal by username **and password** but
  hashed only the id, breaking the `equals`/`hashCode` contract. Both are now
  entities: equality follows the generated id. `Person` compares by username
  and hashes the username, so the contract holds. Passwords are no longer
  readable — `hasPassword(String)` is the only way to check one.
- `Month.endsWithY()` tested against lowercase `"y"` while enum names are
  upper case, so it returned `false` for every month.
- `SIM.getCallsToNumber` compared the target number to the SIM's own number
  instead of the dialled number, so the count never depended on whom you
  called. `Call` now records the dialled number.
- `SetDemo.weekInOrder()` built a `LinkedHashSet` from `Set.of(...)`, which
  destroyed the insertion order it was meant to demonstrate.
- The vehicle rental exercise threw checked `Exception`s for conditions that
  are programming errors; those are now `IllegalStateException` and
  `IllegalArgumentException`, with rental history capped at five entries.

## License

[MIT](LICENSE) © 2026 MakmotRobin
