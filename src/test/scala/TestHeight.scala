package edu.luc.cs.laufer.cs371.shapes
import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import height.apply as ht

class TestHeight extends AnyFunSuite {
  test("rectangle height 1")    { assertResult(1)(ht(simpleRectangle)) }
  test("ellipse height 1")      { assertResult(1)(ht(simpleEllipse)) }
  test("location height 2")     { assertResult(2)(ht(simpleLocation)) }
  test("basic group height 2")  { assertResult(2)(ht(basicGroup)) }
  test("simple group height 3") { assertResult(3)(ht(simpleGroup)) }
  test("complex group height 6"){ assertResult(6)(ht(complexGroup)) }
}
