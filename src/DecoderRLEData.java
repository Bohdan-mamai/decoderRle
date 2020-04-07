import java.util.Scanner;

public class DecoderRLEData {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String decodedText = decoding(text);
        System.out.println("Decoded text: " + decodedText);

    }

    public static String decoding(String inputData) {
        String regex = "\\\\";

        String regexNum = "[0-9]";

        int count = 0;
        
        StringBuilder result = new StringBuilder () ;

        for (int i = 0; i < inputData.length(); i++) {

            char firstChar = inputData.charAt(i);
            char secondChar = inputData.charAt(++i);

            String element = String.valueOf(firstChar);
            String nextElement = String.valueOf(secondChar);

            if (element.matches(regexNum)) {
                count = count * 10 + firstChar - '0' ;
            } else if(element.matches(regex) && nextElement.matches(regex)){
                result.append(firstChar);
            } else if(element.matches(regex) && nextElement.matches(regexNum)){
                result.append(secondChar);
            }
                while (count > 0){
                    result.append(secondChar);
                    count--;
                }
        }
        return result.toString();
    }
}


