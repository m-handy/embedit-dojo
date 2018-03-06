/**
 * 5.3.2018.
 *
 * @author martin.hanyas
 */
public class Range {
    private int lowerRange;
    private int upperRange;
    private boolean lowerIncluded;
    private boolean upperIncluded;

    public Range(String s) {
        String[] split = s.split(",");
        lowerIncluded = split[0].startsWith("[");
        upperIncluded = split[1].endsWith("]");

        lowerRange = Integer.parseInt(split[0].substring(1, split[0].length()));
        upperRange = Integer.parseInt(split[1].substring(0, split[1].length()-1));
    }

    public int getLowerRange() {
        return lowerRange;
    }

    public int getUpperRange() {
        return upperRange;
    }

    public boolean isLowerIncluded() {
        return lowerIncluded;
    }

    public boolean isUpperIncluded() {
        return upperIncluded;
    }

    public boolean contains(int i) {
        if(i == lowerRange){
            return lowerIncluded;
        }
        else if(i == upperRange){
            return upperIncluded;
        }
        else if(i > upperRange || i < lowerRange){
            return false;
        } else {
            return true;
        }
    }

    public boolean contains(Range r){
        return this.getAllPoints().contains(r.getAllPoints());

    }

    public String getAllPoints() {

        String result = "";

        for (int i = lowerRange; i < upperRange; i++) {
            result += i;
            result += ",";
        }

        if (upperIncluded){
            result += upperRange + ",";
        }
        if (!lowerIncluded) {
            result = result.substring(result.indexOf(",")+1,result.length());
        }

        if (result.length()>0) {
            result = result.substring(0,result.length()-1);
        }

        return result;
    }
}
