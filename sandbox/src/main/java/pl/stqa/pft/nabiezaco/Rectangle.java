package pl.stqa.pft.nabiezaco;

public class Rectangle {
  public double x;
  public double y;

  public Rectangle(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double powierzchnia() {
    return this.x * this.y;
  }
}
