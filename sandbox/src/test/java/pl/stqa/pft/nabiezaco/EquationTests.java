package pl.stqa.pft.nabiezaco;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

  @Test
  public void test0() {
    Equation e = new Equation(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);
  }

  @Test
  public void test1() {
    Equation e = new Equation(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);
  }

  @Test
  public void test2() {
    Equation e = new Equation(1,5,6);
    Assert.assertEquals(e.rootNumber(),2);
  }

  @Test
  public void test3Linear() {
    Equation e = new Equation(0,1,1);
    Assert.assertEquals(e.rootNumber(),1);
  }

  @Test
  public void test4Constant0() {
    Equation e = new Equation(0,0,0);
    Assert.assertEquals(e.rootNumber(),-1);
  }

  @Test
  public void test5Constant() {
    Equation e = new Equation(0,0,1);
    Assert.assertEquals(e.rootNumber(),0);
  }

  @Test
  public void test6() {
    Equation e = new Equation(1,0,0);
    Assert.assertEquals(e.rootNumber(),1);
  }

  @Test
  public void test7() {
    Equation e = new Equation(1,0,1);
    Assert.assertEquals(e.rootNumber(),0);
  }

  @Test
  public void test8() {
    Equation e = new Equation(1,0,-1);
    Assert.assertEquals(e.rootNumber(),2);
  }

  @Test
  public void test9Zero() {
    Equation e = new Equation(0,0,0);
    Assert.assertEquals(e.rootNumber(),-1);
  }

}
