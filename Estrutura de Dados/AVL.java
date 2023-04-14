/**
 * @author      : lopespt (lopespt@$HOSTNAME)
 * @file        : main
 * @created     : quinta out 21, 2021 08:54:56 -03
 */

class No {
    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
        this.pai = null;
    }
    public int valor;
    public No esq;
    public No dir;
    public No pai;
}

interface ArvBin {
    boolean insere(int valor);
    boolean remove(int valor);
    boolean busca(int valor);
}

class ArvBinBusca implements ArvBin {
    public No raiz = null;
    private int n = 0;
    private void imprimeErd(No a) {
        if(a != null) {
            imprimeErd(a.esq);
            System.out.print(a.valor + "("+ altura(a) +")  ");
            imprimeErd(a.dir);
        }
    }
    private void imprimeEdr(No a) {
        if(a != null) {
            imprimeEdr(a.esq);
            imprimeEdr(a.dir);
            System.out.print(a.valor + "("+ altura(a) +")  ");
        }
    }
    private void LeftRotate(No x) {
        No y = x.dir;
        No b = y.esq;
        No pai = x.pai;
        y.esq = x;
        x.pai = y;
        x.dir = b;
        if(b != null) b.pai = x;
        if(pai == null) {
            raiz = y;
            y.pai = null;
        }
        else {
            y.pai = pai;
            if(pai.esq == x) pai.esq = y;
            else pai.dir = y;
        }
        System.out.println("Left em "+x.valor); //Não apagar essa linha


    }
    private void RightRotate(No x) {
        No y = x.esq;
        No b = y.dir;
        No pai = x.pai;
        y.dir = x;
        x.pai = y;
        x.esq = b;
        if(b != null) b.pai = x;
        if(pai == null) {
            raiz = y;
            y.pai = null;
        }
        else {
            y.pai = pai;
            if(pai.esq == x) pai.esq = y;
            else pai.dir = y;
        }



        System.out.println("Right em "+x.valor);


    }

    private int altura(No x) {
        if (x==null)
            return -1;
        return Math.max(altura(x.esq), altura(x.dir))+1;
    }

    private int fatorBalanceamento(No x) {
        return altura(x.dir) - altura(x.esq);
    }

    public boolean insere(int valor) {
        No novo = new No(valor);

        No anterior = null;
        No atual = raiz;

        while(atual != null) {
            anterior = atual;
            if (valor <= atual.valor)
                atual = atual.esq;
            else
                atual = atual.dir;
        }

        novo.pai = anterior;
        if (anterior != null) {
            if (valor <= anterior.valor) {
                anterior.esq = novo;
            } else {
                anterior.dir = novo;
            }
        } else {
            raiz = novo;
        }
        n++;

        No temp = novo.pai;
        while(temp != null) {
            balanceie(temp);
            temp= temp.pai;
        }

        return true;
    }


    private void balanceie(No x) {
        if(fatorBalanceamento(x) >= 2) {
            if(fatorBalanceamento(x.dir) < 0) RightRotate(x.dir);
            LeftRotate(x);
        }
        if(fatorBalanceamento(x) <= -2) {
            if(fatorBalanceamento(x.esq) > 0) LeftRotate(x.esq);
            RightRotate(x);
        }

    }

    public int getN() {
        return n;
    }


    private boolean remove(No x) {
        int filhos = 0;

        if (x != null && x.esq != null) {
            filhos++;
        }
        if (x != null && x.dir != null) {
            filhos++;
        }

        No pai = x.pai;
        if (filhos == 0) {
            if(pai != null) {
                if(pai.esq == x) {
                    pai.esq = null;
                } else {
                    pai.dir=null;
                }
            } else {
                raiz = null;
            }
            n--;
        } else if(filhos == 1) {
            No filho = x.esq;
            if (filho == null)
                filho = x.dir;

            if(pai == null)
                this.raiz = filho;
            else {
                if(pai.esq == x)
                    pai.esq = filho;
                else
                    pai.dir = filho;
            }
            filho.pai = pai;
            n--;
        } else {
            No sucessor = x;
            sucessor = sucessor.dir;
            while(sucessor.esq != null)
                sucessor = sucessor.esq;
            x.valor = sucessor.valor;
            return remove(sucessor);
        }

        return true;
    }

    public boolean remove(int valor) {
        No atual = raiz;
        while(atual != null) {
            if (valor < atual.valor)
                atual = atual.esq;
            else if (valor > atual.valor)
                atual = atual.dir;
            else
                return remove(atual);
        }

        return false;

    }

    public boolean busca(int valor) {
        No atual = raiz;
        while(atual != null) {
            if (valor < atual.valor)
                atual = atual.esq;
            else if (valor > atual.valor)
                atual = atual.dir;
            else
                return true;
        }

        return false;
    }

    public void imprimeInOrdem() {
        imprimeErd(raiz);
        System.out.println();
    }
    public void imprimePosOrdem() {
        imprimeEdr(raiz);
        System.out.println();
    }

}

public class Main {
    private static void testeBusca(ArvBinBusca a, int valor) {
        if (a.busca(valor)) {
            System.out.println("valor " + valor + " encontrado na arvore");
        } else {
            System.out.println("valor " + valor + " NAO encontrado na arvore");
        }
    }
    private static void testeInsere(ArvBinBusca a, int valor) {
        if (a.insere(valor)) {
            System.out.println("valor " + valor + " inserido na arvore");
            System.out.printf("In-Ordem: ");
            a.imprimeInOrdem();
            System.out.printf("Pos-Ordem: ");
            a.imprimePosOrdem();
            System.out.println("======== Total: " + a.getN() + " nos ===========\n");
        }
    }
    private static void testeRemove(ArvBinBusca a, int valor) {
        if (a.remove(valor)) {
            System.out.println("valor " + valor + " removido da arvore");
            System.out.printf("In-Ordem: ");
            a.imprimeInOrdem();
            System.out.printf("Pos-Ordem: ");
            a.imprimePosOrdem();
            System.out.println("======== Total: " + a.getN() + " nos ===========\n");
        } else {
            System.out.println("valor " + valor + " NAO removido da arvore");
        }
    }
    public static void main(String[] args) {
        ArvBinBusca a = new ArvBinBusca();
        testeInsere(a, 10);
        testeInsere(a, 20);
        testeInsere(a, 30);
        testeInsere(a, 5);
        testeInsere(a, 1);
        testeInsere(a, 15);
        testeInsere(a, 13);
        testeInsere(a, 14);
    }
}
