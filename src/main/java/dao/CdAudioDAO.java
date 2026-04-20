package dao;

import model.CdAudio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CdAudioDAO {
    
    // Sincronizar el contador de CDs con la BD
    public static void sincronizarContador() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(codigo, 4) AS UNSIGNED)) as max_num FROM cds_audio";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                CdAudio.setContador(maxNum);
                System.out.println("💿 Contador de CDs sincronizado: " + maxNum);
            }
        }
    }
    
    public void insertar(CdAudio cd) throws SQLException {
        String sql = "INSERT INTO cds_audio (codigo, titulo, artista, genero, duracion, num_canciones, unidades_disponibles) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, cd.getIdInterno());
            pstmt.setString(2, cd.getTitulo());
            pstmt.setString(3, cd.getArtista());
            pstmt.setString(4, cd.getGenero());
            pstmt.setInt(5, cd.getDuracion());
            pstmt.setInt(6, cd.getNumeroCanciones());
            pstmt.setInt(7, cd.getUnidadesDisponibles());
            
            pstmt.executeUpdate();
        }
    }
    
    public void actualizar(CdAudio cd) throws SQLException {
        String sql = "UPDATE cds_audio SET titulo=?, artista=?, genero=?, duracion=?, num_canciones=?, unidades_disponibles=? WHERE codigo=?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, cd.getTitulo());
            pstmt.setString(2, cd.getArtista());
            pstmt.setString(3, cd.getGenero());
            pstmt.setInt(4, cd.getDuracion());
            pstmt.setInt(5, cd.getNumeroCanciones());
            pstmt.setInt(6, cd.getUnidadesDisponibles());
            pstmt.setString(7, cd.getIdInterno());
            
            pstmt.executeUpdate();
        }
    }
    
    public void eliminar(String codigo) throws SQLException {
        String sql = "DELETE FROM cds_audio WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
        }
    }
    
    public CdAudio buscarPorCodigo(String codigo) throws SQLException {
        String sql = "SELECT * FROM cds_audio WHERE codigo = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                CdAudio cd = new CdAudio(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getInt("duracion"),
                    rs.getString("genero"),
                    rs.getString("artista"),
                    rs.getInt("num_canciones")
                );
                cd.setIdInterno(rs.getString("codigo"));
                return cd;
            }
        }
        return null;
    }
    
    public List<CdAudio> listarTodos() throws SQLException {
        List<CdAudio> cds = new ArrayList<>();
        String sql = "SELECT * FROM cds_audio";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                CdAudio cd = new CdAudio(
                    rs.getString("titulo"),
                    rs.getInt("unidades_disponibles"),
                    rs.getInt("duracion"),
                    rs.getString("genero"),
                    rs.getString("artista"),
                    rs.getInt("num_canciones")
                );
                cd.setIdInterno(rs.getString("codigo"));
                cds.add(cd);
            }
        }
        return cds;
    }
}