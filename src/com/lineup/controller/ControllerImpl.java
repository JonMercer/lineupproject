package controller;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Controls all logic of button presses.
 *
 * Created by Jon Mercer on 15-07-25.
 */
public class ControllerImpl implements Controller {

    private static final int INITIAL_NUMBER = 0;
    private static final int MAX_NUMBER = 10;

    private final AtomicInteger screenNumber;
    private final AtomicInteger printNumber;

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

        if(screenNumber.get() >= printNumber.get()) {
            printNumber.set(screenNumber.get()+1);
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
    public int getNextRoomSectionToPopulate() {
        return 0;
    }
}
