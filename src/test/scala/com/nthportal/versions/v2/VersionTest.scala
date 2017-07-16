package com.nthportal.versions
package v2

class VersionTest extends SimpleSpec {

  behavior of "Version (2)"

  it should "have consistent constructors" in {
    val v = Version ⋮ 1⋅3
    v should equal (Version(1)(3))
    v should equal (Version :> 1 :* 3)
    v should equal (Version of 1 dot 3)
    v should equal (Version(1, 3))
  }

  it should "not allow negative version values" in {
    an [IllegalArgumentException] should be thrownBy {Version(-1)(0)}
    an [IllegalArgumentException] should be thrownBy {Version(0)(-1)}
  }

  it should "compare correctly" in {
    val v = Version ⋮ 1⋅3

    v should be > Version(1)(2)
    v should be > Version(0)(9)

    v should be < Version(1)(4)
    v should be < Version(2)(0)
  }

  it should "produce the correct string representation" in {
    Version(1)(3).toString should be ("1.3")
  }

  it should "parse versions correctly" in {
    Version parseVersion "1.3" should equal (Version ⋮ 1⋅3)
    Version parseVersion "0.0" should equal (Version ⋮ 0⋅0)

    a [VersionFormatException] should be thrownBy {Version parseVersion "1.0."}
    a [VersionFormatException] should be thrownBy {Version parseVersion "-1.0"}
    a [VersionFormatException] should be thrownBy {Version parseVersion "1"}
    a [VersionFormatException] should be thrownBy {Version parseVersion "1.0.0"}
    a [VersionFormatException] should be thrownBy {Version parseVersion "1.f"}
    a [VersionFormatException] should be thrownBy {Version parseVersion "really not a version"}
  }
}
