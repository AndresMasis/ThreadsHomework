package model;

import controller.Controller;

public abstract class Competitor extends Thread{
    int position;
    int speed;
    int sleepTime;
    Controller control;

    public Competitor(Controller control){
        super();
        this.position = 0;  // Initial position at 0
        this.control = control;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }

    // This method is called when the thread runs
    @Override
    public void run() {
        position = 0;
        System.out.println("Inicio: " + speed);
        while(position <= 500){
            position += speed;
            control.move(speed);
            
            try{
                Thread.sleep(sleepTime);
            }catch(InterruptedException e){
                System.out.println("Ocurrio un error");
            }
        }
        control.finishCompetitor(speed);
    }

}
