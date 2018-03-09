

import java.util.ArrayList;

public class Dijkstra{

  public static final int N = 5;
  //Arreglo de caminos
  public ArrayList<Camino> Caminos = new ArrayList<Camino>();
  //Conjunto S = {}
  public ArrayList<String> S = new ArrayList<String>();
  //Matriz de transicion del grafo
  public int[][] grafo = new int[N][N];
  //Arreglo de nodos = {a, b, c, d, e}
  public String[] nodos = new String[N];
  //Arreglo D = {}
  public int[] D = new int[N];
  //N-S
  public ArrayList<String> NS = new ArrayList<String>();

  //Constructor
  public Dijkstra(int[][] grafo, String[] nodos){
    this.grafo = grafo;
    this.nodos = nodos;
  }

  private void N_menos_S(){
    NS.clear();
    for(int i = 0; i < nodos.length;i++){
      if(!this.S.contains(this.nodos[i]))
        NS.add(this.nodos[i]);
    }
  }

  public String vertMinimo(){
      String vertice = "";
      //necesitamos hacer el algoritmo para calcula el vertice minimo

      return vertice;
  }

  //Algoritmo principal Dijkstra Mejorado "Wink wink"
  public void Djk(){
    String w;
    //S <- {a} //Nodo inicial
    this.S.add(this.nodos[1]);
    //para i <- 2 hasta (n - 1) hacer
    for (int i = 2; i < N;i++)
      //D[i] <- T[1][i]
      D[i] = this.grafo[1][i];
    //para 1 <- 1 hasta n-1 hacer
    for (int i = 1;i < N-1; i++){
      //Esto hace la operacion N-S
      this.N_menos_S();
      //Elige un vertice w tal que D[w] sea un minimo
      w = this.vertMinimo();
      //agrega w a S
      this.S.add(w);
      //para cada vertice y en N-S hacer
      this.N_menos_S();

    }
  }


  public static void main(String[] args){

  }
}
