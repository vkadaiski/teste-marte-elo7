package exploration;
/* Base rosa dos ventos para direcionamento da sonda*/
public enum Direction {
  NORTH('N'), EAST('E'), WEST('W'), SOUTH('S');

  private final char shortCode;

  Direction(char code) {
    this.shortCode = code;
  }

  public char getDirectionCode() {
    return this.shortCode;
  }

  public static Direction getDirection(char shortCode) {
    for (Direction m : Direction.values()) {
      if (m.shortCode == shortCode)
        return m;
    }
    throw new IllegalArgumentException();
  }

  public Direction turnLeft() {
    /* Movimento de 90º da Sonda */
    switch (this) {
      case NORTH:
        return WEST;
      case EAST:
        return NORTH;
      case SOUTH:
        return EAST;
      case WEST:
        return SOUTH;
      default:
        throw new IllegalArgumentException();
    }
  }
  /* Movimento de 90º da Sonda */
  public Direction turnRight() {
    
    switch (this) {
      case NORTH:
        return EAST;
      case EAST:
        return SOUTH;
      case SOUTH:
        return WEST;
      case WEST:
        return NORTH;
      default:
        throw new IllegalArgumentException();
    }
  }

  public Direction moveFoward() {
    /* Avançar no mesmo sentido */
    return this;
  }

}