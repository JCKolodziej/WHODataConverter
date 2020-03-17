import play.api.libs.json.{JsValue, Json}

object dataRetriver extends App{

  val url = "https://ghoapi.azureedge.net/api/DIMENSION/COUNTRY/DimensionValues"
  val result = scala.io.Source.fromURL(url).mkString
  println(result)
  val json: JsValue = Json.parse(result)
  val whatever = (json \ "value")
  println(whatever)
  println(whatever(0)("Title"))

}
