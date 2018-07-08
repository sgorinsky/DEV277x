import java.awt.*;


public class WhiteTiger extends Tiger {

  private boolean infected;

  public Action getMove(CritterInfo info) {

    if (info.getFront() == Neighbor.OTHER) {
      this.infected = true;
      return Action.INFECT;
    } else if (info.getFront() == Neighbor.WALL || info.getRight().equals(Neighbor.WALL)) {
      return Action.LEFT;
    } else if (info.getFront() == Neighbor.SAME) {
      return Action.RIGHT;
    } else {
      return Action.HOP;
    }

  }

  public Color getColor() {
    return Color.WHITE;
  }

  public String toString() {

    if (infected) { //want to specify that white tiger has infected another animal, if so: "TGR"
      return "TGR";
    } else {
      return "tgr";
    }
  }
}
