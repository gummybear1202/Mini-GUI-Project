package controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.InvalidMidiDataException;

import model.Model;
import view.GuiViewFrame;

/**
 * Created by rosaline17 on 2/18/16.
 */
public class ControllerImpl implements Controller {
  private final MouseHandler mouseHandler;
  private final Model model;
  private final GuiViewFrame guiViewFrame;
  private String shape;
  private int stroke;
  private Color color;
  private boolean getClear;
  private Timer timer;

  private enum Shape {
    Rec, Oval, Curve;
  }

  public ControllerImpl(Model model, GuiViewFrame guiViewFrame) {
    this.model = model;
    this.guiViewFrame = guiViewFrame;
    this.mouseHandler = new MouseHandler();
    this.timer = new Timer();
  }

  @Override
  public void initialize() {
    color = guiViewFrame.getCurrentColor();
    stroke = guiViewFrame.getStroke();
    shape = guiViewFrame.getCurrentShape();
    getClear = guiViewFrame.getClear();

    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        color = guiViewFrame.getCurrentColor();
        stroke = guiViewFrame.getStroke();
        shape = guiViewFrame.getCurrentShape();
        getClear = guiViewFrame.getClear();
        if (getClear) {
          model.removeAll();
          guiViewFrame.defaultClear();
        }
      }
    }, 100, 100);
    mouseHandler.addToMouseButton("Press", () -> {
      if (shape == "Rec") {
        model.drawRec(mouseHandler.getXPress(), mouseHandler.getYPress(),
                mouseHandler.getXRelease(), mouseHandler.getYRelease(),
                color, stroke);
      } else if (shape == "Oval") {
        model.drawOval(mouseHandler.getXPress(), mouseHandler.getYPress(),
                mouseHandler.getXRelease(), mouseHandler.getYRelease(),
                color, stroke);
      } else if (shape == "Curve") {
        model.drawCurve(mouseHandler.getXPress(), mouseHandler.getYPress(),
                mouseHandler.getXRelease(), mouseHandler.getYRelease(),
                color, stroke);
      }
    });
    guiViewFrame.addMouseListener(mouseHandler);
  }

  @Override
  public MouseListener getMouseListener() {
    return this.mouseHandler;
  }

  @Override
  public void setColor(Color c) {
    this.color = c;
  }

  @Override
  public void setStroke(int s) {
    this.stroke = s;
  }

  @Override
  public void setShape(String s) {
    this.shape = s;
  }

  @Override
  public void setGetClear(boolean c) {
    this.getClear = c;
  }
}
