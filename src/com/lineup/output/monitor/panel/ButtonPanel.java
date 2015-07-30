package output.monitor.panel;

import output.monitor.AllButtons;
import output.monitor.eventHandler.ButtonEvent;
import output.monitor.eventHandler.ButtonListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Bottom panel that will only show up on toggle. For debugging purposes.
 * Created by Jon Mercer on 15-07-28.
 */
public class ButtonPanel extends JPanel {

    //Creating list of events, becasue multiple events are queued?
    private EventListenerList listenerList = new EventListenerList();

    public ButtonPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        size.height = 60;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Button Panel"));

        JButton downButton = new JButton(AllButtons.DOWN.getLabelName());
        JButton room1 = new JButton(AllButtons.R1.getLabelName());
        JButton room2 = new JButton(AllButtons.R2.getLabelName());
        JButton room3 = new JButton(AllButtons.R3.getLabelName());
        JButton room4 = new JButton(AllButtons.R4.getLabelName());
        JButton room5 = new JButton(AllButtons.R5.getLabelName());
        JButton room6 = new JButton(AllButtons.R6.getLabelName());
        JButton printButton = new JButton(AllButtons.PRINT.getLabelName());
        JButton resetButton = new JButton(AllButtons.RESET.getLabelName());

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.PRINT.getLabelName()));
            }
        });


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




//        //old way to actions
//        room1.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                numberLabel.setText((++testNum).toString());
////                numberLabel.setText(controller.increment().toString());
//            }
//        });
    }

    public void fireButtonEvent(ButtonEvent event) {
        Object[] listeners = listenerList.getListenerList();

        //step two at a time because the first of pair of items is ButtonListener class
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == ButtonListener.class) {
                ((ButtonListener)listeners[i+1]).buttonEventOccurred(event);
            }
        }
    }

    public void addButtonListener(ButtonListener listener) {

        listenerList.add(ButtonListener.class, listener);

    }

    public void removeButtonListener(ButtonListener listener) {
        listenerList.remove(ButtonListener.class, listener);
    }
}
