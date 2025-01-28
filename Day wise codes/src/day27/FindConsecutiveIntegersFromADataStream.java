package day27;



public class FindConsecutiveIntegersFromADataStream {
    public static void main(String[] args) {
        //Input
        //["DataStream", "consec", "consec", "consec", "consec"]
        //[[4, 3], [4], [4], [4], [3]]
        //Output
        //[null, false, false, true, false]

        DataStream dataStream = new DataStream(1,2);
        System.out.println(dataStream.consec(1));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(1));
        System.out.println(dataStream.consec(1));
        System.out.println(dataStream.consec(1));

    }

    static class DataStream {
        private int val, k, count;

        public DataStream(int value, int k) {
            this.val = value;
            this.k = k;
            this.count = 0;
        }

        public boolean consec(int num) {
            count = (num == val) ? count + 1 : 0;
            return count >= k;

        }
    }
}
/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */

