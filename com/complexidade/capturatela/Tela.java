package com.complexidade.capturatela;


import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tela.java
 *
 * Created on 05/03/2011, 07:02:27
 */
/**
 *
 * @author rudieri
 */
public class Tela extends javax.swing.JFrame {

    private Captura captura;
    ChangeListener changeListener;

    /** Creates new form Tela */
    public Tela() {
        initComponents();
        captura = new Captura(500, 300, 300, 300, 5000);
        jSpinner_x.setValue(captura.getX());
        jSpinner_y.setValue(captura.getY());
        jSpinner_w.setValue(captura.getW());
        jSpinner_h.setValue(captura.getH());
        jSpinner_t.setValue(captura.getTempo());
        changeListener = new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                captura.setAll((Integer) jSpinner_x.getValue(), (Integer) jSpinner_y.getValue(), (Integer) jSpinner_w.getValue(), (Integer) jSpinner_h.getValue(), (Integer) jSpinner_t.getValue());
            }
        };
        setEvents(this.jPanelTela);

        if (!isVisible()) {
            this.setVisible(true);
        }

    }

    private void setEvents(JComponent c) {
        for (int i = 0; i < c.getComponentCount(); i++) {
            if (c.getComponent(i) instanceof JSpinner) {
                ((JSpinner) c.getComponent(i)).addChangeListener(changeListener);
            } else {
                if (c.getComponent(i) instanceof JPanel) {
                    setEvents((JComponent) c.getComponent(i));
                }
            }
        }
    }

    private void ligaDesliga() {
        boolean ligado = jToggleButton1.isSelected();
        if (ligado) {
            jToggleButton1.setText("Desligar");
            captura.comeca();
        } else {
            jToggleButton1.setText("Ligar");
            captura.para();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTela = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSpinner_x = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jSpinner_y = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSpinner_w = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jSpinner_h = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jSpinner_t = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelTela.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(5, 2));

        jLabel1.setText("X");
        jPanel3.add(jLabel1);

        jSpinner_x.setModel(new javax.swing.SpinnerNumberModel());
        jPanel3.add(jSpinner_x);

        jLabel3.setText("Y");
        jPanel3.add(jLabel3);

        jSpinner_y.setModel(new javax.swing.SpinnerNumberModel());
        jPanel3.add(jSpinner_y);

        jLabel4.setText("Largura");
        jPanel3.add(jLabel4);

        jSpinner_w.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(5), null, Integer.valueOf(1)));
        jPanel3.add(jSpinner_w);

        jLabel5.setText("Altura");
        jPanel3.add(jLabel5);

        jSpinner_h.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(5), null, Integer.valueOf(1)));
        jPanel3.add(jSpinner_h);

        jLabel6.setText("Tempo");
        jPanel3.add(jLabel6);

        jSpinner_t.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1000), Integer.valueOf(100), null, Integer.valueOf(1)));
        jPanel3.add(jSpinner_t);

        jPanelTela.add(jPanel3, java.awt.BorderLayout.CENTER);

        jToggleButton1.setText("Ligar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1);

        jPanelTela.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15));
        jLabel2.setText("Configurações");
        jPanel1.add(jLabel2);

        jPanelTela.add(jPanel1, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanelTela, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-338)/2, (screenSize.height-260)/2, 338, 260);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        ligaDesliga();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Tela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTela;
    private javax.swing.JSpinner jSpinner_h;
    private javax.swing.JSpinner jSpinner_t;
    private javax.swing.JSpinner jSpinner_w;
    private javax.swing.JSpinner jSpinner_x;
    private javax.swing.JSpinner jSpinner_y;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
