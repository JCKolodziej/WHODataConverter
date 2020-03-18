object AlcoholData {
  val minAgeJson = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/SA_0000001519")
  val legalBloodAlcoholJson = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/SA_0000001520")
  val avgPriceForAlcoholJson = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/SA_0000001523")
  val alcoholTaxPercentJson = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/SA_0000001551")
  val alcoholConsumptionPerCapita = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/SA_0000001404")
}
