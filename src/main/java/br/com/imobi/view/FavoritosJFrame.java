/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imobi.view;

import br.com.imobi.app.Main;
import br.com.imobi.app.Util;
import br.com.imobi.model.Imovel;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dglsw
 */
public class FavoritosJFrame extends javax.swing.JInternalFrame {

    private final String[] columns = {"Código", "Imóvel", "Endereço", "Cliente", "Última atualização", "Favorito"};
    private DefaultTableModel dtm;

    /**
     * Creates new form NotificacoesJFrame
     */
    public FavoritosJFrame() {
        initComponents();
        initState();
    }
    
    private void initState() {
        dtm = new DefaultTableModel(columns, 0);
        tblImoveis.setModel(dtm);
        tblImoveis.setDefaultEditor(Imovel.class, null);
        updateTable();
    }
    
    public void updateTable() {
        
        //Limpar tabela
        while (tblImoveis.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        //setar títulos
        dtm = new DefaultTableModel(columns, 0);

        String jpql = "SELECT m FROM Imovel m WHERE m.favorite = true";
        TypedQuery<Imovel> query = Main.em.createQuery(jpql, Imovel.class);
        List<Imovel> thisList = query.getResultList();

        //add linhas
        for (Imovel m : thisList) {
            String isFavorite;
            if (m.isFavorite()) {
                isFavorite = "Sim";
            } else {
                isFavorite = "Não";
            }
            
            String cliente;
            if(m.getCliente() != null){
                System.out.println(m.toString());
                cliente = m.getCliente().getNome();
            }else{
                cliente = "Disponível";
            }
            
            String[] row = {String.valueOf(m.getId()), m.getDescription(), m.getEndereco(), cliente, m.getLastChange().toString(), isFavorite};
            dtm.addRow(row);
        }
        tblImoveis.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblImoveis = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Favoritos");
        setVisible(true);

        tblImoveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descrição", "Imóvel", "Data", "Hora"
            }
        ));
        tblImoveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImoveisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblImoveis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        setBounds(0, 0, 903, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void tblImoveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImoveisMouseClicked
        if (tblImoveis.getSelectedRow() != -1) {
            String id = (String) dtm.getValueAt(tblImoveis.getSelectedRow(), 0);
            Util.print(String.valueOf(id));

            String jpql = "SELECT m FROM Imovel m WHERE m.id = :id";
            TypedQuery<Imovel> query = Main.em.createQuery(jpql, Imovel.class);
            query.setParameter("id", Integer.valueOf(id));
            Imovel imovel = query.getSingleResult();
            HomeJFrame.selectedImovel = imovel;
            Util.print(HomeJFrame.selectedImovel.getDescription());
        }
    }//GEN-LAST:event_tblImoveisMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblImoveis;
    // End of variables declaration//GEN-END:variables
}
