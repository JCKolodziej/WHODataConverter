import play.api.libs.json.{JsPath, JsResult, JsSuccess, JsValue, Json}

import scala.collection.mutable.ListBuffer

object Consumption {
  val consumptionResponse = AlcoholData.alcoholConsumptionPerCapita
  case class jsonValues(value : List[JsValue])
  val jsonsRead = Json.reads[jsonValues]
  case class consumption(SpatialDim : String, Value: String, Dim1: String)
  val consumRead = Json.reads[consumption]
  var consumptionList = new ListBuffer[consumption]

  val consumptionFromJson: JsResult[jsonValues] =
    Json.fromJson[jsonValues](consumptionResponse)(jsonsRead)

  consumptionFromJson match {
    case JsSuccess(r: jsonValues, path: JsPath) =>
      for (i <- 0 to r.value.length - 1) {
        getConsumptionToList(r.value(i))
      }
  }

  def getConsumptionToList(cons : JsValue) = {
    val ageFromList : JsResult[consumption] =
      Json.fromJson[consumption](cons)(consumRead)
    ageFromList match{
      case JsSuccess(a: consumption, path:JsPath) => consumptionList += a
    }
  }
}

