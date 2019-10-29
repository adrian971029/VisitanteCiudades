import java.util.ArrayList;

public class Vertice {

    private String data;
    private ArrayList<Borda> listaBorda;
    private ArrayList<Vertice> caminho;


    public Vertice(String l){
        this.data = l;
        this.listaBorda = new ArrayList<>();
        this.caminho = new ArrayList<>();
        this.caminho.add(this);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setListaBorda(ArrayList<Borda> listaBorda) {
        this.listaBorda = listaBorda;
    }

    public ArrayList<Vertice> getCaminho() {
        return caminho;
    }

    public void setCaminho(ArrayList<Vertice> caminho) {
        this.caminho = caminho;
    }

    public void addBorda(Borda borda){
        if(this.listaBorda.contains(borda)) {
            return;
        } else {
            this.listaBorda.add(borda);
        }
    }

    public boolean containsBorda(Borda e){
        return this.listaBorda.contains(e);
    }

    public ArrayList<Borda> getListaBorda(){
        return listaBorda;
    }

    public int getCountBorda(){
        return listaBorda.size();
    }

    public ArrayList<Vertice> getListaVerticesAdjacentes(){

        ArrayList<Vertice> vertices = new ArrayList<>();

        for(Borda borda: listaBorda){
            vertices.add(borda.getBordaAdjacente(this));
        }

        return vertices;
    }

}
