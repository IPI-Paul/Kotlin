import java.util.UUID

object x015EntityFactory {
  fun create(type: x015EntityType): x015Entity {
    val id = UUID.randomUUID().toString()
    val name = when (type) {
      x015EntityType.EASY -> type.name
      x015EntityType.MEDIUM -> type.getFormattedName()
      x015EntityType.HARD -> "Hard"
      x015EntityType.HELP -> type.getFormattedName()
    }
    return when (type) {
      x015EntityType.EASY -> x015Entity.Easy(id, name)
      x015EntityType.MEDIUM -> x015Entity.Medium(id, name)
      x015EntityType.HARD -> x015Entity.Hard(id, name, 2f)
      x015EntityType.HELP -> x015Entity.Help
    }
  }
}

object x014EntityFactory4 {
  fun create(type: x014EntityType1): x014Entity1 {
    val id = UUID.randomUUID().toString()
    val name = when (type) {
      x014EntityType1.EASY -> type.name
      x014EntityType1.MEDIUM -> type.getFormattedName()
      x014EntityType1.HARD -> "Hard"
    }
    return x014Entity1(id, name)
  }
}

object x014EntityFactory3 {
  fun create(type: x014EntityType): x014Entity1 {
    val id = UUID.randomUUID().toString()
    val name = when (type) {
      x014EntityType.EASY -> type.name
      x014EntityType.MEDIUM -> "Medium"
      x014EntityType.HARD -> "Hard"
    }
    return x014Entity1(id, name)
  }
}

object x014EntityFactory2 {
  fun create(type: x014EntityType): x014Entity1 {
    val id = UUID.randomUUID().toString()
    val name = when (type) {
      x014EntityType.EASY -> "Easy"
      x014EntityType.MEDIUM -> "Medium"
      x014EntityType.HARD -> "Hard"
    }
    return x014Entity1(id, name)
  }
}

object x014EntityFactory1 {
  fun create() = x014Entity1("id", "name")
}

object x014EntityFactory {
  fun create() = x014Entity("id")
}