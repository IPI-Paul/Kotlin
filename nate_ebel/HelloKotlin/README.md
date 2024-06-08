# Nate Ebel - Kotlin Tutorials

[Kotlin Course - tutorial for beginners](https://m.youtube.com/watch?v=F9UC9DY-vIU)

## Course Work
 - I have split the examples shown in this tutorial in to individual exercises.
 - Unfortunately, I was still not able to figure out how to dynamically generate the help list using kotlin-reflect but managed to call each exercise by method name derived from the user input.
 - This course complemented the two other courses without the feeling of having covered the same points.
 - I learnt about the requirements of classes, functions, object declarations, extension functions/properties and top level variables.
 - The course also help clarify when a constructor variable is not visible and when it becomes visible.

### To Compile
```
kotlinc Main.kt Classes.kt Comments.kt Interfaces.kt ObjectDeclarations.kt ExtensionFunctions-Properties.kt TopLevelVars.kt -include-runtime -d Main.jar
```

### Interactive Mode
```
java -jar KotlinTut.jar
```

### List Exercises
```
java -jar KotlinTut.jar h
```

### Run Last Exercise
```
java -jar KotlinTut.jar l
```

### Run Specified Exercise
```
java -jar KotlinTut.jar 1
```