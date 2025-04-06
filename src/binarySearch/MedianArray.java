package binarySearch;

public class MedianArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = x;

        while(start <= end) {
            int partX = (start + end)/2; // x-partition
            int partY = (x+y+1)/2 - partX; // y-partition

            int xLeft = partX == 0 ? Integer.MIN_VALUE: nums1[partX-1];
            int xRight = partX == x ? Integer.MAX_VALUE: nums1[partX];
            int yLeft = partY == 0 ? Integer.MIN_VALUE: nums2[partY-1];
            int yRight = partY == y ? Integer.MAX_VALUE: nums2[partY];

            if(xLeft<=yRight && yLeft<=xRight) { // partition is done okay
                if((x+y)%2==0) { // even case
                    return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight))/2;
                }
                else {
                    return Math.max(xLeft, yLeft);
                }
            }
            else if(xLeft>yRight) {
                end = partX - 1;
            } else {
                start = partX + 1;
            }

        }

        return 0;

    }
}
