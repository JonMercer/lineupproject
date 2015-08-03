package persistence;

import controller.Pair;

import java.util.Deque;

/**
 * Created by Jon Mercer on 15-08-03.
 */
public class State {


    private final int pNum;
    private final int qNum;
    private final Deque<Pair> deque;

    public State(int screenNumber, int printNumber, Deque<Pair> deque) {
        this.pNum = screenNumber;
        this.qNum = printNumber;
        this.deque = deque;
    }

    public int getPrintNum() {
        return pNum;
    }

    public int getScreenNum() {
        return qNum;
    }

    public Deque<Pair> getDeque() {
        return deque;
    }


}
