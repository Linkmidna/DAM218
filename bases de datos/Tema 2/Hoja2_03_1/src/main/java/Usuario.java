import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Usuario {
    private String user;
    private String passwd;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;
    private int numVotos;

    public Usuario() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public void recogerDatos(){
        Scanner tec=new Scanner(System.in);
        System.out.println("INTRODUCIR DATOS DE NUEVO USUARIO\n"+
                "----------------------------------");
        System.out.println("Apellidos : ");
        apellidos=tec.nextLine();
        System.out.println("Nombre : ");
        nombre=tec.nextLine();
        System.out.println("Usuario : ");
        user=tec.nextLine();
        System.out.println("Contraseña : ");
        String passwordAux=tec.nextLine();
        do {
            System.out.println("Repite la contraseña : ");
            passwd=tec.nextLine();

        }while(!passwd.equals(passwordAux));

        boolean fechaOK=false;
        do{
            System.out.println("Fecha de nacimiento (formato aaaa-mm-dd) : ");

            String fecha=tec.nextLine();
            try {
                //para comprobar que, aun respetando el formato, los valores de mes y dia son correctos
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate f=LocalDate.parse(fecha,formatter);
                fechaOK=true;
            }
            catch (DateTimeParseException ex) {
                System.out.println("La fecha es incorrecta ");
            }

        }while(!fechaOK);
    }

}

