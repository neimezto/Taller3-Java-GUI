package taller3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalculadoraConversor {

    private static final double TASA_COP = 3200.0;

    public static void main(String[] args) {
        
        JFrame ventana = new JFrame("Taller 3 - Operaciones y Conversiones");
        ventana.setSize(520, 680);
        ventana.setLayout(null);

        Font fuenteTitulo = new Font("Arial", Font.BOLD, 14);


        JLabel lblSecMate = new JLabel("--- 1. OPERACIONES MATEMÁTICAS ---");
        lblSecMate.setFont(fuenteTitulo);
        lblSecMate.setBounds(40, 20, 420, 25);

        JLabel lblMate1 = new JLabel("Número 1:");
        lblMate1.setBounds(40, 55, 100, 30);
        JTextField txtMate1 = new JTextField();
        txtMate1.setBounds(150, 55, 310, 30);

        JLabel lblMate2 = new JLabel("Número 2:");
        lblMate2.setBounds(40, 95, 100, 30);
        JTextField txtMate2 = new JTextField();
        txtMate2.setBounds(150, 95, 310, 30);

        JButton btnSumar = new JButton("Sumar");
        btnSumar.setBounds(40, 135, 100, 30);

        JButton btnRestar = new JButton("Restar");
        btnRestar.setBounds(150, 135, 100, 30);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(260, 135, 100, 30);

        JButton btnDividir = new JButton("Dividir");
        btnDividir.setBounds(370, 135, 90, 30);


        JLabel lblSecTemp = new JLabel("--- 2. CONVERSIÓN DE TEMPERATURA ---");
        lblSecTemp.setFont(fuenteTitulo);
        lblSecTemp.setBounds(40, 195, 420, 25);

        JLabel lblTemp = new JLabel("Temperatura:");
        lblTemp.setBounds(40, 230, 100, 30);
        JTextField txtTemp = new JTextField();
        txtTemp.setBounds(150, 230, 310, 30);

        JButton btnCtoF = new JButton("°C a °F");
        btnCtoF.setBounds(100, 275, 140, 35);

        JButton btnFtoC = new JButton("°F a °C");
        btnFtoC.setBounds(260, 275, 140, 35);

        JLabel lblSecMoneda = new JLabel("--- 3. CONVERSIÓN DE MONEDA (Tasa: $3200) ---");
        lblSecMoneda.setFont(fuenteTitulo);
        lblSecMoneda.setBounds(40, 335, 420, 25);

        JLabel lblMoneda = new JLabel("Valor dinero:");
        lblMoneda.setBounds(40, 370, 100, 30);
        JTextField txtMoneda = new JTextField();
        txtMoneda.setBounds(150, 370, 310, 30);

        JButton btnUsdToCop = new JButton("USD a COP");
        btnUsdToCop.setBounds(100, 415, 140, 35);

        JButton btnCopToUsd = new JButton("COP a USD");
        btnCopToUsd.setBounds(260, 415, 140, 35);

        JLabel lblResultadoTitulo = new JLabel("Resultado en pantalla:");
        lblResultadoTitulo.setFont(fuenteTitulo);
        lblResultadoTitulo.setBounds(40, 480, 200, 25);

        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(40, 510, 420, 45);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Arial", Font.BOLD, 15));

        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMate1.getText().trim().isEmpty() || txtMate2.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Debe diligenciar el Número 1 y el Número 2.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double n1 = Double.parseDouble(txtMate1.getText().replace(',', '.'));
                    double n2 = Double.parseDouble(txtMate2.getText().replace(',', '.'));
                    double res = n1 + n2;
                    txtResultado.setText("Suma: " + n1 + " + " + n2 + " = " + String.format("%.2f", res));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Solo se permiten valores numéricos en los campos de operaciones.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMate1.getText().trim().isEmpty() || txtMate2.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Debe diligenciar el Número 1 y el Número 2.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double n1 = Double.parseDouble(txtMate1.getText().replace(',', '.'));
                    double n2 = Double.parseDouble(txtMate2.getText().replace(',', '.'));
                    double res = n1 - n2;
                    txtResultado.setText("Resta: " + n1 + " - " + n2 + " = " + String.format("%.2f", res));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Solo se permiten valores numéricos en los campos de operaciones.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMate1.getText().trim().isEmpty() || txtMate2.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Debe diligenciar el Número 1 y el Número 2.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double n1 = Double.parseDouble(txtMate1.getText().replace(',', '.'));
                    double n2 = Double.parseDouble(txtMate2.getText().replace(',', '.'));
                    double res = n1 * n2;
                    txtResultado.setText("Multiplicación: " + n1 + " × " + n2 + " = " + String.format("%.2f", res));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Solo se permiten valores numéricos en los campos de operaciones.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMate1.getText().trim().isEmpty() || txtMate2.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Debe diligenciar el Número 1 y el Número 2.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double n1 = Double.parseDouble(txtMate1.getText().replace(',', '.'));
                    double n2 = Double.parseDouble(txtMate2.getText().replace(',', '.'));

                    if (n2 == 0) {
                        JOptionPane.showMessageDialog(null, "Error: No es posible dividir entre cero.", "División por Cero", JOptionPane.ERROR_MESSAGE);
                        txtResultado.setText("Indefinido: División por cero");
                        return;
                    }

                    double res = n1 / n2;
                    txtResultado.setText("División: " + n1 + " ÷ " + n2 + " = " + String.format("%.2f", res));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Solo se permiten valores numéricos en los campos de operaciones.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCtoF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTemp.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese el valor de temperatura en el campo correspondiente.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double c = Double.parseDouble(txtTemp.getText().replace(',', '.'));
                    double f = (c * 9.0 / 5.0) + 32.0;
                    txtResultado.setText(c + " °C equivalen a " + String.format("%.2f", f) + " °F");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: La temperatura debe ser un número válido.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnFtoC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTemp.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese el valor de temperatura en el campo correspondiente.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double f = Double.parseDouble(txtTemp.getText().replace(',', '.'));
                    double c = (f - 32.0) * 5.0 / 9.0;
                    txtResultado.setText(f + " °F equivalen a " + String.format("%.2f", c) + " °C");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: La temperatura debe ser un número válido.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnUsdToCop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMoneda.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese el valor a convertir en el campo de dinero.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double usd = Double.parseDouble(txtMoneda.getText().replace(',', '.'));
                    double cop = usd * TASA_COP;
                    txtResultado.setText("$" + usd + " USD = $" + String.format("%.2f", cop) + " COP (Tasa: $3200)");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: El monto de dinero debe ser un valor numérico.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCopToUsd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMoneda.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese el valor a convertir en el campo de dinero.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    double cop = Double.parseDouble(txtMoneda.getText().replace(',', '.'));
                    double usd = cop / TASA_COP;
                    txtResultado.setText("$" + cop + " COP = $" + String.format("%.2f", usd) + " USD (Tasa: $3200)");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: El monto de dinero debe ser un valor numérico.", "Dato Inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ventana.add(lblSecMate);
        ventana.add(lblMate1);
        ventana.add(txtMate1);
        ventana.add(lblMate2);
        ventana.add(txtMate2);
        ventana.add(btnSumar);
        ventana.add(btnRestar);
        ventana.add(btnMultiplicar);
        ventana.add(btnDividir);

        ventana.add(lblSecTemp);
        ventana.add(lblTemp);
        ventana.add(txtTemp);
        ventana.add(btnCtoF);
        ventana.add(btnFtoC);

        ventana.add(lblSecMoneda);
        ventana.add(lblMoneda);
        ventana.add(txtMoneda);
        ventana.add(btnUsdToCop);
        ventana.add(btnCopToUsd);

        ventana.add(lblResultadoTitulo);
        ventana.add(txtResultado);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
