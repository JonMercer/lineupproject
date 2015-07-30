package output.monitor.panel;

import javax.swing.*;
import java.awt.*;

//How to set the font size: http://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size

/**
 * Panel on the left side of the app.
 * Created by Jon Mercer on 15-07-28.
 */
public class NumberPanel extends JPanel {

    public NumberPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("NumberLabel"));

        JLabel numberLabel = new JLabel("50");

        numberLabel.setFont(new Font("Serif", Font.PLAIN, 100));

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(numberLabel, constraints);

    }
}