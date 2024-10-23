import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threads extends Thread{
        private final Compte cpt;
        private String operationType;
        private float amount;
        private final Lock lock = new ReentrantLock();
        public Threads(Compte cpt, String operationType, float amount){
            this.cpt = cpt;
            this.operationType = operationType;
            this.amount = amount;
        }
        @Override
        public void run() {
            lock.lock();
                try {
                    if(operationType.equals("deposit")){
                        cpt.deposit(amount);
                    } else if (operationType.equals("withdraw")){
                        cpt.withdraw(amount);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
        }
}
