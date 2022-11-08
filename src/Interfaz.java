import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaz extends JFrame implements ActionListener {
    public JLabel texto = new JLabel("Seleccione una operación:");
    public JLabel texto1 = new JLabel("Ingresa el número deseado:");
    public JTextField monitor = new JTextField();
    public JTextArea resultado = new JTextArea();
    public JButton enviar = new JButton("Enviar");
    public JButton limpiar = new JButton("Limpiar");
    public JButton suma = new JButton("+");
    public JButton resta = new JButton("-");
    public JButton multiplicación = new JButton("x");
    public JButton division = new JButton("/");
    public JButton modulo = new JButton("%");
    public JButton potencia = new JButton("^");
    public JButton raiz = new JButton("√");
    Operaciones implementacion;

    Interfaz(Operaciones operaciones) {
        this.implementacion = operaciones;
        setTitle("CALCULADORA");
        setSize(295, 380);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(new java.awt.Color(185,245,248));
        setLayout(null);
        componentes();
        enviar.addActionListener(this);
        limpiar.addActionListener(this);
        suma.addActionListener(this);
        resta.addActionListener(this);
        multiplicación.addActionListener(this);
        division.addActionListener(this);
        modulo.addActionListener(this);
        potencia.addActionListener(this);
        raiz.addActionListener(this);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void componentes() {
        monitor.setBounds(10, 10, 200, 50);
        monitor.setEditable(true);
        add(monitor);

        enviar.setBounds(220, 10, 65, 50);
        add(enviar);

        suma.setBounds(10, 70, 85, 85);
        add(suma);

        resta.setBounds(10, 165, 85, 85);
        add(resta);

        multiplicación.setBounds(105, 70, 85, 85);
        add(multiplicación);

        division.setBounds(105, 165, 85, 85);
        add(division);

        potencia.setBounds(200, 70, 85, 85);
        add(potencia);

        raiz.setBounds(200, 165, 85, 85);
        add(raiz);

        modulo.setBounds(200, 260, 85, 85);
        add(modulo);

        limpiar.setBounds(10,260,180,85);
        add(limpiar);

        texto1.setBounds(520,20,180,25);
        add(texto1);

        texto.setBounds(520,100,180,25);
        add(texto);

        resultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultado);
        scroll.setBounds(20,300,150,45);
        add(scroll);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enviar) {
            try {
                String texto = monitor.getText();
                if(texto.equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe escribir el numero que desea enviar al servidor");
                    return;
                }
                this.implementacion.agregar(Double.parseDouble(monitor.getText()));
                JOptionPane.showMessageDialog(null, "El número " + texto + " a sido enviado al servidor");
                JOptionPane.showMessageDialog(null, "Esperando resultados");
                monitor.setText("");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == suma) {
            try {
                if(this.implementacion.verificar()) {
                    double result = this.implementacion.suma(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    String res = Double.toString(result);
                    resultado.setText("La suma de " + implementacion.obtenerNum1() + " + " + this.implementacion.obtenerNum2() + " es " + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == resta) {
            try {
                if(this.implementacion.verificar()) {
                    double result = this.implementacion.resta(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    String res = Double.toString(result);
                    resultado.setText("La resta de: " + this.implementacion.obtenerNum1() + " - " + this.implementacion.obtenerNum2() + " es "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == multiplicación) {
            try {
                if(this.implementacion.verificar()){
                    Double result = this.implementacion.multiplicacion(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    String res = Double.toString(result);
                    resultado.setText("La multiplicación de: " + this.implementacion.obtenerNum1() + " * " + this.implementacion.obtenerNum2() + " es "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == division) {
            try {
                if(this.implementacion.verificar()) {
                    double result = this.implementacion.division(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    String res = Double.toString(result);
                    resultado.setText("La división de: " + this.implementacion.obtenerNum1() + " / " + this.implementacion.obtenerNum2() + " es "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == modulo) {
            try {
                if(this.implementacion.verificar()){
                    double result = this.implementacion.modulo(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    String res = Double.toString(result);
                    resultado.setText("El modulo de: " + this.implementacion.obtenerNum1() + " % " + this.implementacion.obtenerNum2() + " es "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == potencia) {
            try {
                if(this.implementacion.verificar()) {
                    double result = this.implementacion.potencia(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    String res = Double.toString(result);
                    resultado.setText("La potencia de: " + this.implementacion.obtenerNum1() + " ^ " + this.implementacion.obtenerNum2() + " es "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == raiz) {
            try {
                if(this.implementacion.verificar()) {
                    double result = this.implementacion.raiz(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    String res = Double.toString(result);
                    resultado.setText("La raiz de: " + this.implementacion.obtenerNum1() + " √ " + this.implementacion.obtenerNum2() + " es "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == limpiar) {
            monitor.setText("");
            resultado.setText("");
        }
    }
}
