package org.example;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
    public static void main(String[] args) {
        JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(Universidad.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Universidad uni = (Universidad) jaxbUnmarshaller.unmarshal(new File("universidad.xml"));

            System.out.println("Escribe el codigo del departamento a buscar");
            String cod = new Scanner(System.in).nextLine();

            List<Departamento> listaFiltrada=
                    uni.getListaDepartamentos().stream()
                            .filter(dep -> dep.getCodigo().equalsIgnoreCase(cod))
                            .collect(Collectors.toList());
            if (listaFiltrada.size()==0){
                System.out.println("No hay departamento con ese codigo");
            }
            else{
                Departamento dep = listaFiltrada.get(0);
                System.out.println("codigo="+dep.getCodigo()+", tipo="+dep.getTipo()+", telefono="+dep.getTelefono());
                System.out.println("LISTA DE EMPLEADOS");
                dep.getListaEmpleados().stream().forEach(emp -> System.out.println(emp.getNombre()+", puesto: "+emp.getPuesto()+", salario: "+emp.getSalario()));
            }
        }catch (JAXBException JAXBE){
            System.out.println("Error: " + JAXBE.getMessage());
        }
    }
}