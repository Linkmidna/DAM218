package org.Ejercicio1;

import java.sql.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();

        if (con != null) {
            //Ejecutamos programa
            Scanner sc = new Scanner(System.in);

            System.out.println("Las caterorias existentes son:");
            /*
                    SE PUEDE MOSTRAR MEDIANTE CONSULTA SQL

                    SELECT categoria FROM preguntas
                    group by categoria;
             */
            System.out.println("CIE\t DEP\t GEO\t MUS\t SER\t");
            System.out.println("Indica el tipo de categoria");
            String categoria = sc.next().toUpperCase();


            //Escribimos la instruccion
            String consulta = "SELECT preguntas.num_preg, enunciado, num_resp, texto_resp " +
                    "FROM preguntas INNER JOIN respuestas " +
                    "ON preguntas.num_preg=respuestas.num_preg " +
                    "WHERE categoria=?;";

            PreparedStatement prepSt = null;
            ResultSet r = null;

            try {
                prepSt = con.prepareStatement(consulta);
                prepSt.setString(1, categoria);
                r = prepSt.executeQuery();

                int numPreguntaAnterior = 0;
                while (r.next()) {

                    int numPregunta = r.getInt(1);
                    //El numero de pregunta, corresponde al mismo enunciado
                    //Por lo tanto, el numero de la pregunta va junto a su enunciado
                    if (numPregunta!=numPreguntaAnterior) {
                        System.out.println("Numero de pregunta " +numPregunta +":");
                        numPreguntaAnterior = numPregunta;
                        String enunciado = r.getString(2);
                        System.out.println("  Enunciado: " + enunciado);
                    }

                    int numeroRespuesta = r.getInt(3);
                    String respuestaPreg = r.getString(4);
                    System.out.println("\tNumero respuesta: " +numeroRespuesta+ "\tRespuesta: " +respuestaPreg);

                    //Pedimos un intro, para que nos de la siguiente respuesta
                    sc.nextLine();
                }

                r.close();
                prepSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("ERROR DE CONEXION");
        }

        }
    }
