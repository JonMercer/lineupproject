package controller;

import java.util.Iterator;

/**
 * Controls the button logic.
 * Created by Jon Mercer on 15-07-25.
 */
public interface Controller {

    /**
    * Increment the number on the screen. Mod ceiling
    *
    * @return: the incremented number
    * */
    public Integer increment();

    /**
    * Decrement the number on the screen. Will hit a floor. Changes the print number as well.
    *
    * @return: the decremented number
    * */
    public Integer decrement();

    /**
    * Set the print and screen number to floor.
    *
    * @return: the floor
    * */
    public Integer reset();

    /**
    * Increments the print number. This never decrements unless reset.
    *
    * @return: the number to print
    * */
    public Integer print();

    /**
     * Grabs the current screen number. Mainly used for restoring after reboot or crash
     * @return screenNumber
     */
    public Integer getScreenNumber();

    /**
     * Grab the collection of rooms. Mainly used for restoring after reboot or crash
     * @return history of rooms
     */
    public Object[] getRoomsData();

    Object[] roomButtonPressed(int screenNum, int roomNum);

    Object[] decrementButtonPressed();
}
