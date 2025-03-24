import javax.swing.JOptionPane;
public class choosingOption{
    public static void main(String[] args) {
    int option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket ?","Choose your option:" ,JOptionPane.YES_NO_OPTION);
    String message = "You've chosen: "+ (option == JOptionPane.YES_NO_OPTION ? "Yes" : "No");
    JOptionPane.showMessageDialog(null, message);
    System.exit(0);
    }
}