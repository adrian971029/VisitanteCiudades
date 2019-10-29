import java.util.ArrayList;

public class Grafico {

    private ArrayList<Vertice> listaVertices;
    private ArrayList<Borda> listaBorda;

    public Grafico(ArrayList<Vertice> vertices) {
        this.listaVertices = new ArrayList<>();
        this.listaBorda = new ArrayList<>();
        this.listaVertices.addAll(vertices);
    }

    public void addBorda(Vertice uno, Vertice dois){
        Borda borda = new Borda(uno, dois);
        this.listaBorda.add(borda);
        uno.addBorda(borda);
        dois.addBorda(borda);
    }

    public void addBorda(String data1, String data2){
        addBorda(getVerticeFromData(data1), getVerticeFromData(data2));
    }

    public Vertice getVerticeFromData(String data){
        for(Vertice vertice : this.listaVertices){
            if(vertice.getData().equalsIgnoreCase(data))
                return vertice;
        }
        return null;
    }

    public ArrayList<Vertice> getListaVertices() {
        return listaVertices;
    }
}
