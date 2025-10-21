package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import org.slf4j.LoggerFactory

object boundingBox:
  // simple named logger to avoid getClass quirks
  private val log = LoggerFactory.getLogger("boundingBox")

  def apply(s: Shape): Location =
    s match
      case Rectangle(w, h) =>
        log.debug(s"Computing bbox for Rectangle($w, $h)")
        Location(0, 0, Rectangle(w, h))  // <-- last expr returns Location

      case Ellipse(rx, ry) =>
        log.debug(s"Computing bbox for Ellipse($rx, $ry)")
        Location(0, 0, Rectangle(2 * rx, 2 * ry))

      case Location(x, y, inner) =>
        val Location(x0, y0, rect) = apply(inner)
        log.debug(s"Shifting bbox by ($x, $y)")
        Location(x + x0, y + y0, rect)

      case Group(children*) =>
        log.info(s"Computing bbox for Group of ${children.size} shapes")
        val boxes   = children.map(apply) // Seq[Location]
        val lefts   = boxes.map(_.x)
        val tops    = boxes.map(_.y)
        val rights  = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width)
        val bottoms = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height)

        val minX = lefts.min
        val minY = tops.min
        val maxX = rights.max
        val maxY = bottoms.max

        val rect = Rectangle(maxX - minX, maxY - minY)
        log.debug(s"Result bbox: Location($minX, $minY, $rect)")
        Location(minX, minY, rect)        // <-- last expr returns Location
end boundingBox
