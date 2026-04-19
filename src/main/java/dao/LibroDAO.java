package dao;

import model.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    
    // Método para sincronizar el contador con la BD
    // Llama a este método al iniciar el programa
    public static void sincronizarContador() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(codigo, 4) AS UNSIGNED)) as max_num FROM libros";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                Libro.setContador(maxNum);  // Actualiza el contador estático de Libro
                System.out.println("📖 Contador de libros sincronizado: " + maxNum);
            }
        }
    }
    
    public void insertar(Libro libro) throws SQLException {
        String sql = "INSERT INTO libros (codigo, titulo, autor, num_paginas, editorial, isbn, anio_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, libro.getIdInterno());
            pstmt.setString(2, libro.getTitulo());
            pstmt.setString(3, libro.getAutor());
            pstmt.setInt(4, libro.getNumeroPaginas());
            pstmt.setString(5, libro.getEditorial());
            pstmt.setString(6, libro.getIsbn());
            pstmt.setInt(7, libro.getAnioPublicacion());
            pstmt.setInt(8, libro.getUnidadesDisponibles());
            
            pstmt.executeUpdate();
        }
    }
    
    public void actualizar(Libro libro) throws SQLException {
        String sql = "UPDATE libros SET titulo=?, autor=?, num_paginas=?, editorial=?, isbn=?, anio_publicacion=?, unidades_disponibles=? WHERE codigo=?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setInt(3, libro.getNumeroPaginas());
            pstmt.setString(4, libro.getEditorial());
            pstmt.setString(5, libro.getIsbn());
            pstmt.setInt(6, libro.getAnioPublicacion());
            pstmt.setInt(7, libro.getUnidadesDisponibles());
            pstmt.setString(8, libro.getIdInterno());
            
            pstmt.executeUpdate();
        }
    }
    
    public void eliminar(String codigo) throws SQLException {
        String sql = "DELETE FROM libros WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
        }
    }
    
    public Libro buscarPorCodigo(String codigo) throws SQLException {
        String sql = "SELECT * FROM libros WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // Usar el constructor que coincide con lo que tiene la clase Libro
                Libro libro = new Libro(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getString("autor"),
                    rs.getInt("num_paginas"),
                    rs.getString("editorial"),
                    rs.getString("isbn"),
                    rs.getInt("anio_publicacion")
                );
                libro.setIdInterno(rs.getString("codigo"));
                return libro;
            }
        }
        return null;
    }
    
    public List<Libro> listarTodos() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getString("autor"),
                    rs.getInt("num_paginas"),
                    rs.getString("editorial"),
                    rs.getString("isbn"),
                    rs.getInt("anio_publicacion")
                );
                libro.setIdInterno(rs.getString("codigo"));
                libros.add(libro);
            }
        }
        return libros;
    }
}