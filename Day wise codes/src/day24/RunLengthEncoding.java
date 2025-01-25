package day24;

public class RunLengthEncoding {
    public static void main(String[] args) {
        RunLengthEncoding obj = new RunLengthEncoding();
        String s = "aaaabbbccdaa";
        System.out.println(obj.encode(s));
    }

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < n; i++){
            if(c == s.charAt(i)){
                count++;
            }else{
                sb.append(c+Integer.toString(count));
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(c+Integer.toString(count));
        return sb.toString();
    }
}
