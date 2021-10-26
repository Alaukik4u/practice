package wrapper.dynamicProgramming;

public class longestCommonSubsequence {


    public static void main(String[] args) {
        String s1 = "alaukik";
        String s2 = "";

        System.out.println(LCS(s1, s2));
    }

    private static int LCS(String s1, String s2) {
        int n1 =s1.length(), n2=s2.length();
        int[][] t = new int[n1+1][n2+1];
        int j = 0, i = 0;
        for (i = 0; i <= n1; i++) {
            for (j = 0; j <= n2; j++) {

                if(i ==0 || j ==0){
                    t[i][j] =0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{

                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }

            }
        }

        return t[n1][n2];
    }

}