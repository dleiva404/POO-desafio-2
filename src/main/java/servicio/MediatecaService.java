package servicio;

import dao.*;
import model.*;
import java.sql.SQLException;
import java.util.*;

public class MediatecaService {
    
    private LibroDAO libroDAO;
    private RevistaDAO revistaDAO;
    private CdAudioDAO cdDAO;
    private DvdDAO dvdDAO;
    
    public MediatecaService() {
        this.libroDAO = new LibroDAO();
        this.revistaDAO = new RevistaDAO();
        this.cdDAO = new CdAudioDAO();
        this.dvdDAO = new DvdDAO();
    }
    
    // LLAMAR ESTE MÉTODO AL INICIAR EL PROGRAMA
    public static void sincronizarContadores() throws SQLException {
        LibroDAO.sincronizarContador();
        RevistaDAO.sincronizarContador();
        CdAudioDAO.sincronizarContador();
        DvdDAO.sincronizarContador();
    }
    
    public void agregarMaterial(Material material) throws SQLException {
        if (material instanceof Libro) {
            libroDAO.insertar((Libro) material);
        } 
        else if (material instanceof Revista) {
            revistaDAO.insertar((Revista) material);
        }
        else if (material instanceof CdAudio) {
            cdDAO.insertar((CdAudio) material);
        }
        else if (material instanceof Dvd) {
            dvdDAO.insertar((Dvd) material);
        }
    }
    
    public void modificarMaterial(Material material) throws SQLException {
        if (material instanceof Libro) {
            libroDAO.actualizar((Libro) material);
        }
        else if (material instanceof Revista) {
            revistaDAO.actualizar((Revista) material);
        }
        else if (material instanceof CdAudio) {
            cdDAO.actualizar((CdAudio) material);
        }
        else if (material instanceof Dvd) {
            dvdDAO.actualizar((Dvd) material);
        }
    }
    
    public void borrarMaterial(String codigo) throws SQLException {
        if (codigo.startsWith("LIB")) {
            libroDAO.eliminar(codigo);
        }
        else if (codigo.startsWith("REV")) {
            revistaDAO.eliminar(codigo);
        }
        else if (codigo.startsWith("CDA")) {
            cdDAO.eliminar(codigo);
        }
        else if (codigo.startsWith("DVD")) {
            dvdDAO.eliminar(codigo);
        }
    }
    
    public Material buscarMaterial(String codigo) throws SQLException {
        if (codigo.startsWith("LIB")) {
            return libroDAO.buscarPorCodigo(codigo);
        }
        else if (codigo.startsWith("REV")) {
            return revistaDAO.buscarPorCodigo(codigo);
        }
        else if (codigo.startsWith("CDA")) {
            return cdDAO.buscarPorCodigo(codigo);
        }
        else if (codigo.startsWith("DVD")) {
            return dvdDAO.buscarPorCodigo(codigo);
        }
        return null;
    }
    
    public List<Material> listarTodosMateriales() throws SQLException {
        List<Material> todos = new ArrayList<>();
        
        todos.addAll(libroDAO.listarTodos());
        todos.addAll(revistaDAO.listarTodos());
        todos.addAll(cdDAO.listarTodos());
        todos.addAll(dvdDAO.listarTodos());
        
        return todos;
    }
}