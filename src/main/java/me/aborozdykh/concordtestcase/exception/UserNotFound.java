package me.aborozdykh.concordtestcase.exception;

/**
 * @author Andrii Borozdykh
 */
public class UserNotFound extends Exception{
    public UserNotFound(String message) {
        super(message);
    }
}
