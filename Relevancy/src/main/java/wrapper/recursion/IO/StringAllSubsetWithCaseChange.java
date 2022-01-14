package wrapper.recursion.IO;


public class StringAllSubsetWithCaseChange {
    public static void main(String[] args) {
        String input = "ab";
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


        printAllSubset(input.substring(1), output + Character.toLowerCase(input.charAt(0)));
        printAllSubset(input.substring(1), output + Character.toUpperCase(input.charAt(0)));
    }
}
