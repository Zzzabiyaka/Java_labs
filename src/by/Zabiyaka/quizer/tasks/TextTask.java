package by.Zabiyaka.quizer.tasks;

import by.Zabiyaka.quizer.Result;
import by.Zabiyaka.quizer.Task;



public class TextTask implements Task {
    private final String text;
    private final String answer;

    TextTask(String text, String answer) {
        this.text = text;
        this.answer = answer;
        if (this.answer == null || answer.isEmpty()) {
            throw new RuntimeException("TextTask answer can't be null");
        }
        if (this.text == null || text.isEmpty()) {
            throw new RuntimeException("TextTask answer can't be null");
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Result validate(String answer) {
        if (this.answer.equals(answer)) {
            return Result.OK;
        } else {
            return Result.WRONG_ANSWER;
        }
    }
}
