import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadGenerator {
    private int numThreads;
    private String operation;
    private int start;
    private int end;
    private List<CalculatorThread> threads;

    public ThreadGenerator() {
        threads = new ArrayList<>();
        getUserInput();
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of threads: ");
        numThreads = scanner.nextInt();

        System.out.print("Enter the operation (multiply): ");
        operation = scanner.next();

        System.out.print("Enter the start of the range: ");
        start = scanner.nextInt();

        System.out.print("Enter the end of the range: ");
        end = scanner.nextInt();
    }

    public void execute() {
        int range = (end - start + 1) / numThreads;
        int currentStart = start;

        for (int i = 0; i < numThreads; i++) {
            int currentEnd = currentStart + range - 1;
            CalculatorThread thread = new CalculatorThread(currentStart, currentEnd, operation);
            threads.add(thread);
            currentStart = currentEnd + 1;
        }

        for (CalculatorThread thread : threads) {
            thread.start();
        }

        try {
            for (CalculatorThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getResult() {
        long finalResult = 1;

        switch (operation) {
            case "multiply":
                finalResult = multiplyResults();
                break;
        }

        return finalResult;
    }

    private long multiplyResults() {
        long product = 1;
        for (CalculatorThread thread : threads) {
            product *= thread.getResult();
        }
        return product;
    }

    public static void main(String[] args) {
        ThreadGenerator threadGenerator = new ThreadGenerator();
        threadGenerator.execute();

        long result = threadGenerator.getResult();
        System.out.println("Result: " + result);
    }
}
