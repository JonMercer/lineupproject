package output.monitor.eventHandler;

import java.util.EventListener;

/**
 * Created by Jon Mercer on 15-07-29.
 */
public interface ButtonListener extends EventListener {
    public void buttonEventOccurred(ButtonEvent event);
}
