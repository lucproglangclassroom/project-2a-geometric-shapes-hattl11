package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h))

    case Ellipse(rx, ry) =>
      Location(0, 0, Rectangle(2 * rx, 2 * ry)) // diameters

    case Location(x, y, inner) =>
      val Location(x0, y0, Rectangle(w, h)) = apply(inner)
      Location(x + x0, y + y0, Rectangle(w, h))

    case Group(children*) =>
      val boxes = children.map(apply) // Seq[Location]
      // left/top/right/bottom per child
      val lefts   = boxes.map(_.x)
      val tops    = boxes.map(_.y)
      val rights  = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width)
      val bottoms = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height)

      val minX = lefts.min
      val minY = tops.min
      val maxX = rights.max
      val maxY = bottoms.max

      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
end boundingBox
