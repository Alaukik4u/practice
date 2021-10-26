package wrapper.slidingwindow;

import java.util.HashMap;

public class ocurrenceAnagramminimumwindow {

    public static void main(String[] args) {
        String s = "ACTBTEEEC";
        String t = "EC";

        System.out.print("-->Smallest window that contain all character : ");
        System.out.print(Minimum_Window(s, t));
    }

    private static int Minimum_Window(String str, String pat) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count =0, i=0,j=0, min =Integer.MAX_VALUE;
        char[] stra = str.toCharArray();
        char[] pata = pat.toCharArray();

        for (char c : pata){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        count = map.size();
        int[] str2 = new int[2];

        while(j<stra.length){
            if(count > 0){
                if(map.containsKey(stra[j])){
                    map.put(stra[j], map.getOrDefault(stra[j],0)-1);
                    if(map.get(stra[j]) == 0){
                        count--;
                    }
                }

                if(count == 0){
                    while(i<j && count ==0){
                        if((j-i+1) < min){
                            str2[0] = i;
                            str2[1] = j;
                        }

                        min= Math.min(min, j-i+1);
                        if(map.containsKey(stra[i])){
                            map.put(stra[i], map.getOrDefault(stra[i],0)+1);
                            if(map.get(stra[i]) == 1){
                                count++;
                            }
                        }
                        i++;
                    }
                }

                j++;
            }


        }
        System.out.println("minimum string is "+str.substring(str2[0], str2[1]+1));
        return min;
    }


}
