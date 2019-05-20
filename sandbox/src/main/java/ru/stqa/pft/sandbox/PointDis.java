package ru.stqa.pft.sandbox;

public class PointDis {
  public static void main(String[] args) {

    PointC p1 = new PointC(-20, 30);
    PointC p2 = new PointC(50, -35);

    System.out.println("Расстояние между точками p1 и p2 = " + p1.distance(p2));

    PointC p3 = new PointC(0, 13);
    PointC p4 = new PointC(5, -5);

    System.out.println("Расстояние между точками p3 и p4 = " + p3.distance(p4));
  }

}

