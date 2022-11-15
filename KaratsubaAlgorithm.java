public class KaratsubaAlgorithm {
    public static int lengthOfNo(long number) {
        return (int) (Math.floor(Math.log10(Math.abs(number))) + 1);
    }

    public static long multiplySingleDigits(long a, long b) {
        return a * b;
    }

    public static double multiplications(long first_no, long second_no) {
        //find the lengths of the numbers
        int len_first_no = lengthOfNo(first_no);

        int len_second_no = lengthOfNo(second_no);


        // Base cases
        if (len_first_no == 0) return 0;
        if (len_first_no == 1) return multiplySingleDigits(first_no, second_no);

        //split the numbers into two
        long firstNoLeft = (long) (first_no / Math.pow(10, len_first_no / 2));
        long firstNoRight = (long) (first_no - firstNoLeft * Math.pow(10, len_first_no / 2));

        long secondNoLeft = (long) (second_no / Math.pow(10, len_second_no / 2));
        long secondNoRight = (long) (second_no - secondNoLeft * Math.pow(10, len_second_no / 2));

        //do the multiplication
        double P1 = multiplications(firstNoLeft, secondNoLeft);

        double P2 = multiplications(firstNoRight, secondNoRight);

        double P3 = multiplications((firstNoLeft + firstNoRight), (secondNoLeft + secondNoRight));

        return (P1 * Math.pow(10, len_first_no) + ((P3 - P2 - P1) * Math.pow(10, len_first_no / 2)) + P2);
    }

    public static void main(String[] args) {

        System.out.println(multiplications(1234, 4321));
    }
}
