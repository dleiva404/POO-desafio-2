package view;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame {

    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private JMenu mnuRegistros, mnuConsultas, mnuSistema;
    private JMenuItem itemLibro, itemRevista, itemCD, itemDVD, itemVerTodo, itemSalir;

    public FrmPrincipal() {
        setTitle("SISTEMA DE MEDIATECA");
        setSize(1200, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        escritorio = new JDesktopPane();
        escritorio.setBackground(new Color(45, 52, 54));
        setContentPane(escritorio);

        configurarMenu();
        configurarEventos();
    }

    private void configurarMenu() {
        barraMenu = new JMenuBar();

        mnuRegistros = new JMenu("Registros");
        itemLibro = new JMenuItem("Gestión de Libros");
        itemRevista = new JMenuItem("Gestión de Revistas");
        itemCD = new JMenuItem("Gestión de CDs Audio");
        itemDVD = new JMenuItem("Gestión de DVDs");

        mnuRegistros.add(itemLibro);
        mnuRegistros.add(itemRevista);
        mnuRegistros.addSeparator();
        mnuRegistros.add(itemCD);
        mnuRegistros.add(itemDVD);

        mnuConsultas = new JMenu("Consultas");
        itemVerTodo = new JMenuItem("Ver Inventario General");
        mnuConsultas.add(itemVerTodo);

        mnuSistema = new JMenu("Sistema");
        itemSalir = new JMenuItem("Salir del Programa");
        mnuSistema.add(itemSalir);

        barraMenu.add(mnuRegistros);
        barraMenu.add(mnuConsultas);
        barraMenu.add(mnuSistema);
        setJMenuBar(barraMenu);
    }

    private void configurarEventos() {
        itemLibro.addActionListener(e -> abrirVentana(new FrmLibro()));
        itemRevista.addActionListener(e -> abrirVentana(new FrmRevista()));
        itemCD.addActionListener(e -> abrirVentana(new FrmCD()));
        itemDVD.addActionListener(e -> abrirVentana(new FrmDVD()));
        itemVerTodo.addActionListener(e -> abrirVentana(new FrmConsulta()));
        itemSalir.addActionListener(e -> System.exit(0));
    }

    private void abrirVentana(JInternalFrame ventana) {
        // 1. Buscamos todas las ventanas que ya estén en el escritorio
        JInternalFrame[] ventanasAbiertas = escritorio.getAllFrames();

        // 2. Las cerramos todas para limpiar la pantalla
        for (JInternalFrame f : ventanasAbiertas) {
            f.dispose();
        }

        // Agregamos la nueva ventana limpia
        escritorio.add(ventana);

        Dimension ds = escritorio.getSize();
        Dimension fs = ventana.getSize();
        int x = (ds.width - fs.width) / 2;
        int y = (ds.height - fs.height) / 2;

        ventana.setLocation(x, y);
        ventana.setVisible(true);
        try {
            ventana.setSelected(true);
        } catch (Exception e) { }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }
}
