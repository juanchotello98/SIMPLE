/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.EquipmentControl;
import Logic.Equipment;
import Logic.User;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Diego
 */
public class EditEquipmentForm extends javax.swing.JPanel {

    EquipmentControl equipmentControl;
    User sessionUser;
    
    public EditEquipmentForm(User sessionUser) {
        initComponents();
        equipmentControl = new EquipmentControl();
        this.sessionUser=sessionUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerLabel = new javax.swing.JLabel();
        editButtom = new javax.swing.JButton();
        newCodeLabel = new javax.swing.JLabel();
        newSerieTextField = new javax.swing.JTextField();
        newCodeTextField = new javax.swing.JTextField();
        newNameLabel = new javax.swing.JLabel();
        newStateComboBox = new javax.swing.JComboBox<>();
        newSerielNumber = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        newDescriptionTextArea = new javax.swing.JTextArea();
        newDescriptionLabel = new javax.swing.JLabel();
        newStateLabel = new javax.swing.JLabel();
        newNameTextField = new javax.swing.JTextField();
        backButtom = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 433));

        registerLabel.setBackground(new java.awt.Color(153, 153, 153));
        registerLabel.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(235, 30, 0));
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/EditarEquipoTitle.png"))); // NOI18N
        registerLabel.setAlignmentY(0.0F);
        registerLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        editButtom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GuardarButtom.png"))); // NOI18N
        editButtom.setBorderPainted(false);
        editButtom.setContentAreaFilled(false);
        editButtom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtomActionPerformed(evt);
            }
        });

        newCodeLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        newCodeLabel.setForeground(new java.awt.Color(235, 30, 0));
        newCodeLabel.setText("Codigo");

        newSerieTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        newSerieTextField.setMinimumSize(new java.awt.Dimension(6, 27));
        newSerieTextField.setPreferredSize(new java.awt.Dimension(6, 28));

        newCodeTextField.setEditable(false);
        newCodeTextField.setBackground(new java.awt.Color(204, 204, 204));
        newCodeTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        newCodeTextField.setMinimumSize(new java.awt.Dimension(6, 27));
        newCodeTextField.setPreferredSize(new java.awt.Dimension(6, 28));

        newNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        newNameLabel.setForeground(new java.awt.Color(235, 30, 0));
        newNameLabel.setText("Articulo");

        newStateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libre", "Ocupado", "Reservado", "Inactivo" }));
        newStateComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newStateComboBox.setMinimumSize(new java.awt.Dimension(28, 27));
        newStateComboBox.setPreferredSize(new java.awt.Dimension(28, 27));

        newSerielNumber.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        newSerielNumber.setForeground(new java.awt.Color(235, 30, 0));
        newSerielNumber.setText("Numero de serie");

        newDescriptionTextArea.setColumns(20);
        newDescriptionTextArea.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        newDescriptionTextArea.setRows(5);
        newDescriptionTextArea.setLineWrap(true);
        newDescriptionTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(newDescriptionTextArea);

        newDescriptionLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        newDescriptionLabel.setForeground(new java.awt.Color(235, 30, 0));
        newDescriptionLabel.setText("Descripcion");

        newStateLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        newStateLabel.setForeground(new java.awt.Color(235, 30, 0));
        newStateLabel.setText("Estado");

        newNameTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        newNameTextField.setMinimumSize(new java.awt.Dimension(6, 27));
        newNameTextField.setPreferredSize(new java.awt.Dimension(6, 28));

        backButtom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CancelarButton.png"))); // NOI18N
        backButtom.setBorderPainted(false);
        backButtom.setContentAreaFilled(false);
        backButtom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newCodeLabel)
                            .addComponent(newSerielNumber)
                            .addComponent(newNameLabel)
                            .addComponent(newStateLabel)
                            .addComponent(newDescriptionLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(backButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newSerieTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(newStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newCodeLabel)
                    .addComponent(newCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newNameLabel)
                    .addComponent(newNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newSerielNumber)
                    .addComponent(newSerieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newDescriptionLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newStateLabel)
                    .addComponent(newStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtomActionPerformed
        // TODO add your handling code here:
        String numberEquipment;
        String nameEquipment;
        String serieEquipment;
        String descriptionEquipment;
        String stateEquipment;

        if(newNameTextField.getText().length()>0 && newSerieTextField.getText().length()>0 && newDescriptionTextArea.getText().length()>0){

            numberEquipment=newCodeTextField.getText();
            nameEquipment=newNameTextField.getText();
            serieEquipment=newSerieTextField.getText();
            descriptionEquipment=newDescriptionTextArea.getText();
            stateEquipment=(String)newStateComboBox.getSelectedItem();

            int numFilas = equipmentControl.updateEquipment(numberEquipment,nameEquipment, serieEquipment, descriptionEquipment, stateEquipment);

            System.out.println ("Filas "+ numFilas);
            if (numFilas == 1){
                JOptionPane.showMessageDialog(null, "Equipo actualizado exitosamente");
                loadEditEquipment();
            }
            else {
                JOptionPane.showMessageDialog(null, "Ocurrio un problema al actualizar el Equipo");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor completa todos los campos");
        }
    }//GEN-LAST:event_editButtomActionPerformed

    private void backButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtomActionPerformed
        // TODO add your handling code here:
        EditEquipment editEquipment = new EditEquipment(sessionUser);
        editEquipment.setSize(639,483);
        editEquipment.setLocation(0,0);

        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(editEquipment);
    }//GEN-LAST:event_backButtomActionPerformed

    public void limpiar_texto(JPanel panel){
        for(int i = 0; panel.getComponents().length > i; i++){
            if(panel.getComponents()[i] instanceof JTextField){
                ((JTextField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JPasswordField){
                ((JPasswordField)panel.getComponents()[i]).setText("");
            }
        }
    }
    
    public void loadEditEquipment(){
        EditEquipment editarEquipment = new EditEquipment(sessionUser);
        editarEquipment.setSize(639,483);
        editarEquipment.setLocation(0,0);
        
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(editarEquipment);
    }
    
    public void setValues(String code, String name, String serial, String description, String state){
        
        newCodeTextField.setText(code);
        newNameTextField.setText(name);
        newSerieTextField.setText(serial);
        newDescriptionTextArea.setText(description);
        
       /* oldCodeTextField.setText(code);
        oldNameTextField.setText(name);
        oldSerieTextField.setText(serial);
        oldDescriptionTextArea.setText(description);
        oldStateTextField.setText(state);*/
        //stateEquipment=(String)newStateComboBox.getSelectedItem();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButtom;
    private javax.swing.JButton editButtom;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel newCodeLabel;
    private javax.swing.JTextField newCodeTextField;
    private javax.swing.JLabel newDescriptionLabel;
    private javax.swing.JTextArea newDescriptionTextArea;
    private javax.swing.JLabel newNameLabel;
    private javax.swing.JTextField newNameTextField;
    private javax.swing.JTextField newSerieTextField;
    private javax.swing.JLabel newSerielNumber;
    public static javax.swing.JComboBox<String> newStateComboBox;
    private javax.swing.JLabel newStateLabel;
    private javax.swing.JLabel registerLabel;
    // End of variables declaration//GEN-END:variables
}
