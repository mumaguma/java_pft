package pl.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(5, 5);
    System.out.println("Odleglosc punktow to " + distance(p1, p2 ));
  }

  public static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x + p2.x)*(p1.x + p2.x)+(p1.y + p2.y)*(p1.y + p2.y));
  }
}


