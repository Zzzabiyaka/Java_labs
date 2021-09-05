package by.Zabiyaka.quizer.tasks;

import by.Zabiyaka.quizer.*;

import java.util.Objects;

public class ExpressionTask implements Task {
    public ExpressionTask() {
        expected = 4;
    }
    public String getText() {
        return "2 + 2 = ?";
    }

    public Result validate(String answer) {
        if (Objects.equals(answer, expected.toString())) {
            return Result.OK;
        } else {
            return Result.WRONG;
        }
    }

    private Integer expected;
}
