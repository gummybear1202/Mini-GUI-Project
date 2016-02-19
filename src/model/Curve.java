package model;

import java.awt.*;

/**
 * Created by rosaline17 on 2/15/16.
 */
public class Curve extends Shape {

  public Curve(int x1, int y1, int x2, int y2, Color color, int stroke) {
    super(x1, y1, x2, y2, color, stroke);
  }

//  @Override
//  Curve create(int x1, int y1, int x2, int y2) {
//    return new Curve(x1, y1, x2, y2, this.getColor(), stroke);
//  }


  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public boolean equalsShape(Shape s) {
    return s.equalsCurve(this);
  }

  public boolean equalsCurve(Curve c) {
    return this.getX1() == c.getX1() &&
            this.getX2() == c.getX2() &&
            this.getY1() == c.getY1() &&
            this.getY2() == c.getY2() &&
            this.getColor() == c.getColor() &&
            this.getStroke() == c.getStroke();
  }
}
