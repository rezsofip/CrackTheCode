import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private static Numbers numbers = new Numbers();
    private static Set<Number> numbersSet = new HashSet<>(); // egy szám nem szerepelhet többször

    public static Numbers getNumbers() {
        return numbers;
    }

    public Set<Number> getNumbersSet() {
        return numbersSet;
    }

    public Numbers addNumbersToNumbersSet(int[] array) {
        for(int i = 0; i< array.length; i++) {
            this.numbersSet.add(new Number(array[i], new HashSet<>()));
        }

        return this.numbers;
    }

    public void convertResultListToResultArray(List<Result> resultList) {
        Result[][] arrayList = new Result[resultList.size()][];
        List<Result> row = new ArrayList<>();
        int j = -1;
        boolean canAddRow = false;
        for (int i = 0; i < resultList.size(); i++) {
            if(i == 0) {
                row.add(new Result(resultList.get(i).getCondition(), resultList.get(i).getNumberValue(), resultList.get(i).getPossibleIndexes()));
            } else {
                if(resultList.get(i).getCondition() == resultList.get(i - 1).getCondition()) {
                    row.add(new Result(resultList.get(i).getCondition(), resultList.get(i).getNumberValue(), resultList.get(i).getPossibleIndexes()));
                } else {
                    canAddRow = true;
                    j++;
                }
            }

        }
    }

}
