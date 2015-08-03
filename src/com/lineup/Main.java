import controller.Controller;
import controller.ControllerImpl;
import output.monitor.frame.MainFrame;
import persistence.Persistence;
import persistence.PersistenceImpl;

import javax.swing.*;

import static output.monitor.UIElementNumbers.WINDOW_HEIGHT;
import static output.monitor.UIElementNumbers.WINDOW_WIDTH;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Set up the UI thread and hold Controller and Input classes.
 *
 * Created by Jon Mercer on 15-07-23.
 *
 */
public class Main {

    private final String NAME_OF_APP = "LineUp";

    private Controller controller = new ControllerImpl();
    private Persistence persistence = new PersistenceImpl();

    private Main() {
        generateFrame();
    }

    /*
    * The main entry method.
    *
    * */
    public static void main(String[] args) {
        Main m = new Main();

    }

    private void generateFrame() {
        //Creates a special swing thread and runs code there
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Main window of application. Only one per swing program
                JFrame frame = new MainFrame(NAME_OF_APP, controller, persistence.accidentalReeboot());

                //sets the frame to be visible
                frame.setVisible(true);
                //closes application properly
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(WINDOW_WIDTH.getInt(), WINDOW_HEIGHT.getInt());
            }
        });
    }
}
