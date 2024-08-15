# JavaVersionCodeChangeTracker

JavaVersionCodeChangeTracker is a comprehensive project that showcases code changes, improvements, and new features introduced in each version of Java. The best way to learn and put these Java enhancements into practice—and to improve your programming skills with the latest versions—is by implementing them directly. This project facilitates that by providing practical examples of implementation.

## Project Structure

Each Java version's changes and features are organized under the `io.github.flmaria` package. Within this package:
- Each Java version has its own dedicated sub-package.
- Each sub-package contains a runnable `Main.java` class that demonstrates the usage of the new features and improvements introduced in that specific version.
- The examples are designed to be simple and illustrative, allowing you to run and observe the output directly.

## Current Java Versions with Examples

- **Java 9**
   - Factory Methods for Immutable List, Set, Map and Map.Entry: `io.github.flmaria.java_009.factorymethodforImmutablelistsetandmap`
   - Private methods in Interfaces: `io.github.flmaria.java_009.interfaceprivatemethod`
   - Process API Improvements: `io.github.flmaria.java_009.processhandle`
   - Try with resources Improvements: `io.github.flmaria.java_009.trywithresources`
   - CompletableFuture API Improvements: `io.github.flmaria.java_009.completablefutureapiimprovements`

Each version's sub-package contains a `Main.java` that illustrates these features in a runnable format.


## Requirements

To run this project, you need the following:

- **Java 20**: This project requires Java 20 as it leverages the latest language features and improvements.
- **Maven**: The project uses Maven for dependency management, particularly for managing the SLF4J logger dependency.

## How to Use

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/flmaria/JavaVersionCodeChangeTracker.git
2. **Navigate to the Project Directory:**:
   ```bash
   cd JavaVersionCodeChangeTracker
3. **Build the Project::**:
   ```bash
   mvn clean install
4. **Run the Examples:**
- Explore the `io.github.flmaria` package to find sub-packages for each Java version.
- Each sub-package contains a `Main.java` class. You can run this class directly in your preferred IDE or through the command line to see the examples in action.

## Observation

This project is focused solely on code changes and improvements in the Java language. It does not cover improvements in other areas such as the JVM, tools, libraries, or other aspects of the Java ecosystem. The examples and documentation are specifically designed to illustrate changes in Java syntax, APIs, and other code-level enhancements across different versions.