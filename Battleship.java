//Battleship game against computer

import java.util.*;

public class Battleship {

  public static Scanner console = new Scanner(System.in);
  public static Random rand = new Random();

  public static void main(String[] args) {

    game();

  }

  public static void game() {

        String[][] map = Oceanmap();
        String[][] compMap = map();
        String[][] compMapReal = ComputerMap();
        int[] move = new int[2];
        int[] compMove = new int[2];

        int playerScore = 0;
        int compScore = 0;

        System.out.println("How many turns do you wish to play?");
        int turns = console.nextInt();

        while (turns > 100 || turns < 1) {

          if (turns > 100) {
          System.out.print("Number of turns should be less than 100: ");
          turns = console.nextInt();

        } else {

          System.out.println("Can't have less than 1 turn: ");
          turns = console.nextInt();
        }

        }

        int i = 0;

        while (i < turns && (playerScore < 5 && compScore < 5)) {

          System.out.println("Computer map: ");
          printArray(compMap);

          move = playerMove();

          while (compMapReal[move[0]][move[1]].equals("O") || compMapReal[move[0]][move[1]].equals("X")) {

          System.out.println("You have already shot there. Go again.");
          move = playerMove();

          }



          if (compMapReal[move[0]][move[1]].equals("@")){

            System.out.println("Boom!");
            System.out.println("Got one! You sunk one of the opponent's ships.");

            compMap[move[0]][move[1]] = "O";
            compMapReal[move[0]][move[1]] = "O";
            playerScore++;

          } else {

            System.out.println("Miss!");

            compMap[move[0]][move[1]] = "X";
            compMapReal[move[0]][move[1]] = "X";

          }

          compMove = computerMove();

          while (map[compMove[0]][compMove[1]].equals("O") || map[compMove[0]][compMove[1]].equals("X")){

          compMove = computerMove();

          }

          System.out.println("Computer has shot its cannon!");
          System.out.println("It aimed at (" + (compMove[1]-2) + ", " + (compMove[0]-2) + ").");
          //Had to subtract 2 because added 2 earlier to make it easier to put the move on the board


          if (map[compMove[0]][compMove[1]].equals("@")){

            System.out.println("Computer sunk one of your ships!");
            map[compMove[0]][compMove[1]] = "O";
            compScore++;

          } else {

            System.out.println("Computer missed!");

            map[compMove[0]][compMove[1]] = "X";

          }

          System.out.println("Player map: ");
          printArray(map);

          System.out.println("_____________________________________________");

          i++;

        }

        System.out.println("Computer map uncovered: ");
        printArray(compMapReal);

        if (playerScore == 1) {
          System.out.println("Player sunk " + playerScore + " ship. ");
        } else if (playerScore == 5) {
          System.out.println("You sunk all computer's ships!");
        }  else {
            System.out.println("Player sunk " + playerScore + " ships. ");
        }

        if (compScore == 1) {
          System.out.println("Computer sunk " + compScore + " ship. ");
        } else if (playerScore == 5) {
          System.out.println("Computer sunk all your ships.");
        } else {
          System.out.println("Computer sunk " + compScore + " ships. ");
        }

        if (compScore > playerScore) {
          System.out.println("Game over. Computer Wins!");
        } else if (playerScore > compScore) {
          System.out.println("Great job. You won!");
        } else {
          System.out.println("It's a tie! Both players sunk " + playerScore + " ships each!");
        }
  }

  public static String[][] map() {
  //same map initialization code as Oceanmap()

      String[][] map = new String[14][14]; //creating a 14x14 array

      for (int i = 0; i < map.length; i++) { //putting grid coords on the outside of the array

        for (int j = 0; j < map[0].length; j++) {

          map[i][j] = " ";

        }

      }

      for (int i = 0; i < 10; i++) { //putting numbers into columns

        //numbering columns
        map[0][i+2] = i + "";
        map[map.length-1][i+2] = i + "";

        //numbering rows
        map[i+2][0] = i + "";
        map[i+2][map.length-1] = i + "";

        //placing |'s in rows
        map[i+2][map.length-2] = "|";
        map[i+2][1] = "|";

        //placing -'s in columns
        map[1][i+2] = "-";
        map[map.length-2][i+2] = "-";

      }
      return map;
  }
  public static String[][] Oceanmap() {

    String[][] map = map();

    printArray(map);

    System.out.println("Sea is currently empty.");

    System.out.println("Deploy ships at five locations: ");

    for (int j = 0; j < 5; j++) {

      System.out.println("Ship " + (j+1) + ": ");

      int[] ship = ship();

      while (map[ship[0]+2][ship[1]+2].equals("@")) {

        System.out.println("A ship is already there.");
        ship = ship();

      }

      map[ship[0] + 2][ship[1] + 2] = "@";

    }

    printArray(map);

    return map;

  }

  public static int[] ship() {
  //player chooses coordinates of where to put ships
    int[] ship = new int[2];

    System.out.println("Choose x-coordinate from 0 to 9 indicating where you would like to place a ship: ");
    int ship_x = console.nextInt();


    while (ship_x > 9 || ship_x < 0) {

      System.out.println("X-coordinate must be between 0 and 9: ");
      ship_x = console.nextInt();

    }

    System.out.println("Choose y-coordinate from 0 to 9 indicating where you would like to place a ship: ");

    int ship_y = console.nextInt();

    while (ship_y > 9 || ship_y < 0) {

      System.out.println("Y-coordinate must be between 0 and 9: ");
      ship_y = console.nextInt();

    }

    ship[0] = ship_y;
    ship[1] = ship_x;

    return ship;

  }

  public static String[][] ComputerMap() {
  //same map initialization code as Oceanmap()

    String[][] map = map();

    //computer randomly chooses where to put ships
    System.out.println("Computer is deploying ships: ");
    int[] comp_ship1 = {rand.nextInt(10), rand.nextInt(10)};
    System.out.println("Ship 1... DEPLOYED");
    int[] comp_ship2 = {rand.nextInt(10), rand.nextInt(10)};
    System.out.println("Ship 2... DEPLOYED");
    int[] comp_ship3 = {rand.nextInt(10), rand.nextInt(10)};
    System.out.println("Ship 3... DEPLOYED");
    int[] comp_ship4 = {rand.nextInt(10), rand.nextInt(10)};
    System.out.println("Ship 4... DEPLOYED");
    int[] comp_ship5 = {rand.nextInt(10), rand.nextInt(10)};
    System.out.println("Ship 5... DEPLOYED");
    System.out.println("_______________________________________");

    map[comp_ship1[0]+2][comp_ship1[1]+2] = "@";
    map[comp_ship2[0]+2][comp_ship2[1]+2] = "@";
    map[comp_ship3[0]+2][comp_ship3[1]+2] = "@";
    map[comp_ship4[0]+2][comp_ship4[1]+2] = "@";
    map[comp_ship5[0]+2][comp_ship5[1]+2] = "@";

    return map;

  }

  public static int[] playerMove() {

    int[] move = new int[2];
    System.out.println("Enter x-coordinate for where you wish to strike: ");

    int move_x = console.nextInt();
    while(move_x<0 || move_x>9) {

      System.out.println("Must be between 0 and 9: ");
      move_x = console.nextInt();

    }

    System.out.println("Enter y-coordinate for where you wish to strike: ");

    int move_y = console.nextInt();
    while(move_y<0 || move_y>9) {

      System.out.println("Must be between 0 and 9: ");
      move_y = console.nextInt();

    }

    move[0] = move_y + 2; //adding 2 because the first two columns have numbers and |'s on the board
    move[1] = move_x + 2; //first two rows have numbers and -'s

    return move;

  }

  public static int[] computerMove() {

    int[] compMove = new int[2];
    compMove[0] = rand.nextInt(10)+2;
    compMove[1] = rand.nextInt(10)+2;

    return compMove;

  }

  public static void printArray(String[][] array) {

    for (int r = 0; r < array.length; r++) {

      String arrayDisplay = Arrays.toString(array[r]).replace(",", ""); //removes commas from board
      arrayDisplay = arrayDisplay.substring(1, arrayDisplay.length() - 1); //removes brackets from array
      System.out.println(arrayDisplay);

    }
  }

}
