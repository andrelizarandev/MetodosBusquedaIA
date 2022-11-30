import rompecabezas.ProblemaRompecabezas;
import utils.ComboItem;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static espacio_de_estados.EstrategiaBusqueda.*;

public class MetodosBusquedaGUI extends JFrame {
  private JPanel panel1;
  private JTextField textField1;
  private JTextField textField2;
  private JButton button1;
  private JComboBox comboBox1;
  private JCheckBox conRepeticiónCheckBox;
  public MetodosBusquedaGUI () {

    comboBox1.addItem(new ComboItem("Por Amplitud", BUSQUEDA_POR_AMPLITUD));
    comboBox1.addItem(new ComboItem("Por Profundidad", BUSQUEDA_POR_PROFUNDIDAD));
    comboBox1.addItem(new ComboItem("Por Costo Uniforme", BUSQUEDA_POR_COSTO_UNIFORME));
    comboBox1.addItem(new ComboItem("Best First", BUSQUEDA_BEST_FIRST));
    comboBox1.addItem(new ComboItem("A*", BUSQUEDA_A_ESTRELLA));

    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String sInitial = textField1.getText();
        String sFinal = textField2.getText();
        Boolean conRepeticion = conRepeticiónCheckBox.isSelected();
        Integer metodo = comboBox1.getSelectedIndex() + 1;
        runSearchMethod(sInitial, sFinal, metodo, conRepeticion);
      }
    });
  }
  public void runSearchMethod (String sInitial, String sFinal, Integer metodo, boolean conRepeticion) {
    System.out.println(metodo);
    ProblemaRompecabezas problema = new ProblemaRompecabezas(sInitial, sFinal);
    problema.buscarSolucion(metodo, conRepeticion);
  }

  public static void main(String[] args) {
    MetodosBusquedaGUI j = new MetodosBusquedaGUI();
    j.setContentPane(new MetodosBusquedaGUI().panel1);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j.setTitle("Métodos de Búsqueda");
    j.setResizable(false);
    j.setVisible(true);
    j.pack();
  }
}

//  String sInitial = "1,2,3,8,6,0,7,5,4";
//  String sFinal =    "1,2,3,8,0,4,7,6,5";

