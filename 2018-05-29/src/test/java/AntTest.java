import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.JUnit4;

import java.util.Arrays;

public class AntTest {

   @Test
    public void testNextStep(){
       // bila true cerna false
       boolean[][] pole = new boolean[10][10];
       boolean[][] poleResult;
       boolean[][] poleExpected = new boolean[10][10];
       Ant antExpected = new Ant(0,1,Direction.WEST);
       poleExpected[1][1] = true;
       Ant ant = new Ant(1, 1, Direction.NORTH);
       poleResult = ant.move(pole);

       Assert.assertArrayEquals(poleExpected, poleResult);
       assert antExpected.equals(ant);

   }

   @Test
    public void testStepFromWhite(){
       boolean[][] pole = new boolean[10][10];
       pole[0][0] = true;
       boolean[][] poleResult;
       boolean[][] poleExpected = new boolean[10][10];
       Ant antExpected = new Ant(1,0,Direction.EAST);
       poleExpected[0][0] = false;

       Ant ant = new Ant(0, 0, Direction.NORTH);
       poleResult = ant.move(pole);

       Assert.assertArrayEquals(poleExpected, poleResult);
       assert antExpected.equals(ant);
   }

    @Test
    public void testChangeOfDirection1(){
        boolean[][] pole = new boolean[10][10];
        pole[0][0] = true;
        boolean[][] poleResult;
        boolean[][] poleExpected = new boolean[10][10];

        Ant ant = new Ant(0, 0, Direction.SOUTH);
        poleResult = ant.move(pole);

        assert ant.getDirection() == Direction.WEST;
    }

    @Test
    public void testChangeOfDirection2() {
        boolean[][] pole = new boolean[10][10];
        pole[0][0] = true;
        boolean[][] poleResult;
        boolean[][] poleExpected = new boolean[10][10];

        Ant ant = new Ant(0, 0, Direction.WEST);
        poleResult = ant.move(pole);

        assert ant.getDirection() == Direction.NORTH;
    }

    @Test
    public void testChangeOfDirection3() {
        boolean[][] pole = new boolean[10][10];
        boolean[][] poleResult;
        boolean[][] poleExpected = new boolean[10][10];

        Ant ant = new Ant(0, 0, Direction.WEST);
        poleResult = ant.move(pole);

        assert ant.getDirection() == Direction.SOUTH;
    }

    @Test
    public void testMoweDown() {
        boolean[][] pole = new boolean[10][10];
        pole[0][0] = true;
        boolean[][] poleResult;
        boolean[][] poleExpected = new boolean[10][10];

        Ant ant = new Ant(0, 0, Direction.EAST);
        poleResult = ant.move(pole);

        Ant antExpected = new Ant(0,1,Direction.SOUTH);

        Assert.assertEquals(ant,antExpected);
    }

}
