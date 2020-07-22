package com.itech;

public class TicketAlreadyExistException extends Exception {
    String Message;
    public TicketAlreadyExistException()
    {

    }
    public TicketAlreadyExistException(String Message)
    {
        this.Message=Message;
    }

}

