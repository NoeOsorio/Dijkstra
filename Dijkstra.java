import java.util.ArrayList;
import java.util.Scanner;

public class Dijkstra{

  public static final int N = 5;
  //Arreglo de caminos
  public ArrayList<Camino> caminos = new ArrayList<Camino>();

  //Conjunto S = {}
  //El conjunto S va a almacenar indices de los nodos
  public static ArrayList<Integer> S = new ArrayList<Integer>();

  //Matriz de transicion del grafo T
  public double[][] grafo = new double[N][N];

  //Arreglo de nodos = {a, b, c, d, e}
  public String[] nodos = new String[N];

  //Arreglo D = {}
  public double[] D = new double[N];

  //N-S
  public ArrayList<Integer> NS = new ArrayList<Integer>();

  //Constructor
  public Dijkstra(double[][] grafo, String[] nodos){
    this.grafo = grafo;
    this.nodos = nodos;
  }

  public int containsPath(int a, int b){
    Camino temp;
    for(int i = 0; i < this.caminos.size();i++){
      temp = this.caminos.get(i);
      if(temp.from == a && temp.to == b)
        return i;
    }
    return -1;
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
  public static double min(double a, double b){
    double minimo;
    if(a<=b)
      minimo = a;
    else
      minimo = b;
    return minimo;
  }

  public void cleanPath(){
    for(int i = 0; i < this.caminos.size();i++){
      (this.caminos.get(i)).cleanPath();
    }
  }
  //Algoritmo principal Dijkstra Mejorado "Wink wink"
  public void Djk(int s, int n){

    int w;
    n=n-1;

    this.S.add(s);

    for (int i = 0; i <= n;i++){
      D[i] = this.grafo[s][i];
      //Añade los primero caminos al Arreglo de caminos
      caminos.add(new Camino(s,i,D[i]));
    }

    for (int i = 0;i < n; i++){
      this.N_menos_S();

      w = this.vertMinimo();
      this.S.add(w);
      this.N_menos_S();

      for (int v = 0; v < D.length; v++){

          D[v] = min(D[v], D[w] + grafo[w][v]);
          if(D[v] == D[w] + grafo[w][v]){
            //Agrega los caminos al Arreglo de caminos
            if(this.containsPath(s,v) != -1)
                //si existe un camino mas barato, entonces modifica el anterior
                (this.caminos.get(this.containsPath(s,v))).add(w,D[v]);
          }
      }
    }
    //Con este comando se imprime la matriz T con los caminos mas baratos
    /*for(int v=0; v<D.length;v++)
        System.out.print("|"+D[v]+"|\t");
    System.out.println("\n");
    */
    this.cleanPath();
  }



  public static void main(String[] args){
      int n=5;
      double[][] grafo = new double[n][n];
      String[] nodos= new String[n];
      /*Scanner scan = new Scanner(System.in);
      int n, s, f;

      System.out.println("\tIngrese el grafo \n");
      System.out.println("Numero de vertices: \n");
      n = scan.nextInt();
      nodos = new String[n];
      grafo = new double[n][n];

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

                else if(scan.next().startsWith("n")){
                    grafo[i][j] =Double.POSITIVE_INFINITY;
                }
            }
        }
    }
    */
      grafo[0][0]=0;
      grafo[0][1]=10;
      grafo[0][2]=Double.POSITIVE_INFINITY;
      grafo[0][3]=30;
      grafo[0][4]=100;

      grafo[1][0]=Double.POSITIVE_INFINITY;
      grafo[1][1]=0;
      grafo[1][2]=50;
      grafo[1][3]=Double.POSITIVE_INFINITY;
      grafo[1][4]=Double.POSITIVE_INFINITY;

      grafo[2][0]=Double.POSITIVE_INFINITY;
      grafo[2][1]=Double.POSITIVE_INFINITY;
      grafo[2][2]=0;
      grafo[2][3]=Double.POSITIVE_INFINITY;
      grafo[2][4]=10;

      grafo[3][0]=Double.POSITIVE_INFINITY;
      grafo[3][1]=Double.POSITIVE_INFINITY;
      grafo[3][2]=20;
      grafo[3][3]=0;
      grafo[3][4]=60;

      grafo[4][0]=Double.POSITIVE_INFINITY;
      grafo[4][1]=Double.POSITIVE_INFINITY;
      grafo[4][2]=Double.POSITIVE_INFINITY;
      grafo[4][3]=Double.POSITIVE_INFINITY;
      grafo[4][4]=0;

      nodos[0]="a";
      nodos[1]="b";
      nodos[2]="c";
      nodos[3]="d";
      nodos[4]="e";

      Dijkstra main = new Dijkstra(grafo, nodos);

      //System.out.println("Ingrese los nodos entre los cuales quiere encontrar los caminos de costo minimo: \n");
      //System.out.println("Nodo 1: \n");
      //s = scan.nextInt();
      //System.out.println("Nodo 2: \n");
      //f = scan.nextInt();
      System.out.println("Los caminos de costo minimo son:\n");
      //for(int i=0;i<5;i++){
      for(int j = 0; j < 5; j++){
        main.Djk(j,5);
        S.clear();
      }
      for(int i = 0; i < main.caminos.size(); i++)
        System.out.println(main.caminos.get(i));

  }

      /*for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            System.out.print(grafo[i][j] + " ");
          }
        System.out.println("\n");
      }*/
}
