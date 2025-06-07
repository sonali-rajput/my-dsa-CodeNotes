package practice;

import java.util.ArrayList;
import java.util.HashMap;
// import java.util.ArrayList;
// import javafx.util.Pair;
   import java.util.AbstractMap.SimpleEntry;

public class TimeStamp {


    public static void main(String[] args) {
        TimeStamp obj = new TimeStamp();
        obj.set("foo","bar", 1);
        System.out.println(obj.get("foo",1));
        System.out.println(obj.get("foo",3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo",4));
        System.out.println(obj.get("foo",5));
        


    }

    private static HashMap<String, ArrayList<SimpleEntry<Integer, String>>> map ;
    public TimeStamp(){
        map = new HashMap<>();
    }
    public  void set(String key, String value, int timestamp){
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<SimpleEntry<Integer, String>>());
        }

        map.get(key).add(new SimpleEntry<Integer, String>(timestamp, value));
    
    }

    public String get(String key, int timestamp){

        ArrayList<SimpleEntry<Integer, String>> newlist = map.get(key);
        if(!map.containsKey(key)){
            newlist =  new ArrayList<SimpleEntry<Integer, String>>();
            
        }
        int left = 0;
        int right = newlist.size() - 1;
        String ans = "";
        while(left<=right){
            int mid = left+(right-left)/2;

            if(timestamp >= newlist.get(mid).getKey()){
                left = mid+1;
                ans = newlist.get(mid).getValue();
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

}
