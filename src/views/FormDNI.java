/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.toedter.calendar.JDateChooser;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author aramo
 */
public class FormDNI extends javax.swing.JPanel implements Internationalization {

    private static FormDNI instance;

    // Componentes del Formulario
    private JTextField txtDNI, txtSoporte, txtExpedicion, txtTelefono;
    private JComboBox<String> comboHora, comboMin;
    private JButton btnEnviar;
    private JPanel card;
    private JDateChooser dateChooser, fechaCita;
    private JLabel lblTitulo,
            lblDni,
            lblSoporte,
            lblExp,
            lblVal,
            lblTelefono,
            lblCita,
            lblDia,
            lblHora;

    /**
     * Creates new form FormDNI
     */
    public FormDNI() {
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
        lblTitulo = new JLabel("Introduce tus datos:", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(20, 0, 25, 0);
        card.add(lblTitulo, gbc);

        // Reset para los campos (Márgenes compactos)
        gbc.gridwidth = 1;
        gbc.insets = new Insets(4, 15, 4, 15);

        // --- COLUMNA IZQUIERDA: FORMULARIO ---
        // Fila 1: DNI
        gbc.gridy = 1;
        gbc.gridx = 0;
        lblDni = new JLabel("DNI (con letra):");
        lblDni.setFont(fuenteLabels);
        card.add(lblDni, gbc);
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

        // Fila 3: Expedición
        gbc.gridy = 3;
        gbc.gridx = 0;
        lblExp = new JLabel("Equipo de Expedición:");
        lblExp.setFont(fuenteLabels);
        card.add(lblExp, gbc);
        txtExpedicion = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtExpedicion, gbc);

        // Fila 4: Fecha Validez (AJUSTE DE MARGEN)
        gbc.gridy = 4;
        gbc.gridx = 0;
        lblVal = new JLabel("Fecha Validez DNI:");
        lblVal.setFont(fuenteLabels);
        card.add(lblVal, gbc);

        dateChooser = new JDateChooser(null, null, null, null);
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setPreferredSize(new Dimension(180, 26)); // Altura reducida
        dateChooser.setBorder(BorderFactory.createLineBorder(colorBordeBusca, 1));
        gbc.gridx = 1;
        gbc.insets = new Insets(2, 15, 2, 15); // Insets mínimos
        card.add(dateChooser, gbc);

        // Fila 5: Teléfono
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.insets = new Insets(4, 15, 4, 15); // Volvemos al margen normal
        lblTelefono = new JLabel("Teléfono móvil:");
        lblTelefono.setFont(fuenteLabels);
        card.add(lblTelefono, gbc);
        txtTelefono = new JTextField(15);
        gbc.gridx = 1;
        card.add(txtTelefono, gbc);

        // Fila 6: Fecha Cita (AJUSTE DE MARGEN)
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
        gbc.insets = new Insets(2, 15, 2, 15);
        card.add(fechaCita, gbc);

        // Fila 7: Hora Cita
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
        JLabel separador = new JLabel(":");
        separador.setFont(fuenteLabels);
        panelHora.add(separador);
        panelHora.add(comboMin);
        gbc.gridx = 1;
        card.add(panelHora, gbc);

        // --- COLUMNA DERECHA: IMAGEN DNI ---
        JLabel lblImagenDNI = new JLabel();
        try {
            lblImagenDNI.setIcon(utils.Utils.getScaledIcon("/images/dni-ejemplo-2.png", 320));
        } catch (Exception e) {
            lblImagenDNI.setText("[ Imagen DNI ]");
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

        // Cambiamos a la fila 8 para que no se solape con la hora (fila 7)
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
        // Estilo de los textfields
        restablecerEstilo(txtDNI);
        restablecerEstilo(txtSoporte);
        restablecerEstilo(txtExpedicion);
        restablecerEstilo(txtTelefono);
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
            ResourceBundle bundle = main.Main.getBundle();
            StringBuilder errores = new StringBuilder();
            boolean ok = true;

            String dni = txtDNI.getText().trim();
            if (dni.isEmpty()) {
                errores.append(bundle.getString("ERR_DNI_VACIO"));
                marcarError(txtDNI);
                ok = false;
            } else if (!validarDNIOficial(dni)) {
                errores.append(bundle.getString("ERR_DNI_INVALIDO"));
                marcarError(txtDNI);
                ok = false;
            } else {
                restablecerEstilo(txtDNI);
            }

            // 2. Validar Soporte
            if (txtSoporte.getText().trim().length() < 6) {
                errores.append(bundle.getString("ERR_SOPORTE"));
                marcarError(txtSoporte);
                ok = false;
            } else {
                restablecerEstilo(txtSoporte);
            }

            // 3. Validar Equipo Expedición
            if (!txtExpedicion.getText().matches("\\d{9}")) {
                errores.append(bundle.getString("ERR_EXPEDICION"));
                marcarError(txtExpedicion);
                ok = false;
            } else {
                restablecerEstilo(txtExpedicion);
            }

            // 4. Validar Teléfono
            if (!txtTelefono.getText().matches("[679]\\d{8}")) {
                errores.append(bundle.getString("ERR_TELEFONO"));
                marcarError(txtTelefono);
                ok = false;
            } else {
                restablecerEstilo(txtTelefono);
            }

            // 5. Validar Fechas
            if (dateChooser.getDate() == null) {
                errores.append(bundle.getString("ERR_FECHA_VALIDEZ"));
                dateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 2));
                ok = false;
            } else {
                dateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 209, 229), 1));
            }

            if (fechaCita.getDate() == null) {
                errores.append(bundle.getString("ERR_FECHA_CITA_VACIA"));
                fechaCita.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 2));
                ok = false;
            } else {
                Calendar hoy = Calendar.getInstance();
                hoy.set(Calendar.HOUR_OF_DAY, 0);
                hoy.set(Calendar.MINUTE, 0);
                hoy.set(Calendar.SECOND, 0);
                hoy.set(Calendar.MILLISECOND, 0);

                if (fechaCita.getDate().before(hoy.getTime())) {
                    errores.append(bundle.getString("ERR_FECHA_CITA_PASADA"));
                    fechaCita.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 2));
                    ok = false;
                } else {
                    fechaCita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 209, 229), 1));
                }
            }

            // --- MANEJO DE RESULTADOS ---
            if (ok) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String fechaStr = sdf.format(fechaCita.getDate());
                String horaStr = comboHora.getSelectedItem() + ":" + comboMin.getSelectedItem();

                // Uso de MessageFormat para insertar variables en el texto traducido
                String mensajeConfirmacion = java.text.MessageFormat.format(
                        bundle.getString("CONFIRMAR_MSG"),
                        fechaStr, horaStr, txtTelefono.getText()
                );

                int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                        this, mensajeConfirmacion, bundle.getString("CONFIRMAR_TITULO"),
                        javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE
                );

                if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
                    javax.swing.JOptionPane.showMessageDialog(
                            this, bundle.getString("EXITO_MSG"),
                            bundle.getString("EXITO_TITULO"),
                            javax.swing.JOptionPane.INFORMATION_MESSAGE,
                            utils.Utils.getScaledIcon("/images/correcto.png", 40)
                    );

                    javax.swing.JPanel contenedor = (javax.swing.JPanel) getParent();
                    new controllers.PageController(contenedor, controllers.PageController.LANDING).actionPerformed(null);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        bundle.getString("ERR_VALIDACION_MSG") + errores.toString(),
                        bundle.getString("ERR_VALIDACION_TITULO"),
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
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

    public static FormDNI getInstance() {
        if (instance == null) {
            instance = new FormDNI();
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
        lblTitulo.setText(bundle.getString("RENOVACION_DNI"));
        lblDni.setText(bundle.getString("DNI_CON_LETRA"));
        lblSoporte.setText(bundle.getString("NUM_SOPORT"));
        lblExp.setText(bundle.getString("EQ_EXP"));
        lblVal.setText(bundle.getString("FECHA_VALIDEZ_DNI"));
        lblTelefono.setText(bundle.getString("TELEFONO_MOVIL"));
        lblCita.setText(bundle.getString("DIA_CITA"));
        lblHora.setText(bundle.getString("HORA_CITA"));
        btnEnviar.setText(bundle.getString("ENVIAR_DATOS"));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
