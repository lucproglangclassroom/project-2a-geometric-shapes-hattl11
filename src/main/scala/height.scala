package edu.luc.cs.laufer.cs371.shapes
import Shape.*

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _)         => 1
    case Ellipse(_, _)           => 1
    case Location(_, _, inner)   => 1 + apply(inner)
    case Group(children*)        => 1 + children.map(apply).max
end height
