import java.util.ArrayList;
import java.util.Scanner;

public class Dijkstra{

  public static final int N = 5;
  //Arreglo de caminos
  public ArrayList<Camino> Caminos = new ArrayList<Camino>();
  
  //Conjunto S = {}
  //El conjunto S va a almacenar indices de los nodos
  public ArrayList<Integer> S = new ArrayList<Integer>();
  
  //Matriz de transicion del grafo T
  public int[][] grafo = new int[N][N];
  
  //Arreglo de nodos = {a, b, c, d, e}
  public String[] nodos = new String[N];
  
  //Arreglo D = {}
  public int[] D = new int[N];
  
  //N-S
  public ArrayList<Integer> NS = new ArrayList<Integer>();

  //Constructor
  public Dijkstra(int[][] grafo, String[] nodos){
    this.grafo = grafo;
    this.nodos = nodos;
  }

  private void N_menos_S(){
    NS.clear();
    for(int i = 0; i < nodos.length;i++){
      //Si S no contiene el indice, entonces agrega el indice a NS
      if(!this.S.contains(i))
        NS.add(i);
    }
  }
  public int vertMinimo(){
      int vertice = -1;
      //Si D esta vacio entonces el minimo no existe (-1)
      if(D.length > 0){
        vertice = D[0];
        if(D.length > 1){
          for(int i = 1; i < this.D.length;i++){
            if(vertice > D[i])
              vertice = D[i];

          }
        }
      }
      return vertice;
  }
  public static int min(int a, int b){
    int minimo;
    if(a<=b)
      minimo = a;
    else
      minimo = b;
    return minimo;
  }

  //Algoritmo principal Dijkstra Mejorado "Wink wink"
  public void Djk(){
    int w;
    //S <- {a} //Nodo inicial
    this.S.add(1);
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
      for (int v = 0; v < NS.size();i++){
        D[v] = min(D[v], D[w] + grafo[w][v]);
      }

    }
  }




  public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int n;
      
      System.out.println("\tIngrese el grafo \n");
      System.out.println("Numero de vertices: \n");
      n = scan.nextInt();
      
      int[][] grafo = new int[n][n];
      String[] nodos = new String[n];
      
      for(int i = 0; i < n; i++){
          System.out.println("Ingrese el vertice " + i + "\n");
          nodos[i] = scan.next();
      }
      
      System.out.print("\nN: { ");
      for(int i = 0; i < n; i++){
          System.out.print(nodos[i] + " ");
      }
      System.out.println("}\n");
      
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            
            if(i != j){
                System.out.println("Conectar nodo " + nodos[i] + " con nodo " + nodos[j] + "? s/n\n");
                
                if(scan.next().startsWith("s")){
                    System.out.println("Ingrese el peso de la arista: \n");
                    grafo[i][j] = scan.nextInt();
                }
                
                else{
                    grafo[i][j] = -1;
                }
            }
        }
    }
      
      Dijkstra main = new Dijkstra(grafo, nodos, n);
      main.Djk();
      
      /*for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            System.out.print(grafo[i][j] + " ");
          }
        System.out.println("\n");
      }*/
  }
}
