import play.api.libs.json.{JsPath, JsResult, JsSuccess, JsValue, Json}

import scala.collection.mutable.ListBuffer

object LegalBloodAlcohol {
  val legalBloodResponse = AlcoholData.legalBloodAlcoholJson
  case class jsonValues(value : List[JsValue])
  val jsonsRead = Json.reads[jsonValues]
  case class bloodLevel(SpatialDim : String, Value: String, Dim1: String)
  val levelRead = Json.reads[bloodLevel]
  var legalBloodLevelList = new ListBuffer[bloodLevel]

  val limitFromJson: JsResult[jsonValues] =
    Json.fromJson[jsonValues](legalBloodResponse)(jsonsRead)

  limitFromJson match {
    case JsSuccess(r: jsonValues, path: JsPath) =>
      for (i <- 0 to r.value.length - 1) {
        getLimitToList(r.value(i))
      }
  }

  def getLimitToList(age : JsValue) = {
    val ageFromList : JsResult[bloodLevel] =
      Json.fromJson[bloodLevel](age)(levelRead)
    ageFromList match{
      case JsSuccess(a: bloodLevel, path:JsPath) => legalBloodLevelList += a
    }
  }
}
