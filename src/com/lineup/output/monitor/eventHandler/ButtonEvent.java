package output.monitor.eventHandler;

import output.monitor.AllButtons;

import java.util.EventObject;

/**
 * Created by Jon Mercer on 15-07-29.
 */
public class ButtonEvent extends EventObject {

    private AllButtons button;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @param button
     * @throws IllegalArgumentException if source is null.
     */
    public ButtonEvent(Object source, AllButtons button) {
        super(source);

        this.button = button;
    }

    public AllButtons getButton() {
        return button;
    }
}
