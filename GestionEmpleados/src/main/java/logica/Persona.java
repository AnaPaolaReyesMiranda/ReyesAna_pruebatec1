
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Persona implements Serializable {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id; 
   private String nombre;
   private String apellido;
   private String cargo;
   private double salario;     
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date fecha_inicio;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String cargo, double salario, Date fecha_inicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fecha_inicio = fecha_inicio;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

   
   
   
    
    

    @Override
    public String toString() {
        return "Persona{ " + " id= " + id + " , nombre = " + nombre + ", apellido = " + apellido + ", cargo = " + cargo + ", salario = " + salario + ", fecha_inicio = " + fecha_inicio + '}';
    }

}
