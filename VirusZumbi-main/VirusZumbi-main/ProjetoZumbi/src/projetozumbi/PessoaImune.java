package projetozumbi;

import java.util.Timer;
import java.util.TimerTask;

public class PessoaImune extends Pessoa{
    private Cura cura;

    public PessoaImune(int x, int y) {
        super(5,x, y);
        this.cura = cura;
        life=0;
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