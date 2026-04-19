package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class FrmVerTodo extends JInternalFrame {
    public FrmVerTodo() {
        super("Inventario General de Mediateca", true, true, true, true);
        setSize(600, 400);

        // Se definieron  las columnas segun la tabla "material"
        String[] columnas = {"ID", "Código", "Título", "Unidades", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);

        // Simulación de datos
        modelo.addRow(new Object[]{"1", "LIB001", "POO con Java", "5", "LIBRO"});

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}