package day22;

import java.util.*;

class ThroneInheritance {
    Set<String> deadPpl;
    Map<String, List<String>> map;
    LinkedList<String> order;
    String root;
    public ThroneInheritance(String kingName) {
        deadPpl = new HashSet<>();
        order = new LinkedList<>();
        map = new HashMap<>();
        root = kingName;
        map.put(kingName,new ArrayList<>());

    }

    public void birth(String parentName, String childName) {
        List<String> childs = map.get(parentName);
        childs.add(childName);
        map.putIfAbsent(childName,new ArrayList<>());
    }

    public void death(String name) {
        deadPpl.add(name);
    }

    public List<String> getInheritanceOrder() {
        order.clear();
        findOrder(root);
        return order;
    }

    public void findOrder(String root){
        if(root == null)return;

        if(!deadPpl.contains(root)){
            order.add(root);
        }

        for(String child : map.get(root)){
            if(child != null){
                findOrder(child);
            }
        }
    }
}
