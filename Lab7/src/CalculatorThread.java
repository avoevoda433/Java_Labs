public class CalculatorThread extends Thread {
    private int start;
    private int end;
    private long result;
    private String operation;

    public CalculatorThread(int start, int end, String operation) {
        this.start = start;
        this.end = end;
        this.operation = operation;
    }

    public long getResult() {
        return result;
    }

    @Override
    public void run() {
        switch (operation) {
            case "multiply":
                result = multiplyOperation();
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    private long multiplyOperation() {
        long product = 1;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                product *= i;
            }
        }
        return product;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
