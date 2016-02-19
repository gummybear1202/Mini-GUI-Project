package model;

import java.awt.*;

/**
 * Created by rosaline17 on 2/15/16.
 */
public abstract class Shape {
  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;
  public Color color;
  public int stroke;

  public Shape(int x1, int y1, int x2, int y2, Color color, int stroke) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.color = color;
    this.stroke = stroke;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Shape) {
      return ((Shape) obj).equalsShape(this);
    }
    else {
      return false;
    }
  }

  public abstract boolean equalsShape(Shape s);

  public boolean equalsRec(Rec r) {
    return false;
  }

  public boolean equalsOval(Oval o) {
    return false;
  }

  public boolean equalsCurve(Curve c) {
    return false;
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  public int getX2() {
    return x2;
  }

  public int getY2() {
    return y2;
  }

  /**
   * get the color of the shape
   *
   * @return the shape's color
   */
  public Color getColor() {
    return color;
  }

  public int getStroke() {
    return stroke;
  }

  public void changeColor(Color c) {
    this.color = c;
  }

  public void changeStroke(int stroke) {
    this.stroke = stroke;
  }

}
