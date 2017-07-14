package com.carl.se

import com.carl.sf.Compiler
import java.io.File
import com.carl.sf.compiler.AST.Module
import scala.io.Source

object ScriptLoader {

  def load(): Seq[Module] = {
    val dir = new File("scripts")
    dir.listFiles
      .filter(x => x.isFile && x.getName.endsWith(".fs"))
      .map(convert)
      .flatMap(compile)
  }

  def convert(f: File): String = {
    Source.fromFile(f).mkString
  }

  def compile(code: String): Option[Module] = {
    Compiler.compile(code, Seq()).toOption
  }

}