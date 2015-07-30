package output.monitor.frame;

//    https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
//    http://da2i.univ-lille1.fr/doc/tutorial-java/ui/features/components.html

import controller.Controller;
import output.monitor.ButtonEvent;
import output.monitor.ButtonListener;
import output.monitor.panel.ButtonPanel;
import output.monitor.panel.NumberPanel;
import output.monitor.panel.RoomPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Our custom version of JFrame.
 * We can add components here
 * - layout manager: design layouts that reflow depending on screen state
 * - swing components: base class for swing components (pieces of UI including keybinding)
 * , and content pane
 * Created by Jon Mercer on 15-07-23.
 */
public class MainFrame extends JFrame {

    private RoomPanel roomPanel = new RoomPanel();
    private NumberPanel numberPanel = new NumberPanel();
    private ButtonPanel buttonPanel = new ButtonPanel();

    public MainFrame(String title, final Controller controller) {
        super(title);

        // Set layout manager. BorderLayout = 5 panes, one in centre
        setLayout(new BorderLayout());

        //The opposite of addactionListener
        //Anonymous class
        buttonPanel.addButtonListener(new ButtonListener() {
            public void buttonEventOccurred(ButtonEvent event) {
                String text = event.getText();
                numberPanel.setText(text);
            }
        });

        //add swing components to content pane.
        Container container = getContentPane();

        container.add(roomPanel, BorderLayout.CENTER);
        container.add(numberPanel, BorderLayout.WEST);
        container.add(buttonPanel, BorderLayout.SOUTH);
    }
}
