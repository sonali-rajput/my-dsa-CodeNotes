package advanceGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItineray {


    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        ReconstructItineray object = new ReconstructItineray();
        List<String> ans = object.findItinerary(tickets);
        System.out.println(ans);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        

        Map<String, List<String>> hashMap = new HashMap<>();

        // Create the adjlist (graph)
        for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            hashMap.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        // sort the to(destinations) values in graph
        for(List<String> to: hashMap.values()){
            Collections.sort(to);
        }

        // Start the journet from "JFK" terminal
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", hashMap, itinerary);
        return itinerary;
    }

    private void dfs(String airport, Map<String, List<String>>hashMap, LinkedList<String> itinerary) {
        
        List<String> destinations = hashMap.get(airport);
        while (destinations != null && !destinations.isEmpty() ){
            // remove the next destination to avoid revisiting the same path
            String next = destinations.remove(0);
            dfs(next,hashMap,itinerary);
        }

        // Add the airport to the itineray at the start to build the itinerary in reverse order
        itinerary.addFirst(airport);


    }
}
