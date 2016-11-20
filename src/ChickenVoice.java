/**
 * Created by dmitry.arefyev on 25.10.2016.
 */

class EggVoice extends Thread {
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {

            }

            System.out.println("Яйцо!");
        }
    }
}


public class ChickenVoice {
    static EggVoice mAnotherOpinion;

    public static void main(String[] args) {
        mAnotherOpinion = new EggVoice();
        System.out.println("Спор начат!");
        mAnotherOpinion.start();

        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {

            }

            System.out.println("Курица!");
        }

        if (mAnotherOpinion.isAlive()) {
            //Если поток еще не отработал
            try {
                mAnotherOpinion.join(); //Ожидаем оконцания
            }
            catch (InterruptedException e) {

            }

            System.out.println("Первым появилось яйцо!");
        }
        else {
            //Если поток отработал
            System.out.println("Первой появилась курица!");
        }

        System.out.println("Спор окончен!");
    }
}
