package com.nthportal
package versions
package v2

/**
 * A version of the form `major`.`minor` (such as, for example, `1.3`).
 *
 * @param major the major version number
 * @param minor the minor version number
 */
final case class Version(major: Int, minor: Int) extends VersionBase[Version, ExtendedVersion] {
  // Validate values
  require(major >= 0 && minor >= 0, "major and minor values must be >= 0")

  override private[versions] def companion = Version

  override private[versions] def extendedCompanion = ExtendedVersion

  override def toString = s"$major.$minor"
}

object Version extends VersionCompanion[Version, ExtendedVersion] with Of[Dot[Version]] {
  override private[versions] val ordering: Ordering[Version] =
    Ordering
      .by[Version, Int](_.major)
      .orElseBy(_.minor)

  override def of(major: Int): Dot[Version] = minor => apply(major, minor)

  override protected def versionFromArray = { case Array(major, minor) => apply(major, minor) }

  /**
   * Extracts a version from a string.
   *
   * @param version the string from which to extract a version
   * @return an [[Option]] containing the major and minor version numbers;
   *         [[None]] if the string did not represent a valid version
   */
  def unapply(version: String): Option[(Int, Int)] = parseAsOption(version) flatMap unapply
}
