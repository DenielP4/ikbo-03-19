package lab5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel {
    public static void main(String[] args){
        JFrame frame=new JFrame("Lab5");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(1,1));
        Random rand = new Random();
        Circle circle;
        Rect rect;
        Arc arc;
        for(int i=0;i<20;++i){
            switch (Math.abs(rand.nextInt()%3)){
                case 0:
                    circle=new Circle();
                    frame.add(circle);
                    frame.setVisible(true);
                    break;
                case 1:
                    rect=new Rect();
                    frame.add(rect);
                    frame.setVisible(true);
                    break;
                case 2:
                    arc=new Arc();
                    frame.add(arc);
                    frame.setVisible(true);
                    break;
            }
        }
    }
}
