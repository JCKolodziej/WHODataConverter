import play.api.libs.json._

import scala.collection.mutable.ListBuffer

object CountryNames {
  private val json: JsValue = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/DIMENSION/COUNTRY/DimensionValues")
  var countryList = new ListBuffer[CountryName]
  case class ResponseValue(value: List[JsValue])
  case class CountryName(Code: String, Title : String)

  implicit val responseRead: Reads[ResponseValue] = Json.reads[ResponseValue]
  implicit val countryRead: Reads[CountryName] = Json.reads[CountryName]


  def getCountryFromList(country: JsValue): Unit ={
    val countryFromValue: JsResult[CountryName] =
      Json.fromJson[CountryName](country)(countryRead)
    countryFromValue match {
      case JsSuccess(c: CountryName, path: JsPath) =>
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
