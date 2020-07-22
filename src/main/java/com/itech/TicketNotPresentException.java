package com.itech;

public class TicketNotPresentException extends Exception {
    String Message;
    public TicketNotPresentException()
    {

    }
    public TicketNotPresentException(String Message)
    {
        this.Message=Message;
    }
}
