package output.monitor.panel;

import enums.UIElementNumbers;

import javax.swing.*;
import java.awt.*;

/**
 * Right hand panel displaying rooms.
 * Created by Jon Mercer on 15-07-28.
 */
public class RoomPanel extends JPanel {

    private static final int FONT_SIZE = UIElementNumbers.PANEL_ROOM_FONT.getInt();



    JLabel topLeft = new JLabel();
    JLabel topRight = new JLabel();
    JLabel midLeft = new JLabel();
    JLabel midRight = new JLabel();
    JLabel lowLeft = new JLabel();
    JLabel lowRight = new JLabel();

    public RoomPanel() {
        Dimension size = getPreferredSize();
        size.width = UIElementNumbers.PANEL_ROOM_WIDTH.getInt();
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("RoomPanel"));

        topLeft.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        topRight.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));

        midLeft.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        midRight.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));

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

    public void setFirstRow(String counter, String room) {
        topLeft.setText(counter);
        topRight.setText(room);
    }


    public void setSecondRow(String counter, String room) {
        midLeft.setText(counter);
        midRight.setText(room);
    }

    public void setThirdRow(String counter, String room) {
        lowLeft.setText(counter);
        lowRight.setText(room);
    }
}
