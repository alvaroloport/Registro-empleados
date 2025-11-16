import java.util.Scanner;

void main() {
    HashMap<Integer, String> empleados = new HashMap<Integer, String>();
    HashMap<Integer, String> departamentos = new HashMap<Integer, String>();
    Scanner teclado = new Scanner(System.in);

    MostrarMenu(teclado, empleados, departamentos);
}

public static void MostrarMenu(Scanner teclado, HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    int seleccion;
    boolean haFinalizado = false;

    while (!haFinalizado) {
        System.out.println("Menu Principal:");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Mostrar empleados");
        System.out.println("3. Actualizar empleado");
        System.out.println("4. Borrar empleado");
        System.out.println("5. Buscar empleado por id");
        System.out.println("6. Buscar empleado por departamento");
        System.out.println("7. Mostrar empleados ordenados por id");
        System.out.println("8. Vaciar registro");
        System.out.println("9. Salir");

        seleccion = teclado.nextInt();
        switch (seleccion) {
            case 1:
                AgregarEmpleado(teclado, empleados, departamentos);
                break;
            case 2:
                MostrarEmpleados(empleados, departamentos);
                break;
            case 3:
                Actualiza(teclado, empleados, departamentos);
                break;
            case 4:
                eliminar(teclado, empleados, departamentos);
                break;
            case 5:
                buscarID(teclado, empleados, departamentos);
                break;
            case 6:
                buscarDep(teclado, empleados, departamentos);
            case 7:
                ordenar(empleados, departamentos);
                break;
            case 8:
                vaciar(empleados, departamentos);
                break;
            case 9:
                haFinalizado = true;
                break;
        }
    }


}

public static void AgregarEmpleado(Scanner teclado, HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    System.out.print("Ingresa el nombre del empleado: ");
    String nombre = teclado.next();
    System.out.print("Ingresa el nombre del departamento: ");
    String dep = teclado.next();
    System.out.print("Ingresa la ID: ");
    int id = teclado.nextInt();
    empleados.put(id, nombre);
    departamentos.put(id, dep);
}

public static void MostrarEmpleados(HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    for (Map.Entry<Integer, String> entry : empleados.entrySet()) {
        System.out.println("Empleado: " + entry.getValue() + " con ID: " + entry.getKey() + " está en el departamento : "
                + departamentos.get(entry.getKey()));
    }
}

public static void Actualiza(Scanner teclado, HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    System.out.print("Introduce la ID del empleado: ");
    int numero = teclado.nextInt();
    if(empleados.containsKey(numero)) {
        System.out.print("Introduce el nombre del empleado: ");
        String nombre = teclado.next();
        empleados.put(numero, nombre);
        System.out.print("Introduce el nombre del departamento: ");
        String dep = teclado.next();
        departamentos.put(numero, dep);
    }
}

public static void eliminar(Scanner teclado, HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    System.out.print("Introduce la ID del empleado a eliminar: ");
    int ID = teclado.nextInt();
    if(empleados.containsKey(ID)) {
        empleados.remove(ID);
        departamentos.remove(ID);
    }
}

public static void buscarID(Scanner teclado, HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    System.out.print("Introduce la ID del empleado a buscar: ");
    int ID = teclado.nextInt();
    if(empleados.containsKey(ID)) {
        System.out.println("Empleados: " + empleados.get(ID) + " con ID: " + ID + " pertenece al departamento: " + departamentos.get(ID));
    }
}

public static void buscarDep(Scanner teclado, HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    System.out.print("Introduce el departamento a buscar: ");
    String dep = teclado.next();
    if(departamentos.containsValue(dep)) {
        for (Map.Entry<Integer, String> entry : departamentos.entrySet()) {
            if (entry.getValue().equals(dep)) {
                System.out.println(empleados.get(entry.getKey()));
            }
        }
    }
}

public static void ordenar(HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    TreeMap<Integer, String> empleadosSorted = new TreeMap<>(empleados);
    for (Map.Entry<Integer, String> entry : empleadosSorted.entrySet()) {
        System.out.println(empleadosSorted.get(entry.getKey()));
    }
}

public static void vaciar(HashMap<Integer, String> empleados, HashMap<Integer, String> departamentos) {
    empleados.clear();
    departamentos.clear();
}