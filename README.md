# versions

[![Build Status](https://travis-ci.org/NthPortal/versions.svg?branch=master)](https://travis-ci.org/NthPortal/versions)
[![Coverage Status](https://coveralls.io/repos/github/NthPortal/versions/badge.svg?branch=master)](https://coveralls.io/github/NthPortal/versions?branch=master)
[![Maven Central](https://img.shields.io/maven-central/v/com.nthportal/versions_2.13.svg)](https://mvnrepository.com/artifact/com.nthportal/versions_2.13)
[![Versioning](https://img.shields.io/badge/versioning-semver%202.0.0-blue.svg)](http://semver.org/spec/v2.0.0.html)
[![Docs](https://www.javadoc.io/badge/com.nthportal/versions_2.13.svg?color=blue&label=docs)](https://www.javadoc.io/doc/com.nthportal/versions_2.13)

A Scala library for representing versions as objects.

This library is in maintenance-only mode; it is slated for deprecation when
[`v`](https://github.com/NthPortal/v) is stable and feature-complete (or
surpasses this library's features), and will not receive any new feature
updates. As of the time this paragraph was last updated (2020-09-05),
`v` supports basic versions (e.g. `1.0.2`), but does not support more
complex versions (e.g. `1.0-alpha`). If you are an author/maintainer of an
application, script or private library, and `v` supports the features
you need, we strongly recommended that you use `v` instead. That being said,
PRs for basic maintenance (such as updating dependencies) will likely
be accepted.

## Add as a Dependency

### SBT

```sbtshell
libraryDependencies += "com.nthportal" %% "versions" % "2.0.2"
```

## Usage and Examples

See `usage-guide.md` for usage and examples.
