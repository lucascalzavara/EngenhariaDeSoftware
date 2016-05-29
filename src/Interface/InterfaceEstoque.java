/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Programa.Estoque;
import DAO.DAOEstoque;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author koala_bolo
 */
public final class InterfaceEstoque extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceEstoque
     */
    
    public InterfaceEstoque() {
        initComponents();
        consultarTodos();
        setTitle("Estoque");
    }
    void consultarTodos(){
        ArrayList<Estoque> clis = new ArrayList<Estoque>();
          DAOEstoque c = new DAOEstoque();
          
        try {
            
            clis = (ArrayList<Estoque>) c.consultaTodos();
            
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        if( clis.isEmpty()){
            JOptionPane.showMessageDialog(null, "banco vazio");      
        }
        preencherTabela(clis);
    }
    public void preencherTabela(ArrayList<Estoque> clis){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Valor", "Quantidade", "Código Barra", "Marca", "Descrição", "Fornecedor", "Preço Custo", "Unidade", "Observações"});
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < clis.size(); i++) {
            fila[0] = clis.get(i).getValor();
            fila[1] = clis.get(i).getQtd();
            fila[2] = clis.get(i).getCdbarra();
            fila[3] = clis.get(i).getMarca();
            fila[4] = clis.get(i).getDescricao();
            fila[5] = clis.get(i).getFornecedor();
            fila[6] = clis.get(i).getPrecocusto();
            fila[7] = clis.get(i).getUn();
            fila[8] = clis.get(i).getObs();
            modelo.addRow(fila);
        }
        Tabela.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        descri = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código:");

        jLabel2.setText("Descrição:");

        jButton1.setText("Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabela);

        jButton2.setText("Incluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Alterar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Excluir ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Fechar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descri, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addComponent(cod))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3)
                        .addGap(31, 31, 31)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(descri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DAOEstoque c= new DAOEstoque();
        if (cod.getText().isEmpty() && descri.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Prencha o CNPJ ou Razão Social.");
            consultarTodos();
        }
        else if (cod.getText().isEmpty()) {
            ArrayList<Estoque> clis = new ArrayList<>();
             try {
                clis = (ArrayList<Estoque>)c.consultaCod(Integer.parseInt(cod.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro", "Mensagem", JOptionPane.ERROR_MESSAGE, null);
                cod.setText(null);
                return;
            }
            if(clis.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não encontrado", "Mensagem", JOptionPane.ERROR_MESSAGE, null);
                cod.setText(null);
                return;
            }
            preencherTabela(clis);
            cod.setText(null);
        }
        else {
            ArrayList<Estoque> clis = new ArrayList<>();
            
            try {
                clis = (ArrayList<Estoque>) c.consultaDescricao(descri.getText());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro");
            }
            if( clis.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não encontrado", "Mensagem", JOptionPane.ERROR_MESSAGE, null);
                return;        
            }
            preencherTabela(clis);
            descri.setText(null);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            new InserirEstoque(this).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         int selecionada = Tabela.getSelectedRow();
        if (selecionada == -1){
            JOptionPane.showMessageDialog(null, "Nenhum selecionado", "Mensagem", JOptionPane.ERROR_MESSAGE, null);
        }else{
            /*Estoque cli = new Estoque(Float.parseFloat((String) Tabela.getValueAt(selecionada, 1)), Integer.parseInt((String) Tabela.getValueAt(selecionada, 0)), 
            Integer.parseInt((String) Tabela.getValueAt(selecionada, 2)), Tabela.getValueAt(selecionada, 3).toString(), Tabela.getValueAt(selecionada, 4).toString(), 
            Tabela.getValueAt(selecionada, 5).toString(),Float.parseFloat((String) Tabela.getValueAt(selecionada, 6)), Tabela.getValueAt(selecionada, 7).toString(),
            Tabela.getValueAt(selecionada, 8).toString());
            new AlterarEstoque(cli, this).setVisible(true);    */      
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selecionada = Tabela.getSelectedRow();
        if (selecionada == -1){
            JOptionPane.showMessageDialog(null, "Nenhum selecionado", "Mensagem", JOptionPane.ERROR_MESSAGE, null);
        }else{
            String str = Tabela.getValueAt(selecionada, 1).toString();
            DAOEstoque c = new DAOEstoque();
            try {
                c.exclui(str);
                JOptionPane.showMessageDialog(null, "Excluido com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE, null);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir", "Mensagem", JOptionPane.ERROR_MESSAGE, null);
            }
        }
        consultarTodos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField descri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
