package pl.stqa.pft.nabiezaco;

public class RoboczaPiaskownica {
  public static void main(String[] args) {
    hello("text");

    Square s = new Square(5);
    Rectangle r = new Rectangle(7, 8);

    System.out.println("Powierzchnia kwadratu o boku " + s.l + " = " + s.powierzchnia());
    System.out.println("Powierzchnia prostokąta o bokach " + r.x + ", " + r.y + " = " + r.powierzchnia());

  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

}
