package com.lld.calendar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class scheduler {

    static class Interval {
        long start;
        long end;
        public Interval(long start, long end)
        {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Start:" + start + " End:" + end;

        }
    }
    static class Event {
        long time;
        int delta;
        public Event(long time, int delta)
        {
            this.time = time;
            this.delta = delta;
        }
    }



    public static List<Interval> freeSlots(List<List<Interval>> users,int windowStart,
                                    int windowEnd,
                                    int duration)
    {
        List<Event> events = new ArrayList<>();
        List<Interval> res = new ArrayList<>();

        for(List<Interval> intervals : users)
        {
            for (Interval i : intervals)
            {
                events.add(new Event(i.start,1));
                events.add(new Event(i.end,-1));
            }
        }

        Collections.sort(events, (a,b) -> a.time != b.time ? (int)(a.time - b.time) : a.delta - b.delta);

        long freeStart =windowStart;
        int busyCount = 0;

        for(Event e : events)
        {
            if(busyCount == 0 && e.time - freeStart >= duration)
            {
                res.add(new Interval(freeStart, e.time));
            }

            busyCount += e.delta;
            if(busyCount == 0)
            {
                freeStart = e.time;
            }
        }

        if(busyCount == 0 && windowEnd - freeStart >= duration)
        {
            res.add(new Interval(freeStart, windowEnd));
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Interval>> users = new ArrayList<>();

        users.add(List.of(new Interval(540,600), new Interval(720, 780)));
        users.add(List.of(new Interval(570,660), new Interval(720, 780)));

        System.out.println(freeSlots(users,540,1080,30));


    }
}
