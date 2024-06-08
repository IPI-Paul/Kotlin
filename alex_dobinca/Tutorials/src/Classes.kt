// exercise013 =>
class Calculator1() {
  companion object {
    fun sum(a: Int, b: Int) = a + b
  }
}

class Database private constructor() {
  companion object {
    private var instance: Database? = null

    fun getInstance(): Database? {
      if (instance == null) {
        instance = Database()
      }
      return instance
    }
  }
}

object Database1 {
  init {
    println("Database created")
  }
}

enum class Direction {
  NORTH,
  SOUTH,
  EAST,
  WEST
}

enum class Direction1(var direction: String, var distance: Int) {
  NORTH("north", 10),
  SOUTH("south", 20),
  EAST("east", 15),
  WEST("west", 40);

  fun printData() {
    println("Name: $name \nDirection: $direction \nDistance: $distance\n")
  }
}


enum class Result {
  SUCCESS,
  ERROR();
}

sealed class Result1(val message: String) {
  fun showMessage() {
    println("Result: $message")
  }
  class Success(message: String): Result1(message)
  class Error(message: String): Result1(message)
  class Progress(message: String): Result1(message)
}

sealed class Result2(val message: String) {
  fun showMessage() {
    println("Result: $message")
  }
  class Success(message: String): Result2(message)
  sealed class Error(message: String): Result2(message) {
    class RecoverableError(exception: Exception, message: String): Error(message)
    class NonRecoverableError(exception: Exception, message: String): Error(message)
  }
  class Progress(message: String): Result2(message)
}
// <= exercise013