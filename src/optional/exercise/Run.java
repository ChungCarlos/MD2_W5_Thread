package optional.exercise;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        // LazyPrimeFactorization...
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
        lazyPrimeFactorization.start();

        // OptimizedPrimeFactorization...
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread thread = new Thread(optimizedPrimeFactorization);
        thread.start();
    }
}

class LazyPrimeFactorization extends Thread {
    public boolean Check(int n) {

        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("Số nguyên tố:");
        int i = 0;
        int count = 0;
        while (count < 30) {
            if (Check(i) == true) {
                System.out.println("A " + i);
                count++;
            }
            i++;
        }
    }
}

class OptimizedPrimeFactorization implements Runnable {
    public boolean Check(int n) {

        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("SNT:");
        int i = 0;
        int count = 0;
        while (count < 20) {
            if (Check(i) == true) {
                System.out.println("B " + i);
                count++;
            }
            i++;
        }
    }
}