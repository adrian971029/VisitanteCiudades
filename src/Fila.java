import java.util.Iterator;
import java.util.LinkedList;

public class Fila {

    private LinkedList<String> elementos;
    private int size;

    public Fila(int size) {
        this.elementos = new LinkedList<>();
        this.size = size;
    }

    public void enfileirar(String vertice){
        if(!isCheio()){
            elementos.addLast(vertice);
        }
    }

    public String desenfileirar(){

        return elementos.poll();

    }

    private boolean isCheio() {
        return elementos.size()==size;
    }

    public String exibirFila(){

        Iterator<String> iterator = elementos.iterator();
        String auxiliar = "";
        while(iterator.hasNext()){

            auxiliar = auxiliar + iterator.next();
        }
        return auxiliar;
    }

    public int getSize() {
        return size;
    }
}
