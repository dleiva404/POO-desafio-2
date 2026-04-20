package main;

import model.*;
import servicio.MediatecaService;
import java.util.List;

// IMPORTS DE LOG4J
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    // LOGGER (VA FUERA DEL MAIN)
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            logger.info("Iniciando sistema de Mediateca");

            MediatecaService.sincronizarContadores();
            MediatecaService service = new MediatecaService();

            Libro libro = new Libro("El Quijote", 3,
                    "Miguel de Cervantes", 800, "Planeta", "978-1234567890", 1605);

            service.agregarMaterial(libro);

            // CAMBIO DE println → logger
            logger.info("Libro agregado: " + libro.getIdInterno());

            List<Material> lista = service.listarTodosMateriales();

            // CAMBIO DE println → logger
            logger.info("Total de materiales: " + lista.size());

        } catch (Exception e) {

            // CAMBIO DE printStackTrace → logger
            logger.error("Error en el sistema", e);
        }
    }
}