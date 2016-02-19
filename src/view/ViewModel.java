package view;

import java.awt.*;
import java.awt.Shape;
import java.util.*;
import java.util.List;

import model.*;

/**
 * Wrapper for model
 */

public class ViewModel {
  private final Model model;

  public ViewModel(Model model) {
    this.model = model;
  }
//  /**
//   * draws a curve
//   *
//   * @param x1 first x coordinate
//   * @param y1 first y coordinate
//   * @param x2 second x coordinate
//   * @param y2 second y coordinate
//   * @param color the color of the shape
//   * @param stroke the stroke of the shape
//   */
//  void drawCurve(int x1, int y1, int x2, int y2, Color color, int stroke) {
//    model.drawCurve(x1, y1, x2, y2, color, stroke);
//  }
//
//  /**
//   * draws a rectangle
//   *
//   * @param x1 first x coordinate
//   * @param y1 first y coordinate
//   * @param x2 second x coordinate
//   * @param y2 second y coordinate
//   * @param color the color of the shape
//   * @param stroke the stroke of the shape
//   */
//  void drawRec(int x1, int y1, int x2, int y2, Color color, int stroke) {
//    model.drawRec(x1, y1, x2, y2, color, stroke);
//  }
//
//  /**
//   * draws an oval
//   *
//   * @param x1 first x coordinate
//   * @param y1 first y coordinate
//   * @param x2 second x coordinate
//   * @param y2 second y coordinate
//   * @param color the color of the shape
//   * @param stroke the stroke of the shape
//   */
//  void drawOval(int x1, int y1, int x2, int y2, Color color, int stroke) {
//    model.drawOval();
//  }

  /**
   * find a shape with given coordinates
   *
   * @param x coordinate
   * @param y coordinate
   * @return the found shape
   * @throws IllegalArgumentException if the shape doesn't exist
   */
  model.Shape find(int x, int y) { return model.find(x, y); }

//  /**
//   * removes the shape with given coordinates
//   *
//   * @param x coordinate
//   * @param y coordinate
//   * @throws IllegalArgumentException if the shape doesn't exist
//   */
//  void remove(int x, int y);
//
//  /**
//   * remove all shapes from the model
//   */
//  void removeAll();

  /**
   * get all shapes from the model
   */
  List<model.Shape> getShapes() { return model.getShapes(); }

  List<Color> getColors() { return model.getColors();}
  List<Integer> getStrokes() { return model.getStrokes();}


}
