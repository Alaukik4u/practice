package interview.Archive;

import java.util.PriorityQueue;

public class MinimumNumberOfStation {

    /*
    oracle

    Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
    We are given two arrays that represent the arrival and departure times of trains that stop.

    Examples:

    Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
    dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
    Output: 3
    Explanation: There are at-most three trains at a time (time between 11:00 to 11:20)

    Input: arr[] = {9:00, 9:40}
    dep[] = {9:10, 12:00}
    Output: 1
    Explanation: Only one platform is needed.*/


  /*  dep[] = {9:10,11:20,11:30,12:00,19:00, 20:00}


   // 9:10 ---> 9:40 > 9:10 (take out the node out )
   1 //12:00 --> 9:50 (enter one node 11:20)
    2//11:20 ---> 11: ()
    3//11:20 --> 15: (11:20 out from heap and make it 19 )
    3// 11:30 ---> 18 (11:30 out from wrapper.queue and make it 20 )
    // 12:00 ---




    9:40 --- 9:40 > 9:10 (c--);
    11:20 --- 9:50 <11:20 (c++)
    11:30 --- 11 < 11:30 (c++)
    12:00 -- 15 > 12 (nthg)

    22:01 22:02 10:03 10:04
    23:01 11:02 11:03 11:04
  */


    public static void main(String[] args) {
        int[] arrival = new int[]{900, 940, 950, 1100, 1500, 1800, 2201, 2202, 2203, 2204 };
        int[] departure = new int[]{910, 1200, 1120, 1130, 1900, 2000, 2301, 2302, 2303, 2304};


        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(910);
        for(int i=1; i<arrival.length; i++){
            Integer minvalue = minHeap.peek();
            if(arrival[i] > minvalue){

                minvalue = departure[i];
                minHeap.poll();
                minHeap.add(minvalue);
            }else{
                minHeap.add(departure[i]);
            }
        }

        System.out.println("Minimum number of stations :: " + minHeap.size());

    }







}
