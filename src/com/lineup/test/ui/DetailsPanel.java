package test.ui;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Odin on 15-07-22.
 */
public class DetailsPanel extends JPanel {

    private static final long serialVersionUID = 1234567432L;

    private EventListenerList listenerList = new EventListenerList();

    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);


        //creates borders
        setBorder(BorderFactory.createTitledBorder("Personal Details"));

        JLabel nameLabel = new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");

        final JTextField nameField = new JTextField(10);
        final JTextField occupationField = new JTextField(10);

        JButton addBtn = new JButton("Add");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();

                String text = name + "  " + occupation + "\n";

                fireDetailEvent(new DetailEvent(this, text));

            }
        });

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

    public void fireDetailEvent(DetailEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == DetailListener.class) {
                ((DetailListener) listeners[i + 1]).detailEventOccured(event);
            }
        }
    }

    public void addDetailListener(DetailListener listener) {
        listenerList.add(DetailListener.class, listener);

    }

    public void removeDetailListener(DetailListener listener) {
        listenerList.remove(DetailListener.class, listener);

    }


}
