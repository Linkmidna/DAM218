package org.example;

import controlador.Controlador;
import modelo.Cancion;
import modelo.Grupo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Cancion> canciones;
    private static List<Grupo> grupos;
    private static Controlador controlador;
    public static void main(String[] args) {
        controlador=new Controlador();
        cargarDatos();
        //listAllCancionesGrupos();
        String opcion;
        do{
            opcion=menu();
            realizar(opcion);
        }while(!opcion.equals("0"));
    }

    private static String menu() {
        System.out.println("""
                1.- Grupos y canciones
                2.- Canciones y grupo
                3.- Canciones del grupo
                4.- Modificar duración de canción
                5.- Modificar grupo de canción
                6.- Eliminar canción
                7.- Añadir canción
                0.-         SALIR
                """);
        return  (new Scanner(System.in).nextLine());
    }

    private static void realizar(String opcion) {
        switch (opcion){
            case "1"->listAllCancionesGrupos();
            case "2"->listAllCanciones();
            case "3"->{
                System.out.println("Escribe el código del grupo");
                int numGrupo=new Scanner(System.in).nextInt();
                listCancionesGrupo(numGrupo);
            }
            case "4"->modDuracionCancion();
            case "5"->modGrupoDeCancion();
            case "6"->delCancion();
            case "7"->addCancion();
        }
    }




    public static void cargarDatos(){
        canciones=controlador.cargarCanciones();
        grupos=controlador.cargarGrupos();
        asignarGruposACanciones();
        asignarCancionesAGrupos();
    }


    private static void asignarCancionesAGrupos() {
        for (Cancion c:canciones) {
            int grupoDeCancion=c.getIdGrupo();
            //para cada cancion se busca el grupo cuyo id sea igual a grupoDeCancion
            //No hay que comprobar que no exista el grupo
            // ya que en la BD toda canción está asociada a un grupo existente
            for(Grupo g:grupos){
                if(g.getId()==grupoDeCancion){
                    //se añade la canción a la lista de canciones del grupo g
                    g.getCanciones().add(c);
                }
            }
        }
    }
    //Mismo método que el anterior, y realizado con Lambda
    private static void asignarCancionesAGrupos2() {
        canciones.forEach(c->{
            Optional<Grupo> opt=grupos.stream()
                    .filter(g->g.getId()==c.getIdGrupo())
                    .findFirst();
            opt.get().addCancion(c);
        });
    }
    private static void asignarGruposACanciones() {
        for (Cancion c:canciones) {
            int grupoDeCancion=c.getIdGrupo();
            //para cada cancion se busca el grupo cuyo id sea igual a grupoDeCancion
            //No hay que comprobar que no exista el grupo
            // ya que en la BD toda canción está asociada a un grupo existente
            for(Grupo g:grupos){
                if(g.getId()==grupoDeCancion){
                    //se asigna el objeto Grupo g a la Canción c
                    c.setGrupo(g);
                }
            }
        }
    }
    //Mismo método realizado con expresión Lambda
    private static void asignarGruposACanciones2() {
        canciones.forEach(c->{
            Optional<Grupo> opt=grupos.stream()
                    .filter(g->g.getId()==c.getIdGrupo())
                    .findFirst();
            c.setGrupo(opt.get());
        });
    }

    private static void listAllCancionesGrupos() {
        grupos.forEach(g-> {
            System.out.println("GRUPO: "+g.getId()+" - "+g.getNombre());
            g.getCanciones().forEach(c-> System.out.println("\t"+c.getTitulo()));
        });
    }

    private static void listAllCanciones() {
        //Ordenar la lista por título
        canciones
                .sort(Comparator.comparing(Cancion::getTitulo));
        canciones.forEach(c-> System.out.println(
                c.getTitulo()+" - "+
                c.getNum()+" - "+
                c.getDuracion()+" - "+
                c.getGrupo().getNombre()));

    }

    private static Cancion buscarCancion(int numCancion) {
        Cancion c=null;
        for(Cancion cancion:canciones){
            if(cancion.getNum()==numCancion){
                c=cancion;
            }
        }
        return c;
    }

    private static Grupo buscarGrupo(int idGrupo) {
        Grupo g=null;
        for(Grupo grupo:grupos){
            if(grupo.getId()==idGrupo){
                g=grupo;
            }
        }
        return g;
    }
    private static void listCancionesGrupo(int idGrupo) {
        Grupo g=buscarGrupo(idGrupo);
        if(g==null){
            System.out.println("No existe grupo con ese código");
        }
        else{
            System.out.println("GRUPO: "+g.getNombre());
            if(g.getCanciones().isEmpty()){
                System.out.println("El grupo no tiene canciones cargadas");
            }
            else{
                g.getCanciones()
                        .forEach(c-> System.out.println(c.getNum()+" - "+c.getTitulo()+" - "+c.getDuracion()));
            }

        }

    }

    private static void modDuracionCancion() {
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce el número de la canción a modificar");
        int numCancion=tec.nextInt();
        //vacíar buffer de teclado
        tec.nextLine();
        Cancion c=buscarCancion(numCancion);

        if(c==null){
            System.out.println("No existe la canción");
        }
        else{
            System.out.println(c.getTitulo()+" - "+c.getDuracion()+" - votos="+
                    c.getTotalVotos()+" - "+c.getGrupo().getNombre());
            String texto;
            boolean ok=false;
            System.out.println("Escribe la duración de la canción en formato mm:ss");
            do{
                texto=tec.nextLine();
                DateTimeFormatter dt=DateTimeFormatter.ofPattern("mm:ss");
                try {
                    dt.parse(texto);
                    //LocalTime.parse(texto, dt);
                    ok=true;
                }
                catch(DateTimeParseException ex){
                    System.out.println("El formato de la duración es incorrecto, debe ser mm:ss");
                }
            }while(!ok);
            c.setDuracion("00:"+texto);
            if(controlador.updateCancion(c)){
                System.out.println("Se ha realizado correctamente la modificación");
                cargarDatos();
            }
            else{
                System.err.println("Se ha producido un error en la modificación de la duración");
            }
        }
    }


    private static void modGrupoDeCancion() {
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce el número de la canción a modificar");
        int numCancion=tec.nextInt();
        Cancion c=buscarCancion(numCancion);
        if(c==null){
            System.out.println("No existe la canción");
        }
        else{
            System.out.println(c.getTitulo()+" - "+c.getDuracion()+" - votos="+
                    c.getTotalVotos()+" - "+c.getGrupo().getNombre());
            System.out.println("Pulsa ENTER para ver los grupos y elegir el grupo");
            //Un nextLine es para vacíar buffer por haber capturado antes con nextInt
            tec.nextLine();
            tec.nextLine();
            escribeGrupos();
            System.out.println("\n Escribe el número de grupo al que vas a asignar la canción");
            int idGrupo=tec.nextInt();
            if(buscarGrupo(idGrupo)==null){
                System.out.println("NO existe grupo con ese código, no se ha realizado modificación");
            }
            else{
                //Con asignar el id sirve. NO hace falta asignar el grupo a la cancion
                //ni cambiar la cancion al nuevo grupo
                //ya que todo eso se hace al llamar al método cargarDatos
                c.setIdGrupo(idGrupo);
                if(controlador.updateCancion(c)){
                    System.out.println("Se ha realizado correctamente la modificación");
                    cargarDatos();
                }
                else{
                    System.err.println("Se ha producido un error en la modificación del grupo");
                }
            }
        }
    }



    private static void delCancion() {
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce el número de la canción");
        int numCancion=tec.nextInt();
        //vaciar buffer de teclado para siguiente nextLine de recoger respuesta a eliminar
        tec.nextLine();
        Cancion c=buscarCancion(numCancion);
        if(c==null){
            System.out.println("No existe canción con ese número");
        }
        else{
            System.out.println("Ojo! vas a aliminar la canción de título "+c.getTitulo());
            System.out.println("Escribe S para confirmar la eliminación, otro carácter para cancelar");
            String resp=tec.nextLine();
            if(resp.equalsIgnoreCase("S")){
                if(controlador.deleteCancion(c)){
                    System.out.println("Se ha realizado correctamente la eliminación");
                    cargarDatos();
                }
                else{
                    System.err.println("Se ha producido un error en la eliminación de la canción");
                }
            }
        }


    }

    private static void addCancion() {
        Scanner tec=new Scanner(System.in);
        System.out.println("Título de la canción?");
        String tit=tec.nextLine();
        System.out.println("\n ID del grupo al que pertenece la canción?");
        boolean encontrado=false;
        int idGrupo=tec.nextInt();
        do {
            Grupo g=buscarGrupo(idGrupo);
            if(g==null) {
                System.out.println("No existe un grupo con ese ID. Escribe otro ID de grupo");
                idGrupo=tec.nextInt();
            }
            else {
                System.out.println("El grupo que has seleccionado es "+g.getNombre());
                encontrado=true;
            }

        }while(!encontrado);
        //Recoger la duración de la canción
        String texto;
        boolean ok=false;
        System.out.println("Escribe la duración de la canción en formato mm:ss");
        do{
            texto=tec.nextLine();
            DateTimeFormatter dt=DateTimeFormatter.ofPattern("mm:ss");
            try {
                dt.parse(texto);
                //LocalTime.parse(texto, dt);
                ok=true;
            }
            catch(DateTimeParseException ex){
                System.out.println("El formato de la duración es incorrecto, debe ser mm:ss");
            }
        }while(!ok);

        //Instanciar un objetoi Cancion para después añadir sus datos a BD
        Cancion c=new  Cancion();
        c.setTitulo(tit);
        c.setDuracion("00:"+texto);
        c.setIdGrupo(idGrupo);
        c.setTotalVotos(0);
        if(controlador.insertCancion(c)){
            System.out.println("Se ha añadido correctamente la canción");
            cargarDatos();
        }
        else{
            System.err.println("Se ha producido un error al añadir la canción");
        }

    }
    private static void escribeGrupos() {
        grupos.forEach(g-> System.out.println(g.getId()+"-"+g.getNombre()));
    }

}