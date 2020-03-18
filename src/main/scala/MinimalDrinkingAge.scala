import play.api.libs.json.{JsPath, JsResult, JsSuccess, JsValue, Json}

import scala.collection.mutable.ListBuffer

object MinimalDrinkingAge {
  val minDrinkAgeResponseList = AlcoholData.minAgeJson
  case class jsonValues(value : List[JsValue])
  val jsonsRead = Json.reads[jsonValues]
  case class minAge(SpatialDim : String, Value: String)
  val ageRead = Json.reads[minAge]
  var minAgeList = new ListBuffer[minAge]

  val minAgeFromJson: JsResult[jsonValues] =
    Json.fromJson[jsonValues](minDrinkAgeResponseList)(jsonsRead)

  minAgeFromJson match {
    case JsSuccess(r: jsonValues, path: JsPath) =>
      for (i <- 0 to r.value.length - 1) {
        getMinAgeToList(r.value(i))
      }
  }

  def getMinAgeToList(age : JsValue) = {
    val ageFromList : JsResult[minAge] =
      Json.fromJson[minAge](age)(ageRead)
    ageFromList match{
      case JsSuccess(a: minAge, path:JsPath) => minAgeList += a
    }
  }
}
