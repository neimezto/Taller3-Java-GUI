package taller3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalculadoraConversor {

    private static final double TASA_COP = 3200.0;

    private static JFrame ventana;
    private static JTextField txtResultado;

    public static void main(String[] args) {

        ventana = new JFrame("Taller 3 - Operaciones y Conversiones");
        ventana.setSize(520, 680);
        ventana.setLayout(null);
        ventana.setResizable(false);

        Font fuenteTitulo = new Font("Arial", Font.BOLD, 14);

        JLabel lblSecMate = new JLabel("--- 1. OPERACIONES MATEMÁTICAS ---");
        lblSecMate.setFont(fuenteTitulo);
        lblSecMate.setBounds(40, 20, 420, 25);

        JLabel lblMate1 = new JLabel("Número 1:");
        lblMate1.setBounds(40, 55, 100, 30);
        JTextField txtMate1 = new JTextField();
        txtMate1.setBounds(150, 55, 310, 30);
        txtMate1.setToolTipText("Primer número de la operación. Ejemplo: 25 o 12,5");

        JLabel lblMate2 = new JLabel("Número 2:");
        lblMate2.setBounds(40, 95, 100, 30);
        JTextField txtMate2 = new JTextField();
        txtMate2.setBounds(150, 95, 310, 30);
        txtMate2.setToolTipText("Segundo número de la operación. Ejemplo: 4 o 0,5");

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
        txtTemp.setToolTipText("Grados a convertir (°C o °F según el botón). Ejemplo: 36,5");

        JButton btnCtoF = new JButton("°C a °F");
        btnCtoF.setBounds(100, 275, 140, 35);

        JButton btnFtoC = new JButton("°F a °C");
        btnFtoC.setBounds(260, 275, 140, 35);

         JLabel lblSecMoneda = new JLabel("--- 3. CONVERSIÓN DE MONEDA (Tasa: $" + fmt(TASA_COP) + ") ---");
        lblSecMoneda.setFont(fuenteTitulo);
        lblSecMoneda.setBounds(40, 335, 420, 25);

        JLabel lblMoneda = new JLabel("Valor dinero:");
        lblMoneda.setBounds(40, 370, 100, 30);
        JTextField txtMoneda = new JTextField();
        txtMoneda.setBounds(150, 370, 310, 30);
        txtMoneda.setToolTipText("Monto a convertir (USD o COP según el botón). Ejemplo: 150");

        JButton btnUsdToCop = new JButton("USD a COP");
        btnUsdToCop.setBounds(100, 415, 140, 35);

        JButton btnCopToUsd = new JButton("COP a USD");
        btnCopToUsd.setBounds(260, 415, 140, 35);

        JLabel lblResultadoTitulo = new JLabel("Resultado en pantalla:");
        lblResultadoTitulo.setFont(fuenteTitulo);
        lblResultadoTitulo.setBounds(40, 480, 200, 25);

        txtResultado = new JTextField();
        txtResultado.setBounds(40, 510, 420, 45);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Arial", Font.BOLD, 15));

        JButton btnLimpiar = new JButton("Limpiar todo");
        btnLimpiar.setBounds(180, 575, 140, 35);
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMate1.setText("");
                txtMate2.setText("");
                txtTemp.setText("");
                txtMoneda.setText("");
                txtResultado.setText("");
                txtMate1.requestFocus();
            }
        });

        soloNumeros(txtMate1, true);
        soloNumeros(txtMate2, true);
        soloNumeros(txtTemp, true);
        soloNumeros(txtMoneda, false);

        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTemp.setText("");
                txtMoneda.setText("");
                Double n1 = leerNumero(txtMate1, "Número 1");
                if (n1 == null) return;
                Double n2 = leerNumero(txtMate2, "Número 2");
                if (n2 == null) return;
                txtResultado.setText("Suma: " + fmt(n1) + " + " + fmt(n2) + " = " + fmt(n1 + n2));
            }
        });

        btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTemp.setText("");
                txtMoneda.setText("");
                Double n1 = leerNumero(txtMate1, "Número 1");
                if (n1 == null) return;
                Double n2 = leerNumero(txtMate2, "Número 2");
                if (n2 == null) return;
                txtResultado.setText("Resta: " + fmt(n1) + " - " + fmt(n2) + " = " + fmt(n1 - n2));
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTemp.setText("");
                txtMoneda.setText("");
                Double n1 = leerNumero(txtMate1, "Número 1");
                if (n1 == null) return;
                Double n2 = leerNumero(txtMate2, "Número 2");
                if (n2 == null) return;
                txtResultado.setText("Multiplicación: " + fmt(n1) + " × " + fmt(n2) + " = " + fmt(n1 * n2));
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTemp.setText("");
                txtMoneda.setText("");
                Double n1 = leerNumero(txtMate1, "Número 1");
                if (n1 == null) return;
                Double n2 = leerNumero(txtMate2, "Número 2");
                if (n2 == null) return;

                if (n2 == 0) {
                    txtResultado.setText("");
                    JOptionPane.showMessageDialog(ventana,
                            "No es posible dividir entre cero.\nCambie el valor del campo \"Número 2\".",
                            "División por cero", JOptionPane.ERROR_MESSAGE);
                    txtMate2.requestFocus();
                    return;
                }
                txtResultado.setText("División: " + fmt(n1) + " ÷ " + fmt(n2) + " = " + fmt(n1 / n2));
            }
        });

        btnCtoF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMate1.setText("");
                txtMate2.setText("");
                txtMoneda.setText("");
                Double c = leerNumero(txtTemp, "Temperatura");
                if (c == null) return;
                double f = (c * 9.0 / 5.0) + 32.0;
                txtResultado.setText(fmt(c) + " °C equivalen a " + fmt(f) + " °F");
            }
        });

        btnFtoC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMate1.setText("");
                txtMate2.setText("");
                txtMoneda.setText("");
                Double f = leerNumero(txtTemp, "Temperatura");
                if (f == null) return;
                double c = (f - 32.0) * 5.0 / 9.0;
                txtResultado.setText(fmt(f) + " °F equivalen a " + fmt(c) + " °C");
            }
        });

        btnUsdToCop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMate1.setText("");
                txtMate2.setText("");
                txtTemp.setText("");
                Double usd = leerNumero(txtMoneda, "Valor dinero");
                if (usd == null) return;
                if (!esMontoValido(usd, txtMoneda)) return;
                double cop = usd * TASA_COP;
                txtResultado.setText("$" + fmt(usd) + " USD = $" + fmt(cop) + " COP (Tasa: $" + fmt(TASA_COP) + ")");
            }
        });

        btnCopToUsd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMate1.setText("");
                txtMate2.setText("");
                txtTemp.setText("");
                Double cop = leerNumero(txtMoneda, "Valor dinero");
                if (cop == null) return;
                if (!esMontoValido(cop, txtMoneda)) return;
                double usd = cop / TASA_COP;
                txtResultado.setText("$" + fmt(cop) + " COP = $" + fmt(usd) + " USD (Tasa: $" + fmt(TASA_COP) + ")");
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
        ventana.add(btnLimpiar);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    static boolean esNumeroValido(String texto) {
        return texto.matches("-?\\d+([.,]\\d+)?");
    }

    private static Double leerNumero(JTextField campo, String nombreCampo) {
        String texto = campo.getText().trim();

        if (texto.isEmpty()) {
            txtResultado.setText("");
            JOptionPane.showMessageDialog(ventana,
                    "El campo \"" + nombreCampo + "\" está vacío.\nDebe ingresar un valor para continuar.",
                    "Campo vacío", JOptionPane.WARNING_MESSAGE);
            campo.requestFocus();
            return null;
        }

        if (!esNumeroValido(texto)) {
            txtResultado.setText("");
            JOptionPane.showMessageDialog(ventana,
                    "El campo \"" + nombreCampo + "\" solo admite números.\n"
                    + "No se permiten letras ni caracteres especiales. Ejemplos válidos: 25, -8, 12,5",
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
            campo.requestFocus();
            return null;
        }

        double valor = Double.parseDouble(texto.replace(',', '.'));

        if (Double.isInfinite(valor)) {
            txtResultado.setText("");
            JOptionPane.showMessageDialog(ventana,
                    "El valor del campo \"" + nombreCampo + "\" es demasiado grande.",
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
            campo.requestFocus();
            return null;
        }
        return valor;
    }

    private static boolean esMontoValido(double monto, JTextField campo) {
        if (monto < 0) {
            txtResultado.setText("");
            JOptionPane.showMessageDialog(ventana,
                    "El valor de dinero no puede ser negativo.",
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
            campo.requestFocus();
            return false;
        }
        return true;
    }

    private static void soloNumeros(JTextField campo, boolean permiteNegativo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                boolean permitido = Character.isDigit(c) || c == '.' || c == ','
                        || (permiteNegativo && c == '-')
                        || Character.isISOControl(c);
                if (!permitido) {
                    e.consume();
                }
            }
        });
    }

    static String fmt(double valor) {
        return String.format(Locale.US, "%.2f", valor + 0.0);
    }
}
