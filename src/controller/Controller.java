package controller;

import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Created by rosaline17 on 2/18/16.
 */
public interface Controller {

  void initialize();

  MouseListener getMouseListener();

  void setColor(Color c);

  void setStroke(int s);

  void setShape(String s);

  void setGetClear(boolean c);

}
