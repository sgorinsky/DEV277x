import java.awt.*;
import java.util.*;

public class Tiger extends Critter {
  private Random rand = new Random();
  private int turn = -1;
  private Color color;

  //always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left,
  //otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
  public Action getMove(CritterInfo info) {

    turn++;

    if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT;
    } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
      return Action.LEFT;
    } else if (info.getFront() == Neighbor.SAME) {
      return Action.RIGHT;
    } else {
      return Action.HOP;
    }
  }


  public Color getColor() {
    int randNum = rand.nextInt(3);
    //random int to determine color

    if (turn % 3 == 0) {
      if (randNum == 0) {
        color = Color.BLUE;
      } else if(randNum == 1) {
        color = Color.RED;
      } else {
        color = Color.GREEN;
      }
    }

    return color;

  }


  public String toString() {
    return "TGR";
  }

}
