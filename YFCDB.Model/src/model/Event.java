package model;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Event here.
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class Event
{
    private String name, type, venue, notes;
    private int regFee, noOfAttendees, timeStart, timeEnd;
    private Date date;
    private ArrayList<Attendee> attendees = new ArrayList<Attendee>();

    public Event(String n, String t, String v, String nts, int rf, int dd, int mm, int yyyy, 
    int start, int end)
    {
        name = n;
        type = t;
        venue = v;
        notes = nts;
        regFee = rf;
        setDate(dd, mm, yyyy);
        setTimes(start, end);
        EventList.addEvent(this);
    }

    private void setDate(int mm, int dd, int yyyy)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mm-1);
        cal.set(Calendar.DATE, dd);
        cal.set(Calendar.YEAR, yyyy);
        date = cal.getTime();
    }

    public String getStringDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String stringDate = dateFormat.format(this.date);
        return stringDate;
    }
    
    public Date getDate()
    {
        return this.date;
    }
    
    public String getTimes()
    {
        return timeStart + "-" + timeEnd;
    }

    private void setTimes(int start, int end)
    {
        timeStart = start;
        timeEnd = end;
    }
    
    public void addAttendee(Member m, String r)
    {
        Attendee a = new Attendee(m, r);
        attendees.add(a);
    }

    public void printEvent()
    {
        System.out.println(name);
        System.out.println(type);
        System.out.println(venue);
        System.out.println(notes);
        System.out.println(regFee);
        System.out.println(noOfAttendees);
        System.out.println(getDate());
        System.out.println(getTimes());
        
        for(Attendee attendee: attendees)
        {
            System.out.println(attendee.member.getID() + ":" + attendee.getAttendee());
        }
    }
}