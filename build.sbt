import sbt.librarymanagement.DependencyBuilders

name := "WHO_Data_Converter"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += DependencyBuilders.stringToOrganization("com.typesafe.play") %% "play-json" % "2.8.1"