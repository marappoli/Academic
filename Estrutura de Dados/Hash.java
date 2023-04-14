class No {
  public int valor;
  public No anterior;
  public No proximo;
}

interface ILista {
  boolean insere(int valor);

  boolean remove(int idx);

  void imprime();

  void imprimeReverso();

  int busca(int valor);
}

class Ldde implements ILista {
  private No primeiro = null;
  private No ultimo = null;
  private int n = 0;

  @Override
  public boolean insere(int valor) {
    No novo = new No();
    if (novo == null)
      return false;
    novo.valor = valor;
    novo.anterior = null;
    novo.proximo = null;

    No atual = primeiro;
    No anterior = null;
    while (atual != null && atual.valor < valor) {
      anterior = atual;
      atual = atual.proximo;
    }

    if (atual != null) {
      atual.anterior = novo;
    } else {
      ultimo = novo;
    }

    if (anterior != null) {
      anterior.proximo = novo;
    } else {
      primeiro = novo;
    }

    novo.proximo = atual;
    novo.anterior = anterior;

    n++;
    return true;

  }

  @Override
  public boolean remove(int idx) {
    if (idx < 0 || idx >= n)
      return false;
    No atual = primeiro;

    while (atual != null && idx > 0) {
      atual = atual.proximo;
      idx--;
    }

    if (atual == null)
      return false;

    No ant = atual.anterior;
    No prox = atual.proximo;

    if (ant != null)
      ant.proximo = prox;
    else
      primeiro = prox;

    if (prox != null)
      prox.anterior = ant;
    else
      ultimo = ant;

    return true;
  }

  @Override
  public void imprime() {
    No atual = primeiro;
    while (atual != null) {
      System.out.print(atual.valor + "   ");
      atual = atual.proximo;
    }
  }

  @Override
  public void imprimeReverso() {
    No atual = ultimo;
    while (atual != null) {
      System.out.println(atual.valor);
      atual = atual.anterior;
    }
  }

  @Override
  public int busca(int valor) {
    No atual = primeiro;
    int idx = 0;
    while (atual != null) {
      if (atual.valor == valor)
        return idx;
      atual = atual.proximo;
      idx++;
    }
    return -1;
  }
}

interface IHashTable {
  boolean insere(int valor);

  boolean remove(int valor);

  boolean busca(int valor);

  void imprime();
}

class HashTable implements IHashTable {

  private Ldde[] v;
  private int n;

  HashTable(int capacidade) {
    v = new Ldde[capacidade];
    for (int i = 0; i < v.length; i++)
      v[i] = new Ldde();

    n = 0;
  }

  boolean insere(int x) {
    if (n >= max) {
      return false;
    }
    int idx = fhash(x);
    this.v[idx].add(x);
    n += 1;
    return true;
  }

  @Override
  public void imprime() {
    for (int i = 0; i < v.length; i++) {
      System.out.print("Lista " + i + ": ");
      v[i].imprime();
      System.out.println("");
    }
  }
}

public class Main {
  public static void insere(IHashTable hash, int valor) {
    if (hash.insere(valor))
      System.out.println(valor + " inserido na Hash");
    else
      System.out.println("erro na inserção do valor " + valor);
  }

  public static void imprime(IHashTable hash) {
    System.out.println("==imprimindo Hash==");
    hash.imprime();
    System.out.println("===================");
  }

  public static void busca(IHashTable hash, int valor) {
    if (hash.busca(valor))
      System.out.println("Valor " + valor + " encontrado na Hash");
    else
      System.out.println("Valor " + valor + " não encontrado na Hash");
  }

  public static void remove(IHashTable hash, int valor) {
    if (hash.remove(valor))
      System.out.println(valor + " removido da Hash");
    else
      System.out.println("erro na remoção do valor " + valor);
  }

  public static void main(String[] args) {
    IHashTable hash = new HashTable(5);
    insere(hash, 4);
    insere(hash, 9);
    insere(hash, 3);
    insere(hash, 8);
    imprime(hash);
    busca(hash, 3);
    busca(hash, 4);
    busca(hash, 8);
    busca(hash, 9);
    busca(hash, 10);

    remove(hash, 3);
    remove(hash, 9);
    remove(hash, 0);
    imprime(hash);

    for (int i = 21; i < 25; i++) {
      insere(hash, i);
    }

    imprime(hash);

  }
}
