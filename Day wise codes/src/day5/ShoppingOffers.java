package day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
    public static void main(String[] args) {
        List<Integer> price = List.of(2, 5);
        List<List<Integer>> special = List.of(List.of(3, 0, 5), List.of(1, 2, 10));
        List<Integer> needs = List.of(3, 2);
        System.out.println(new ShoppingOffers().shoppingOffers(price, special, needs));
    }

    Map<Integer, Integer> dp = new HashMap<>();

    public int encodeList(List<Integer> list){
        int encodedVal = 0;
        for(int i = 0 ; i < list.size(); i++){
            encodedVal |= list.get(i) << (i * 4);
        }
        return encodedVal;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        int encode = encodeList(needs);
        if (dp.containsKey(encode)) {
            return dp.get(encode);
        }

        int totalCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            totalCost += needs.get(i) * price.get(i);
        }

        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>(needs);
            boolean canApply = true;

            for (int i = 0; i < needs.size(); i++) {
                newNeeds.set(i, newNeeds.get(i) - offer.get(i));
                if (newNeeds.get(i) < 0) {
                    canApply = false;
                    break;
                }
            }

            if (canApply) {
                totalCost = Math.min(totalCost,
                        dfs(price, special, newNeeds) + offer.get(offer.size() - 1));
            }
        }

        dp.put(encode, totalCost);
        return totalCost;
    }
}
