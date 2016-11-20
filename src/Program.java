/**
 * Created by dmitry.arefyev on 25.10.2016.
 */

class SomeThing //наш класс с логикой
implements Runnable { //содержит метов run()
    int i;

    public SomeThing(int i) {
        this.i = i;
    }

    public void run() {
        System.out.println("Привет из дочернего потока" + this.i);
    }
}

public class Program {
    //основная программа
    static SomeThing mThing; //объект класса с интерфейсом

    public static void main(String[] args) {
        for (int i=0; i < 10; i++) {
            mThing = new SomeThing(i);

            Thread myThready = new Thread(mThing);
            myThready.start();
        }

        System.out.println("Главный поток завершен...");
    }
}
