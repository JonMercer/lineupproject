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
    }
}
