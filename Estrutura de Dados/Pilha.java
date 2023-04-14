class No{
    //Não alterar essa classe
    public int valor;
    public No proximo;

    public No(int valor){
        this.valor = valor;
        this.proximo = null;
        System.out.println("No " + valor + " criado");
    }
}
interface IPilha{
    boolean insere(int valor);
    int remove();
    void imprime();
}

class PilhaEncadeada implements IPilha{
    private No topo;

    public PilhaEncadeada(){
        topo = null;
    }

    @Override
    public boolean insere(int valor) {
      No x = new No(valor);
      x.proximo = topo;
      topo = x;
      
        return true;
    }

    @Override
    public int remove() {
      if(topo != null){
        int n = topo.valor;
        topo = topo.proximo;
        return n;
      }
        return 0;
    }

    @Override
    public void imprime() {
        No c = topo;
        while(c != null){
            System.out.println(c);
            c = c.proximo;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        IPilha p = new PilhaEncadeada();
        p.insere(10);
        p.insere(30);
        p.insere(20);
        p.insere(1);
        System.out.println(p.remove());
        System.out.println(p.remove());
        p.insere(99);
        System.out.println(p.remove());
        System.out.println(p.remove());
        System.out.println(p.remove());
    }
}

