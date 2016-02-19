package model;

import java.awt.*;

/**
 * Created by rosaline17 on 2/15/16.
 */
public class Oval extends Shape {
  private final int width;
  private final int height;

  public Oval(int x1, int y1, int x2, int y2, Color color, int stroke) {
    super(x1, y1, x2, y2, color, stroke);
    this.width = x2 - x1;
    this.height = y2 - y1;
  }

//  @Override
//  Oval create(int x1, int y1, int x2, int y2) {
//    return new Oval(x1, y1, x2, y2, this.getColor(), stroke);
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
    return s.equalsOval(this);
  }

  public boolean equalsOval(Oval o) {
    return this.getX1() == o.getX1() &&
            this.getX2() == o.getX2() &&
            this.getY1() == o.getY1() &&
            this.getY2() == o.getY2() &&
            this.getColor() == o.getColor() &&
            this.getStroke() == o.getStroke();
  }
}
