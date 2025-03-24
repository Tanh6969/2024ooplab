import java.util.Scanner;

public class GiaiPhuongTrinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Chọn loại phương trình cần giải:");
        System.out.println("1. Phương trình bậc nhất ");
        System.out.println("2. Phương trình bậc hai ");
        System.out.println("3. He phuong trinh hai ẩn ");
        System.out.print("Nhập lựa chọn (1,2,3): ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                giaiPhuongTrinhBacNhat(scanner);
                break;
            case 2:
                giaiPhuongTrinhBacHai(scanner);
                break;
            case 3:
                giaiHephuongtrinh(scanner);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
        
        scanner.close();
    }
    
    public static void giaiPhuongTrinhBacNhat(Scanner scanner) {
        System.out.println("\nGiải phương trình bậc nhất: ax + b = 0");
        System.out.print("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập b: ");
        double b = scanner.nextDouble();
        
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        } else {
            double x = -b / a;
            System.out.printf("Nghiệm của phương trình: x = %.2f%n", x);
        }
    }
    
    public static void giaiPhuongTrinhBacHai(Scanner scanner) {
        System.out.println("\nGiải phương trình bậc hai: ax² + bx + c = 0");
        System.out.print("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập c: ");
        double c = scanner.nextDouble();
        
        if (a == 0) {
            System.out.println("Đây không phải phương trình bậc hai!");
            System.out.println("Giải như phương trình bậc nhất: bx + c = 0");
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình có vô số nghiệm");
                } else {
                    System.out.println("Phương trình vô nghiệm");
                }
            } else {
                double x = -c / b;
                System.out.printf("Nghiệm: x = %.2f%n", x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.printf("Phương trình có 2 nghiệm phân biệt:%n");
                System.out.printf("x1 = %.2f%n", x1);
                System.out.printf("x2 = %.2f%n", x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.printf("Phương trình có nghiệm kép: x = %.2f%n", x);
            } else {
                System.out.println("Phương trình vô nghiệm trong tập số thực");
            }
        }
    }
    public static void giaiHephuongtrinh(Scanner scanner)
    {
        
        
        System.out.println("Giải hệ phương trình bậc nhất:");
        System.out.println("a11x1 + a12x2 = b1");
        System.out.println("a21x1 + a22x2 = b2");
        
        System.out.print("Nhập a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Nhập a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Nhập b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Nhập a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Nhập a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Nhập b2: ");
        double b2 = scanner.nextDouble();
        
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        
        System.out.println("\nPhân tích nghiệm:");
        switch (D == 0 ? 0 : 1) { // 0 nếu D = 0, 1 nếu D ≠ 0
            case 0:
                if (D1 == 0 && D2 == 0) {
                    System.out.println("Hệ phương trình có vô số nghiệm.");
                } else {
                    System.out.println("Hệ phương trình vô nghiệm.");
                }
                break;
                
            case 1: 
                double x1 = D1 / D;
                double x2 = D2 / D;
                System.out.printf("Hệ phương trình có nghiệm duy nhất:%n");
                System.out.printf("x1 = %.2f%n", x1);
                System.out.printf("x2 = %.2f%n", x2);
                break;
                
            default:
                System.out.println("Lỗi trong tính toán!");
        }
        
        
    

    }
}