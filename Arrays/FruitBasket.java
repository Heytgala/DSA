import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitBasket {

    public int maxfruitsarray(int[] fruits) {
        int l = 0;
        int maxFruits = 0;

        Map<Integer, Integer> fruitCount = new HashMap<>();

        for (int r = 0; r < fruits.length; r++) {
            fruitCount.put(fruits[r], fruitCount.getOrDefault(fruits[r], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[l], fruitCount.get(fruits[l]) - 1);
                if (fruitCount.get(fruits[l]) == 0) {
                    fruitCount.remove(fruits[l]);
                }
                l++;
            }

            maxFruits = Math.max(maxFruits, r - l + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of fruits: ");
        int n = scanner.nextInt();
        int[] fruits = new int[n];
        System.out.println("Enter the sizes of the fruits:");
        for (int i = 0; i < n; i++) {
            fruits[i] = scanner.nextInt();  
        }
        FruitBasket fb = new FruitBasket();
        long result = fb.maxfruitsarray(fruits);
        System.out.println("Maximum number of fruits that can be collected: " + result);
        scanner.close();
    }
}
