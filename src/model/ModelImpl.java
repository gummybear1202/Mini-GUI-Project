package model;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rosaline17 on 2/15/16.
 */
public class ModelImpl implements Model {
  private final ArrayList<Shape> shapes;
  private final ArrayList<Color> colors;
  private final ArrayList<Integer> strokes;

  private ModelImpl(ArrayList<Shape> shapes, ArrayList<Color> colors, ArrayList<Integer>
          strokes) {
    if (colors.size() > 10 || strokes.size() > 10) {
      throw new IllegalArgumentException("too many colors or strokes. Max of" +
              " 10");
    }
    this.shapes = shapes;
    this.colors = colors;
    this.strokes = strokes;
  }

  @Override
  public void drawCurve(int x1, int y1, int x2, int y2, Color color, int stroke) {
    Curve c = new Curve(x1, y1, x2, y2, color, stroke);
    this.shapes.add(c);
  }

  @Override
  public void drawRec(int x1, int y1, int x2, int y2, Color color, int stroke) {
    Rec r = new Rec(x1, y1, x2, y2, color, stroke);
    this.shapes.add(r);
  }

  @Override
  public void drawOval(int x1, int y1, int x2, int y2, Color color, int stroke) {
    Oval o = new Oval(x1, y1, x2, y2, color, stroke);
    this.shapes.add(o);
  }

  @Override
  public Shape find(int x, int y) {
    Shape s = new Rec(0, 0, 0, 0, Color.cyan, 0);
    boolean booX = false;
    boolean booY = false;
    for (Shape sh: this.shapes) {
      if (sh.getY1() <= sh.getY2()) {
        booY = y <= sh.getY2() && y >= sh.getY1();
      }
      if (sh.getY1() > sh.getY2()) {
        booY = y <=sh.getY1() && y >= sh.getY2();
      }
      if (sh.getX1() <= sh.getX2()) {
        booX = x <= sh.getX2() && x >= sh.getX1();
      }
      if (sh.getX1() > sh.getX2()) {
        booX = x <=sh.getX1() && x >= sh.getX2();
      }
      if (booX && booY) {
        s = sh;
      }
    }
    if (s.stroke == 0) {
      throw new IllegalArgumentException("No such shape exists");
    }
    return s;
  }

  @Override
  public void remove(int x, int y) {
    try {
      Shape s = this.find(x, y);
      for (int i = 0; i < this.shapes.size(); i++) {
        if (s.equals(this.shapes.get(i))) {
          this.shapes.remove(i);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void removeAll() {
    this.shapes.removeAll(this.shapes);
  }

  @Override
  public List<Shape> getShapes() {
    return new ArrayList<>(this.shapes);
  }

  @Override
  public List<Color> getColors() {
    return new ArrayList<>(this.colors);
  }

  @Override
  public List<Integer> getStrokes() {
    return new ArrayList<>(this.strokes);
  }

  /**
   * creates a model
   *
   * @return the new model created
   */
  public static Builder builder() {
    return new ModelImpl.Builder();
  }

  public static final class Builder {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();
    private ArrayList<Integer> strokes = new ArrayList<>();

    /**
     * add a shape to the list
     *
     * @param s the shape added
     * @return this for method chaining
     */
    public Builder addShape(Shape s) {
      this.shapes.add(s);
      return this;
    }


    public Builder addColor(Color c) {
      this.colors.add(c);
      return this;
    }


    public Builder addStroke(int stroke) {
      this.strokes.add(stroke);
      return this;
    }

    public Builder setColors() {
      this.colors.add(Color.black);
      this.colors.add(Color.white);
      this.colors.add(Color.yellow);
      this.colors.add(Color.blue);
      this.colors.add(Color.red);
      this.colors.add(Color.green);
      this.colors.add(Color.pink);
      this.colors.add(Color.darkGray);
      return this;
    }

    public Builder setStrokes() {
      this.strokes.add(1);
      this.strokes.add(2);
      this.strokes.add(3);
      this.strokes.add(4);
      this.strokes.add(5);
      this.strokes.add(6);
      this.strokes.add(7);
      return this;
    }

    public Builder setList(ArrayList<Shape> shapes) {
      this.shapes = shapes;
      return this;
    }

    /**
     * builds the model
     *
     * @return the model
     */
    public ModelImpl build() {
      return new ModelImpl(shapes, colors, strokes);
    }

  }

}
