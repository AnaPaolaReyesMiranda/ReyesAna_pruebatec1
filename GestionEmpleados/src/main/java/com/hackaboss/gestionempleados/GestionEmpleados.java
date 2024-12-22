
package com.hackaboss.gestionempleados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import logica.Persona;
import persistencia.ControladoraPersistencia;

public class GestionEmpleados {

    public static void main(String[] args) {
        
        System.out.println("Gestion de Empleados");
        
        
        ControladoraPersistencia controlPer = new ControladoraPersistencia();
        Scanner teclado = new Scanner(System.in);
        
        int opcion = 0;
        System.out.println("------------------------------------------------");
        System.out.println("         🄶🄴🅂🅃🄸🄾🄽 🄴🄼🄿🄻🄴🄰🄳🄾🅂            ");
        System.out.println("------------------------------------------------\t");
        
        
        while (true) {
            System.out.println("----------------------------------------------|");
            System.out.println("|     Seleccione la acción que desea realizar:|");
            System.out.println("----------------------------------------------|");
            System.out.println("|               1. Alta                       |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|               2. Baja                       |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|               3. Ver lista de empleados     |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|               4. Modificaciones             |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|               5. Buscar por cargo           |");
            System.out.println("----------------------------------------------|\t");
            System.out.println("|               6. Salir                      |");
            System.out.println("----------------------------------------------|\t");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); 

            switch (opcion) {
                case 1 -> { 
                    System.out.println("Ingrese el nombre del empleado: ");
                    String nombre = teclado.nextLine();
                    System.out.println("Ingrese el apellido del empleado: ");
                    String apellido = teclado.nextLine();
                    System.out.println("Ingrese el cargo:");
                    String cargo = teclado.nextLine();
                    System.out.println("Ingrese el salario:");
                    double salario = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Ingrese la fecha de inicio(formato: dd/MM/yyyy):");
                    String fecha_inicio= teclado.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = null;
                    try {
                        fecha = sdf.parse(fecha_inicio);  
                    } catch (ParseException e) {
                        System.out.println("Error al ingresar la fecha.");
                        return;
                    }
                    Persona persona = new Persona(opcion, nombre, apellido, cargo, salario, fecha);
                    controlPer.crearPersona(persona);
                    System.out.println("Empleado agregado correctamente.");
                }

                case 2 -> { 
                    System.out.println("Ingrese el id del empleado que desea eliminar:");
                    String idEliminar = teclado.nextLine();
                    boolean eliminado = false;

                    int id = Integer.parseInt(idEliminar);

                    List<Persona> listaPersonas = controlPer.traerPersonas();
                    for (Persona per : listaPersonas) {
                        if (per.getId() == id) {
                            controlPer.borrarPersona(id);
                            eliminado = true;
                            System.out.println("Empleado eliminado correctamente.");

                            break;
                        }
                    }

                    if (!eliminado) {
                        System.out.println("Empleado no encontrado.");
                    }

                }

                case 3 -> { 
                    List<Persona>listaPersonas = controlPer.traerPersonas();
                    if (listaPersonas.isEmpty()) {
                        System.out.println("No hay empleados en la lista.");
                    } else {
                        System.out.println("Lista de empleados:");
                        
                        for(Persona per : listaPersonas){
                            System.out.println(per.toString());
                        }
                    }
                }

                case 4 -> { 
                    System.out.println("Ingrese el nombre del empleado que desea modificar: ");
                    String nombreModificar = teclado.nextLine();
                    boolean encontrado = false;
                    List<Persona>listaPersonas = controlPer.traerPersonas();
                    for (Persona per : listaPersonas){
                        if (per.getNombre().equalsIgnoreCase(nombreModificar)) {
                            System.out.println("Empleado encontrado. Ingrese los nuevos datos: ");
                            System.out.println("Nuevo nombre (deje vacío para mantener el actual): ");
                            String nuevoNombre = teclado.nextLine();
                            if (!nuevoNombre.isEmpty()) {
                                per.setNombre(nuevoNombre);
                            }
                            System.out.println("Nuevo apelllido (deje vacío para mantener la actual): ");
                            String nuevaApellido = teclado.nextLine();
                            if (!nuevaApellido.isEmpty()) {
                                per.setApellido(nuevaApellido);
                            }
                            System.out.println("Nuevo cargo (deje vacío para mantener la actual): ");
                            String nuevoCargo = teclado.nextLine();                           
                            if (!nuevoCargo.isEmpty()) {
                            per.setCargo(nuevoCargo);
                            }
                            System.out.println("Nuevo salario (deje vacío para mantener la actual): ");
                            String nuevoSalario = teclado.nextLine();                           
                            if (!nuevoSalario.isEmpty()) {
                            per.setSalario(opcion);
                            }
                            System.out.println("Nueva fecha de inicio (deje vacío para mantener la actual): ");
                            String NuevaFechaInicio = teclado.nextLine();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date fecha = null;                         
                            if (!NuevaFechaInicio.isEmpty()) {
                            per.setFecha_inicio(fecha);
                            }
                            controlPer.modificarPersona(per);
                            System.out.println("Empleado modificado correctamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Empleado no encontrado.");
                    }
                }
                
                
                case 5 -> {
                    System.out.println("Ingrese el cargo del empleado que desea buscar:");
                    String nombreCargo = teclado.nextLine();
                    boolean encontrado = false;
                    List<Persona>listaPersonas = controlPer.traerPersonas();
                    for (Persona per : listaPersonas){
                        if (per.getCargo() !=null && per.getCargo().equalsIgnoreCase(nombreCargo)) {
                           System.out.println(per);
                            encontrado = true;
                          
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontraron empleados con el cargo: " + nombreCargo);
                    }
                }

                case 6 -> { 
                    System.out.println("Gracias por usar el gestor de empleados. ¡Hasta pronto!");
                    return;
                }

                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
 
     
        }
    }

