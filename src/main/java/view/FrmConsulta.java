package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class FrmConsulta extends JInternalFrame {

    private JTable tablaInventario;
    private DefaultTableModel modelo;

    public FrmConsulta() {
        super("Consulta General de Inventario", true, true, true, true);
        setSize(950, 550);


        getContentPane().setBackground(new Color(45, 52, 54));

        //  Atributos
        String[] columnas = {"ID / CÓDIGO", "TÍTULO DEL MATERIAL", "CATEGORÍA", "AUTOR / DIRECTOR", "STOCK", "UBICACIÓN"};

        // Modelo
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaInventario = new JTable(modelo);

        // Diseño de filas de inventario
        tablaInventario.setBackground(new Color(60, 63, 65));
        tablaInventario.setForeground(Color.WHITE);
        tablaInventario.setRowHeight(30);
        tablaInventario.setSelectionBackground(new Color(75, 101, 132));
        tablaInventario.setShowGrid(true);
        tablaInventario.setGridColor(Color.DARK_GRAY);

        // Encabezado
        JTableHeader header = tablaInventario.getTableHeader();
        header.setBackground(new Color(30, 39, 46));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 14));
        header.setPreferredSize(new Dimension(0, 40));
        header.setReorderingAllowed(false);

        //  Datos de prueba (Un libro, una revista y un CD)

        modelo.addRow(new Object[]{
                "LIB-101", "Tierra de Infancia", "Libro", "Claudia Lars", "8", "Estante A-1"
        });
        modelo.addRow(new Object[]{
                "REV-505", "Revista Cultura (Mined)", "Revista", "Dirección de Publicaciones", "20", "Hemeroteca"
        });
        modelo.addRow(new Object[]{
                "CDA-088", "Lo mejor de Álvaro Torres", "CD Audio", "Álvaro Torres", "5", "Multimedia 2"
        });
        JScrollPane scroll = new JScrollPane(tablaInventario);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scroll.getViewport().setBackground(new Color(45, 52, 54));

        add(scroll, BorderLayout.CENTER);
    }
}