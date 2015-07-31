package output.monitor.frame;

//    https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
//    http://da2i.univ-lille1.fr/doc/tutorial-java/ui/features/components.html

import controller.Controller;
import controller.Pair;
import output.monitor.AllButtons;
import output.monitor.eventHandler.ButtonEvent;
import output.monitor.eventHandler.ButtonListener;
import output.monitor.panel.ButtonPanel;
import output.monitor.panel.NumberPanel;
import output.monitor.panel.RoomPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import static output.monitor.AllButtons.*;

/**
 * Our custom version of JFrame.
 * We can add components here
 * - layout manager: design layouts that reflow depending on screen state
 * - swing components: base class for swing components (pieces of UI including keybinding)
 * , and content pane
 * Created by Jon Mercer on 15-07-23.
 */
public class MainFrame extends JFrame {

    private RoomPanel roomPanel = new RoomPanel();
    private NumberPanel numberPanel = new NumberPanel();
    private ButtonPanel buttonPanel = new ButtonPanel();

    private Controller controller;

    public MainFrame(String title, final Controller controller) {
        super(title);

        this.controller = controller;

        // Set layout manager. BorderLayout = 5 panes, one in centre
        setLayout(new BorderLayout());

        //The opposite of addactionListener
        //Anonymous class
        buttonPanel.addButtonListener(new ButtonListener() {
            public void buttonEventOccurred(ButtonEvent event) {
                filterWhatButtonWasPressed(event.getButton());
            }
        });

        //add swing components to content pane.
        Container container = getContentPane();

        container.add(roomPanel, BorderLayout.CENTER);
        container.add(numberPanel, BorderLayout.WEST);
        container.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void filterWhatButtonWasPressed(AllButtons buttonLabel) {
        switch (buttonLabel) {
            case DOWN:
                decrementCounter();
                break;
            case PRINT:
                printTicket();
                break;
            case RESET:
                resetCounterAndRooms();
                break;
            case R1:
                updateCounterAndRoom(1);
                break;
            case R2:
                updateCounterAndRoom(2);
                break;
            case R3:
                updateCounterAndRoom(3);
                break;
            case R4:
                updateCounterAndRoom(4);
                break;
            case R5:
                updateCounterAndRoom(5);
                break;
            case R6:
                updateCounterAndRoom(6);
                break;
            case R7:
                updateCounterAndRoom(7);
                break;
            case R8:
                updateCounterAndRoom(8);
                break;
            case R9:
                updateCounterAndRoom(9);
                break;
            case R10:
                updateCounterAndRoom(10);
                break;
            default:
                System.err.println("Button Does not Exist");

        }
    }

    private void printTicket() {
        Integer printNumber = controller.print();

        buttonPanel.setPrintLabel("Print:" + printNumber.toString());

//        System.out.println("Printed number is: " + printNumber.toString());
    }

    private void updateCounterAndRoom(int roomNum) {
        Integer counterNumber = this.controller.increment();
        numberPanel.setText(counterNumber.toString());

        Object[] pairs = this.controller.roomButtonPressed(counterNumber, roomNum);

        setRoomText(pairs);
    }

    private void setRoomText(Object[] pairs) {

        if(pairs.length == 0) {
            roomPanel.setFirstRow("", "");
            roomPanel.setSecondRow("", "");
            roomPanel.setThirdRow("", "");
        }else if (pairs.length == 1) {
            roomPanel.setSecondRow("", "");
            roomPanel.setThirdRow("", "");
        } else if (pairs.length == 2) {
            roomPanel.setThirdRow("", "");
        }

        for (int i = 0; i < pairs.length; i++) {
            Pair pair = (Pair) pairs[i];
            switch (i) {
                case 0:
                    roomPanel.setFirstRow(pair.getLeft().toString(), " Room:" + pair.getRight().toString());
                    break;
                case 1:
                    roomPanel.setSecondRow(pair.getLeft().toString(), " Room:" + pair.getRight().toString());
                    break;
                case 2:
                    roomPanel.setThirdRow(pair.getLeft().toString(), " Room:" + pair.getRight().toString());
                    break;
                default:
                    i = pairs.length;
            }
        }
    }

    private void resetCounterAndRooms() {
        Integer counterNumber = this.controller.reset();

        numberPanel.setText(counterNumber.toString());

        roomPanel.setFirstRow("", "");
        roomPanel.setSecondRow("", "");
        roomPanel.setThirdRow("", "");

        buttonPanel.setPrintLabel("P:");
    }

    private void decrementCounter() {
        Integer counterNumber = this.controller.decrement();
        numberPanel.setText(counterNumber.toString());

        Object[] pairs = this.controller.decrementButtonPressed();
        setRoomText(pairs);

    }
}
