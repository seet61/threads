/**
 * Created by dmitry.arefyev on 25.10.2016.
 */
class AffableThread extends Thread {
    @Override
    public void run() {
        System.out.println("Привет из побочного потока!!!");
    }
}

public class Potomoc {
    static AffableThread mSecondThread;

    public static void main(String[] args) {
        mSecondThread = new AffableThread(); //создание потока
        mSecondThread.start();

        System.out.println("Главный поток завершен.");

    }

}
