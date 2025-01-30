package day28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII obj = new CombinationSumIII();
        System.out.println(obj.combinationSum3(3, 7));
    }

    List<Integer> list;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        res = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        dfs(1,n,k,vis);
        return res;
    }

    public void dfs(int s, int n , int k, Set<Integer> vis){
        if(n == 0 && k == 0){
            res.add(new ArrayList<>(list));
            return;
        }else if(n < 0 || k < 0){
            return;
        }

        for(int i = s; i <= 9; i++){
            if(!vis.contains(i)){
                list.add(i);
                vis.add(i);
                dfs(i,n - i,k - 1,vis);
                list.remove(list.size() - 1);
                vis.remove(i);
            }
        }
    }
}
