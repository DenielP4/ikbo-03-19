package practice9;

public class Student implements Comparable{
    private int mark;
    private String name;

    Student(String name, int mark) {
        this.mark = mark;
        this.name = name;
    }
    @Override
    public Object getMark() {
        return mark;
    }
    @Override
    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String getName() {
        return name;
    }
}
