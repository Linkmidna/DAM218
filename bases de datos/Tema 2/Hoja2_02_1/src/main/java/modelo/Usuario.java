package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Usuario {
    private int id;
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;
    private int numAccesos;
    private int testRealizados;
    private float puntuacionMedia;

    public Usuario(String usuario, String password, String nombre, String apellidos, LocalDate fecha_nac) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fecha_nac;
        numAccesos=0;
        testRealizados=0;
        puntuacionMedia=0;
    }

    public Usuario() {
        numAccesos=0;
        testRealizados=0;
        puntuacionMedia=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getNumAccesos() {
        return numAccesos;
    }

    public void setNumAccesos(int numAccesos) {
        this.numAccesos = numAccesos;
    }

    public int getTestRealizados() {
        return testRealizados;
    }

    public void setTestRealizados(int testRealizados) {
        this.testRealizados = testRealizados;
    }

    public float getPuntuacionMedia() {
        return puntuacionMedia;
    }

    public void setPuntuacionMedia(float puntuacionMedia) {
        this.puntuacionMedia = puntuacionMedia;
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
        usuario=tec.nextLine();
        System.out.println("Contraseña : ");
        String passwordAux=tec.nextLine();
        do {
            System.out.println("Repite la contraseña : ");
            password=tec.nextLine();

        }while(!password.equals(passwordAux));

        //Creamos un formateador de una Date para fecha
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        boolean fechaOK=false;
        do{
            System.out.println("Fecha de nacimiento (formato aaaa-mm-dd) : ");

            String fecha=tec.nextLine();
            try {

                //para comprobar que, aun respetando el formato, los valores de mes y dia son correctos
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                fechaNac=LocalDate.parse(fecha,formatter);
                fechaOK=true;
            }
            catch (DateTimeParseException ex) {
                System.out.println("La fecha es incorrecta ");
            }

        }while(!fechaOK);
    }
}

