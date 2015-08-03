package output.monitor.frame;

//    https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
//    http://da2i.univ-lille1.fr/doc/tutorial-java/ui/features/components.html

import controller.Controller;
import controller.Pair;
import output.monitor.AllButtons;
import output.monitor.eventHandler.ButtonEvent;
import output.monitor.eventHandler.ButtonListener;
import output.monitor.eventHandler.KeyMonitor;
import output.monitor.panel.ButtonPanel;
import output.monitor.panel.NumberPanel;
import output.monitor.panel.RoomPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Holds panels that make up the UI.
 * Created by Jon Mercer on 15-07-23.
 */
public class MainFrame extends JFrame {

    private static final boolean BUTTON_PANEL_ON = false;
    private RoomPanel roomPanel = new RoomPanel();
    private NumberPanel numberPanel = new NumberPanel();
    private ButtonPanel buttonPanel = new ButtonPanel();

    private Controller controller;


    /**
     * @param title goes on top of the window
     * @param controller the logic that generates numbers to be placed on screen
     * @param restore find out if system crashed/rebooted with info in it.
     */
    public MainFrame(String title, final Controller controller, boolean restore) {

        super(title);
        this.controller = controller;

        //The opposite of addActionListener. Monitors when UI button is pressed
        buttonPanel.addButtonListener(new ButtonListener() {
            public void buttonEventOccurred(ButtonEvent event) {
                filterWhatButtonWasPressed(event.getButton());
            }
        });
        //Monitors when keyboard button is pressed
        KeyMonitor monitor = new KeyMonitor(this);
        addKeyListener(monitor);

        setFocusable(true);
        setLayout(new BorderLayout());

        Container container = getContentPane();
        container.add(roomPanel, BorderLayout.CENTER);
        container.add(numberPanel, BorderLayout.WEST);
        if (BUTTON_PANEL_ON) container.add(buttonPanel, BorderLayout.SOUTH);

        if (restore) {
            controller.loadState();
            showCounter();
            showRooms();
        }
    }

    private void showCounter() {
        Integer counterNumber = this.controller.getScreenNumber();
        numberPanel.setText(counterNumber.toString());
    }

    private void showRooms() {
        Object[] pairs = this.controller.getRoomsData();
        setRoomText(pairs);
    }

    public void filterWhatButtonWasPressed(AllButtons buttonLabel) {
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
                System.err.println("ERROR: Button Does not Exist");
        }
    }

    private void printTicket() {
        Integer printNumber = controller.print();

        buttonPanel.setPrintLabel("Print:" + printNumber.toString());
        numberPanel.setPrintLabel("Print:" + printNumber.toString());

    }

    private void updateCounterAndRoom(int roomNum) {
        Integer counterNumber = this.controller.increment();
        numberPanel.setText(counterNumber.toString());

        Object[] pairs = this.controller.roomButtonPressed(counterNumber, roomNum);

        setRoomText(pairs);
    }

    private void setRoomText(Object[] pairs) {

        //TODO: refactor room rows as list
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

    public void restore() {

    }
}
