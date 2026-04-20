package dao;

import model.Revista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevistaDAO {
    
    public static void sincronizarContador() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(codigo, 4) AS UNSIGNED)) as max_num FROM revistas";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                Revista.setContador(maxNum);
                System.out.println("📰 Contador de revistas sincronizado: " + maxNum);
            }
        }
    }
    
    public void insertar(Revista revista) throws SQLException {
        String sql = "INSERT INTO revistas (codigo, titulo, autor, num_paginas, editorial, periodicidad, fecha_publicacion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, revista.getIdInterno());
            pstmt.setString(2, revista.getTitulo());
            pstmt.setString(3, revista.getAutor());
            pstmt.setInt(4, revista.getNumeroPaginas());
            pstmt.setString(5, revista.getEditorial());
            pstmt.setString(6, revista.getPeriodicidad());
            pstmt.setString(7, revista.getFechaPublicacion());
            pstmt.setInt(8, revista.getUnidadesDisponibles());
            
            pstmt.executeUpdate();
        }
    }
    
    public void actualizar(Revista revista) throws SQLException {
        String sql = "UPDATE revistas SET titulo=?, autor=?, num_paginas=?, editorial=?, periodicidad=?, fecha_publicacion=?, unidades_disponibles=? WHERE codigo=?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, revista.getTitulo());
            pstmt.setString(2, revista.getAutor());
            pstmt.setInt(3, revista.getNumeroPaginas());
            pstmt.setString(4, revista.getEditorial());
            pstmt.setString(5, revista.getPeriodicidad());
            pstmt.setString(6, revista.getFechaPublicacion());
            pstmt.setInt(7, revista.getUnidadesDisponibles());
            pstmt.setString(8, revista.getIdInterno());
            
            pstmt.executeUpdate();
        }
    }
    
    public void eliminar(String codigo) throws SQLException {
        String sql = "DELETE FROM revistas WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
        }
    }
    
    public Revista buscarPorCodigo(String codigo) throws SQLException {
        String sql = "SELECT * FROM revistas WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Revista revista = new Revista(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getString("autor"),
                    rs.getInt("num_paginas"),
                    rs.getString("editorial"),
                    rs.getString("periodicidad"),
                    rs.getString("fecha_publicacion")
                );
                revista.setIdInterno(rs.getString("codigo"));
                return revista;
            }
        }
        return null;
    }
    
    public List<Revista> listarTodos() throws SQLException {
        List<Revista> revistas = new ArrayList<>();
        String sql = "SELECT * FROM revistas";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Revista revista = new Revista(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getString("autor"),
                    rs.getInt("num_paginas"),
                    rs.getString("editorial"),
                    rs.getString("periodicidad"),
                    rs.getString("fecha_publicacion")
                );
                revista.setIdInterno(rs.getString("codigo"));
                revistas.add(revista);
            }
        }
        return revistas;
    }
}