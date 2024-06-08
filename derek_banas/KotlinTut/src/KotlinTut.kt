package demo
import java.util.Random

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
class Comments {
  fun getComments(): MutableList<String> {
    var comments: MutableList<String> = mutableListOf()
    comments.add("""
      * Prints out Hello, World.
      * Creates an Immutable variable using: val [name]
      * Creates a Mutable variable using: var [myAge]
    """)
    comments.add("""
      * Displays Min and Max values of Int, Long, Double and Float.
      * Also confirms that Double Precision is accurate only up to 15 digits.
    """)
    comments.add("""
      * Examples of using booleans. 
      * Where [true] is confirmed as a Boolean and ['A'] is confirmed as a Char.
    """)
    comments.add("""
      * Examples of casting doubles to integers, characters to code integer and integers to characters.
    """)
    comments.add("""
      * String examples that return the length, substring and comparisons.
    """)
    comments.add("""
      * Array examples.
      * Creates a mutable inferred Array [myArray]
      * Creates a mutable inferred array containing an integer and an annonymous function.
      * Creates a mutable type specific array [arr2]
    """)
    comments.add("""
      * Range Examples
      * Creates immutable integer ranges [oneTo10], [tenTo1], [twoTo20] and [rng3] and iterates through a couple.
      * Creates and immutable character range [alpha] and searches within it.
    """)
    comments.add("""
      * Conditionals examples.
      * Uses the if, else if and else condition.
      * Uses the when, in and else condition. 
    """)
    comments.add("""
      * Iterator examples using the for and while loops.
      * Uses java.util.Random to create a immutable variable [rand] and uses it to generate a random number for an immutable varaible [magicNum].
      * Creates a mutable variable [guess] and uses a while loop to increment [guess] until it matches [magicNum].
      * Uses a for loop to iterate through an integer range and uses an if condition to print odd numbers.
      * Creates a mutable array [arr3] then uses a for loop to iterate through its indices and another for loop to iterate through it as a tuple using the .withIndex() option.
    """)
    comments.add("""
      * Function examples.
      * Creates three single line functions [add], [subtract] and [sayHello].
      * Creates three functions with function blocks [nextTwo], [getSum] and [fact]
      * Creates a recursive factorial function [factTail].
      * Prints output from use of each function.
    """)
    comments.add("""
      * Creates an immutable integer list [numList].
      * Creates an immutable integer list [evenList] and uses numList.filter{} to get all the even numbers. 
      * Uses evenList.forEach{} to print all its entries. 
      * Creates a function [mathOnList] that takes an Array and a Function and prints the results of the function on the array items.
    """)
    comments.add("""
      * Creates an immutable integer list [numList2].
      * Creates an immutable varaiable [listSum] from numList2.reduce{}.
      * Creates an immutable varaiable [listSum2] from numList2.fold().
      * Uses .any{} and .all{} to check if there are even numbers in [numList2].
      * Creates an immutable list [big3] using .filter{} to retrurn all values greater than 3 from [numList2] and prints the list using .forEach{}.
      * Creates an immutable list [times7] using .map{} to multiply each value in [numList2] and prints the list using .forEach{}.
    """)
    comments.add("""
      * Creates an immutable variable [divisor] with value set to 0.
      * Uses the try catch block to divide a number by 0.
    """)
    comments.add("""
      * [list1] a type specific mutable list of integers is populated with mutableListOf().
      * [list2] a type specific immutable list of integers is populated with listOf().
      * Prints [list1] first and last items using .first() and .last().
      * Prints [list2] item at index 2 using [2].
      * [list3] an inferred mutable list is populated from [list1] using .subList().
      * Running .clear() on [list3] also removes the items in [list1].
      * Removes specific items from [list1] using .remove() and removes items at index number using .removeAt().
      * Updates [list1] item using index and prints out both lists.
    """)
    comments.add("""
      * [map] a type specific mutable of integers and arrays using mutableMapOf<>().
      * [map2] an inferred type mutable of integers and arrays using mutableMapOf().
      * Uses index assignment and .put() to add values to [map] and .remove() to remove item an specified index.
      * Uses for loop to iterate through key values of [map] and [map2].
    """)
    comments.add("""
      * [Animal] a class with name, height and weight variables and a function [getInfo].
      * [Dog] a class with name, height and weight variables that inherits from [Animal] and overides the function [getInfo].
      * [Flyable] an interface with a mutable variable [flies] and a function [fly].
      * [Bird] a class with name, height and weight variables in a constructor that implements [Flyable] and overides the function [fly].
    """)
    comments.add("""
      * Shows that you can't assign null values and need to put ? after the variable or function return type.
      * [nullVal] a mutable type specific String initiated with null.
      * [returnNull] a type specifi function with a return type of String that returns null.
      * [nullVal2] a mutable variable receiving the return value from [returnNull].
      * [nullVal3] an immutable variable receiving the length of [nullVal] using !!.length (!!. cannot be used on mutable variables) replaced with ?. as it causes panic().
      * [nullVal4] a type specifc mutable String variables receiving the value of an either or statement using ?:.
      * Uses a try catch block to print out all variables.
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
class Exercises {
  /**
   * Shows that you can't assign null values and need to put ? after the variable or function return type.
   * [nullVal] a mutable type specific String initiated with null.
   * [returnNull] a type specifi function with a return type of String that returns null.
   * [nullVal2] a mutable variable receiving the return value from [returnNull].
   * [nullVal3] an immutable variable receiving the length of [nullVal] using !!.length (!!. cannot be used on mutable variables) replaced with ?. as it causes panic().
   * [nullVal4] a type specifc mutable String variables receiving the value of an either or statement using ?:.
   * Uses a try catch block to print out all variables.
   */
  fun exercise017() {
    var nullVal: String? = null
    fun returnNull(): String? {
      return null
    }
    var nullVal2 = returnNull()
  
    if(nullVal2 != null) {
      println("nullVal2.length")
    }
    val nullVal3 = nullVal?.length
    var nullVal4: String = (returnNull() ?: nullVal) ?: "None"
    try {
      println("nullVal: $nullVal \nnullVal2: $nullVal2 \nnullVal3: $nullVal3 \nnullVal4: $nullVal4")
    } catch (e: NullPointerException) {
      println("${e.message}")
    }
  }
  
  interface Flyable {
    var flies: Boolean
    fun fly(distMiles: Double): Unit
  }
  
  /**
   * [Animal] a class with name, height and weight variables and a function [getInfo].
   * [Dog] a class with name, height and weight variables that inherits from [Animal] and overides the function [getInfo].
   * [Flyable] an interface with a mutable variable [flies] and a function [fly].
   * [Bird] a class with name, height and weight variables in a constructor that implements [Flyable] and overides the function [fly].
   */
  fun exercise016() {
    open class Animal(
      val name: String, 
      var height: Double,
      var weight: Double
    ) {
      init {
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) {"Animal name Can't Contain a Number"}
        require(height > 0) {"Height must be Greater than 0"}
        require(weight > 0) {"Weight must be Greater than 0"}
      }
      open fun getInfo(): Unit {
        println("$name is $height feet tall and weighs $weight tons")
      }
    }
    val bowser = Animal("Bowser", 20.0, 13.5)
    bowser.getInfo()
  
    class Dog(
      name: String,
      height: Double,
      weight: Double,
      var owner: String
    ): Animal(name, height, weight) {
      override fun getInfo(): Unit {
        println("$name is $height feet tall and weighs $weight tons and is owned by $owner")
      }
    }
  
    val spot = Dog("Spot", 20.0, 14.5, "Paul Smith")
    spot.getInfo()
  
    class Bird constructor(val name: String, override var flies: Boolean = true): Flyable{
      override fun fly(distMiles: Double): Unit {
        if (flies) {
          println("$name flies $distMiles miles")
        }
      }
    }
    val tweety = Bird("Tweety", true)
    tweety.fly(10.0)
  }
  
  /**
   * [map] a type specific mutable of integers and arrays using mutableMapOf<>().
   * [map2] an inferred type mutable of integers and arrays using mutableMapOf().
   * Uses index assignment and .put() to add values to [map] and .remove() to remove item an specified index.
   * Uses for loop to iterate through key values of [map] and [map2].
   */
  fun exercise015() {
    val map = mutableMapOf<Int, Any?>()
    val map2 = mutableMapOf(1 to "Doug", 2 to 25)
    map[1] = "Derek"
    map[2] = 42
  
    println("Map Sice: ${map.size}")
    map.put(3, "Pittsburgh")
    map.remove(2)
    for ((x, y) in map) {
      println("Key: $x Value: $y")
    }
    for ((x, y) in map2) {
      println("Key: $x Value: $y")
    }
  }
  
  /**
   * [list1] a type specific mutable list of integers is populated with mutableListOf().
   * [list2] a type specific immutable list of integers is populated with listOf().
   * Prints [list1] first and last items using .first() and .last().
   * Prints [list2] item at index 2 using [2].
   * [list3] an inferred mutable list is populated from [list1] using .subList().
   * Running .clear() on [list3] also removes the items in [list1].
   * Removes specific items from [list1] using .remove() and removes items at index number using .removeAt().
   * Updates [list1] item using index and prints out both lists.
   */
  fun exercise014() {
    var list1: MutableList<Int> = mutableListOf(1,2,3,4,5)
    val list2: List<Int> = listOf(1,2,3)
    list1.add(6)
    println("1st: ${list1.first()}")
    println("Last: ${list1.last()}")
    println("2nd: ${list1[2]}")
  
    var list3 = list1.subList(0, 3)
    println("list1 Length: ${list1.size}")
    list3.clear()
    println("list1 Length: ${list1.size}")
    list1.remove(1)
    list1.removeAt(1)
    list1[1] = 10
    list1.forEach { n -> println("Mutable List: $n") }
    list2.forEach { n -> println("Immutable List: $n") }
  }
  
  /**
   * Creates an immutable variable [divisor] with value set to 0.
   * Uses the try catch block to divide a number by 0.
   */
  fun exercise013() {
    val divisor = 0  
    try {
      if (divisor == 0) {
        throw IllegalArgumentException("Can't Divide by Zero")
      } else {
        println("5 / $divisor = ${5/divisor}")
      }
    } catch (e: IllegalArgumentException) {
      println("${e.message}")
    }
  }
  
  /**
   * Creates an immutable integer list [numList2].
   * Creates an immutable varaiable [listSum] from numList2.reduce{}.
   * Creates an immutable varaiable [listSum2] from numList2.fold().
   * Uses .any{} and .all{} to check if there are even numbers in [numList2].
   * Creates an immutable list [big3] using .filter{} to retrurn all values greater than 3 from [numList2] and prints the list using .forEach{}.
   * Creates an immutable list [times7] using .map{} to multiply each value in [numList2] and prints the list using .forEach{}.
   */
  fun exercise012() {
    val numList2 = 1..20
    val listSum = numList2.reduce { x, y -> x + y }
    println("Reduce Sum: $listSum")
    val listSum2 = numList2.fold(5) { x, y -> x + y }
    println("Fold Sum: $listSum2")
  
    println("Evens: ${numList2.any { it % 2 == 0 }}")
    println("Evens: ${numList2.all { it % 2 == 0 }}")
  
    val big3 = numList2.filter { it > 3 }
    big3.forEach { n -> println(">3: $n") }
  
    val times7 = numList2.map { it * 7 }
    times7.forEach { n -> println("*7: $n") }
  }
  
  /**
   * Creates an immutable integer list [numList].
   * Creates an immutable integer list [evenList] and uses numList.filter{} to get all the even numbers. 
   * Uses evenList.forEach{} to print all its entries. 
   * Creates a function [mathOnList] that takes an Array and a Function and prints the results of the function on the array items.
   */
  fun exercise011() {
    val numList = 1..20
    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach { n -> println(n) }
  
    fun makeMathFunc(num1: Int): (Int) -> Int = {num2 -> num1 * num2}
    val mult3 = makeMathFunc(3)
    println("5 * 3 = ${mult3(5)}")
  
    fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
      for (num in numList) {
        println("MathOnList ${myFunc(num)}")
      }
    }
    val multiply2 = {num1: Int -> num1 * 2}
    val numList2 = arrayOf(1,2,3,4,5)
    mathOnList(numList2, multiply2)
  }
  
  /**
   * Function examples.
   * Creates three single line functions [add], [subtract] and [sayHello].
   * Creates three functions with function blocks [nextTwo], [getSum] and [fact]
   * Creates a recursive factorial function [factTail].
   * Prints output from use of each function.
   */
  fun exercise010() {
    fun add(num1: Int, num2: Int): Int = num1 + num2
    println("5 + 4 = ${add(5, 4)}")
    fun subtract(num1: Int = 1, num2: Int = 1) = num1 - num2
    println("5 - 4 = ${subtract(5, 4)}")
    println("4 - 5 = ${subtract(num2 = 5, num1 = 4)}")
    
    fun sayHello(name: String): Unit = println("Hello $name")
    sayHello("Paul")
  
    fun nextTwo(num: Int): Pair<Int, Int> {
      return Pair(num + 1, num + 2)
    }
    val (two, three) = nextTwo(1)
    println("1 $two $three")
  
    fun getSum(vararg nums: Int): Int {
      var sum = 0
      nums.forEach {n -> sum += n}
      return sum
    }
    println("Sum = ${getSum(1, 2, 3, 4, 5)}")
  
    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("5 * 3 = ${multiply(5, 3)}")
  
    fun fact(x: Int): Int {
      tailrec fun factTail(y: Int, z: Int): Int {
        if (y == 0) return z
        else return factTail(y - 1, y * z)
      }
      return factTail(x, 1)
    }
    println("5! = ${fact(5)}")
  }
  
  /**
   * Iterator examples using the for and while loops.
   * Uses java.util.Random to create a immutable variable [rand] and uses it to generate a random number for an immutable varaible [magicNum].
   * Creates a mutable variable [guess] and uses a while loop to increment [guess] until it matches [magicNum].
   * Uses a for loop to iterate through an integer range and uses an if condition to print odd numbers.
   * Creates a mutable array [arr3] then uses a for loop to iterate through its indices and another for loop to iterate through it as a tuple using the .withIndex() option.
   */
  fun exercise009() {
    for (x in 1..10) {
      println("Loop: $x")
    }
    val rand = Random()
    val magicNum = rand.nextInt(50) + 1
    var guess = 0
    while (magicNum != guess) {
      guess += 1
    }
    println("Magic Number was $guess")
    for (x in 1..20) {
      if (x % 2 == 0) {
        continue
      }
      println("Odd: $x")
      if (x == 15) break
    } 
    var arr3: Array<Int> = arrayOf(3,6,9)
    for (i in arr3.indices) {
      println("Mult 3: ${arr3[i]}")
    }
    for ((index, value) in arr3.withIndex()) {
      println("Index: $index Value: $value")
    }
  }
  
  /**
   * Conditionals examples.
   * Uses the if, else if and else condition.
   * Uses the when, in and else condition. 
   */
  fun exercise008() {
    val age = 8
    if (age < 5) {
      println("Go to Preschool")
    } else if (age == 5) {
      println("Go to Kindergarten")
    } else if ((age > 5) && (age < 17)) {
      val grade = age - 5
      println("Go to Grade $grade")
    } else {
      println("Go to Colledge")
    }
  
    when (age) {
      0,1,2,3,4 -> println("Go to Preschool")
      5 -> println("Go to Kindergarten")
      in 6..17 -> {
        val grade = age - 5
        println("Go to Grade $grade")
      }
      else -> println("Go to Colledge")
    }
  }
  
  /**
   * Range Examples
   * Creates immutable integer ranges [oneTo10], [tenTo1], [twoTo20] and [rng3] and iterates through a couple.
   * Creates and immutable character range [alpha] and searches within it.
   */
  fun exercise007() {
    val oneTo10 = 1..10
    val alpha = "A".."ZZ"
    println("R in Aplha: ${"AR" in alpha}")
    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val rng3 = oneTo10.step(3)
    for (x in rng3) println("rng: $x")
    for (x in tenTo1.reversed()) println("Reverse: $x")
    println(twoTo20)
  }
  
  /**
   * Array examples.
   * Creates a mutable inferred Array [myArray]
   * Creates a mutable inferred array containing an integer and an annonymous function.
   * Creates a mutable type specific array [arr2]
   */
  fun exercise006() {
    var myArray = arrayOf(1, 1.23, "Doug")
    println(myArray[2])
    myArray[1] = 3.14
    println("Array Length: ${myArray.size}")
    println("Doug in Array: ${myArray.contains("Doug")}")
    var partArray = myArray.copyOfRange(0, 1)
    println("First: ${partArray.first()}")
    println("Doug Index: ${myArray.indexOf("Doug")}")
    var sqArray = Array(5, {x -> x * x})
    println(sqArray[2])
    var arr2: Array<Int> = arrayOf(1, 2, 3)
    println(arr2[0])
  }
  
  /**
   * String examples that return the length, substring and comparisons.
   */
  fun exercise005() {
    val myName = "Derek Banas"
    val longStr = """This is a 
    long string"""
    println(myName + " says " + longStr)
    var fName: String = "Doug"
    var lName : String = "Smith"
    fName = "Sally"
    var fullName = fName + " " + lName
    println("Name: $fullName")
    println("1 + 2 = ${1 + 2}")
    println("String Length: ${longStr.length}")
    var str1 = "A random string"
    var str2 = "a random string"
    println("Strings Equal: ${str1.equals(str2)}")
    println("Compare A to B: ${"A".compareTo("B")}")
    println("2nd Index: ${str1.get(2)}")
    println("2nd Index: ${str1[2]}")
    println("Index 2 - 7: ${str1.subSequence(2, 8)}")
    println("Contains random: ${str1.contains("random")}")
  }
  
  /**
   * Examples of casting doubles to integers, characters to code integer and integers to characters.
   */
  fun exercise004() {
    println("3.14 to Int: " + (3.14.toInt()))
    println("A to Int: " + ('A'.code))
    println("65 to Char: " + 65.toChar())
  }
  
  /**
   * Examples of using booleans. 
   * Where [true] is confirmed as a Boolean and ['A'] is confirmed as a Char.
   */
  fun exercise003() {
    if (true is Boolean) {
      print("true is boolean\n")
    }
    var letterGrade: Char = 'A'
    println("A is a Char: ${letterGrade is Char}")
  }
  
  /**
   * Displays Min and Max values of Int, Long, Double and Float.
   * Also confirms that Double Precision is accurate only up to 15 digits.
   */
  fun exercise002() {
    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE
    println("Biggest Int: " + bigInt)
    println("Smallest Int: $smallInt")
  
    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE
    println("Biggest Long: " + bigLong)
    println("Smallest Long: " + smallLong)
  
    var bigDouble: Double = Double.MAX_VALUE
    var smallDouble: Double = Double.MIN_VALUE
    println("Biggest Double: " + bigDouble)
    println("Smallest Double: " + smallDouble)
  
    var bigFloat: Float = Float.MAX_VALUE
    var smallFloat: Float = Float.MIN_VALUE
    println("Biggest Float: " + bigFloat)
    println("Smallest Float: " + smallFloat)
  
    var dblNum1: Double = 1.1111111111111111
    var dblNum2: Double = 1.1111111111111111
    println("Sum: " + (dblNum1 + dblNum2))
  }

  /**
   * Prints out Hello, World.
   * Creates an Immutable variable using: val [name]
   * Creates a Mutable variable using: var [myAge]
   */
  fun exercise001() {
    println("Hello, World!")
    val name = "Derek"
    var myAge = 42
    println("$name is $myAge years old")
  }
}