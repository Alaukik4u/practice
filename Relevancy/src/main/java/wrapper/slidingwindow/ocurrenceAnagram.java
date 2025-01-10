package wrapper.slidingwindow;

import java.util.Arrays;

public class ocurrenceAnagram {

    public static void main(String[] args) {
        String text = "mama";
        String word = "ma";
        System.out.print(countAnagrams(text, word));
    }

    private static int countAnagrams(String text, String word) {
        int n = text.length();
        int k = word.length();

        int characters =255, count=0;
        int [] chartext = new int [characters];
        int [] charword = new int [characters];

        if(n<k){
            System.out.println("invalid input");
            return -1;
        }


        int i=0, j=0, sum=0;
        int max = Integer.MIN_VALUE;
        while(j<n){

            chartext[characters-text.charAt(j)]++;
            if(j<k){
                charword[characters-word.charAt(j)]++;
            }
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(Arrays.equals(chartext, charword)){
                    count++;
                }
                chartext[characters-text.charAt(i)]--;
                i++;
                j++;
            }
        }

        return count;
    }
}
