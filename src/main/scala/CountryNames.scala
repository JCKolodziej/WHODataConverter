import play.api.libs.json._

import scala.collection.mutable.ListBuffer

object CountryNames {
  private val json: JsValue = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/DIMENSION/COUNTRY/DimensionValues")
  var countryList = new ListBuffer[Country]
  case class ResponseValue(value: List[JsValue])
  case class Country(Code: String, Title : String)

  implicit val responseRead: Reads[ResponseValue] = Json.reads[ResponseValue]
  implicit val countryRead: Reads[Country] = Json.reads[Country]


  def getCountryFromList(country: JsValue): Unit ={
    val countryFromValue: JsResult[Country] =
      Json.fromJson[Country](country)(countryRead)
    countryFromValue match {
      case JsSuccess(c: Country, path: JsPath) =>
        countryList += c
    }
  }
// could redo it to generic later on and put it separate class, not enough time and knowledge right now
  val countryFromJson: JsResult[ResponseValue] =
    Json.fromJson[ResponseValue](json)(responseRead)

  countryFromJson match {
    case JsSuccess(r: ResponseValue, path: JsPath) =>
      for(i <- 0 to r.value.length -1){
        getCountryFromList(r.value(i))
      }
  }
}
