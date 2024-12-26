# **Gestión de Empleados**

## **Descripción**
Aplicación de consola en Java para gestionar empleados.

## **Funcionalidades:**

- **Alta de empleados:** Permite ingresar nuevos empleados con nombre, apellido, cargo, salario y fecha de inicio.
- **Baja de empleados:** Permite eliminar un empleado mediante su ID.
- **Visualización de empleados:** Muestra una lista de todos los empleados registrados.
- **Modificación de empleados:** Permite modificar la información de un empleado específico.
- **Búsqueda por cargo:** Busca empleados según el cargo y muestra sus detalles.

## **Programas Utilizados:**

- **JDK 17:** Necesario para compilar y ejecutar el código.
- **NetBeans 17:** IDE con el que se desarrolló la aplicación.
- **MySQL:** Base de datos para almacenar los datos de los empleados.
- **JPA (Java Persistence API):** Para interactuar con la base de datos.
- **ControladoraPersistencia:** Encargada de las operaciones CRUD (crear, leer, actualizar, eliminar) sobre la base de datos.

## **Supuestos**

- **Variable ID para cada empleado:** Se ha añadido una variable `id` para identificar de manera única a cada empleado en la base de datos. 
  Esto es importante ya que un empleado puede tener el mismo nombre y apellido que otro, pero con un id único se puede garantizar que cada registro es único y fácil de identificar. 
  La variable `id` se gestiona automáticamente en la base de datos como un campo autoincremental.

## **Excepciones utilizadas:**

- **IllegalArgumentException:** Se utiliza para evitar la duplicación de empleados con el mismo nombre y cargo. Si un empleado con el mismo nombre y cargo ya existe, se lanza esta excepción para notificar al usuario que el registro no puede ser duplicado.

- **ParseException:** Se utiliza cuando el formato de la fecha de inicio ingresada no es válido. Si el usuario ingresa un formato incorrecto (que no sea `dd/MM/yyyy`), se lanza esta excepción.
