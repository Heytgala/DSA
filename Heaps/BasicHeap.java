import java.util.*;

 class BasicHeap {
    private List<Integer> heap = new ArrayList<>();
    public BasicHeap() {
        heap.add(0);
    }
    

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicHeap maxHeap = new BasicHeap();
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

        scanner.close();
    }
}
