package ru.stqa.pft.sandbox;

public class Point { //созданый класс

  public double x; //атрибуты
  public double y; //атрибуты

  public Point(double x, double y) { //конструктор
    this.x = x; //новые обьекты
    this.y = y; //новые обьекты
  }

  public double distance(Point p1, Point p2) { //метод
    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }
}


