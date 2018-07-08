public class RationalNumberTest {

  public static void main(String[] args) {

    RationalNumber rash = new RationalNumber(3, 5);
    RationalNumber numby = new RationalNumber(4, 6);
    System.out.println(rash.toString() + " * " + numby.toString() + " = " + rash.multiply(numby).toString());

  }
}
