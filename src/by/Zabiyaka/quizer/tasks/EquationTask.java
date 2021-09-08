package by.Zabiyaka.quizer.tasks;

import by.Zabiyaka.quizer.*;

abstract public class EquationTask implements Task {
    public EquationTask(int first, int second, Operation op) {
        text = String.valueOf(first);
        switch (op) {
            case ADD -> {
                expected = second - first;
                text += " + ";
            }
            case SUB -> {
                expected = first - second;
                text += " - ";
            }
            case MUL -> {
                if (first == 0) {
                    throw new ArithmeticException("Cant divide by 0");
                }

                expected = second / first;
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

        text += "x = " + second;
    }

    public String getText() {
        return text;
    }

    public Result validate(String answer) {
        int got;
        try {
            got = Integer.parseInt(answer);
        } catch (NumberFormatException exception) {
            return Result.INCORRECT_INPUT;
        }
        if (got == expected) {
            return Result.OK;
        } else {
            return Result.WRONG_ANSWER;
        }
    }

    private final int expected;
    private String text;
}
