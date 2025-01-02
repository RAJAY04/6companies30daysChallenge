public class FindTheWinnerOfCircularGame {
    public static void main(String[] args) {
        FindTheWinnerOfCircularGame obj = new FindTheWinnerOfCircularGame();
        System.out.println(obj.findTheWinner(5, 2));
    }

    public int findTheWinner(int n, int k) {
        int res = 0;
        for(int i = 1; i <= n ;i++){
            res = (res + k) % i;
        }
        return res + 1;
    }
}
