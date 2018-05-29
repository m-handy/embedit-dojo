public enum Direction {

    WEST, EAST, SOUTH, NORTH;

    public static Direction turnLeft(Direction direction) {
        switch (direction) {
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
        }
        throw new RuntimeException();
    }

    public static Direction turnRight(Direction direction) {
        switch (direction) {
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
        }
        throw new RuntimeException();
    }

}
