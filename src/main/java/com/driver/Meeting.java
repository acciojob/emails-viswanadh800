package com.driver;

import java.time.LocalTime;

public class Meeting implements Comparable<Meeting>{
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime(){
        return startTime;
    }
    public LocalTime getEndTime(){
        return endTime;
    }
    public int compareTo(Meeting m2){
        LocalTime t1=this.endTime;
        LocalTime t2=m2.endTime;
        if(t1.getHour()<t2.getHour())
            return 1;
        else if(t1.getHour()>t2.getHour())
            return -1;
        else{
            if(t1.getMinute()<t2.getMinute())
                return 1;
            else //if(t1.getHour()>t2.getHour())
                return -1;
        }
    }
}
