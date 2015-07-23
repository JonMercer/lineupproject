import javax.swing.*;
import java.awt.*;

/**
 * Created by Odin on 15-07-22.
 */
public class DetailsPanel extends JPanel {

    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);


        //creates borders
        setBorder(BorderFactory.createTitledBorder("Personal Details"));

        JLabel nameLabel = new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");

        JTextField nameField = new JTextField(10);
        JTextField occupationField = new JTextField(10);

        JButton addBtn = new JButton("Add");

        //lets you add controlls in conjunction with gridbag constraints
        setLayout(new GridBagLayout());

        //where to want each class to go
        GridBagConstraints gc = new GridBagConstraints();

        //Divide contolls into logical sections


        /// First Collumn ////
        //top left is 0,0

        //how much of the scren will be taken

        gc.anchor = GridBagConstraints.LINE_END;//allign to the right
        gc.weightx = 0.5;
        gc.weighty = 0.5;


        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(occupationLabel, gc);


        //second collumn

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(occupationField, gc);

        //Final row

        gc.weighty = 10;

        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);





    }
}
