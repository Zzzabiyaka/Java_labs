package by.Zabiyaka.quizer.tasks;

import by.Zabiyaka.quizer.*;

abstract public class ExpressionTask implements Task {
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

    protected int expected;
    protected String text;
}
