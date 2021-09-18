package by.Zabiyaka.quizer.task_generators;
import by.Zabiyaka.quizer.*;
import by.Zabiyaka.quizer.tasks.EquationTask;
import by.Zabiyaka.quizer.tasks.ExpressionTask;

import java.util.EnumSet;
import java.util.Random;

public class EquationTaskGenerator implements TaskGenerator {
    public EquationTaskGenerator(int minNumber, int maxNumber, EnumSet<Operation> avaliable) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        operations = avaliable;
    }
    public EquationTask generate() {
        int first = random.nextInt(maxNumber - minNumber) + minNumber;
        int second = random.nextInt(maxNumber - minNumber) + minNumber;
        Operation[] supported = operations.toArray(new Operation[0]);
        Operation operation = supported[random.nextInt(supported.length)];
        if (operation == Operation.DIV) {
            second = Math.max(1, second / 2);
            first = second * Math.max(1, random.nextInt(maxNumber / second));
        } else if (operation == Operation.MUL) {
            first = Math.max(1, first / 2);
            second = first * Math.max(1, random.nextInt(maxNumber / first));
        }
        return new EquationTask(first, second, operation);
    }

    private final int minNumber;
    private static final Random random = new Random();
    private final int maxNumber;
    private final EnumSet<Operation> operations;
}