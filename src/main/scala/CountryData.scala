import scala.collection.mutable.ListBuffer

object CountryData {
  var countryDataList = new ListBuffer[Country]
  CountryNames.countryList.foreach(country => {
    val Code = country.Code
    var age = "no data"
    var genPopLimit = "no data"
    var youngDriverLimit = "no data"
    var profDriverLimit = "no data"
    var beerAvgPrice = "no data"
    var localSpiritAvgPrice = "no data"
    var importedSpiritAvgPrice = "no data"
    var wineAvgPrice = "no data"
    var taxValue = "no data"
    var maleConsumption = "no data"
    var femaleConsumption = "no data"

    val ageList = MinimalDrinkingAge.minAgeList.filter(x => x.SpatialDim == Code)
    if(ageList.nonEmpty){age = ageList(0).Value}
    val genPopLimitList = LegalBloodAlcohol.legalBloodLevelList.filter(x => x.SpatialDim == Code && x.Dim1 == "SA_GENERAL_POPULATION")
    if(genPopLimitList.nonEmpty) {genPopLimit = genPopLimitList(0).Value}
    val youngDriverLimitList = LegalBloodAlcohol.legalBloodLevelList.filter(x => x.SpatialDim == Code && x.Dim1 == "SA_YOUNG_NOVICE_DRIVERS")
    if(youngDriverLimitList.nonEmpty) {youngDriverLimit = youngDriverLimitList(0).Value}
    val profDriverLimitList = LegalBloodAlcohol.legalBloodLevelList.filter(x => x.SpatialDim == Code && x.Dim1 == "SA_PROFESS_COMMERCE_DRIVERS")
    if(profDriverLimitList.nonEmpty) {profDriverLimit = profDriverLimitList(0).Value}
    val beerAvgPriceList = AveragePrice.avgPriceList.filter(x=> x.SpatialDim == Code && x.Dim1 == "SA_500_POPULAR_BEER")
    if(beerAvgPriceList.nonEmpty) {beerAvgPrice = beerAvgPriceList(0).Value.toString}
    val localSpiritAvgPriceList = AveragePrice.avgPriceList.filter(x=> x.SpatialDim == Code && x.Dim1 == "SA_750_POPULAR_LOCAL_SPIRITS")
    if(localSpiritAvgPriceList.nonEmpty) {localSpiritAvgPrice = localSpiritAvgPriceList(0).Value.toString}
    val importedSpiritAvgPriceList = AveragePrice.avgPriceList.filter(x=> x.SpatialDim == Code && x.Dim1 == "SA_750_POPULAR_IMPORTED_SPIRITS")
    if(importedSpiritAvgPriceList.nonEmpty) {importedSpiritAvgPrice = importedSpiritAvgPriceList(0).Value.toString}
    val wineAvgPriceList = AveragePrice.avgPriceList.filter(x=> x.SpatialDim == Code && x.Dim1 == "SA_750_TABLE_WINE")
    if(wineAvgPriceList.nonEmpty) {wineAvgPrice = wineAvgPriceList(0).Value.toString}
    val taxValueList = AlcoholTax.taxList.filter(x => x.SpatialDim == Code)
    if(taxValueList.nonEmpty) {taxValue = taxValueList(0).Value}
    val maleConsumptionList = Consumption.consumptionList.filter(x => x.SpatialDim == Code && (x.Dim1 == "MLE" || x.Dim1 == "BTSX"))
    if(maleConsumptionList.nonEmpty) {maleConsumption = maleConsumptionList(0).Value}
    val femaleConsumptionList = Consumption.consumptionList.filter(x => x.SpatialDim == Code && (x.Dim1 == "FMLE" || x.Dim1 == "BTSX"))
    if(femaleConsumptionList.nonEmpty) {femaleConsumption = femaleConsumptionList(0).Value}


    countryDataList += new Country(
      Code,
      country.Title,
      age,
      genPopLimit,
      youngDriverLimit,
      profDriverLimit,
      beerAvgPrice,
      localSpiritAvgPrice,
      importedSpiritAvgPrice,
      wineAvgPrice,
      taxValue,
      maleConsumption,
      femaleConsumption
    )

  })
}
