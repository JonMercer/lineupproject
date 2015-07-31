package controller;

import java.util.Iterator;

/**
 * Controls the button logic.
 * Created by Jon Mercer on 15-07-25.
 */
public interface Controller {

    /*
    * Increment the number on the screen. Mod ceiling
    *
    * @return: the incremented number
    * */
    public Integer increment();

    /*
    * Decrement the number on the screen. Will hit a floor. Changes the print number as well.
    *
    * @return: the decremented number
    * */
    public Integer decrement();

    /*
    * Set the print and screen number to floor.
    *
    * @return: the floor
    * */
    public Integer reset();

    /*
    * Increments the print number. This never decrements unless reset.
    *
    * @return: the number to print
    * */
    public Integer print();

    Object[] roomButtonPressed(int screenNum, int roomNum);
}
