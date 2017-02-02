package com.nthportal.versions.semver

import _build_metadata._

/**
  * Metadata for a build, which may be appended to a
  * [[http://semver.org/spec/v2.0.0.html#spec-item-10 SemVer version]].
  */
trait BuildMetadata

object BuildMetadata {

  /**
    * Parses a string into some type of [[BuildMetadata]]
    *
    * @tparam M the type of the build metadata
    */
  trait Parser[M <: BuildMetadata] {
    /**
      * Parses a string into build metadata.
      *
      * @param metadata the string to parse
      * @throws IllegalArgumentException if the metadata is invalid
      * @return the metadata represented by the string
      */
    @throws[IllegalArgumentException]
    def parse(metadata: String): M
  }

  /**
    * Metadata represented by a string.
    *
    * @param value the metadata as a string
    */
  case class StringMetadata(value: String) extends BuildMetadata

  object StringMetadata {
    /**
      * A [[Parser]] for [[StringMetadata]].
      *
      * @return a parser for StringMetadata
      */
    implicit def buildMetadataParser: Parser[StringMetadata] = _parser(apply)
  }

}
