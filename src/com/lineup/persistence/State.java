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

    public State(int pNum, int qNum, Deque<Pair> deque) {
        this.pNum = pNum;
        this.qNum = qNum;
        this.deque = deque;
    }

    public int getpNum() {
        return pNum;
    }

    public int getqNum() {
        return qNum;
    }

    public Deque<Pair> getDeque() {
        return deque;
    }


}
