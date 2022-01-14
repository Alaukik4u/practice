package wrapper.recursion.IO;



public class StringAllSubsetWithSpaces {
    public static void main(String[] args) {
        String input ="abc";
        String output="";
        int index=0, size=input.length();

        printAllSubset(input, output, index, size);
    }

    private static void printAllSubset(String input, String output, int index, int size) {
        if(input.length() == 0){
            if(output.isEmpty()){
                System.out.print("*");
            }else{
                System.out.print(output+" ");
            }

            return;
        }

        if(index == 0 || size==input.length()){
            printAllSubset(input.substring(1), output+input.charAt(0), ++index, size);
        }else{
            printAllSubset(input.substring(1), output+input.charAt(0), ++index, size);
            printAllSubset(input.substring(1), output+"_"+input.charAt(0), ++index, size);
        }
    }
}
