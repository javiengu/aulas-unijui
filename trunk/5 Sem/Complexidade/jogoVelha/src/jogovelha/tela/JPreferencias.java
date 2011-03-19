/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPreferencias.java
 *
 * Created on 19/03/2011, 11:43:17
 */
package jogovelha.tela;

import jogovelha.tabuleiro.Tabuleiro;

/**
 *
 * @author rudieri
 */
public class JPreferencias extends javax.swing.JDialog {

    private TelaVelha telaVelha;

    /** Creates new form JPreferencias */
    public JPreferencias(TelaVelha parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.telaVelha = parent;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_Jogador = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2));

        jLabel1.setText("Quem começa o jogo: ");
        jPanel1.add(jLabel1);

        jComboBox_Jogador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Humano", "Computador" }));
        jComboBox_Jogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_JogadorActionPerformed(evt);
            }
        });
        jComboBox_Jogador.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox_JogadorPropertyChange(evt);
            }
        });
        jPanel1.add(jComboBox_Jogador);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_JogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_JogadorActionPerformed
        // TODO add your handling code here:
        //        telaVelha.quemComeca
    }//GEN-LAST:event_jComboBox_JogadorActionPerformed

    private void jComboBox_JogadorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox_JogadorPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_JogadorPropertyChange

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (((String) jComboBox_Jogador.getSelectedItem()).equalsIgnoreCase("humano")) {
            telaVelha.quemComeca = Tabuleiro.JOGADOR_COMPUTADOR;
        } else {
            telaVelha.quemComeca = Tabuleiro.JOGADOR_HUMANO;
        }
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox_Jogador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
