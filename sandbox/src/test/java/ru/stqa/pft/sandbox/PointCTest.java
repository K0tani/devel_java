package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointCTest {

  @Test
  public void testPoint () {

    PointC p1 = new PointC(-20,30);
    PointC p2 = new PointC(50,-35);

    Assert.assertEquals(p1.distance(p2),95.524865872714);

    PointC p3 = new PointC(0,13);
    PointC p4 = new PointC(5,-5);

    Assert.assertEquals(p3.distance(p4),18.681541692269406);
  }
}