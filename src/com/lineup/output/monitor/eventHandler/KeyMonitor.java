package output.monitor.eventHandler;

import enums.AllButtons;
import output.monitor.frame.MainFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Jon Mercer on 15-08-01.
 */
public class KeyMonitor extends KeyAdapter {
    MainFrame mainFrame;

    public KeyMonitor(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_1:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R1);
                break;
            case KeyEvent.VK_2:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R2);
                break;
            case KeyEvent.VK_3:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R3);
                break;
            case KeyEvent.VK_4:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R4);
                break;
            case KeyEvent.VK_5:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R5);
                break;
            case KeyEvent.VK_6:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R6);
                break;
            case KeyEvent.VK_7:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R7);
                break;
            case KeyEvent.VK_8:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R8);
                break;
            case KeyEvent.VK_9:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R9);
                break;
            case KeyEvent.VK_0:
                mainFrame.filterWhatButtonWasPressed(AllButtons.R10);
                break;
            case KeyEvent.VK_P:
                mainFrame.filterWhatButtonWasPressed(AllButtons.PRINT);
                break;
            case KeyEvent.VK_D:
                mainFrame.filterWhatButtonWasPressed(AllButtons.DOWN);
                break;
            case KeyEvent.VK_R:
                mainFrame.filterWhatButtonWasPressed(AllButtons.RESET);
                break;
        }
    }
}
