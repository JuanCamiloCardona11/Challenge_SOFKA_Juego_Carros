
package dev.j3c.view;

import dev.j3c.domain.TrackLane;
import java.util.List;

public class CurrentDriversWindow extends javax.swing.JFrame {

    List<TrackLane> currentDriversList; 
    
    public CurrentDriversWindow(List<TrackLane> currentDriversList) {
        initComponents();
        this.currentDriversList = currentDriversList;
        this.configWindow();
        this.setUpCurrDriversList();
    }

    private void configWindow(){
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null); 
    }
    
    private void setUpCurrDriversList(){
        String listaCorredores = "";
        for(TrackLane trackLane : currentDriversList) {
            listaCorredores += "Carril: " + trackLane.getTrackLaneNumber() + "\n";
            listaCorredores += "Nombre de Usuario: " + trackLane.getCarDriver().getUsername() + "\n";
            listaCorredores += "Nombre Completo: " + trackLane.getCarDriver().getName() + "\n";
            listaCorredores += "Nacionalidad: " + trackLane.getCarDriver().getNationality() + "\n";
            listaCorredores += "Marca: " + trackLane.getCarDriver().getVehicle().getBrand()+ "\n";
            listaCorredores += "Modelo: " + trackLane.getCarDriver().getVehicle().getModel()+ "\n";
            listaCorredores += "Color: " + trackLane.getCarDriver().getVehicle().getColour()+ "\n\n";
        }
        this.jTextAreaCurrDrivers.setText(listaCorredores);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCurrDrivers = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 219, 250));

        jLabel1.setFont(new java.awt.Font(".SF NS Text", 0, 18)); // NOI18N
        jLabel1.setText("Lista de Corredores en la Actual Carrera");

        jTextAreaCurrDrivers.setBackground(new java.awt.Color(250, 235, 224));
        jTextAreaCurrDrivers.setColumns(20);
        jTextAreaCurrDrivers.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jTextAreaCurrDrivers.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCurrDrivers);

        jButton1.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCurrDrivers;
    // End of variables declaration//GEN-END:variables
}
