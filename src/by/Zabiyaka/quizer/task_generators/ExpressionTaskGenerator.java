package by.Zabiyaka.quizer.task_generators;
import by.Zabiyaka.quizer.*;
import by.Zabiyaka.quizer.tasks.ExpressionTask;

import java.util.EnumSet;

public class ExpressionTaskGenerator implements TaskGenerator {
    ExpressionTaskGenerator(int minNumber, int maxNumber) {
        EnumSet<Result>  enumSet;
    }
    public ExpressionTask generate() {
        return new ExpressionTask();
    }
}
