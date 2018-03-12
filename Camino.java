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
      this.caminito.add(a);
      this.caminito.add(b);
  }

  public void add(int c, double cost){
    int i = 1;
    if(!this.caminito.contains(c)){
      this.caminito.add(this.caminito.indexOf(this.to),c);
      this.cost = cost;
    }
    /*if(!this.caminito.contains(c)){
      this.caminito.add(c);

    }*/

  }

  public String toString(){
    String path = "";
    path += this.caminito.get(0);
    for(int i = 1; i < this.caminito.size(); i++)
        path += " -> " + this.caminito.get(i);
    path += " = \t" + this.cost ;
      return path;
  }

  public void cleanPath(){
      if(this.cost == Double.POSITIVE_INFINITY){
        this.caminito.clear();
        this.caminito.add(this.from);
        this.caminito.add(this.to);
      }
  }

}
