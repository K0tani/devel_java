package ru.stqa.pft.sandbox;

public class PointC { //созданый класс

  public double x;
  //атрибуты
  public double y;
  //атрибуты

  public PointC(double x, double y) { //конструктор
    this.x = x;
    //новые обьекты
    this.y = y;
    //новые обьекты
  }

  public double distance(PointC p) { //метод

    return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
  }
}


