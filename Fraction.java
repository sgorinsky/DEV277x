//Fraction calculator
import java.util.*;

public class Fraction {

  private int n;
  private int d;

  public Fraction(int x, int y) throws IllegalArgumentException { //Fraction constructor with two parameters
    if (y < 0) {
      this.n = -x;
      this.d = -y;
    } else if (y == 0) {

      throw new IllegalArgumentException("Undefined");

    } else {
      this.n = x;
      this.d = y;
    }

  }

  public Fraction(int x) { //I want a fraction with only a numerator, no denominator

    this(x, 1);

  }

  //no parameters defaults fraction values to 0
  public Fraction() {
    this(0, 1);
  }

  /*wanted to test if I could create an ArrayList of Fraction instances -- it works

   *public ArrayList<Fraction> cm(Fraction other) {


   *int num = this.n;
   *int denom = this.d;

   *this.n *= other.d;
   *this.d *= other.d;

   *other.n *= denom;
   *other.d *= denom;



   *ArrayList <Fraction> fracArray = new ArrayList<Fraction>();
   *fracArray.add(this);
   *fracArray.add(other);
   *return fracArray;

  } */

  public Fraction add(Fraction other) {

    int numerator = (this.n * other.d) + (other.n * this.d);
    int denominator = this.d * other.d;

    Fraction f = new Fraction(numerator, denominator);
    if (f.n == 0) {
      return f;
    } else {
      return f.toLowestTerms();
    }


  }

  public Fraction subtract(Fraction other) {

    int numerator = (this.n * other.d) - (other.n * this.d);
    int denominator = this.d * other.d;

    Fraction f = new Fraction(numerator, denominator);
    if (f.n == 0) {
      return f;
    } else {
      return f.toLowestTerms();
    }

  }

  public Fraction multiply(Fraction other) {

    if (this.n == 0 || other.n == 0) {

      this.n = 0;
      return this;

    } else {

    this.n *= other.n;
    this.d *= other.d;

    return this.toLowestTerms();
  }


  }

  public Fraction divide(Fraction other) throws IllegalArgumentException {

    if (other.n == 0) { //can't divide by 0

      throw new IllegalArgumentException("Undefined");

    } else if (this.n == 0) { //trying to divide into 0 is 0

      return this;

    } else {
      this.n *= other.d;
      this.d *= other.n;

      return this.toLowestTerms();
    }

  }

  public Boolean isEqual(Fraction other) {

    this.toLowestTerms();
    other.toLowestTerms();

    if (this.n == other.n && this.d == other.d) {
      return true;
    } else {
      return false;
    }

  }

  public String toString() {

    if (this.d == 1 || this.n == 0) {

      return this.n + "";

    } else if (this.d < 0) {

      this.d *= -1;

      return -this.n + "/" + this.d;

    } else {

      return this.n + "/" + this.d;
    }

  }

  public static int gcd(int a, int b) {
    int remainder;
    while (a != 0 && b != 0) { //Euclidean Algorithm
      remainder = a % b;
      a = b;
      b = remainder;
    }
    return a;
  }

  public Fraction toLowestTerms() {

    int divisor = gcd(n, d);
    this.n = n/divisor;
    this.d = d/divisor;
    return this;

  }





}
