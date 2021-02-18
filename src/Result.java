import java.util.HashSet;
import java.util.Set;

public class Result { // itt tároljuk az egyes állítások lehetséges eredményeit

    private int condition; // hanyadik számú állítás/feltétel
    private int numberValue; // a szám értéke
    private Set<Integer> possibleIndexes = new HashSet<>(); // a lehetséges indexek

    @Override
    public String toString() {
        return this.numberValue + " " + this.possibleIndexes.toString();
    }

    public int getCondition() {
        return condition;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public Set<Integer> getPossibleIndexes() {
        return possibleIndexes;
    }

    public Result(int condition, int numberValue, Set<Integer> possibleIndexes) {
        this.condition = condition;
        this.numberValue = numberValue;
        this.possibleIndexes = possibleIndexes;
    }
}
