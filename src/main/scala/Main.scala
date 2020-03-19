

object Main extends App {
//  CountryNames.countryList.foreach(country => println(country.Code + " " +  country.Title))
//  MinimalDrinkingAge.minAgeList.foreach(age => println(age.SpatialDim + " " + age.Value))
//  LegalBloodAlcohol.legalBloodLevelList.foreach(level => println(level.SpatialDim + " " + level.Dim1 + " " + level.Value))
//  AveragePrice.avgPriceList.foreach(level => println(level.SpatialDim + " " + level.Dim1 + " " + level.Value))
//  AlcoholTax.taxList.foreach(age => println(age.SpatialDim + " " + age.Value))
//  Consumption.consumptionList.foreach(level => println(level.SpatialDim + " " + level.Dim1 + " " + level.Value))
//  CountryData.countryDataList.foreach(x => println(x.Name + " Female " +  x.FemaleConsumption + " Male " +  x.MaleConsumption))
//  DataFunctions.CountryNamesWithBeerUnder1().foreach(x => println(x))
//  DataFunctions.CountriesWithHigherOrEqualFemaleConsumption().foreach(x => println(x.Name))
  DataFunctions.CountriesWithMostExpensiveAlcohol().foreach(x => println(x))
}
