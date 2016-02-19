package model;

import java.awt.*;
import java.util.List;

/**
 * Created by rosaline17 on 2/15/16.
 */
public interface Model {
  /**
   * draws a curve
   *
   * @param x1 first x coordinate
   * @param y1 first y coordinate
   * @param x2 second x coordinate
   * @param y2 second y coordinate
   * @param color the color of the shape
   * @param stroke the stroke of the shape
   */
  void drawCurve(int x1, int y1, int x2, int y2, Color color, int stroke);

  /**
   * draws a rectangle
   *
   * @param x1 first x coordinate
   * @param y1 first y coordinate
   * @param x2 second x coordinate
   * @param y2 second y coordinate
   * @param color the color of the shape
   * @param stroke the stroke of the shape
   */
  void drawRec(int x1, int y1, int x2, int y2, Color color, int stroke);

  /**
   * draws an oval
   *
   * @param x1 first x coordinate
   * @param y1 first y coordinate
   * @param x2 second x coordinate
   * @param y2 second y coordinate
   * @param color the color of the shape
   * @param stroke the stroke of the shape
   */
  void drawOval(int x1, int y1, int x2, int y2, Color color, int stroke);

  /**
   * find a shape with given coordinates
   *
   * @param x coordinate
   * @param y coordinate
   * @return the found shape
   * @throws IllegalArgumentException if the shape doesn't exist
   */
  Shape find(int x, int y);

  /**
   * removes the shape with given coordinates
   *
   * @param x coordinate
   * @param y coordinate
   * @throws IllegalArgumentException if the shape doesn't exist
   */
  void remove(int x, int y);

  /**
   * remove all shapes from the model
   */
  void removeAll();

  /**
   * get all shapes from the model
   */
  List<Shape> getShapes();

  List<Color> getColors();

  List<Integer> getStrokes();

}
