import org.junit.Assert;
import org.junit.Test;

/**
 * 5.3.2018.
 *
 * @author martin.hanyas
 */
public class RangeTest {

    @Test
    public void createRangeObject() {
        Range range = new Range("[2,6)");
        Assert.assertTrue(range.isLowerIncluded());
        Assert.assertFalse(range.isUpperIncluded());

        Assert.assertEquals(2, range.getLowerRange());
        Assert.assertEquals(6, range.getUpperRange());
    }

    @Test
    public void rangeContains(){
        Range range = new Range("[2,6)");

        Assert.assertTrue(range.contains(2));
        Assert.assertFalse(range.contains(6));
        Assert.assertFalse(range.contains(60));
        Assert.assertFalse(range.contains(-1));

        Range range2 = new Range("(9,12]");
        Assert.assertFalse(range2.contains(9));
        Assert.assertTrue(range2.contains(12));
        Assert.assertTrue(range2.contains(10));

    }

    @Test
    public void rangeGetAllPoints(){
        Range range = new Range("[2,6)");
        Assert.assertEquals("2,3,4,5",range.getAllPoints());

        range = new Range("[2,6]");
        Assert.assertEquals("2,3,4,5,6",range.getAllPoints());

        range = new Range("[1,5]");
        Assert.assertEquals("1,2,3,4,5",range.getAllPoints());

        range = new Range("(1,5]");
        Assert.assertEquals("2,3,4,5",range.getAllPoints());

        range = new Range("(1,2)");
        Assert.assertEquals("",range.getAllPoints());

        range = new Range("(1,3)");
        Assert.assertEquals("2",range.getAllPoints());
    }

    @Test
    public void rangeContainsRange() {
        Range rangeOrigin = new Range("[2,5)");
        Range range = new Range("[7,10)");
        Assert.assertFalse(rangeOrigin.contains(range));

        rangeOrigin = new Range("[2,10)");
        range = new Range("[3,5)");
        Assert.assertTrue(rangeOrigin.contains(range));

        rangeOrigin = new Range("[2,10)");
        range = new Range("[2,10)");
        Assert.assertTrue(rangeOrigin.contains(range));

        rangeOrigin = new Range("[2,10)");
        range = new Range("(2,10)");
        Assert.assertTrue(rangeOrigin.contains(range));

        rangeOrigin = new Range("(2,10)");
        range = new Range("[2,10)");
        Assert.assertFalse(rangeOrigin.contains(range));

        rangeOrigin = new Range("(2,10)");
        range = new Range("[2,10)");
        Assert.assertFalse(rangeOrigin.contains(range));

        rangeOrigin = new Range("(2,3)");
        range = new Range("(2,3)");
        Assert.assertTrue(rangeOrigin.contains(range));

    }

}
