package wrapper.slidingwindow;

import java.util.HashMap;

public class LargestSubstringwithKuniqueCharacters {
    public static void main(String[] args) {
        String s = "kkkkkkoooof";
        int k = 2;
        System.out.println(kUniques(s, k));
    }

    private static int kUniques(String s, int k) {
        int i=0, j=0, sum=0;
        int n = s.length();
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int[] str = new int[2];
        while(j<n){
            map.put(ch[j], map.getOrDefault(ch[j],0)+1);
            if(map.size() < k){
                j++;
            }else if(map.size() == k){
                if((j-i+1) > max){
                    str[0] = i;
                    str[1] = j;
                }
                max = Math.max(max, (j-i+1));


                j++;
            }else if(map.size() > k){
                while(map.size() > k){
                    int count = map.get(ch[i])-1;
                    if(count == 0){
                        map.remove(ch[i]);
                    }else{
                        map.put(ch[i], count);
                    }
                    i++;
                }
                j++;
            }
        }

        System.out.println("max string is "+s.substring(str[0],str[1]+1));

        return max;
    }
}
