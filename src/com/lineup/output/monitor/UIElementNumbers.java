package output.monitor;

/**
 * Created by Jon Mercer on 15-08-02.
 */
public enum UIElementNumbers {
    WINDOW_WIDTH(700.0),
    WINDOW_HEIGHT(500.0),
    PANEL_BUTTON_HEIGHT(60.0),
    PANEL_NUMBER_WIDTH(0.3),
    PANEL_ROOM_WIDTH(0.7),
    PANEL_ROOM_FONT(60.0);


    private Double number;

    UIElementNumbers(Double number) {
        this.number = number;
    }

    public int getInt() {

        switch (this) {
            case WINDOW_HEIGHT:
                return number.intValue();
            case WINDOW_WIDTH:
                return number.intValue();
            case PANEL_BUTTON_HEIGHT:
                return number.intValue();
            case PANEL_NUMBER_WIDTH:
                return valueOfPercent(PANEL_NUMBER_WIDTH.number, WINDOW_WIDTH.number);
            case PANEL_ROOM_WIDTH:
                return valueOfPercent(PANEL_ROOM_WIDTH.number, WINDOW_WIDTH.number);
            case PANEL_ROOM_FONT:
                return number.intValue();
        }
        return (int) Math.floor(number);
    }

    private int valueOfPercent(Double percent, Double percentOf) {
        Double temp = percentOf * percent;
        return temp.intValue();
    }
    }
