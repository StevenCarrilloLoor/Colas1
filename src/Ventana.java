import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JComboBox cboMarcaModelo;
    private JTextField txtAnio;
    private JButton btnAgregar;
    private JTextArea txtListado;
    private JButton btnPagar;
    ListadoAutos coleccion=new ListadoAutos();
    public Ventana (){

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int anio = Integer.parseInt(txtAnio.getText());
                if(anio<1900 || anio>2024){
                    JOptionPane.showMessageDialog(null,"Ingrese un ano entre 1900 y 2024");
                }else{
                coleccion.encolar(new Auto(cboMarcaModelo.getSelectedItem().toString(),anio));
                txtListado.setText(coleccion.listaAutos());}
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   Auto autoPagado=coleccion.desencolar();
                   JOptionPane.showMessageDialog(null,"total a pagar"+autoPagado.valorPago()+"\n"+autoPagado);
                   txtListado.setText(coleccion.listaAutos());
               }catch (Exception ex){
                   JOptionPane.showMessageDialog(null,ex.getMessage());
               }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
