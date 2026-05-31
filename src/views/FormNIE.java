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
import java.util.Calendar;
import java.util.ResourceBundle;
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
public class FormNIE extends javax.swing.JPanel implements Internationalization {

    private static FormNIE instance;

    // Componentes del Formulario
    private JTextField txtDNI, txtSoporte, txtTelefono;
    private JComboBox<String> comboTipo, comboHora, comboMin;
    private JButton btnEnviar;
    private JPanel card;
    private JDateChooser dateChooser, fechaCita;
    private JLabel lblTitle, 
            lblNie,
            lblSoporte,
            lblVal,
            lblTipo,
            lblTelefono,
            lblCita,
            lblHora;

    /**
     * Creates new form FormDNI
     */
    public FormNIE() {
        // 1. Configuración del Panel Principal
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        // 2. Creación de la Card Central
        card = new JPanel();
        card.setBackground(new Color(231, 240, 247));
        card.setBorder(new LineBorder(new Color(184, 209, 229), 2, true));
        card.setPreferredSize(new Dimension(800, 500));
        card.setLayout(new GridBagLayout());

        Font fuenteLabels = new Font("Arial", Font.PLAIN, 14);
        Color colorBordeBusca = new Color(184, 209, 229);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- FILA 0: TÍTULO ---
        lblTitle = new JLabel("Introduce tus datos NIE:", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(20, 0, 25, 0);
        card.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(4, 15, 4, 15);

        // --- FORMULARIO ---
        // Fila 1: NIE
        gbc.gridy = 1;
        gbc.gridx = 0;
        lblNie = new JLabel("NIE (con letra):");
        lblNie.setFont(fuenteLabels);
        card.add(lblNie, gbc);
        txtDNI = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtDNI, gbc);

        // Fila 2: Soporte
        gbc.gridy = 2;
        gbc.gridx = 0;
        lblSoporte = new JLabel("Número de Soporte:");
        lblSoporte.setFont(fuenteLabels);
        card.add(lblSoporte, gbc);
        txtSoporte = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtSoporte, gbc);

        // Fila 3: Tipo
        gbc.gridy = 3;
        gbc.gridx = 0;
        lblTipo = new JLabel("Tipo de documento:");
        lblTipo.setFont(fuenteLabels);
        card.add(lblTipo, gbc);
        comboTipo = new JComboBox<>(new String[]{"Tarjeta", "Certificado"});
        gbc.gridx = 1;
        card.add(comboTipo, gbc);

        // Fila 4: Teléfono
        gbc.gridy = 4;
        gbc.gridx = 0;
        lblTelefono = new JLabel("Teléfono móvil:");
        lblTelefono.setFont(fuenteLabels);
        card.add(lblTelefono, gbc);
        txtTelefono = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtTelefono, gbc);

        // Fila 5: Fecha Validez
        gbc.gridy = 5;
        gbc.gridx = 0;
        lblVal = new JLabel("Fecha Validez:");
        lblVal.setFont(fuenteLabels);
        card.add(lblVal, gbc);
        dateChooser = new JDateChooser(null, null, null, null);
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setPreferredSize(new Dimension(180, 26));
        dateChooser.setBorder(BorderFactory.createLineBorder(colorBordeBusca, 1));
        gbc.gridx = 1;
        gbc.insets = new Insets(2, 15, 2, 15);
        card.add(dateChooser, gbc);

        // Fila 6: Fecha Cita
        gbc.gridy = 6;
        gbc.gridx = 0;
        lblCita = new JLabel("Día de la Cita:");
        lblCita.setFont(fuenteLabels);
        card.add(lblCita, gbc);
        fechaCita = new JDateChooser(null, null, null, null);
        fechaCita.setDateFormatString("dd/MM/yyyy");
        fechaCita.setPreferredSize(new Dimension(180, 26));
        fechaCita.setBorder(BorderFactory.createLineBorder(colorBordeBusca, 1));
        gbc.gridx = 1;
        card.add(fechaCita, gbc);

        // Fila 7: Hora
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.insets = new Insets(4, 15, 4, 15);
        lblHora = new JLabel("Hora de la Cita:");
        lblHora.setFont(fuenteLabels);
        card.add(lblHora, gbc);
        JPanel panelHora = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelHora.setOpaque(false);
        comboHora = new JComboBox<>();
        comboMin = new JComboBox<>();
        comboHora.setPreferredSize(new Dimension(55, 26));
        comboMin.setPreferredSize(new Dimension(55, 26));
        panelHora.add(comboHora);
        panelHora.add(new JLabel(":"));
        panelHora.add(comboMin);
        gbc.gridx = 1;
        card.add(panelHora, gbc);

        // --- COLUMNA DERECHA: IMAGEN ---
        JLabel lblImagenDNI = new JLabel();
        try {
            lblImagenDNI.setIcon(utils.Utils.getScaledIcon("/images/nie-ejemplo-1.jpg", 320));
        } catch (Exception e) {
            lblImagenDNI.setText("[ Imagen Ayuda ]");
            lblImagenDNI.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            lblImagenDNI.setPreferredSize(new Dimension(320, 200));
            lblImagenDNI.setHorizontalAlignment(SwingConstants.CENTER);
        }
        GridBagConstraints gbcImg = new GridBagConstraints();
        gbcImg.gridx = 2;
        gbcImg.gridy = 1;
        gbcImg.gridheight = 6;
        gbcImg.anchor = GridBagConstraints.CENTER;
        gbcImg.insets = new Insets(0, 30, 0, 20);
        card.add(lblImagenDNI, gbcImg);

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

        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 20, 0);
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
        restablecerEstilo(txtTelefono);
        for (int i = 8; i <= 19; i++) {
            comboHora.addItem(String.format("%02d", i));
        }
        String[] mins = {"00", "15", "30", "45"};
        for (String m : mins) {
            comboMin.addItem(m);
        }
    }

    private void configurarValidacion() {
        btnEnviar.addActionListener(e -> {
            StringBuilder errores = new StringBuilder();
            boolean ok = true;

            if (!validarNIEOficial(txtDNI.getText().trim())) {
                errores.append("- El NIE introducido no es válido.\n");
                marcarError(txtDNI);
                ok = false;
            } else {
                restablecerEstilo(txtDNI);
            }
            if (txtSoporte.getText().trim().length() < 6) {
                errores.append("- El número de soporte debe tener al menos 6 caracteres.\n");
                marcarError(txtSoporte);
                ok = false;
            } else {
                restablecerEstilo(txtSoporte);
            }

            // 3. Validar Teléfono
            if (!txtTelefono.getText().matches("[679]\\d{8}")) {
                errores.append("- El teléfono debe tener 9 dígitos y empezar por 6, 7 o 9.\n");
                marcarError(txtTelefono);
                ok = false;
            } else {
                restablecerEstilo(txtTelefono);
            }

            // 4. Validar Fecha Validez
            if (dateChooser.getDate() == null) {
                errores.append("- Debe seleccionar la fecha de validez.\n");
                dateChooser.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                ok = false;
            } else {
                dateChooser.setBorder(BorderFactory.createLineBorder(new Color(184, 209, 229), 1));
            }

            // 5. Validar Fecha Cita + Comprobación de Pasado
            if (fechaCita.getDate() == null) {
                errores.append("- Debe seleccionar un día para su cita.\n");
                fechaCita.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                ok = false;
            } else {
                Calendar hoy = Calendar.getInstance();
                hoy.set(Calendar.HOUR_OF_DAY, 0);
                hoy.set(Calendar.MINUTE, 0);
                hoy.set(Calendar.SECOND, 0);
                hoy.set(Calendar.MILLISECOND, 0);

                if (fechaCita.getDate().before(hoy.getTime())) {
                    errores.append("- La fecha de la cita no puede ser anterior a hoy.\n");
                    fechaCita.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    ok = false;
                } else {
                    fechaCita.setBorder(BorderFactory.createLineBorder(new Color(184, 209, 229), 1));
                }
            }

            if (ok) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String mensaje = "¿Desea confirmar la cita para el día " + sdf.format(fechaCita.getDate())
                        + " a las " + comboHora.getSelectedItem() + ":" + comboMin.getSelectedItem() + "h? \n Se te notificará por SMS al número " + txtTelefono.getText();

                int resp = JOptionPane.showConfirmDialog(this, mensaje, "Confirmar Cita", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    javax.swing.Icon icono = null;
                    try {
                        icono = utils.Utils.getScaledIcon("/images/correcto.png", 40);
                    } catch (Exception err) {
                    }
                    JOptionPane.showMessageDialog(this, "Cita concertada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE, icono);
                    new PageController((JPanel) getParent(), PageController.LANDING).actionPerformed(null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Errores encontrados:\n\n" + errores.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void marcarError(JTextField tf) {
        tf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.RED, 2), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    private void restablecerEstilo(JTextField tf) {
        tf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(184, 209, 229), 1), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    private boolean validarNIEOficial(String it) {
        if (!it.matches("[XYZ\\d]\\d{7}[A-Z]")) {
            return false;
        }
        return true;
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

    @Override
    public void actualizarTextos(ResourceBundle bundle) {
        lblNie.setText(bundle.getString("ACCESO_CON_NIE"));
        lblTitle.setText(bundle.getString("TITULO"));
        lblSoporte.setText(bundle.getString("NUM_SOPORT"));
        lblTipo.setText(bundle.getString("TIPO_DOCUMENTO"));
        lblTelefono.setText(bundle.getString("TELEFONO_MOVIL"));
        lblCita.setText(bundle.getString("DIA_CITA"));
        lblHora.setText(bundle.getString("HORA_CITA"));
        btnEnviar.setText(bundle.getString("ENVIAR_DATOS"));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
