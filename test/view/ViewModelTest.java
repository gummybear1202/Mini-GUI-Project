package view;

import org.junit.Test;

import java.awt.*;
import java.util.*;

import model.*;
import model.Shape;

import static org.junit.Assert.*;

/**
 * Created by rosaline17 on 2/17/16.
 */
public class ViewModelTest {

  @Test
  public void testFind() throws Exception {

    Rec rec = new Rec(1, 1, 2, 2, Color.yellow, 10);
    Oval oval = new Oval(5, 1, 6, 2, Color.yellow, 10);
    Curve line = new Curve(10, 1, 12, 2, Color.blue, 10);
    ModelImpl model = ModelImpl.builder().addShape(rec).addShape(oval)
            .addShape(line).build();
    ViewModel vm = new ViewModel(model);
    assertEquals(vm.find(11, 1), line);
  }

  @Test
  public void testGetShapes() throws Exception {
    Rec rec = new Rec(1, 1, 2, 2, Color.yellow, 10);
    Oval oval = new Oval(5, 1, 6, 2, Color.yellow, 10);
    Curve line = new Curve(10, 1, 12, 2, Color.blue, 10);
    java.util.List<Shape> list = new ArrayList<>();
    list.add(rec);
    list.add(oval);
    list.add(line);
    ModelImpl model = ModelImpl.builder().addShape(rec).addShape(oval)
            .addShape(line).build();
    ViewModel vm = new ViewModel(model);
    assertEquals(vm.getShapes(), list);
  }
}