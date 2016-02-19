package model;

import java.awt.*;

/**
 * Created by rosaline17 on 2/15/16.
 */
public class Rec extends Shape {
  private final int width;
  private final int height;

  public Rec(int x1, int y1, int x2, int y2, Color color, int stroke) {
    super(x1, y1, x2, y2, color, stroke);
    this.width = x2 - x1;
    this.height = y2 - y1;
  }

//  @Override
//  Rec create(int x1, int y1, int x2, int y2) {
//    return new Rec(x1, y1, x2, y2, this.getColor(), stroke);
//  }


  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equalsShape(Shape s) {
    return s.equalsRec(this);
  }

  public boolean equalsRec(Rec r) {
    return this.getX1() == r.getX1() &&
            this.getX2() == r.getX2() &&
            this.getY1() == r.getY1() &&
            this.getY2() == r.getY2() &&
            this.getColor() == r.getColor() &&
            this.getStroke() == r.getStroke();
  }

}
