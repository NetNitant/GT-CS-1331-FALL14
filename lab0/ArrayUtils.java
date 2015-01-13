public class ArrayUtils {
    public static int reverseProduct(int[] a, int[] b) {
        int length = a.length < b.length ? a.length : b.length;

        int sum = 0;

        for (int i = 0; i < length; i++) {
            int j = length - i - 1;

            sum += a[i] * b[j];
        }

        return sum;
    }
}
