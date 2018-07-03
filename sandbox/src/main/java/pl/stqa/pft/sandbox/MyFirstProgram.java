package pl.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("ssss");
    hello("aaaa");
    double v = 5;
    double x = 4;
    System.out.println("Powierzchnia o boku " + v + " = " + powierzchnia(v));
    System.out.println("Powierzchnia o bokach " + v + ", " + x + " = " + powierzchnia(v, x));

  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double powierzchnia(double krawedz) {
    return krawedz * krawedz;
  }

  public static double powierzchnia(double a, double b ) {
    return a * b;
  }
}
