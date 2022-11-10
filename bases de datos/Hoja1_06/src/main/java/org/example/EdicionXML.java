package org.example;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class EdicionXML {
    Document doc;

    public int abrir_XML_DOM(File fichero)
    {
        doc=null;

        try{
            //Se crea un objeto DocumentBuiderFactory.
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            //Indica que el modelo DOM no debe contemplar los comentarios que tenga el XML. Es decir, cuando se convierte
            //el XML al modelo DOM los comentarios que tenga serán ignorados.
            factory.setIgnoringComments(true);
            //Ignora los espacios en blanco. Si no se hace esto entonces los espacios en blanco aparecen como nodos.
            factory.setIgnoringElementContentWhitespace(true);
            //Se crea un objeto DocumentBuilder para cargar en él la estructura de árbol DOM a partir del XML seleccionado.
            DocumentBuilder builder=factory.newDocumentBuilder();

            //Interpreta (parsea) el documento XML (file) y genera el DOM equivalente.
            doc=builder.parse(fichero);
            //Ahora doc apunta al árbol DOM listo para ser recorrido.
            return 0;

        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    protected ArrayList<String> procesarAtributos(Node nodo){
        ArrayList<String> datos= new ArrayList();

        System.out.println("ATRIBUTOS DE ELEMENTO "+nodo.getNodeName());

        //Para saber cuantos atributos tiene el nodo
        int num=nodo.getAttributes().getLength();
        for (int i=0;i<num;i++){
            //De la lista de atributos añade al ArrayList el nombre de cada atributo y su valor
            //Cada vez se añaden dos valores al ArrayList
            // en las posiciones parea habrá nombres de atributos y en las impares valores de atributos
            datos.add(nodo.getAttributes().item(i).getNodeName());
        }
        return datos;
    }

    protected String [] procesarFutbolista(Node nodo)    {
        String [] datos=new String[4];
        Node ntemp=null;
        int contador=0;

        //Obtiene los hijos del Alumno. Entre ellos están lo Elements nombre y edad)
        NodeList nodos=nodo.getChildNodes();
        for (int i=0; i<nodos.getLength(); i++)
        {
            ntemp = nodos.item(i);
            //Se debe comprobar el tipo de nodo que se quiere tratar por que es posible que haya
            //nodos tipo TEXT que contengan retornos de carro al cambiar de línea en el XML.
            //En este ejemplo, cuando detecta un nodo que no es tipo ELEMENT_NODE es porque es tipo TEXT
            // y contiene los retornos de carro "\n" que se incluyen en el fichero de texto al crear el XML.
            if(ntemp.getNodeType()==Node.ELEMENT_NODE){
                //IMPORTANTE: para obtener el texto con el título accede al nodo TEXT hijo de ntemp y saca su valor.
                datos[contador]=ntemp.getChildNodes().item(0).getNodeValue();
                contador++;
            }
        }
        return datos;
    }

    public String recorrerDOMyMostrar() {
        String datos_nodo[] = null;
        String salida = "";
        Node node;

        //Obtiene el primero nodo del DOM
        Node raiz = doc.getFirstChild();

        //Muestra los atributos de raiz

        System.out.println("Futbolistas: ");

        //Obtiene una lista de nodos con todos los nodos hijo del raiz (de Alumnos)
        NodeList nodelist = raiz.getChildNodes();
        for (int i = 0; i < nodelist.getLength(); i++) //Proceso los nodos hijo
        {
            node = nodelist.item(i);
            //Al ejecutar paso a paso este código, se observa como los nodos que encuentra son
            // de tipo 1 (ELEMENT_NODE) y tipo 3 (TEXT_NODE). Esto es porque en DOM todo elemento tiene un nodo
            //hijo TEXT aunque esté en blanco.
            if (node.getNodeType() == Node.ELEMENT_NODE) { //Es un nodo Alumno que hay que procesar si es de tipo Elemento
                datos_nodo = procesarFutbolista(node);
                salida += "\n " + "ID: " + datos_nodo[0];
                salida = salida + "\n " + "Alias: " + datos_nodo[1];
                salida = salida + "\n " + "Puesto: " + datos_nodo[2];
                salida = salida + "\n " + "Altura: " + datos_nodo[3];
                salida = salida + "\n  -------------------";
            }
        }
        return salida;
    }

        public String recorrerDOMyMostrarFiltrado(String id){
            String datos_nodo[]=null;
            String salida="";
            Node node;

            //Obtiene el primero nodo del DOM
            Node raiz=doc.getFirstChild();

            //Muestra los atributos de raiz

            System.out.println("Futbolistas: ");

            //Obtiene una lista de nodos con todos los nodos hijo del raiz (de Alumnos)
            NodeList nodelist=raiz.getChildNodes();
            for (int i=0; i<nodelist.getLength(); i++) //Proceso los nodos hijo
            {
                node = nodelist.item(i);
                //Al ejecutar paso a paso este código, se observa como los nodos que encuentra son
                // de tipo 1 (ELEMENT_NODE) y tipo 3 (TEXT_NODE). Esto es porque en DOM todo elemento tiene un nodo
                //hijo TEXT aunque esté en blanco.
                if(node.getNodeType()==Node.ELEMENT_NODE){ //Es un nodo Alumno que hay que procesar si es de tipo Elemento
                    datos_nodo= procesarFutbolista(node);
                    if (datos_nodo[0].equalsIgnoreCase(id)){
                        salida += "\n " + "ID: " + datos_nodo[0];
                        salida=salida + "\n " + "Alias: " + datos_nodo[1];
                        salida=salida + "\n " + "Puesto: " + datos_nodo[2];
                        salida=salida + "\n " + "Altura: " + datos_nodo[3];
                        salida=salida + "\n  -------------------";
                    }

                }
            }
            return salida;

    }
    public void addFutbolista(Futbolista fut){
        Element elementFutbolista = doc.createElement("Futbolista");
        //Añadimos el elemento "Futbolista" al nodo "Futbolistas"
        Node node = doc.getFirstChild();
        node.appendChild(elementFutbolista);
        //Creamos un nodo nuevo para el numero del futbolista
        Element elementNum = doc.createElement("num");
        //Le asignamos que sea de tipo texto y lo rellenamos
        elementNum.appendChild(doc.createTextNode(String.valueOf(fut.getNum())));
        //Y ahora lo añadimos al nodo Futbolista
        elementFutbolista.appendChild(elementNum);
        //Añadimos otro nodo con valor para el alias del futbolista
        Element elementAlias = doc.createElement("alias");
        Text textAlias = doc.createTextNode(fut.getAlias());
        elementAlias.appendChild(textAlias);
        elementFutbolista.appendChild(elementAlias);
        //Añadimos atributo al nodo futbolista (no es necesario añadir el alias a la vez que el atributo)
        elementFutbolista.setAttribute("equipo", fut.getCodEq());
        //Añadimos otro nodo para la posición en el campo
        Element elementPos = doc.createElement("posicion");
        elementPos.appendChild(doc.createTextNode(String.valueOf(fut.getPuesto())));
        elementFutbolista.appendChild(elementPos);
        //Añadimos un ultimo nodo para la altura
        Element elementAltura = doc.createElement("altura");
        elementAltura.appendChild(doc.createTextNode(String.valueOf(fut.getAltura())));
        elementFutbolista.appendChild(elementAltura);
    }
}
