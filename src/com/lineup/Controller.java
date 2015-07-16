package com.lineup;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jon on 15-07-15.
 */
public class Controller {

    //zero is too confusing for people
    private static final int LOWEST_NUMBER = 1;
    private final AtomicInteger currentNumber = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println("currentNumber is " + currentNumber.get());
    }

    public void increment() {

        //this should not happen
        if (currentNumber.get() == Integer.MAX_VALUE) {
            currentNumber.set(LOWEST_NUMBER);
        }

        int incrementedNumber = currentNumber.incrementAndGet();
        //output.outputNumber(incrementedNumber);
    }

    public void decrement() throws Exception {

        if(currentNumber.get() < LOWEST_NUMBER) {
            throw new Exception("number cannot be negative");
        }

        if(currentNumber.get() == LOWEST_NUMBER) {
            //output.outputNumber(currentNumber.get());
        } else {
            int decrementedNumber = currentNumber.decrementAndGet();
            //output.outputNumber(decrementedNumber);
        }
    }

    public void reset() {
        currentNumber.set(LOWEST_NUMBER);
    }
}
