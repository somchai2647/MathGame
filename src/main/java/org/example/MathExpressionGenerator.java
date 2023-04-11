package org.example;

import java.util.Random;

public class MathExpressionGenerator {

    private String expression = "";

    public String generateExpression(int difficulty) {
        Random rand = new Random();
        int numExpressions = rand.nextInt(2) + 2; // Random number of expressions (2 or 3)

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numExpressions; i++) {
            int operand1 = rand.nextInt(difficulty * 15) + 1; // Random first operand
            int operand2 = rand.nextInt(difficulty * 10) + 1; // Random second operand
            int operator = rand.nextInt(getNumOperators(difficulty)); // Random operator (+, -, *, /, ^, %)

            // Generate expression based on operator and difficulty level
            switch (operator) {
                case 0:
                    sb.append(operand1).append("+").append(operand2);
                    break;
                case 1:
                    sb.append(operand1).append("-").append(operand2);
                    break;
                case 2:
                    sb.append(operand1).append("*").append(operand2);
                    break;
                case 3:
                    // Ensure division is valid (non-zero denominator)
                    int denominator;
                    do {
                        denominator = rand.nextInt(difficulty * 5) + 1;
                    } while (operand2 % denominator != 0);
                    sb.append(operand1).append("/").append(denominator);
                    break;
                case 4:
                    sb.append(operand1).append("^").append(operand2);
                    break;
                case 5:
                    sb.append(operand1).append("%").append(operand2);
                    break;
                default:
                    break; // Invalid operator
            }

//             Randomly insert parentheses around sub-expressions
//            if (i < numExpressions - 1 && rand.nextBoolean()) {
//                sb.insert(0, "(");
//                sb.append(")");
//            }
        }
        this.expression = sb.toString();
        return sb.toString();
    }

    private static int getNumOperators(int difficulty) {
        switch (difficulty) {
            case 1:
                return 2; // +, -
            case 2:
                return 4; // +, -, *, /
            case 3:
                return 6; // +, -, *, /, ^, %
            default:
                return 0; // Invalid difficulty level
        }
    }

    @Override
    public String toString() {
        return expression;
    }
}
