package practice9;

public class LabClass {
    Student[] sort;
    private int temp = 0;
    public LabClass(Student[] sort)
    {
        this.sort = sort;
    }
    public String findStudent(String name)
    {
        for (int i = 0; i < sort.length; i++)
        {
            if (sort[i].getName().equals(name)) {return sort[i].getName();}
        }
        throw new StudentNotFoundException("Student not found");
    }
    public void quickSort(int low, int high) {
        if (sort.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = (int)sort[middle].getMark();
        int i = low, j = high;
        while (i <= j) {
            while ((int)sort[i].getMark() < opora) {
                i++;
            }
            while ((int)sort[j].getMark() > opora) {
                j--;
            }
            if (i <= j) {
                int temp = (int)sort[i].getMark();
                sort[i].setMark((int)sort[j].getMark());
                sort[j].setMark(temp);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }
}
