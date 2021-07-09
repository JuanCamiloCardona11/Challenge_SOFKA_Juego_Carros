
package dev.j3c.view;

import dev.j3c.controller.GameController;
import dev.j3c.domain.*;
import javax.swing.JOptionPane;
import java.util.List;

public class GameView extends javax.swing.JFrame {

    private int gameStatus; 
    private final GameController gameController;
    
    public GameView() {
        super("CHALLENGE - JUEGO DE CARROS POR CONSOLA - Sofka U");
        this.initComponents();
        this.configWindow();
        this.gameStatus = 0;
        this.gameController = new GameController();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jButtonNewGame = new javax.swing.JButton();
        jButtonCurrentGameDrivers = new javax.swing.JButton();
        jButtonGoAhead = new javax.swing.JButton();
        jButtonGameRepeat = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jButtonDriversHistory = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonInputNewDriver = new javax.swing.JButton();
        jButtonPodiumsHistory = new javax.swing.JButton();

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

        jButtonCurrentGameDrivers.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonCurrentGameDrivers.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCurrentGameDrivers.setText("Ver Lista de Corredores");
        jButtonCurrentGameDrivers.setEnabled(false);
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
        jButtonGameRepeat.setText("Reiniciar Juego");
        jButtonGameRepeat.setEnabled(false);
        jButtonGameRepeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGameRepeatActionPerformed(evt);
            }
        });

        jButtonHelp.setIcon(new javax.swing.ImageIcon("/Users/administrator/Desktop/Cursos Desarrollo y BDD/AppJuegoCarros/src/main/java/dev/j3c/assets/Info-Button.png")); // NOI18N
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
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

        jButtonPodiumsHistory.setFont(new java.awt.Font(".SF NS Text", 0, 15)); // NOI18N
        jButtonPodiumsHistory.setForeground(new java.awt.Color(0, 0, 0));
        jButtonPodiumsHistory.setText("Historial de Podiums");
        jButtonPodiumsHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPodiumsHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonGameRepeat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jButtonNewGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGoAhead, javax.swing.GroupLayout.PREFERRED_SIZE, 191, Short.MAX_VALUE))
                .addGap(99, 99, 99)
                .addComponent(jButtonHelp)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonPodiumsHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonDriversHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonCurrentGameDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonInputNewDriver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHelp)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonGoAhead, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonGameRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCurrentGameDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInputNewDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPodiumsHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDriversHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void configWindow(){
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void showDriversAdvances() { 
        String estadoActualCarrera = "";
        for(TrackLane tr : this.gameController.getCurrentRaceTrack().getTrackLanesList()){
            estadoActualCarrera += tr.getCarDriver().getName() + "  ";
            estadoActualCarrera += tr.getCarDriver().getNationality() + "  ";
            estadoActualCarrera += tr.getCarDriver().getVehicle().getBrand() + "  " + tr.getCarDriver().getVehicle().getModel() + "\n";
            estadoActualCarrera += "Distancia Recorrida: " + tr.getCarDriver().getVehicle().getCurrentDistance() + "\n\n";
        }
        RaceStatusWindow raceStatusWindowdow = new RaceStatusWindow(estadoActualCarrera);
        raceStatusWindowdow.setVisible(true);
    }
    
    private void createRaceTrack(){
        int raceLength = this.gameController.inputRaceTrackLength();
        int numDrivers = this.gameController.inputNumberOfDrivers();
        List<TrackLane> trackLanesList = this.gameController.getDriversData(numDrivers);
        RaceTrack newRaceTrack = new RaceTrack(raceLength, trackLanesList);
        this.gameController.setCurrentRaceTrack(newRaceTrack); 
    }
 
    private void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameActionPerformed
        int confirm = 0;
        if(this.gameStatus != 0) { 
            confirm = JOptionPane.showConfirmDialog(this,"Al iniciar el nuevo juego se perdera el progreso del juego actual, aun asi desea inicarlo? ","Iniciar un nuevo juego", 0);
        }
        if(confirm == 0) {
            this.jButtonGameRepeat.setEnabled(true);
            this.gameStatus = 1;
            this.jButtonGoAhead.setEnabled(true);
            this.jButtonCurrentGameDrivers.setEnabled(true);
            this.createRaceTrack();
        }
    }//GEN-LAST:event_jButtonNewGameActionPerformed
    
    private void jButtonCurrentGameDriversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCurrentGameDriversActionPerformed
        List<TrackLane> currentDriversList = this.gameController.getCurrentRaceTrack().getTrackLanesList();
        CurrentDriversWindow currentDriversWindow = new CurrentDriversWindow(currentDriversList);
        currentDriversWindow.setVisible(true);
    }//GEN-LAST:event_jButtonCurrentGameDriversActionPerformed

    private void jButtonGameRepeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGameRepeatActionPerformed
        int confirm = 0;
        if(this.gameStatus != 0) { 
            confirm = JOptionPane.showConfirmDialog(this,"Al reiniciar el juego se perdera el progreso actual, aun asi desea reiniciar este juego con los mismos jugadores? ","Reiniciar Juego", 0);
        }
        if(confirm == 0) {
            this.gameStatus = 1;
            this.jButtonGoAhead.setEnabled(true);
            this.jButtonCurrentGameDrivers.setEnabled(true);
            this.gameController.resetCurrentGame();
        }
    }//GEN-LAST:event_jButtonGameRepeatActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        HelpWindow helpWindow = new HelpWindow();
        helpWindow.setVisible(true);
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jButtonGoAheadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoAheadActionPerformed
        this.gameController.goAhead();
        this.showDriversAdvances();
        if(this.gameController.isGameFinished()){
            this.jButtonGoAhead.setEnabled(false);
            this.jButtonCurrentGameDrivers.setEnabled(false);
            this.gameStatus = 0;
            if(this.gameController.constructCurrentPodium()) {
                PodiumWindow podiumWindow = new PodiumWindow(this.gameController.getCurrentRaceTrack().getTrackLanesList());
                podiumWindow.setVisible(true);
            }    
        }
    }//GEN-LAST:event_jButtonGoAheadActionPerformed

    private void jButtonDriversHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDriversHistoryActionPerformed
        List<CarDriver> carDriversFullList = this.gameController.getFullListCarDrivers();
        System.out.println("*******" + carDriversFullList.size());
        DriversHistoryWindow driversHistoryWindow = new DriversHistoryWindow(carDriversFullList);
        driversHistoryWindow.setVisible(true);
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

    private void jButtonInputNewDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputNewDriverActionPerformed
        String driverUsername = JOptionPane.showInputDialog(this,"Ingrese el nombre de usuario que tendra el nuevo corredor: ","Ingreso de Nuevo Corredor",3);
        if(this.gameController.validateNewUsername(driverUsername)){
            this.gameController.getNewDriverData(driverUsername);
        }
    }//GEN-LAST:event_jButtonInputNewDriverActionPerformed

    private void jButtonPodiumsHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPodiumsHistoryActionPerformed
        List<Podium> podiumsFullList =  this.gameController.getFullListPodiums();
        PodiumsWindow podiumsWindow = new PodiumsWindow(podiumsFullList);
        podiumsWindow.setVisible(true);
    }//GEN-LAST:event_jButtonPodiumsHistoryActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCurrentGameDrivers;
    private javax.swing.JButton jButtonDriversHistory;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonGameRepeat;
    private javax.swing.JButton jButtonGoAhead;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonInputNewDriver;
    private javax.swing.JButton jButtonNewGame;
    private javax.swing.JButton jButtonPodiumsHistory;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
