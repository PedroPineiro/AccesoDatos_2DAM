package manager;

import datos.Adestrador;
import datos.Pokedex;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConvertirXML {

    public void leerDatosAdestrador(List<Adestrador> adestradorL){
        try{
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("adestrador.xml"));

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("Adestradores");

            for(Adestrador adestrador: adestradorL){
                xmlStreamWriter.writeStartElement("Adestrador");
                xmlStreamWriter.writeAttribute("id",String.valueOf(adestrador.getId()));
                xmlStreamWriter.writeStartElement("Nome");
                xmlStreamWriter.writeCharacters(adestrador.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Nacemento");
                xmlStreamWriter.writeCharacters(String.valueOf(adestrador.getNacemento()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

            System.out.println("Datos de adestrador convertidos a XML");

        }catch (IOException | XMLStreamException e){
            System.out.println("Error al leer los datos de adestrador: "+e.getMessage());
        }
    }

    public void leerDatosPokedex(List<Pokedex> pokedexL){
        try{
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("pokedex.xml"));

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("Pokedex");

            for(Pokedex pokedex: pokedexL){
                xmlStreamWriter.writeStartElement("Pokedex");
                xmlStreamWriter.writeAttribute("id",String.valueOf(pokedex.getId()));
                xmlStreamWriter.writeStartElement("Nome");
                xmlStreamWriter.writeCharacters(pokedex.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Peso");
                xmlStreamWriter.writeCharacters(String.valueOf(pokedex.getPeso()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Misc");
                xmlStreamWriter.writeCharacters(pokedex.getMisc());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

            System.out.println("Datos de pokedex convertidos a XML");

        }catch (IOException | XMLStreamException e){
            System.out.println("Error al leer los datos de pokedex: "+e.getMessage());
        }
    }
}
