/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imobi.view;

import br.com.imobi.app.Main;
import br.com.imobi.model.Cliente;
import br.com.imobi.model.Imovel;
import br.com.imobi.model.Notificacao;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author dglsw
 */
public class ImoveisJDialog extends javax.swing.JDialog {

    private Imovel imovel;
    private boolean isEdit = false;

    //Construtor para novo
    public ImoveisJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initState();
    }

    //Construtor para editar
    public ImoveisJDialog(java.awt.Frame parent, boolean modal, Imovel imovel) {
        super(parent, modal);
        this.imovel = imovel;
        this.isEdit = true;
        initComponents();
        initState();
    }

    private void initState() {
        loadClientes();
        if (imovel != null) {
            loadInfos();
        }
    }

    private void loadInfos() {
        txtDescription.setText(imovel.getDescription());
        txtEndereco.setText(imovel.getEndereco());
        if(imovel.getCliente() != null){
            cmbCliente.setSelectedItem(imovel.getCliente());
        } else{
            cmbCliente.setSelectedIndex(0);
        }
        
        chkFavorite.setSelected(imovel.isFavorite());
    }

    private void loadClientes() {
        //Busca os usuários no banco
        String jpql = "SELECT u FROM Cliente u";
        TypedQuery<Cliente> query = Main.em.createQuery(jpql, Cliente.class);
        List<Cliente> thisList = query.getResultList();

        //Add lista de usuários a combobox
        //TODO: Configurar o .toString do objeto Usuário
        cmbCliente.addItem(new Cliente("Disponível", "", ""));
        for (Cliente u : thisList) {
            cmbCliente.addItem(u);
        }
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
        chkFavorite = new javax.swing.JCheckBox();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Descrição:");

        jLabel2.setText("Endereço:");

        chkFavorite.setText("Favorito");
        chkFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFavoriteActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chkFavorite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkFavorite)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFavoriteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkFavoriteActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!this.txtDescription.getText().isEmpty() && !this.txtEndereco.getText().isEmpty()) {
            Cliente c = cmbCliente.getItemAt(cmbCliente.getSelectedIndex());
            Imovel thisImovel = new Imovel(0, this.txtDescription.getText(), this.txtEndereco.getText(), Timestamp.from(Instant.now()), chkFavorite.isSelected(), c);
            System.out.println(imovel);

            if (isEdit) {
                //Envia mensagem pro banco
                try {
                    Imovel selectedImovel = Main.em.find(Imovel.class, imovel.getId());
                    if (selectedImovel != null) {
                        selectedImovel.setCliente(thisImovel.getCliente());
                        selectedImovel.setDescription(thisImovel.getDescription());
                        selectedImovel.setFavorite(thisImovel.isFavorite());
                        selectedImovel.setLastChange(thisImovel.getLastChange());
                        Main.em.getTransaction().begin();
                        Main.em.merge(selectedImovel);
                        Main.em.getTransaction().commit();
                        HomeJFrame.janelaImoveis.updateTable();
                    }
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Houve ume erro ao editar o imóvel: " + imovel.toString());
                };

                //Cria instancia de notificação
                Notificacao n = new Notificacao();
                n.setDescription("Imóvel editado por " + Main.uLogado.getLogin() + " | " + imovel.getDescription() + ", " + imovel.getEndereco());
                n.setTimestamp(Timestamp.from(Instant.now()));
                n.setUsuario(null);

                //Envia notificação pro banco
                try {
                    Main.em.getTransaction().begin();
                    Main.em.persist(n);
                    Main.em.getTransaction().commit();
                } catch (Exception e) {
                    System.out.println(e.toString());
                    JOptionPane.showMessageDialog(this, "Houve ume erro ao notificar!");
                }
            } else {
                //Envia mensagem pro banco
                try {
                    Main.em.getTransaction().begin();
                    Main.em.persist(thisImovel);
                    Main.em.getTransaction().commit();
                    HomeJFrame.janelaImoveis.updateTable();
                    this.dispose();
                } catch (Exception e) {
                    System.out.println(e.toString());
                    JOptionPane.showMessageDialog(this, "Houve ume erro ao inserir o imóvel: " + thisImovel.toString());
                };

                //Cria instancia de notificação
                Notificacao n = new Notificacao();
                n.setDescription("Novo imóvel cadastrado por " + Main.uLogado.getLogin() + " | " + thisImovel.getDescription() + ", " + thisImovel.getEndereco());
                n.setTimestamp(Timestamp.from(Instant.now()));
                n.setUsuario(null);

                //Envia notificação pro banco
                try {
                    Main.em.getTransaction().begin();
                    Main.em.persist(n);
                    Main.em.getTransaction().commit();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Houve ume erro ao notificar!");
                }
            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ImoveisJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImoveisJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImoveisJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImoveisJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ImoveisJDialog dialog = new ImoveisJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkFavorite;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEndereco;
    // End of variables declaration//GEN-END:variables
}
