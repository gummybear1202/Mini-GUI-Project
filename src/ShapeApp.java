import java.io.IOException;

import controller.ControllerImpl;
import model.Model;
import model.ModelImpl;
import view.GuiViewFrame;
import view.ViewModel;

/**
 * Created by rosaline17 on 2/17/16.
 */
public class ShapeApp {
  public static void main(String[] args) throws IOException {
    Model model = ModelImpl.builder().setColors().setStrokes().build();
    ViewModel vm = new ViewModel(model);
    GuiViewFrame gui = GuiViewFrame.builder().setViewModel(vm).build();
    ControllerImpl controller = new ControllerImpl(model, gui);
    controller.initialize();
  }
}
