interface IFila {
    boolean insere(int i);

    int remove();

    void imprime();
}

class Heap implements IFila {
    private int[] v;
    private int n;

    public Heap(int[] vinicial, int tamMax) {
        v = new int[tamMax];
        n = vinicial.length;
        System.arraycopy(vinicial, 0, v, 0, vinicial.length);
        for (int i = ultimoPai(); i >= 0; i--) {
            sift(i);
        }
    }

    public Heap(int tamMax) {
        v = new int[tamMax];
        n = 0;
    }

    private int fe(int idx) {
        return 2 * idx + 1;
    }

    private int fd(int idx) {
        return 2 * idx + 2;
    }

    private int pai(int idx) {
        return (idx - 1) / 2;
    }

    private int ultimoPai() {
        return pai(n - 1);
    }

    private void sift(int idx) {
        if (idx > ultimoPai() || n == 1) {
            return;
        }

        int idxMaiorFilho = fe(idx);
        if (fd(idx) < n && v[fd(idx)] > v[idxMaiorFilho])
            idxMaiorFilho = fd(idx);

        if (v[idxMaiorFilho] > v[idx]) {
            int temp = v[idxMaiorFilho];
            v[idxMaiorFilho] = v[idx];
            v[idx] = temp;
            sift(idxMaiorFilho);
        }
    }

    @Override
    public boolean insere(int i) {
      int novoInd = v[n];
     
      if(n != v.length){
        v[n] = i;
        n++;
        if(n != 1){
          if(v[pai(novoInd)] < v[novoInd]){
            sift(0);
          }
        }
      }
        return true;
    }

    @Override
    public int remove() {
      int temp = v[0];
      v[0] = v[n - 1];
      v[n - 1] = temp;
      n--;
      
      sift(0);
      return v[n];
      
      
    }

    @Override
    public void imprime() {
        for (int i = 0; i < n; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }
}


public class main {
    public static void main(String[] args) {
        int[] v = {6, 4, 7, 8, 43, 6, 90, 56, 99};
        Heap h = new Heap(v, 30);
        h.imprime();
        for (int i = 0; i < v.length; i++) {
            System.out.println("Remove: " + h.remove());
            h.imprime();
        }
        int[] ins = {2, 5, 7, 2, 1};
        for (int i : ins) {
            System.out.println("inserindo " + i);
            h.insere(i);
        }
        h.imprime();

        for (int i = 0; i < ins.length; i++) {
            System.out.println("Remove: " + h.remove());
        }
        h.imprime();

    }
}
