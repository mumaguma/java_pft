package pl.stqa.pft.nabiezaco;

public class Primes {

  public static boolean isPrime(int n) {
    int sqr = (int) Math.sqrt(n);
    for (int i = 2; i <= sqr; i++ ){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrime(long n) {
    long sqr = (long) Math.sqrt(n);
    for (long i = 2; i <= sqr; i++ ){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    double sqr = Math.sqrt(n);
    int i = 2;
    while (i <= sqr && n % i != 0) {
      i++;
    }
    System.out.println(i + "   " + n + "    " + sqr);
    return i > sqr;
  }
}
