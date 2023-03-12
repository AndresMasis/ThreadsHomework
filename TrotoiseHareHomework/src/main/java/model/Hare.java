package model;

import controller.Controller;

public class Hare extends Competitor{
    public Hare(Controller control){
        super(control);
        this.speed = 20; // The hare starts fast
        this.sleepTime = 2000;  // The hare sleeps for 2 seconds
    }

    public void setSleepTime(int sleepTime){
        this.sleepTime = sleepTime;
    }



}
