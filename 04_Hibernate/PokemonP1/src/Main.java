import datos.Pokedex;
import manager.PokemonManager;

public class Main {
    public static void main(String[] args) {

        PokemonManager pokemonManager = new PokemonManager();

        pokemonManager.insertarPokemon(new Pokedex("Bulbasaur", 6.9, "Pequeño Pokémon cuadrúpedo de tipo planta y veneno, que se caracteriza principalmente por el bulbo de color verde oscuro que tiene en su lomo"));
        pokemonManager.insertarPokemon(new Pokedex("Charmander", 8.5, "Pequeño Pokémon bípedo de tipo fuego, que se caracteriza principalmente por la llama que tiene en la punta de su cola"));
        pokemonManager.insertarPokemon(new Pokedex("Squirtle", 9.0, "Pequeño Pokémon bípedo de tipo agua, que se caracteriza principalmente por su caparazón de color azul oscuro"));
        pokemonManager.insertarPokemon(new Pokedex("Pikachu", 6.0, "Pequeño Pokémon bípedo de tipo eléctrico, que se caracteriza principalmente por sus mejillas de color rojo y sus orejas puntiagudas"));
        pokemonManager.insertarPokemon(new Pokedex("Jigglypuff", 5.5, "Pequeño Pokémon bípedo de tipo normal y hada, que se caracteriza principalmente por su cuerpo redondo y su voz hipnótica"));
        pokemonManager.insertarPokemon(new Pokedex("Meowth", 4.2, "Pequeño Pokémon bípedo de tipo normal, que se caracteriza principalmente por su moneda en la frente y su habilidad para hablar"));
        pokemonManager.insertarPokemon(new Pokedex("Psyduck", 19.6, "Pequeño Pokémon bípedo de tipo agua, que se caracteriza principalmente por su cabeza amarilla y su constante dolor de cabeza"));
        pokemonManager.insertarPokemon(new Pokedex("Growlithe", 41.9, "Pequeño Pokémon cuadrúpedo de tipo fuego, que se caracteriza principalmente por su pelaje naranja y su lealtad"));
        pokemonManager.insertarPokemon(new Pokedex("Poliwag", 27.3, "Pequeño Pokémon bípedo de tipo agua, que se caracteriza principalmente por su vientre transparente y su habilidad para nadar"));
        pokemonManager.insertarPokemon(new Pokedex("Abra", 43.0, "Pequeño Pokémon bípedo de tipo psíquico, que se caracteriza principalmente por su habilidad para teletransportarse"));


        pokemonManager.listarPokemons();

        pokemonManager.modificarPokemon_enPokedex(1, "Ivisaur");
        pokemonManager.modificarPokemon_enPokedex(2, "Charmeleon");

    }
}