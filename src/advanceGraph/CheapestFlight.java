package advanceGraph;

import java.util.Arrays;

public class CheapestFlight {

    public static void main(String[] args) {
       int n = 4, src = 0, dst = 3, k = 1;
       int [][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

       CheapestFlight obj = new CheapestFlight();
       int sol = obj.findCheapestPrice(n, flights, src, dst, k);
       System.out.println(sol);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE); 
        cost[src] = 0;

        for(int i=0; i <= k; i++){
            int[] temp = cost.clone();
            for(int[] flight: flights){
                int u = flight[0], v = flight[1], price = flight[2];
                if (cost[u] == Integer.MAX_VALUE) continue; // If source node u is not reachable
                if(temp[v] > cost[u] + price){
                    temp[v] = cost[u] + price;
                }
            }
            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE? -1: cost[dst];

    }
}
