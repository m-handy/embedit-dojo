import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class KataPotterTest {

    public static final double DELTA = 0.0001;
    private KataPotter kataPotter = new KataPotter();

    @Test
    public void testEmptyBasket() {
        assertEquals(0.0, new KataPotter().price(), DELTA);
    }

    @Test
    public void testBasketWithOneBook() {
        assertEquals(8.0, new KataPotter(1).price(), DELTA);
    }

    @Test
    public void testBasketWithTwoDifferentBooks() {
        assertEquals(2 * 8.0 * 0.95, new KataPotter(1, 2).price(), DELTA);
    }

    @Test
    public void testBasketWithTwoSameBooks() {
        assertEquals(2 * 8.0, new KataPotter(1, 1).price(), DELTA);
    }

    @Test
    public void testBasketWithThreeDifferentBooks() {
        assertEquals(3 * 8.0 * 0.9, new KataPotter(1, 2, 3).price(), DELTA);
    }

    @Test
    public void testBasketWithThreeSameBooks() {
        assertEquals(3 * 8.0, new KataPotter(1, 1, 1).price(), DELTA);
    }

    @Test
    public void testBasketWithTwoSameAndOneDifferentBooks() {
        assertEquals(2 * 8.0 * 0.95 + 8, new KataPotter(1, 1, 2).price(), DELTA);
    }

    @Test
    public void testBasketWithFourDifferentBooks() {
        assertEquals(4 * 8.0 * 0.8, new KataPotter(1, 2, 3, 4).price(), DELTA);
    }

    @Test
    public void testBasketWithTwoDifferentSetsOfSameBooks() {
        assertEquals(2 * (2 * 8.0 * 0.95), new KataPotter(1, 1, 2, 2).price(), DELTA);
    }

}