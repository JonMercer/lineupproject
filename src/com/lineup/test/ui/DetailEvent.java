package test.ui;

import java.util.EventObject;

/**
 * Created by Odin on 15-07-23.
 */
public class DetailEvent extends EventObject {
    private String text;

    public DetailEvent(Object source, String text) {
        super(source);

        this.text = text;

    }

    public String getText() {
        return this.text;
    }
}
