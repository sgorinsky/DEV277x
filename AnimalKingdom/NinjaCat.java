import java.awt.*;
public class NinjaCat extends Critter {
  private int turn = 1;

  public String toString() {

    return "NC";

  }

  public Action getMove(CritterInfo info) {

    turn++;

    if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT;
    } else if (info.getFront() == Neighbor.WALL || info.getLeft() == Neighbor.WALL || info.getFront().equals(Neighbor.SAME)) {
      return Action.LEFT;
    } else {
      return Action.HOP;
    }

  }


  public Color getColor() {
    if (turn%3 == 0) {

      return Color.WHITE;

    } else {

      return super.getColor();
    }

  }
}
