package ru.stqa.pft.sandbox.point.n2;

public class PointDis {
  public static void main(String[] args) {

    PointC p1 = new PointC(-20, 30);
    PointC p2 = new PointC(50, -35);

    System.out.println("Расстояние между точками " + "p1(" + p1.x + ";" + p1.y + ") и " + "p2(" + p2.x + ";" + p2.y + ") = " + p1.distance(p1, p2));

    PointC p3 = new PointC(0, 13);
    PointC p4 = new PointC(5, -5);

    System.out.println("Расстояние между точками " + "p3(" + p3.x + ";" + p3.y + ") и " + "p4(" + p4.x + ";" + p4.y + ") = " + p1.distance(p3, p4));
  }

}

