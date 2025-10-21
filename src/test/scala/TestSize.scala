package edu.luc.cs.laufer.cs371.shapes
import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import size.apply as sz

class TestSize extends AnyFunSuite {
  test("rectangle is size 1")      { assertResult(1)(sz(simpleRectangle)) }
  test("ellipse is size 1")        { assertResult(1)(sz(simpleEllipse)) }
  test("location keeps size")      { assertResult(1)(sz(simpleLocation)) }
  test("basic group size 2")       { assertResult(2)(sz(basicGroup)) }
  test("simple group size 2")      { assertResult(2)(sz(simpleGroup)) }
  test("complex group size 5")     { assertResult(5)(sz(complexGroup)) }
}
