/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.User;

/**
 *
 * @author Diego
 */
public class MenuEquipment extends javax.swing.JPanel {
    User sessionUser;
    /**
     * Creates new form MenuEquipment
     */
    public MenuEquipment(User sessionUser) {
        initComponents();
        this.sessionUser=sessionUser;
        displayMenu(sessionUser.getCharge());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCircle1 = new org.edisoncor.gui.button.ButtonCircle();
        RegisterEquipmentButtom = new javax.swing.JButton();
        listEquipmentButtom = new javax.swing.JButton();
        editEquipmentButtom = new javax.swing.JButton();
        listLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        editLabel = new javax.swing.JLabel();

        buttonCircle1.setText("buttonCircle1");

        setBackground(new java.awt.Color(255, 255, 255));

        RegisterEquipmentButtom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RegistrarEquipo.png"))); // NOI18N
        RegisterEquipmentButtom.setBorderPainted(false);
        RegisterEquipmentButtom.setContentAreaFilled(false);
        RegisterEquipmentButtom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegisterEquipmentButtom.setPreferredSize(new java.awt.Dimension(130, 130));
        RegisterEquipmentButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterEquipmentButtomActionPerformed(evt);
            }
        });

        listEquipmentButtom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ListarEquipo.png"))); // NOI18N
        listEquipmentButtom.setBorderPainted(false);
        listEquipmentButtom.setContentAreaFilled(false);
        listEquipmentButtom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listEquipmentButtom.setPreferredSize(new java.awt.Dimension(130, 130));
        listEquipmentButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEquipmentButtomActionPerformed(evt);
            }
        });

        editEquipmentButtom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/EditarEquipo.png"))); // NOI18N
        editEquipmentButtom.setBorderPainted(false);
        editEquipmentButtom.setContentAreaFilled(false);
        editEquipmentButtom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editEquipmentButtom.setPreferredSize(new java.awt.Dimension(130, 130));
        editEquipmentButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEquipmentButtomActionPerformed(evt);
            }
        });

        listLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        listLabel.setForeground(new java.awt.Color(235, 30, 0));
        listLabel.setText("Listar Equipos");

        registerLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(235, 30, 0));
        registerLabel.setText("Registrar Equipos");

        editLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        editLabel.setForeground(new java.awt.Color(235, 30, 0));
        editLabel.setText("Editar Equipos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(listEquipmentButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editEquipmentButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(listLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(editLabel)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(RegisterEquipmentButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editEquipmentButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listEquipmentButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listLabel)
                    .addComponent(editLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(RegisterEquipmentButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerLabel)
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void displayMenu(String userCharge){
        switch (userCharge) {
        case "Administrador":
        listEquipmentButtom.setVisible(true);
        editEquipmentButtom.setVisible(true);
        RegisterEquipmentButtom.setVisible(true);
        break;
        case "Miembro":
        listEquipmentButtom.setVisible(true);
        editEquipmentButtom.setVisible(false);
        editLabel.setVisible(false);
        RegisterEquipmentButtom.setVisible(false);
        registerLabel.setVisible(false);
        break;
        case "Coordinador de Equipos":
        listEquipmentButtom.setVisible(true);
        editEquipmentButtom.setVisible(true);
        RegisterEquipmentButtom.setVisible(true);
        break;
        case "Lider de Proyecto":
        listEquipmentButtom.setVisible(true);
        editEquipmentButtom.setVisible(false);
        editLabel.setVisible(false);
        RegisterEquipmentButtom.setVisible(false);
        registerLabel.setVisible(false);
        break;
        case "Director de Laboratorio":
        listEquipmentButtom.setVisible(true);
        editEquipmentButtom.setVisible(true);
        RegisterEquipmentButtom.setVisible(true);
        break;
        default:
        System.out.println("error" );
        break;}      
}
    
    private void RegisterEquipmentButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterEquipmentButtomActionPerformed
        // TODO add your handling code here:
        
        RegisterEquipment registerEquipment = new RegisterEquipment(sessionUser);
        registerEquipment.setSize(639,483);
        registerEquipment.setLocation(0,0);
        
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(registerEquipment);
        
    }//GEN-LAST:event_RegisterEquipmentButtomActionPerformed

    private void editEquipmentButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEquipmentButtomActionPerformed
        // TODO add your handling code here:
        
        EditEquipment editarEquipment = new EditEquipment(sessionUser);
        editarEquipment.setSize(639,483);
        editarEquipment.setLocation(0,0);
        
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(editarEquipment);
        
    }//GEN-LAST:event_editEquipmentButtomActionPerformed

    private void listEquipmentButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEquipmentButtomActionPerformed
        // TODO add your handling code here:
        
        ListEquipment listEquipment = new ListEquipment(sessionUser);
        listEquipment.setSize(639,483);
        listEquipment.setLocation(0,0);
        
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(listEquipment);    
    }//GEN-LAST:event_listEquipmentButtomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegisterEquipmentButtom;
    private org.edisoncor.gui.button.ButtonCircle buttonCircle1;
    private javax.swing.JButton editEquipmentButtom;
    private javax.swing.JLabel editLabel;
    private javax.swing.JButton listEquipmentButtom;
    private javax.swing.JLabel listLabel;
    private javax.swing.JLabel registerLabel;
    // End of variables declaration//GEN-END:variables
}
