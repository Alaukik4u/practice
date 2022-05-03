package wrapper.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static wrapper.stack.MAH.printArray;

public class SunSetViews {

    public static void main(String[] args) {
        int buildings[]= {3,5, 4,4, 3,1, 3,2};
        ArrayList<Integer> result;
        result = sunsetViews(buildings, "EAST");
        printArray(result);
        result = sunsetViews(buildings, "WEST");
        printArray(result);
    }

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        if(direction.equals("EAST")){
            for(int i=buildings.length-1; i>=0; i--){
                if(stack.isEmpty()){
                    result.add(i);
                }else if(!stack.isEmpty() && stack.peek()>= buildings[i]){
                    continue;
                }else{
                    while(!stack.isEmpty() && stack.peek() < buildings[i]){
                        stack.pop();
                    }

                    if(stack.isEmpty()){
                        result.add(i);
                    }else{
                        continue;
                    }
                }
                stack.push(buildings[i]);
            }

            Collections.reverse(result);
            return result;

        }else{
            for(int i=0; i<buildings.length; i++){
                if(stack.isEmpty()){
                    result.add(i);
                }else if(!stack.isEmpty() && stack.peek()>= buildings[i]){
                    continue;
                }else{
                    while(!stack.isEmpty() && stack.peek() < buildings[i]){
                        stack.pop();
                    }

                    if(stack.isEmpty()){
                        result.add(i);
                    }else{
                        continue;
                    }
                }
                stack.push(buildings[i]);
            }
        }
        return result;
    }
}
