package ru.stqa.pft.sandbox;

public class PointDis {
  public static void main(String[] args) {

    Point p1 = new Point(-20, 30);
    Point p2 = new Point(50, -35);

    System.out.println("Расстояние между точками " + "p1(" + p1.x + ";" + p1.y + ") и " + "p2(" + p2.x + ";" + p2.y + ") = " + p1.distance(p1, p2));
  }

}

