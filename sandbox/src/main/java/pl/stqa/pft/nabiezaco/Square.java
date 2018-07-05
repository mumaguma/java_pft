package pl.stqa.pft.nabiezaco;

public class Square {
  public double l;

  public Square(double l) {
    this.l = l;
  }


  public double powierzchnia() {
    return this.l * this.l;
  }
}