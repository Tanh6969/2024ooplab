
import javax.swing.JOptionPane;

public class ShowtwoNumbers {

    public static void main(String arg[]) {
        String strNum1, strNum2;
        String strNotification = "You're just entered: ";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum;
        sum=num1+num2;

        double difference;
        difference= Math.abs(num1-num2);

        double product;
        product= num1*num2;

        double quotient;
        quotient= num1/num2;
        
        System.out.println(sum);
        System.out.println(difference);
        System.out.println(product);
        System.out.println(quotient);
    }
}
