/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jhit.opendiabetesvault.fx.gui;

import de.jhit.openmediavault.app.data.VaultDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mswin
 */
public class LauncherFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Init DB
        VaultDao.initializeDb();

        // Setup Gui
        Parent root = FXMLLoader.load(getClass().getResource("MainGui.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
