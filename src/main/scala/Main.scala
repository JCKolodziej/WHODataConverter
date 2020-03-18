

object Main extends App {
  CountryNames.countryList.foreach(country => println(country.Code + " " +  country.Title))
}
