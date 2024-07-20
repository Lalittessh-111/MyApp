package QuizApplication;

import java.util.Scanner;

public class QuizApp {
    private Question[] questions;
    private int score;
    private Scanner scanner;

    public QuizApp(Question[] questions) {
        this.questions = questions;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            QuizTimer timer = new QuizTimer(10); // 10 seconds for each question
            timer.start();

            int userAnswer = getUserAnswer();

            if (timer.isTimeUp()) {
                System.out.println("Time's up!");
            } else {
                if (question.isCorrect(userAnswer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            }

            System.out.println();
        }

        displayResults();
    }

    private int getUserAnswer() {
        int answer = -1;
        while (answer < 1 || answer > 4) {
            System.out.print("Enter your answer (1-4): ");
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
            } else {
                scanner.next(); // clear the invalid input
            }
        }
        return answer;
    }

    private void displayResults() {
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }

    public static void main(String[] args) {
        Question[] questions = new Question[]{
                new Question("What does 'HTTP' stand for?", new String[]{"HyperText Transfer Protocol", "HighText Transfer Protocol", "HyperTransfer Text Protocol", "HighTransfer Text Protocol"}, 1),
                new Question("Who is considered the father of the computer?", new String[]{"Charles Babbage", "Alan Turing", "John von Neumann", "Bill Gates"}, 1),
                new Question("What programming language is primarily used for developing Android apps?", new String[]{"Java", "Python", "Swift", "Kotlin"}, 1),
                new Question("What does 'SQL' stand for?", new String[]{"Structured Query Language", "Standard Query Language", "Simple Query Language", "Sequential Query Language"}, 1)
        };

        QuizApp quiz = new QuizApp(questions);
        quiz.startQuiz();
    }
}
