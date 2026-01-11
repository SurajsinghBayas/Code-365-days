
class cala extends Thread {
    table_print obj;

    cala(table_print obj) {
        this.obj = obj;

    }

}

class table_print {
    synchronized void print_table(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " X " + i + " = " + (n * i));

        }
    }

}

public class table {
    public static void main(String[] args) {
        table_print op = new table_print();
        cala t2 = new cala(op);
        t2.start();

    }
}
