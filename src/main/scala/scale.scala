package edu.luc.cs.laufer.cs371.shapes
import Shape.*

object scale:
  def apply(s: Shape, k: Int): Shape = s match
    case Rectangle(w, h)         => Rectangle(k * w, k * h)
    case Ellipse(rx, ry)         => Ellipse(k * rx, k * ry)
    case Location(x, y, inner)   => Location(k * x, k * y, apply(inner, k))
    case Group(children*)        => Group(children.map(ch => apply(ch, k))*)
end scale
