package wrapper.Twopointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "TEET";
        System.out.println(isPalindrome(s));
    }
        public static boolean isPalindrome(String s) {
            s = s.toLowerCase();
            s = s.replaceAll("[^a-z0-9]", "");
            int leftPointer = 0, rightPointer = s.toCharArray().length -1;
            char [] charArray = s.toCharArray();
            while(leftPointer < rightPointer){
                if(charArray[leftPointer] != charArray[rightPointer]){
                    return false;
                }
                leftPointer++;
                rightPointer--;
            }
            return true;
        }
}

