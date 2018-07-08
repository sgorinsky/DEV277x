import java.awt.*;
import java.util.*;

public class Bear extends Critter {

  private static int moveCount;
  private boolean polar;

  public Bear(boolean polar) {
    moveCount = 0;
    this.polar = polar;

  }



  public Action getMove(CritterInfo info) {
    if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT;
    } else {
      return Action.HOP;
    }
  }

  public Color getColor() {
    if (polar) {
      return Color.WHITE;
    } else {
      return super.getColor();
    }
  }


  public String toString() {

    if (moveCount%2 == 1) {
      return "/";
    } else  {
      return "\\";
    }
  }


}
