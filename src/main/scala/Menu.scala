import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object Menu {
  var select = 0
  var goodChoice = true

  def main(args: Array[String]){
    do{
      goodChoice = true
      doMenu()
      }while(select != 0)

  }


  def doMenu(): Unit ={
      println("1 - xxxxxx\n")
      println("2 - yyyyyyy\n")
      println("0 - end\n")
    try {
      select = readLine.toInt
      select match{
        case 0 => println("see You later")
        case 1 => select1()
        case 2 => select2()
      }

    }catch{
      case e: scala.MatchError =>
        println("match error")
        goodChoice = false
      case e: NumberFormatException =>
        println("only int")
        goodChoice = false
    }

  }

  def select1 (): Unit ={
    println("see 1")
  }

  def select2 (): Unit ={
    println("see 2")
  }
}
