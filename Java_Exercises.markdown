# Java Programming Exercises Based on Effective Java

## 2 Creating and Destroying Objects

### Item 1: Consider static factory methods instead of constructors
1. Create a `Book` class with private constructors and provide static factory methods like `Book.ofTitle(String title)` and `Book.ofTitleAndAuthor(String title, String author)` to instantiate objects with different parameters.
2. Implement a `Color` class with static factory methods to create predefined colors (e.g., `Color.red()`, `Color.blue()`) instead of using public constructors.
3. Design a `DatabaseConnection` class that uses a static factory method to return a connection based on a configuration string, ensuring a single instance per configuration.
4. Create a `Point` class with static factory methods for creating points in Cartesian (`Point.fromCartesian(double x, double y)`) and polar (`Point.fromPolar(double radius, double angle)`) coordinates.
5. Write a `Logger` class with a static factory method `Logger.getInstance(String name)` that returns a logger instance, caching instances to avoid duplicates.

### Item 2: Consider a builder when faced with many constructor parameters
1. Implement a `Pizza` class with a `Builder` pattern to handle optional toppings, size, and crust type, ensuring immutability.
2. Create a `Car` class using the Builder pattern to configure attributes like model, color, engine type, and optional features (e.g., sunroof, GPS).
3. Design a `UserProfile` class with a Builder to set required fields (username, email) and optional fields (phone, address, age).
4. Build a `House` class with a Builder pattern to configure rooms, floors, and optional amenities like garage or pool.
5. Write a `Report` class with a Builder to set title, content, author, and optional metadata like date and category, ensuring required fields are set.

### Item 3: Enforce the singleton property with a private constructor or an enum type
1. Implement a `Settings` singleton class using a private constructor and a static `getInstance()` method to manage application settings.
2. Create a `Cache` singleton using an enum to store key-value pairs, ensuring thread-safe singleton behavior.
3. Write a `DatabaseManager` singleton class with a private constructor to manage a single database connection.
4. Design a `Logger` singleton using an enum to provide a single logging instance across an application.
5. Implement a `Configuration` singleton with a private constructor that loads properties from a file, ensuring only one instance exists.

### Item 4: Enforce noninstantiability with a private constructor
1. Create a `MathUtils` class with a private constructor and static methods for mathematical operations like `factorial(int n)` and `isPrime(int n)`.
2. Implement a `StringUtils` class with a private constructor and static methods for string manipulation (e.g., `reverse(String s)`, `isPalindrome(String s)`).
3. Design a `Constants` class with a private constructor to hold static final constants like `PI` and `GRAVITY`.
4. Write a `ValidationUtils` class with a private constructor and static methods to validate email addresses and phone numbers.
5. Create a `FileUtils` class with a private constructor and static methods for file-related operations like reading or writing text.

### Item 5: Prefer dependency injection to hardwiring resources
1. Implement a `NotificationService` class that accepts a `MessageSender` dependency (e.g., `EmailSender` or `SMSSender`) via constructor injection.
2. Create a `UserService` class that depends on a `Database` interface, injected through the constructor, to save user data.
3. Design a `PaymentProcessor` class that accepts a `PaymentGateway` dependency via setter injection to process payments.
4. Write a `ReportGenerator` class that uses constructor injection to accept a `DataSource` for generating reports.
5. Implement a `OrderProcessor` class that depends on injected `InventoryService` and `PaymentService` to process customer orders.

### Item 6: Avoid creating unnecessary objects
1. Rewrite a method that creates a new `String` object in a loop (e.g., `new String("constant")`) to use a single `String` instance.
2. Implement a `Counter` class that reuses a static `Integer` cache for values between 0 and 100 instead of creating new `Integer` objects.
3. Create a `DateFormatter` class that reuses a single `SimpleDateFormat` instance instead of creating one per method call.
4. Optimize a `Point` class to reuse immutable `Point` objects for common coordinates (e.g., (0,0), (1,1)) using a static cache.
5. Write a `Config` class that loads properties once and reuses them instead of reading from a file multiple times.

### Item 7: Eliminate obsolete object references
1. Implement a `Stack` class that nulls out references to popped elements to prevent memory leaks.
2. Create a `Cache` class that removes stale entries and nulls out references to prevent memory retention.
3. Write a `Queue` class that ensures dequeued elements are no longer referenced to avoid memory leaks.
4. Design a `SessionManager` class that clears references to expired sessions to free memory.
5. Implement a `Graph` class that removes references to deleted nodes to prevent memory leaks in a graph structure.

### Item 8: Avoid finalizers and cleaners
1. Rewrite a class that uses a finalizer to close a file, replacing it with try-with-resources.
2. Convert a class that uses a cleaner to release database connections to use explicit resource management.
3. Implement a `ResourceHolder` class that manages resources without relying on finalizers or cleaners.
4. Refactor a `NetworkConnection` class to close connections explicitly instead of using a finalizer.
5. Create a `FileProcessor` class that handles file resources using try-with-resources instead of cleaners.

### Item 9: Prefer try-with-resources to try-finally
1. Write a method to read a file using try-with-resources to ensure proper resource closure.
2. Implement a `DatabaseQuery` class that uses try-with-resources to manage database connections.
3. Create a `SocketClient` class that uses try-with-resources to handle socket connections.
4. Refactor a `FileWriter` class to use try-with-resources instead of try-finally for writing to a file.
5. Design a `ResourceManager` class that uses try-with-resources to handle multiple resources (e.g., file and database).

## 3 Methods Common to All Objects

### Item 10: Obey the general contract when overriding equals
1. Implement an `Employee` class with `id` and `name` fields, overriding `equals` to compare both fields correctly.
2. Create a `Point` class with `x` and `y` coordinates, ensuring the `equals` method satisfies the general contract.
3. Write a `Book` class with `title`, `author`, and `isbn`, overriding `equals` to compare all fields.
4. Design a `ComplexNumber` class with real and imaginary parts, implementing a correct `equals` method.
5. Implement a `Student` class with `studentId` and `grade`, ensuring `equals` is symmetric and transitive.

### Item 11: Always override hashCode when you override equals
1. Add a `hashCode` method to the `Employee` class from Item 10, ensuring consistency with `equals`.
2. Implement `hashCode` for the `Point` class from Item 10, using both `x` and `y` fields.
3. Create a `hashCode` method for the `Book` class from Item 10, incorporating all fields.
4. Write a `hashCode` method for the `ComplexNumber` class from Item 10, ensuring good distribution.
5. Implement `hashCode` for the `Student` class from Item 10, consistent with its `equals` method.

### Item 12: Always override toString
1. Add a `toString` method to the `Employee` class to return a formatted string with `id` and `name`.
2. Implement `toString` for the `Point` class to display coordinates in the format `(x, y)`.
3. Create a `toString` method for the `Book` class to include `title`, `author`, and `isbn`.
4. Write a `toString` method for the `ComplexNumber` class in the format `a + bi`.
5. Implement `toString` for the `Student` class to show `studentId` and `grade` in a readable format.

### Item 13: Override clone judiciously
1. Implement a `Cloneable` `Matrix` class with a deep `clone` method for a 2D array.
2. Create a `TreeNode` class with a `clone` method that performs a deep copy of the tree structure.
3. Write a `Person` class with a `clone` method that copies fields like `name` and `address` deeply.
4. Implement a `Graph` class with a `clone` method that copies nodes and edges correctly.
5. Design a `Configuration` class with a `clone` method to create a deep copy of its properties.

### Item 14: Consider implementing Comparable
1. Implement `Comparable` for the `Employee` class, comparing by `id`.
2. Create a `Product` class that implements `Comparable` based on price.
3. Write a `Student` class that implements `Comparable` based on `grade` and then `name`.
4. Design a `Task` class that implements `Comparable` based on priority and due date.
5. Implement `Comparable` for a `Point` class, comparing by distance from origin.

## 4 Classes and Interfaces

### Item 15: Minimize the accessibility of classes and members
1. Refactor a `User` class to make fields private and provide public getters/setters only where necessary.
2. Create a `BankAccount` class with private fields and minimal public methods for balance operations.
3. Design a `Library` class with private collections and public methods for borrowing books.
4. Write a `Game` class with private state and public methods for gameplay actions.
5. Implement a `Config` class with private fields and a minimal public API for configuration access.

### Item 16: In public classes, use accessor methods, not public fields
1. Refactor a `Person` class to replace public fields with private fields and accessor methods.
2. Create a `Rectangle` class with private `width` and `height` fields and public getters/setters.
3. Design a `Car` class with private fields and accessor methods for attributes like `model` and `year`.
4. Write a `Student` class with private fields and accessor methods for `name` and `id`.
5. Implement a `Product` class with private fields and accessor methods for `name` and `price`.

### Item 17: Minimize mutability
1. Create an immutable `Point` class with final fields and no setters.
2. Implement an immutable `Money` class with `amount` and `currency` fields.
3. Design an immutable `Event` class with `date`, `title`, and `location` fields.
4. Write an immutable `Address` class with `street`, `city`, and `zip` fields.
5. Create an immutable `Fraction` class with `numerator` and `denominator` fields.

### Item 18: Favor composition over inheritance
1. Refactor a `Vehicle` class to use composition instead of inheriting from a `Car` class.
2. Create a `Logger` class that uses composition with a `Writer` instead of extending a base class.
3. Design a `Shape` class that uses composition for drawing behavior instead of inheritance.
4. Implement a `Player` class that composes `Inventory` instead of extending it.
5. Write a `Document` class that uses composition for formatting instead of inheriting a formatter.

### Item 19: Design and document for inheritance or else prohibit it
1. Create a `BaseShape` class designed for inheritance with proper documentation and protected methods.
2. Write a `Counter` class that prohibits inheritance using `final`.
3. Design a `Report` class with clear documentation for subclasses to override specific methods.
4. Implement a `DataProcessor` class that is sealed to prevent inheritance.
5. Create a `MathOperation` class with protected methods for subclasses to extend.

### Item 20: Prefer interfaces to abstract classes
1. Define a `Drawable` interface and implement it in `Circle` and `Rectangle` classes.
2. Create a `Loggable` interface for logging and implement it in multiple classes.
3. Design a `Serializable` interface for data serialization, implemented by `User` and `Order` classes.
4. Write a `Comparable` interface for sorting, implemented by `Product` and `Employee` classes.
5. Implement a `Resizable` interface for shapes like `Square` and `Triangle`.

### Item 21: Design interfaces for posterity
1. Create a `FileReader` interface with methods designed to be future-proof (e.g., `readLine()`).
2. Design a `PaymentProcessor` interface with minimal, flexible methods for payment handling.
3. Write a `MessageSender` interface with methods that avoid breaking changes in future versions.
4. Implement a `DataStore` interface with methods that allow for future extensions.
5. Create a `TaskExecutor` interface with a single, general-purpose method for task execution.

### Item 22: Use interfaces only to define types
1. Refactor a `Constants` interface used for constants into a class with static fields.
2. Create a `MathOperations` interface used correctly to define operation types, not constants.
3. Design a `Shape` interface to define shape types, avoiding constant definitions.
4. Write a `Logger` interface for logging behavior, not for holding configuration constants.
5. Implement a `Validator` interface for validation logic, ensuring it defines only types.

### Item 23: Prefer class hierarchies to tagged classes
1. Refactor a tagged `Shape` class (with a type field) into a hierarchy with `Circle` and `Rectangle` subclasses.
2. Convert a tagged `Vehicle` class into a hierarchy with `Car` and `Truck` subclasses.
3. Design a `Payment` class hierarchy instead of a tagged class with `type` field.
4. Rewrite a tagged `Employee` class into a hierarchy with `Manager` and `Developer` subclasses.
5. Implement a `Message` class hierarchy instead of a tagged class for `Email` and `SMS`.

### Item 24: Favor static member classes over nonstatic
1. Create a static nested `Node` class inside a `Tree` class for tree nodes.
2. Implement a static nested `Entry` class in a `Cache` class for cache entries.
3. Design a static nested `Point` class in a `Graph` class for graph vertices.
4. Write a static nested `Item` class in an `Inventory` class for inventory items.
5. Refactor a nonstatic nested class in a `Database` class to a static nested `Query` class.

### Item 25: Limit source files to a single top-level class
1. Split a source file with multiple top-level classes (`Point` and `Line`) into separate files.
2. Refactor a file containing `User` and `Profile` classes into individual files.
3. Create separate files for `Order` and `OrderItem` classes originally in one file.
4. Separate a file with `Car` and `Engine` classes into two files.
5. Split a file containing `Book` and `Author` classes into distinct files.

## 5 Generics

### Item 26: Don’t use raw types
1. Refactor a raw `List` in a `UserManager` class to use `List<User>`.
2. Convert a raw `Map` in a `Cache` class to `Map<String, Object>`.
3. Rewrite a raw `Set` in a `PermissionManager` to `Set<Permission>`.
4. Fix a raw `Collection` in a `DataStore` class to use `Collection<Data>`.
5. Refactor a raw `Queue` in a `TaskManager` to `Queue<Task>`.

### Item 27: Eliminate unchecked warnings
1. Fix an unchecked warning in a `List` assignment by specifying the generic type.
2. Eliminate an unchecked warning in a `Map` cast by using proper generics.
3. Refactor a method with an unchecked warning in a generic `Set` operation.
4. Fix an unchecked warning in a `Collection` cast by adding type parameters.
5. Rewrite a generic method to eliminate an unchecked warning in a `List` operation.

### Item 28: Prefer lists to arrays
1. Refactor a method returning an array of `String` to return a `List<String>`.
2. Convert a method using a `Point[]` array to use a `List<Point>`.
3. Rewrite a `User[]` array in a `UserManager` class to use a `List<User>`.
4. Replace an `Integer[]` array in a `Counter` class with a `List<Integer>`.
5. Refactor a `Product[]` array in an `Inventory` class to use a `List<Product>`.

### Item 29: Favor generic types
1. Create a generic `Stack<T>` class to handle any type of elements.
2. Implement a generic `Pair<K, V>` class to store key-value pairs.
3. Design a generic `Queue<T>` class for a type-safe queue.
4. Write a generic `Container<T>` class to hold a single item of any type.
5. Create a generic `Result<T, E>` class to represent success or error results.

### Item 30: Favor generic methods
1. Write a generic method `swap(List<T>, int i, int j)` to swap elements in a list.
2. Implement a generic method `max(List<T extends Comparable<T>>)` to find the maximum element.
3. Create a generic method `copy(List<T>, List<T>)` to copy elements between lists.
4. Write a generic method `filter(List<T>, Predicate<T>)` to filter elements.
5. Implement a generic method `merge(List<T>, List<T>)` to merge two lists.

### Item 31: Use bounded wildcards to increase API flexibility
1. Write a method `printList(List<? extends Number>)` to print numbers.
2. Create a method `addAll(List<? super Integer>, List<Integer>)` to add integers to a list.
3. Implement a method `processShapes(List<? extends Shape>)` to process shapes.
4. Design a method `copyTo(List<? super T>, List<T>)` for flexible copying.
5. Write a method `countElements(List<? extends Object>)` to count elements.

### Item 32: Combine generics and varargs judiciously
1. Write a safe varargs method `toList(T... elements)` to create a list from arguments.
2. Implement a varargs method `sum(Number... numbers)` to sum numbers safely.
3. Create a varargs method `addAll(Collection<T>, T... elements)` to add elements.
4. Write a varargs method `printAll(T... items)` to print items safely.
5. Design a varargs method `createSet(T... elements)` to create a set.

### Item 33: Consider typesafe heterogeneous containers
1. Implement a `Favorites` class that stores objects of different types using `Class` as a key.
2. Create a `TypeSafeMap` class to store key-value pairs with type safety.
3. Design a `Registry` class for storing heterogeneous objects with type-safe retrieval.
4. Write a `ConfigStore` class to hold configuration values of different types.
5. Implement a `TypeSafeContainer` class to manage objects with type-safe access.

## 6 Enums and Annotations

### Item 34: Use enums instead of int constants
1. Replace int constants in a `Day` class with a `Day` enum (e.g., `MONDAY`, `TUESDAY`).
2. Convert int constants for `Status` (e.g., `OPEN`, `CLOSED`) to a `Status` enum.
3. Refactor int constants in a `Color` class to a `Color` enum.
4. Create an `Operation` enum to replace int constants for arithmetic operations.
5. Implement a `Priority` enum to replace int constants for task priorities.

### Item 35: Use instance fields instead of ordinals
1. Add instance fields to a `Day` enum to store working hours instead of using ordinals.
2. Create a `Status` enum with a `description` field instead of relying on ordinals.
3. Implement a `Color` enum with RGB fields instead of using ordinals.
4. Write an `Operation` enum with a `symbol` field instead of ordinals.
5. Design a `Priority` enum with a `level` field instead of ordinals.

### Item 36: Use EnumSet instead of bit fields
1. Refactor a `Permissions` class using bit fields to use an `EnumSet` for permissions.
2. Convert a `Features` class with bit fields to an `EnumSet` for enabled features.
3. Rewrite a `Roles` class using bit fields to an `EnumSet` for user roles.
4. Implement a `Settings` class using `EnumSet` instead of bit fields for options.
5. Create a `Flags` class that uses `EnumSet` to manage configuration flags.

### Item 37: Use EnumMap instead of ordinal indexing
1. Refactor a `DaySchedule` class using an array indexed by ordinals to use an `EnumMap`.
2. Convert a `StatusCount` class with an ordinal-indexed array to an `EnumMap`.
3. Implement a `ColorMap` class using `EnumMap` instead of an ordinal-based array.
4. Write an `OperationResult` class using `EnumMap` for operation outcomes.
5. Design a `PriorityTasks` class using `EnumMap` to map priorities to tasks.

### Item 38: Emulate extensible enums with interfaces
1. Create an `Operation` interface and implement it in multiple enums (e.g., `BasicOperation`, `AdvancedOperation`).
2. Design a `Shape` interface with `Circle` and `Rectangle` enums implementing it.
3. Implement a `Command` interface with enums like `FileCommand` and `NetworkCommand`.
4. Write a `TaskType` interface with enums for `UserTask` and `SystemTask`.
5. Create a `PaymentType` interface with enums for `CreditCard` and `BankTransfer`.

### Item 39: Prefer annotations to naming patterns
1. Replace a naming pattern (e.g., `test*`) with a `@Test` annotation for test methods.
2. Create a `@Config` annotation to replace naming patterns for configuration methods.
3. Implement a `@Log` annotation to mark methods for logging instead of a naming convention.
4. Design a `@Validate` annotation to replace naming patterns for validation methods.
5. Write a `@Cacheable` annotation to mark methods for caching instead of naming.

### Item 40: Consistently use the Override annotation
1. Add `@Override` to methods in a `Rectangle` class overriding `Shape` methods.
2. Refactor a `Car` class to use `@Override` for all overridden methods.
3. Ensure `@Override` is used in a `Student` class overriding `Person` methods.
4. Add `@Override` to a `Logger` class overriding interface methods.
5. Refactor a `Processor` class to include `@Override` for all overridden methods.

### Item 41: Use marker interfaces to define types
1. Create a `Serializable` marker interface and implement it in a `Data` class.
2. Design a `Loggable` marker interface for classes that support logging.
3. Implement a `Cacheable` marker interface for cacheable objects.
4. Write a `Printable` marker interface for classes that can be printed.
5. Create a `Persistable` marker interface for objects that can be saved.

## 7 Lambdas and Streams

### Item 42: Prefer lambdas to anonymous classes
1. Refactor an anonymous `Comparator` in a `sort` method to use a lambda expression.
2. Convert an anonymous `Runnable` in a `Thread` to a lambda expression.
3. Rewrite an anonymous `ActionListener` in a GUI to a lambda expression.
4. Replace an anonymous `Predicate` in a filter with a lambda expression.
5. Convert an anonymous `Function` in a stream operation to a lambda expression.

### Item 43: Prefer method references to lambdas
1. Replace a lambda `(x) -> String.valueOf(x)` with a method reference in a stream.
2. Convert a lambda `(s) -> s.toUpperCase()` to a method reference in a stream.
3. Refactor a lambda `(x) -> System.out.println(x)` to a method reference.
4. Replace a lambda `(x, y) -> x.compareTo(y)` with a method reference in a `sort`.
5. Convert a lambda `(x) -> Math.abs(x)` to a method reference in a stream.

### Item 44: Favor the use of standard functional interfaces
1. Use `Predicate` in a method to filter a `List<Integer>` for even numbers.
2. Implement a `Function` to convert a `String` to its length in a stream.
3. Use `Consumer` to print elements of a `List<String>` in a stream.
4. Write a method using `Supplier` to generate random numbers.
5. Implement a `BiFunction` to combine two strings in a stream operation.

### Item 45: Use streams judiciously
1. Rewrite a loop that sums a list of integers using a stream.
2. Convert a loop that filters even numbers to a stream operation.
3. Refactor a loop that maps strings to uppercase using a stream.
4. Use a stream to find the maximum value in a `List<Double>`.
5. Rewrite a loop that counts elements matching a condition using a stream.

### Item 46: Prefer side-effect-free functions in streams
1. Refactor a stream with a side-effecting `forEach` to use a collector.
2. Convert a stream that modifies a list in `forEach` to a side-effect-free operation.
3. Rewrite a stream that prints values in `forEach` to collect results instead.
4. Fix a stream that updates a counter in `forEach` to use a collector.
5. Refactor a stream with side effects in a mapping operation to be pure.

### Item 47: Prefer Collection to Stream as a return type
1. Refactor a method returning a `Stream<String>` to return a `List<String>`.
2. Convert a method returning a `Stream<Integer>` to return a `Set<Integer>`.
3. Rewrite a method returning a `Stream<User>` to return a `Collection<User>`.
4. Change a method returning a `Stream<Product>` to return a `List<Product>`.
5. Refactor a method returning a `Stream<Point>` to return a `Set<Point>`.

### Item 48: Use caution when making streams parallel
1. Write a stream to sum a large list of numbers and test with parallel execution.
2. Create a parallel stream to filter a large dataset and compare performance.
3. Implement a parallel stream to map a large list of strings to uppercase.
4. Test a parallel stream for sorting a large list of objects and measure performance.
5. Write a parallel stream to process a large dataset and check for thread safety.

## 8 Methods

### Item 49: Check parameters for validity
1. Add parameter validation to a `setAge(int age)` method to throw `IllegalArgumentException` for negative ages.
2. Implement a `divide(double a, double b)` method that checks for division by zero.
3. Write a `setName(String name)` method that validates non-null and non-empty names.
4. Create a `createUser(String id, String email)` method with email format validation.
5. Implement a `resizeImage(int width, int height)` method that checks for positive dimensions.

### Item 50: Make defensive copies when needed
1. Implement a `DateRange` class that makes defensive copies of `Date` objects in its constructor.
2. Create a `Person` class that defensively copies a `List<String>` of hobbies.
3. Write a `Config` class that makes defensive copies of a `Map<String, String>`.
4. Design a `Matrix` class that defensively copies a 2D array in its constructor.
5. Implement a `Team` class that defensively copies a `List<Member>`.

### Item 51: Design method signatures carefully
1. Refactor a method with too many parameters into a method using a parameter object.
2. Simplify a method with a long parameter list by using a builder pattern.
3. Rewrite a method with ambiguous parameter types to use more specific types.
4. Design a method with a clear, minimal parameter list for a `calculate` operation.
5. Refactor a method with redundant parameters to make it more concise.

### Item 52: Use overloading judiciously
1. Refactor overloaded `print` methods to use distinct names for clarity.
2. Create a `sendMessage` method with clear parameter types to avoid overloading ambiguity.
3. Rewrite overloaded `setValue` methods to use a single method with a parameter object.
4. Design a `processData` method that avoids overloading by using specific method names.
5. Refactor a class with confusing overloaded constructors to use static factory methods.

### Item 53: Use varargs judiciously
1. Write a `sum(int... numbers)` method that safely handles varargs.
2. Create a `log(String message, Object... args)` method for formatted logging.
3. Implement a `concat(String... strings)` method to concatenate strings safely.
4. Design a `addItems(Collection<T>, T... items)` method using varargs.
5. Write a `printValues(Object... values)` method to print multiple values.

### Item 54: Return empty collections or arrays, not nulls
1. Refactor a method returning `null` for an empty list to return `Collections.emptyList()`.
2. Rewrite a method returning a `null` array to return an empty array.
3. Fix a `getUsers()` method to return an empty `Set` instead of `null`.
4. Refactor a `getProperties()` method to return an empty `Map` instead of `null`.
5. Write a `getItems()` method that returns an empty `Collection` instead of `null`.

### Item 55: Return optionals judiciously
1. Rewrite a `findUser(String id)` method to return `Optional<User>` instead of `null`.
2. Implement a `getValue(String key)` method returning `Optional<String>`.
3. Refactor a `getConfig(String name)` method to return `Optional<Config>`.
4. Write a `findProduct(int id)` method that returns `Optional<Product>`.
5. Design a `getSetting(String key)` method returning `Optional<Object>`.

### Item 56: Write doc comments for all exposed API elements
1. Add Javadoc comments to a `Calculator` class’s public methods.
2. Write Javadoc for a `UserService` class’s public API methods.
3. Document a `Database` class’s public methods with Javadoc.
4. Add Javadoc to a `FileReader` class’s public methods and constructors.
5. Write Javadoc for a `PaymentProcessor` class’s exposed API elements.

## 9 General Programming

### Item 57: Minimize the scope of local variables
1. Refactor a method with a variable declared too early to declare it at first use.
2. Rewrite a loop to declare the loop variable inside the `for` loop.
3. Fix a method with a widely scoped variable to limit its scope to a block.
4. Refactor a method to declare temporary variables only within their usage block.
5. Rewrite a method to minimize the scope of a counter variable.

### Item 58: Prefer for-each loops to traditional for loops
1. Refactor a traditional `for` loop over a `List<String>` to a for-each loop.
2. Convert a traditional `for` loop over an array to a for-each loop.
3. Rewrite a `for` loop over a `Set<Integer>` to use a for-each loop.
4. Refactor a `for` loop iterating a `Map`’s entries to use a for-each loop.
5. Convert a traditional `for` loop over a `Collection` to a for-each loop.

### Item 59: Know and use the libraries
1. Replace a custom `max` method with `Collections.max`.
2. Use `String.join` instead of manual string concatenation in a loop.
3. Rewrite a custom sorting method to use `Collections.sort`.
4. Use `Files.readAllLines` instead of a custom file-reading method.
5. Replace a custom random number generator with `Random.nextInt`.

### Item 60: Avoid float and double if exact answers are required
1. Rewrite a `Money` class using `BigDecimal` instead of `double` for calculations.
2. Implement a `TaxCalculator` using `BigDecimal` for precise tax computations.
3. Refactor a `Price` class to use `BigDecimal` instead of `float`.
4. Write a `FinancialReport` class using `BigDecimal` for monetary values.
5. Design a `BillingSystem` using `BigDecimal` for accurate billing.

### Item 61: Prefer primitive types to boxed primitives
1. Refactor a `List<Integer>` to use `int` in a sum calculation.
2. Rewrite a method using `Double` to use `double` for performance.
3. Convert a `Map<Integer, String>` to use `int` keys where possible.
4. Refactor a `Counter` class to use `int` instead of `Integer`.
5. Write a `Stats` class using `double` instead of `Double` for calculations.

### Item 62: Avoid strings where other types are more appropriate
1. Refactor a `Status` class using an enum instead of a `String` for status values.
2. Convert a `Date` class using `LocalDate` instead of `String` for dates.
3. Rewrite a `Configuration` class to use `Map` instead of `String` keys.
4. Design a `Role` class using an enum instead of `String` for roles.
5. Refactor a `Key` class to use a custom type instead of `String`.

### Item 63: Beware the performance of string concatenation
1. Rewrite a loop concatenating strings to use `StringBuilder`.
2. Refactor a method building a large string to use `StringBuilder`.
3. Convert a string concatenation in a loop to use `StringJoiner`.
4. Rewrite a logging method to use `StringBuilder` for message construction.
5. Design a `ReportGenerator` to use `StringBuilder` for building reports.

### Item 64: Refer to objects by their interfaces
1. Refactor a method using `ArrayList` to use `List` as the parameter type.
2. Rewrite a method using `HashMap` to use `Map` as the return type.
3. Convert a `LinkedList` variable to use the `List` interface.
4. Refactor a `TreeSet` parameter to use `Set` in a method signature.
5. Write a method using `Collection` instead of `ArrayList` for flexibility.

### Item 65: Prefer interfaces to reflection
1. Refactor a method using reflection to call a method to use an interface.
2. Rewrite a class using reflection for object creation to use a factory interface.
3. Convert a reflection-based method invocation to use an interface method.
4. Design a `Plugin` system using an interface instead of reflection.
5. Refactor a configuration loader to use an interface instead of reflection.

### Item 66: Use native methods judiciously
1. Rewrite a method using a native method to use a Java implementation.
2. Refactor a class with native methods to use a Java library instead.
3. Design a `MathUtils` class without native methods for portability.
4. Convert a native method for file access to use Java’s `Files` API.
5. Rewrite a performance-critical native method to use Java optimizations.

### Item 67: Optimize judiciously
1. Profile a method and optimize only the bottleneck using a better algorithm.
2. Refactor a slow loop to use a more efficient data structure.
3. Optimize a sorting method to use `Collections.sort` instead of a custom sort.
4. Improve a search method by using a `HashMap` instead of a linear search.
5. Refactor a method to reduce object creation for better performance.

### Item 68: Adhere to generally accepted naming conventions
1. Refactor a class with non-standard names (e.g., `myclass`) to follow Java conventions.
2. Rename variables in a method to use camelCase instead of underscores.
3. Fix a class with inconsistent method names to follow Java naming conventions.
4. Refactor a package name to use lowercase and follow Java conventions.
5. Rewrite a class to use standard naming for constants (e.g., `MAX_VALUE`).

## 10 Exceptions

### Item 69: Use exceptions only for exceptional conditions
1. Refactor a method using exceptions for flow control to use return values.
2. Rewrite a `findUser` method to return `Optional` instead of throwing an exception.
3. Convert a method throwing exceptions for normal cases to use conditionals.
4. Design a `Parser` class to handle errors without exceptions.
5. Refactor a `Validator` class to return boolean instead of throwing exceptions.

### Item 70: Use checked exceptions for recoverable conditions and runtime exceptions for programming errors
1. Create a `FileReader` class using checked exceptions for file errors.
2. Implement a `Calculator` class throwing runtime exceptions for invalid inputs.
3. Design a `NetworkClient` class with checked exceptions for network failures.
4. Write a `Parser` class throwing runtime exceptions for syntax errors.
5. Refactor a class to use checked exceptions for recoverable I/O errors.

### Item 71: Avoid unnecessary use of checked exceptions
1. Refactor a method throwing a checked exception to return `Optional`.
2. Convert a checked exception in a `FileProcessor` to a runtime exception.
3. Rewrite a `Database` class to avoid checked exceptions for simple queries.
4. Design a `ConfigLoader` to handle errors without checked exceptions.
5. Refactor a `NetworkRequest` class to minimize checked exception usage.

### Item 72: Favor the use of standard exceptions
1. Refactor a custom `InvalidInputException` to use `IllegalArgumentException`.
2. Replace a custom `NotFoundException` with `NoSuchElementException`.
3. Convert a custom `ErrorException` to use `IllegalStateException`.
4. Rewrite a method to throw `UnsupportedOperationException` instead of a custom exception.
5. Design a class to use `NullPointerException` instead of a custom null exception.

### Item 73: Throw exceptions appropriate to the abstraction
1. Refactor a `FileReader` class to throw a high-level `FileAccessException` instead of `IOException`.
2. Design a `Database` class to throw `DatabaseException` instead of low-level exceptions.
3. Rewrite a `NetworkClient` to throw `NetworkException` for connection issues.
4. Implement a `Parser` class to throw `ParseException` instead of generic exceptions.
5. Refactor a `PaymentProcessor` to throw `PaymentException` for payment errors.

### Item 74: Document all exceptions thrown by each method
1. Add Javadoc to a `FileReader` class documenting all thrown exceptions.
2. Document exceptions in a `Database` class’s Javadoc for public methods.
3. Write Javadoc for a `NetworkClient` class, listing all possible exceptions.
4. Add exception documentation to a `Parser` class’s public methods.
5. Document exceptions in a `PaymentProcessor` class’s Javadoc.

### Item 75: Include failure-capture information in detail messages
1. Refactor a `FileReader` to include the file path in exception messages.
2. Add details to a `DatabaseException` to include the query causing the error.
3. Rewrite a `NetworkException` to include the server address in the message.
4. Include input details in a `ParseException` message for better debugging.
5. Add context to a `PaymentException` message, including the transaction ID.

### Item 76: Strive for failure atomicity
1. Refactor a `BankAccount` class to ensure failure atomicity for transfers.
2. Design a `ListUpdater` class to maintain state consistency on failure.
3. Implement a `DatabaseUpdater` class to rollback changes on error.
4. Write a `FileWriter` class to ensure atomicity for file operations.
5. Create a `QueueManager` class that maintains state on operation failure.

### Item 77: Don’t ignore exceptions
1. Refactor a method that ignores an `IOException` to handle it properly.
2. Fix a `Database` class that ignores a `SQLException` to log or rethrow it.
3. Rewrite a `NetworkClient` to handle ignored `IOException` appropriately.
4. Convert a method ignoring a `ParseException` to handle it with logging.
5. Refactor a `FileProcessor` to handle all exceptions instead of ignoring them.

## 11 Concurrency

### Item 78: Synchronize access to shared mutable data
1. Add synchronization to a `Counter` class to ensure thread-safe increments.
2. Implement a `SharedList` class with synchronized methods for thread safety.
3. Refactor a `Cache` class to synchronize access to its `Map`.
4. Design a `Logger` class with synchronized logging for thread safety.
5. Write a `ResourcePool` class with synchronized resource allocation.

### Item 79: Avoid excessive synchronization
1. Refactor a `Counter` class to reduce synchronization using `AtomicInteger`.
2. Rewrite a `SharedList` class to use `CopyOnWriteArrayList` instead of synchronized blocks.
3. Convert a synchronized `Cache` class to use `ConcurrentHashMap`.
4. Design a `Logger` class to minimize synchronization with a thread-safe queue.
5. Refactor a `ResourcePool` to use `ConcurrentLinkedQueue` for less synchronization.

### Item 80: Prefer executors, tasks, and streams to threads
1. Refactor a `Thread` creation to use an `ExecutorService` for task execution.
2. Convert a `Runnable` in a `Thread` to a task submitted to an `Executor`.
3. Implement a `TaskManager` using `ExecutorService` for task scheduling.
4. Rewrite a `Worker` class to use `CompletableFuture` instead of threads.
5. Design a `Processor` class using `ExecutorService` for parallel tasks.

### Item 81: Prefer concurrency utilities to wait and notify
1. Refactor a `ProducerConsumer` class to use `BlockingQueue` instead of `wait/notify`.
2. Convert a `Semaphore` class using `wait/notify` to use `java.util.concurrent.Semaphore`.
3. Rewrite a `ThreadPool` class to use `ExecutorService` instead of `wait/notify`.
4. Implement a `Barrier` class using `CyclicBarrier` instead of `wait/notify`.
5. Design a `TaskQueue` using `ConcurrentLinkedQueue` instead of `wait/notify`.

### Item 82: Document thread safety
1. Add Javadoc to a `Counter` class documenting its thread-safe behavior.
2. Document a `SharedList` class’s thread safety in its Javadoc.
3. Write Javadoc for a `Cache` class, specifying its concurrency guarantees.
4. Add thread-safety documentation to a `Logger` class’s Javadoc.
5. Document a `ResourcePool` class’s thread safety in its public API.

### Item 83: Use lazy initialization judiciously
1. Implement a `Config` class with lazy initialization for a resource-intensive field.
2. Refactor a `DatabaseConnection` class to use lazy initialization for connections.
3. Write a `Cache` class with lazy initialization for its internal map.
4. Design a `Logger` class with lazy initialization for its output stream.
5. Implement a `Settings` class with thread-safe lazy initialization.

### Item 84: Don’t depend on the thread scheduler
1. Refactor a `TaskRunner` class to avoid relying on thread priorities.
2. Rewrite a `Worker` class to use an `Executor` instead of thread scheduling.
3. Design a `Processor` class that avoids thread scheduler dependencies.
4. Convert a `Scheduler` class to use `ScheduledExecutorService`.
5. Implement a `TaskManager` class that uses a queue instead of scheduler reliance.

## 12 Serialization

### Item 85: Prefer alternatives to Java serialization
1. Refactor a `User` class to use JSON serialization instead of Java serialization.
2. Convert a `Config` class to use XML serialization instead of `Serializable`.
3. Rewrite a `Data` class to use a custom serialization format.
4. Implement a `Message` class using Protobuf instead of Java serialization.
5. Design a `State` class to use a database instead of serialization.

### Item 86: Implement Serializable with great caution
1. Implement a `User` class with `Serializable` and proper field validation.
2. Write a `Config` class with `Serializable` and careful state management.
3. Refactor a `Data` class to implement `Serializable` with transient fields.
4. Design a `Message` class with `Serializable` and secure field handling.
5. Create a `State` class with `Serializable` and defensive copying.

### Item 87: Consider using a custom serialized form
1. Implement a `Point` class with a custom `writeObject` and `readObject` for serialization.
2. Write a `User` class with a custom serialized form for specific fields.
3. Design a `Config` class with a custom serialized form to exclude sensitive data.
4. Refactor a `Message` class to use a custom serialized form for efficiency.
5. Create a `Data` class with a custom serialized form for versioning.

### Item 88: Write readObject methods defensively
1. Implement a `User` class with a defensive `readObject` method to validate fields.
2. Write a `Config` class with a `readObject` method to check invariants.
3. Refactor a `Data` class to include a defensive `readObject` method.
4. Design a `Message` class with a `readObject` method to prevent invalid states.
5. Create a `State` class with a `readObject` method to ensure security.

### Item 89: For instance control, prefer enum types to readResolve
1. Refactor a `Singleton` class to use an enum instead of `readResolve`.
2. Convert a `Status` class to an enum to ensure instance control during serialization.
3. Rewrite a `Type` class as an enum to avoid `readResolve` issues.
4. Design a `Role` class as an enum for serialization safety.
5. Implement a `Category` enum to handle serialization without `readResolve`.

### Item 90: Consider serialization proxies instead of serialized instances
1. Implement a `User` class with a serialization proxy to control serialized data.
2. Write a `Config` class using a serialization proxy for secure serialization.
3. Refactor a `Data` class to use a serialization proxy instead of direct serialization.
4. Design a `Message` class with a serialization proxy to simplify serialization.
5. Create a `State` class with a serialization proxy to ensure immutability.