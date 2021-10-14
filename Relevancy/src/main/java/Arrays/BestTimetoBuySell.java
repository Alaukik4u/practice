package Arrays;

public class BestTimetoBuySell {

    public static void main(String[] args) {
        int [] arr = {3,2,4,1,5,6};
        System.out.println("max profit in buy sell "+maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int profit=0;


        for(int i=1;i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit+= prices[i]-prices[i-1];
            }
        }

        return profit;
    }
}
