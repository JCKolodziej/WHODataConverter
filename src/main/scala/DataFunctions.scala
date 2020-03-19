import scala.collection.mutable.ListBuffer

object DataFunctions {
  def CountryNamesWithBeerUnder1() : ListBuffer[Country] = {
    var listOfNames = new ListBuffer[Country]
    CountryData.countryDataList.foreach(x => {
      if((x.AvgPriceForBeer != "no data" && x.AvgPriceForBeer != "None") && x.AvgPriceForBeer.toFloat < 1){
        listOfNames += x
      }
    })
    listOfNames
  }
  def CountriesWithHigherOrEqualFemaleConsumption() : ListBuffer[Country] = {
    var listOfCountries = new ListBuffer[Country]
    CountryData.countryDataList.foreach(x => {
      if(x.MaleConsumption != "no data" && x.FemaleConsumption != "no data" && x.FemaleConsumption.toFloat >= x.MaleConsumption.toFloat)
        listOfCountries += x
    })
    listOfCountries
  }
  def CountriesWithMostExpensiveAlcohol() : List[String] = {
    var beer = 0.0
    var wine = 0.0
    var impSpirit = 0.0
    var localSpirit = 0.0
    var beerC =""
    var wineC = ""
    var impSpiritC = ""
    var localSpiritC = ""
    CountryData.countryDataList.foreach(x=> {
      if(x.AvgPriceForBeer != "None" && x.AvgPriceForBeer!="no data" && x.AvgPriceForBeer.toFloat > beer){
        beer = x.AvgPriceForBeer.toFloat.round
        beerC = x.Name
      }
      if(x.AvgPriceForWine != "None" && x.AvgPriceForWine!="no data" && x.AvgPriceForWine.toFloat > wine){
        wine = x.AvgPriceForWine.toFloat
        wineC = x.Name
      }
      if(x.AvgPriceForImpSpirit != "None" && x.AvgPriceForImpSpirit!="no data" && x.AvgPriceForImpSpirit.toFloat > impSpirit){
        impSpirit = x.AvgPriceForImpSpirit.toFloat
        impSpiritC = x.Name
      }
      if(x.AvgPriceForLocalSpirit != "None" && x.AvgPriceForLocalSpirit!="no data" && x.AvgPriceForLocalSpirit.toFloat > localSpirit){
        localSpirit = x.AvgPriceForLocalSpirit.toFloat
        localSpiritC = x.Name
      }
    })
    List("Beer " + beerC + " "  + f"$beer%1.2f" + "$",
      "Wine " + wineC + " "  + f"$wine%1.2f" + "$",
      "Imported Spirits " + impSpiritC + " "  + f"$impSpirit%1.2f" + "$",
      "Local Spirits " + localSpiritC + " "  + f"$localSpirit%1.2f" + "$")
  }
}
