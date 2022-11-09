import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaz extends JFrame implements ActionListener {
    public JTextField monitor = new JTextField();
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
        limpiar.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enviar) {
            try {
                String numero = monitor.getText();
                if(numero.equals("")) {
                    JOptionPane.showMessageDialog(null, "Se debe escribir un número para enviar al servidor");
                    return;
                }
                this.implementacion.agregar(Double.parseDouble(monitor.getText()));
                JOptionPane.showMessageDialog(null, numero + " enviado con exito al servidor, esperando resultados");
                monitor.setText("");
                monitor.setEditable(false);
                enviar.setEnabled(false);
                limpiar.setEnabled(true);
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "Error en el envío de datos");
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == suma) {
            try {
                if(this.implementacion.verificar()) {
                    double resultado = this.implementacion.suma(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    monitor.setText(implementacion.obtenerNum1() + " + " + this.implementacion.obtenerNum2() + " = " + resultado);
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
                    double resultado = this.implementacion.resta(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    monitor.setText(this.implementacion.obtenerNum1() + " - " + this.implementacion.obtenerNum2() + " = "  + resultado);
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
                    Double resultado = this.implementacion.multiplicacion(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    monitor.setText(this.implementacion.obtenerNum1() + " * " + this.implementacion.obtenerNum2() + " = "  + resultado);
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
                    double resultado = this.implementacion.division(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    monitor.setText(this.implementacion.obtenerNum1() + " / " + this.implementacion.obtenerNum2() + " = "  + resultado);
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
                    monitor.setText(this.implementacion.obtenerNum1() + " % " + this.implementacion.obtenerNum2() + " = "  + res);
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
                    double resultado = this.implementacion.potencia(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    monitor.setText(this.implementacion.obtenerNum1() + " ^ " + this.implementacion.obtenerNum2() + " = "  + resultado);
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
                    double resultado = this.implementacion.raiz(this.implementacion.obtenerNum1(), this.implementacion.obtenerNum2());
                    monitor.setText(this.implementacion.obtenerNum1() + " √ " + this.implementacion.obtenerNum2() + " = "  + resultado);
                    return;
                }
                JOptionPane.showMessageDialog(null, "El otro usuario no a enviado su respectivo número");
            } catch (RemoteException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(e.getSource() == limpiar) {
            monitor.setText("");
            monitor.setEditable(true);
            enviar.setEnabled(true);
            limpiar.setEnabled(false);
        }
    }
}
