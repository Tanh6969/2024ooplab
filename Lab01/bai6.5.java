import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAverage {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();
        
        
        int[] myArray = new int[size];
        
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            myArray[i] = scanner.nextInt();
        }
        
        
        System.out.println("Mảng ban đầu: " + Arrays.toString(myArray));
        
        Arrays.sort(myArray);
        
        
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(myArray));
        
        
        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        
        double average = (double) sum / myArray.length;
        
        
        System.out.println("Tổng của các phần tử: " + sum);
        System.out.println("Giá trị trung bình: " + average);
        

        scanner.close();
    }
}