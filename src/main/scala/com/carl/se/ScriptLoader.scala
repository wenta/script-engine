package com.carl.se

import java.io.File
import scala.io.Source

object ScriptLoader {

  def load(): Array[String] = {
    val dir = new File("scripts")
    dir.listFiles
      .filter(x => x.isFile && x.getName.endsWith(".fs")) //.toList.filter()
      .map(convert)
  }

  def convert(f: File): String = {
    Source.fromFile(f).mkString
  }

}