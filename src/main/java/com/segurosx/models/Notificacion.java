package com.segurosx.models;

import java.awt.*;

public class Notificacion {

    private String titulo;
    private String texto;

    public void display() throws AWTException {
        if (SystemTray.isSupported()) {
            this.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
    }

    public Notificacion(String titulo, String texto){
        this.titulo = titulo;
        this.texto = texto;
    }

    public void displayTray() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        //Image image = Toolkit.getDefaultToolkit().createImage("https://image.flaticon.com/icons/png/512/50/50268.png");
        Image image = Toolkit.getDefaultToolkit().createImage("com/segurosx/images/pay.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("https://image.flaticon.com/icons/png/512/50/50268.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System icon");
        tray.add(trayIcon);

        trayIcon.displayMessage(this.titulo, this.texto, TrayIcon.MessageType.INFO);
    }
}
