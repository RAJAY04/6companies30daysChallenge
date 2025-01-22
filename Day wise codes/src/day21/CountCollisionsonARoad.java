package day21;

public class CountCollisionsonARoad {
    public static void main(String[] args) {
        CountCollisionsonARoad obj = new CountCollisionsonARoad();
        System.out.println(obj.countCollisions("RRR"));
    }

    public int countCollisions(String directions) {
        int right = 0;
        boolean isStatic = false;
        int totalCollisions = 0;
        for(char c : directions.toCharArray()){
            if(c == 'L'){
                if(right > 0 && !isStatic){
                    totalCollisions += 2;
                    totalCollisions += (right - 1);
                    right = 0;
                    isStatic = true;
                }else if(isStatic){
                    totalCollisions++;
                }
            }else if(c == 'R'){
                right++;
                isStatic = false;
            }else{
                if(right > 0){
                    totalCollisions += right;
                    right = 0;
                }
                isStatic = true;
            }
        }
        return totalCollisions;
    }
}
