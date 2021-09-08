package by.Zabiyaka.quizer.tasks.math_tasks;

import by.Zabiyaka.quizer.Operation;
import by.Zabiyaka.quizer.Result;
import by.Zabiyaka.quizer.tasks.ExpressionTask;

public class IntegerExpressionMathTask extends ExpressionTask implements IntegerMathTask {
    public IntegerExpressionMathTask(int first, int second, Operation op) {
        text = String.valueOf(first);

        switch (op) {
            case ADD -> {
                expected = first + second;
                text += " + ";
            }
            case SUB -> {
                expected = first - second;
                text += " - ";
            }
            case MUL -> {
                expected = first * second;
                text += " * ";
            }
            case DIV ->  {
                if (second == 0) {
                    throw new ArithmeticException("Cant divide by 0");
                }

                if (first % second != 0) {
                    throw new RuntimeException("Division must be without remainder");
                }

                expected = first / second;
                text += " / ";
            }

            default -> {
                throw new RuntimeException("Unknown operation");
            }
        }

        text += second + " = ?";
    }

    public Result generate() {

    }
}
