# JavaVersionCodeChangeTracker

JavaVersionCodeChangeTracker is a comprehensive project that showcases code changes, improvements, and new features introduced in each version of Java. The best way to learn and put these Java enhancements into practice—and to improve your programming skills with the latest versions—is by implementing them directly. This project facilitates that by providing practical examples of implementation.

## Project Structure

Each Java version's changes and features are organized under the `io.github.flmaria` package. Within this package:
- Each Java version has its own dedicated sub-package.
- Each sub-package contains a runnable `Main.java` class that demonstrates the usage of the new features and improvements introduced in that specific version.
- The examples are designed to be simple and illustrative, allowing you to run and observe the output directly.

## Current Java Versions with Examples

- **Java 4 (1.4)**
  - Assertions: `io.github.flmaria.java_004.assertions`
  - Regular Expressions: io.github.flmaria.java_004.regularexpressions`
- **Java 5**
  - Generics: `io.github.flmaria.java_005.generics`
  - Concurrency Utilities: `io.github.flmaria.java_005.concurrencyutilities`
  - Scanner: `io.github.flmaria.java_005.scanner`
- **Java 7**
  - Fork/Join Framework: `io.github.flmaria.java_007.forjjoinframework`
  - NIO.2 (New I/O 2): `io.github.flmaria.java_007.nio2`
- **Java 8**
  - Lambda Expressions: `io.github.flmaria.java_008.lambdaexpressions`
  - Functional Interfaces: `io.github.flmaria.java_008.functionalinterfaces`
  - Stream API: `io.github.flmaria.java_008.streamapi`
  - Default Methods: `io.github.flmaria.java_008.defaultmethods`
  - Optional Class: `io.github.flmaria.java_008.optionalclass`
  - New Date and Time API (java.time package): `io.github.flmaria.java_008.newdateandtimeapi`
  - Parallel Array SortingL `io.github.flmaria.java_008.parallelarraysorting`
  - CompletableFuture and the Concurrency API Enhancements: `io.github.flmaria.java_008.completablefutureandtheconcurrencyapienhancements`
  - Collectors Class: `io.github.flmaria.java_008.collectorsclass`
  - Method References: `io.github.flmaria.java_008.methodreferences`
- **Java 9**
  - Factory Methods for Immutable List, Set, Map and Map.Entry: `io.github.flmaria.java_009.factorymethodforImmutablelistsetandmap`
  - Private methods in Interfaces: `io.github.flmaria.java_009.interfaceprivatemethod`
  - Process API Improvements: `io.github.flmaria.java_009.processhandle`
  - Try with resources Improvements: `io.github.flmaria.java_009.trywithresources`
  - CompletableFuture API Improvements: `io.github.flmaria.java_009.completablefutureapiimprovements`
  - Reactive Streams: `io.github.flmaria.java_009.reactivestreams` 
  - Optional Class Improvements: `io.github.flmaria.java_009.optionalclassimprovements`
  - Stream API Improvements: `io.github.flmaria.java_009.streamapiimprovements`
- **Java 10**
  - Local-Variable Type Inference: `io.github.flmaria.java_010.localvariabletype`
- **Java 11**
  - String Methods: `io.github.flmaria.java_011.stringmethods`
  - Local-Variable Syntax For Lambda Parameters: `io.github.flmaria.java_011.varkeywordinlambdaexpression`
  - Reading/Writing Strings from Files class: `io.github.flmaria.java_011.readwritestringfromfiles`
- **Java 12**
  - Reimplement the Legacy Socket API: `io.github.flmaria.java_012.reimplementthelegacysocketapi`
  - Switch Expressions `io.github.flmaria.java_012.switchexpressions`
- **Java 13**
  - Text Blocks `io.github.flmaria.java_013.textblocks`
  - FileSystems.newFileSystem() Method: `io.github.flmaria.java_013.filesystemsnewfilesystemmethod`
- **Java 14**
  - Pattern Matching for instanceof: `io.github.flmaria.java_014.patternmatchingforinstanceof`
  - Records: `io.github.flmaria.java_014.records`
- **Java 15**
  - Sealed Classes: `io.github.flmaria.java_015.sealedclasses`
- **Java 16**
  - Vector API: `io.github.flmaria.java_016.vectorapi`
- **Java 17**
  - Pattern Matching for switch: `io.github.flmaria.java_017.patternmatchingforswitch`
  - Context-Specific Deserialization Filters: `io.github.flmaria.java_017.contextspecificdeserializationfilters`
  - Enhanced Pseudo-Random Number Generators: `io.github.flmaria.java_017.enhancedpseudorandomnumbergenerators`
- **Java 18**
  - Simple Web Server: `io.github.flmaria.java_018.simplewebserver`
- **Java 19**
  - Virtual Threads: `io.github.flmaria.java_019.virtualthreads`
- **Java 21**
  - Sequenced Collections: `io.github.flmaria.java_021.sequencedcollections`
- **Java 22**
  - Unmodifiable Collection Factory Methods: `io.github.flmaria.java_022.unmodifiablecollectionfactorymethods`
  - New APIs for Daylight Saving Time and Leap Seconds: `io.github.flmaria.java_022.newapisfordaylightsavingtimeandleapseconds`


Each version's sub-package contains a `Main.java` that illustrates these features in a runnable format.


## Requirements

To run this project, you need the following:

- **Java 22**: This project requires Java 22 as it leverages the latest language features and improvements.
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