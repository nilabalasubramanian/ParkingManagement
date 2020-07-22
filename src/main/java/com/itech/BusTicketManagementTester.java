package com.itech;

import javax.naming.LimitExceededException;

public class BusTicketManagementTester {
    public static void main(String []args) throws TicketAlreadyExistException, LimitExceededException {
        BusTicketManagement b=new BusTicketManagement();
        Passenger p1=new Passenger("Rohinth","Male","Thanjavur","karur");
        Passenger p2=new Passenger("Bhuvan","Female","Thanjavur","Chennai");
        Passenger p3=new SeniorCitizen("Nila","Female","Thanjavur","Madurai",98);
        Bus bus=new Bus(121,"Thanjavur","Madurai");
        b.setBus(bus);
        int tn1=b.getTicketNoGenerator().generateTicketNo(121);
        Ticket t1=new Ticket(tn1,375.67,p3);
        b.issueTicket(121,t1);
        System.out.println(b.getPassengersByGender("Female"));
        System.out.println(b.getCountOfPassengers("Thanjavur","Madurai"));
        System.out.println(b.getCountOfSeniorCitizens());
    }


}
