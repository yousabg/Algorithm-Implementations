import java.math.BigInteger;

public class QuestionThreeAndFour {
    public static void main(String[] args) {
        BigInteger[] notFib = notFibbonacci(12);

        System.out.print(notFib[0]);
        for (int i = 1; i < notFib.length; i++) {
            System.out.print(", " + notFib[i]);
        }
        System.out.println("\n" + closestInNotFibSequence(new BigInteger("5740")));

    }
    public static BigInteger[] notFibbonacci(int n) {
        BigInteger[] notFibArray = new BigInteger[n];
        notFibArray[0] = BigInteger.valueOf(0);
        if (n == 1) {
            return notFibArray;
        } else if (n == 2) {
            notFibArray[1] = BigInteger.valueOf(1);
            return notFibArray;
        }
        notFibArray[1] = BigInteger.valueOf(1);

        for (int i = 2; i < n; i++) {
            BigInteger two = BigInteger.valueOf(2);
            notFibArray[i] = (notFibArray[i-1].multiply(two)).add(notFibArray[i-2]);
        }

        return notFibArray;
    }

    public static int closestInNotFibSequence(BigInteger i) {
        boolean done = false;
        int count = 1;
        BigInteger zero = BigInteger.valueOf(0);
        BigInteger difference = zero;
        while (!done) {
            BigInteger[] notFib = notFibbonacci(count);
            BigInteger prevDiff = difference;
            difference = notFib[count-1].subtract(i);
            if (difference.compareTo(zero) == 0) {
                return count-1;
            } else if (difference.compareTo(zero) == 1) {
                prevDiff = prevDiff.multiply(BigInteger.valueOf(-1));
                if (difference.compareTo(prevDiff) == 1) {
                    return count-2;
                } else {
                    return count-1;
                }
            }


            count++;
        }
        return 0;
    }
}
