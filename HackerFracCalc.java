import java.util.*;

public class HackerFracCalc {

  public static Scanner console = new Scanner(System.in);
  public static void main(String[] args) {

    System.out.println("This program is a fraction calculator.");
    System.out.println("It will add, subtract, multiply, and divide fractions until you Q quit.");
    System.out.println("Valid operations are of the form \"[FRAC] [OPERATION] [FRAC]\". ");
    System.out.println("[FRAC] can either be a single integer or two integers separated by \"/\".");
    System.out.println("[OPERATION] can be +, -, *, /, or =.");


    int i = 0;

    while (i < 1) {

      //catches all exceptions
      try {

        hackCalc();

      } catch(Exception e) {

        System.out.println("Invalid entry. Must be of form \"[FRAC] [OPERATION] [FRAC]\".");

      }

    }

  }

  public static void hackCalc() {

    String str1 = "";
    String str2 = "";

    System.out.print("Enter an operation (q to quit): ");

    String input = console.nextLine();

    if (input.toUpperCase().equals("Q")) {

       System.exit(0);

    }

    // try/catch exceptions from lines 49-54 in main method
    int count = spaceCount(input);

    char operation = input.charAt((input.indexOf(" ")+1));

    str1 = input.substring(0, input.indexOf(" "));
    str2 = input.substring((input.indexOf(" ")+3), input.length());

    //must have 2 spaces, an operation, and strings as valid fractions
    while ((count != 2) || (validFraction(str1) != true || validFraction(str2) != true)
      || ((operation != '+') && (operation != '-') && (operation != '*')
      && (operation != '/') && (operation != '=') && (!input.toUpperCase().equals("Q")))) {

        System.out.println("Invalid entry. Must be of form \"[FRAC] [OPERATION] [FRAC]\".");
        System.out.print("Enter an operation (q to quit): ");

        input = console.nextLine();
        count = spaceCount(input);

        if (input.toUpperCase().equals("Q")) {

           System.exit(0);

        }

        if (count == 2) { //user must satisfy this condition

        operation = input.charAt((input.indexOf(" ")+1));

        str1 = input.substring(0, input.indexOf(" "));
        str2 = input.substring((input.indexOf(" ")+3), input.length());

        }


    }

    Fraction frac_1 = getFraction(str1);
    Fraction frac_2 = getFraction(str2);

    if (operation == '+') {

        System.out.println(frac_1.toString() + " + "+ frac_2.toString() + " = " + frac_1.add(frac_2).toString());

    } else if (operation == '-') {

        System.out.println(frac_1.toString() + " - "+ frac_2.toString() +" = " + frac_1.subtract(frac_2).toString());

    } else if (operation == '/') {

        System.out.println(frac_1.toString() + " / "+ frac_2.toString() +" = " + frac_1.divide(frac_2).toString());

    } else if (operation == '*') {

        System.out.println(frac_1.toString() + " * "+ frac_2.toString() +" = " + frac_1.multiply(frac_2).toString());

    } else if (operation == '=') {

      System.out.println(frac_1.toString() + " = "+ frac_2.toString() + " is " + frac_1.isEqual(frac_2).toString());

    }

  }

  public static Fraction getFraction(String strFrac) {

    if (strFrac.contains("/")) {

        String[] arc = new String[2];
        arc = strFrac.split("/");

        int n = Integer.parseInt(arc[0]);
        int d = Integer.parseInt(arc[1]);

        return new Fraction(n, d);

      } else {

        int n = Integer.parseInt(strFrac.substring(0, strFrac.length()));

        return new Fraction(n);

      }

  }

  public static Boolean validFraction(String input) { //is it a valid fraction? if the String contains a / or -, it's good

    String a = input;

    if (input.contains("/") || input.contains("-")) {

      a = a.replace("/", "");
      a = a.replace("-", "");

    }

    return isInteger(a);
  }


  private static Boolean isInteger(String input) { //is it an integer? checking to see if there are digits in String arg

    return input.matches("\\d+");

  }

  public static int spaceCount(String str) {

    int count = 0;
    for (int i = 0; i < str.length(); i++) {

      if (str.charAt(i) == ' ') {
        count++;
      }

    }
    return count;
  }



}
