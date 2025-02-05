package com.example.tableview;
public class Task {
    private String Subject;
    private String date;
    private String time;
    private String location;
    private String details;
    public Task(String Subj,String date, String time, String location, String details){
        this.Subject=Subj;
        this.time=time;
        this.date=date;
        this.location=location;
        this.details=details;
    }
    public String getSubject(){
        return this.Subject;
    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return this.time;
    }
    public String  getLocation(){
        return this.location;
    }
    public String getDetails(){
        return this.details;
    }
    public void setSubject(String subj){
        Subject=subj;
    }
    public void setDate(String date){
        this.date=date;
    }
    public void setTime(String time){
        this.time=time;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public void setDetails(String details){
        this.details=details;
    }
    public String toString(){
        return "Subject: "+this.Subject+"\nDate: "+this.date+ "\nTime "+this.time+"\nLocation:"+this.location
                +"\nDetails"+ this.details;
    }
}