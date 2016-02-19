package model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by rosaline17 on 2/16/16.
 */
public class ShapeTest {

  @Test
  public void testEquals0() {
    Rec rec = new Rec(1, 1, 3, 4, Color.BLACK, 10);
    Shape rec2 = new Rec(1, 1, 3, 4, Color.BLACK, 10);
    Rec rec1 = new Rec(1, 1, 3, 4, Color.BLACK, 10);
    assertEquals(rec.getColor(), rec1.getColor());
    assertEquals(rec.getStroke(), 10);
    assertEquals(rec.getX1(), rec.getY1());
    assertEquals(rec.getX2(), 3);
    assertEquals(rec.getY2(), 4);
    assertTrue(rec1.equals(rec));
    assertTrue(rec.equals(rec1));
    assertTrue(rec.equals(rec2));

  }

  @Test
  public void testEquals1() {
    Shape oval = new Oval(1, 1, 3, 4, Color.BLACK, 10);
    Shape oval2 = new Oval(1, 1, 3, 4, Color.BLACK, 10);

    Oval oval1 = new Oval(1, 1, 3, 4, Color.BLACK, 10);
    assertEquals(oval.getColor(), oval1.getColor());
    assertEquals(oval.getStroke(), 10);
    assertEquals(oval.getX1(), oval.getY1());
    assertEquals(oval.getX2(), 3);
    assertEquals(oval.getY2(), 4);
    assertTrue(oval.equals(oval2));
    assertTrue(oval.equals(oval1));
  }

  @Test
  public void testEquals2() {
    Shape curve = new Curve(1, 1, 3, 4, Color.BLACK, 10);
    Shape curve2 = new Curve(1, 1, 3, 4, Color.BLACK, 10);

    Curve curve1 = new Curve(1, 1, 3, 4, Color.BLACK, 10);
    assertEquals(curve.getColor(), curve1.getColor());
    assertEquals(curve.getStroke(), 10);
    assertEquals(curve.getX1(), curve.getY1());
    assertEquals(curve.getX2(), 3);
    assertEquals(curve.getY2(), 4);
    assertTrue(curve.equals(curve2));
    assertTrue(curve.equals(curve1));
  }


  @Test
  public void testChangeStroke() {
    Shape curve = new Curve(1, 1, 3, 4, Color.BLACK, 10);
    curve.changeStroke(1);
    assertEquals(curve.getStroke(), 1);

  }


  @Test
  public void testChangeColor() {
    Shape rec = new Rec(1, 1, 3, 4, Color.BLACK, 10);
    rec.changeColor(Color.YELLOW);
    assertEquals(rec.getColor(), Color.yellow);

  }




}