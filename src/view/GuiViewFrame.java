package view;

import com.sun.xml.internal.rngom.parse.host.Base;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

/**
 * Created by rosaline17 on 2/17/16.
 */
public final class GuiViewFrame extends JFrame implements GuiView {
  ViewModel vm;
  private JFrame frame = new JFrame("View");
  private String colorName;
  private int stroke;
  private String shape;
  private boolean clear;

  private GuiViewFrame(ViewModel vm) {
    this.vm = vm;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());


    ConcreteGuiViewPanel concreteGuiViewPanel = new ConcreteGuiViewPanel(vm);
    concreteGuiViewPanel.setPreferredSize(new Dimension(500, 500));

    concreteGuiViewPanel.setVisible(true);


    frame.setLayout(new BorderLayout());
    GroupLayout groupSettings = new GroupLayout(frame.getContentPane());

    frame.getContentPane().setLayout(groupSettings);
    groupSettings.setAutoCreateGaps(true);
    groupSettings.setAutoCreateContainerGaps(true);


    // label for colors
    JLabel lbColor = new JLabel("Colors");

    // colors
    String[] colors = {"Black", "White", "Yellow", "Blue", "Red", "Green",
            "Pink", "Dark Gray"};
    JComboBox colorList = new JComboBox(colors);
    colorList.setSelectedIndex(0);
    colorName = colorList.getSelectedItem().toString();
    colorList.setPreferredSize(new Dimension(120, 40));
    colorList.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          colorName = colorList.getSelectedItem().toString();
        }
      }
    });


    // label for strokes
    JLabel lbStrokes = new JLabel("Strokes");


    // strokes
    JComboBox strokeList = new JComboBox(vm.getStrokes().toArray());
    strokeList.setSelectedIndex(0);
    stroke = Integer.parseInt(Objects.toString(vm.getStrokes().toArray()[0]));
    strokeList.setPreferredSize(new Dimension(120, 40));
    strokeList.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          stroke = Integer.parseInt(strokeList.getSelectedItem().toString());
        }
      }
    });


    // label for shapes
    JLabel lbShapes = new JLabel("Shapes");

    // shapes
    String[] shapes = {"Rec", "Oval", "Curve"};
    JComboBox shapeList = new JComboBox(shapes);
    shapeList.setSelectedIndex(0);
    shape = shapes[0];
    shape = shapeList.getSelectedItem().toString();
    shapeList.setPreferredSize(new Dimension(120, 40));
    shapeList.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          shape = shapeList.getSelectedItem().toString();
        }
      }
    });

    // clear button
    JButton clearButton = new JButton("Clear");
    clearButton.setPreferredSize(new Dimension(120, 40));
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (clear == false) {

          clear = true;
        }
      }
    });


    // vertical group for all settings

    concreteGuiViewPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    groupSettings.setVerticalGroup(groupSettings.createSequentialGroup()
            .addGroup(groupSettings.createParallelGroup(GroupLayout.Alignment
                    .BASELINE)
                    .addComponent(concreteGuiViewPanel)
                    .addGroup(groupSettings.createSequentialGroup()
                            .addGroup(groupSettings.createParallelGroup(GroupLayout
                                    .Alignment.BASELINE)
                                    .addComponent(lbColor)
                                    .addComponent(colorList))
                            .addGroup(groupSettings.createParallelGroup(GroupLayout
                                    .Alignment.BASELINE)
                                    .addComponent(lbShapes)
                                    .addComponent(shapeList))
                            .addGroup(groupSettings.createParallelGroup(GroupLayout
                                    .Alignment.BASELINE)
                                    .addComponent(lbStrokes)
                                    .addComponent(strokeList))
                    .addComponent(clearButton))));

    groupSettings.setHorizontalGroup(groupSettings.createSequentialGroup()
            .addGroup(groupSettings.createParallelGroup(GroupLayout
                    .Alignment.LEADING))
            .addComponent(concreteGuiViewPanel)
            .addGroup(groupSettings.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbColor)
                    .addComponent(lbShapes)
                    .addComponent(lbStrokes))
            .addGroup(groupSettings.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(colorList)
                    .addComponent(shapeList)
                    .addComponent(strokeList)
                    .addComponent(clearButton)));

    frame.pack();
    frame.setPreferredSize(new Dimension(500, 500));
    frame.setMinimumSize(new Dimension(500, 500));
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }

  public static Builder builder() {
    return new GuiViewFrame.Builder();
  }


  public static final class Builder {
    private ViewModel vm;


    public Builder setViewModel(ViewModel vm) {
      this.vm = vm;
      return this;
    }

    public GuiViewFrame build() {
      return new GuiViewFrame(vm);
    }
  }

  @Override
  public void addMouseListener(MouseListener m) {
    this.frame.getContentPane().addMouseListener(m);
  }

  @Override
  public void removeMouseListener(MouseListener m) {
    this.frame.getContentPane().removeMouseListener(m);

  }

  public String getColorName() {
    return this.colorName;
  }

  public int getStroke() {
    return this.stroke;
  }

  public Color getCurrentColor() {
    switch (this.getColorName()) {
      case "Black":
        return Color.black;
      case "White":
        return Color.white;
      case "Yellow":
        return Color.yellow;
      case "Blue":
        return Color.blue;
      case "Red":
        return Color.red;
      case "Green":
        return Color.green;
      case "Pink":
        return Color.pink;
      case "Dark Gray":
        return Color.darkGray;
      default:
        throw new IllegalArgumentException("Unknown color");
    }
  }

  public String getCurrentShape() {
    return this.shape;
  }

  public boolean getClear() {
    return this.clear;
  }

  public void defaultClear() {
    this.clear = false;
  }
}
