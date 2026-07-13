class Solution {
    List<Integer> allSequenceDigits = new ArrayList<>();

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> sequentialDigitResult = new ArrayList<>();

        if (allSequenceDigits.isEmpty()) {
            List<Integer> prevSequenceDigit =
                    new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

            allSequenceDigits.addAll(prevSequenceDigit);

            while (!prevSequenceDigit.isEmpty()) {
                List<Integer> currSequenceDigit = new ArrayList<>();

                for (Integer integer : prevSequenceDigit) {
                    if (integer % 10 < 9) {
                        currSequenceDigit.add(
                                integer * 10 + (integer % 10 + 1));
                    } else {
                        break;
                    }
                }

                if (!currSequenceDigit.isEmpty()) {
                    allSequenceDigits.addAll(currSequenceDigit);
                }

                prevSequenceDigit = currSequenceDigit;
            }
        }

        for (Integer allSequenceDigit : allSequenceDigits) {
            if (allSequenceDigit >= low && allSequenceDigit <= high) {
                sequentialDigitResult.add(allSequenceDigit);
            } else if (allSequenceDigit > high) {
                break;
            }
        }
        return sequentialDigitResult;
    }
}