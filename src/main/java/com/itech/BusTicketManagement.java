package com.itech;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BusTicketManagement implements BusManagementInterface{
    private Bus bus;
   private TicketNoGenerator ticketNoGenerator=new TicketNoGenerator();

    public BusTicketManagement() {
        this.bus = bus;
        this.ticketNoGenerator=ticketNoGenerator;
    }
    public TicketNoGenerator getTicketNoGenerator() {
        return ticketNoGenerator;
    }

    public void setTicketNoGenerator(TicketNoGenerator ticketNoGenerator) {
        this.ticketNoGenerator = ticketNoGenerator;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "BusTicketManagement{" +
                "bus=" + bus +
                ", ticketNoGenerator=" + ticketNoGenerator +
                '}';
    }

    @Override
    public boolean issueTicket(int busNo, Ticket t) throws TicketAlreadyExistException, LimitExceededException {
       long c=bus.getTicket().stream().filter(i->i.getTicketNo()==t.getTicketNo()).count();
       if(c!=0)
        throw new TicketAlreadyExistException();
       if(bus.getTicket().size()>50)
           throw new LimitExceededException();
       if(bus.getBusNo()!=busNo)
        return false;
       bus.getTicket().add(t);
        return true;
    }

    @Override
    public HashMap<Integer, Integer> getCountOfSeniorCitizens() {
        int cs=(int)bus.getTicket().stream().filter(i->i.getPassenger() instanceof SeniorCitizen).count();
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(bus.getBusNo(),cs);
        return map;
    }

    @Override
    public boolean cancelTicket(int busNo, int ticketNo) throws InvalidBusException, TicketNotPresentException {
        if(bus.getBusNo()!=busNo)
        throw new InvalidBusException();
        List<Ticket> t=bus.getTicket().stream().filter(i->i.getTicketNo()==ticketNo).collect(Collectors.toList());

        if(t.isEmpty())
        throw new TicketNotPresentException();
        bus.getTicket().remove(t.get(0));
        return true;
    }

    @Override
    public ArrayList<Passenger> getPassengersByGender(String gender) {
        return (ArrayList<Passenger>) bus.getTicket().stream().map(Ticket::getPassenger).filter(i->i.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
    }

    @Override
    public long getCountOfPassengers(String source, String destination) {
        return bus.getTicket().stream().map(Ticket::getPassenger).filter(i->i.getSource().equalsIgnoreCase(source)&&i.getDestination().equalsIgnoreCase(destination)).count();
    }


}
