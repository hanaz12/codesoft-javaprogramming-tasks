import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Questions
        String questions[] = {
                "1- What does RAM stand for?\nA) Random Access Memory\nB) Read Access Memory\nC) Run All Memory\nD) Random Allocation Memory",
                "2- What does URL stand for?\nA) Uniform Resource Locator\nB) Universal Resource Locator\nC) Uniform Reference Link\nD) Universal Reference Link",
                "3- What does HTTP stand for?\nA) HyperText Transfer Protocol\nB) HyperText Transmission Protocol\nC) HighText Transfer Program\nD) Hyper Transfer Text Protocol",
                "4- What does USB stand for?\nA) Universal Serial Bus\nB) Uniform Serial Bus\nC) Universal System Bus\nD) Uniform System Bus",
                "5- What does GPS stand for?\nA) Global Positioning System\nB) General Positioning System\nC) Global Program System\nD) General Program System"
        };
        String answers[] = {"a", "a", "a", "a", "a"};
        int trueAnswers = 0, limit = 10;
        
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("You have " + limit + " seconds to answer the question");

            Future<String> future = executor.submit(() -> input.nextLine());

            try {

                String userAnswer = future.get(limit, TimeUnit.SECONDS);
                if (userAnswer.equalsIgnoreCase(answers[i])) {
                    trueAnswers++;
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Wrong! The correct answer is: " + answers[i] + "\n");
                }
            } catch (TimeoutException e) {
                future.cancel(true);
                System.out.println("Oops! Time has left.\n");
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }

        executor.shutdown();
        System.out.println("Quiz Over! You got " + trueAnswers + " correct answers out of "+questions.length+" questions.");
    }
}
