class No{
  public int valor;
  public No proximo;
  public No(int valor){
    this.valor = valor;
    this.proximo = null;
  }

  public int getValor(){
    return valor;
  }

  public No getProximo(){
    return proximo;
  }
  //friend class
}
interface ILista{
  public boolean insere(int valor);
  public boolean remove(int idx);
  public int busca(int valor);
  public void imprime();
}


class LDE implements ILista{
  private No primeiro;
  private int n;
  public LDE(){
    primeiro = null;
    n = 0;
  }

  @Override
  public boolean insere(int valor){
    No temp = new No(valor);
    if(temp==null)
      return false;


    No anter = null;
    No atual = primeiro;
    while(atual != null && atual.valor < valor){
      anter = atual;
      atual = atual.proximo;
    }

    if(anter!=null)
      anter.proximo = temp;
    else
      primeiro = temp;

    temp.proximo = atual;
    n++;
    return true;
  }

  @Override
  public void imprime(){
    No temp = primeiro;
    while(temp != null){
      System.out.println(temp.valor);
      temp = temp.proximo;
    }
  }

  
  
 @Override
  public boolean remove(int idx) {
    No atual = primeiro;
    No anterior = null;
    int i=0;

    if (idx < 0 || idx >= n){
      return false;
    }
    
    for (i = 0 ; i < idx; i++) {
      anterior = atual;
      atual = atual.proximo;
    }
    
    if(anterior!=null){
        anterior.proximo=atual.proximo;
        
    }
    else{
        primeiro = atual.proximo;
    }
    
    n--;
    return true;
  }
  
  @Override
  public int busca (int valor) {

    No atual=primeiro;
    int idx = 0;
    while(atual!=null){
        if(atual.getValor() == valor){
        return idx;
      }
      idx++;
      atual = atual.getProximo();
    }
  return -1;
  }
}

public class LDEMain
{
  public static void main(String[] args) {
      //NÃ£o alterar o main
    LDE l = new LDE();
    l.insere(1);
    l.insere(5);
    l.insere(3);
    l.insere(9);
    l.insere(2);
    l.insere(0);
    System.out.println("===================");
    l.imprime();
    l.remove(3);
    System.out.println("===================");
    l.imprime();
    l.remove(0);
    System.out.println("===================");
    l.imprime();
    l.remove(3);
    System.out.println("===================");
    l.imprime();
    l.insere(9);
    System.out.println("===================");
    l.imprime();
    System.out.println("Buscas:");
    for (int i = 0; i < 10; i++) {
      System.out.println(i + " = " + l.busca(i));
    }


  }
}
