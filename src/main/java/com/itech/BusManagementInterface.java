package com.itech;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.HashMap;

public interface BusManagementInterface {
    public boolean issueTicket(int busNo,Ticket t)throws  TicketAlreadyExistException, LimitExceededException;
    HashMap<Integer,Integer>getCountOfSeniorCitizens();
    public boolean cancelTicket(int busNo,int ticketNo)throws InvalidBusException,TicketNotPresentException;
    ArrayList<Passenger>getPassengersByGender(String gender);
    long getCountOfPassengers(String source,String destination);
}
