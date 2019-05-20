package ru.stqa.pft.sandbox.point.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.point.n2.PointC;

public class PointTest {

  @Test
  public void testPoint () {

    PointC p1 = new PointC(-20,30);
    PointC p2 = new PointC(50,-35);

    Assert.assertEquals(p1.distance(p1, p2),95.524865872714);

    PointC p3 = new PointC(0,13);
    PointC p4 = new PointC(5,-5);

    Assert.assertEquals(p1.distance(p3,p4),18.681541692269406);
  }
}