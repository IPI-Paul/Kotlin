# Derek Banas - Kotlin Tutorials

[Learn Kotlin in one Video](https://youtu.be/H_oGi8uuDpA)

## Course Work
 - I have split the examples shown in this tutorial in to 17 exercises.
 - Unfortunately, I was not able to figure out how to dynamically generate the help list using kotlin-reflect but managed to call each exercise by method name derived from the user input.
 - As usual, Derek covers a wide range of the basics needed to get you started with programming in Kotlin. He covered it all so fast I was a bit put out when the tutorial ended, somewhat anticipating that there would be more .
 - I note from google searches that dokka is Kotlins version of java docs and in trying to follow the advise of Brandan Jones about ensuring guidline comments before classes and methods I have added them.
 - I found Kotlin easier to learn than Rust as I already have learnt mix of Java, Javascript and Rust approaches.

### To Compile
```
kotlinc KotlinTut.kt -include-runtime -d KotlinTut.jar && java -jar KotlinTut.jar
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