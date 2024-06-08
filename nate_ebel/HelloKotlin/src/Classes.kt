sealed class x015Entity() {
  object Help: x015Entity() {
    val name = "Help"
  }
  data class Easy(val id: String, val name: String): x015Entity()
  data class Medium(val id: String, val name: String): x015Entity()
  data class Hard(val id: String, val name: String, val multiplier: Float): x015Entity()
}

enum class x015EntityType {
  HELP, EASY, MEDIUM, HARD;

  fun getFormattedName() = name.lowercase().replaceFirstChar { x -> x.uppercase() }
}

enum class x014EntityType1 {
  EASY, MEDIUM, HARD;

  fun getFormattedName() = name.lowercase().replaceFirstChar { x -> x.uppercase() }
}

enum class x014EntityType {
  EASY, MEDIUM, HARD
}

class x014Entity1(val id: String, val name: String) {
  override fun toString(): String {
    return "id: $id name:$name"
  }
}

class x014Entity(val id: String) 

class x013Entity3 private constructor(val id: String){
  companion object Factory: x013IdProvider {
    override fun getId(): String {
      return "123"
    }
    const val id = "id"
    fun create() = x013Entity3(getId())
  }
}

class x013Entity2 private constructor(val id: String){
  companion object Factory {
    const val id = "id"
    fun create() = x013Entity2(id)
  }
}

class x013Entity1 private constructor(val id: String){
  companion object Factory {
    fun create() = x013Entity1("id")
  }
}

class x013Entity private constructor(val id: String){
  companion object {
    fun create() = x013Entity("id")
  }
}

class x009Person5(val firstName: String = "Peter", val lastName: String = "Parker") 
{
  private var nickName: String? = null
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
      println("Person5: $firstName ($nickNameToPrint) $lastName")
    }
}

class x009Person4(val firstName: String = "Peter", val lastName: String = "Parker") 
{
  protected var nickName: String? = null
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
      println("Person4: $firstName ($nickNameToPrint) $lastName")
    }
}

class x009Person3(val firstName: String = "Peter", val lastName: String = "Parker") 
{
  internal var nickName: String? = null
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
      println("Person3: $firstName ($nickNameToPrint) $lastName")
    }
}

private class x009Person2
internal class x009Person1
public class x009Person