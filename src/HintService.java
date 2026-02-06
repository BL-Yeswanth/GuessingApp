class HintService {

    public static String generateHint(int target, int hintCount) {

        if (hintCount == 1) {
            return (target % 2 == 0)
                    ? "Hint: Number is EVEN"
                    : "Hint: Number is ODD";
        }

        if (hintCount == 2) {
            return (target > 50)
                    ? "Hint: Number is greater than 50"
                    : "Hint: Number is 50 or less";
        }

        if (hintCount == 3) {
            return (target % 5 == 0)
                    ? "Hint: Number is divisible by 5"
                    : "Hint: Number is not divisible by 5";
        }

        return "No more hints available";
    }
}
