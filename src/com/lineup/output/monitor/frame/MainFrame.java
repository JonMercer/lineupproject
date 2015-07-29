package output.monitor.frame;

import controller.Controller;
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

    private Integer testNum = 0;
    private JLabel numberLabel = new JLabel(testNum.toString());

    private RoomPanel roomPanel;
    private NumberPanel numberPanel;
    private ButtonPanel buttonPanel;


//    https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
//    http://da2i.univ-lille1.fr/doc/tutorial-java/ui/features/components.html

    public MainFrame(String title, final Controller controller) {
        super(title);

        // Set layout manager. 5 panes, one in centre
        setLayout(new BorderLayout());

        //create swing component.
//        final JLabel numberLabel = new JLabel("50");
//        numberLabel.setSize(40, 40);


        roomPanel = new RoomPanel();
        numberPanel = new NumberPanel();
        buttonPanel = new ButtonPanel();

        //add swing component to content pane.
        Container container = getContentPane();

//        container.add(numberLabel, BorderLayout.WEST);
//        container.add(downButton, BorderLayout.PAGE_END);
//        container.add(upButton, BorderLayout.PAGE_START);
//        container.add(printButton, BorderLayout.LINE_START);
//        container.add(resetButton, BorderLayout.LINE_END);
        container.add(roomPanel, BorderLayout.CENTER);
        container.add(numberPanel, BorderLayout.WEST);
        container.add(buttonPanel, BorderLayout.SOUTH);





    }
}
