package main;

import model.*;
import servicio.MediatecaService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            MediatecaService.sincronizarContadores();
            MediatecaService service = new MediatecaService();
            
            Libro libro = new Libro("El Quijote", 3, 
                "Miguel de Cervantes", 800, "Planeta", "978-1234567890", 1605);
            service.agregarMaterial(libro);
            System.out.println("Libro agregado: " + libro.getIdInterno());
            
            List<Material> lista = service.listarTodosMateriales();
            System.out.println("Total de materiales: " + lista.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}