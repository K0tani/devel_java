package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    System.out.println("Hello, World");

    Square s = new Square(100);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(34, 12);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }
}