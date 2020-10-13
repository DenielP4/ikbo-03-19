package lab10;

public class SuperArray <E> {
    private E [] a;
    E getArrIndex(int i){
        return  a[i] ;
    }
    public void setA(E [] a){
        this.a = a;
    }
    public int getLength(){
        return  a.length ;
    }
}
