package librerias;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculadoraConversor {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Taller 3 - Operaciones y Conversiones");
        ventana.setSize(520, 680);
        ventana.setLayout(null);

        // Secciones visuales
        JLabel lblSecMate = new JLabel("--- 1. OPERACIONES MATEMATICAS ---");
        lblSecMate.setBounds(40, 20, 420, 25);
        ventana.add(lblSecMate);

        JLabel lblSecTemp = new JLabel("--- 2. CONVERSION DE TEMPERATURA ---");
        lblSecTemp.setBounds(40, 195, 420, 25);
        ventana.add(lblSecTemp);

        JLabel lblSecMoneda = new JLabel("--- 3. CONVERSION DE MONEDA ---");
        lblSecMoneda.setBounds(40, 335, 420, 25);
        ventana.add(lblSecMoneda);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
