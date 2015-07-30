package output.monitor;

/**
 * Enum of button labels.
 * Created by Jon Mercer on 15-07-29.
 */
public enum AllButtons {
    DOWN    ("down"),
    PRINT   ("print"),
    RESET   ("reset"),
    R1      ("r1"),
    R2      ("r2"),
    R3      ("r3"),
    R4      ("r4"),
    R5      ("r5"),
    R6      ("r6"),
    R7      ("r7"),
    R8      ("r8"),
    R9      ("r9"),
    R10     ("r10");

    private String name;

    AllButtons(String name) {
        this.name = name;
    }

    public String getLabelName() {
        return this.name;
    }
}
