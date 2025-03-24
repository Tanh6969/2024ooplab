import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập kích thước của ma trận
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = scanner.nextInt();
        
        // Khai báo và nhập ma trận đầu tiên
        int[][] matrix1 = new int[rows][cols];
        System.out.println("Nhập các phần tử cho ma trận thứ nhất:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Nhập phần tử [%d][%d]: ", i, j);
                matrix1[i][j] = scanner.nextInt();
            }
        }
        
        // Khai báo và nhập ma trận thứ hai
        int[][] matrix2 = new int[rows][cols];
        System.out.println("Nhập các phần tử cho ma trận thứ hai:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Nhập phần tử [%d][%d]: ", i, j);
                matrix2[i][j] = scanner.nextInt();
            }
        }
        
        // Tính tổng của hai ma trận
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        // In ma trận tổng
        System.out.println("Tổng của hai ma trận là:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}