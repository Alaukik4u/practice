package wrapper.Arrays;

public class median2sortedArraysLogarithmic {

    public static void main(String[] args) {
        int ar1[] = {1, 2, 3, 6};
        int ar2[] = {4, 6, 8, 10};
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 != n2) {
            System.out.println(
                    "Doesn't work for arrays "
                            + "of unequal size");
        } else if (n1 == 0) {
            System.out.println("wrapper.Arrays are empty.");
        } else if (n1 == 1 ) {
            System.out.println((ar1[0] + ar2[0]) / 2);
        } else {
            System.out.println("Median is " + getMedian(ar1, ar2, 0, 0, ar1.length - 1, ar2.length - 1));
        }
    }

    private static int getMedian(int[] ar1, int[] ar2, int startA, int startB, int endA, int endB) {
        if (endA - startA == 1) {
            return (Math.max(ar1[startA], ar2[startB]) + Math.min(ar1[endA], ar2[endB]) )/ 2;
        }

        int median1 = median(ar1, startA, endA);
        int median2 = median(ar2, startB, endB);

        if (median1 == median2) {
            return median1;
        } else if (median1 < median2) {
            return getMedian(ar1, ar2, (startA + endA+1) / 2, startB, endA, (startB + endB+1) / 2);

        } else {
            return getMedian(ar1, ar2, startA, (startB + endB+1) / 2, (startA + endA+1) / 2, endB);
        }
    }

    private static int median(int[] ar1, int start, int end) {
        int n = end - start + 1;

        if (n % 2 == 0) {
            return (ar1[start + n / 2] + ar1[start + (n / 2 - 1)]) / 2;
        } else {
            return ar1[start + n / 2];
        }
    }
}


