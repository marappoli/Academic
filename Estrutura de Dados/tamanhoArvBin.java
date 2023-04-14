//calcular o tamanho de uma arvore binaria de modo recursivo

//classe contendo o filho da esquerda e da direita do nó atual e o valor de chave
class No {
  int valor;
  No esq, dir;

  public No(int item) {
    valor = item;
    esq = dir = null;
  }
}

// classe para achar o tamanho da arvore
class ArvoreBinaria {
  No raiz;

  // função para retornar tamanho
  int tamanho() {
    return tamanho(raiz);
  }

  // varredura para quantos nós tem na arvore
  int tamanho(No node){
    if(node == null){
      return 0;
    }
    else{
      if(tamanho(node.esq) > tamanho(node.dir)){
        return tamanho(node.esq);
      }
      else if(tamanho(node.dir) > tamanho(node.esq)){
        return tamanho(node.dir);
      }
    }
    return 0;
  }
  
 void imprimeNo(No node) {
    if (node == null)
      return;

    imprimeNo(node.esq);
    System.out.println(node.valor);
    imprimeNo(node.dir);

  }
  public void imprime() {
    imprimeNo(raiz);
  }
}
    

    class Main{
    public static void main(String args[]){
      //criando uma arvore e inserindo os nós
      ArvoreBinaria a = new ArvoreBinaria();
      a.raiz = new No(1);
      a.raiz.esq = new No(2);
      a.raiz.dir = new No(3);
      a.raiz.esq.esq = new No(4);
      a.raiz.esq.dir = new No(5);
      a.raiz.dir.esq = new No(6);
      a.raiz.dir.dir = new No(7);
      a.imprime();
      System.out.println(a.tamanho());
    }
  }

