package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<Player> a=new ArrayList<>(5);
        a.add(new Player("football","Ronaldo",35));
        a.add(1,new Player("basketball","Lebron",33));
        a.add(new Player("football","Messi",30));
        a.add(3,new Player("tennis","Nadal",37));
        a.add(new Player("football","Neymar",28));
        Collections.sort(a,Player::compareTo);
        for(Player p:a){
            System.out.println(p);

        }
    }
}
