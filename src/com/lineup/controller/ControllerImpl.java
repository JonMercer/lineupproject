package controller;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
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
    private final Deque<Pair> arrayDeque = new ArrayDeque<Pair>();

    public ControllerImpl() {
        screenNumber = new AtomicInteger(INITIAL_NUMBER);
        printNumber = new AtomicInteger(INITIAL_NUMBER);
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
        if (screenNumber.get() <= INITIAL_NUMBER) {
            screenNumber.set(INITIAL_NUMBER);
            return screenNumber.get();
        }

        return screenNumber.decrementAndGet();
    }

    @Override
    public Integer reset() {
        screenNumber.set(INITIAL_NUMBER);
        printNumber.set(INITIAL_NUMBER);
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
    public Iterator<Pair> roomButtonPressed(int screenNum, int roomNum) {

        Pair<Integer, Integer> roomPair = new Pair<Integer, Integer>(screenNum, roomNum);

        arrayDeque.addFirst(roomPair);

        while (arrayDeque.size() > MAX_DEQUE_SIZE) {
            arrayDeque.removeLast();
        }

        return arrayDeque.iterator();
    }
}
