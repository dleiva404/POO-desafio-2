package dao;

import model.Dvd;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DvdDAO {
    
    // Sincronizar el contador de DVDs con la BD
    public static void sincronizarContador() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(codigo, 4) AS UNSIGNED)) as max_num FROM dvds";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                Dvd.setContador(maxNum);
                System.out.println("🎬 Contador de DVDs sincronizado: " + maxNum);
            }
        }
    }
    
    public void insertar(Dvd dvd) throws SQLException {
        String sql = "INSERT INTO dvds (codigo, titulo, director, genero, duracion, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, dvd.getIdInterno());
            pstmt.setString(2, dvd.getTitulo());
            pstmt.setString(3, dvd.getDirector());
            pstmt.setString(4, dvd.getGenero());
            pstmt.setInt(5, dvd.getDuracion());
            pstmt.setInt(6, dvd.getUnidadesDisponibles());
            
            pstmt.executeUpdate();
        }
    }
    
    public void actualizar(Dvd dvd) throws SQLException {
        String sql = "UPDATE dvds SET titulo=?, director=?, genero=?, duracion=?, unidades_disponibles=? WHERE codigo=?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, dvd.getTitulo());
            pstmt.setString(2, dvd.getDirector());
            pstmt.setString(3, dvd.getGenero());
            pstmt.setInt(4, dvd.getDuracion());
            pstmt.setInt(5, dvd.getUnidadesDisponibles());
            pstmt.setString(6, dvd.getIdInterno());
            
            pstmt.executeUpdate();
        }
    }
    
    public void eliminar(String codigo) throws SQLException {
        String sql = "DELETE FROM dvds WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
        }
    }
    
    public Dvd buscarPorCodigo(String codigo) throws SQLException {
        String sql = "SELECT * FROM dvds WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Dvd dvd = new Dvd(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getInt("duracion"),
                    rs.getString("genero"),
                    rs.getString("director")
                );
                dvd.setIdInterno(rs.getString("codigo"));
                return dvd;
            }
        }
        return null;
    }
    
    public List<Dvd> listarTodos() throws SQLException {
        List<Dvd> dvds = new ArrayList<>();
        String sql = "SELECT * FROM dvds";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Dvd dvd = new Dvd(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getInt("duracion"),
                    rs.getString("genero"),
                    rs.getString("director")
                );
                dvd.setIdInterno(rs.getString("codigo"));
                dvds.add(dvd);
            }
        }
        return dvds;
    }
}