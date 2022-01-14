package wrapper.recursion.IO;


public class StringAllSubsetWithCaseChangeHavingDigits {
    public static void main(String[] args) {
        String input = "a1B";
        String output = "";

        printAllSubset(input, output);
    }

    private static void printAllSubset(String input, String output) {
        if (input.length() == 0) {
            if (output.isEmpty()) {
                System.out.print("*");
            } else {
                System.out.print(output + " ");
            }

            return;
        }


        if(Character.isDigit(input.charAt(0))){
            printAllSubset(input.substring(1), output + input.charAt(0));
        }else{
            printAllSubset(input.substring(1), output + Character.toLowerCase(input.charAt(0)));
            printAllSubset(input.substring(1), output + Character.toUpperCase(input.charAt(0)));
        }

    }
}
