// потоки одновременно начинают выводить цифры 01234
// потом синхронизировать метод

import javax.swing.table.TableRowSorter;

public class Sinchro {
    public static void main(String[] args) {
        int p; //индикатор приоритета
        Thread mt = Thread.currentThread();
        Def_meth def = new Def_meth();
        Potok ob1 = new Potok("Ob1", def, 10);
        Potok ob2 = new Potok("Ob2", def, 10);
        Potok ob3 = new Potok("Ob3", def, 2);
        Potok ob4 = new Potok("Ob4", def, 1);
        ob1.t.start();
        while (ob1.t.isAlive()){
            try {
                mt.sleep(1);
            }catch (InterruptedException e){e.printStackTrace();}
        }
        ob2.t.start();
        while (ob2.t.isAlive()){
            try {
                mt.sleep(1);
            }catch (InterruptedException e){e.printStackTrace();}
        }
        ob3.t.start();
        ob4.t.start();


             try{
                ob1.t.join();
                ob2.t.join();
                ob3.t.join();
                ob4.t.join();
            }catch (InterruptedException e){
                e.getStackTrace();
            }finally {
                System.out.println();
                System.out.println("Programm is closed.");
            }

    }
}
