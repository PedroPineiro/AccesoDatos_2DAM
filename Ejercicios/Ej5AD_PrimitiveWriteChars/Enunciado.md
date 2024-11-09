# Exercicio de Fluxos Binarios con Tipos Primitivos e Strings

Neste exercicio seguiremos tratando os fluxos binarios de datos, pero agora tratando-os como soporte de tipos de datos primitivos e valores **String**.

### Uso de `DataInputStream` e `DataOutputStream`

- **`DataInputStream`** dispoñen dunha serie de métodos para que, partindo de fluxos binarios de datos, poidamos ler tipos primitivos de datos e valores **String**.

- **`DataOutputStream`** dispoñen dunha serie de métodos para que, partindo de fluxos binarios de datos, poidamos escribir tipos primitivos de datos e valores **String** que previamente foron codificados nestes fluxos mediante **`DataInputStream`**.

### Uso de `BufferedInputStream` e `BufferedOutputStream`

- Dado que **`DataInputStream`** admite como parámetro calquera clase herdada de `InputStream`, e **`BufferedInputStream`** cumpre este requisito, o único que temos que facer para poder usar os métodos de **`DataInputStream`** é pasarlle como parámetro un obxecto **`BufferedInputStream`** (coma o traballado no exercicio anterior).

- Dado que **`DataOutputStream`** admite como parámetro calquera clase herdada de `OutputStream`, e **`BufferedOutputStream`** tamén cumpre este requisito, o único que temos que facer para poder usar os métodos de **`DataOutputStream`** é pasarlle como parámetro un obxecto **`BufferedOutputStream`** (coma o traballado no exercicio anterior).

## Aplicación

Propoñovos un exercicio que consistirá en gravar unha mesma cadea de texto dúas veces usando o método `writeChars(String)` da clase **`DataOutputStream`** nun ficheiro denominado **`text5.dat`** para posteriormente recuperalas (voltalas a ler) mediante o método `readChar()` da clase **`DataInputStream`**.

### Consideracións Importantes:

- **`writeChars(String)`** escribe **2 bytes por caracter** (podemos cambiar calquera vogal da cadea por esa mesma vogal acentuada ou unha letra **ñ** e veremos que a lonxitude da cadea non varía, ao contrario do que ocorría con `writeUTF()`, onde si variaba).

- **`readChar()`** lé un caracter de cada vez (2 bytes), polo que teremos que usar un bucle para ler cada carácter da cadea.

### Cadea a Grabar:

- Cadea: **"o tempo está xélido"**

### Métodos a Usar:

- **Método `length()`** — Aplicado a calquera `String`, danos a súa lonxitude en número de caracteres.

#### Clase `DataInputStream`:

- **`readChar()`** — Lê un carácter de cada vez (2 bytes).
- **`available()`** — Dínos cantos bytes quedan por ler dun ficheiro.

#### Clase `DataOutputStream`:

- **`writeChars(String)`** — Escribe o `String` (ocupa 2 bytes por carácter).
- **`size()`** — Aplicado a un obxecto de tipo `DataOutputStream`, devolve o que ocupa en bytes.

### Nota:

Dado que gravamos dúas cadeas de igual lonxitude, para lelas debemos repetir o código correspondente a unha lectura dúas veces, ou ben facer un bucle ata que o contido a ler (detectable co método `available()` da clase `DataInputStream`) sexa de lonxitude igual a 0.

### Resultado da Execución:

O resultado da execución debería ser o seguinte:

Escribindo: o tempo está xélido  
A lonxitude desta cadea en caracteres é: 19 caracteres   
Lévanse escritos: 38 bytes  

Escribindo: o tempo está xélido  
A lonxitude desta cadea en caracteres é: 19 caracteres  
Lévanse escritos: 76 bytes  

Lemos a primeira cadea: o tempo está xélido  
Restan por ler: 38 bytes  

Lemos a segunda cadea: o tempo está xélido   
Restan por ler: 0 bytes  

### Notas:

- Podemos comprobar que se intentamos abrir o ficheiro de texto **`text5.dat`** co editor gráfico **gedit**, non o permite. Debemos usar editores non gráficos como **nano**, **vi**, ou **emacs** para poder ver o contido.

- Podemos ver o contido do ficheiro de texto en hexadecimal e en código **ASCII** co seguinte comando:

hexdump -C nome_ficheiro

- Tamén podemos ver o contido en binario puro con:

xxd -b nome_ficheiro

- Para mostrar a lonxitude en bytes do ficheiro:

wc -c nome_ficheiro