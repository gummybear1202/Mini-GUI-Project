package view;

/**
 * Created by rosaline17 on 2/17/16.
 */

import java.awt.event.MouseListener;

public interface GuiView {

  void addMouseListener(MouseListener l);

  void removeMouseListener(MouseListener l);

}
