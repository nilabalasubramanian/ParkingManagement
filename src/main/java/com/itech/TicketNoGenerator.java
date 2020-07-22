package com.itech;

public class TicketNoGenerator {
    static int i;
    public int generateTicketNo(int busNo)
    {
        i++;
        return Integer.parseInt(busNo+String.valueOf(i));
    }

}
