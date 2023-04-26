package prueba.escuela;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * MyApp.java
 *
 * @autor: Antonio Garces
 * @revisor: Carlos Arranz
 * @version: 1.0
 */
public class MyApp {

	private static final String PERSISTENCELOCAL_UNIT_NAME = "PERSISTENCE";

	/**
	 * Pide al usuario que seleccione un vehiculo y una accion.
	 *
	 * @param args linea de comandos
	 */
	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			// Establecemos la conexión
			emf = Persistence.createEntityManagerFactory(PERSISTENCELOCAL_UNIT_NAME);
			em = emf.createEntityManager();
			
			// Obtenemos vehículo mediante menu y desde DB o recien creado según indique el usuario
			VehiculoManager vehiculoManager = new VehiculoManager(em);
			vehiculoManager.getVehiculo();
			
			// Funcionamiento
			while (!vehiculoManager.runAccion()) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
			if (emf != null && emf.isOpen()) {
				emf.close();
			}
		}

	}

}
