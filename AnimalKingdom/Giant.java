import java.awt.*;

public class Giant extends Critter {

  private int turn = 0;
  private boolean phaseOne = true;
  private boolean phaseTwo = false;
  private boolean phaseThree = false;



  public Color getColor() {
    return Color.GRAY;
  }


  public Action getMove(CritterInfo info) {


    turn++;


    if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT;
    } else if (info.getFront() == Neighbor.WALL) {
      return Action.RIGHT;
    } else {
      return Action.HOP;
    }
  }

  public String toString() {
  //fee first 6 turns, fie next 6, fo next 6, fum last 6. Repeat

  if (turn >= 0 && turn < 6) {
    phaseOne = true;
  } else if (turn >= 6 && turn < 12) {
    phaseOne = false;
    phaseTwo = true;
  } else if (turn >= 12 && turn < 18) {
    phaseTwo = false;
    phaseThree = true;
  } else if (turn >= 18 && turn < 24) {
    phaseThree = false;
  } else {
    turn = 0;
    phaseOne = true;
  }

  if (phaseOne) {
    return "fee";
  } else if (phaseTwo) {
    return "fie";
  } else if (phaseThree) {
    return "fo";
  } else {
    return "fum";
  }

  }



}
