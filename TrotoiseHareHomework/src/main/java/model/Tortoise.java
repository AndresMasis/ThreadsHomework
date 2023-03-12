package model;

import controller.Controller;

public class Tortoise extends Competitor{
    
    private int maxSpeed;

    public Tortoise(Controller control){
        super(control);
        maxSpeed = 15;
        this.speed = 1;  // The tortoise starts slow
        this.sleepTime = 500; // Just half second to make it visual
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }
}
