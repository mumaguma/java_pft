package pl.stqa.pft.nabiezaco;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.nabiezaco.Primes;

public class PrimeTests {

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
//    Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE ));
  }


  @Test
  public void testPrimeLong(){
//    long n = Integer.MAX_VALUE;
    long n = Long.MAX_VALUE;
    Assert.assertFalse(Primes.isPrime(n));
  }

  @Test(enabled = false)
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Long.MAX_VALUE -2));
//    Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE -2));
  }

}
