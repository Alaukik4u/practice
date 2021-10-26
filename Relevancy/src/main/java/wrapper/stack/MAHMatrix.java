package wrapper.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MAHMatrix {

    public static void main(String[] args) {
        int A[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.print("Area of maximum rectangle is " + maxRectangle(A));
    }

    private static int maxRectangle(int[][] a) {
        int[] hist = new int[a[0].length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a[0].length; i++) {
            hist[i] = a[0][i];
            max = Math.max(max, getMaxArea(hist, a[0].length));
        }


        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    hist[j] = 0;
                } else {
                    hist[j] = hist[j] + a[i][j];
                }

            }
            max = Math.max(max, getMaxArea(hist, a[0].length));

        }

        return max;
    }


    private static int getMaxArea(int[] hist, int n) {

        int max = Integer.MIN_VALUE;
        int maxindex = -1;
        List<Integer> NSER = printNSER(hist, n);
        printArray(NSER);
        List<Integer> NSEL = printNSEL(hist, n);
        printArray(NSEL);


        for (int i = 0; i < NSER.size(); i++) {
            System.out.println(i + "th width " + (NSER.get(i) - NSEL.get(i) - 1));
            if (hist[i] * (NSER.get(i) - NSEL.get(i) - 1) > max) {
                maxindex = i;
            }
            max = Math.max(max, hist[i] * (NSER.get(i) - NSEL.get(i) - 1));
        }

        System.out.println("maximum index :: " + maxindex);
        return max;
    }

    private static List<Integer> printNSEL(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.isEmpty() && arr[i] > stack.peek().value) {
                list.add(stack.peek().index);
            } else if (!stack.isEmpty() && arr[i] <= stack.peek().value) {
                while (!stack.isEmpty() && arr[i] <= stack.peek().value) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().index);
                }
            }
            stack.push(new Node(arr[i], i));
        }

        return list;
    }

    private static List<Integer> printNSER(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(arr.length);
            } else if (!stack.isEmpty() && arr[i] > stack.peek().value) {
                list.add(stack.peek().index);
            } else if (!stack.isEmpty() && arr[i] <= stack.peek().value) {
                while (!stack.isEmpty() && arr[i] <= stack.peek().value) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(arr.length);
                } else {
                    list.add(stack.peek().index);
                }
            }
            stack.push(new Node(arr[i], i));
        }
        Collections.reverse(list);
        return list;
    }

    public static void printArray(List<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
