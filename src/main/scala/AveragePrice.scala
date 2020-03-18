import play.api.libs.json.{JsPath, JsResult, JsSuccess, JsValue, Json}

import scala.collection.mutable.ListBuffer

object AveragePrice {
  val averagePriceResponse = AlcoholData.avgPriceForAlcoholJson
  case class jsonValues(value : List[JsValue])
  val jsonsRead = Json.reads[jsonValues]
  case class avgPrice(SpatialDim : String, Value: Option[String], Dim1: String)
  val priceRead = Json.reads[avgPrice]
  var avgPriceList = new ListBuffer[avgPrice]

  val avgPriceFromJson: JsResult[jsonValues] =
    Json.fromJson[jsonValues](averagePriceResponse)(jsonsRead)

  avgPriceFromJson match {
    case JsSuccess(r: jsonValues, path: JsPath) =>
      for (i <- 0 to r.value.length - 1) {
        getavgPriceToList(r.value(i))
      }
  }

  def getavgPriceToList(price : JsValue) = {
    val ageFromList : JsResult[avgPrice] =
      Json.fromJson[avgPrice](price)(priceRead)
    ageFromList match{
      case JsSuccess(a: avgPrice, path:JsPath) => avgPriceList += a
    }
  }
}
