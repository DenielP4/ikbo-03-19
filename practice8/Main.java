package practice8;

public class Main {

    public static void main(String[] args) {
        WaitList<Integer> iw=new WaitList<>();
        UnfairWaitList<Integer>u=new UnfairWaitList<>();
        BoundedWaitList<Integer>b=new BoundedWaitList<>(6);
        for(int i=0;i<10;i++){
            iw.add(i);
            if(i<6){
                b.add(i);
            }
            u.add(i);
        }

        u.moveToBack(u.remove());
        System.out.println(iw.toString()+" "+iw.contains(10));
        System.out.println(b.toString());
        System.out.println(u.toString());
    }
}
