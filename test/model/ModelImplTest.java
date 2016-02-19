package model;

import org.junit.Test;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by rosaline17 on 2/15/16.
 */
public class ModelImplTest {

  @Test
  public void testFind() {
    Rec rec = new Rec(1, 1, 2, 2, Color.yellow, 10);
    Oval oval = new Oval(5, 1, 6, 2, Color.yellow, 10);
    Curve line = new Curve(10, 1, 12, 2, Color.blue, 10);
    ModelImpl model = ModelImpl.builder().addShape(rec).addShape(oval)
            .addShape(line).build();
    assertEquals(model.find(11, 1), line);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemove() {
    Rec rec = new Rec(1, 1, 2, 2, Color.yellow, 10);
    Oval oval = new Oval(5, 1, 6, 2, Color.yellow, 10);
    Curve line = new Curve(10, 1, 12, 2, Color.blue, 10);
    ModelImpl model = ModelImpl.builder().addShape(rec).addShape(oval)
            .addShape(line).build();
    model.remove(1, 1);
    assertEquals(model.find(1, 1), line);
  }

  @Test
  public void testRemoveAll() {
    Rec rec = new Rec(1, 1, 2, 2, Color.yellow, 10);
    Oval oval = new Oval(5, 1, 6, 2, Color.yellow, 10);
    Curve line = new Curve(10, 1, 12, 2, Color.blue, 10);
    ModelImpl model = ModelImpl.builder().addShape(rec).addShape(oval)
            .addShape(line).build();
    model.removeAll();
    assertTrue(model.getShapes().isEmpty());

  }

  @Test
  public void testGetShapes() {
    Rec rec = new Rec(1, 1, 2, 2, Color.yellow, 10);
    Oval oval = new Oval(5, 1, 6, 2, Color.yellow, 10);
    Curve line = new Curve(10, 1, 12, 2, Color.blue, 10);
    List<Shape> list = new ArrayList<>();
    list.add(rec);
    list.add(oval);
    list.add(line);
    ModelImpl model = ModelImpl.builder().addShape(rec).addShape(oval)
            .addShape(line).build();
    assertEquals(model.getShapes(), list);
  }

  @Test
  public void testDrawRec() {
    Rec rec = new Rec(1, 1, 2, 2, Color.yellow, 10);
    ModelImpl model = ModelImpl.builder().build();
    assertEquals(model.getShapes().isEmpty(), true);
    model.drawRec(1, 1, 2, 2, Color.yellow, 10);
    assertEquals(model.getShapes().isEmpty(), false);
    assertEquals(model.find(1, 1), rec);
  }

  @Test
  public void testDrawOval() {

    Oval oval = new Oval(1, 1, 2, 2, Color.yellow, 10);
    ModelImpl model = ModelImpl.builder().build();
    assertEquals(model.getShapes().isEmpty(), true);
    model.drawOval(1, 1, 2, 2, Color.yellow, 10);
    assertEquals(model.getShapes().isEmpty(), false);
    assertEquals(model.find(1, 1), oval);
  }

  @Test
  public void testDrawCurve() {
    Curve curve = new Curve(1, 1, 2, 2, Color.yellow, 10);
    ModelImpl model = ModelImpl.builder().build();
    assertEquals(model.getShapes().isEmpty(), true);
    model.drawCurve(1, 1, 2, 2, Color.yellow, 10);
    assertEquals(model.getShapes().isEmpty(), false);
    assertEquals(model.find(1, 1), curve);

  }

  @Test
  public void testGetColors() {
    Model model = ModelImpl.builder().setColors().build();
    ArrayList<Color> result = new ArrayList<>();
    result.add(Color.black);
    result.add(Color.white);
    result.add(Color.yellow);
    result.add(Color.blue);
    result.add(Color.red);
    result.add(Color.green);
    result.add(Color.pink);
    result.add(Color.darkGray);
    assertEquals(model.getColors(), result);
  }

  @Test
  public void testGetStrokes() {
    Model model = ModelImpl.builder().setStrokes().build();
    ArrayList<Integer> result = new ArrayList<>();
    result.add(1);
    result.add(2);
    result.add(3);
    result.add(4);
    result.add(5);
    result.add(6);
    result.add(7);
    assertEquals(model.getStrokes(), result);
  }

}