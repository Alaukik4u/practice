package stack;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price);
    }

    private static void calculateSpan(int[] price) {
        Stack<Node> st = new Stack<Node>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<price.length; i++){

            if(st.isEmpty()){
                list.add(-1);
            }else if(!st.isEmpty() && price[i] < st.peek().value){
                list.add(st.peek().index);
            }else if(!st.isEmpty() && price[i] >= st.peek().value){
                while(!st.isEmpty() && price[i] >= st.peek().value){
                    st.pop();
                }

                if(st.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(st.peek().index);
                }
            }
            st.push(new Node(price[i], i));
        }


        for(int i=0; i<list.size(); i++){
            System.out.print((i-list.get(i))+ " " );
        }

    }
}

