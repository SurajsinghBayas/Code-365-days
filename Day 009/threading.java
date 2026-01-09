/*  Step 1 : import java.lang.*;
 *  Step 2 : A) by Extending Thread class
 *          B) by Implementing Runnable Interface
 *  Step 3 : initiate the run() method
 *  Step 4 : Give public access specifier to run() method
 *  Step 5 :  Implement the run() method
 *  Step 6 : Create the Thread Object and start() the thread
 * 
*/

//import java.lang.*;
class demo extends Thread {
    public void run() {
        try {
            for (int i = 0; i <= 3; i++) {
                System.out.println("Hi");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

// Interface example
interface client {
    void display();

}

class test implements client {
    public void display() {
        System.out.println("Hello");
    }
}

public class threading {
    public static void main(String[] args) throws InterruptedException

    {
        demo obj = new demo();
        obj.start();
    }
}
