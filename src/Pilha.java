import java.util.Arrays;

public class Pilha {

    private int topo = -1;
    private int size;

    String[] elementos;

    public Pilha(int size) {
        this.size = size;
        elementos = new String[size];
        Arrays.fill(elementos, null);
    }

    public String pop(){
        return (!isVazia()) ? elementos[topo --] : null;
    }

    public void push(String data){
        if(!isCheia()){
            topo ++;
            elementos[topo ] = data;
        }
    }

    public void exibirPilha(){
        if(!isVazia())
            for(int i=topo ;i>=0;i--){
                System.out.println(elementos[i]);
            }
        else
            System.out.println("Vazia");
        System.out.println("--------------");
    }

    public boolean isCheia(){
        return  topo == size - 1;
    }

    public boolean isVazia(){
        return topo == -1;
    }

}
