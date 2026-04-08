import java.util.Scanner;

class Shapes {
    Shapes() {
        System.out.println("Shape object created");
    }

    void area(int side) {
        int squareArea = side * side;
        System.out.println("Area of Square = " + squareArea);
    }

    void area(int length, int breadth) {
        int rectangleArea = length * breadth;
        System.out.println("Area of Rectangle = " + rectangleArea);
    }

    void area(double radius) {
        double circleArea = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + circleArea);
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shapes s = new Shapes();

        System.out.print("Enter side of square: ");
        int side = sc.nextInt();
        s.area(side);

        System.out.print("Enter length of rectangle: ");
        int length = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int breadth = sc.nextInt();
        s.area(length, breadth);

        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();
        s.area(radius);

        sc.close();
    }
}