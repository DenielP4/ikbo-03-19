package ru.mirea.laba2.circle;

public class Circle {
    double rad,area,pir;
    Circle(double rad){
        resetRad(rad);
    }
    void resetRad(double rad){
        this.rad=rad;
        area=3.14*rad*rad;
        pir=2*3.14*rad;
    }
}
