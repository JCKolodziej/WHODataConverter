import play.api.libs.json.{JsPath, JsResult, JsSuccess, JsValue, Json}

import scala.collection.mutable.ListBuffer

object AlcoholTax {
  val taxResponse = AlcoholData.alcoholTaxPercentJson
  case class jsonValues(value : List[JsValue])
  val jsonsRead = Json.reads[jsonValues]
  case class tax(SpatialDim : String, Value: String)
  val taxRead = Json.reads[tax]
  var taxList = new ListBuffer[tax]

  val taxFromJson: JsResult[jsonValues] =
    Json.fromJson[jsonValues](taxResponse)(jsonsRead)

  taxFromJson match {
    case JsSuccess(r: jsonValues, path: JsPath) =>
      for (i <- 0 to r.value.length - 1) {
        taxFromList(r.value(i))
      }
  }

  def taxFromList(tax : JsValue) = {
    val ageFromList : JsResult[tax] =
      Json.fromJson[tax](tax)(taxRead)
    ageFromList match{
      case JsSuccess(a: tax, path:JsPath) => taxList += a
    }
  }
}
