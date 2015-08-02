package output.monitor.panel;

import output.monitor.AllButtons;
import output.monitor.eventHandler.ButtonEvent;
import output.monitor.eventHandler.ButtonListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static output.monitor.UIElementNumbers.PANEL_BUTTON_HEIGHT;

/**
 * Bottom panel that will only show up on toggle. For debugging purposes.
 * Created by Jon Mercer on 15-07-28.
 */
public class ButtonPanel extends JPanel {

    JLabel printLabel = new JLabel("P:");

    //Creating list of events, because multiple events are queued?
    private EventListenerList listenerList = new EventListenerList();

    public ButtonPanel() {
        Dimension size = getPreferredSize();
        size.height = PANEL_BUTTON_HEIGHT.getInt();
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.black));

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
                fireButtonEvent(new ButtonEvent(this, AllButtons.PRINT));
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.DOWN));
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.RESET));
            }
        });

        room1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.R1));
            }
        });

        room2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.R2));
            }
        });

        room3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.R3));
            }
        });

        room4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.R4));
            }
        });

        room5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.R5));
            }
        });

        room6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireButtonEvent(new ButtonEvent(this, AllButtons.R6));
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

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(printLabel, constraints);

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

//    public void removeButtonListener(ButtonListener listener) {
//        listenerList.remove(ButtonListener.class, listener);
//    }

    public void setPrintLabel(String text) {
        printLabel.setText(text);
    }
}
