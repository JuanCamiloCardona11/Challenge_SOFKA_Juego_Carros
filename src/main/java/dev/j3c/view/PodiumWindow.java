
package dev.j3c.view;

import dev.j3c.domain.CarDriver;
import java.util.HashMap;
import java.util.Map;

public class PodiumWindow extends javax.swing.JFrame {
    
    private HashMap<Integer,CarDriver> driversResultMap;
    
    public PodiumWindow(Map<Integer, CarDriver> driversResultList) {
        super("Resultados Finales");
        initComponents();
        this.driversResultMap = (HashMap<Integer,CarDriver>) driversResultList;
        this.configWindow();
        this.setFinalPodium();
        this.setRestOfFinalPositions();
    }
    
    private void configWindow(){
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null); 
    }
    
    private void setRestOfFinalPositions() {
        if(this.driversResultMap.size() > 3){
            this.jTextAreaRestOfDrivers.setText("\t\tResultados de los otros corredores:\n\n");
            for(int i = 4 ; i < this.driversResultMap.size() ; i++){
                this.jTextAreaRestOfDrivers.append(this.driversResultMap.get(i).toString() + "\n");
                this.jTextAreaRestOfDrivers.append(this.driversResultMap.get(i).getVehicle().toString() + "\n\n");
            }
        } else {
            this.jTextAreaRestOfDrivers.setText("");
            this.jTextAreaRestOfDrivers.setEnabled(false);
        }
        
    }
    
    private void setFinalPodium(){
        this.jLabelFirstPlaceDriver.setText(this.driversResultMap.get(1).toString());
        this.jLabelFirstPlaceCar.setText(this.driversResultMap.get(1).getVehicle().toString());
        
        this.jLabelFirstPlaceDriver.setText(this.driversResultMap.get(2).toString());
        this.jLabelFirstPlaceCar.setText(this.driversResultMap.get(2).getVehicle().toString());
        
        this.jLabelFirstPlaceDriver.setText(this.driversResultMap.get(3).toString());
        this.jLabelFirstPlaceCar.setText(this.driversResultMap.get(3).getVehicle().toString());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelFirstPlaceDriver = new javax.swing.JLabel();
        jLabelSecondPlaceDriver = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelThirdPlaceDriver = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRestOfDrivers = new javax.swing.JTextArea();
        jLabelFirstPlaceCar = new javax.swing.JLabel();
        jLabelSecondPlaceCar = new javax.swing.JLabel();
        jLabelThirdPlaceCar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 219, 250));
        jPanel1.setForeground(new java.awt.Color(162, 219, 250));

        jLabel7.setIcon(new javax.swing.ImageIcon("/Users/administrator/Desktop/Cursos Desarrollo y BDD/AppJuegoCarros/src/main/java/dev/j3c/assets/1.png")); // NOI18N

        jLabel8.setBackground(new java.awt.Color(162, 219, 250));
        jLabel8.setFont(new java.awt.Font(".SF NS Text", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Resultados de la Carrera");

        jLabelFirstPlaceDriver.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jLabelFirstPlaceDriver.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFirstPlaceDriver.setText("Etiqueta para el primer puesto");

        jLabelSecondPlaceDriver.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jLabelSecondPlaceDriver.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSecondPlaceDriver.setText("Etiqueta para el segundo puesto");

        jLabel10.setIcon(new javax.swing.ImageIcon("/Users/administrator/Desktop/Cursos Desarrollo y BDD/AppJuegoCarros/src/main/java/dev/j3c/assets/2.png")); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon("/Users/administrator/Desktop/Cursos Desarrollo y BDD/AppJuegoCarros/src/main/java/dev/j3c/assets/3.png")); // NOI18N

        jLabelThirdPlaceDriver.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jLabelThirdPlaceDriver.setForeground(new java.awt.Color(0, 0, 0));
        jLabelThirdPlaceDriver.setText("Etiqueta para el tercer puesto");

        jTextAreaRestOfDrivers.setEditable(false);
        jTextAreaRestOfDrivers.setBackground(new java.awt.Color(162, 219, 250));
        jTextAreaRestOfDrivers.setColumns(20);
        jTextAreaRestOfDrivers.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jTextAreaRestOfDrivers.setRows(5);
        jScrollPane1.setViewportView(jTextAreaRestOfDrivers);

        jLabelFirstPlaceCar.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jLabelFirstPlaceCar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFirstPlaceCar.setText("Etiqueta para el primer puesto");

        jLabelSecondPlaceCar.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jLabelSecondPlaceCar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSecondPlaceCar.setText("Etiqueta para el segundo puesto");

        jLabelThirdPlaceCar.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jLabelThirdPlaceCar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelThirdPlaceCar.setText("Etiqueta para el tercer puesto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(162, 162, 162))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelThirdPlaceDriver)
                            .addComponent(jLabelThirdPlaceCar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFirstPlaceDriver)
                            .addComponent(jLabelFirstPlaceCar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSecondPlaceDriver)
                            .addComponent(jLabelSecondPlaceCar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabelFirstPlaceDriver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelFirstPlaceCar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelSecondPlaceDriver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelSecondPlaceCar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelThirdPlaceDriver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelThirdPlaceCar)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelFirstPlaceCar;
    private javax.swing.JLabel jLabelFirstPlaceDriver;
    private javax.swing.JLabel jLabelSecondPlaceCar;
    private javax.swing.JLabel jLabelSecondPlaceDriver;
    private javax.swing.JLabel jLabelThirdPlaceCar;
    private javax.swing.JLabel jLabelThirdPlaceDriver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaRestOfDrivers;
    // End of variables declaration//GEN-END:variables
}
