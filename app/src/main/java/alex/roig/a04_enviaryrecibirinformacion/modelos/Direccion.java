package alex.roig.a04_enviaryrecibirinformacion.modelos;

import java.io.Serializable;

public class Direccion implements Serializable {
    private String calle;
    private String numero;

    private String ciudad;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    public Direccion(String calle, int numero, String ciudad) {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
