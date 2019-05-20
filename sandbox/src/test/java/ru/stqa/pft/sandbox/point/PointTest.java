package ru.stqa.pft.sandbox.point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testPoint () {

    Point p1 = new Point(-20,30);
    Point p2 = new Point(50,-35);

    Assert.assertEquals(p1.distance(p1, p2),95.524865872714);

    Point p3 = new Point(0,13);
    Point p4 = new Point(5,-5);

    Assert.assertEquals(p1.distance(p3,p4),18.681541692269406);
  }
}