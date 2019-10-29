public class Borda {

    private Vertice uno;
    private Vertice dois;

    public Borda(Vertice uno, Vertice dois) {
        this.uno = uno;
        this.dois = dois;
    }

    public Vertice getBordaAdjacente(Vertice vertice){
        return (vertice.equals(uno)) ? dois : uno;
    }

}
