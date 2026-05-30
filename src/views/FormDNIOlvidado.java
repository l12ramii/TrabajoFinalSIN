/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.toedter.calendar.JDateChooser;
import controllers.PageController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author aramo
 */
public class FormDNIOlvidado extends javax.swing.JPanel {

    private static FormDNIOlvidado instance;

    // Componentes del Formulario (Declarados como campos de clase)
    private JTextField txtDNI, txtNombre, txtApellido1, txtApellido2, txtPadre, txtMadre, txtEmail, txtEmail2;
    private JComboBox<String> comboProvincia;
    private JDateChooser dateNacimiento;
    private JButton btnEnviar;
    private JPanel card;

    /**
     * Creates new form FormDNIRobado
     */
    public FormDNIOlvidado() {

        // 1. Configuración Base
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        // 2. Card Central
        card = new JPanel();
        card.setBackground(new Color(231, 240, 247));
        card.setBorder(BorderFactory.createLineBorder(new Color(184, 209, 229), 2, true));
        card.setPreferredSize(new Dimension(600, 400));
        card.setLayout(new GridBagLayout());

        Font fuenteLabels = new Font("Arial", Font.PLAIN, 14);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 15, 4, 15);

        // --- TÍTULO ---
        JLabel title = new JLabel("Formulario por Pérdida o Robo", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(15, 0, 20, 0);
        card.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(3, 15, 3, 15);

        // --- FORMULARIO ---
        // DNI
        gbc.gridy = 1;
        gbc.gridx = 0;
        card.add(crearLabel("DNI y Letra:", fuenteLabels), gbc);
        txtDNI = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtDNI, gbc);

        // Nombre
        gbc.gridy = 2;
        gbc.gridx = 0;
        card.add(crearLabel("Nombre:", fuenteLabels), gbc);
        txtNombre = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtNombre, gbc);

        // Apellidos
        gbc.gridy = 3;
        gbc.gridx = 0;
        card.add(crearLabel("Primer Apellido:", fuenteLabels), gbc);
        txtApellido1 = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtApellido1, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        card.add(crearLabel("Segundo Apellido:", fuenteLabels), gbc);
        txtApellido2 = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtApellido2, gbc);

        // Filiación
        gbc.gridy = 5;
        gbc.gridx = 0;
        card.add(crearLabel("Hijo/a de (Padre):", fuenteLabels), gbc);
        txtPadre = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtPadre, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        card.add(crearLabel("Hijo/a de (Madre):", fuenteLabels), gbc);
        txtMadre = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtMadre, gbc);

        // Nacimiento
        gbc.gridy = 7;
        gbc.gridx = 0;
        card.add(crearLabel("Fecha de Nacimiento:", fuenteLabels), gbc);
        dateNacimiento = new JDateChooser(null, null, null, null);
        dateNacimiento.setDateFormatString("dd/MM/yyyy");
        gbc.gridx = 1;
        card.add(dateNacimiento, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        card.add(crearLabel("Lugar de Nacimiento:", fuenteLabels), gbc);
        comboProvincia = new JComboBox<>(getProvincias());
        gbc.gridx = 1;
        card.add(comboProvincia, gbc);

        // Email
        gbc.gridy = 9;
        gbc.gridx = 0;
        card.add(crearLabel("Correo Electrónico:", fuenteLabels), gbc);
        txtEmail = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtEmail, gbc);

        gbc.gridy = 10;
        gbc.gridx = 0;
        card.add(crearLabel("Repetir Correo:", fuenteLabels), gbc);
        txtEmail2 = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtEmail2, gbc);

        // --- IMAGEN LATERAL ---
        JLabel lblImg = new JLabel();
        try {
            lblImg.setIcon(utils.Utils.getScaledIcon("/images/ayuda_perdida.png", 300));
        } catch (Exception e) {
            lblImg.setText("[Imagen Ayuda]");
        }
        GridBagConstraints gbcImg = new GridBagConstraints();
        gbcImg.gridx = 2;
        gbcImg.gridy = 1;
        gbcImg.gridheight = 8;
        gbcImg.insets = new Insets(0, 20, 0, 10);
        card.add(lblImg, gbcImg);

        // --- BOTÓN ENVIAR ---
        btnEnviar = new JButton("Enviar Datos");
        btnEnviar.setOpaque(true);
        btnEnviar.setContentAreaFilled(true);
        btnEnviar.setBorderPainted(false);
        btnEnviar.setBackground(new Color(0, 51, 132));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEnviar.setPreferredSize(new Dimension(220, 45));
        btnEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviar.setBackground(new Color(0, 70, 190));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviar.setBackground(new Color(0, 51, 132));
            }
        });

        gbc.gridy = 11;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 20, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        card.add(btnEnviar, gbc);

        add(card);
        configurarValidacion();
    }

    private void configurarValidacion() {
        btnEnviar.addActionListener(e -> {
            StringBuilder errores = new StringBuilder();
            boolean ok = true;

            // 1. DNI
            if (!validarDNIOficial(txtDNI.getText().trim())) {
                errores.append("- El DNI introducido no es válido.\n");
                marcarError(txtDNI);
                ok = false;
            } else {
                restablecerEstilo(txtDNI);
            }

            // 2. Nombre y Apellidos
            if (txtNombre.getText().trim().isEmpty()) {
                errores.append("- El nombre es obligatorio.\n");
                marcarError(txtNombre);
                ok = false;
            } else {
                restablecerEstilo(txtNombre);
            }

            if (txtApellido1.getText().trim().isEmpty()) {
                errores.append("- El primer apellido es obligatorio.\n");
                marcarError(txtApellido1);
                ok = false;
            } else {
                restablecerEstilo(txtApellido1);
            }
            if (txtApellido2.getText().trim().isEmpty()) {
                errores.append("- El segundo apellido es obligatorio.\n");
                marcarError(txtApellido2);
                ok = false;
            } else {
                restablecerEstilo(txtApellido2);
            }

            // 3. Filiación
            if (txtPadre.getText().trim().isEmpty()) {
                errores.append("- Debe indicar el nombre del padre.\n");
                marcarError(txtPadre);
                ok = false;
            } else {
                restablecerEstilo(txtPadre);
            }

            if (txtMadre.getText().trim().isEmpty()) {
                errores.append("- Debe indicar el nombre de la madre.\n");
                marcarError(txtMadre);
                ok = false;
            } else {
                restablecerEstilo(txtMadre);
            }

            // 4. Fecha Nacimiento
            if (dateNacimiento.getDate() == null) {
                errores.append("- Seleccione su fecha de nacimiento.\n");
                dateNacimiento.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                ok = false;
            } else {
                dateNacimiento.setBorder(null);
            }

            // 5. Emails
            String email1 = txtEmail.getText().trim();
            String email2 = txtEmail2.getText().trim();
            if (!email1.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                errores.append("- Correo electrónico no válido.\n");
                marcarError(txtEmail);
                ok = false;
            } else if (!email1.equals(email2)) {
                errores.append("- Los correos electrónicos no coinciden.\n");
                marcarError(txtEmail2);
                ok = false;
            } else {
                restablecerEstilo(txtEmail);
                restablecerEstilo(txtEmail2);
            }

            if (ok) {
                int resp = JOptionPane.showConfirmDialog(this, "¿Confirmar envío de datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    Icon icono = null;
                    try {
                        icono = utils.Utils.getScaledIcon("/images/correcto.png", 40);
                    } catch (Exception ex) {
                    }
                    JOptionPane.showMessageDialog(this, "Solicitud enviada correctamente. Recibirás un correo a la dirección: " + email1 + "con los detalles.", "Éxito", JOptionPane.INFORMATION_MESSAGE, icono);
                    new PageController((JPanel) getParent(), PageController.LANDING).actionPerformed(null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Errores encontrados:\n\n" + errores.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    // --- MÉTODOS AUXILIARES ---
    private boolean validarDNIOficial(String it) {
        if (!it.matches("\\d{8}[A-Z]")) {
            return false;
        }
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        try {
            int num = Integer.parseInt(it.substring(0, 8));
            return it.charAt(8) == letras.charAt(num % 23);
        } catch (Exception e) {
            return false;
        }
    }

    private void marcarError(JTextField tf) {
        tf.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
    }

    private void restablecerEstilo(JTextField tf) {
        tf.setBorder(BorderFactory.createLineBorder(new Color(184, 209, 229), 1));
    }

    private JLabel crearLabel(String texto, Font fuente) {
        JLabel label = new JLabel(texto);
        label.setFont(fuente);
        return label;
    }

    private String[] getProvincias() {
        return new String[]{"Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "La Coruña", "La Rioja", "Las Palmas", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza", "Ceuta", "Melilla", "PAIS EXTRANJERO"};
    }

    public static FormDNIOlvidado getInstance() {
        if (instance == null) {
            instance = new FormDNIOlvidado();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
