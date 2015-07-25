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
    private static final String BUTTON_DOWN_LABEL = "down";
    private static final String BUTTON_UP_LABEL = "up";
    private static final String BUTTON_PRINT_LABEL = "print";
    private static final String BUTTON_RESET_LABEL = "reset";

    private Integer testNum = 0;
    private JLabel numberLabel = new JLabel(testNum.toString());


//    https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
//    http://da2i.univ-lille1.fr/doc/tutorial-java/ui/features/components.html

    public MainFrame(String title) {
        super(title);

        // Set layout manager. 5 panes, one in centre
        setLayout(new BorderLayout());

        //create swing component.
//        final JLabel numberLabel = new JLabel("50");
//        numberLabel.setSize(40, 40);

        JButton downButton = new JButton(BUTTON_DOWN_LABEL);
        JButton upButton = new JButton(BUTTON_UP_LABEL);
        JButton printButton = new JButton(BUTTON_PRINT_LABEL);
        JButton resetButton = new JButton(BUTTON_RESET_LABEL);

        //add swing component to content pane.
        Container container = getContentPane();

        container.add(numberLabel, BorderLayout.CENTER);
        container.add(downButton, BorderLayout.PAGE_END);
        container.add(upButton, BorderLayout.PAGE_START);
        container.add(printButton, BorderLayout.LINE_START);
        container.add(resetButton, BorderLayout.LINE_END);


        //annonymous class
        upButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                numberLabel.setText((++testNum).toString());
            }
        });

        //annonymous class
        downButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                numberLabel.setText((--testNum).toString());
            }
        });

        //annonymous class
        resetButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                testNum = 0;
                numberLabel.setText((testNum).toString());
            }
        });

        //annonymous class
        printButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your number is "+ (testNum + 1));
            }
        });

    }
}
