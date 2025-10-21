package edu.luc.cs.laufer.cs371.shapes
import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*
import scale.apply as sc

class TestScale extends AnyFunSuite {
  test("scale rectangle x2") {
    assertResult(Rectangle(160, 240))(sc(simpleRectangle, 2))
  }
  test("scale location x2") {
    assertResult(Location(140, 60, Rectangle(160, 240)))(sc(simpleLocation, 2))
  }
  test("scale basic group x3") {
    val scaled = sc(basicGroup, 3)
    assertResult(Group(Ellipse(150, 90), Rectangle(60, 120)))(scaled)
  }
}
