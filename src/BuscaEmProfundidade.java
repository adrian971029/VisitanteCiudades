import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BuscaEmProfundidade {

    private String linea;
    private boolean flag;

    public BuscaEmProfundidade() {
        linea = "";
        flag = true;
    }

    public String getCaminhoEmProfundidade(String inicio, String destino) {
        ArrayList<Vertice> listaVertices = new ArrayList<>();
        ArrayList<Vertice> listaTemporal = new ArrayList<>();

        FileReader fileReader = null;
        String[] arrayString;
        try {
            fileReader = new FileReader("resources/mapa.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((linea = bufferedReader.readLine())!= null){
                arrayString = linea.split(",");
                listaTemporal.add(new Vertice(arrayString[0]));
                listaTemporal.add(new Vertice(arrayString[1]));
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        listaVertices.add(listaTemporal.get(0));

        for(Vertice vertice : listaTemporal){
            flag=true;
            for(Vertice vertice1:listaVertices){
                if(vertice.getData().equalsIgnoreCase(vertice1.getData())){
                    flag=true;
                    break;
                }else
                {
                    flag=false;
                }
            }
            if(!flag){
                listaVertices.add(vertice);
            }
        }

        Grafico grafico = new Grafico(listaVertices);
        FileReader fileReader1 = null;
        try {
            fileReader1 = new FileReader("resources/mapa.txt");
            BufferedReader bufferedReader2 = new BufferedReader(fileReader1);
            while((linea = bufferedReader2.readLine())!= null){
                arrayString = linea.split(",");
                grafico.addBorda(arrayString[0], arrayString[1]);
            }
            bufferedReader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pilha pilha = new Pilha(grafico.getListaVertices().size());
        String data="";

        String[] visitante = new String[grafico.getListaVertices().size()];
        ArrayList<Vertice> listaFinal = new ArrayList<>();

        int contador = 0 ;
        StringBuilder resultado = new StringBuilder();

        pilha.push(inicio);

        visitante[contador++]=inicio;

        while(!pilha.isVazia()){

            data = pilha.pop();

            if(data.equalsIgnoreCase(destino)) {
                resultado = new StringBuilder("Objetivo alcançado!" + System.lineSeparator());
                break;
            }
            else {
                listaFinal = grafico.getVerticeFromData(data).getListaVerticesAdjacentes();
                Collections.sort(listaFinal,new Comparator<Vertice>(){
                    @Override public int compare(Vertice vertice1,Vertice vertice2){
                        return vertice1.getData().compareTo(vertice2.getData());
                    }
                });
                for(Vertice vertice:listaFinal) {
                    if(!verficaSeFoiVisitado(visitante,vertice.getData())){
                        visitante[contador++]=vertice.getData();
                        pilha.push(vertice.getData());
                        vertice.getCaminho().addAll(grafico.getVerticeFromData(data).getCaminho());
                    }

                }
            }
        }

        resultado.append("Ruta desde ").append(inicio).append(" para ").append(destino).append(":" + System.lineSeparator());

        for(int i=grafico.getVerticeFromData(destino).getCaminho().size()-1; i>0; i--){
            resultado.append(grafico.getVerticeFromData(destino).getCaminho().get(i).getData()).append(" --> ");
        }
        resultado.append(grafico.getVerticeFromData(destino).getCaminho().get(0).getData());
        return resultado.toString();
    }

    private static boolean verficaSeFoiVisitado(String[] visitado, String data) {
        for (String s : visitado) {
            if (data.equalsIgnoreCase(s))
                return true;
        }
        return false;
    }
}
