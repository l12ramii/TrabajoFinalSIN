/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import views.Acceso;
import views.Landing;

/**
 *
 * @author aramo
 */
public class PageController implements ActionListener {

    private final JPanel container;
    private final int viewTarget;
    public static final int LANDING = 1;
    public static final int ACCESO = 2;
    public static final int FORMDNI = 3;
    public static final int FORMNIE = 4;
    public static final int FORMDNI_OLVIDADO = 5;
    public static final int AYUDA = 6;
    public static final int CONTACTO = 7;
    public static final int TU_OPINION = 8;
    
    
    public PageController(JPanel container, int viewTarget) {
        this.container = container;
        this.viewTarget = viewTarget;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Identificar y remover el panel que está actualmente en el centro
        BorderLayout layout = (BorderLayout) container.getLayout();
        Component current = layout.getLayoutComponent(BorderLayout.CENTER);
        
        if (current != null) {
            container.remove(current);
        }

        // 2. Seleccionar la nueva instancia (usando tu lógica de Singleton)
        JPanel newPanel;
        newPanel = switch (viewTarget) {
            case LANDING -> Landing.getInstance();
            case ACCESO -> Acceso.getInstance();
                //case 3 -> PanelCita.getInstance();
            default -> Landing.getInstance();
        };

        // 3. Inyectar el nuevo panel y refrescar
        container.add(newPanel, BorderLayout.CENTER);
        
        // Forzar actualización de la UI
        container.revalidate();
        container.repaint();
        
        SwingUtilities.invokeLater(() -> {
            JScrollPane sp = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, container);
            if (sp != null) sp.getVerticalScrollBar().setValue(0);
        });
    }
}