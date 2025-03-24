import java.util.Scanner;
public class displayDaysinaMonths{
    public static int checkingMonth(String month) {
    switch (month) {
        case "January":
        case "Jan.":
        case "Jan":
        case "1":
            return 1;
        case "February":
        case "Feb.":
        case "Feb":
        case "2":
            return 2;
        case "March":
        case "Mar.":
        case "Mar":
        case "3":
            return 3;
        case "April":
        case "Apr.":
        case "Apr":
        case "4":
            return 4;
        case "May":
        case "5":
            return 5;
        case "June":
        case "Jun.":
        case "Jun":
        case "6":
            return 6;
        case "July":
        case "Jul.":
        case "Jul":
        case "7":
            return 7;
        case "August":
        case "Aug.":
        case "Aug":
        case "8":
            return 8;
        case "September":
        case "Sept.":
        case "Sep":
        case "9":
            return 9;
        case "October":
        case "Oct.":
        case "Oct":
        case "10":
            return 10;
        case "November":
        case "Nov.":
        case "Nov":
        case "11":
            return 11;
        case "December":
        case "Dec.":
        case "Dec":
        case "12":
            return 12;
        default:
            return -1; // Invalid month
    }
}

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter month-year: ");
        String mystr = keyboard.nextLine();
        String[] mystrs = mystr.split("-");
        int year = Integer.parseInt(mystrs[1]);
        boolean leap = false;
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    leap = true;
                }
            }
            else{
                leap = true;
            }
        }
        int checkMonth = checkingMonth(mystrs[0]);
        if(checkMonth == -1){
            System.out.println("Invalid month");
        }
        else{
            switch(checkMonth){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("31 days");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("30 days");
                    break;
                case 2:
                    if(leap){
                        System.out.println("29 days");
                    }
                    else{
                        System.out.println("28 days");
                    }
                    break;
            }
        }
        System.exit(0);
    }
}