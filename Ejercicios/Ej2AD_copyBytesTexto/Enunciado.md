# Traballo con Fluxos de Bytes en Java

Neste exercicio traballaremos cos fluxos de bytes, utilizando as clases `FileInputStream` e `FileOutputStream`.

### Clase `FileInputStream`
A clase `FileInputStream` permite ler bytes dun ficheiro no sistema. Usaremos o método `read()` para ler os bytes de forma individual. O valor retornado será `-1` cando se alcance o fin do ficheiro, polo que debemos preguntar por este valor para detectar o final do ficheiro e non facer máis lecturas que xerarán un erro.

### Clase `FileOutputStream`
A clase `FileOutputStream` permite escribir bytes nun ficheiro no sistema. Usaremos o método `write()` para escribir os bytes.  
Ademais, a clase `FileOutputStream` ten un constructor que acepta un segundo parámetro tipo booleano. Se este parámetro é `true`, o ficheiro abrirase en modo *append* (engadir), é dicir, cando escribimos neste ficheiro, o seu contido non se sobreescribirá, senón que se engadirá ao final do ficheiro.

**Nota importante:**  
Lembrar pechar o obxecto `OutputStream` co método `close()` para asegurar que os datos no buffer se desladen correctamente ao ficheiro de destino.

---

## 1) Crear o ficheiro `texto1.txt`

Crea manualmente cun editor de texto simple un ficheiro chamado `texto1.txt` cun contido de tres liñas:

ola adeus cecais

---

## 2) Aplicación `copybytestexto`

### 2.1) Copiar o contido do ficheiro `texto1.txt` a `texto2.txt`

Desenvolve unha pequena aplicación chamada `copybytestexto` que, usando só as clases `FileInputStream` e `FileOutputStream`, copie byte a byte o contido do ficheiro de texto chamado `texto1.txt` noutro ficheiro chamado `texto2.txt`.

### 2.2) Engadir o contido de `texto1.txt` a `texto2.txt` (modo "append")

Fai a modificación necesaria na aplicación anterior para que, en vez de sobreescribir o contido de `texto2.txt`, se engada o texto do ficheiro `texto1.txt` ao final do ficheiro `texto2.txt`. Es decir, cada vez que executemos a aplicación, o ficheiro `texto2.txt` verá incrementado o seu contido coas tres liñas de `texto1.txt` sen perder o que xa contiña.

---

## Notas adicionais

- **Sobre o método `read()`:**  
  Este método lee un byte a cada vez e retorna `-1` cando chega ao final do ficheiro.

- **Sobre o método `write()`:**  
  Este método escribe un byte no ficheiro. Se se utiliza o parámetro `true` no constructor de `FileOutputStream`, a escritura fará append no ficheiro en vez de sobreescribilo.

- **Importante:**  
  Non esquecer chamar ao método `close()` despois de finalizar a operación con fluxos de entrada ou saída para asegurar que todos os datos son correctamente despositados no ficheiro.
