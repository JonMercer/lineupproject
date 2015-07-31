package output.monitor.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Right hand panel displaying rooms.
 * Created by Jon Mercer on 15-07-28.
 */
public class RoomPanel extends JPanel {

    private static final int FONT_SIZE = 30;

    public RoomPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("RoomPanel"));

        JLabel topLeft = new JLabel("49");
        JLabel topRight = new JLabel("Room 5");
        topLeft.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        topRight.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));

        JLabel midLeft = new JLabel("50");
        JLabel midRight = new JLabel("Room 3");
        midLeft.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        midRight.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));

        JLabel lowLeft = new JLabel("48");
        JLabel lowRight = new JLabel("Room 1");
        lowLeft.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        lowRight.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(topLeft, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(topRight, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(midLeft, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(midRight, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(lowLeft, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(lowRight, constraints);
    }


}
