package pekan3_2511532022;

import java.util.*; // Penting: Supaya Stack dan Scanner dikenali

public class StackPostfix_2511532022 {
    public static int postfixEvaluate_2511532022(String expression) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner input_2511532022 = new Scanner(expression);
        
        while (input_2511532022.hasNext()) {
            if (input_2511532022.hasNextInt()) {
                s.push(input_2511532022.nextInt());
            } else {
                String operator = input_2511532022.next();
                int operand2 = s.pop();
                int operand1_2511532022 = s.pop();
               
                if (operator.equals("+")) {
                    s.push(operand1_2511532022 + operand2);
                } else if (operator.equals("-")) {
                    s.push(operand1_2511532022 - operand2);
                } else if (operator.equals("*")) {
                    s.push(operand1_2511532022 * operand2);
                } else if (operator.equals("/")) {
                    s.push(operand1_2511532022 / operand2);
                }
            } // Penutup blok 'else' dipindah ke sini
        }
        input_2511532022.close(); // Tutup scanner setelah loop selesai
        return s.pop();
    }

    public static void main(String[] args) {
        // Contoh: "5 2 4 * + 7 -"
        // Cara bacanya: 5 + (2 * 4) - 7 = 6
        System.out.println("hasil postfix: " + postfixEvaluate_2511532022("5 2 4 * + 7 -"));
    }
}