interface x013IdProvider {
  fun getId(): String
}

interface x010SessionInfoProvider {
  fun getSessionId(): String
}

interface x010PersonInfoProvider3 {
  val providerInfo: String
  fun printInfo(person : x009Person5) {
    println(providerInfo)
    person.printInfo()
  }
} 

interface x010PersonInfoProvider2 {
  fun printInfo(person : x009Person5) {
    println("basicInfoProvider")
    person.printInfo()
  }
} 

interface x010PersonInfoProvider1 {
  fun printInfo(person : x009Person5)
} 

interface x010PersonInfoProvider 