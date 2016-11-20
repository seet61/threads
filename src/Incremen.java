/**
 * Created by dmitry.arefyev on 25.10.2016.
 */

class Incrementator extends Thread {
    private volatile boolean mIsIncrement = true;
    //private volatile boolean mFinish = false;

    public void changeAction() {
        //Меняет действие на противоположное
        mIsIncrement = !mIsIncrement;
    }

    /*
    public void finish() {
        //Инициируем завершение потока
        mFinish =  true;
    }
    */

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                //Проверка необходимости завершениея
                if (mIsIncrement) {
                    Incremen.mValue++;
                }
                else {
                    Incremen.mValue--;
                }

                System.out.print(Incremen.mValue + " ");
            }
            else
                return; //Завершение потока

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                return; //Завершение потока после прерывания
            }
        }
        while(true);
    }
}

public class Incremen {
    public static int mValue = 0;
    static Incrementator mInc;

    public static void main(String[] args) {
        mInc = new Incrementator();
        System.out.print("Значение = ");
        mInc.start();

        //Ждем трекратного действия и выключаем
        for (int i=1; i<=3; i++) {
            try {
                Thread.sleep(i*2*1000);
            }
            catch (InterruptedException e) {}

            mInc.changeAction();
        }

        mInc.interrupt();
    }
}
