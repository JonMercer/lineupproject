package controller;

import persistence.Persistence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Controls all logic of button presses.
 * <p/>
 * Created by Jon Mercer on 15-07-25.
 */
public class ControllerImpl implements Controller {

    private static final int INITIAL_NUMBER = 0;
    private static final int MAX_NUMBER = 10;
    private static final int MAX_DEQUE_SIZE = 100;

    private final AtomicInteger screenNumber;
    private final AtomicInteger printNumber;
    private final Deque<Pair> arrayDeque;
    private final Persistence persistence;

    public ControllerImpl(Persistence persistence) {

        screenNumber = new AtomicInteger(INITIAL_NUMBER);
        printNumber = new AtomicInteger(INITIAL_NUMBER);
        arrayDeque = new ArrayDeque<Pair>();

        this.persistence = persistence;
        if(this.persistence.accidentalReboot()) {
            screenNumber.set(persistence.loadState().getScreenNum());
            printNumber.set(persistence.loadState().getPrintNum());
            arrayDeque.addAll(persistence.loadState().getDeque());
        }
    }

    @Override
    public Integer increment() {
        if (screenNumber.get() >= MAX_NUMBER) {
            screenNumber.set(INITIAL_NUMBER);
            printNumber.set(INITIAL_NUMBER);
        }

        if (screenNumber.get() >= printNumber.get()) {
            printNumber.set(screenNumber.get() + 1);
        }

        return screenNumber.incrementAndGet();
    }

    @Override
    public Integer decrement() {
        if (screenNumber.get() == INITIAL_NUMBER && arrayDeque.size() == 0) {
            screenNumber.set(INITIAL_NUMBER);
            return screenNumber.get();
        } else if (screenNumber.get() == 1 && arrayDeque.size() != 1) {
            screenNumber.set(MAX_NUMBER);
            return screenNumber.get();
        }

        return screenNumber.decrementAndGet();
    }

    @Override
    public Integer reset() {
        screenNumber.set(INITIAL_NUMBER);
        printNumber.set(INITIAL_NUMBER);

        while(arrayDeque.size() != 0) {
            arrayDeque.remove();
        }
        return screenNumber.get();
    }

    @Override
    public Integer print() {
        if (printNumber.get() >= MAX_NUMBER) {
            printNumber.set(INITIAL_NUMBER);

        }
        return printNumber.incrementAndGet();
    }

    @Override
    public Integer getScreenNumber() {
        return screenNumber.get();
    }

    @Override
    public Object[] getRoomsData() {
        return arrayDeque.toArray();
    }

    @Override
    public Object[] roomButtonPressed(int screenNum, int roomNum) {

        Pair<Integer, Integer> roomPair = new Pair<Integer, Integer>(screenNum, roomNum);

        arrayDeque.addFirst(roomPair);

        while (arrayDeque.size() > MAX_DEQUE_SIZE) {
            arrayDeque.removeLast();
        }

        return arrayDeque.toArray();
    }

    @Override
    public Object[] decrementButtonPressed() {
        if (arrayDeque.size() > 0) {
            arrayDeque.pop();
        }
        return arrayDeque.toArray();
    }

}
