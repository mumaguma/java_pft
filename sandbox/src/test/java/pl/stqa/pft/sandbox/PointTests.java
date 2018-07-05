package pl.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

  @Test
  public void testDistance() {
    Point testpoint1 = new Point(-10, 0);
    Assert.assertEquals(testpoint1.distance(testpoint1), 0.0);
  }

  @Test
  public void testDistance2() {
    Point testpoint1 = new Point(-10, 0);
    Point testpoint2 = new Point(0, 10);
    Assert.assertEquals(testpoint1.distance(testpoint2), 14.142135623730951);
  }

  @Test
  public void testDistance3() {
    Point testpoint1 = new Point(-10, 0);
    Point testpoint3 = new Point(10, 0);
    Assert.assertEquals(testpoint1.distance(testpoint3), 20.0);
  }

  @Test
  public void testDistance4() {
    Point testpoint3 = new Point(10, 0);
    Point testpoint4 = new Point(0, 0);
    Assert.assertEquals(testpoint3.distance(testpoint4), 10.0);
  }
}
