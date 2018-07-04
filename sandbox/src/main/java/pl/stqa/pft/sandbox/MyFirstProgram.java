package pl.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("ssss");
    hello("aaaa");

    Square s = new Square(5);
    Rectangle r = new Rectangle(7, 8);
    Rectangle klasycznyobiekt = new Rectangle(12, 92);

    System.out.println("Powierzchnia o boku " + s.l + " = " + s.powierzchnia());
    System.out.println("Powierzchnia o bokach " + r.x + ", " + r.y + " = " + r.powierzchnia());
    System.out.println("potwierzenie dla " + klasycznyobiekt.x + " oraz " + klasycznyobiekt.y + " to " + klasycznyobiekt.powierzchnia());

  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

}


