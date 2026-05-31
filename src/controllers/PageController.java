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
import views.FormDNI;
import views.FormDNIOlvidado;
import views.FormNIE;
import views.Landing;
import views.Ayuda;
import views.Contacto;
import views.TuOpinion;

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
    public static final int TODO_OK = 9;
    
    
    public PageController(JPanel container, int viewTarget) {
        this.container = container;
        this.viewTarget = viewTarget;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BorderLayout layout = (BorderLayout) container.getLayout();
        Component current = layout.getLayoutComponent(BorderLayout.CENTER);
        
        if (current != null) {
            container.remove(current);
        }

        JPanel newPanel;
        newPanel = switch (viewTarget) {
            case LANDING -> Landing.getInstance();
            case ACCESO -> Acceso.getInstance();
            case FORMDNI -> FormDNI.getInstance();
            case FORMNIE -> FormNIE.getInstance();
            case FORMDNI_OLVIDADO -> FormDNIOlvidado.getInstance();
            case AYUDA -> Ayuda.getInstance();
            case CONTACTO -> Contacto.getInstance();
            case TU_OPINION -> TuOpinion.getInstance();
            default -> Landing.getInstance();
        };

        container.add(newPanel, BorderLayout.CENTER);
        
        container.revalidate();
        container.repaint();
        
        SwingUtilities.invokeLater(() -> {
            JScrollPane sp = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, container);
            if (sp != null) sp.getVerticalScrollBar().setValue(0);
        });
    }
}
