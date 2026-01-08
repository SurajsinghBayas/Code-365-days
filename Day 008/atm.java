import java.util.*;
import java.io.*;

class account {
    private int pn;
    private int CN;

    void setCustomerNumber(int cn) {
        CN = cn;
    }

    void setPinNumber(int pn) {
        this.pn = pn;
    }

    int getCustomerNumeber() {
        return CN;
    }

    int getPinNumber() {
        return pn;
    }
}

class option_menu extends account {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Integer> hm = new HashMap<>();

    void getlogin() {

        try {
            hm.put(11111, 111);
            hm.put(11112, 222);
            hm.put(11113, 333);
            hm.put(11114, 444);
            hm.put(11115, 111);
            System.out.println("Welcome to my ATM");
            System.out.println("Enter Customer Number");
            setCustomerNumber(sc.nextInt());
            System.out.println("Enter Pin Number");
            setPinNumber(sc.nextInt());
            int p = getCustomerNumeber();
            int q = getPinNumber();
            if (hm.containsKey(p) && hm.get(p) == q) {
                System.out.println("Login Successful");
                getAccountType();
            } else {
                System.out.println("Incorrect Customer Number or Pin Number");
                getlogin();
            }

        }

        catch (Exception g) {
            System.err.println("\nEnter Only Numbers");
            System.err.println("\nCaracters and Special Symbols are not allowed");
        }
    }

    void getAccountType() {
        System.out.println("Select The Account Type");
        System.out.println("Choice : 1.Current Account 2.Saving Account 3.Exit");
        int choice = sc.nextInt();
    }
}

public class atm extends account {
    public static void main(String[] args) {
        option_menu op = new option_menu();
        op.getlogin();

    }
}
