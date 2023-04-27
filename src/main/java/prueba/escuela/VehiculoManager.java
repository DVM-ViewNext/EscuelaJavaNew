package prueba.escuela;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * VehiculoManager Se encarga de gestionar los Vehiculos.
 */
public class VehiculoManager {
	private Vehiculo vehiculo;
	private EntityManager em;

	public VehiculoManager(EntityManager em) {
		this.em = em;
	}

	/**
	 * Método para crear un Vehiculo siguiendo el input del usuario.
	 *
	 * @return {@link Vehiculo}
	 */
	public Vehiculo getVehiculo() {

		InputHandler inputHandler = new InputHandler();

		Integer tipoVehiculo = inputHandler.getTipoVehiculo();
		Integer dbOrCreated = inputHandler.getDBorCreated();
		String fromMatricula;

		// Si ya existe, obtenemos de DB con la matrícula
		if (dbOrCreated == 0) {

			switch (tipoVehiculo) {
			case 0: // Coche

				// Obtenemos matrícula
				fromMatricula = inputHandler.getFromMatricula();

				// Consulta en DB para obtener vehículo mediante matrícula
				CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
				CriteriaQuery<Coche> criteriaQuery = criteriaBuilder.createQuery(Coche.class);
				Root<Coche> cocheRoot = criteriaQuery.from(Coche.class);
				criteriaQuery.select(cocheRoot);
				criteriaQuery.where(criteriaBuilder.equal(cocheRoot.get("matricula"), fromMatricula));
				vehiculo = em.createQuery(criteriaQuery).getSingleResult();

				// Si la matrícula es correcta obtenemos el vehículo
				if (fromMatricula.equals(vehiculo.getMatricula()))
					return vehiculo;

				return null;
			case 1: // Moto
				return null;
			case 2: // Barco
				return null;
			case 3: // Salir
				return null;
			default: // Como default por opcion no incluida, salir
				System.out.println("No se ha encontrado una opción válida.");
				return null;
			}

		} else {

			switch (tipoVehiculo) {
			case 0: // Coche
				return createCoche();
			case 1: // Moto
				return createMoto();
			case 2: // Barco
				return createBarco();
			case 3: // Salir
				break;
			default: // Como default por opcion no incluida, salir
				System.out.println("No se ha encontrado una opción válida.");
				return null;
			}

		}

		return null; // no se ha encontrado ningun resultado valido

	}

	/**
	 * Creación de un coche desde 0
	 * 
	 * @return {@link Coche}
	 */
	private Vehiculo createCoche() {
		vehiculo = new Coche("Rojo", "Toyota", 20.000, "SADF12", "Manual");
		System.out.println("Se ha creado un vehículo de tipo Coche ");
		return vehiculo;
	}

	/**
	 * Creación de una Moto desde 0
	 * 
	 * @return {@link Moto}
	 */
	private Vehiculo createMoto() {
		Moto moto = new Moto("Negro", "Yamaha", 50.000, "YTUI78", "Motocross");
		System.out.println("Se ha creado un vehículo de tipo Moto ");
		return moto;
	}

	/**
	 * Creación de un Barco desde 0
	 * 
	 * @return {@link Barco}
	 */
	private Vehiculo createBarco() {
		Barco barco = new Barco("Rojo", "Toyota", 20.000, "VBNM76", "Yate");
		System.out.println("Se ha creado un vehículo de tipo Barco ");
		return barco;
	}

	/**
	 * pregunta y ejecuta la accion del usuario.
	 */
	public boolean runAccion() {

		InputHandler inputHandler = new InputHandler();

		Integer accion = inputHandler.getAccion();

		switch (accion) {
		case 0: // Opcion arranque
			return vehiculo.arrancar();

		case 1: // Opcion parar
			if (!vehiculo.parar())
				return false;

			// Guardado en DB
			em.getTransaction().begin();
			em.persist(vehiculo);
			em.getTransaction().commit();
			return true;

		case 2: // Opcion avanzar
			if (vehiculo.isArrancado()) {
				int metrosAvanzados = inputHandler.getMetros();
				return vehiculo.avanzar(metrosAvanzados);
			} else {
				System.out.println("No puedo avanzar con un vehiculo que no está en marcha,"
						+ "por favor arranque antes de avanzar.");
				return false;
			}

		case 3: // Opcion retroceder
			if (vehiculo.isArrancado()) {
				int metrosRetrocedidos = inputHandler.getMetros();
				return vehiculo.retroceder(metrosRetrocedidos);
			} else {
				System.out.println("No puedo retroceder con un vehiculo que no está en marcha,"
						+ "por favor arranque antes de avanzar.");
				return false;
			}
		case 4: // Opcion imprimir datos
			vehiculo.imprimirDatos();
			return false;
		case 5: // Salir
			return true;
		default: // Como default por opcion no incluida, salir
			return true;

		}

	}

}
