import java.util.*;

 class BasicHeap {
    private List<Integer> heap = new ArrayList<>();
    public BasicHeap() {
        heap.add(0);
    }
    
    // INSERTION FUNCTION
    // This function inserts a value into the heap and maintains the heap property.
    public void insert(int value){
        heap.add(value);
        int index = heap.size() - 1;
        while(index>1){
            int parent = index/2;
            if(heap.get(parent)<heap.get(index)){
                int temp = heap.get(parent);
                heap.set(parent, heap.get(index));
                heap.set(index, temp);
                index = parent;
            }
            else {
                return;
            }
        }
    }

    // DELETION FUNCTION
    // This function deletes a value from the heap and maintains the heap property.
    public void delete(int value){
        int index = heap.indexOf(value);
        if(index ==-1){
            System.out.println("Value not found in the heap.");
            return;
        }
        int lastindex = heap.size()-1;
        heap.set(index,heap.get(lastindex));
        heap.remove(lastindex);
        while(index < heap.size()){
            int leftchild = 2*index;
            int rightchild = 2*index + 1;
            int largest = index;
            if(leftchild < heap.size() && heap.get(leftchild) > heap.get(largest)){
                largest = leftchild;
            }
            if(rightchild < heap.size() && heap.get(rightchild) > heap.get(largest)){
                largest = rightchild;
            }
            if(largest != index){
                int temp = heap.get(index);
                heap.set(index, heap.get(largest));
                heap.set(largest, temp);
                index = largest;
            } else {
                return;
            }

        }
    }

    // HEAPIFY FUNCTION
    // This function is used to maintain the heap property after insertion or deletion.
    public void heapify(int[] arr, int n, int index){
        int largest = index;
        int leftchild = 2 * index;
        int rightchild = 2 * index + 1;
        if(leftchild<n && arr[leftchild] > arr[largest]){
            largest = leftchild;
        }
        if(rightchild<n && arr[rightchild] > arr[largest]){
            largest = rightchild;
        }

        if(largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicHeap maxHeap = new BasicHeap();
        System.out.println("Choose the function:");
        System.out.println("1. Max-Heap (Insert/Delete)");
        System.out.println("2. Heapify");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the number of elements in the heap:");
                int n = scanner.nextInt();
                System.out.println("Enter the elements of the heap (space-separated):");
                for (int i = 0; i < n; i++) {
                    int value = scanner.nextInt();
                    maxHeap.insert(value);  
                }        

                System.out.println("Heap after insertions (Max-Heap): ");
                for (int i = 1; i < maxHeap.heap.size(); i++) {
                    System.out.print(maxHeap.heap.get(i) + " ");
                }


                int valueToDelete;
                System.out.println("\nEnter a value to delete from the heap:");
                valueToDelete = scanner.nextInt();
                maxHeap.delete(valueToDelete);

                System.out.println("Heap after deletion (Max-Heap): ");
                for (int i = 1; i < maxHeap.heap.size(); i++) {
                    System.out.print(maxHeap.heap.get(i) + " ");
                }
                break;
            case 2:
                // Heapify example
                System.out.println("\nEnter the number of elements to heapify:");
                int m = scanner.nextInt();
                int[] arr = new int[m + 1]; 
                System.out.println("Enter the elements to heapify (space-separated):");
                for (int i = 0; i < m; i++) {
                    arr[i] = scanner.nextInt();
                }
                for (int i = m / 2; i >= 1; i--) {
                    maxHeap.heapify(arr, m + 1, i);
                }
                System.out.println("Array after heapify:");
                for (int i = 1; i <= m; i++) {
                    System.out.print(arr[i] + " ");
                }
            default:
                break;
        }
        
        scanner.close();
    }
}
