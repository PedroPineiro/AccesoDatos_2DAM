# Aplicación `copybytesimaxe`

Imos partir do exercicio anterior para desenvolver este, así que crea un proxecto denominado `copybytesimaxe` co mesmo código do exercicio anterior.

### a) Proba de copia dunha imaxe

Agora fai a proba de utilizar como ficheiro orixe a copiar a imaxe `foto.jpg` (en vez de `texto1.txt`) e como ficheiro destino da copia un que se chame `foto2.jpg` (en vez de `texto2.jpg`).  
**Preguntas:**
- Canto ocupa `foto2.jpg`?
- Ocupa o mesmo que a imaxe orixinal (`foto.jpg`)?

### b) Engadir de novo a imaxe

Executa por segunda vez a aplicación para que se engada de novo a imaxe `foto.jpg` á imaxe `foto2.jpg`.  
**Preguntas:**
- Que ocorre se abrimos a imaxe? Vese a imaxe repetida?
- Canto ocupa agora o arquivo `foto2.jpg`?

### c) Traballo con fluxos de datos tipo byte

O que estamos facendo ata o de agora é traballar con fluxos de datos tipo byte, sen diferenciar se o contido do ficheiro a copiar contén datos de texto ou binarios.  
Veremos máis adiante que cando se traballa con fluxos de datos de tipo texto, normalmente se garda un byte por carácter, pero cando se traballa con fluxos de datos de tipo binario (como imaxes), os datos son almacenados byte a byte ou en formatos que poden escribir diferentes tipos primitivos de datos.

En canto ao que fixemos até agora, para o sistema non hai diferenza entre copiar un ficheiro de texto ou unha imaxe, posto que non interpreta o contido de cada byte, senón que simplemente o lee e o copia byte a byte (un byte de cada vez).

Isto é aparentemente rápido, pero se o ficheiro orixe é grande e queremos mellorar a velocidade de copia, debemos recorrer a outras clases que, combinadas coas clases anteriores (`FileInputStream` e `FileOutputStream`), nos permitirán mellorar a velocidade dos fluxos de datos.

### Clases `BufferedInputStream` e `BufferedOutputStream`

Para traballar con ficheiros binarios de maneira máis eficiente, temos dúas clases que melloran a velocidade de entrada e saída do fluxo de datos:
- `BufferedInputStream`
- `BufferedOutputStream`

A vantaxe de usar buffers é que se reduce o número de operacións de entrada e saída feitas ao disco. Por exemplo, se un buffer pode conter 4000 bytes, só se fará a operación de lectura ou escritura cando o buffer se encha ou cando o fluxo sexa pechado (`close`). En caso de non usar buffers, a grabación dos 4000 bytes requiriría centos de operacións de entrada e saída, o que é moi lento, xa que cada operación require a recolocación das cabezas do disco.

Para poder facer isto, Java permite combinar dous ou máis fluxos de datos (Streams) para engadir a funcionalidade que se necesita para a aplicación. Neste caso, podemos combinar `FileInputStream` e `BufferedInputStream`, así como `FileOutputStream` e `BufferedOutputStream`.

---

# Aplicación `copybytesimaxe2`

Sabendo que a clase `BufferedInputStream` acepta como argumento no seu constructor un obxecto da clase `FileInputStream`, e que a clase `BufferedOutputStream` acepta como argumento no seu constructor un obxecto da clase `FileInputStream`, fai outro proxecto chamado `copybytesimaxe2` para aumentar a velocidade de copia facendo uso destas clases.

**Importante:**
- A clase `BufferedInputStream` ten un método `read()` que permite ler un byte de cada vez e, do mesmo xeito que a clase `FileInputStream`, permite detectar o fin do ficheiro mediante a consulta do valor devolto na lectura. Se o valor é `-1`, indica que se alcanzou o fin do ficheiro.
- A clase `BufferedOutputStream` ten un método `write()` que permite escribir un byte.

---

## Preguntas finais:

1. Notaches a diferenza en velocidade ao copiar a imaxe usando `BufferedInputStream` e `BufferedOutputStream` en comparación co uso de `FileInputStream` e `FileOutputStream`?

2. Se non notas a diferenza, escolle unha imaxe cun maior número de bytes que a proporcionada (`foto.jpg`) ou executa varias veces o proxecto `copybytesimaxe` para facer crecer en bytes a imaxe `foto2.jpg` e despois usa esta como orixe de copia neste proxecto `copybytesimaxe2`.
