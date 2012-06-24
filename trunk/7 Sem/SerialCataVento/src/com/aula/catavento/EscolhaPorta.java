/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EscolhaPorta.java
 *
 * Created on 30/06/2011, 15:52:26
 */
package com.aula.catavento;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Veríssimo
 */
public class EscolhaPorta extends javax.swing.JDialog {

    /**
     * Creates new form EscolhaPorta
     */
    private byte botaoClicado;
    public static final byte BOTAO_OK = 0;
    public static final byte BOTAO_CANCELAR = 1;
    public static final byte BOTAO_ERRO = 2;
    public EscolhaPorta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Enumeration portIdentifiers = CommPortIdentifier.getPortIdentifiers();
        if (!portIdentifiers.hasMoreElements()) {
            model.addElement("Nenhuma porta encontrada.");
            jButton2.setEnabled(false);
        }
        while (portIdentifiers.hasMoreElements()) {
            CommPortIdentifier pid = (CommPortIdentifier) portIdentifiers.nextElement();
            if (pid.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                model.addElement(pid.getName());
                break;
            }
        }
        jComboBox1.setModel(model);
    }

    public byte getBotaoClicado() {
        return botaoClicado;
    }
    
    

    public static void main(String[] args) {
        new EscolhaPorta(null, true).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Porta:");

        jButton1.setMnemonic('c');
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setMnemonic('O');
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-214)/2, (screenSize.height-126)/2, 214, 126);
    }// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            botaoClicado = BOTAO_CANCELAR;
            dispose();
	}//GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            Enumeration portIdentifiers = CommPortIdentifier.getPortIdentifiers();
            while (portIdentifiers.hasMoreElements()) {
                CommPortIdentifier pid = (CommPortIdentifier) portIdentifiers.nextElement();
                if (pid.getName().equals(jComboBox1.getModel().getSelectedItem().toString())) {
                    portId = pid;
                    botaoClicado = BOTAO_OK;
                    dispose();
                    return;
                }
            }
	}//GEN-LAST:event_jButton2ActionPerformed
    public CommPortIdentifier portId = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
