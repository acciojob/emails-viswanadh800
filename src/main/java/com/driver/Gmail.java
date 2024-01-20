package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java .util.LinkedList;

public class Gmail extends Email {

    class Data {
        Date date;
        String sender;
        String message;

        Data(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }
    }

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    LinkedList<Data> inbox;  //near tail is latest
    LinkedList<Data> thrashbox;
    int currCapacity;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        inbox=new LinkedList<>();
        thrashbox=new LinkedList<>();
        currCapacity=0;
    }

    public void receiveMail(Date date, String sender, String message) {
        Data data=new Data(date,sender,message);
        inbox.addLast(data);
        currCapacity+=1;
        if(currCapacity>inboxCapacity){
            data=inbox.removeFirst();
            currCapacity-=1;
            thrashbox.addLast(data);
        }
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message) {
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int i=0;
        Data data;
        LinkedList<Data> temp=inbox;
        for(;i<inbox.size();i++){
            if(temp.get(i).message.equals(message)) {
                data=inbox.remove(i);
                thrashbox.addLast(data);
                currCapacity-=1;
                break;
            }
        }
    }

    public String findLatestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size()>0)
            return inbox.peekLast().message;
        else return null;
    }

    public String findOldestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size()>0)
            return inbox.peekFirst().message;
        else return null;
    }

    public int findMailsBetweenDates(Date start, Date end) {
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int ans=0;
        LinkedList<Data> temp=inbox;
        for(int i=0;i<temp.size();i++){
            if((temp.get(i).date.before(end) && temp.get(i).date.after(start)) || temp.get(i).date.equals(start) || temp.get(i).date.equals(end))
                ans++;
        }
        return ans;
    }

    public int getInboxSize() {
        // Return number of mails in inbox
        return currCapacity;
    }

    public int getTrashSize() {
        // Return number of mails in Trash
        return thrashbox.size();
    }

    public void emptyTrash() {
        // clear all mails in the trash
        while(thrashbox.size()>0)
            thrashbox.remove(0);
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
