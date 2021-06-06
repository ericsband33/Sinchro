import java.util.Arrays;

// дефолтный метод, который будут использовать классы с потоками
// Этот метод будем синхронизировать
//Default Method
public class Def_meth {
    boolean u = false;
    synchronized public void out(String name){

            while (u) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        for(int x = 0; x<5; x++) {
            System.out.print(x +" ");
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                System.out.println("ERROR " + Arrays.toString(e.getStackTrace()));
            }
        }
        System.out.println();
        System.out.println("Отсчет " + name + " завершен.");
        notify();
    }
}
