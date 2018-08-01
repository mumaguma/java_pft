package pl.stqa.pft.nabiezaco;

import java.util.Arrays;
import java.util.List;

public class Collections2 {
  public static void main(String[] args) {
 //   String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
//    languages.add("Java");
//    languages.add("C#");
//    languages.add("Python");
//    languages.add("PHP");

    // for (int i = 0;  i < languages.size(); i++){
    //      System.out.println("I wanna learn " + languages.get(i));
    //  }
    for (String l : languages) {
      System.out.println("I wanna learn " + l);
    }
  }
}
