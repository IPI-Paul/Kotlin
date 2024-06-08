import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.collections.reduce
import kotlin.properties.ReadWriteProperty
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
   * Advanced Functions - Higher Order Functions:
   * [printFilteredStrings] function that takes a list and a function in its constructor.
   * [list] list of strings.
   * [printFilteredStrings] function that takes a list and a function or a null in its constructor.
   * [predicate] type inferred immutable variable of a functional type.
   * [getPrintPredicate] function that returns an anonymous function which takes a string.
   * [list1] list of strings.
   * [map] map of strings derived calling .associate on [list1].
   * [language] to [language6] type inferred immutable variables derived from Kotlin library methods/functions on [list1].
  */
  fun exercise018() {
    fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
      list.forEach { 
        if (predicate(it)) {
          println(it)
        }
       }
    }
    val list = listOf("Kotlin", "Java", "C++", "Javascript")
    printFilteredStrings(list, { it.startsWith("K") })
    println()
    printFilteredStrings(list, { it.startsWith("J") })
    println()
    printFilteredStrings(list) { it.startsWith("C") }
    println()

    fun printFilteredStrings1(list: List<String>, predicate: ((String) -> Boolean)?) {
      list.forEach { 
        if (predicate?.invoke(it) == true) {
          println(it)
        }
       }
    }
    printFilteredStrings1(list, null)

    val predicate: (String) -> Boolean = {
      it.startsWith("J") 
    }
    printFilteredStrings1(list, predicate)
    println()

    fun getPrintPredicate(): (String) -> Boolean {
      return { it.startsWith("J") }
    }
    printFilteredStrings1(list, getPrintPredicate())
    println()

    list
      .filter { it.startsWith("J") }
      .forEach { println(it) }
    println()

    val list1 = listOf("Kotlin", "Java", "C++", "Javascript", null, null)

    list1
      .filterNotNull()
      .filter { it.startsWith("J") }
      .forEach { println(it) }
    println()

    list1
      .filterNotNull()
      .filter { it.startsWith("J") }
      .map{ it.length }
      .forEach { println(it) }
    println()

    list1
      .filterNotNull()
      .take(3)
      .forEach { println(it) }
    println()

    list1
      .filterNotNull()
      .takeLast(3)
      .forEach { println(it) }
    println()

    list1
      .filterNotNull()
      .associate { it to it.length }
      .forEach { println("${it.value}, ${it.key}") }
    println()

    val map = list1
      .filterNotNull()
      .associate { it to it.length }
    println(map)
    println()

    val language = list1.first()
    println(language)
    println()

    val language1 = list1.last()
    println(language1)
    println()

    val language2 = list1.filterNotNull().last()
    println(language2)
    println()

    val language3 = list1.filterNotNull().find { it.startsWith("Java") }
    println(language3)
    println()

    val language4 = list1.filterNotNull().findLast { it.startsWith("Java") }
    println(language4)
    println()

    val language5 = list1.filterNotNull().find { it.startsWith("foo") }
    println(language5)
    println()

    val language6 = list1.filterNotNull().find { it.startsWith("foo") }.orEmpty()
    println(language6)
    println()
  }

  /** 
   * Extension Functions / Properties:
   * [x015EntityType] enum class with four constants and a function.
   * [x015Entity] sealed class with an object and four data classes extended with a function [printInfo] and a property [info].
   * [x015EntityFactory] object declaration whose create function takes [x015EntityType] and inherits from [x015Entity].
   * [entity] type inferred immutable variable derived from [x015EntityFactory].
  */
  fun exercise017() {
    x015Entity.Medium("id", "name").printInfo()

    val entity = x015EntityFactory.create(x015EntityType.MEDIUM)
    if (entity is x015Entity.Medium) {
      entity.printInfo()
      println(entity.info)
    }
  }

  /** 
   * Data Classes:
   * [x015EntityType] enum class with four constants and a function.
   * [x015Entity] sealed class with an object and four data classes.
   * [x015EntityFactory] object declaration whose create function takes [x015EntityType] and inherits from [x015Entity].
   * [entity1] to [entity10] type inferred immutable variables derived from [x015EntityFactory].
  */
  fun exercise016() {
    val entity1 = x015EntityFactory.create(x015EntityType.EASY)
    val entity2 = x015EntityFactory.create(x015EntityType.EASY)

    if (entity1 == entity2) {
      println("They are equal")
    } else {
      println("They are not equal")
    }
    println()

    val entity3 = x015Entity.Easy("id", "name")
    val entity4 = x015Entity.Easy("id", "name")

    if (entity3 == entity4) {
      println("They are equal")
    } else {
      println("They are not equal")
    }
    println()

    val entity5 = x015Entity.Easy("id", "name")
    val entity6 = entity5.copy()

    if (entity5 == entity6) {
      println("They are equal")
    } else {
      println("They are not equal")
    }
    println()

    val entity7 = x015Entity.Easy("id", "name")
    val entity8 = entity7.copy(name = "new name")

    if (entity7 == entity8) {
      println("They are equal")
    } else {
      println("They are not equal")
    }
    println()

    val entity9 = x015Entity.Easy("id", "name")
    val entity10 = x015Entity.Easy("id", "name")

    if (entity9 === entity10) {
      println("They are equal")
    } else {
      println("They are not equal")
    }
    println()

    if (entity9 === entity9) {
      println("They are equal")
    } else {
      println("They are not equal")
    }
    println()
  }

  /** 
   * Sealed Classes:
   * [x015EntityType] enum class with four constants and a function.
   * [x015Entity] sealed class with an object and four data classes.
   * [x015EntityFactory] object declaration whose create function takes [x015EntityType] and inherits from [x015Entity].
   * [entity] and [entity1] type inferred immutable variables derived from [x015EntityFactory].
  */
  fun exercise015() {
    val entity: x015Entity = x015EntityFactory.create(x015EntityType.EASY)
    val msg = when (entity) {
      is x015Entity.Help -> "Help Class"
      is x015Entity.Easy -> "Easy Class"
      is x015Entity.Medium -> "Medium Class"
      is x015Entity.Hard -> "Hard Class"
    }
    println(msg)
    println()

    val entity1: x015Entity = x015EntityFactory.create(x015EntityType.HELP)
    val msg1 = when (entity1) {
      is x015Entity.Help -> "Help Class"
      is x015Entity.Easy -> "Easy Class"
      is x015Entity.Medium -> "Medium Class"
      is x015Entity.Hard -> "Hard Class"
    }
    println(msg1)
    println()
  }

  /** 
   * Object Declarations:
   * [x014Entity] class with one visible variable in its constructor.
   * [x014EntityFactory] object declaration with a [create] function that takes one parameter.
   * [entity] type inferred immutable varaible derived from [x014EntityFactory].
   * [x014Entity1] class with two visible variables in its constructor.
   * [x014EntityFactory1] object declaration with a [create] function that takes two parameters.
   * [entity1] type inferred immutable varaible derived from [x014EntityFactory1].
   * [x014EntityType] enum class with three variables.
   * [x014EntityFactory2], [x014EntityFactory3] and [x014EntityFactory4] object declaration with a [create] function that takes an enum parameter of type [x014EntityType] and inherits from [x014Entity1].
   * [entity2] and [mediumEntity] type inferred immutable varaible derived from [x014EntityFactory2].
   * [easyEntity] type inferred immutable varaible derived from [x014EntityFactory3].
   * [mediumEntity1] type inferred immutable varaible derived from [x014EntityFactory4].
  */
  fun exercise014() {
    val entity = x014EntityFactory.create()
    println(entity.id)
    println()

    val entity1 = x014EntityFactory1.create()
    println(entity1)
    println()

    val entity2 = x014EntityFactory2.create(x014EntityType.EASY)
    println(entity2)
    println()

    val mediumEntity = x014EntityFactory2.create(x014EntityType.MEDIUM)
    println(mediumEntity)
    println()

    val easyEntity = x014EntityFactory3.create(x014EntityType.EASY)
    println(easyEntity)
    println()

    val mediumEntity1 = x014EntityFactory4.create(x014EntityType1.MEDIUM)
    println(mediumEntity1)
    println()
  }

  /** 
   * Companion Objects:
   * [Entity] class with a private constructor.
   * [x013Entity] class with a private constructor and a companion object with a create function.
   * [entity1] and [entity2] type inferred immutable variables derived from [x013Entity].
   * [x013Entity1] class with a private constructor and a companion object of type Factory with a create function.
   * [entity3] type inferred immutable variable derived from [x013Entity1].
   * [x013Entity2] class with a private constructor and a companion object of type Factory with a create function and an initiated varaible.
   * [entity4] type inferred immutable variable derived from [x013Entity2].
   * [x013IdProvider] interface with a [getId] function.
   * [x013Entity3] class with a private constructor and a companion object of type Factory that 
   * inherits from [x013IdProvider] overriding its function and has a create function and an initiated varaible.
  */
  fun exercise013() {
    class Entity private constructor(val id: String)
    // val entity = Entity("id")
    
    val entity1 = x013Entity.Companion.create()
    println(entity1.id)
    println()
    val entity2 = x013Entity.create()
    println(entity2.id)
    println()

    val entity3 = x013Entity1.Factory.create()
    println(entity3.id)
    println()
    
    val entity4 = x013Entity2.Factory.create()
    println(entity4.id)
    println(x013Entity2.id)
    println()
    
    val entity5 = x013Entity3.Factory.create()
    println(entity5.id)
    println(x013Entity3.id)
    println()
  }

  /** 
   * Object Expressions:
   * [provider] immutable type inferred variable derived from an anonymous class object that inherits from [x010PersonInfoProvider3].
  */
  fun exercise012() {
    val provider = object : x010PersonInfoProvider3 {
      override val providerInfo: String
        get() = "New Info Provider"
      
        fun getSessionId() = "id"
    }
    provider.printInfo(x009Person5())
    println(provider.getSessionId())
    println()
  }

  /** 
   * Class Inherittance:
   * [BasicInfoProvider], [BasicInfoProvider1] and [BasicInfoProvider2] open classes that inherits from [x010PersonInfoProvider3] and [x010SessionInfoProvider] overiding their variables and functions.
   * [FancyInfoProvider] class that inherits from [BasicInfoProvider] overiding its variables and functions.
   * [provider] immutable type inferred variable derived from [FancyInfoProvider].
   * [FancyInfoProvider1] class that inherits from [BasicInfoProvider1] overiding its variables and functions.
   * [provider1] immutable type inferred variable derived from [FancyInfoProvider1].
   * [FancyInfoProvider2] class that inherits from [BasicInfoProvider2] overiding its variables and functions.
   * [provider2] immutable type inferred variable derived from [FancyInfoProvider2].
  */
  fun exercise011() {
    open class BasicInfoProvider : x010PersonInfoProvider3, x010SessionInfoProvider {
      override val providerInfo: String
        get() = "BasicInfoProvider"
      
      override fun printInfo(person: x009Person5) {
        super.printInfo(person)
        println("Additional Print Statement")
      }

      override fun getSessionId(): String {
        return "Session"
      }
    }
    class FancyInfoProvider: BasicInfoProvider() {
      override val providerInfo: String
        get() = "Fancy Info Provider"
      
        override fun printInfo(person: x009Person5) {
          super.printInfo(person)
          println("Fancy Info")
        }
    }
    val provider = FancyInfoProvider()
    provider.printInfo(x009Person5())
    println(provider.getSessionId())
    println()

    open class BasicInfoProvider1 : x010PersonInfoProvider3, x010SessionInfoProvider {
      override val providerInfo: String
        get() = "BasicInfoProvider"
      
      open val sessionIdPrefix = "Session"

      override fun printInfo(person: x009Person5) {
        super.printInfo(person)
        println("Additional Print Statement")
      }

      override fun getSessionId(): String {
        return sessionIdPrefix
      }
    }
    class FancyInfoProvider1: BasicInfoProvider1() {
      override val sessionIdPrefix: String
        get() = "Fancy Session"
      
      override val providerInfo: String
        get() = "Fancy Info Provider"
      
        override fun printInfo(person: x009Person5) {
          super.printInfo(person)
          println("Fancy Info")
        }
    }
    val provider1 = FancyInfoProvider1()
    provider1.printInfo(x009Person5())
    println(provider1.getSessionId())
    println()

    open class BasicInfoProvider2 : x010PersonInfoProvider3, x010SessionInfoProvider {
      override val providerInfo: String
        get() = "BasicInfoProvider"
      
      protected open val sessionIdPrefix = "Session"

      override fun printInfo(person: x009Person5) {
        super.printInfo(person)
        println("Additional Print Statement")
      }

      override fun getSessionId(): String {
        return sessionIdPrefix
      }
    }
    class FancyInfoProvider2: BasicInfoProvider2() {
      override val sessionIdPrefix: String
        get() = "Fancy Session"
      
      override val providerInfo: String
        get() = "Fancy Info Provider"
      
        override fun printInfo(person: x009Person5) {
          super.printInfo(person)
          println("Fancy Info")
        }
    }
    val provider2 = FancyInfoProvider2()
    provider2.printInfo(x009Person5())
    println(provider2.getSessionId())
    println()
  }

  /** 
   * Interfaces:
   * [x010PersonInfoProvider] interface without block.
   * [BasicInfoProvider] class inheriting from [x010PersonInfoProvider].
   * [x010PersonInfoProvider1] interface with a single function.
   * [BasicInfoProvider1] class that inherits from [x010PersonInfoProvider1] but does not override it's function.
   * [BasicInfoProvider2] class that inherits from [x010PersonInfoProvider1] and override it's function.
   * [provider2] variable derived from [BasicInfoProvider2].
   * [BasicInfoProvider3] class that inherits from [x010PersonInfoProvider1] and override it's function with additional calls.
   * [provider3] variable derived from [BasicInfoProvider2].
   * [x010PersonInfoProvider2] interface with a single function and additional calls.
   * [BasicInfoProvider4] class that inherits from [x010PersonInfoProvider2] and override it's function.
   * [provider4] variable derived from [BasicInfoProvider4].
   * [x010PersonInfoProvider3] interface with a null variable and a single function with additional calls.
   * [BasicInfoProvider5] class that inherits from [x010PersonInfoProvider3] and override it's variable and function.
   * [provider5] variable derived from [BasicInfoProvider5].
   * [BasicInfoProvider6] class that inherits from [x010PersonInfoProvider3] and override it's variable and function, then extends the function.
   * [provider6] variable derived from [BasicInfoProvider6].
   * [x010SessionInfoProvider] interface with single function.
   * [BasicInfoProvider7] class that inherits from both [x010PersonInfoProvider3] and [x010SessionInfoProvider] then override their variables and functions.
   * [provider7] variable derived from [BasicInfoProvider7].
   * [checkTypes] function with a constructor variable of type [x010PersonInfoProvider3] and checks to see if variable is of type [x010SessionInfoProvider].
   * [checkTypes1] function with a constructor variable of type [x010PersonInfoProvider3] and checks to see if variable is not of type [x010SessionInfoProvider].
   * [checkTypes2] function with a constructor variable of type [x010PersonInfoProvider3] and checks to 
   * see if variable is not of type [x010SessionInfoProvider] and if it is casts the variable to that type to run it's function.
  */
  fun exercise010() {
    class BasicInfoProvider : x010PersonInfoProvider

    abstract class BasicInfoProvider1 : x010PersonInfoProvider1
    // val provider1 = BasicInfoProvider1()

    class BasicInfoProvider2 : x010PersonInfoProvider1 {
      override fun printInfo(person: x009Person5) {
        println("printInfo")
      }
    }
    val provider2 = BasicInfoProvider2()
    provider2.printInfo(x009Person5())
    println()

    class BasicInfoProvider3 : x010PersonInfoProvider1 {
      override fun printInfo(person: x009Person5) {
        println("basicInfoProvider")
        person.printInfo()
      }
    }
    val provider3 = BasicInfoProvider3()
    provider3.printInfo(x009Person5())
    println()

    class BasicInfoProvider4 : x010PersonInfoProvider2
    val provider4 = BasicInfoProvider4()
    provider4.printInfo(x009Person5())
    println()

    class BasicInfoProvider5 : x010PersonInfoProvider3 {
      override val providerInfo: String
        get() = "BasicInfoProvider"
    }
    val provider5 = BasicInfoProvider5()
    provider5.printInfo(x009Person5())
    println()

    class BasicInfoProvider6 : x010PersonInfoProvider3 {
      override val providerInfo: String
        get() = "BasicInfoProvider"
      
      override fun printInfo(person: x009Person5) {
        super.printInfo(person)
        println("Additional Print Statement")
      }
    }
    val provider6 = BasicInfoProvider6()
    provider6.printInfo(x009Person5())
    println()

    class BasicInfoProvider7 : x010PersonInfoProvider3, x010SessionInfoProvider {
      override val providerInfo: String
        get() = "BasicInfoProvider"
      
      override fun printInfo(person: x009Person5) {
        super.printInfo(person)
        println("Additional Print Statement")
      }

      override fun getSessionId(): String {
        return "Session"
      }
    }
    val provider7 = BasicInfoProvider7()
    provider7.printInfo(x009Person5())
    println(provider7.getSessionId())
    println()

    fun checkTypes(infoProvider: x010PersonInfoProvider3) {
      if (infoProvider is x010SessionInfoProvider) {
        println("Is a session info provider")
      } else {
        println("Not a session info provider")
      }
    }
    checkTypes(provider7)
    println()

    fun checkTypes1(infoProvider: x010PersonInfoProvider3) {
      if (infoProvider !is x010SessionInfoProvider) {
        println("Not a session info provider")
      } else {
        println("Is a session info provider")
      }
    }
    checkTypes1(provider7)
    println()

    fun checkTypes2(infoProvider: x010PersonInfoProvider3) {
      if (infoProvider !is x010SessionInfoProvider) {
        println("Not a session info provider")
      } else {
        println("Is a session info provider")
        println((infoProvider as x010SessionInfoProvider).getSessionId())
        println(infoProvider.getSessionId())
      }
    }
    checkTypes2(provider7)
    println()
  }

  /** 
   * Classes - Visibility Modifiers:
   * [x009Person] class using public modifier.
   * [person] type inferred immutable vairable derived from [x009Person].
   * [x009Person1] class using internal modifier.
   * [person1] type inferred immutable vairable derived from [x009Person1].
   * [x009Person2] class using private modifier.
   * [x009Person3] class using default modifier and internal modifier on [nickName].
   * [person3] type inferred immutable vairable derived from [x009Person3].
   * [x009Person4] class using default modifier and protected modifier on [nickName].
   * [person4] type inferred immutable vairable derived from [x009Person4].
   * [x009Person5] class using default modifier and private modifier on [nickName].
   * [person5] type inferred immutable vairable derived from [x009Person5].
  */
  fun exercise009() {
    val person = x009Person()
    println(person)
    println()
    
    val person1 = x009Person1()
    println(person1)
    println()
    
    // val person2 = x009Person2()
    
    val person3 = x009Person3()
    person3.nickName = "Nate"
    person3.printInfo()
    println()

    val person4 = x009Person4()
    // person4.nickName = "Nate"
    person4.printInfo()
    println()

    val person5 = x009Person5()
    // person5.nickName = "Nate"
    person5.printInfo()
    println()
  }

  /** 
   * Classes:
   * [Person] class with no constructor.
   * [person] immutable variable derived from [Person]
   * [Person1] class with two private varaibles in a constructor.
   * [person1] immutable variable derived from [Person1].
   * [Person2] class with a constructor, two type specific variables and an init.
   * [person2] immutable variable derived from [Person2].
   * [Person3] class with a constructor and two initiated type specific variables.
   * [person3] immutable variable derived from [Person3].
   * [Person4] class with two public variables in the constructor.
   * [person4] immutable variable derived from [Person4].
   * [Person5] class with two public variables in the constructor, two init blocks and a secondary constructor.
   * [person5] and [person6] immutable variables derived from [Person5].
   * [Person6] class with two public variables having default values in the constructor.
   * [person7] immutable variable derived from [Person6].
   * [Person7] class with two public variables having default values in the constructor and a mutable variable.
   * [person8] immutable variable derived from [Person7].
   * [Person8] class with two public variables having default values in the constructor and a mutable variable with a set function.
   * [person9] immutable variable derived from [Person8].
   * [Person9] class with two public variables having default values in the constructor and a mutable variable with set and get functions.
   * [person10] immutable variable derived from [Person9].
   * [Person10] and [Person11] class with two public variables having default values in the constructor, a mutable variable with set and get functions and a printInfo function.
   * [person11] immutable variable derived from [Person10].
   * [person12] immutable variable derived from [Person11].
  */
  fun exercise008() {
    class Person 
    val person = Person()
    println(person)
    println()

    class Person1(_firstName: String, _lastName: String)
    val person1 = Person1("Nate", "Ebel")
    println("$person1")
    println()

    class Person2(_firstName: String, _lastName: String) {
      val firstName: String
      val lastName: String

      init {
        firstName = _firstName
        lastName = _lastName
      }
    }
    val person2 = Person2("Nate", "Ebel")
    println("Person2: ${person2.firstName} ${person2.lastName}")
    println()

    class Person3(_firstName: String, _lastName: String) {
      val firstName: String = _firstName
      val lastName: String = _lastName
    }
    val person3 = Person3("Nate", "Ebel")
    println("Person3: ${person3.firstName} ${person3.lastName}")
    println()

    class Person4(val firstName: String, val lastName: String) 
    val person4 = Person4("Nate", "Ebel")
    println("Person4: ${person4.firstName} ${person4.lastName}")
    println()

    class Person5(val firstName: String, val lastName: String) {
      init {
        println("Init 1")
      }
      constructor(): this("Peter", "Parker") {
        println("Secondary Constructor")
      }
      init {
        println("Init 2")
      }
    }
    val person5 = Person5("Nate", "Ebel")
    println("Person5: ${person5.firstName} ${person5.lastName}")
    println()

    val person6 = Person5()
    println("Person6: ${person6.firstName} ${person6.lastName}")
    println()

    class Person6(val firstName: String = "Peter", val lastName: String = "Parker") 
    val person7 = Person6()
    println("Person7: ${person7.firstName} ${person7.lastName}")
    println()

    class Person7(val firstName: String = "Peter", val lastName: String = "Parker") 
    {
      var nickName: String? = null
    }
    val person8 = Person7()
    person8.nickName = "Shades"
    println("Person8: ${person8.firstName} ${person8.lastName} (${person8.nickName})")
    println()

    class Person8(val firstName: String = "Peter", val lastName: String = "Parker") 
    {
      var nickName: String? = null
        set(value) {
          field = value
          println("The new nickname is $value")
        }
    }
    val person9 = Person8()
    person9.nickName = "Shades"
    person9.nickName = "New Nickname"
    println("Person9: ${person9.firstName} ${person9.lastName} (${person9.nickName})")
    println()

    class Person9(val firstName: String = "Peter", val lastName: String = "Parker") 
    {
      var nickName: String? = null
        set(value) {
          field = value
          println("The new nickname is $value")
        }
        get() {
          println("The returned value is $field")
          return field
        }
    }
    val person10 = Person9()
    person10.nickName = "Shades"
    person10.nickName = "New Nickname"
    println("Person10: ${person10.firstName} ${person10.lastName} (${person10.nickName})")
    println()

    class Person10(val firstName: String = "Peter", val lastName: String = "Parker") 
    {
      var nickName: String? = null
        set(value) {
          field = value
          println("The new nickname is $value")
        }
        get() {
          println("The returned value is $field")
          return field
        }
      
        fun printInfo() {
          val nickNameToPrint = if (nickName != null) nickName else "No Nickname"
          println("Person11: $firstName ($nickNameToPrint) $lastName")
        }
    }
    val person11 = Person10()
    person11.printInfo()

    class Person11(val firstName: String = "Peter", val lastName: String = "Parker") 
    {
      var nickName: String? = null
        set(value) {
          field = value
          println("The new nickname is $value")
        }
        get() {
          println("The returned value is $field")
          return field
        }
      
        fun printInfo() {
          val nickNameToPrint = nickName ?: "No Nickname"
          println("Person12: $firstName ($nickNameToPrint) $lastName")
        }
    }
    val person12 = Person11()
    person12.printInfo()
  }

  /** 
   * vararg, named arguments & default parameter values:
   * [sayHello] function with vararg in constructor and no return type.
   * [greetPerson] function with a constructor and no return type.
   * [greetPerson1] function with default parameters in the constructor and no return type.
   * [interestingThings] type inferred variable derived from an array of strings.
  */
  fun exercise007() {
    fun sayHello(greeting: String, vararg itemsToGreet: String) {
      itemsToGreet.forEach { itemToGreet -> println("$greeting $itemToGreet") }
    }
    sayHello("Hi")
    sayHello("Hi", "Kotlin", "Programming", "Comic Books")
    println()

    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    sayHello("Hi", *interestingThings)
    println()

    fun greetPerson(greeting: String, name: String) = println("$greeting $name")
    greetPerson(name = "Nate", greeting = "Hi")
    println()

    fun greetPerson1(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")
    greetPerson1(name = "Nate")
    greetPerson1()
    println()

    sayHello(greeting = "Hi", itemsToGreet = interestingThings)
    println()
    sayHello(itemsToGreet = interestingThings, greeting = "Hi")
    println()
  }

  /**
   * Collections & Iterations:
   * [interestingThings] immutable inferred variable derived from an array of strings.
   * [interestingThings1] immutable inferred variable derived from a list of strings.
   * [map] immutable inferred variable derived from a map of integers to strings.
   * [interestingThings2] mutable inferred variable derived from a mutable list of strings.
   * [map1] mutable inferred variable derived from a mutable map of integers to strings.
   * [sayHello] function with a collection variable in it's constructor.
   */
  fun exercise006() {
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))
    println()

    for (interestingThing in interestingThings) {
      println(interestingThing)
    }
    println()

    interestingThings.forEach { println(it) }
    println()
    interestingThings.forEach { interestingThing -> println(interestingThing) }
    println()
    interestingThings.forEachIndexed { index, interestingThing -> println("$interestingThing is at index $index") }
    println()

    val interestingThings1 = listOf("Kotlin", "Programming", "Comic Books")
    interestingThings1.forEach { interestingThing -> println(interestingThing) }
    println()

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { key, value -> println("$key -> $value") }

    val interestingThings2 = mutableListOf("Kotlin", "Programming", "Comic Books")
    interestingThings2.add("Dogs")
    
    val map1 = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    map1.put(4, "d")

    fun sayHello(greeting: String, itemsToGreet: List<String>) {
      itemsToGreet.forEach { itemToGreet -> println("$greeting $itemToGreet") }
    }
    sayHello("Hi", interestingThings1)
  }

  /** 
   * Function Parameters:
   * [sayHello] function with constructor and return type as unit.
   * [sayHello1] and [sayHello2] single line function with constructor and return type as unit.
  */
  fun exercise005() {
    fun sayHello(itemToGreet: String) {
      val msg = "Hello " + itemToGreet
      println(msg)
    }
    sayHello("Kotlin")
    sayHello("World")
    println()

    fun sayHello1(itemToGreet: String) = println("Hello $itemToGreet")
    sayHello1("Kotlin")
    sayHello1("World")
    println()

    fun sayHello2(greeting: String, itemToGreet: String) = println("$greeting $itemToGreet")
    sayHello2("Hey", "Kotlin")
    sayHello2("Hello", "World")
  }

  /** 
   * Basic Functions:
   * [getGreeting], [getGreeting1], [getGreeting2] and [sayHello] type specific functions.
   * [getGreeting1] function that can return a null.
   * [getGreeting3] and [sayHello1] type inferred functions.
   * [getGreeting2] and [getGreeting3] are single line functions.
  */
  fun exercise004() {
    fun getGreeting(): String {
      return "Hello Kotlin"
    }
    println(getGreeting())

    fun sayHello(): Unit {
      println(getGreeting())
    }
    sayHello()

    fun sayHello1() {
      println(getGreeting())
    }

    fun getGreeting1(): String? {
      return null
    }
    fun getGreeting2(): String = "Hello Kotlin"
    fun getGreeting3() = "Hello Kotlin"
  }

  /** 
   * Control Flow:
   * [x003Greeting] type specific mutable Top Level variable.
   * [x003Name] type inferred immutable Top Level variable.
   * [greetingToPrint] type inferred immutable variable derived from if condition on [x003Greeting].
   * [greetingToPrint1] type inferred immutable variable derived from when condition on [x003Greeting].
  */
  fun exercise003() {
    if (x003Greeting != null) {
      println(x003Greeting)
    } else {
      println("Hi")
    }
    println(x003Name)

    when (x003Greeting) {
      null -> println("Hi")
      else -> println(x003Greeting)
    }
    println(x003Name)

    val greetingToPrint = if (x003Greeting != null) x003Greeting else "hi"
    println(greetingToPrint)
    println(x003Name)

    val greetingToPrint1 = when (x003Greeting) {
      null -> "hi"
      else -> x003Greeting 
    }
    println(greetingToPrint1)
    println(x003Name)
  }

  /** 
   * Variables:
   * [name] type specific immutable variable.
   * [name1] type specific mutable variable.
   * [x002Greeting] type specific mutable Top Level variable.
   * [x002Name] type specific immutable Top Level variable.
   * Inferrence does not work with nullable variables.
  */
  fun exercise002() {
    val name: String = "Nate"
    var name1: String = "Nate"
    println(name1)
    name1 = ""
    println("name: $name \nname1: $name1")
    println(x002Greeting)
    println(x002Name)

    x002Greeting = "hi"
    println(x002Greeting)
    println(x002Name)
  }

  fun exercise001() {
    println("Hello Kotlin")
  }
}