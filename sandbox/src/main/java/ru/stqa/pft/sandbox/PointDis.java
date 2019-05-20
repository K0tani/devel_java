package ru.stqa.pft.sandbox;

public class PointDis {
  public static void main(String[] args) {

    Point p1 = new Point(-20, 30);
    Point p2 = new Point(50, -35);

    System.out.println("Расстояние между точками " + "p1(" + p1.x + ";" + p1.y + ") и " + "p2(" + p2.x + ";" + p2.y + ") = " + p1.distance(p1, p2));

    Point p3 = new Point(0, 13);
    Point p4 = new Point(5, -5);

    System.out.println("Расстояние между точками " + "p3(" + p3.x + ";" + p3.y + ") и " + "p4(" + p4.x + ";" + p4.y + ") = " + p1.distance(p3, p4));
  }

}

