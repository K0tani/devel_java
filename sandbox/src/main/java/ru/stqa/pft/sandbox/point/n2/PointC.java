package ru.stqa.pft.sandbox.point.n2;

public class PointC { //созданый класс

  public double x; //атрибуты
  public double y; //атрибуты

  public PointC(double x, double y) { //конструктор
    this.x = x; //новые обьекты
    this.y = y; //новые обьекты
  }

  public double distance(PointC p1, PointC p2) { //метод
    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }
}


