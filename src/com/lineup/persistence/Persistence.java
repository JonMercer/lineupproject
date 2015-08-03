package persistence;

import controller.Pair;

import java.util.Deque;

/**
 * Created by Jon Mercer on 15-08-03.
 */
public interface Persistence {

    public boolean accidentalReeboot();

    public void saveState(State state);

    public State loadState();
}
