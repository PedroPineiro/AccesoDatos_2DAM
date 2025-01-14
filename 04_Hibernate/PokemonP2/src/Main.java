import datos.Adestrador;
import datos.Pokedex;
import manager.AdestradorManager;
import manager.ConvertirXML;
import manager.PokedexManager;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PokedexManager pokedexManager = new PokedexManager();
        AdestradorManager adestradorManager = new AdestradorManager();
        ConvertirXML convertirXML = new ConvertirXML();

        pokedexManager.insertarPokemon(new Pokedex("Lucario", 54.0, "Tipo lucha"));
        pokedexManager.insertarPokemon(new Pokedex("Blaziken", 52.0, "Tipo fuego"));
        pokedexManager.insertarPokemon(new Pokedex("Greninja", 40.0, "Tipo agua"));
        pokedexManager.insertarPokemon(new Pokedex("Charizard", 90.5, "Tipo fuego"));
        pokedexManager.insertarPokemon(new Pokedex("Pikachu", 6.0, "Tipo electrico"));
        pokedexManager.insertarPokemon(new Pokedex("Gengar", 40.5, "Tipo fantasma"));
        pokedexManager.insertarPokemon(new Pokedex("Gyarados", 235.0, "Tipo agua"));
        pokedexManager.insertarPokemon(new Pokedex("Mewtwo", 122.0, "Tipo psiquico"));
        pokedexManager.insertarPokemon(new Pokedex("Rayquaza", 206.5, "Tipo dragon"));
        pokedexManager.insertarPokemon(new Pokedex("Arceus", 320.0, "Tipo normal"));

        adestradorManager.insertarAdestrador(new Adestrador("Ash", new Date(1990,12,9)));
        adestradorManager.insertarAdestrador(new Adestrador("Misty", new Date(1992,8,13)));

        pokedexManager.listarPokemons();
        adestradorManager.listarAdestradores();

        pokedexManager.modificarPokemon(1,"Bulbasaur");
        pokedexManager.modificarPokemon(2,"Charmander");

        adestradorManager.modificarAdestrador(1,"Maximo");
        adestradorManager.modificarAdestrador(2,"Cintia");

        pokedexManager.listarPokemons();
        adestradorManager.listarAdestradores();

        convertirXML.leerDatosAdestrador(adestradorManager.listarAdestradores());
        convertirXML.leerDatosPokedex(pokedexManager.listarPokemons());

        pokedexManager.borrarTabla();
        adestradorManager.borrarTabla();









    }
}