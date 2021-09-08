package by.Zabiyaka.quizer;

public class Quiz {
    Quiz(TaskGenerator generator, int taskCount) {
        this.taskCount = taskCount;
        this.generator = generator;
    }

   Task NextTask() {
        if (taskCount <= 0) {
            throw new RuntimeException("Next task requested when test is over");
        }
        if (lastResult != Result.INCORRECT_INPUT) {
            --taskCount;
            last = generator.generate();
            return last;
        }

        return last;
    }

    Result ProvideAnswer(String answer) {
        lastResult = last.validate(answer);
        if (lastResult == Result.OK) {
            ++correctAnswerNumber;
        } else if (lastResult == Result.INCORRECT_INPUT) {
            ++incorrectInputNumber;
        } else if (lastResult == Result.WRONG_ANSWER) {
            ++wrongAnswerNumber;
        } else {
            throw new RuntimeException("Unknown result");
        }
        return lastResult;
    }

    boolean isFinished() {
        return (taskCount == 0);
    }

    public int getCorrectAnswerNumber() {
        return correctAnswerNumber;
    }

    public int getWrongAnswerNumber() {
        return wrongAnswerNumber;
    }

    public int getIncorrectInputNumber() {
        return incorrectInputNumber;
    }

    double getMark() {
        if (taskCount != 0) {
            throw new RuntimeException("Trying to get mark while still has tasks");
        }
        return 10.0 * correctAnswerNumber /
                (correctAnswerNumber + wrongAnswerNumber);
    }

    private int correctAnswerNumber;
    private int wrongAnswerNumber;
    private int incorrectInputNumber;
    private int taskCount;
    private final TaskGenerator generator;
    private Task last;
    private Result lastResult;
}
