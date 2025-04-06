package binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    
    public static void main(String[] args) {
        TimeMap TimeMap = new TimeMap();
        TimeMap.set("foo","bar",1);
        System.out.println(TimeMap.get("foo",1));
        System.out.println(TimeMap.get("foo",3));
        TimeMap.set("foo","bar2",4);
        System.out.println(TimeMap.get("foo",4));
        System.out.println(TimeMap.get("foo",5));


    }

    private Map<String, TreeMap<Integer, String>> map;


    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value); 
    }
    
    public String get(String key, int timestamp) {
        
        TreeMap<Integer, String> treeMap = map.get(key);
        if(treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry==null? "": entry.getValue();
    }

}
