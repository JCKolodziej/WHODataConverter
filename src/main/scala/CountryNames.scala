import play.api.libs.json.{JsError, JsPath, JsResult, JsSuccess, JsValue, Json, Reads}

import scala.collection.mutable.ListBuffer

object CountryNames {
  private val json: JsValue = dataRetriever.getDataFromUrl("https://ghoapi.azureedge.net/api/DIMENSION/COUNTRY/DimensionValues")
  var listOfCountries: JsValue = (json \ "value").as[JsValue]

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
      case e@JsError(_) =>
        println("Errors: " + JsError.toJson(e).toString())
    }
  }
  var countryList = new ListBuffer[Country]
  val residentFromJson: JsResult[ResponseValue] =
    Json.fromJson[ResponseValue](json)(responseRead)

  residentFromJson match {
    case JsSuccess(r: ResponseValue, path: JsPath) =>
      for(i <- 0 to r.value.length -1){
        getCountryFromList(r.value(i))

      }


    case e@JsError(_) =>
      println("Errors: " + JsError.toJson(e).toString())
  }

//  countryList.foreach(country => println(country.Title))
}
