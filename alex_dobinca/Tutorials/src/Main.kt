import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.collections.reduce
import kotlin.properties.ReadWriteProperty
import Engine
import OnClickListener
import java.awt.Button

fun main(args: Array<String>) {
  var readText = " "
  var idx: Int = 999
  val exerciseObj = Exercises()
  val comments = Comments()
  val count = exerciseObj::class.java.methods.filter { it.name.take(9) == "exercise0" }.size
  fun runExercise() {
    print("Now running: $readText")
    (comments::showComment)(idx)
    val func = exerciseObj::class.java.getMethod(readText)
    func.invoke(exerciseObj)
    println("")
  }
  if (args.size != 0 && args[0] != "h" && args[0] != "l" && args[0].toInt() in 1..count) {
    readText = "exercise${args[0].toString().padStart(3, '0')}"
    idx = args[0].toInt() - 1
    runExercise()
  } else if (args.size != 0 && args[0] == "h") {
    (comments::showList)()
  } else if (args.size != 0 && args[0] == "l") {
    readText = "exercise${count.toString().padStart(3, '0')}"
    idx = count - 1
    runExercise()
  } else {
    while (readText != "q" && readText > "") {
      print("Please enter a number from 1 to $count to view exercise output or either one of (h)elp, (l)ast or (q)uit: ")
      val console = System.console().readLine()
      if (console == "h") {
        (comments::showList)()
        continue
      }
      if (console == "q") break
      if (console == "l") {
        readText = "exercise${count.toString().padStart(3, '0')}"
        idx = count - 1
      } else if (console.length > 0) {
        readText = "exercise${console.toString().padStart(3, '0')}"
        idx = console.toInt() - 1
      }
      runExercise()
    }
  }
}

class Exercises {

  /** 
   * Generics - Upperbounds:
   * No need to cast the generic type.
   * [Player] open class with constructor.
   * [Team] class with constructor that takes a generic type with upper bounds.
   * [FootballPlayer] and [BaseballPlayer] classes with constructors that inherit from [Player].
   * [footballTeam] and [baseballTeam] type inferred objects derived from [Team].
  */
  fun exercise062() {
    open class Player(val name: String)

    class Team<T: Player>(val name: String, val players: MutableList<T>) {
      fun addPlayers(player: T) {
        if (players.contains(player)) {
          println("Player: ${player.name} is already in the team ${this.name}")
        } else {
          players.add(player)
          println("Player: ${player.name} was added to team ${this.name}")
        }
      }
    }

    class FootballPlayer(name: String): Player(name)
    class BaseballPlayer(name: String): Player(name)
    class GamesPlayer(name: String): Player(name)

    val footballPlayer = FootballPlayer("Football player 1")
    val footballPlayer2 = FootballPlayer("Football player 2")

    val baseballPlayer = BaseballPlayer("Baseball player 1")
    val baseballPlayer2 = BaseballPlayer("Baseball player 2")

    val footballTeam = Team("Football Team", mutableListOf(footballPlayer))
    footballTeam.addPlayers(footballPlayer2)

    val baseballTeam = Team("Baseball Team", mutableListOf(baseballPlayer))
    baseballTeam.addPlayers(baseballPlayer)
    baseballTeam.addPlayers(baseballPlayer2)

    val gamesPlayer = GamesPlayer("Games player 1")
    val gamesTeam = Team("Games Team", mutableListOf(gamesPlayer))
    gamesTeam.addPlayers(gamesPlayer)
  }

  /** 
   * Generics:
   * Only a compile time feature, does not make it to runtime.
   * [Player] open class with constructor.
   * [Team] class with constructor that takes a generic type.
   * [FootballPlayer] and [BaseballPlayer] classes with constructors that inherit from [Player].
   * [footballTeam] and [baseballTeam] type spefic objects derived from [Team].
  */
  fun exercise061() {
    open class Player(val name: String)

    class Team<T>(val name: String, val players: MutableList<T>) {
      fun addPlayers(player: T) {
        if (players.contains(player)) {
          println("Player: ${(player as Player).name} is already in the team ${this.name}")
        } else {
          players.add(player)
          println("Player: ${(player as Player).name} was added to team ${this.name}")
        }
      }
    }

    class FootballPlayer(name: String): Player(name)
    class BaseballPlayer(name: String): Player(name)

    val footballPlayer = FootballPlayer("Football player 1")
    val footballPlayer2 = FootballPlayer("Football player 2")

    val baseballPlayer = BaseballPlayer("Baseball player 1")
    val baseballPlayer2 = BaseballPlayer("Baseball player 2")

    val footballTeam = Team<FootballPlayer>("Football Team", mutableListOf(footballPlayer))
    footballTeam.addPlayers(footballPlayer2)

    val baseballTeam = Team<BaseballPlayer>("Baseball Team", mutableListOf(baseballPlayer))
    baseballTeam.addPlayers(baseballPlayer)
    baseballTeam.addPlayers(baseballPlayer2)
  }

  /** 
   * Collections - Binary Search:
   * Only works with ordered lists.
   * [searchElement] function that uses a for loop to do a linear search of a mutable list of integers.
  */
  fun exercise060() {
    fun searchElement(searchedElement: Int, numbers: MutableList<Int>): Int {
      var low = 0
      var high = numbers.size - 1
      var i = 0

      while (low <= high) {
        val mid = (low + high) / 2
        println("Searched number: ${numbers[mid]}")
        val cmp = numbers[mid].compareTo(searchedElement)

        if (cmp < 0) {
          low = mid + 1
        } else if (cmp > 0) {
          low = mid - 1
        } else {
          return numbers[mid]
        }
      }
      return -1
    }
    println(searchElement(27, (1..30).toMutableList()))

    fun searchElementInBuilt(searchedElement: Int, numbers: MutableList<Int>) = numbers[numbers.binarySearch(searchedElement)]
    println(searchElementInBuilt(27, (1..30).toMutableList()))

  }

  /** 
   * Collections - Linear Search:
   * [searchElement] function that uses a for loop to do a linear search of a mutable list of integers.
  */
  fun exercise059() {
    fun searchElement(searchedElement: Int, numbers: MutableList<Int>): Int {
      var i = 0
      for (number in numbers) {
        i++
        println("Searched number: $i")
        if (number == searchedElement) {
          return number
        }
      }
      return -1
    }
    println(searchElement(27, (1..30).toMutableList()))
  }

  /** 
   * Collections - Comparable Ordering:
   * [numbers] mutable type inferred list of integers.
  */
  fun exercise058() {
    val numbers = mutableListOf(2, 5, 1, 40, 20, 100, 60)
    numbers.sorted().forEach { println(it) }

    data class Laptop(val brand: String, val year: Int, val ram: Int, val price: Int) : Comparable<Laptop> {
      override fun compareTo(other: Laptop): Int {
        return if (this.price > other.price) {
          println("In if statement: Swapping ${this.brand} with ${other.brand}")
          1
        } else if (this.price < other.price) {
          println("In if statement: Swapping ${this.brand} with ${other.brand}")
          -1
        } else {
          0
        }
      }
    }
    val laptops = mutableListOf(
      Laptop("Dell", 2021, 4, 600),
      Laptop("Apple", 2022, 16, 1000),
      Laptop("Acer", 2020, 8, 800)
    )
    laptops.sorted().forEach { println(it) }

    class ComparatorRam: Comparator<Laptop> {
      override fun compare(laptop1: Laptop, laptop2: Laptop): Int {
        return if (laptop1.ram > laptop2.ram) {
          1
        } else if (laptop1.ram < laptop2.ram) {
          -1
        } else {
          0
        }
      }
    }
    println("")
    laptops.sortedWith(ComparatorRam()).forEach { println(it) }

    class ComparatorYear: Comparator<Laptop> {
      override fun compare(laptop1: Laptop, laptop2: Laptop): Int {
        return if (laptop1.year > laptop2.year) {
          1
        } else if (laptop1.year < laptop2.year) {
          -1
        } else {
          0
        }
      }
    }
    println("")
    laptops.sortedWith(ComparatorYear()).forEach { println(it) }

    println("")
    laptops.sortedWith(compareBy { it.price }).forEach { println(it) }
    println("")
    laptops.sortedWith(compareBy { it.ram }).forEach { println(it) }
    println("")
    laptops.sortedWith(compareBy { it.brand }).forEach { println(it) }
    println("")
    laptops.sortedWith(compareBy<Laptop> { it.brand }.thenBy { it.price }).forEach { println(it) }

    println("")
    laptops.sortedBy { it.price }.forEach { println(it) }
    println("")
    laptops.sortedBy { it.ram }.forEach { println(it) }
  }

  /** 
   * Collections - Aggregation:
   * [numbers] immutable type inferred list of integers.
  */
  fun exercise057() {
    val numbers = listOf(6, 10, 14, 4, 100)
    println("The sum is: ${numbers.sum()}")
    println("The count is: ${numbers.count()}")
    println("The average is: ${numbers.average()}")
    println("The max value is: ${numbers.maxOrNull()}")
    println("The min value is: ${numbers.minOrNull()}")
    println("")
    println("The sum is: ${numbers.sumOf { it * 2 }}")
  }

  /** 
   * Collections - Retrieve Single Elements:
   * [numbers] immutable type inferred list of strings.
  */
  fun exercise056() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.elementAt(3))
    println(numbers.first())
    println(numbers.last())
    println("")
    println(numbers.first { it.length > 3 })
    println(numbers.last { it.startsWith("f") })
    println(numbers.random())
    println(numbers.isEmpty())
  }

  /** 
   * Collection Parts - chunked and windowed:
   * [numbers] immutable type inferred list of integers.
   * [numbersStrings] immutable type inferred list of strings.
  */
  fun exercise055() {
    val numbers = (0..13).toList()
    println(numbers.chunked(3))
    println(numbers.chunked(3) { it.sum() })

    val numbersStrings = listOf("one", "two", "three", "four", "five", "six")
    println("")
    println(numbersStrings.windowed(3))
  }

  /** 
   * Collection Parts using Predicates - takeWhile, takeLastWhile, dropWhile, dropLastWhile:
   * [numbers] immutable type inferred list of strings.
  */
  fun exercise054() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.takeWhile { !it.startsWith("f") })
    println(numbers.takeLastWhile { it != "three"})
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains("i")})
  }

  /** 
   * Collection Parts - slice, take and drop:
   * [numbers] immutable type inferred list of strings.
  */
  fun exercise053() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3, 5, 0)))

    println("")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))
  }
  
  /** 
   * Grouping:
   * [numbers] immutable type inferred list of strings.
  */
  fun exercise052() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.groupBy { it.first().uppercase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() }))
  }

  /** 
   * Collections Operations - Plus & Minus Operators:
   * [numbers] mutable type inferred list of strings.
  */
  fun exercise051() {
    val numbers = mutableListOf("one", "two", "three", "four")
    val plusList = numbers + "five"
    val minusList = numbers - mutableListOf("three", "four")
    println(plusList)
    println(minusList)
  }

  /** 
   * Collections Operations - Predicates:
   * [numbers] immutable type inferred list of strings.
  */
  fun exercise050() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.any { it.endsWith("e") })
    println(numbers.none { it.endsWith("w") })
    println(numbers.all { it.length > 1 })
  }

  /** 
   * Collections Operations - Partition:
   * [numbers] immutable type inferred list of strings.
  */
  fun exercise049() {
    val numbers = listOf("one", "two", "three", "four")
    val (match, rest) = numbers.partition { it.length > 3 }
    println(match)
    println(rest)
  }

  /** 
   * Collections Operations - Filtering:
   * [numbers] immutable type inferred list of strings.
   * [longerThan3] immutable type inferred list derived from .filter().
   * [numbersMap] immutable type inferred map of integers.
   * [filteredMap] immutable type inferred map derived from .filter().
   * [filteredIndex] immutable type inferred list derived from .filterIndexed().
   * [filteredNot] immutable type inferred list derived from .filteredNot().
   * [mixedList] immutable list of mixed types.
  */
  fun exercise048() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    val numbersMap = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3, "key 101" to 101)
    val filteredMap = numbersMap.filter { it.key.endsWith("1") && it.value > 100 }
    println(filteredMap)

    val filteredIndex = numbers.filterIndexed { index, value -> (index != 0) && (value.length < 5) }
    val filteredNot = numbers.filterNot { it.length <= 3 }
    println(filteredIndex)
    println(filteredNot)

    val mixedList = listOf(1, 2, 3, 'A', 'B', 'C', "Hello World", "Alex", false)
    mixedList.filterIsInstance<Char>().forEach {
      println(it)
    }
    mixedList.filterIsInstance<Int>().forEach {
      println(it)
    }
    mixedList.filterIsInstance<String>().forEach {
      println(it)
    }
    mixedList.filterIsInstance<Boolean>().forEach {
      println(it)
    }
  }

  /** 
   * Collections Operations - String Representation:
   * [numbersStrings] immutable type inferred list of strings.
   * [listString] immutable type inferred string buffer.
   * [numbers] immutable type inferred list of integers.
  */
  fun exercise047() {
    val numbersStrings = listOf("one", "two", "three", "four")
    println(numbersStrings)
    println("")
    println(numbersStrings.joinToString())
    println("")

    val listString = StringBuffer("The list of numbers: ")
    println(numbersStrings.joinTo(listString))
    println("")
    println(numbersStrings.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

    val numbers = (1 .. 100).toList()
    println(numbers.joinToString(limit = 15, truncated = "<...>"))

    println(numbersStrings.joinToString { "Element: ${it.uppercase()}"})
  }

  /** 
   * Collections Operations - Flatten Transformations:
   * [numberSets] immutable type inferred list of lists.
   * [numbersFlatten] immutable type inferred list derived by using the .flatten() on [numberSets].
   * [numberSets1] immutable type inferred array of arrays.
  */
  fun exercise046() {
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(7, 8, 9))
    for (numbers in numberSets) {
      for (number in numbers) {
        println(number)
      }
      println("")
    }
    val numbersFlatten = numberSets.flatten()
    println(numbersFlatten[8])
    println("")
    for (number in numbersFlatten) println(number)
    println("")
    val numberSets1 = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
    println(numberSets1[2][2])
  }

  /** 
   * Collections Operations - Association Transformations:
   * [numbers] immutable type inferred list of strings.
  */
  fun exercise045() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })
    println(numbers.associateBy { it.first().uppercase() })
    println(numbers.associateBy(keySelector = { it.first().uppercase() }, valueTransform = { it.length }))
  }

  /** 
   * Collections Operations - Zip Transformations:
   * [colours] and [animals] immutable type inferred lists of strings.
   * [numberPairs] immutable type inferred list of pairs.
  */
  fun exercise044() {
    val colours = listOf("red", "brown", "grey")
    val animals = listOf("fox", "deer", "wolf")
    println(colours.zip(animals))
    println(colours zip animals)
    println(colours.zip(animals) { colour, animal -> "The ${animal.replaceFirstChar { it.uppercase() }} is $colour"})

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs)
    println(numberPairs.unzip())
  }

  /** 
   * Collections Operations - Map Transformations:
   * [numbers] and [numbers1] immutable type inferred containers derived from setOf() and altered using .map {} and .mapIndexedNotNull {}.
   * [numbersMap] immutable map altered using .mapKeys {} and .mapValues {}.
  */
  fun exercise043() {
    val numbers = setOf(1, 2, 3, 4, 5)
    println(numbers.map { it * 10 })

    val numbers1 = setOf(1, 2, 3, 4, 5)
    println(numbers1.map { if (it == 3) it * 100 else it * 10 })
    println(numbers1.mapIndexedNotNull { index, value -> if (index == 0) null else index + value })

    val numbersMap = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3, "key 4" to 4)
    println(numbersMap.mapKeys { it.key.uppercase() })
    println(numbersMap.mapValues { it.value + it.key.length })
  }

  /** 
   * Collections - Map:
   * [users] immutable type specific container derived from mapOf<Int, String>().
   * [users1] mutable type specific container derived from mutableMapOf<Int, String>().
  */
  fun exercise042() {
    val users = mapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John")
    println("users[1]: ${users[1]}")
    println("users[2]: ${users[2]}")

    val users1 = mutableMapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John")
    users1[5] = "Vlad"
    users1.remove(2)
    users1.forEach { t, u -> 
      println("$t and $u")
    }
  }

  /** 
   * Collections - Set:
   * [names] immutable type specified container derived from setOf<String>().
   * [names1] mutable type inferred container derived from mutableSetOf().
   * [User] class with String @property [name].
   * [user1], [user2], [user3], [user4], [user5], [user6] and [user7] immutable objects derived from [User].
   * [names2] mutable type specific container derived from mutableSetOf<User>().
   * [User1] data class with String @property [name].
   * [user8], [user9], [user10], [user11], [user12], [user13] and [user14] immutable objects derived from [User1].
   * [names3] mutable type specific container derived from mutableSetOf<User1>().
  */
  fun exercise041() {
    val names = setOf<String>("Name 1", "Name 2", "Name 3", "Name 1", "Name 2")
    names.forEach { println(it) }
    println("")

    val names1 = mutableSetOf("Name 1", "Name 2", "Name 3", "Name 1", "Name 2")
    names1.add("Name 4")
    names1.forEach { println(it) }
    println("")

    class User(val name: String)
    val user1 = User("Name 1")
    val user2 = User("Name 2")
    val user3 = User("Name 3")
    val user4 = User("Name 4")
    val user5 = User("Name 5")
    val user6 = User("Alex")
    val user7 = User("Alex")
    val names2 = mutableSetOf<User>(user1, user2, user3, user4, user5, user6, user7)
    names2.forEach { println(it.name) }
    println("")

    data class User1(val name: String)
    val user8 = User1("Name 1")
    val user9 = User1("Name 2")
    val user10 = User1("Name 3")
    val user11 = User1("Name 4")
    val user12 = User1("Name 5")
    val user13 = User1("Alex")
    val user14 = User1("Alex")
    val names3 = mutableSetOf<User1>(user8, user9, user10, user11, user12, user13, user14)
    names3.forEach { println(it.name) }
  }

  /** 
   * Collections - List:
   * [names] immutable list of type specified String.
   * [names1] mutable list of inferred type String.
  */
  fun exercise040() {
    val names = listOf<String>("Name 1", "Name 2", "Name 3")
    println("names[0]: ${names[0]}")

    val names1 = mutableListOf("Name 1", "Name 2", "Name 3", "Name 1", "Name 2")
    names1.add("Name 4")
    names1.removeAt(0)
    names1.remove("Name 2")
    names1.forEach { println(it) }
  }

  /** 
   * Object Oriented Programming - Delegation:
   * [FirstDelegate] open class with function [print].
   * [SecondDelegate] open class with function [print2].
   * [App] class delegates A by FirstDelegate(), B by SecondDelegate() and overrides their functions.
   * [FormatDelegate] class that inherits from [ReadWriteProperty] and overrides its [getValue] and [setValue] functions.
   * [User] class the delegates its two @property [firstName] and [lastName] by FormatDelegate].
   * [user] mutable object derived from [User].
  */
  fun exercise039() {
    open class FirstDelegate: A {
      override fun print() {

      }
    }
    open class SecondDelegate: B {
        override fun print2() { 

        }
    }
    class App: A by FirstDelegate(), B by SecondDelegate() {
      override fun print() {}
      override fun print2() {}
    } 
    class FormatDelegate: ReadWriteProperty<Any?, String> {
      private var formattedString: String = ""

      override fun getValue(thisRef: Any?, property: KProperty<*>): String { 
        return formattedString
      }

      override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) { 
        formattedString = value.lowercase()
      }
    }
    class User {
      var firstName by FormatDelegate()
      var lastName by FormatDelegate()
    }
    var user = User()
    with (user) {
      firstName = "Alex"
      lastName = "Dobinca"
    }
    with (user) {
      println("$firstName $lastName")
    }
  }

  /**
   * Object Oriented Programming - Object Expression(Anonymous Class): 
   * [Button] class with the Interface [OnClickListener] as one of its property types.
   * [ClickListener] class that implements th interface [OnClickListener].
   * [clickListener] immutable derived from [ClickListener].
   * [loginButton] immutable derived from [Button] using [clickListener].
   * [loginButton1] and [signUpButton] immutables derived from [Button] using Object Expressions of [ClickListener].
  */
  fun exercise038() {
    class Button(val text: String, val id: Int, onClickListener: OnClickListener)
    class ClickListener(): OnClickListener {
      override fun onClick() {
        println("Button Clicked")
      }
    }
    val clickListener = ClickListener()
    val loginButton = Button("Login", 1232, clickListener)

    val loginButton1 = Button("Login", 1232, object: OnClickListener {
      override fun onClick() {
        println("Login button Clciked")
      }
    })
    val signUpButton = Button("Sign Up", 23423, object: OnClickListener {
      override fun onClick() {
        println("Sign Up button Clciked")
      }
    })
    println(loginButton.text)
    println(loginButton1.text)
    println(signUpButton.text)
  }

  /** 
   * Object Oriented Programming - Interfaces:
   * [Engine] interface.
   * [Car], [Truck], [Plane] and [Tesla] classes that implement [Engine].
  */
  fun exercise037() {
    open class Iter(val named: String, val coloured: String) {      
      open operator fun iterator(): Iterator<Pair<String, Any>> {
        return listOf("Name" to named, "Colour" to coloured).iterator()
      }
    }
    class Car(val name: String, val colour: String): Engine, Iter(name, colour) {
      override fun startEngine() {
        println("The car is starting the engine.")
      }      
    }
    class Truck(val name: String, val colour: String): Engine, Iter(name, colour) {
      override fun startEngine() {
        println("The truck is starting the engine.")
      }      
    }
    class Plane(val name: String, val colour: String): Engine, Iter(name, colour) {
      override fun startEngine() {
        println("The plane is starting the engine.")
      }
    }
    class Tesla(val name: String, val colour: String): Engine, Iter(name, colour) {
      override fun startEngine() {
        println("Tesla is starting the engine.")
      }
    }
    val car = Car("Car 1", "Green")
    val truck = Truck("Truck 1", "Red")
    val plane = Plane("Plane 1", "Blue")
    val tesla = Tesla("Tesla 1", "White")

    for ((key, value) in car) println("$key: $value")
    car.startEngine()
    println("")

    for ((key, value) in truck) println("$key: $value")
    truck.startEngine()
    println("")

    for ((key, value) in plane) println("$key: $value")
    plane.startEngine()
    println("")

    for ((key, value) in tesla) println("$key: $value")
    tesla.startEngine()
    println("")
  }

  /** 
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
  */
  fun exercise036() {
    val name1 = "Alex"
    val name2 = "Alexandru"
    println("name1 == name2: ${name1 == name2}")
    println("name1 === name2: ${name1 === name2}")

    class User(var firstName: String, var lastName: String, var age: Int)
    val user1 = User("Alex", "Dobbin", 23)
    val user2 = User("Alex", "Dobbin", 23)
    println("user1 == user2: ${user1 == user2}")

    class User1(var firstName: String, var lastName: String, var age: Int) {
      override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is User1) return this.firstName == other.firstName && 
          this.lastName == other.lastName && this.age == other.age
        return false
      }
      override fun hashCode() = 0
      override fun toString() = "User1(firstName: '$firstName', lastName: '$lastName', age: '$age')"
    }
    val user3 = User1("Alex", "Dobbin", 23)
    val user4 = User1("Alex", "Dobbin", 23)
    println("user3 == user4: ${user3 == user4}")
    println("user3: $user3")
    println("user4: $user4")

    data class User2(var firstName: String, var lastName: String, var age: Int)
    val user5 = User2("Alex", "Dobbin", 23)
    val user6 = User2("Alex", "Dobbin", 23)
    println("user5 == user6: ${user5 == user6}")
    println("user5: $user5")
    println("user6: $user6")

    data class User3(var firstName: String, var lastName: String) {
      var age = 0
    }
    val user7 = User3("Alex", "Dobbin")
    val user8 = User3("Alex", "Dobbin")
    println("user7 == user8: ${user7 == user8}")
    println("user7: $user7")
    println("user8: $user8")
  }

  /** 
   * Object Oriented Programming - Abstract Classes:
   * [Vehicle] abstract class with one intiated property [text] and two abstract functions [move] and [stop].
   * [Car] class that inherits from [Vehicle] and overrides it's two functions.
  */
  fun exercise035() {
    abstract class Vehicle {
      val text = "Can have properties initiated"
      abstract fun move() 
      abstract fun stop() 
    }
    class Car(var name: String, var colour: String, val engines: Int, val doors: Int): Vehicle() {
        override fun move() { }
        override fun stop() { }

    }
  }

  /** 
   * Object Oriented Programming - Sealed Classes with inner Sealed Class:
   * [Result2] sealed classes with three internal classes [Success], [Error] and [Progress] and a function [showMessage].
   * [getData] function that takes a variable of type [Result2] and uses a when statement to render conditions.
   * [success] and [progress] immutable objects derived from initiating [Result2] objects with messages.
  */
  fun exercise034() {
    fun getData(result: Result2) {
      when (result) {
        is Result2.Success -> result.showMessage()
        is Result2.Progress -> result.showMessage()
        is Result2.Error.NonRecoverableError -> result.showMessage()
        is Result2.Error.RecoverableError -> result.showMessage()
      }
    }
    val success = Result2.Success("SUCCESS!")
    val progress = Result2.Progress("PROGRESS!")
    getData(success)
    getData(progress)
  }

  /** 
   * Object Oriented Programming - Sealed Classes:
   * [Result] enum class with two fixed objects [SUCCESS] and [ERROR].
   * [Result1] sealed classes with three internal classes [Success], [Error] and [Progress] and a function [showMessage].
   * [getData] function that takes a variable of type [Result1] and uses a when statement to render conditions.
   * [success], [error] and [progress] immutable objects derived from initiating [Result1] objects with messages.
  */
  fun exercise033() {
    fun getData(result: Result1) {
      when (result) {
        is Result1.Error -> result.showMessage()
        is Result1.Success -> result.showMessage()
        is Result1.Progress -> result.showMessage()
      }
    }
    val success = Result1.Success("SUCCESS!")
    val error = Result1.Error("FAILED!")
    val progress = Result1.Progress("PROGRESS!")
    getData(success)
    getData(error)
    getData(progress)
  }

  /** 
   * Object Oriented Programming - Class Inheritance:
   * [View] open class with an open function [Draw].
   * [Button] class that inherits from [View] and overrides [draw].
   * [RoundButton] class that inherits from [Button] and overrides [draw].
  */
  fun exercise032() {
    open class View() {
      open fun draw() {
        println("Drawing the view.")
      }
    }
    open class Button(val text: String, val orientation: String): View() {
      override fun draw() {
        println("Drawing the button")
        super.draw()
      }
    }
    class RoundButton(text: String, orientation: String, val corners: Int): Button(text, orientation) {
      override fun draw() {
        println("Drawing the round button.")
      }
    }
    val view = View()
    val button = Button("login", "Center")
    val roundButton = RoundButton("Sign Up", "Center", 30)
    view.draw()
    button.draw()
    roundButton.draw()
  }

  /** 
   * Object Oriented Programming - Class Inheritance:
   * [Vehicle] class with primary constructors and two functions [move] and [stop]. 
   * Uses the open keyword to allow the class to be inherited and uses the open keyword to allow the functions to be overriden.
   * [Car] and [Plane] classes with primary constructors that inherit from [Vehicle].
   * [Plane] overrides the [move] function.
   * [car] and [plane] immutable objects derived from [Car] and [Plane] respectively.
  */
  fun exercise031() {
    open class Vehicle(val name: String, val colour: String)  {
      open fun move() {
        println("$name is moving")
      }
      open fun stop() {
        println("$name has stopped")
      }
    }
    class Car(name: String, colour: String, val engines: Int, val doors: Int): Vehicle(name, colour) {
    }
    class Plane(name: String, colour: String, val engines: Int, val doors: Int): Vehicle(name, colour) {
      override fun move() {
        flying()
        super.move()
      }
      fun flying() {
        println("The plane is flying")
      }
    }
    val car = Car("BMW", "RED", 1, 4)
    val plane = Plane("Boeing", "WHITE and BLUE", 4, 4)
    car.move()
    car.stop()
    plane.move()
    plane.stop()
  }

  /** 
   * Object Oriented Programming - Access Modifiers:
   * [Account] class with primary and secondary constructors and 3 functions [deposit], [withdraw] and [calculateBalance].
   * [alexAccount] immutable object derived from [Account].
  */
  fun exercise030() {
    class Account(val accountName: String) {
      private var balance = 0
      private var transactions = mutableListOf<Int>()

      fun deposit(amount: Int) {
        if (amount > 0) {
          transactions.add(amount)
          balance += amount
          println("$amount deposited. Balance is now ${this.balance}")
        } else {
          println("Cannot make a deposit because $amount is less than or equal to zero")
        }
      }
      fun withdraw(withdrawal: Int) {
        if (-withdrawal < 0) {
          transactions.add(-withdrawal)
          balance += -withdrawal
          println("$withdrawal withdrawn. Balance is now ${this.balance}")
        } else {
          println("Cannot make a withdrawal because $withdrawal is less than or equal to zero")
        }
      }
      fun calculateBalance(): Int {
        this.balance = 0
        for (transaction in transactions) {
          this.balance += transaction
        }
        return this.balance
      }
    }

    val alexAccount = Account("Alex")
    alexAccount.deposit(1000)
    alexAccount.withdraw(500)
    alexAccount.deposit(-20)
    alexAccount.withdraw(-100)
    val balance = alexAccount.calculateBalance()
    println("Balance is $balance")
  }

  /** 
   * Object Oriented Programming - Inner Classes:
   * [ListView] class with primary constructor and inner class.
   * [ListViewItem] inner class with function [displayItem].
   * [listView] immutable object derived from [ListView].
  */
  fun exercise029() {
    class ListView(val items: Array<String>) {
      inner class ListViewItem() {
        fun displayItem(position: Int) {
          println(items[position])
        }
      }
    }
    val listView = ListView(arrayOf("Name 1", "Name 2", "Name 3", "Name 4"))
    listView.ListViewItem().displayItem(2)
  }

  /** 
   * Object Oriented Programming - Enum Classes with Constructors:
   * [Direction1] enum class with 4 Objects and a function.
   * [direction] and [direction1] immutable objects derived from [Direction1]
  */
  fun exercise028() {
    for (direction in Direction1.values()) {
      println(direction)
    }
    println("")

    println("Name: ${Direction1.NORTH.name}")
    println("Direction: ${Direction1.NORTH.direction}")
    println("Distance: ${Direction1.NORTH.distance}")
    println("")
    Direction1.WEST.printData()

    val direction = Direction1.EAST
    when(direction) {
      Direction1.EAST -> println("The direction is East")
      Direction1.WEST -> println("The direction is West")
      Direction1.NORTH -> println("The direction is North")
      Direction1.SOUTH -> println("The direction is South")
    }

    val direction1 = Direction1.valueOf("east".uppercase())
    when(direction1) {
      Direction1.EAST -> println("The direction is East")
      Direction1.WEST -> println("The direction is West")
      Direction1.NORTH -> println("The direction is North")
      Direction1.SOUTH -> println("The direction is South")
    }
  }

  /** 
   * Object Oriented Programming - Enum Classes:
   * [Direction] enum class with 4 Objects.
  */
  fun exercise027() {
    println("Direction.WEST: ${Direction.WEST}")
    println("Direction.EAST: ${Direction.EAST}")
    println("Direction.NORTH: ${Direction.NORTH}")
    println("Direction.SOUTH: ${Direction.SOUTH}")
    println("")
  }

  /** 
   * Object Oriented Programming - Lazy Loading:
   * [User] class with primary constructor.
   * [user] immutable derived object from [User].
   * [user1] immutable derived object from [User] using lazy loading.
  */
  fun exercise026() {
    class User(var firstName: String, var lastName: String, var age: Int) {
      init {
        println("User: $firstName was created")
      }
      
      operator fun iterator(): Iterator<Pair<String, Any>> {
        return listOf("firstName" to firstName, "lastName" to lastName, "age" to age).iterator()
      }
    }
    val user = User("Alex", "Dobbin", 23)
    for ((key, value) in user) println("$key: $value")
    println("")

    val user1 by lazy { 
      User("User", "lastName", 23)
    }
    for ((key, value) in user1) println("$key: $value")
    println("")
  }

  /** 
   * Object Oriented Programming - Singletons:
   * [Database] singleton object.
  */
  fun exercise025() {
    println("Database: ${Database}")
    println("Database: ${Database}")
  }

  /** 
   * Object Oriented Programming - Instances:
   * [Database] class with private constructor and companion object.
   * [instance] and [instance2] objects derived from calling [getInstance] of [Database]
  */
  fun exercise024() {
    val instance = Database.getInstance()
    println("instance: $instance")
    val instance2 =  Database.getInstance()
    println("instance2: $instance2")
  }

  /** 
   * Object Oriented Programming - Companion Objects:
   * [Calculator] class with [sum] function inside a companion object.
   * [result] immutable variable derived from calling the [sum] function of [Calculator].
  */
  fun exercise023() {
    val result = Calculator1.sum(5, 10)
    println("result: $result")
  }

  /** 
   * Object Oriented Programming - Class Functions:
   * [Calculator] class with [sum] function.
   * [calculator] immutable object derived from [Calculator].
   * [result] immutable variable derived from calling the [sum] function of [calculator].
  */
  fun exercise022() {
    class Calculator() {
      fun sum(a: Int, b: Int) = a + b
    }
    val calculator = Calculator()
    val result = calculator.sum(5, 10)
    println("result: $result")
  }

  /** 
   * Object Oriented Programming - lateinit:
   * [User] class with primary constructor, default values and lateinit variable.
   * [user] mutable derived objects from [User].
  */
  fun exercise021() {
    class User(var firstName: String, var lastName: String, var age: Int) {
      lateinit var favouriteMovie: String
      
      operator fun iterator(): Iterator<Pair<String, Any>> {
        return listOf("firstName" to firstName, "lastName" to lastName, "age" to age, 
          "favouriteMovie" to favouriteMovie
        ).iterator()
      }
    }
    val user = User("Alex", "Dobbin", 23)
    user.favouriteMovie = "Interstellar"
    for ((key, value) in user) println("$key: $value")
    println("")
  }

  /** 
   * Object Oriented Programming - Class Getters & Setters:
   * [User] class with primary constructor, default values and overidden getter and setter.
   * [user] and [friend] mutable derived objects from [User].
  */
  fun exercise020() {
    class User(firstName: String, var lastName: String = "LastName", var age: Int = 0) {
      var firstName = firstName
      get() {
        return "FirstName: $field"
      }
      set(value) {
        println("$value was assigned to firstName property and replaced $field")
        field = value
      }

      operator fun iterator(): Iterator<Pair<String, Any>> {
        return listOf("firstName" to firstName, "lastName" to lastName, "age" to age).iterator()
      }
    }
    var user = User("Alex")
    for ((_, value) in user) println("$value")
    println("")

    var friend = User("John", "Smith")
    for ((_, value) in friend) println("$value")
    println("")

    user.firstName = "Vlad"
    for ((_, value) in user) println("$value")
    println("")
  }

  /** 
   * Object Oriented Programming - Class Properties Default Values:
   * [User] class with primary constructor and default values.
   * [user], [user1] and [friend] mutable derived objects from [User].
  */
  fun exercise019() {
    class User(var firstName: String, var lastName: String = "LastName", var age: Int = 0) {
      operator fun iterator(): Iterator<Pair<String, Any>> {
        return listOf("firstName" to firstName, "lastName" to lastName, "age" to age).iterator()
      }
    }
    val user = User("Alex")
    for ((key, value) in user) println("$key: $value")
    println("")

    val friend = User("John", "Smith")
    for ((key, value) in friend) println("$key: $value")
    println("")

    val user1 = User(age = 19, firstName = "Ioana", lastName = "Dobbbi")
    for ((key, value) in user1) println("$key: $value")
    println("")
  }

  /** 
   * Object Oriented Programming - Class Secondary Constructors:
   * [User] class with primary and secondary constructors.
   * [user] and [friend] mutable derived objects from [User].
  */
  fun exercise018() {
    class User(var name: String, var lastName: String, var age: Int) {
      constructor(name: String): this(name, "LastName", 0) {
        println("2nd constructor")
      }
      constructor(name: String, lastName: String): this(name, lastName, 0) {
        println("3rd constructor")
      }

      operator fun iterator(): Iterator<Pair<String, Any>> {
        return listOf("name" to name, "lastName" to lastName, "age" to age).iterator()
      }
    }
    val user = User("Alex")
    for ((key, value) in user) println("$key: $value")
    println("")

    val friend = User("John", "Smith")
    for ((key, value) in friend) println("$key: $value")
    println("")
  }

  /** 
   * Object Oriented Programming - Class Validation with Initialiser Blocks:
   * [User] class with primary constructor.
   * [user] and [friend] mutable derived objects from [User].
  */
  fun exercise017() {
    class User(name: String, var lastName: String, var age: Int) {
      var name: String 

      init {
        if (name.lowercase().startsWith("a")) {
          this.name = name
        } else {
          println("The name $name doesn't start with the letter 'a' or 'A'")
          this.name = "User"
        }
      }

      operator fun iterator(): Iterator<Pair<String, Any>> {
        return listOf("name" to name, "lastName" to lastName, "age" to age).iterator()
      }
    }
    var user = User("Alex", "Dobinca", 23)
    user.iterator().forEach {(key, value) -> println("$key: $value")}
    println("")

    var friend = User("John", "Smith", 30)
    for ((key, value) in friend) println("$key: $value")
    println("")

    friend = User("Andra", "Smith", 30)
    for ((key, value) in friend) println("$key: $value")
    println("")
  }

  /** 
   * Object Oriented Programming - Class Constructors & Properties:
   * [Car] class constructor with parameters name, model, colour and doors  set as properties except name and functions move and stop.
   * [car] and [car1] immutable inferred objects of the [Car] class.
  */
  fun exercise016() {

    class Car(name: String, var model: String, var colour: String, var doors: Int) {
      var name = name.trim()
      fun move() {
        println("The car $name is moving")
      }
      fun stop() {
        println("The car $name has stopped")
      }
    }
    val car = Car(" Tesla ", "S Plaid", "Red", 4)
    println("Car:")
    println("Name: ${car.name}")
    println("Model: ${car.model}")
    println("Colour: ${car.colour}")
    println("Doors: ${car.doors}")
    car.move()
    car.stop()
    println("")

    val car1 = Car(" Ford ", "Mustang", "Blue", 2)
    println("Car1:")
    println("Name: ${car1.name}")
    println("Model: ${car1.model}")
    println("Colour: ${car1.colour}")
    println("Doors: ${car1.doors}")
    car1.move()
    car1.stop()
    println("")
  }

  /** 
   * Object Oriented Programming - Class Constructors:
   * [Car] class constructor with parameters set as properties name, model, colour and doors and functions move and stop.
   * [car] and [car1] immutable inferred objects of the [Car] class.
  */
  fun exercise015() {
    class Car(var name: String, var model: String, var colour: String, var doors: Int) {
      fun move() {
        println("The car $name is moving")
      }
      fun stop() {
        println("The car $name has stopped")
      }
    }
    val car = Car("Tesla", "S Plaid", "Red", 4)
    println("Car:")
    println("Name: ${car.name}")
    println("Model: ${car.model}")
    println("Colour: ${car.colour}")
    println("Doors: ${car.doors}")
    car.move()
    car.stop()
    println("")

    val car1 = Car("Ford", "Mustang", "Blue", 2)
    println("Car1:")
    println("Name: ${car1.name}")
    println("Model: ${car1.model}")
    println("Colour: ${car1.colour}")
    println("Doors: ${car1.doors}")
    car1.move()
    car1.stop()
    println("")
  }

  /** 
   * Object Oriented Programming - Class State & Function:
   * [Car] class constructor with parameters name, model, colour and doors and functions move and stop.
   * [car] and [car] immutable inferred objects of the [Car] class.
  */
  fun exercise014() {
    class Car(name: String, model: String, colour: String, doors: Int) {
      var name = name
      var model = model
      var colour = colour
      var doors = doors

      fun move() {
        println("The car $name is moving")
      }
      fun stop() {
        println("The car $name has stopped")
      }
    }
    val car = Car("Tesla", "S Plaid", "Red", 4)
    println("Car:")
    println("Name: ${car.name}")
    println("Model: ${car.model}")
    println("Colour: ${car.colour}")
    println("Doors: ${car.doors}")
    car.move()
    car.stop()
    println("")

    val car1 = Car("Ford", "Mustang", "Blue", 2)
    println("Car1:")
    println("Name: ${car1.name}")
    println("Model: ${car1.model}")
    println("Colour: ${car1.colour}")
    println("Doors: ${car1.doors}")
    car1.move()
    car1.stop()
    println("")
  }

  /** 
   * Object Oriented Programming - Class State & Function:
   * [Car] class with properties name, model, colour and doors and functions move and stop.
   * [car1] and [car2] immutable inferred objects of the [Car] class.
  */
  fun exercise013() {
    class Car {
      var name = ""
      var model = ""
      var colour = ""
      var doors = 0

      fun move() {
        println("The car $name is moving")
      }
      fun stop() {
        println("The car $name has stopped")
      }
    }

    val car1 = Car()
    car1.name = "Tesla"
    car1.model = "S Plaid"
    car1.colour = "Red"
    car1.doors = 4
    println("Car1:")
    println("Name: ${car1.name}")
    println("Model: ${car1.model}")
    println("Colour: ${car1.colour}")
    println("Doors: ${car1.doors}")
    car1.move()
    car1.stop()
    println("")

    val car2 = Car()
    car2.name = "Ford"
    car2.model = "Mustang"
    car2.colour = "Blue"
    car2.doors = 2
    println("Car2:")
    println("Name: ${car2.name}")
    println("Model: ${car2.model}")
    println("Colour: ${car2.colour}")
    println("Doors: ${car2.doors}")
    car2.move()
    car2.stop()
    println("")
  }

  /** 
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
  */
  fun exercise012() {
    val names: Array<String> = arrayOf("John", "Stephen", "Megan")
    val names1 = arrayOf("John", "Stephen", "Megan")
    names1.forEach { println(it); }
    names[0] = "Alex"
    println("First element: ${names[0]}")
    println("The size of the array is: ${names.size}")

    val mixedElements = arrayOf(4, 5, 6, 7, 4, "Name 1", 'a')

    for (name in names) {
      println("name: $name")
    }

    for (i in mixedElements) {
      println("i: $i")
    }

    for (i in mixedElements) {
      if (i is Int) println("i is Int: $i")
    }

    for (i in mixedElements) {
      if (i is Char) println("i is Char: $i")
    }

    for (i in mixedElements) {
      if (i is String) println("i is String: $i")
    }

    fun IntRange.toIntArray(): IntArray {
      if (last < first) return IntArray(0)
      val result = IntArray(last - first + 1)
      var index = 0
      for (element in this) result[index++] = element
      return result
    }
    val numbers = (1..20).toIntArray()
    fun minNumbers(numbers: IntArray) = numbers.reduce { x, y -> if (x < y) x else y }
    fun maxNumbers(numbers: IntArray) = numbers.reduce { x, y -> if (x > y) x else y }
    fun minMaxNumbers(numbers: IntArray, min: Boolean = true) = numbers.reduce { x, y -> if (min && x < y) x else if (!min && x > y) x else y }
    println("The minimum of numbers is ${minNumbers(numbers)}")
    println("The maximum of numbers is ${maxNumbers(numbers)}")
    println("The minimum of numbers is ${minMaxNumbers(numbers)} " + 
      "and the maximum of numbers is ${minMaxNumbers(numbers, false)}"
    )

    fun findMax(numbers: Array<Int>): Int {
      var max = numbers[0]
      for (number in numbers) {
        if (number > max) max = number
      }
      return max
    }

    fun findMin(numbers: Array<Int>): Int {
      var min = numbers[0]
      for (number in numbers) {
        if (number < min) min = number
      }
      return min
    }
    var max = findMax(arrayOf(4, 6, 7, 4, 3, 6))
    var min = findMin(arrayOf(4, 7, 9, 20, 7, 100))
    println("Max value = $max and my Max value is ${maxNumbers(arrayOf(4, 6, 7, 4, 3, 6).toIntArray())}")
    println("Min value = $min and my Min value is ${minNumbers(arrayOf(4, 7, 9, 20, 7, 100).toIntArray())}")

    fun findMinAndMax(numbers: Array<Int>, searchMax: Boolean): Int {
      var max = numbers[0]
      var min = max
      if (searchMax) {
        for (number in numbers) {
          if (number > max) max = number
        }
        return max
      } else {
        for (number in numbers) {
          if (number < min) min = number
        }
        return min
      }
    }
    max = findMinAndMax(arrayOf(20, 40, 50, 60, 100), true)
    println("The max value is = $max and my Max value is ${minMaxNumbers(arrayOf(20, 40, 50, 60, 100).toIntArray(), false)}")

    min = findMinAndMax(arrayOf(20, 40, 50, 60, 100), false)
    println("The min value is = $min and my Min value is ${minMaxNumbers(arrayOf(20, 40, 50, 60, 100).toIntArray())}")
  }

  /** 
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
  */
  fun exercise011() {
    for (i in 1..10) {
      println("i = $i")
    }
    for (i in 1 until 10) {
      println("i = $i")
    }
    for (i in 10 downTo 1) {
      println("i = $i")
    }
    for (i in 1 until 10 step 2) {
      println("i = $i")
    }

    var number = 0
    while (number < 10) {
      println("number: ${number++}")
    }
    number = 0
    while (number < 10) println("number: ${number++}")

    do {
      println("number: ${number++}")
    }
    while (number < 10)

    number = 0
    while (number < 10) {
      if (++number == 7) continue
      println("number: ${number}")
    }

    number = 0
    while (number < 10) {
      if (++number > 2 && number < 8) continue
      println("number: ${number}")
    }

    number = 0
    while (number < 10) {
      if (++number in 3..7) continue
      println("number: ${number}")
    }

    number = 0
    while (number < 10) {
      if (++number == 7) break
      println("number: ${number}")
    }

    for (i in 0..10) {
      if (i in 3..8) continue 
      println("i: $i")
    }

    for (i in 0..10) {
      if (i == 7) break
      println("i: $i")
    }

    number = 0
    while (number < 5) {
      println("number: ${number++}")

      var i = 0
      while (i < 5) println("i: ${i++}")
    }

    number = 0
    while (number < 5) {
      println("number: ${number++}")

      var i = 0
      while (i < 5) {
        if (i == 0) break
        println("i: ${i++}")
      }
    }

    number = 0
    outer@ while (number < 5) {
      println("number: ${number++}")

      var i = 0
      while (i < 5) {
        if (i == 0) break@outer
        println("i: ${i++}")
      }
    }

    number = 1
    val lastNumber = 20
    var evenNumberCounter = 0

    fun isEvenNumber(number: Int) = (number % 2) == 0
      
    while (number <= lastNumber) {
      if (!isEvenNumber(++number)) continue
      evenNumberCounter++
      println("number: $number")
    }
    println("Total number of even numbers found - using function = $evenNumberCounter")

    number = 0
    evenNumberCounter = 0
      
    while (number <= lastNumber) {
      if ((++number % 2) != 0) continue
      evenNumberCounter++
      println("number: $number")
    }
    println("Total number of even numbers found - using operator = $evenNumberCounter")

    evenNumberCounter = 0
    for (i in 1..20) {
      if ((i % 2) != 0) continue
      println("i: $i")
    }
    println("Total number of even numbers found - using for loop are: $evenNumberCounter")
  }

  /** 
   * Funcions:
   * [sayHello] functions with and without parameters. Parameters are immutable and type specific.
   * [getData] function with parameter @param [data] .
   * [showMessage] function without parameters.
   * [hasInternetConnection] immutable inferred Boolean used in if else to call either of two functions.
   * [getMax] function has two integer parameters and returns the max of both.
   * [max] immutable inferred Int derived from [getMax] result.
   * [getMax1] and [getMax2] more concise functions of [getMax].
   * Uses function overloading on [getMax].
   * [sendMessage] function whose parameters have default values.
   * [sendMessage1] function whose parameters have default values and also uses another function to return a default value.
   * [sum], [sum1] and [sum2] functions with a vararg @param [numbers] as type specific Int and sums up all passed entries.
  */
  fun exercise010() {
    fun sayHello() {
      println("Hello")
    }
    sayHello()
    fun sayHello(name: String) {
      println("Hello $name")
    }
    sayHello("Alex")
    fun sayHello(name: String, age: Int) {
      println("Hello $name your age is $age")
    }
    sayHello("Alex", 22)

    fun getData(data: String) {
      println("Your data is: $data")
    }
    fun showMessage() {
      println("There's no internet connection")
    }
    val hasInternetConnection = true
    if (hasInternetConnection) {
      getData("Some data")
    } else {
      showMessage()
    }

    fun getMax(a: Int, b: Int): Int {
      val max = if (a > b) a else b
      return max
    }    
    fun getMax1(a: Int, b: Int): Int {
      return if (a > b) a else b
    }  
    fun getMax2(a: Int, b: Int) = if (a > b) a else b
    val max = getMax(5, 9)
    println("Max of 5 and 9 is $max")

    fun getMax(a: Double, b: Double) = if (a > b) a else b
    val max1 = getMax(5.6, 9.7)
    println("Max of 5.6 and 9.7 is $max1")

    fun getMax(a: Int, b: Int, c: Int): Int {
      if (a >= b && a >= c) {
        return a
      } else if ( b >= a && b >= c) {
        return b
      } else {
        return c
      }
    }    
    val max2 = getMax(5, 7, 10)
    println("Max of 5, 7 and 10 is $max2")

    fun sendMessage(name: String = "User", message: String = "") {
      println("Name = $name and message = $message")
    }
    sendMessage("Alexa", "Hello!")
    sendMessage("Alexa")
    sendMessage()
    sendMessage(message = "Hello!")
    sendMessage(message = "Hello!", name = "Alexa")

    fun sendText() = "Some text!"
    fun sendMessage1(name: String = "User", message: String = sendText()) {
      println("Name = $name and message = $message")
    }
    sendMessage1("Alexa")

    fun sum(vararg numbers: Int): Int {
      var result = 0
      for (number in numbers) {
        result += number
      }
      return result
    }
    println("sum(5, 6, 7, 10, 5, 6, 4, 5, 3, 4, 5, 6, 4, 4, 6, 5) = ${sum(5, 6, 7, 10, 5, 6, 4, 5, 3, 4, 5, 6, 4, 4, 6, 5)}")

    fun sum1(vararg numbers: Int): Int {
      var result = 0
      numbers.forEach { result += it }
      return result
    }
    println("sum1(5, 6, 7, 10, 5, 6, 4, 5, 3, 4, 5, 6, 4, 4, 6, 5) = ${sum1(5, 6, 7, 10, 5, 6, 4, 5, 3, 4, 5, 6, 4, 4, 6, 5)}")

    fun sum2(vararg numbers: Int) = numbers.reduce { x, y -> x + y }
    println("sum2(5, 6, 7, 10, 5, 6, 4, 5, 3, 4, 5, 6, 4, 4, 6, 5) = ${sum2(5, 6, 7, 10, 5, 6, 4, 5, 3, 4, 5, 6, 4, 4, 6, 5)}")
  }

  /** 
   * Null:
   * [text] immutable type specific String assigned null.
   * Uses ? to accept existence of a null and avoid throwing an exception and !! to throw an exception.
   * [text2] immutable inferred String populated using Elvis method ?: .
  */
  fun exercise009() {
    val text: String? = null
    println("text: $text")
    if (text != null) {
      println("text length: ${text.length}")
    } else {
      println("The variable is null.")
    }
    println("text length: ${text?.length}")
    try {
      println("text length: ${text!!.length}")
    } catch (e: NullPointerException) {
      println("ERROR: text!!.length: ${e.message}")
    }

    val text2 = text ?: "The variable is null."
    println("text2: $text2")
  }

  /** 
   * ControlFlow:
   * [alarm] immutable inferred Int.
   * Uses when statement to determine outputs.
   * [text] immutable inferred String from when statement.
   * [text1] immutable inferred String from when statement.
   * [text2] immutable inferred String from when statement.
  */
  fun exercise008() {
    val alarm = 12

    when (alarm) {
      12 -> println("The time is $alarm")
      7 -> println("The time is $alarm")
      14 -> println("The time is $alarm")
      else -> println("The time is $alarm")
    }
    when (alarm) {
      12, 7, 14 -> println("The time is $alarm")
      in 1..10 -> println("The number is in the range 1..10")
      else -> println("The time is $alarm")
    }
    when (alarm) {
      !in 1..10 -> println("The number is in the range 1..10")
      12, 7, 14 -> println("The time is $alarm")
      else -> println("The time is $alarm")
    }
    
    val text = when (alarm) {
      in 1..10 -> {
        println("The number is in the range 1..10")
        "The number is in the range 1..10"
      }
      12, 7, 14 -> {
        println("The time is $alarm")
        "The time is $alarm"
      }
      else -> {
        println("The time is $alarm")
        "The time is $alarm"
      }
    }
    println("text: $text")
    
    val text1 = when (alarm) {
      in 1..10 -> "The number is in the range 1..10"
      12, 7, 14 -> "The time is $alarm"
      else ->"The time is $alarm"
    }
    println("text1: $text1")
    
    val text2 = when  {
      alarm <= 10 -> "The number is in the range 1..10"
      alarm in arrayOf(12, 7, 14) -> "The time is $alarm"
      else ->"The time is $alarm"
    }
    println("text2: $text2")
  }

  /** 
   * If then else:
   * [isActive] immutable inferred Boolean.
   * [myNumber] immutable inferred Int.
   * [isPlaying] immuable inferred Boolean.
   * [score] immutable inferred Int.
   * [num1] immutable inferred Int.
   * [num2] immutable inferred Int.
   * [text] immutable inferred String from result of if then expression.
   * [text1] immutable inferred String from result of if then expression.
   * Uses if, else if and else to determine the outputs.
  */
  fun exercise007() {
    val isActive = true
    if (isActive) {
      println("The user is active")
    } else {
      println("The user is not active")
    }
    val myNumber = 100
    if (myNumber > 150) {
      println("myNumber is greater than 150")
    } else if (myNumber > 90) {
      println("myNumber is greater than 90")
    } else {
      println("All the conditions failed.")
    }
    if (myNumber >= 100) {
      println("myNumber is greater than or equal to 100")
    } else if (myNumber > 90) {
      println("myNumber is greater than 90")
    } else {
      println("All the conditions failed.")
    }
    if (myNumber < 100) {
      println("myNumber is less than 150")
    } else if (myNumber <= 100) {
      println("myNumber is less than or equal to 100")
    } else {
      println("All the conditions failed.")
    }

    val isPlaying = true
    val score = 80
    if (isPlaying && score == 100) {
      println("Next level opened")
    } else {
      println("Still at the same level")
    }

    val num1 = 5
    val num2 = 4
    if (num1 > 0 || num2 > 0) {
      println("The condition is true")
    } else {
      println("The condition is false")
    }

    val text = if (num1 > 0 || num2 > 0) {
      println("The condition is true")
      "This is text 1"
    } else {
      println("The condition is false")
      "This is text 2"
    }
    println("text: $text")

    val text1 = if (num1 > 0 || num2 > 0) "This is text 1" else "This is text 2"
    println("text1: $text1")
  }

  /** 
   * Operators:
   * [x] mutable inferred Int.
   * [y] immutable inferred Int.
   * [result] mutable inferred Int from the sum of operands [x] and [y].
   * Prints [result] and uses place holder to print the following operations on [x] and [y]: + - * / %.
   * Shows end of line and block comments.
  */
  fun exercise006() {
    var x = 5
    val y = 3
    var result = x + y
    println("result: $result \nx + y = ${x + y}")
    println("x - y = ${x - y}")
    println("x * y = ${x * y}")
    println("x / y = ${x.toDouble() / y}")
    println("x % y = ${x % y}")

    result += 2
    println("result + 2 = $result")
    result -= 2
    println("result - 2 = $result")
    result *= 2
    println("result * 2 = $result")
    result /= 2
    println("result / 2 = $result")
    result %= 2
    println("result % 2 = $result")

    println("3 + 3 * 4 = ${3 + 3 *4}")

    x = 0 
    println("x = ${x++}")
    println("x = ${++x}")
    println("x = ${x--}")
    println("x = ${--x}")
  }

  /** 
   * CharAndBoolean:
   * [myCharValue] immutable type specific Char.
   * [myBooleanValue] immutable type specific Boolean.
  */
  fun exercise005() {
    val myCharValue: Char = 'D'
    val myBooleanValue: Boolean = false
    println("myCharValue: $myCharValue \nmyBooleanValue: $myBooleanValue")
  }

  /** 
   * FloatAndDouble:
   * [myFloat] immutable Float specified by appending f or F to the value.
   * [myDouble] immutable inferred Double.
  */
  fun exercise004() {
    val myFloat = 2.5f
    val myDouble = 2.5
    println("myFloat: $myFloat \nmyDouble: $myDouble")
  }

  /** 
   * ByteShortIntLong:
   * [number] immutable type specific Int.
   * [maxIntegerValue] immutable type specific Int.
   * [minIntegerValue] immutable type specific Int.
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
  */
  fun exercise003() {
    val number: Int = 22
    println("number: $number")
    val maxIntegerValue: Int = Int.MAX_VALUE
    val minIntegerValue: Int = Int.MIN_VALUE
    println("Int maximum value is: $maxIntegerValue")
    println("Int minimum value is: $minIntegerValue")

    try {
      val tooBig = Math.addExact(Int.MAX_VALUE, 1)
      println("tooBig: $tooBig, but should be ${Int.MAX_VALUE.toLong() + 1}")
    } catch (e: ArithmeticException) {
      println("ERROR: with tooBig: ${e.message}")
    }

    val myMaxByteValue: Byte = Byte.MAX_VALUE
    val myMinByteValue: Byte = Byte.MIN_VALUE
    println("Byte maximum value is: $myMaxByteValue")
    println("Byte minimum value is: $myMinByteValue")

    val myMaxShortValue: Short = Short.MAX_VALUE
    val myMinShortValue: Short = Short.MIN_VALUE
    println("Short maximum value is: $myMaxShortValue")
    println("Short minimum value is: $myMinShortValue")

    val myMaxLongValue: Long = Long.MAX_VALUE
    val myMinLongValue: Long = Long.MIN_VALUE
    println("Long maximum value is: $myMaxLongValue")
    println("Long minimum value is: $myMinLongValue")

    val intNumber = 28
    val longNumber = 28L
    val floatNumber = 28F
    println("Int: $intNumber, Long: $longNumber, Float: $floatNumber")
  }

  /**
   * Variables
   * [userName] immutable type specific String.
   * [age] immutable type specific integer.
  */
  fun exercise002() {
    var userName: String = "Alex"
    userName = "Jonh"
    var age: Int = 22
    age = 25
    println("Hello $userName your age is $age!")
  }

  /**
   * HelloWorld
   * Prints out Hello, World.
  */
  fun exercise001() {
    println("Hello, World")
  }
}