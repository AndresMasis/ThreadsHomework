package controller;

import model.Hare;
import model.Tortoise;
import view.MyGui;

public class Controller {
    private Hare hare;
    private Tortoise tortoise;
    private MyGui gui;
    private boolean tortoiseFinished, hareFinished;

    public Controller(MyGui gui) {
        this.gui = gui;
    }

    public void startRace() throws InterruptedException {
        gui.resetCompetitors();
        tortoiseFinished = hareFinished = false;
        startThreads();
    }

    
    private void startThreads()throws InterruptedException {
        hare = new Hare(this);
        tortoise = new Tortoise(this);
        
        hare.start();
        hare.sleep(50);
        tortoise.start();
        tortoise.sleep(50);
    
    }

    public void changeSpeed(int speed){
        // Speed tells us if is tortoise or hare, hare is fast and tortoise slow
        if(speed <= tortoise.getMaxSpeed()){
            tortoise.setSpeed(speed);
        }else{
            hare.setSpeed(speed);
        }
    }
    
    public void changeSleepTime(int time){
        hare.setSleepTime(time*1000); // Has to multiply it by 1000 to make it seconds
    }
    
    public void move(int speed){
        if(speed <= tortoise.getMaxSpeed()){
            gui.moveTortoise(speed);
        } else {
            gui.moveHare(speed);
        }
    }
    
    public void finishCompetitor(int speed){
        if(speed <= tortoise.getMaxSpeed()){
            tortoiseFinish();
        } else {
            hareFinish();
        }
    }
    
    public void tortoiseFinish(){
        gui.finishTortoise();
        tortoiseFinished = true;
        hasToSetButton();
    }

    public void hareFinish(){
        gui.finishHare();
        hareFinished = true;
        hasToSetButton();
    }
    
    private void hasToSetButton() {
        if (tortoiseFinished && hareFinished){
            gui.resetStartButton();
        }
    }
}
