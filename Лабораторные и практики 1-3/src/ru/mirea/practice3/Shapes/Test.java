package ru.mirea.practice3.Shapes;

public class Test {
    public static void main(String[] args) {
        System.out.println("-------------Первая проверка-------------");
        Shape s1 = new Circle("RED", false, 5.5); // Upcast
        System.out.println(s1); // Метод вызывается из класса Circle
        System.out.println(s1.getArea()); // Метод вызывается из класса Circle
        System.out.println(s1.getPerimeter()); // Метод вызывается из класса Circle
        System.out.println(s1.getColor()); // Метод вызывается из класса Shape
        System.out.println(s1.isFilled()); // Метод вызывается из класса Shape
        //System.out.println(s1.getRadius()); // Метод getRadius не существует в классе Shape

        System.out.println("-------------Вторая проверка-------------");
        Circle c1 = (Circle) s1; // Downcast back to Circle
        System.out.println(c1); // Метод вызывается из класса Circle
        System.out.println(c1.getArea()); // Метод вызывается из класса Circle
        System.out.println(c1.getPerimeter()); // Метод вызывается из класса Circle
        System.out.println(c1.getColor()); // Метод вызывается из класса Shape
        System.out.println(c1.isFilled()); // Метод вызывается из класса Shape
        System.out.println(c1.getRadius()); // Метод вызывается из класса Circle
        //Shape s2 = new Shape(); // Нельзя создать экземпляр абстрактого класса Shape

        System.out.println("-------------Третья проверка-------------");
        Shape s3 = new Rectangle("RED", false, 1.0, 2.0); // Upcast
        System.out.println(s3); // Метод вызывается из класса Rectangle
        System.out.println(s3.getArea()); // Метод вызывается из класса Rectangle
        System.out.println(s3.getPerimeter()); // Метод вызывается из класса Rectangle
        System.out.println(s3.getColor()); // Метод вызывается из класса Shape
        //System.out.println(s3.getLength()); // Метод getLength не существует в классе Shape

        System.out.println("-------------Четвертая проверка-------------");
        Rectangle r1 = (Rectangle) s3; // downcast
        System.out.println(r1); // Метод вызывается из класса Rectangle
        System.out.println(r1.getArea()); // Метод вызывается из класса Rectangle
        System.out.println(r1.getColor()); // Метод вызывается из класса Shape
        System.out.println(r1.getLength()); // Метод вызывается из класса Rectangle

        System.out.println("-------------Пятая проверка-------------");
        Shape s4 = new Square(6.6); // Upcast
        System.out.println(s4); // Метод вызывается из класса Square
        System.out.println(s4.getArea()); // Метод вызывается из класса Rectangle
        System.out.println(s4.getColor()); // Метод вызывается из класса Shape
        //System.out.println(s4.getSide()); // Метод getSide не существует в классе Shape

        System.out.println("-------------Шестая проверка-------------");
        Rectangle r2 = (Rectangle) s4; // downcast
        System.out.println(r2); // Метод вызывается из класса Square
        System.out.println(r2.getArea()); // Метод вызывается из класса Rectangle
        System.out.println(r2.getColor()); // Метод вызывается из класса Shape
        //System.out.println(r2.getSide()); // Метод вызывается не существует в классе Rectangle
        System.out.println(r2.getLength()); // Метод вызывается из класса Rectangle

        System.out.println("-------------Седьмая проверка-------------");
        Square sq1 = (Square) r2; // Downcast
        System.out.println(sq1); // Метод вызывается из класса Square
        System.out.println(sq1.getArea()); // Метод вызывается из класса Rectangle
        System.out.println(sq1.getColor()); // Метод вызывается из класса Shape
        System.out.println(sq1.getSide()); // Метод вызывается из класса Square
        System.out.println(sq1.getLength()); // Метод вызывается из класса Rectangle
    }
}
