package by.Zabiyaka.quizer.task_generators;
import by.Zabiyaka.quizer.*;
import by.Zabiyaka.quizer.tasks.ExpressionTask;
import by.Zabiyaka.quizer.tasks.math_tasks.IntegerExpressionMathTask;

import java.util.EnumSet;
import java.util.Random;

public class ExpressionTaskGenerator implements TaskGenerator {
    public ExpressionTaskGenerator(int minNumber, int maxNumber, EnumSet<Operation> avaliable) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        if (avaliable.isEmpty()) {
            throw new RuntimeException("Can't have 0 allowed operations");
        }
        operations = avaliable.toArray(new Operation[0]);
    }
    public ExpressionTask generate() {
        int first = random.nextInt(maxNumber - minNumber) + minNumber;
        int second = random.nextInt(maxNumber - minNumber) + minNumber;
        Operation operation = operations[random.nextInt(operations.length)];
        if (operation == Operation.DIV) {
            second = Math.max(1, second / 2);
            first = second * random.nextInt(maxNumber / second);
        }
        return new IntegerExpressionMathTask(first, second, operation);
    }

    private final int minNumber;
    private static final Random random = new Random();
    private final int maxNumber;
    private final Operation[] operations;
}
