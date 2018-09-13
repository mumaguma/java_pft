package pl.stqa.pft.nabiezaco;

import org.testng.annotations.Test;

import java.io.File;

public class DirectoryTest {


  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
  }
}
