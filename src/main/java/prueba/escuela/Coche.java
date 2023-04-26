package prueba.escuela;

import jakarta.persistence.*;

/**
 * Coche.java Clase para el objecto Coche
 */
@Entity
@Table(name = "coche")
public class Coche extends Vehiculo {

	@Id
	@SequenceGenerator(
			name = "libro_id_seq",
			sequenceName = "libro_id_seq",
			allocationSize = 1,
			initialValue = 100
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "libro_id_seq"
			)
	private int id;
	
    private String tipoMarchas;
    
    //protected static final String TIPO = "Coche";

    /**
     * Constructor de la clase Coche.
     *
     * @param color       color del vehiculo
     * 
     * @param marca       marca del vehiculo
     * 
     * @param precio      precio del vehiculo
     * 
     * @param matricula   matricula del vehiculo
     * 
     * @param tipoMarchas tipo de marchas del coche
     * 
     */
    public Coche(String color, String marca, String precio, String matricula, String tipoMarchas) {
        super(color, marca, precio, matricula, 4); // Siempre tiene 4 ruedas si es un coche
        this.tipoMarchas = tipoMarchas;

    }

    /**
     * Devuelve el tipo de marchas
     * 
     * @return String tipo de marchas
     */
    public String getTipoMarchas() {
        return tipoMarchas;
    }

    
    @Override
    public void imprimirDatos() {
        System.out.println("Este vehiculo es un coche");
        System.out.println("Este coche tiene una marcha " + tipoMarchas);
        super.imprimirDatos();
    }

}
