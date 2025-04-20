package multithreading;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class ParallelSum extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start, end;
    private static final int THRESHOLD = 5; // Base case threshold

    public ParallelSum(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }

        int mid = (start + end) / 2;

        ParallelSum leftTask = new ParallelSum(arr, start, mid);
        ParallelSum rightTask = new ParallelSum(arr, mid, end);

        leftTask.fork(); // Compute left half in parallel
        int rightResult = rightTask.compute(); // Compute right half in current thread
        int leftResult = leftTask.join(); // Get result from left half

        return leftResult + rightResult;
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();
        ParallelSum task = new ParallelSum(arr, 0, arr.length);
        int sum = pool.invoke(task);

        System.out.println("Sum: " + sum); // Output: Sum: 55
    }
}
