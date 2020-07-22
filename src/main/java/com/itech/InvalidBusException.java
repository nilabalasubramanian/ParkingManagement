package com.itech;

public class InvalidBusException extends Exception {
    String Message;
    public InvalidBusException()
    {

    }
    public InvalidBusException(String Message)
    {
        this.Message=Message;
    }
}
