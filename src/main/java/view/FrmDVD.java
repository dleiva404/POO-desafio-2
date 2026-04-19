package view;

import javax.swing.*;
import java.awt.*;

public class FrmDVD extends JInternalFrame {

    private JTextField txtTitulo, txtUnidades, txtDirector, txtDuracion, txtGenero;
    private JButton btnGuardar, btnLimpiar;

    private final Color azulHeader = new Color(28, 57, 84);
    private final Color fondoOscuro = new Color(43, 43, 43);
    private final Color fondoCampo = new Color(30, 30, 30);
    private final Color textoGris = new Color(200, 200, 200);

    public FrmDVD() {
        super("", true, true, true, true);
        setSize(550, 480);
        getContentPane().setBackground(fondoOscuro);
        setLayout(new BorderLayout());

        // Encabezado Azul
        JPanel pnlHeader = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 12));
        pnlHeader.setBackground(azulHeader);
        JLabel lblHeader = new JLabel("Sistema de Mediateca — Registro de DVDs");
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
        pnlHeader.add(lblHeader);

        // Panel de Datos
        JPanel pnlDatos = new JPanel(new GridBagLayout());
        pnlDatos.setBackground(fondoOscuro);
        pnlDatos.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        añadirFila(pnlDatos, gbc, 0, "Título de Película:", txtTitulo = new JTextField());
        añadirFila(pnlDatos, gbc, 1, "Unidades Disponibles:", txtUnidades = new JTextField());
        añadirFila(pnlDatos, gbc, 2, "Director:", txtDirector = new JTextField());
        añadirFila(pnlDatos, gbc, 3, "Duración (min):", txtDuracion = new JTextField());
        añadirFila(pnlDatos, gbc, 4, "Género / Categoría:", txtGenero = new JTextField());

        // Panel de Botones
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
        pnlBotones.setBackground(fondoOscuro);

        btnLimpiar = new JButton("Limpiar Campos");
        btnGuardar = new JButton("Guardar DVD");

        estilizarBoton(btnLimpiar, new Color(160, 40, 40));
        estilizarBoton(btnGuardar, new Color(56, 102, 0));

        pnlBotones.add(btnLimpiar);
        pnlBotones.add(btnGuardar);

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlDatos, BorderLayout.CENTER);
        add(pnlBotones, BorderLayout.SOUTH);
    }

    private void añadirFila(JPanel pnl, GridBagConstraints gbc, int fila, String texto, JTextField campo) {
        gbc.gridy = fila;
        gbc.gridx = 0; gbc.weightx = 0;
        JLabel lbl = new JLabel(texto, SwingConstants.RIGHT);
        lbl.setForeground(textoGris);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        pnl.add(lbl, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        campo.setBackground(fondoCampo);
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        pnl.add(campo, gbc);
    }

    private void estilizarBoton(JButton btn, Color colorFondo) {
        btn.setBackground(colorFondo);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(160, 40));
    }
}
