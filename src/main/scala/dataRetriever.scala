import play.api.libs.json.{JsValue, Json}

object dataRetriever extends App{
    def getDataFromUrl(url : String) : JsValue = {
      val result = scala.io.Source.fromURL(url).mkString
      Json.parse(result)

    }


}
