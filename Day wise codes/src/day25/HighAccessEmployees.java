package day25;

import java.util.*;

public class HighAccessEmployees {
    public static void main(String[] args) {

    }
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> list : access_times){
            String employee = list.get(0);
            String time = list.get(1);
            map.putIfAbsent(employee,new ArrayList<>());
            List<String> employeeList = map.get(employee);
            employeeList.add(time);
        }

        List<String> highAccessEmployees = new ArrayList<>();
        for(String employee : map.keySet()){
            List<String> times = map.get(employee);
            if(times.size() < 3)continue;
            Collections.sort(times);
            if(isHighAccess(times)){
                highAccessEmployees.add(employee);
            }
        }
        return highAccessEmployees;
    }

    public boolean isHighAccess(List<String> times){
        int i = 0, j = 2, n = times.size();
        while(j < n){
            String last = times.get(j);
            String first = times.get(i);
            int lastMins = Integer.parseInt(last.substring(2,4));
            int lastHrs = Integer.parseInt(last.substring(0,2));
            int firstHrs = Integer.parseInt(first.substring(0,2));
            int firstMins = Integer.parseInt(first.substring(2,4));
            int minDiff = lastMins - firstMins;
            int hrDiff = lastHrs - firstHrs;
            int hrDiffInMins = hrDiff * 60;
            int totalMinDiff = hrDiffInMins + minDiff;
            if(totalMinDiff < 60)return true;
            i++; j++;
        }
        return false;
    }
}
