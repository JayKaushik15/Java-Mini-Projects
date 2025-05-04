import java.util.Scanner;

public class QuizGame {
    static String userAnswer = "";
    static boolean answered = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. Who was the first President of India?",
            "2. Which river is the longest in India?",
            "3. In which year did India get independence?",
            "4. What is the capital of Australia?",
            "5. Who is the current Prime Minister of India (as of 2024)?"
        };

        String[][] options = {
            {"a) Dr. Rajendra Prasad", "b) Jawaharlal Nehru", "c) B. R. Ambedkar", "d) Mahatma Gandhi"},
            {"a) Yamuna", "b) Brahmaputra", "c) Ganga", "d) Godavari"},
            {"a) 1945", "b) 1947", "c) 1950", "d) 1952"},
            {"a) Sydney", "b) Canberra", "c) Melbourne", "d) Brisbane"},
            {"a) Rahul Gandhi", "b) Narendra Modi", "c) Amit Shah", "d) Arvind Kejriwal"}
        };

        char[] answers = {'a', 'c', 'b', 'b', 'b'};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            userAnswer = "";
            answered = false;

            System.out.println("\n" + questions[i]);
            for (String opt : options[i]) {
                System.out.println(opt);
            }

            Thread inputThread = new Thread(() -> {
                Scanner in = new Scanner(System.in);
                userAnswer = in.nextLine().toLowerCase();
                answered = true;
            });

            inputThread.start();

            System.out.println("You have 10 seconds to answer...");

            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Timer error.");
                }

                if (answered) break;
            }

            if (!answered) {
                System.out.println("Time's up! Moving to next question.");
            } else if (userAnswer.length() > 0 && userAnswer.charAt(0) == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\nQuiz Over!");
        System.out.println("Final Score: " + score + "/" + questions.length);
    }
}
