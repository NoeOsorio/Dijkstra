import java.util.ArrayList;

public class Camino{
  public int from;
  public int to;
  private double cost;
  private ArrayList<Integer> caminito = new ArrayList();

  public Camino(int a, int b, double cost){
    this.cost = cost;
    this.from = a;
    this.to = b;
    if(!this.caminito.contains(a))
      this.caminito.add(a);
    if(!this.caminito.contains(b))
      this.caminito.add(b);
  }

  public void add(int c, double cost){
    if(!this.caminito.contains(c)){
      this.caminito.add(c);
      this.cost = cost;
    }

  }

  public String toString(){
    String path = "";
    path += this.caminito.get(0);
    for(int i = 1; i < this.caminito.size(); i++)
        path += " -> " + this.caminito.get(i);
    path += " = \t" + this.cost ;
      return path;
  }



}
