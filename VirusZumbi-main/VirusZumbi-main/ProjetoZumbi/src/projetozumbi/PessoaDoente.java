package projetozumbi;

import java.util.Timer;
import java.util.TimerTask;

public class PessoaDoente extends Pessoa{
    private Virus virus;

    public PessoaDoente(int x, int y) {
        super(3,x,y);
        this.virus = virus;
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

