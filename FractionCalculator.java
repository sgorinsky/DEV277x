//FractionCalculator: client class for Fraction.java
import java.util.*;

public class FractionCalculator {

  public static Scanner console = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("This program is a fraction calculator.");
    System.out.println("It will add, subtract, multiply, and divide fractions until you press Q to quit.");
    System.out.println("Please enter your fractions in the form a/b where a and b are integers.");
    System.out.println("---------------------------------------------------------------------------");

    int i = 0;
    while (i < 1) {

      Calculator();

    }

  }

  //method to calculate everything
  public static void Calculator() { //

    //getting operation
    String op = getOperation();

    //creating new fractions to operate on
    Fraction frac1 = getFraction();
    Fraction frac2 = getFraction();


    if (op.equals("+")) {

        System.out.println(frac1.toString() + " + " + frac2.toString() + " = " + frac1.add(frac2).toString());

    } else if (op.equals("-")) {

        System.out.println(frac1.toString() + " - " + frac2.toString() + " = " + frac1.subtract(frac2).toString());


    } else if (op.equals("/")) {

        System.out.println(frac1.toString() + " / " + frac2.toString() + " = " + frac1.divide(frac2).toString());

    } else if (op.equals("*")) {

        System.out.println(frac1.toString() + " * " + frac2.toString() + " = " + frac1.multiply(frac2).toString());

    } else if (op.charAt(0) == '=') {

      System.out.println(frac1.toString() + " = " + frac2.toString() + " is " + frac1.isEqual(frac2));

    }

    System.out.println("---------------------------------------------------------------------------");

  }

  public static String getOperation() {

    System.out.println("Enter an operation (+, -, *, /, = or press Q to quit): ");
    String input = console.nextLine().toUpperCase();

    while (input.length() == 0 || (!input.equals("+") && !input.equals("-") && !input.equals("*")
    && !input.equals("/") && !input.equals("=") && !input.equals("Q"))) {

      System.out.println("Input requires a valid operation (+, -, *, /, = or press Q to quit): ");

      input = console.nextLine().toUpperCase();

    }
    if (input.charAt(0) == 'Q') {
      System.exit(0);
    }

    return input;

  }

  public static Fraction getFraction() {

    System.out.println("Please enter a valid fraction (a/b) or integer (a): ");

    String frac = console.nextLine();

    while (frac.length() == 0 || !validFraction(frac)) {

      System.out.println("Invalid entry. Enter a fraction (a/b) where a and b are integers and b is not negative or 0: ");
      frac = console.nextLine();

    }



    if (frac.length() == 0) {

      return new Fraction();

    } else if (frac.charAt(0) == '-') {
      if (frac.contains("/")) {

        int n = Integer.parseInt(frac.substring(1, frac.indexOf("/")));
        int d = Integer.parseInt(frac.substring(frac.indexOf("/")+1 , frac.length()));

        return new Fraction(-n, d);

      } else {

        int n = Integer.parseInt(frac.substring(1, frac.length()));

        return new Fraction(-n);

      }
    } else if (frac.contains("/")) {

      int n = Integer.parseInt(frac.substring(0, frac.indexOf("/")));
      int d = Integer.parseInt(frac.substring(frac.indexOf("/")+1, frac.length()));

      return new Fraction(n, d);

    } else {
      return new Fraction(Integer.parseInt(frac));
    }
  }



    public static Boolean validFraction(String input) { //is it a valid fraction? if the String contains a / or -, it's good
      String a = input;

      if (input.contains("/") || input.charAt(0) == '-') {
        a = a.replace("/", "");
        a = a.replace("-", "");
      }

      return isInteger(a);
    }


    private static Boolean isInteger(String input) { //is it an integer? checking to see if there are digits in String arg

      return input.matches("\\d+");

    }

}
