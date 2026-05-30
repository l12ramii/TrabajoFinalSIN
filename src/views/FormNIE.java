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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author aramo
 */
public class FormNIE extends javax.swing.JPanel {

    private static FormNIE instance;

    // Componentes del Formulario
    private JTextField txtDNI, txtSoporte;
    private JComboBox<String> comboTipo, comboHora, comboMin;
    private JButton btnEnviar;
    private JPanel card;
    private JDateChooser dateChooser, fechaCita;

    /**
     * Creates new form FormDNI
     */
    public FormNIE() {
        // 1. Configuración del Panel Principal (Fondo Blanco)
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        // 2. Creación de la Card Central
        card = new JPanel();
        card.setBackground(new Color(231, 240, 247));
        card.setBorder(new LineBorder(new Color(184, 209, 229), 2, true));
        card.setPreferredSize(new Dimension(850, 500));
        card.setLayout(new GridBagLayout());

        Font fuenteLabels = new Font("Arial", Font.PLAIN, 14);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 15, 8, 15); // Insets ligeramente reducidos para que quepa bien
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- FILA 0: TÍTULO ---
        JLabel title = new JLabel("Introduce tus datos NIE:", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(20, 0, 30, 0);
        card.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 15, 5, 15);

        // --- COLUMNA IZQUIERDA: FORMULARIO ---
        // Fila 1: DNI/NIE
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel lblDNI = new JLabel("NIE (con letra):");
        lblDNI.setFont(fuenteLabels);
        card.add(lblDNI, gbc);
        txtDNI = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtDNI, gbc);

        // Fila 2: Soporte
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel lblSoporte = new JLabel("Número de Soporte:");
        lblSoporte.setFont(fuenteLabels);
        card.add(lblSoporte, gbc);
        txtSoporte = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtSoporte, gbc);

        // Fila 3: TIPO (Certificado o Tarjeta) - SUSTITUYE A EXPEDICIÓN
        gbc.gridy = 3;
        gbc.gridx = 0;
        JLabel lblTipo = new JLabel("Tipo de documento:");
        lblTipo.setFont(fuenteLabels);
        card.add(lblTipo, gbc);
        comboTipo = new JComboBox<>(new String[]{"Tarjeta", "Certificado"});
        gbc.gridx = 1;
        card.add(comboTipo, gbc);

        // Fila 4: Fecha Validez
        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel lblVal = new JLabel("Fecha Validez:");
        lblVal.setFont(fuenteLabels);
        card.add(lblVal, gbc);
        dateChooser = new JDateChooser(null, null, null, null);
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setPreferredSize(new Dimension(180, 28));
        gbc.gridx = 1;
        card.add(dateChooser, gbc);

        // Fila 5: Fecha Cita
        gbc.gridy = 5;
        gbc.gridx = 0;
        JLabel lblCita = new JLabel("Día de la Cita:");
        lblCita.setFont(fuenteLabels);
        card.add(lblCita, gbc);
        fechaCita = new JDateChooser(null, null, null, null);
        fechaCita.setDateFormatString("dd/MM/yyyy");
        fechaCita.setPreferredSize(new Dimension(180, 28));
        gbc.gridx = 1;
        card.add(fechaCita, gbc);

        // Fila 6: Hora Cita
        gbc.gridy = 6;
        gbc.gridx = 0;
        JLabel lblHora = new JLabel("Hora de la Cita:");
        lblHora.setFont(fuenteLabels);
        card.add(lblHora, gbc);
        JPanel panelHora = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelHora.setOpaque(false);
        comboHora = new JComboBox<>();
        comboMin = new JComboBox<>();
        comboHora.setPreferredSize(new Dimension(40, 28));
        comboMin.setPreferredSize(new Dimension(40, 28));
        panelHora.add(comboHora);
        JLabel separador = new JLabel(":");
        separador.setFont(fuenteLabels);
        panelHora.add(separador);
        panelHora.add(comboMin);
        gbc.gridx = 1;
        card.add(panelHora, gbc);

        // --- COLUMNA DERECHA: IMAGEN ---
        JLabel lblImagenDNI = new JLabel();
        try {
            lblImagenDNI.setIcon(utils.Utils.getScaledIcon("/images/dni-ejemplo-2.png", 320));
        } catch (Exception e) {
            lblImagenDNI.setText("[ Imagen Ayuda ]");
            lblImagenDNI.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            lblImagenDNI.setPreferredSize(new Dimension(320, 200));
            lblImagenDNI.setHorizontalAlignment(SwingConstants.CENTER);
        }

        GridBagConstraints gbcImg = new GridBagConstraints();
        gbcImg.gridx = 2;
        gbcImg.gridy = 1;
        gbcImg.gridheight = 5;
        gbcImg.anchor = GridBagConstraints.CENTER;
        gbcImg.insets = new Insets(0, 30, 0, 20);
        card.add(lblImagenDNI, gbcImg);

        // --- FILA FINAL: BOTÓN ENVIAR ---
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

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(40, 0, 20, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        card.add(btnEnviar, gbc);

        add(card);
        configurarEstilosYDatos();
        configurarValidacion();
    }

    private void configurarEstilosYDatos() {
        restablecerEstilo(txtDNI);
        restablecerEstilo(txtSoporte);
        // txtExpedicion eliminado

        for (int i = 8; i <= 19; i++) {
            comboHora.addItem(String.format("%02d", i));
        }
        comboMin.addItem("00");
        comboMin.addItem("15");
        comboMin.addItem("30");
        comboMin.addItem("45");
    }

    private void configurarValidacion() {
        btnEnviar.addActionListener(e -> {
            boolean ok = true;

            // Validar NIE
            if (!validarDNIOficial(txtDNI.getText())) {
                marcarError(txtDNI);
                ok = false;
            } else {
                restablecerEstilo(txtDNI);
            }

            // Validar Soporte
            if (txtSoporte.getText().length() < 6) {
                marcarError(txtSoporte);
                ok = false;
            } else {
                restablecerEstilo(txtSoporte);
            }

            // Validar Fechas (Validez y Cita)
            if (dateChooser.getDate() == null) {
                dateChooser.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                ok = false;
            } else {
                dateChooser.setBorder(BorderFactory.createLineBorder(new Color(184, 209, 229), 1));
            }

            if (fechaCita.getDate() == null) {
                fechaCita.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                ok = false;
            } else {
                fechaCita.setBorder(BorderFactory.createLineBorder(new Color(184, 209, 229), 1));
            }

            if (ok) {
                // 1. Extraer los datos para el mensaje de confirmación
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String fechaStr = (fechaCita.getDate() != null) ? sdf.format(fechaCita.getDate()) : "No seleccionada";
                String horaStr = comboHora.getSelectedItem() + ":" + comboMin.getSelectedItem();

                String mensajeConfirmacion = "¿Está seguro/a de que desea realizar una cita para el día " + fechaStr + " a las " + horaStr + "h?";

                // 2. Mostrar el diálogo de confirmación (SÍ / NO)
                int respuesta = JOptionPane.showConfirmDialog(
                        this,
                        mensajeConfirmacion,
                        "Confirmar Cita",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                // 3. Si el usuario elige SÍ (YES_OPTION)
                if (respuesta == JOptionPane.YES_OPTION) {

                    // --- CARGAR EL ICONO PERSONALIZADO (TICK VERDE) ---
                    javax.swing.Icon iconoTick = null;
                    try {
                        iconoTick = utils.Utils.getScaledIcon("/images/correcto.png", 40);
                    } catch (Exception err) {
                        // Si falla la carga, el diálogo usará el icono por defecto
                        System.err.println("No se pudo cargar el icono del tick: " + err.getMessage());
                    }

                    // 4. Mostrar mensaje de éxito con el icono
                    JOptionPane.showMessageDialog(
                            this,
                            "Cita concertada con éxito. Volviendo al inicio...",
                            "Cita concertada",
                            JOptionPane.INFORMATION_MESSAGE,
                            iconoTick
                    );

                    // 5. Navegación
                    JPanel contenedor = (JPanel) getParent();
                    new PageController(contenedor, PageController.LANDING).actionPerformed(null);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Por favor revise los campos en rojo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void marcarError(JTextField tf) {
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED, 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }

    private void restablecerEstilo(JTextField tf) {
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(184, 209, 229), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }

    private boolean validarDNIOficial(String it) {
        if (!it.matches("\\d{8}[A-Z]")) {
            return false;
        }
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int num = Integer.parseInt(it.substring(0, 8));
        return it.charAt(8) == letras.charAt(num % 23);
    }

    public static FormNIE getInstance() {
        if (instance == null) {
            instance = new FormNIE();
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
