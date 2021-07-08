/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.j3c.view;

import dev.j3c.domain.CarDriver;
import javax.swing.JOptionPane;
import dev.j3c.model.DBController;
import dev.j3c.domain.RaceTrack;
import dev.j3c.domain.TrackLane;
import dev.j3c.domain.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author administrator
 */
public class Game extends javax.swing.JFrame {

    private DBController DBControl;
    private int gameStatus; 
    private RaceTrack currentRaceTrack;
    public Game() {
        super("CHALLENGE - JUEGO DE CARROS POR CONSOLA");
        this.gameStatus = 0;
        this.initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jButtonNewGame = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonCurrentGameDrivers = new javax.swing.JButton();
        jButtonGoAhead = new javax.swing.JButton();
        jButtonGameRepeat = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButtonDriversHistory = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonInputNewDriver = new javax.swing.JButton();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 219, 250));

        jButtonNewGame.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonNewGame.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNewGame.setText("Nuevo Juego");
        jButtonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Corredor 1", "Corredor 2", "Corredor 3", "Corredor 4", "Corredor 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font(".SF NS Text", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Lista de Corredores");

        jButtonCurrentGameDrivers.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonCurrentGameDrivers.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCurrentGameDrivers.setText("Ver Lista de Corredores");
        jButtonCurrentGameDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCurrentGameDriversActionPerformed(evt);
            }
        });

        jButtonGoAhead.setIcon(new javax.swing.ImageIcon("/Users/administrator/Desktop/Cursos Desarrollo y BDD/AppJuegoCarros/src/main/java/dev/j3c/assets/Car-Button.png")); // NOI18N
        jButtonGoAhead.setEnabled(false);
        jButtonGoAhead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoAheadActionPerformed(evt);
            }
        });

        jButtonGameRepeat.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonGameRepeat.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGameRepeat.setText("Repetir Juego");
        jButtonGameRepeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGameRepeatActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("/Users/administrator/Desktop/Cursos Desarrollo y BDD/AppJuegoCarros/src/main/java/dev/j3c/assets/Info-Button.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtonDriversHistory.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonDriversHistory.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDriversHistory.setText("Historial de Corredores");
        jButtonDriversHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDriversHistoryActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(0, 0, 0));
        jButtonExit.setText("Salir");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonInputNewDriver.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonInputNewDriver.setForeground(new java.awt.Color(0, 0, 0));
        jButtonInputNewDriver.setText("Ingresar Nuevo Corredor");
        jButtonInputNewDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInputNewDriverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonDriversHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCurrentGameDrivers, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(jButtonInputNewDriver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonGameRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jButtonExit))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jButtonGoAhead, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(201, 201, 201)
                        .addComponent(jButton7)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonGoAhead, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGameRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonInputNewDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonCurrentGameDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonDriversHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
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
    
    private int inputRaceTrackLength() {
        int lengthKM = 0;
        while(lengthKM <= 0) {
            try {
                lengthKM = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese una cantidad entera para la distancia a recorrer (en kilometros)","Longitud de la Carrera",3));
                if(lengthKM <= 0) JOptionPane.showMessageDialog(this, "La longitud ingresada es invalida, las carreras son de minimo 1 kilometro.","Longitud invalida",2);
            } catch(NumberFormatException ex1) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad numerica entera.","Formato de Dato Incorrecto",2);
            }
        }
        return(lengthKM);
    }
    
    private int inputNumberOfDrivers() {
        int numDrivers = -1;
        while(numDrivers < 3 || numDrivers > 20) {
            try {
                numDrivers = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingrese la cantidad de juegadores mayor o igual que 3 y menor o igual a 20.","Cantidad de Corredores",3));
                if(numDrivers < 3) JOptionPane.showMessageDialog(this, "Numero de corredores invalido, se requieren minimo 3.","Numero de Corredores Invalido",2);
                if(numDrivers > 20) JOptionPane.showMessageDialog(this, "Numero de corredores invalido, se requieren maximo 20.","Numero de Corredores Invalido",2);
            } catch(NumberFormatException ex1) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad numerica entera.","Formato de Dato Incorrecto",2);
            }
        }
        return(numDrivers);
    }
    
    private List<TrackLane> getDriversData(int numDrivers){
        List<TrackLane> trackLanesList = new ArrayList<>();
        for(int i = 0 ; i < numDrivers ; i++){
            CarDriver driver = DBControl.getRandomDriver();
            TrackLane trackLane = new TrackLane(driver, (i + 1));
            trackLanesList.add(trackLane);
        }
        return(trackLanesList);
    }
    
    private void createRaceTrack(){
        int raceLength = this.inputRaceTrackLength();
        int numDrivers = this.inputNumberOfDrivers();
        List<TrackLane> trackLanesList = this.getDriversData(numDrivers);
        this.currentRaceTrack = new RaceTrack(raceLength, trackLanesList);
    }
    
    private void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameActionPerformed
        int confirm = 0;
        if(this.gameStatus != 0) { 
            confirm = JOptionPane.showConfirmDialog(this,"Al iniciar el nuevo juego se perdera el progreso del juego actual, aun asi desea inicarlo? ","Iniciar un nuevo juego", 0);
        }
        if(confirm == 0) {
            this.gameStatus = 1;
            this.createRaceTrack();
        }
    }//GEN-LAST:event_jButtonNewGameActionPerformed

    private void jButtonCurrentGameDriversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCurrentGameDriversActionPerformed
        CurrentDriversWindow currentDriversListWindow = new CurrentDriversWindow(this.currentRaceTrack.getTrackLanesList());
    }//GEN-LAST:event_jButtonCurrentGameDriversActionPerformed

    private void jButtonGameRepeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGameRepeatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGameRepeatActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        HelpWindow helpWindow = new HelpWindow();
        helpWindow.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void drawNewRow(){
        
    }
    
    private void jButtonGoAheadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoAheadActionPerformed
        this.currentRaceTrack.goAhead();
        this.drawNewRow();
        if(this.currentRaceTrack.juegoTerminado()){
            this.jButtonGoAhead.setEnabled(false);
            this.gameStatus = 0;
        }
    }//GEN-LAST:event_jButtonGoAheadActionPerformed

    private void jButtonDriversHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDriversHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDriversHistoryActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        int confirm = 0;
        if(this.gameStatus != 0) { 
            confirm = JOptionPane.showConfirmDialog(this,"Al salir se perdera el progreso del juego actual, aun asi desea salir? ","Salir", 0);
        }
        if(confirm == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private String validateStringInput(String dato, int maxLength) {
        String fullName = "";
        while(!fullName.matches("^[a-zA-Z ]{3," + String.valueOf(maxLength) + "}$")){
            fullName = JOptionPane.showInputDialog(this,"Por favor ingrese " + dato + " del nuevo usuario: ","Ingreso de Datos del Nuevo Corredor",3);
        }
        return(fullName);
    }
  
    private void getNewDriverData(String driverUsername){
        String name = this.validateStringInput("el nombre", 100),
            nationality = this.validateStringInput("la nacionalidad",30),
            brand = this.validateStringInput("la marca del auto", 30),
            colour = this.validateStringInput("el color del auto", 30),
            model = this.validateStringInput("el modelo del auto", 30);
        Vehicle vehicle = new Vehicle(brand, colour, model);
        CarDriver carDriver = new CarDriver(driverUsername, name, vehicle, nationality);
        this.DBControl.addCarDriver(carDriver);
    }
    
    private void jButtonInputNewDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputNewDriverActionPerformed
        String driverUsername = JOptionPane.showInputDialog(this,"Ingrese el nombre de usuario que tendra el nuevo corredor : ","Ingreso de Nuevo Corredor",3);
        if(driverUsername.matches("^[a-z0-9_-]{3,50}$")){
            if(!this.DBControl.driverExists(driverUsername)){
                this.getNewDriverData(driverUsername);
            } else {
                JOptionPane.showMessageDialog(this, "El corredor con nombre de usuario: " + driverUsername + " ya se encuentra registrado en el sistema, intente con uno nuevo la siguiente vez.","Nombre de Usuario Existente.", 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El username debe tener el formato ^[a-z0-9_-]{3,50}$.","Formato invalido", 0);
        }
    }//GEN-LAST:event_jButtonInputNewDriverActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonCurrentGameDrivers;
    private javax.swing.JButton jButtonDriversHistory;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonGameRepeat;
    private javax.swing.JButton jButtonGoAhead;
    private javax.swing.JButton jButtonInputNewDriver;
    private javax.swing.JButton jButtonNewGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
