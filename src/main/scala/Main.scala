

object Main extends App {
  val json = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/DIMENSION/COUNTRY/DimensionValues")
  var listOfCountries = (json \ "value" \ 1).get
  println(json)
  println(listOfCountries)
}
