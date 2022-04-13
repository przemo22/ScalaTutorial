package com.app.learning

object StringExtension {

  extension (str: String) {
    def toSnakeCase() ={
      str.replaceAll("([A-Z])", "_" + "$1").toLowerCase
    }
    //many more methods
  }
}
