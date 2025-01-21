package day20;

import java.util.Arrays;

public class AssignCookie {
    public static void main(String[] args) {
        AssignCookie obj = new AssignCookie();
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(obj.findContentChildren(g,s));
    }
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i = 0 , j = 0 , count = 0;
        while( i < n && j < m){
            if(g[i] <= s[j]){
                count++;
                i++;
                j++;
            }else if(g[i] > s[j]){
                j++;
            }
        }
        return count;
    }
}
