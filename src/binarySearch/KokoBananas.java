package binarySearch;

public class KokoBananas {

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h  = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1; int right = 1;
        for(int pile: piles) {
            right = Math.max(right, pile);
        }

        while(left<right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles,mid,h)) {
                right = mid;
            } else {
                left  = mid + 1;
            }
        }
        return left; // minimum speed
    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        int hours  = 0;
        for (int pile: piles) {
            hours += Math.ceil((double) pile / speed);
        }
        return hours <= h;
    }
}
