package pl.stqa.pft.nabiezaco;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};
// lang[3]="PHP";

//    for (int i = 0; i < langs.length; i++){
//      System.out.println("I wanna learn " + langs[i]);
//    }
    for (String l : langs) {
      System.out.println("I wanna learn " + l);
    }
  }
}
