import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Subsequences {
    // Function to generate all subsequences of a string
    public void generateseq(int index,int[] arr,int n, List<Integer> ds, List<List<Integer>> result) {
        if(index == n) {
            if(!ds.isEmpty()) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        ds.add(arr[index]);
        generateseq(index + 1, arr, n, ds, result);
        ds.remove(ds.size() - 1);
        generateseq(index + 1, arr, n, ds, result);

    }
    public List<List<Integer>> generatesequence(int[] arr){
        int n=arr.length;
        List<List<Integer>> result = new ArrayList<>();
        generateseq(0,arr,n, new ArrayList<>(), result);
        return result;
    }

    // Case 2: Function to generate subsequences with a specific sum
    public List<List<Integer>> subsequenceWithSumK(int [] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        findSubsequenceswithSum(0, arr,n, k, new ArrayList<>(), result);
        return result;
    }

    public void findSubsequenceswithSum(int index,int[] arr,int n, int k, List<Integer> ds, List<List<Integer>> result){
        if(index == n){
            if(k==0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        ds.add(arr[index]);
        findSubsequenceswithSum(index + 1, arr, n, k - arr[index], ds, result);
        ds.remove(ds.size() - 1);
        findSubsequenceswithSum(index + 1, arr, n, k, ds, result);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Subsequences subsequences = new Subsequences();
        System.out.println("Enter number of elements in array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Choose an option:");
        System.out.println("1. Generate all Subsequences");
        System.out.println("2. Generate subsequence with sum as k");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                List<List<Integer>> result = subsequences.generatesequence(arr);
                System.out.println("All subsequences are:");
                for(List<Integer> seq : result) {
                    System.out.println(seq);
                }
                break;
            case 2:
                System.out.println("Enter the sum k:");
                int k = sc.nextInt();
                List<List<Integer>> subsequencesWithSumK = subsequences.subsequenceWithSumK(arr, k);
                System.out.println("Subsequences with sum '" + k + "' are:");
                for(List<Integer> seq : subsequencesWithSumK) {
                    System.out.println(seq);
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        sc.close();
    }
}
