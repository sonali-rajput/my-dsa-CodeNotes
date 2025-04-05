package stack;

import java.util.Arrays;

public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0;i<n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        int count = 0;
        double prevTime = 0;
        for(double[] car: cars) {
            if(car[1]>prevTime) {
                count++;
                prevTime = car[1];
            }
        }
        return count;
    }

}
