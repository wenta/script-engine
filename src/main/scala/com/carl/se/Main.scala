package com.carl.se

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn

object Main {
  val hashMap = ScriptLoader.load()

  def main(args: Array[String]) {

    implicit val system = ActorSystem("script-engine")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val route =
      path("api" / "execute") {
        post {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "{result: 23}\n"))
        }
      }

    val bindingFuture = Http().bindAndHandle(route, "0.0.0.0", 8080)

    println(s"Server online at http://localhost:8080/\nPress Ctrl-C to stop...")
    while (true) {
      StdIn.readLine() // let it run until user presses return
    }
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}