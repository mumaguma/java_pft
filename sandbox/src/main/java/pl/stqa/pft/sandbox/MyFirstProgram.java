package pl.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    Point p1 = new Point(3, 4);
    Point p2 = new Point(-6, -8);
    System.out.println("Odleglosc punktow o wspolrzednych (" + p1.x + "," + p1.y + "), (" + p2.x + "," + p2.y + ") wynosi " + p1.distance(p2));
  }


}


