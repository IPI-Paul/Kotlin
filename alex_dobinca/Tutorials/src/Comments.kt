
class Comments {
  fun getComments(): MutableList<String> {
    var comments: MutableList<String> = mutableListOf()
    comments.add("""
      * HelloWorld
      * Prints out Hello, World.
    """)
    comments.add("""
      * Variables
      * [userName] immutable type specific String.
      * [age] immutable type specific integer.
    """)
    comments.add("""
      * ByteShortIntLong:
      * [number] immutable type specific integer.
      * [maxIntegerValue] immutable type specific integer.
      * [minIntegerValue] immutable type specific integer.
      * Prints values.
      * [tooBig] immutable type specific integer assigned [maxIntegerValue] + 1.
      * [myMaxByteValue] immutable type specific Byte.
      * [myMinByteValue] immutable type specific Byte.
      * [myMaxShortValue] immutable type specific Short.
      * [myMinShortValue] immutable type specific Short.
      * [myMaxLongValue] immutable type specific Long.
      * [myMinLongValue] immutable type specific Long.
      * [intNumber] immutable inferred Int.
      * [longNumber] immutable Long implied by adding L after value assigned.
      * [floatNumber] immutable Float implied by adding F after value assigned.
    """)
    comments.add("""
      * FloatAndDouble:
      * [myFloat] immutable Float specified by appending f or F to the value.
      * [myDouble] immutable inferred Double.
    """)
    comments.add("""
      * CharAndBoolean:
      * [myCharValue] immutable type specific Char.
      * [myBooleanValue] immutable type specific Boolean.
    """)
    comments.add("""
      * Operators:
      * [x] mutable inferred Int.
      * [y] immutable inferred Int.
      * [result] mutable inferred Int from the sum of operands [x] and [y].
      * Prints [result] and uses place holder to print the following operations on [x] and [y]: + - * / %.
      * Shows end of line and block comments.
    """)
    comments.add("""
      * If then else:
      * [isActive] immutable inferred Boolean.
      * [myNumber] immutable inferred Int.
      * [isPlaying] immuable inferred Boolean.
      * [score] immutable inferred Int.
      * [num1] immutable inferred Int.
      * [num2] immutable inferred Int.
      * [text] immutable inferred String from result of if then expression.
      * [text1] immutable inferred String from result of if then expression.
    """)
    comments.add("""
      * ControlFlow:
      * [alarm] immutable inferred Int.
      * Uses when statement to determine outputs.
      * [text] immutable inferred String from when statement.
      * [text1] immutable inferred String from when statement.
      * [text2] immutable inferred String from when statement.
    """)
    comments.add("""
      * Null:
      * [text] immutable type specific String assigned null.
      * Uses ? to accept existence of a null and avoid throwing an exception and !! to throw an exception.
      * [text2] immutable inferred String populated using Elvis method ?: .
    """)
    comments.add("""
      * Funcions:
      * [sayHello] functions with and without parameters. Parameters are immutable and type specific.
      * [getData] function with parameter [data] .
      * [showMessage] function without parameters.
      * [hasInternetConnection] immutable inferred Boolean used in if else to call either of two functions.
      * [getMax] function has two integer parameters and returns the max of both.
      * [max] immutable inferred Int derived from [getMax] result.
      * [getMax1] and [getMax2] more concise functions of [getMax].
      * Uses function overloading on [getMax].
      * [sendMessage] function whose parameters have default values.
      * [sendMessage1] function whose parameters have default values and also uses another function to return a default value.
      * [sum], [sum1] and [sum2] functions with a vararg @param [numbers] as type specific Int and sums up all passed entries.
    """)
    comments.add("""
      * Loops:
      * Uses for loops to iterate over ranges in both directions.
      * [number] muable inferred Int.
      * Uses while loop to check and increment value of [number].
      * Uses do while loop to check and increment value of [number].
      * Uses continue and break in while and for loops.
      * Breaks from a labelled loop.
      * [lastNumber] immutable inferred Int.
      * [evenNumberCounter] mutable inferred Int.
      * [isEvenNumber] function that returns a Boolean from the modulus of 2.
      * Uses while and for loops to iterate between [number] and [lastNumber] outputing even numbers.
    """)
    comments.add("""
      * Arrays:
      * [names] immutable type specific Array of Stings.
      * [names] immutable inferred Array of Stings.
      * [mixedArray] immutable inferred mixed Array.
      * Uses for loops top iterate through arrays and the is keyword to check value types.
      * [IntRange.toIntArray] function to convert IntRange to IntArray.
      * [numbers] immutable Int Array.
      * [minNumbers] function using reduce to return minimum value of IntArray.
      * [maxNumbers] function using reduce to return maximum value of IntArray.
      * [minMaxNumbers] function using reduce to return either minimum or maximum value of IntArray.
      * [findMax] function to iterate through an Array<Int> and return the maximum value.
      * [findMin] function to iterate through an Array<Int> and return the minimum value.
      * [findMinAndMax] function to iterate through an Array<Int> and return the minimum or maximum value.
    """)
    comments.add("""
      * Object Oriented Programming - Class State & Function:
      * [Car] class with properties name, model, colour and doors and functions move and stop.
      * [car1] and [car2] immutable inferred objects of the [Car] class.
    """)
    comments.add("""
      * Object Oriented Programming - Class State & Function:
      * [Car] class constructor with parameters name, model, colour and doors and functions move and stop.
      * [car] and [car] immutable inferred objects of the [Car] class.
    """)
    comments.add("""
      * Object Oriented Programming - Class Constructors:
      * [Car] class constructor with parameters set as properties name, model, colour and doors and functions move and stop.
      * [car] and [car1] immutable inferred objects of the [Car] class.
    """)
    comments.add("""
      * Object Oriented Programming - Class Constructors & Properties:
      * [Car] class constructor with parameters name, model, colour and doors  set as properties except name and functions move and stop.
      * [car] and [car1] immutable inferred objects of the [Car] class.
    """)
    comments.add("""
      * Object Oriented Programming - Class Validation with Initialiser Blocks:
      * [User] class with primary constructor.
      * [user] and [friend] mutable derived objects from [User].
    """)
    comments.add("""
      * Object Oriented Programming - Class Secondary Constructors:
      * [User] class with primary and secondary constructors.
      * [user] and [friend] mutable derived objects from [User].
    """)
    comments.add("""
      * Object Oriented Programming - Class Properties Default Values:
      * [User] class with primary constructor and default values.
      * [user], [user1] and [friend] mutable derived objects from [User].
    """)
    comments.add("""
      * Object Oriented Programming - Class Getters & Setters:
      * [User] class with primary constructor, default values and overidden getter and setter.
      * [user] and [friend] mutable derived objects from [User].
    """)
    comments.add("""
      * Object Oriented Programming - lateinit:
      * [User] class with primary constructor, default values and lateinit variable.
      * [user] mutable derived objects from [User].
    """)
    comments.add("""
      * Object Oriented Programming - Class Functions:
      * [Calculator] class with [sum] function.
      * [calculator] immutable object derived from [Calculator].
      * [result] immutable variable derived from calling the [sum] function of [calculator].
    """)
    comments.add("""
      * Object Oriented Programming - Companion Objects:
      * [Calculator] class with [sum] function inside a companion object.
      * [result] immutable variable derived from calling the [sum] function of [Calculator].
    """)
    comments.add("""
      * Object Oriented Programming - Instances:
      * [Database] class with private constructor and companion object.
      * [instance] and [instance2] objects derived from calling [getInstance] of [Database]
    """)
    comments.add("""
      * Object Oriented Programming - Singletons:
      * [Database] singleton object.
    """)
    comments.add("""
      * Object Oriented Programming - Lazy Loading:
      * [User] class with primary constructor.
      * [user] immutable derived object from [User].
      * [user1] immutable derived object from [User] using lazy loading.
    """)
    comments.add("""
      * Object Oriented Programming - Enum Classes:
      * [Direction] enum class with 4 Objects.
    """)
    comments.add("""
      * Object Oriented Programming - Enum Classes with Constructors:
      * [Direction1] enum class with 4 Objects and a function.
      * [direction] and [direction1] immutable objects derived from [Direction1]
    """)
    comments.add("""
      * Object Oriented Programming - Inner Classes:
      * [ListView] class with primary constructor and inner class.
      * [ListViewItem] inner class with function [displayItem].
      * [listView] immutable object derived from [ListView].
    """)
    comments.add("""
      * Object Oriented Programming - Access Modifiers:
      * [Account] class with primary and secondary constructors and 3 functions [deposit], [withdraw] and [calculateBalance].
      * [alexAccount] immutable object derived from [Account].
    """)
    comments.add("""
      * Object Oriented Programming - Class Inheritance:
      * [Vehicle] class with primary constructors and two functions [move] and [stop]. 
      * Uses the open keyword to allow the class to be inherited and uses the open keyword to allow the functions to be overriden.
      * [Car] and [Plane] classes with primary constructors that inherit from [Vehicle].
      * [Plane] overrides the [move] function.
      * [car] and [plane] immutable objects derived from [Car] and [Plane] respectively.
    """)
    comments.add("""
      * Object Oriented Programming - Class Inheritance:
      * [View] open class with an open function [Draw].
      * [Button] class that inherits from [View] and overrides [draw].
      * [RoundButton] class that inherits from [Button] and overrides [draw].
    """)
    comments.add("""
      * Object Oriented Programming - Sealed Classes:
      * [Result] enum class with two fixed objects [SUCCESS] and [ERROR].
      * [Result1] sealed classes with three internal classes [Success], [Error] and [Progress] and a function [showMessage].
      * [getData] function that takes a variable of type [Result1] and uses a when statement to render conditions.
      * [success], [error] and [progress] immutable objects derived from initiating [Result1] objects with messages.
    """)
    comments.add("""
      * Object Oriented Programming - Sealed Classes with inner Sealed Class:
      * [Result2] sealed classes with three internal classes [Success], [Error] and [Progress] and a function [showMessage].
      * [getData] function that takes a variable of type [Result2] and uses a when statement to render conditions.
      * [success] and [progress] immutable objects derived from initiating [Result2] objects with messages.
    """)
    comments.add("""
      * Object Oriented Programming - Abstract Classes:
      * [Vehicle] abstract class with one intiated property [text] and two abstract functions [move] and [stop].
      * [Car] class that inherits from [Vehicle] and overrides it's two functions.
    """)
    comments.add("""
      * Object Oriented Programming - Data Classes:
      * [name1] and [name2] immutable inferred Strings.
      * First uses structural eqaulity (==) to check if [name1] is equal to [name2].
      * Then uses referential eqaulity (===) to check if [name1] is equal to [name2].
      * [User] class that inherits the Any class equality operator.
      * [user1] and [user2] immutable objects derived from [User].
      * [User1] class that overrides the Any class equality, hashCode and toString functions.
      * [user3] and [user4] immutable objects derived from [User1].
      * Using the keyword [data] infront of the [class] keyword autogenerates code for equality, hashCode and toString functions.
      * [User2] data class.
      * [user5] and [user6] immutable objects derived from [User2].
      * [User3] data class.
      * [user7] and [user8] immutable objects derived from [User3].
    """)
    comments.add("""
      * Object Oriented Programming - Interfaces:
      * [Engine] interface.
      * [Car], [Truck], [Plane] and [Tesla] classes that implement [Engine].
    """)
    comments.add("""
      * Object Oriented Programming - Object Expression(Anonymous Class): 
      * [Button] class with the Interface [OnClickListener] as one of its property types.
      * [ClickListener] class that implements th interface [OnClickListener].
      * [clickListener] immutable derived from [ClickListener].
      * [loginButton] immutable derived from [Button] using [clickListener].
      * [loginButton1] and [signUpButton] immutables derived from [Button] using Object Expressions of [ClickListener].
    """)
    comments.add("""
      * Object Oriented Programming - Delegation:
      * [FirstDelegate] open class with function [print].
      * [SecondDelegate] open class with function [print2].
      * [App] class delegates A by FirstDelegate(), B by SecondDelegate() and overrides their functions.
      * [FormatDelegate] class that inherits from [ReadWriteProperty] and overrides its [getValue] and [setValue] functions.
      * [User] class the delegates its two @property [firstName] and [lastName] by FormatDelegate].
      * [user] mutable object derived from [User].
    """)
    comments.add("""
      * Collections - List:
      * [names] immutable list of type specified String.
      * [names1] mutable list of inferred type String.
    """)
    comments.add("""
      * Collections - Set:
      * [names] immutable type specified container derived from setOf<String>().
      * [names1] mutable type inferred container derived from mutableSetOf().
      * [User] class with String @property [name].
      * [user1], [user2], [user3], [user4], [user5], [user6] and [user7] immutable objects derived from [User].
      * [names2] mutable type specific container derived from mutableSetOf<User>().
      * [User1] data class with String @property [name].
      * [user8], [user9], [user10], [user11], [user12], [user13] and [user14] immutable objects derived from [User1].
      * [names3] mutable type specific container derived from mutableSetOf<User1>().
    """)
    comments.add("""
      * Collections - Map:
      * [users] immutable type specific container derived from mapOf<Int, String>().
      * [users1] mutable type specific container derived from mutableMapOf<Int, String>().
    """)
    comments.add("""
      * Collections Operations - Map Transformations:
      * [numbers] and [numbers1] immutable type inferred containers derived from setOf() and altered using .map {} and .mapIndexedNotNull {}.
      * [numbersMap] immutable map altered using .mapKeys {} and .mapValues {}.
    """)
    comments.add("""
      * Collections Operations - Zip Transformations:
      * [colours] and [animals] immutable type inferred lists of strings.
      * [numberPairs] immutable type inferred list of pairs.
    """)
    comments.add("""
      * Collections Operations - Association Transformations:
      * [numbers] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collections Operations - Flatten Transformations:
      * [numberSets] immutable type inferred list of lists.
      * [numbersFlatten] immutable type inferred list derived by using the .flatten() on [numberSets].
      * [numberSets1] immutable type inferred array of arrays.
    """)
    comments.add("""
      * Collections Operations - String Representation:
      * [numbersStrings] immutable type inferred list of strings.
      * [listString] immutable type inferred string buffer.
      * [numbers] immutable type inferred list of integers.
    """)
    comments.add("""
      * Collections Operations - Filtering:
      * [numbers] immutable type inferred list of strings.
      * [longerThan3] immutable type inferred list derived from .filter().
      * [numbersMap] immutable type inferred map of integers.
      * [filteredMap] immutable type inferred map derived from .filter().
      * [filteredIndex] immutable type inferred list derived from .filterIndexed().
      * [filteredNot] immutable type inferred list derived from .filteredNot().
      * [mixedList] immutable list of mixed types.
    """)
    comments.add("""
      * Collections Operations - Partition:
      * [numbers] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collections Operations - Predicates:
      * [numbers] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collections Operations - Plus & Minus Operators:
      * [numbers] mutable type inferred list of strings.
    """)
    comments.add("""
      * Grouping:
      * [numbers] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collection Parts - Slice, Take and Drop:
      * [numbers] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collection Parts using Predicates - takeWhile, takeLastWhile, dropWhile, dropLastWhile:
      * [numbers] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collection Parts - chunked and windowed:
      * [numbers] immutable type inferred list of integers.
      * [numbersStrings] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collections - Retrieve Single Elements:
      * [numbers] immutable type inferred list of strings.
    """)
    comments.add("""
      * Collections - Aggregation:
      * [numbers] immutable type inferred list of integers.
    """)
    comments.add("""
      * Collections - Comparable Ordering:
      * [numbers] mutable type inferred list of integers.
    """)
    comments.add("""
      * Collections - Linear Search:
      * [searchElement] function that uses a for loop to do a linear search of a mutable list of integers.
    """)
    comments.add("""
      * Collections - Binary Search:
      * Only works with ordered lists.
      * [searchElement] function that uses a for loop to do a linear search of a mutable list of integers.
    """)
    comments.add("""
      * Generics:
      * Only a compile time feature, does not make it to runtime.
      * [Player] open class with constructor.
      * [Team] class with constructor that takes a generic type.
      * [FootballPlayer] and [BaseballPlayer] classes with constructors that inherit from [Player].
      * [footballTeam] and [baseballTeam] type spefic objects derived from [Team].
    """)
    comments.add("""
      * Generics - Upperbounds:
      * No need to cast the generic type.
      * [Player] open class with constructor.
      * [Team] class with constructor that takes a generic type with upper bounds.
      * [FootballPlayer] and [BaseballPlayer] classes with constructors that inherit from [Player].
      * [footballTeam] and [baseballTeam] type inferred objects derived from [Team].
    """)
    return comments
  }
  fun showComment(idx: Int) {
    val comments = getComments()
    if (comments.size > idx) {
      println(comments[idx])
    } else {
      println("\n")
    }
  }
  fun showList() {
    var comments = getComments()
    var i = 1
    comments.forEach { x -> run {
        print("exercise${i.toString().padStart(3, '0')}")
        println(x)
        i += 1
      } 
    }
  }
}