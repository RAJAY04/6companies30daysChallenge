package day16;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int num = 1000010007;
        System.out.println(new IntegerToEnglishWords().numberToWords(num));
    }

    private static class Utils {
        public static final String[] UNITS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        public static final String[] TEN_TO_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        public static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        public static final String[] PREFIX = {"", "Thousand", "Million", "Billion"};
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder temp = new StringBuilder();
                helper(num % 1000, temp);
                result.insert(0, temp.append(Utils.PREFIX[index]).append(" "));
            }
            num /= 1000;
            index++;
        }

        return result.toString().trim();
    }

    private void helper(int num, StringBuilder sb) {
        if (num == 0) return;

        if (num >= 100) {
            sb.append(Utils.UNITS[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            sb.append(Utils.TENS[num / 10]).append(" ");
            if (num % 10 > 0) {
                sb.append(Utils.UNITS[num % 10]).append(" ");
            }
        } else if (num >= 10) {
            sb.append(Utils.TEN_TO_TWENTY[num - 10]).append(" ");
        } else if (num > 0) {
            sb.append(Utils.UNITS[num]).append(" ");
        }
    }
}