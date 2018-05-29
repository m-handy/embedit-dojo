public class Ant {

    private int x;
    private int y;
    private Direction direction;

    public Ant(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public boolean [][] move ( boolean [][] pole) {
        pole[x][y] = !pole[x][y];
        if(!pole[x][y]){ //biela
            direction = Direction.turnRight(direction);
        } else { // cierna
            direction = Direction.turnLeft(direction);
        }
        moveForward();
        return pole;
    }

    private void moveForward() {
        switch (direction) {
            case SOUTH:
                y++;
                break;
            case NORTH:
                y--;
                break;
            case WEST:
                x--;
                break;
            case EAST:
                x++;
                break;
        }
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 1;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ant ant = (Ant) o;
        return x == ant.x &&
                y == ant.y &&
                direction == ant.direction;
    }

}
