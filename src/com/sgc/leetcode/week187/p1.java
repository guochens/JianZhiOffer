package com.sgc.leetcode.week187;

import java.util.*;

public class p1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> paths = new ArrayList<>();

        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.equals("")){
                break;
            }
            String[] city = s.split(",");
            List<String> path = new ArrayList<>();
            path.add(city[0]);
            path.add(city[1]);
            paths.add(path);
        }
        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Map<String ,String> map = new HashMap<>();
        for(List<String> path:paths){
            if(path.equals("")) {
                continue;
            }
            map.put(path.get(0),path.get(1));
        }
        String city = paths.get(0).get(0);
        while(map.containsKey(city)){
            city = map.get(city);
        }
        return city;
    }
}
