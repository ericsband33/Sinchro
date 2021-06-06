//класс инициализации потоков

public class Potok implements Runnable {
    String name;
    Thread t;
    Def_meth def;
    // индикатор приоритета
    int p;
    Potok(String name, Def_meth def, int p){
        this.def = def;
        this.name = name;
        this.p = p;
        t = new Thread(this);
        t.setPriority(p);
        //t.start();
    }
    public void run(){
         def.out(name);
         def.u = false;
        }

}

