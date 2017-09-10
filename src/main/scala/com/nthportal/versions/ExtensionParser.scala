package com.nthportal.versions

import com.nthportal.convert.Convert

/**
  * Something which parses a version extension from a string.
  *
  * @tparam E the type of the version extension
  */
trait ExtensionParser[E] {
  /**
    * Parses a version extension from the given string.
    *
    * @param extension the string representation of the extension
    * @throws scala.IllegalArgumentException if the string provided does not
    *                                        represent a valid extension
    * @return the extension represented by the specified string
    */
  @throws[IllegalArgumentException]("if the string provided does not represent a valid extension")
  def parse(extension: String)(implicit c: Convert): c.Result[E]
}
