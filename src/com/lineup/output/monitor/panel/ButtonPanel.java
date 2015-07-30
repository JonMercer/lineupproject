package output.monitor.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Bottom panel that will only show up on toggle. For debugging purposes.
 * Created by Jon Mercer on 15-07-28.
 */
public class ButtonPanel extends JPanel {
    private static final String BUTTON_DOWN_LABEL = "down";
    private static final String BUTTON_ROOM_1_LABEL = "R1";
    private static final String BUTTON_ROOM_2_LABEL = "R2";
    private static final String BUTTON_ROOM_3_LABEL = "R3";
    private static final String BUTTON_ROOM_4_LABEL = "R4";
    private static final String BUTTON_ROOM_5_LABEL = "R5";
    private static final String BUTTON_ROOM_6_LABEL = "R6";
    private static final String BUTTON_PRINT_LABEL = "print";
    private static final String BUTTON_RESET_LABEL = "reset";

    public ButtonPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        size.height = 60;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Button Panel"));

        JButton downButton = new JButton(BUTTON_DOWN_LABEL);
        JButton room1 = new JButton(BUTTON_ROOM_1_LABEL);
        JButton room2 = new JButton(BUTTON_ROOM_2_LABEL);
        JButton room3 = new JButton(BUTTON_ROOM_3_LABEL);
        JButton room4 = new JButton(BUTTON_ROOM_4_LABEL);
        JButton room5 = new JButton(BUTTON_ROOM_5_LABEL);
        JButton room6 = new JButton(BUTTON_ROOM_6_LABEL);
        JButton printButton = new JButton(BUTTON_PRINT_LABEL);
        JButton resetButton = new JButton(BUTTON_RESET_LABEL);

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(downButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(resetButton, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(printButton, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        add(room1, constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        add(room2, constraints);

        constraints.gridx = 6;
        constraints.gridy = 0;
        add(room3, constraints);

        constraints.gridx = 4;
        constraints.gridy = 1;
        add(room4, constraints);

        constraints.gridx = 5;
        constraints.gridy = 1;
        add(room5, constraints);

        constraints.gridx = 6;
        constraints.gridy = 1;
        add(room6, constraints);






        //annonymous class
        room1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
//                numberLabel.setText((++testNum).toString());
//                numberLabel.setText(controller.increment().toString());
            }
        });

        //annonymous class
        downButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                numberLabel.setText((--testNum).toString());
//                numberLabel.setText(controller.decrement().toString());
            }
        });

        //annonymous class
        resetButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
//                numberLabel.setText((testNum).toString());
//                numberLabel.setText(controller.reset().toString());
            }
        });

        //annonymous class
        printButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Your number is "+ (testNum + 1));
//                System.out.println("Your number is " + controller.print().toString());
            }
        });
    }
}
