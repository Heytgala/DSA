import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubsetSums {
    public void findSubsetSums(int[] arr, int n, int index, int currentSum, List<Integer> result) {
        if (index == n) {
            result.add(currentSum);
            return;
        }
        // Pick
        findSubsetSums(arr, n, index + 1, currentSum + arr[index], result);
        // Not Pick
        findSubsetSums(arr, n, index + 1, currentSum, result);
    }

    public List<Integer> subsetsum(int[] arr, int n) {
        List<Integer> result = new ArrayList<>();
        findSubsetSums(arr, n, 0, 0, result);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        SubsetSums ss = new SubsetSums();

        List<Integer> result = ss.subsetsum(arr, n);

        System.out.println("Subset sums in increasing order:");
        for(int sum : result) {
            System.out.print(sum + " , ");
        }

        scanner.close();
    }
}
