import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] firstArray = {6, 8, 2};
        int[] secondArray = {6, 1, 4};
        int[] thirdArray = {2, 0, 6};
        int[] fourthArray = {7, 3, 8};
        int[] fifthArray = {8, 7, 0};

        Numbers.getNumbers().addNumbersToNumbersSet(firstArray).addNumbersToNumbersSet(secondArray).
                addNumbersToNumbersSet(thirdArray).addNumbersToNumbersSet(fourthArray).addNumbersToNumbersSet(fifthArray);
  

        int[][] conditions = new int[5][3];

        for (int j = 0; j < firstArray.length; j++) {
            conditions[0][j] = firstArray[j];
        }

        for (int j = 0; j < secondArray.length; j++) {
            conditions[1][j] = secondArray[j];
        }

        for (int j = 0; j < thirdArray.length; j++) {
            conditions[2][j] = thirdArray[j];
        }

        for (int j = 0; j < fourthArray.length; j++) {
            conditions[3][j] = fourthArray[j];
        }

        for (int j = 0; j < fifthArray.length; j++) {
            conditions[4][j] = fifthArray[j];
        }

        Results results = new Results();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    Set<Integer> conditionSet1 = new HashSet<>();
                    conditionSet1.add(j);
                    results.getResults().add(new Result(i, conditions[i][j], conditionSet1));
                    for (int k = 0; k < 3; k++) {  // ha egy helyes, akkor a másik 2 nem helyes
                        if (k != j) {
                            results.getResults().add(new Result(i, conditions[i][k], new HashSet<>()));
                        }
                    }
                } else if (i == 1) {
                    Set<Integer> conditionSet2 = new HashSet<>();
                    if (j == 0) {
                        conditionSet2.add(1);
                        conditionSet2.add(2);
                    } else if (j == 1) {
                        conditionSet2.add(0);
                        conditionSet2.add(2);
                    } else if (j == 2) {
                        conditionSet2.add(0);
                        conditionSet2.add(1);
                    }
                    results.getResults().add(new Result(i, conditions[i][j], conditionSet2));
                    for (int k = 0; k < 3; k++) {
                        if (k != j) {
                            results.getResults().add(new Result(i, conditions[i][k], new HashSet<>()));
                        }
                    }
                } else if (i == 2) {
                    Set<Integer> conditionSet3a = new HashSet<>();
                    Set<Integer> conditionSet3b = new HashSet<>();
                    Set<Integer> conditionSet3c = new HashSet<>();
                    Set<Integer> conditionSet3d = new HashSet<>();
                    Set<Integer> conditionSet3e = new HashSet<>();
                    Set<Integer> conditionSet3f = new HashSet<>();

                    if (j == 0) {

                        conditionSet3a.add(1);   // 2 és 0
                        conditionSet3a.add(2);
                        results.getResults().add(new Result(i, conditions[i][j], conditionSet3a));
                        conditionSet3b.add(0);
                        conditionSet3b.add(2);
                        results.getResults().add(new Result(i, conditions[i][j + 1], conditionSet3b));

                        for (int k = 0; k < 3; k++) {
                            if ((k != j) && (k != (j + 1))) {
                                results.getResults().add(new Result(i, conditions[i][k], new HashSet<>()));
                            }
                        }

                    } else if (j == 1) {    // 2 és 6

                        conditionSet3e.add(1);
                        conditionSet3e.add(2);
                        results.getResults().add(new Result(i, conditions[i][j - 1], conditionSet3e));
                        conditionSet3f.add(0);
                        conditionSet3f.add(1);
                        results.getResults().add(new Result(i, conditions[i][j + 1], conditionSet3f));

                        for (int k = 0; k < 3; k++) {
                            if ((k != (j + 1)) && (k != (j - 1))) {
                                results.getResults().add(new Result(i, conditions[i][k], new HashSet<>()));
                            }
                        }

                    } else if (j == 2) {  // 0 és 6

                        conditionSet3c.add(0);
                        conditionSet3c.add(2);
                        results.getResults().add(new Result(i, conditions[i][j - 1], conditionSet3c));
                        conditionSet3d.add(0);
                        conditionSet3d.add(1);
                        results.getResults().add(new Result(i, conditions[i][j], conditionSet3d));
                        for (int k = 0; k < 3; k++) {
                            if ((k != j) && (k != (j - 1))) {
                                results.getResults().add(new Result(i, conditions[i][k], new HashSet<>()));
                            }
                        }
                    }


                } else if (i == 3) {
                    Set<Integer> conditionSet4 = new HashSet<>();
                    results.getResults().add(new Result(i, conditions[i][j], conditionSet4));
                } else if (i == 4) {
                    Set<Integer> conditionSet5 = new HashSet<>();
                    if (j == 0) {
                        conditionSet5.add(1);
                        conditionSet5.add(2);
                    } else if (j == 1) {
                        conditionSet5.add(0);
                        conditionSet5.add(2);
                    } else if (j == 2) {
                        conditionSet5.add(0);
                        conditionSet5.add(1);
                    }
                    results.getResults().add(new Result(i, conditions[i][j], conditionSet5));
                    for (int k = 0; k < 3; k++) {
                        if (k != j) {
                            results.getResults().add(new Result(i, conditions[i][k], new HashSet<>()));
                        }
                    }
                }

            }
        }

        Result[] firstCondition = new Result[9];
        Result[] secondCondition = new Result[9];
        Result[] thirdCondition = new Result[9];
        Result[] fourthCondition = new Result[3];
        Result[] fifthCondition = new Result[9];


        for (int i = 0; i < firstCondition.length; i++) {
            firstCondition[i] = results.getResults().get(i);
        }

        for (int i = 0; i < secondCondition.length; i++) {
            secondCondition[i] = results.getResults().get(i + 9);
        }

        for (int i = 0; i < thirdCondition.length; i++) {
            thirdCondition[i] = results.getResults().get(i + 18);
        }

        for (int i = 0; i < fourthCondition.length; i++) {
            fourthCondition[i] = results.getResults().get(i + 27);
        }

        for (int i = 0; i < fifthCondition.length; i++) {
            fifthCondition[i] = results.getResults().get(i + 30);
        }

        int condCount = 1;

        Result[][][][][] newResults = new Result[9][9][9][9][15];

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k += 3) {
                    for (int m = 0; m < 9; m += 3) {
                        for (int n = 0; n < 5; n++) {
                            if (condCount % 5 == 1) {
                                newResults[i][j][k][m][n] = firstCondition[i];
                                newResults[i][j][k][m][n + 1] = firstCondition[i + 1];
                                newResults[i][j][k][m][n + 2] = firstCondition[i + 2];
                                condCount++;
                            } else if (condCount % 5 == 2) {
                                newResults[i][j][k][m][n + 2] = secondCondition[j];
                                newResults[i][j][k][m][n + 3] = secondCondition[j + 1];
                                newResults[i][j][k][m][n + 4] = secondCondition[j + 2];
                                condCount++;
                            } else if (condCount % 5 == 3) {
                                newResults[i][j][k][m][n + 4] = thirdCondition[k];
                                newResults[i][j][k][m][n + 5] = thirdCondition[k + 1];
                                newResults[i][j][k][m][n + 6] = thirdCondition[k + 2];
                                condCount++;
                            } else if (condCount % 5 == 4) {
                                newResults[i][j][k][m][n + 6] = fourthCondition[0];
                                newResults[i][j][k][m][n + 7] = fourthCondition[1];
                                newResults[i][j][k][m][n + 8] = fourthCondition[2];
                                condCount++;
                            } else if (condCount % 5 == 0) {
                                newResults[i][j][k][m][n + 8] = fifthCondition[m];
                                newResults[i][j][k][m][n + 9] = fifthCondition[m + 1];
                                newResults[i][j][k][m][n + 10] = fifthCondition[m + 2];
                                condCount++;
                            }
                        }

                    }
                }
            }
        }

        condCount = 0;


        Results combinedResults = new Results();
        Map<Integer, Set<Integer>> resultsMap = new HashMap();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k += 3) {
                    for (int m = 0; m < 9; m += 3) {
                        for (int n = 0; n < 15; n++) {
                            combinedResults.getResults().add(newResults[i][j][k][m][n]);
                            condCount++;

                            if (condCount % 15 == 0) {
                                Result firstResult_a = combinedResults.getResults().get(0);
                                Result firstResult_b = combinedResults.getResults().get(1);
                                Result firstResult_c = combinedResults.getResults().get(2);
                                Result secondResult_a = combinedResults.getResults().get(3);
                                Result secondResult_b = combinedResults.getResults().get(4);
                                Result secondResult_c = combinedResults.getResults().get(5);
                                Result thirdResult_a = combinedResults.getResults().get(6);
                                Result thirdResult_b = combinedResults.getResults().get(7);
                                Result thirdResult_c = combinedResults.getResults().get(8);
                                Result fourthResult_a = combinedResults.getResults().get(9);
                                Result fourthResult_b = combinedResults.getResults().get(10);
                                Result fourthResult_c = combinedResults.getResults().get(11);
                                Result fifthResult_a = combinedResults.getResults().get(12);
                                Result fifthResult_b = combinedResults.getResults().get(13);
                                Result fifthResult_c = combinedResults.getResults().get(14);

                                resultsMap.clear();

                                Set<Integer> numbersSet = new HashSet<>();   // itt találhatók azok a számok, amik az eredményekben szerepelnek
                                numbersSet.add(firstResult_a.getNumberValue());
                                numbersSet.add(firstResult_b.getNumberValue());
                                numbersSet.add(firstResult_c.getNumberValue());
                                numbersSet.add(secondResult_a.getNumberValue());
                                numbersSet.add(secondResult_b.getNumberValue());
                                numbersSet.add(secondResult_c.getNumberValue());
                                numbersSet.add(thirdResult_a.getNumberValue());
                                numbersSet.add(thirdResult_b.getNumberValue());
                                numbersSet.add(thirdResult_c.getNumberValue());
                                numbersSet.add(fourthResult_a.getNumberValue());
                                numbersSet.add(fourthResult_b.getNumberValue());
                                numbersSet.add(fourthResult_c.getNumberValue());
                                numbersSet.add(fifthResult_a.getNumberValue());
                                numbersSet.add(fifthResult_b.getNumberValue());
                                numbersSet.add(fifthResult_c.getNumberValue());

                                for (Integer number : numbersSet) {
                                    resultsMap.put(number, null);
                                }


                                for (Integer number : numbersSet) {
                                    if (firstResult_a.getNumberValue() == number && resultsMap.get(number) != null) { // amit a newPossibleIndexes-zel csinálok az lesz a restulsMap.get(number)-rel is
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(firstResult_a.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (firstResult_a.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, firstResult_a.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (firstResult_b.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(firstResult_b.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (firstResult_b.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, firstResult_b.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (firstResult_c.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(firstResult_c.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (firstResult_c.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, firstResult_c.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (secondResult_a.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(secondResult_a.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (secondResult_a.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, secondResult_a.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (secondResult_b.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(secondResult_b.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (secondResult_b.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, secondResult_b.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (secondResult_c.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(secondResult_c.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (secondResult_c.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, secondResult_c.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (thirdResult_a.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(thirdResult_a.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (thirdResult_a.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, thirdResult_a.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (thirdResult_b.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(thirdResult_b.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (thirdResult_b.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, thirdResult_b.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (thirdResult_c.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(thirdResult_c.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (thirdResult_c.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, thirdResult_c.getPossibleIndexes());
                                    }
                                }


                                for (Integer number : numbersSet) {
                                    if (fourthResult_a.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(fourthResult_a.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (fourthResult_a.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, fourthResult_a.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (fourthResult_b.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(fourthResult_b.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (fourthResult_b.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, fourthResult_b.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (fourthResult_c.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(fourthResult_c.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (fourthResult_c.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, fourthResult_c.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (fifthResult_a.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(fifthResult_a.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (fifthResult_a.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, fifthResult_a.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (fifthResult_b.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(fifthResult_b.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (fifthResult_b.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, fifthResult_b.getPossibleIndexes());
                                    }
                                }

                                for (Integer number : numbersSet) {
                                    if (fifthResult_c.getNumberValue() == number && resultsMap.get(number) != null) {
                                        Set<Integer> newPossibleIndexes = new HashSet<>(resultsMap.get(number));
                                        newPossibleIndexes.retainAll(fifthResult_c.getPossibleIndexes());
                                        resultsMap.put(number, newPossibleIndexes);
                                    } else if (fifthResult_c.getNumberValue() == number && resultsMap.get(number) == null) {
                                        resultsMap.put(number, fifthResult_c.getPossibleIndexes());
                                    }
                                }


                                int hasOneElement = 0;
                                int hasTwoElements = 0;

                                for (Map.Entry<Integer, Set<Integer>> entry : resultsMap.entrySet()) { // megszámoljuk, hogy hány 1 és 2 elemű set van
                                    if (entry.getValue().size() == 1) {
                                        hasOneElement++;
                                    } else if (entry.getValue().size() == 2) {
                                        hasTwoElements++;
                                    }
                                }

                                if (hasOneElement == 1 && hasTwoElements == 2) {
                                    int indexToRemove = -1;
                                    for (Map.Entry<Integer, Set<Integer>> entry : resultsMap.entrySet()) { // megkeresem azt az indexet, ami annak van, ami egy elemes
                                        Set<Integer> set = new HashSet<>(entry.getValue());
                                        if (entry.getValue().size() == 1) {
                                            for (Integer index : set) {
                                                if (indexToRemove == -1) {
                                                    indexToRemove = index;
                                                }
                                            }
                                        }
                                    }

                                    for (Map.Entry<Integer, Set<Integer>> entry : resultsMap.entrySet()) { // ahol 2 elem van onnan elveszem a fix indexet, ami nem lehet köztük
                                        Set<Integer> set = new HashSet<>(entry.getValue());
                                        if (set.size() == 2) {
                                            set.remove(indexToRemove);
                                            if (set.size() == 1) {
                                                hasOneElement++;
                                            }
                                        }
                                    }
                                }
                                if (hasOneElement == 2 && hasTwoElements == 1) {
                                    int indexToRemove1 = -1;
                                    int indexToRemove2 = -1;

                                    for (Map.Entry<Integer, Set<Integer>> entry : resultsMap.entrySet()) { // megkeresem azokat az indexeket, amik azoknak vanak, amik egy elemesek
                                        Set<Integer> set = new HashSet<>(entry.getValue());
                                        if (set.size() == 1) {
                                            for (Integer index : set) {
                                                if (indexToRemove1 == -1) {
                                                    indexToRemove1 = index;
                                                } else {
                                                    indexToRemove2 = index;
                                                }
                                            }
                                        }
                                    }

                                    for (Map.Entry<Integer, Set<Integer>> entry : resultsMap.entrySet()) { // ahol 2 elem van onnan elveszem a fix indexet, ami nem lehet köztük
                                        Set<Integer> set = entry.getValue();
                                        if (set.size() == 2) {
                                            set.remove(indexToRemove1);
                                            set.remove(indexToRemove2);
                                            if (set.size() == 1) {
                                                hasOneElement++;
                                            }

                                        }
                                    }
                                }
                                if (hasOneElement == 3) {
                                    System.out.println("Megvan a megoldás!");
                                    System.out.println("A számok sorrendje: ");
                                    for (int l = 0; l < 3; l++) {
                                        for (Map.Entry<Integer, Set<Integer>> entry : resultsMap.entrySet()) {
                                            if (entry.getValue().size() == 1 && entry.getValue().contains(l)) {
                                                System.out.print(entry.getKey() + " ");
                                            }
                                        }

                                    }
                                    System.out.println();
                                    return;
                                }
                            }
                        }

                        combinedResults.getResults().clear();
                    }

                }
            }

        }

    }
}
