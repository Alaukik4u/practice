package wrapper.binarySearch;

public class NextGreaterAlphaBet {


    public static void main(String[] args) {
        char letters[] = {'A', 'r', 'z'};
        char K = 'p';
        char result = nextGreatestAlphabet(letters,0, letters.length-1, K);

        // Function call
        System.out.println(result);
    }

    private static char nextGreatestAlphabet(char[] letters, int low, int high, char k) {
        char res='#';
        if(k>=letters[high]){
            return letters[0];
        }
        while(low <= high){
            int mid = (low+high)/2;

            if(letters[mid] == k){
                return letters[mid];
            }else if(letters[mid] < k){
                low = mid+1;
            }else if (letters[mid] > k){
                res=letters[mid];
                high = mid -1;
            }
        }
        return res;
    }


}
