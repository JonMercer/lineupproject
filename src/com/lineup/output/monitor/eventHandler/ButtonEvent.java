package output.monitor.eventHandler;

import java.util.EventObject;

/**
 * Created by Jon Mercer on 15-07-29.
 */
public class ButtonEvent extends EventObject {

    private String text;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ButtonEvent(Object source, String text) {
        super(source);

        this.text = text;
    }

    public String getText() {
        return text;
    }
}
