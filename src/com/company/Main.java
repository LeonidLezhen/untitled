package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.company.Calculator.calculate;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;


public class Main {
    public static void main(String[] args) throws IncompatibleOperation, NumberIsOutOfRange {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                out.print("Enter an expression (Num OP Num): ");
                String userIn = br.readLine();
                if (userIn.toUpperCase().trim().equals("EXIT")) break;

                String[] expression = userIn.split("\\s");
                String num1 = expression[0];
                String num2 = expression[2];
                String op = expression[1];

                if (!op.matches("[+-/*]?+")) { // check if operand id incompatible
                    throw new IncompatibleOperation();
                }

                if (Romans.isRoman(num1) && Romans.isRoman(num2)) {
                    out.println(calculate(expression[0], expression[2], op));

                } else if (!Romans.isRoman(num1) && !Romans.isRoman(num2))
                    out.println(calculate(parseInt(num1), parseInt(num2), op));
                else {
                    throw new IncompatibleTypes();
                }
            }

        }
        catch (IOException | IncompatibleTypes e) {
            e.printStackTrace();
        }

    }

}