package by.Zabiyaka.quizer;

import by.Zabiyaka.quizer.task_generators.EquationTaskGenerator;
import by.Zabiyaka.quizer.task_generators.ExpressionTaskGenerator;
import by.Zabiyaka.quizer.task_generators.GroupTaskGenerator;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestController {
    public TestController() {
        System.out.println("Please, enter the test name...");
        tests.put("1", new Quiz(new ExpressionTaskGenerator(0, 100, EnumSet.allOf(Operation.class)), 10));
        tests.put("2", new Quiz(new EquationTaskGenerator(0, 100, EnumSet.allOf(Operation.class)), 10));
    tests.put("3", new Quiz(new GroupTaskGenerator(
            new ExpressionTaskGenerator(0, 10, EnumSet.allOf(Operation.class)),
        new EquationTaskGenerator(0, 10, EnumSet.allOf(Operation.class))), 10));


        EnumSet.of(Operation.ADD, Operation.SUB);
        String testName = scanner.next();
        if (tests.containsKey(testName)) {
            Start(tests.get(testName));
        } else {
            System.out.println("Sorry, it seems that test with this name doesn't exist.\n " + "" +
                    "Please try again");

        }
    }

    static void Start(Quiz quiz) {
        while (!quiz.isFinished()) {
            System.out.println(quiz.NextTask().getText());
            String answer = scanner.next();
            System.out.println(quiz.ProvideAnswer(answer));
        }

        System.out.println("Your mark is \n" + quiz.getMark());
    }

    static String[] GetAllTests() {
        return tests.keySet().toArray(new String[0]);
    }


    private static HashMap<String, Quiz> tests = new HashMap<>();
    private final static Scanner scanner = new Scanner(System.in);
}
