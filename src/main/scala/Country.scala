class Country(
             var Code: String,
             var Name: String,
             var DrinkingAge: String,
             var LegalLimitForGenPop: String,
             var LegalLimitForYoungDrivers: String,
             var LegalLimitForProfDrivers: String,
             var AvgPriceForBeer: String,
             var AvgPriceForLocalSpirit: String,
             var AvgPriceForImpSpirit: String,
             var AvgPriceForWine: String,
             var Tax: String,
             var MaleConsumption: String,
             var FemaleConsumption: String
             ) {
  if(AvgPriceForBeer.contains("Some")) {
    AvgPriceForBeer = AvgPriceForBeer.substring(5, AvgPriceForBeer.length-1)
  }
  if(AvgPriceForLocalSpirit.contains("Some")) {
    AvgPriceForLocalSpirit = AvgPriceForLocalSpirit.substring(5, AvgPriceForLocalSpirit.length-1)
  }
  if(AvgPriceForImpSpirit.contains("Some")) {
    AvgPriceForImpSpirit = AvgPriceForImpSpirit.substring(5, AvgPriceForImpSpirit.length-1)
  }
  if(AvgPriceForWine.contains("Some")) {
    AvgPriceForWine = AvgPriceForWine.substring(5, AvgPriceForWine.length-1)
  }
  if(MaleConsumption.contains("[")){
    if(MaleConsumption.exists(_.isDigit)){
      MaleConsumption = MaleConsumption.split("\\s")(0)
    }
    else{
      MaleConsumption = "no data"
    }
  }
  if(FemaleConsumption.contains("[")){
    if(FemaleConsumption.exists(_.isDigit)){
      FemaleConsumption = FemaleConsumption.split("\\s")(0)
    }
    else{
      FemaleConsumption = "no data"
    }
  }



}
