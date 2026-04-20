package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// IMPORTS DE LOG4J
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionDB {

    private static final String URL = "jdbc:mariadb://localhost:3306/mediateca?allowPublicKeyRetrieval=true&useSSL=false";    private static final String USUARIO = "root";
    private static final String CONTRASENA = "admin";

    private static Connection connection = null;

    // LOGGER
    private static final Logger logger = LogManager.getLogger(ConexionDB.class);

    private ConexionDB() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");

                connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

                // LOG DE CONEXIÓN EXITOSA
                logger.info("Conexión exitosa a la base de datos");

            } catch (ClassNotFoundException e) {

                // ERROR SI NO ENCUENTRA EL DRIVER
                logger.error("Driver de MariaDB no encontrado", e);

                throw new SQLException("Driver de MariaDB no encontrado", e);

            } catch (SQLException e) {

                // ERROR DE CONEXIÓN
                logger.error("Error al conectar a la base de datos", e);

                throw e;
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;

                // LOG DE CIERRE
                logger.info("Conexión cerrada correctamente");

            } catch (SQLException e) {

                // REEMPLAZO DE System.err
                logger.error("Error cerrando conexión", e);
            }
        }
    }
}