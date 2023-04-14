package projetozumbi;

import java.util.Timer;
import java.util.TimerTask;

public class Zumbi extends Pessoa{
    private Cura cura;

    public Zumbi(int x, int y) {
        super(6,x, y);
        this.cura = cura;
        life=1;
        run ();
    }
    public void run (){
        Timer clock = new Timer();
        clock.schedule(new TimerTask() {
            @Override
            public void run(){
                life=0;
            }}, 30000);
    }
}
