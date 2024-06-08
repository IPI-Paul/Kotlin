
class Comments {
  fun getComments(): MutableList<String> {
    var comments: MutableList<String> = mutableListOf()
    comments.add("""
      * HelloKotlin
      * Prints out Hello Kotlin.
    """)
    comments.add("""
      * Variables:
      * [name] type specific immutable variable.
      * [name1] type specific mutable variable.
      * [x002Greeting] type specific mutable Top Level variable.
      * [x002Name] type specific immutable Top Level variable.
      * Inferrence does not work with nullable variables.
    """)
    comments.add("""
      * Control Flow:
      * [x003Greeting] type specific mutable Top Level variable.
      * [x003Name] type inferred immutable Top Level variable.
      * [greetingToPrint] type inferred immutable variable derived from if condition on [x003Greeting].
      * [greetingToPrint1] type inferred immutable variable derived from when condition on [x003Greeting].
    """)
    comments.add("""
      * Basic Functions:
      * [getGreeting], [getGreeting1], [getGreeting2] and [sayHello] type specific functions.
      * [getGreeting1] function that can return a null.
      * [getGreeting3] and [sayHello1] type inferred functions.
      * [getGreeting2] and [getGreeting3] are single line functions.
    """)
    comments.add("""
      * Function Parameters:
      * [sayHello] function with constructor and return type as unit.
      * [sayHello1] and [sayHello2] single line function with constructor and return type as unit.
    """)
    comments.add("""
      * Collections & Iterations:
      * [interestingThings] immutable inferred variable derived from an array of strings.
      * [interestingThings1] immutable inferred variable derived from a list of strings.
      * [map] immutable inferred variable derived from a map of integers to strings.
      * [interestingThings2] mutable inferred variable derived from a mutable list of strings.
      * [map1] mutable inferred variable derived from a mutable map of integers to strings.
      * [sayHello] function with a collection variable in it's constructor.
    """)
    comments.add("""
      * vararg, named arguments & default parameter values:
      * [sayHello] function with vararg in constructor and no return type.
      * [greetPerson] function with a constructor and no return type.
      * [greetPerson1] function with default parameters in the constructor and no return type.
      * [interestingThings] type inferred variable derived from an array of strings.
    """)
    comments.add("""
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
    """)
    comments.add("""
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
    """)
    comments.add("""
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
    """)
    comments.add("""
      * Class Inherittance:
      * [BasicInfoProvider], [BasicInfoProvider1] and [BasicInfoProvider2] open classes that inherits from [x010PersonInfoProvider3] and [x010SessionInfoProvider] overiding their variables and functions.
      * [FancyInfoProvider] class that inherits from [BasicInfoProvider] overiding its variables and functions.
      * [provider] immutable type inferred variable derived from [FancyInfoProvider].
      * [FancyInfoProvider1] class that inherits from [BasicInfoProvider1] overiding its variables and functions.
      * [provider1] immutable type inferred variable derived from [FancyInfoProvider1].
      * [FancyInfoProvider2] class that inherits from [BasicInfoProvider2] overiding its variables and functions.
      * [provider2] immutable type inferred variable derived from [FancyInfoProvider2].
    """)
    comments.add("""
      * Object Expressions:
      * [provider] immutable type inferred variable derived from an anonymous class object that inherits from [x010PersonInfoProvider3].
    """)
    comments.add("""
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
    """)
    comments.add("""
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
    """)
    comments.add("""
      * Sealed Classes:
      * [x015EntityType] enum class with four constants and a function.
      * [x015Entity] sealed class with an object and four data classes.
      * [x015EntityFactory] object declaration whose create function takes [x015EntityType] and inherits from [x015Entity].
      * [entity] and [entity1] type inferred immutable variables derived from [x015EntityFactory].
    """)
    comments.add("""
      * Data Classes:
      * [x015EntityType] enum class with four constants and a function.
      * [x015Entity] sealed class with an object and four data classes.
      * [x015EntityFactory] object declaration whose create function takes [x015EntityType] and inherits from [x015Entity].
      * [entity1] to [entity10] type inferred immutable variables derived from [x015EntityFactory].
    """)
    comments.add("""
      * Extension Functions / Properties:
      * [x015EntityType] enum class with four constants and a function.
      * [x015Entity] sealed class with an object and four data classes extended with a function [printInfo] and a property [info].
      * [x015EntityFactory] object declaration whose create function takes [x015EntityType] and inherits from [x015Entity].
      * [entity] type inferred immutable variable derived from [x015EntityFactory].
    """)
    comments.add("""
      * Advanced Functions - Higher Order Functions:
      * [printFilteredStrings] function that takes a list and a function in its constructor.
      * [list] list of strings.
      * [printFilteredStrings] function that takes a list and a function or a null in its constructor.
      * [predicate] type inferred immutable variable of a functional type.
      * [getPrintPredicate] function that returns an anonymous function which takes a string.
      * [list1] list of strings.
      * [map] map of strings derived calling .associate on [list1].
      * [language] to [language6] type inferred immutable variables derived from Kotlin library methods/functions on [list1].
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