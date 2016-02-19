package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.awt.geom.*;

import javax.swing.*;

import model.Curve;
import model.Oval;
import model.Rec;

/**
 * Created by rosaline17 on 2/17/16.
 */
public final class ConcreteGuiViewPanel extends JPanel {
  private ViewModel vm;

  public ConcreteGuiViewPanel(ViewModel vm) {
    this.vm = vm;
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    java.util.List<model.Shape> shapes = vm.getShapes();
    for (int i = 0; i < shapes.size(); i++) {
      model.Shape shape = shapes.get(i);
      if (shapes.get(i) instanceof Oval) {
        int width = shape.getX2() - shape.getX1();
        int height = shape.getY2() - shape.getY1();
        if (shape.getX1() > shape.getX2()) {
          width = shape.getX1() - shape.getX2();
        }
        if (shape.getY1() > shape.getY2()) {
          height = shape.getY1() - shape.getY2();
        }
        g2d.setColor(shape.getColor());
        g2d.setStroke(new BasicStroke((float) shape.getStroke()));
        g2d.fillOval(shape.getX1(), shape.getY1(), width, height);
      } else if (shapes.get(i) instanceof Curve) {
        g2d.setStroke(new BasicStroke((float) shape.getStroke()));
        QuadCurve2D q = new QuadCurve2D.Float();
        q.setCurve(shape.getX1(), shape.getY1(), 2, 2, shape.getX2(), shape
                .getY2());
        g2d.draw(q);
      } else if (shapes.get(i) instanceof Rec) {
        g2d.setColor(shape.getColor());
        g2d.setStroke(new BasicStroke((float) shape.getStroke()));
        g2d.fillRect(shape.getX1(), shape.getY1(), Math.abs(shape.getX2() - shape
                .getX1()), Math.abs(shape.getY2() - shape.getY1()));
      }
    }
    repaint();
    g2d.dispose();
  }
}
