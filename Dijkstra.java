/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstrapkg;

/**
 *
 * @author Camila
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Dijkstra{

  public static final int N = 5;
  //Arreglo de caminos
  public ArrayList<Camino> Caminos = new ArrayList<Camino>();
  
  //Conjunto S = {}
  //El conjunto S va a almacenar indices de los nodos
  public static ArrayList<Integer> S = new ArrayList<Integer>();
  
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
        vertice = NS.get(0);
        if(D.length > 1){
          for(int i = 0; i < this.NS.size();i++){
            if(D[vertice] > D[i] && D[i]!=-1 || (D[vertice]==-1 && D[vertice]!=D[i]))
              vertice = NS.get(i);

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
  
  public String shortestPath(int w, int v, int s)
  {
  	String path=""+s;
  	if(this.grafo[s][v]!=-1 && s!=w)
  	{
            
  	}
  	return path;
  }

  //Algoritmo principal Dijkstra Mejorado "Wink wink"
  public void Djk(int s, int n){
    int w;
    n=n-1;
    //S <- {a} //Nodo inicial
    this.S.add(s);
    //para i <- 2 hasta (n - 1) hacer
    for (int i = 0; i <= n;i++)
      //D[i] <- T[1][i]
      D[i] = this.grafo[s][i];
    //para 1 <- 1 hasta n-1 hacer
    for (int i = 0;i < n; i++){
      //Esto hace la operacion N-S
      this.N_menos_S();
      //Elige un vertice w tal que D[w] sea un minimo
      w = this.vertMinimo();
      //agrega w a S
      this.S.add(w);
      //para cada vertice y en N-S hacer
      this.N_menos_S();
      for (int v = 0; v < D.length;v++){
        if(grafo[w][v]!=-1)
            if(D[v]!=-1)
                D[v] = min(D[v], D[w] + grafo[w][v]);
            else D[v] = D[w]+grafo[w][v];
        //shortestPath(w,v,s);
      }
    }
    for(int v=0; v<D.length;v++)
        System.out.print(D[v]+" ");
  }



  public static void main(String[] args){
      int n=5;
      int[][] grafo = new int[n][n];
      String[] nodos = new String[n];
      /*Scanner scan = new Scanner(System.in);
      int n;
      
      System.out.println("\tIngrese el grafo \n");
      System.out.println("Numero de vertices: \n");
      n = scan.nextInt();
      
      
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
    }**/
    
      grafo[0][0]=0;
      grafo[0][1]=10;
      grafo[0][2]=-1;
      grafo[0][3]=30;
      grafo[0][4]=100;
      
      grafo[1][0]=-1;
      grafo[1][1]=0;
      grafo[1][2]=50;
      grafo[1][3]=-1;
      grafo[1][4]=-1;
      
      grafo[2][0]=-1;
      grafo[2][1]=-1;
      grafo[2][2]=0;
      grafo[2][3]=-1;
      grafo[2][4]=10;
      
      grafo[3][0]=-1;
      grafo[3][1]=-1;
      grafo[3][2]=20;
      grafo[3][3]=0;
      grafo[3][4]=60;
      
      grafo[4][0]=-1;
      grafo[4][1]=-1;
      grafo[4][2]=-1;
      grafo[4][3]=-1;
      grafo[4][4]=0;
      
      nodos[0]="a";
      nodos[1]="b";
      nodos[2]="c";
      nodos[3]="d";
      nodos[4]="e";
      
      Dijkstra main = new Dijkstra(grafo, nodos);
      
      System.out.println("Los caminos de costo minimo son:\n");
      //for(int i=0;i<5;i++){
        main.Djk(0,5);
        S.clear();
      }
      
      /*for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            System.out.print(grafo[i][j] + " ");
          }
        System.out.println("\n");
      }*/
  }
}
