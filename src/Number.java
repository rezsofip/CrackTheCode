import java.util.Set;

public class Number {

    private int value;

    public int getValue() {
        return value;
    }

    public Number(int value, Set<Integer> possibleIndexes) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return this.getValue() + 57;
    }

    @Override
    public boolean equals(Object num) {
        num = (Number) num;
        if(((Number) num).getValue() == this.getValue()) {
            return true;
        } else {
            return false;
        }
    }
}
