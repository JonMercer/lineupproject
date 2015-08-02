package output.monitor;

/**
 * Enum of button labels.
 * Created by Jon Mercer on 15-07-29.
 */
public enum AllButtons {
    DOWN    ("down"),
    PRINT   ("print"),
    RESET   ("reset"),
    R1      ("room1"),
    R2      ("room2"),
    R3      ("room3"),
    R4      ("room4"),
    R5      ("room5"),
    R6      ("room6"),
    R7      ("room7"),
    R8      ("room8"),
    R9      ("room9"),
    R10     ("room10");

    private String name;

    AllButtons(String name) {
        this.name = name;
    }

    public String getLabelName() {
        return this.name;
    }
}
