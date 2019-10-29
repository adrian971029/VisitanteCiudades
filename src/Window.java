import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Tue Oct 29 14:43:07 BRT 2019
 */



/**
 * @author unknown
 */
public class Window extends JFrame {

    public Window() {
        initComponents();
        setTitle("Viajando pelas Ciudades");
        alimentarComboBox();
    }

    private void btnBuscaLarguraActionPerformed(ActionEvent e) {
        tfResultado.setText("");
        String inicio = Objects.requireNonNull(cbCiudadeInicial.getSelectedItem()).toString();
        String destino = Objects.requireNonNull(cbCiudadeFinal.getSelectedItem()).toString();
        BuscaEmLargura buscaEmLargura = new BuscaEmLargura();
        tfResultado.setText(buscaEmLargura.getCaminhoEmLargura(inicio, destino));
    }

    private void btnBuscaProfundidadeActionPerformed(ActionEvent e) {
        tfResultado.setText("");
        String inicio = Objects.requireNonNull(cbCiudadeInicial.getSelectedItem()).toString();
        String destino = Objects.requireNonNull(cbCiudadeFinal.getSelectedItem()).toString();
        BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade();
        tfResultado.setText(buscaEmProfundidade.getCaminhoEmProfundidade(inicio, destino));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        lblCiudadeInicial = new JLabel();
        cbCiudadeInicial = new JComboBox();
        lblCiudadeFinal = new JLabel();
        cbCiudadeFinal = new JComboBox();
        btnBuscaLargura = new JButton();
        btnBuscaProfundidade = new JButton();
        image_map = new JLabel();
        scrollPane1 = new JScrollPane();
        tfResultado = new JTextArea();

        //======== this ========
        Container contentPane = getContentPane();

        //---- lblCiudadeInicial ----
        lblCiudadeInicial.setText("Ciudade Inicial:");

        //---- lblCiudadeFinal ----
        lblCiudadeFinal.setText("Ciudade Final:");

        //---- btnBuscaLargura ----
        btnBuscaLargura.setText("Busca em Largura");
        btnBuscaLargura.setMaximumSize(new Dimension(170, 30));
        btnBuscaLargura.setMinimumSize(new Dimension(170, 30));
        btnBuscaLargura.setPreferredSize(new Dimension(170, 30));
        btnBuscaLargura.addActionListener(e -> btnBuscaLarguraActionPerformed(e));

        //---- btnBuscaProfundidade ----
        btnBuscaProfundidade.setText("Busca em Profundiade");
        btnBuscaProfundidade.addActionListener(e -> btnBuscaProfundidadeActionPerformed(e));

        //---- image_map ----
        image_map.setPreferredSize(new Dimension(500, 500));
        image_map.setIcon(new ImageIcon("/Users/adriandeltoro/Personal/Programacao/BuscaEmLargura/resources/map_image.png"));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tfResultado);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(lblCiudadeInicial)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbCiudadeInicial, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(lblCiudadeFinal)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbCiudadeFinal, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(btnBuscaLargura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscaProfundidade))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(scrollPane1))
                                .addComponent(image_map, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(15, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCiudadeInicial)
                        .addComponent(lblCiudadeFinal)
                        .addComponent(cbCiudadeInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCiudadeFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(image_map, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnBuscaLargura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscaProfundidade))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel lblCiudadeInicial;
    private JComboBox cbCiudadeInicial;
    private JLabel lblCiudadeFinal;
    private JComboBox cbCiudadeFinal;
    private JButton btnBuscaLargura;
    private JButton btnBuscaProfundidade;
    private JLabel image_map;
    private JScrollPane scrollPane1;
    private JTextArea tfResultado;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //Alimentando componentes
    private void alimentarComboBox() {
        ArrayList<String> listaCiudades = new ArrayList<>();
        listaCiudades.add("Arad");
        listaCiudades.add("Zerind");
        listaCiudades.add("Oradea");
        listaCiudades.add("Timisoara");
        listaCiudades.add("Sibiu");
        listaCiudades.add("Lugoj");
        listaCiudades.add("Rimnicu Vilcea");
        listaCiudades.add("Fagaras");
        listaCiudades.add("Mehadia");
        listaCiudades.add("Dobreta");
        listaCiudades.add("Craiova");
        listaCiudades.add("Pitesti");
        listaCiudades.add("Bucharest");
        listaCiudades.add("Giurgiu");
        listaCiudades.add("Urziceni");
        listaCiudades.add("Hirsova");
        listaCiudades.add("Eforie");
        listaCiudades.add("Vaslui");
        listaCiudades.add("Iasi");
        listaCiudades.add("Neamt");
        DefaultComboBoxModel<Object> modelCiudadeInicial = new DefaultComboBoxModel<>(listaCiudades.toArray());
        DefaultComboBoxModel<Object> modelCiudadeFinal = new DefaultComboBoxModel<>(listaCiudades.toArray());
        cbCiudadeInicial.setModel(modelCiudadeInicial);
        cbCiudadeFinal.setModel(modelCiudadeFinal);
    }

}
