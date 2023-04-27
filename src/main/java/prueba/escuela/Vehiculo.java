package prueba.escuela;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;

/**
 * Vehiculo.java Clase para el objecto Vehiculo
 */
@MappedSuperclass
public abstract class Vehiculo implements Conducible {
    protected String color;
    protected String marca;
    protected double precio;
    protected String matricula;
    protected int numRuedas;
    private boolean arrancado = false;
    protected static final String TIPO = "Vehiculo";

    // Variables del viaje
    protected Date horaInicio;
    protected int distanciaRecorrida = 0;

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param color     color del vehiculo
     * @param marca     marca del vehiculo
     * @param precio    precio del vehiculo
     * @param matricula matricula del vehiculo
     * @param numRuedas numero de ruedas del vehiculo
     */
    protected Vehiculo(String color, String marca, double precio, String matricula, int numRuedas) {

        this.numRuedas = numRuedas;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
        this.matricula = matricula;

    }

    /**
     * Impresión de los datos del vehiculo.
     */
    public void imprimirDatos() {
        System.out.println("La marca es: " + marca);
        System.out.println("El color es: " + color);
        System.out.println("La matricula es: " + matricula);
        System.out.println("El precio es: " + precio);
    }

    /**
     * Devuelve el color.
     *
     * @return String color
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color.
     *
     * @param color String color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve el precio.
     *
     * @return String precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio.
     *
     * @param precio String precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la marca.
     *
     * @return String marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene la matricula.
     *
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Obtiene el número de ruedas.
     *
     */
    public int getnumRuedas() {
        return numRuedas;
    }

    /**
     * Indica si está arrancado 
     * 
     * @return boolean si está arrancado o no
     */
    public boolean isArrancado() {
        return this.arrancado;
    }

    /**
     * Obtiene el estado actual del vehículo, arrancado (true) o apagado (false)
     * 
     * @return
     */
    public boolean getArrancado() {
        return this.arrancado;
    }

    /**
     * Establece si el vehiculo está apagado o no
     * 
     * @param arrancado
     */
    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    /**
     * Arranca el vehiculo.
     *
     * @return boolean Indica si como parte de esta accion el viaje termina
     */
    public boolean arrancar() {

        if (isArrancado()) {
            System.out.println(
                    "El "
                            + TIPO
                            + " ya está en marcha, por favor pare antes de volver a arrancar.");
            return false;
        } else {
            setArrancado(true);
            this.horaInicio = new Date();
            System.out.println("Viaje iniciado en "
                    + TIPO
                    + " "
                    + this.horaInicio);
            return false;
        }

    }

    /**
     * para el vehiculo.
     *
     * @return boolean
     */
    public boolean parar() {
        // Si el vehiculo está en marcha, lo paramos y reseteamos la hora inicio y
        // distancia recorrida.

        if (!isArrancado()) {
            System.out.println(
                    String.format(
                            "El %s no está en marcha, "
                                    + "por favor arránquelo "
                                    + "antes de retroceder.",
                            TIPO));
            return false;
        } else if (this.horaInicio != null) {
            long velocidad = (this.distanciaRecorrida)
                    / ((new Date().getTime() - this.horaInicio.getTime()) / 1000);

            System.out.println("Detenidos en " + new Date() + ", habiendo empezado el viaje en "
                    + this.horaInicio + " el cual a recorrido " + this.distanciaRecorrida
                    + " metros, a una velocidad de " + velocidad + "m/s");

            this.horaInicio = null;
            this.distanciaRecorrida = 0;
            setArrancado(false);
            return true;
        } else {
            System.out.println(
                    "Ha ocurrido un error en el motor.");
            return false;
        }

    }

    /**
     * retrocede el coche.
     *
     * @return boolean
     */
    public boolean retroceder(int distancia) {
        // Mira si el vehiculo está en marcha y si su distancia recorrida es menor a la
        // que se quiere retroceder, si es correcto, retrocede
        if (!isArrancado()) {
            System.out.println(
                    "El coche no está en marcha, por favor arráquelo antes de retroceder.");
            return false;
        } else if (this.distanciaRecorrida >= distancia && this.horaInicio != null) {
            this.distanciaRecorrida -= distancia;
            System.out.println("Se han avanzado " + this.distanciaRecorrida
                    + " metros desde el inicio " + this.horaInicio + " hasta ahora "
                    + new Date());
            return false;
        } else {
            System.out.println("No se puede retroceder más de lo que se ha avanzado.");
            return false;
        }

    }

    /**
     * avanza el vehiculo los metros especificados.
     *
     * @param distancia int metros a avanzar
     * @return boolean
     */
    public boolean avanzar(int distancia) {
        // Si el vehiculo esta en marcha, avanza distancia
        if (isArrancado()) {
            this.distanciaRecorrida += distancia;

            System.out.println("Se han avanzado " + this.distanciaRecorrida
                    + " metros desde el inicio " + this.horaInicio + " hasta ahora "
                    + new Date());
            return false;
        } else {
            System.out.println(
                    "El " + TIPO + " aún no está en marcha, por favor arranque antes de avanzar.");
            return false;
        }

    }

}
