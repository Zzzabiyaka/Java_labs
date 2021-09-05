package by.Zabiyaka.quizer;

public class Quiz {
    Quiz(TaskGenerator generator, int taskCount) {

    }

//    Task NextTask() {
//
//        return;
//    }

    Result ProvideAnswer(String answer) {
        return Result.OK;
    }

    boolean isFinished() {
        return true;
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
                (correctAnswerNumber + wrongAnswerNumber + incorrectInputNumber);
    }

    private int correctAnswerNumber;
    private int wrongAnswerNumber;
    private int incorrectInputNumber;
    private int taskCount;
}
