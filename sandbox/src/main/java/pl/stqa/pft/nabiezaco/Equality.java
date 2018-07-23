package pl.stqa.pft.nabiezaco;

public class Equality {

  public static void main(String[] args){
    String s1 = "firefox 4.0";
    String s2 = "firefox " + String.valueOf(Math.sqrt(16.0));
    System.out.println(s1 == s2  );
    System.out.println(s1.equals(s2));
  }

}
