# Exercicio `primitiveWriteUTF`

Neste exercicio seguiremos traballando cos fluxos binarios de datos, pero agora tratando-os como soporte para tipos de datos primitivos e valores `String`.

### Clases `DataOutputStream` e `DataInputStream`

- **`DataOutputStream`**: A clase `DataOutputStream` proporciona unha serie de métodos para escribir tipos primitivos de datos e valores `String` en fluxos binarios. Utiliza o método `writeUTF(String)` para escribir cadeas de texto no formato UTF-8.

- **`DataInputStream`**: A clase `DataInputStream` permite ler tipos primitivos de datos e valores `String` que foron previamente escritos en fluxos binarios mediante `DataOutputStream`. Para ler cadeas de texto, usaremos o método `readUTF()`.

Dado que `DataInputStream` admite como parámetro calquera clase herdada de `InputStream`, e `BufferedInputStream` cumpre este requisito, podemos usar un obxecto `BufferedInputStream` como parámetro de `DataInputStream`, tal e como traballamos no exercicio anterior (`copybytesimaxe2`).

De maneira similar, como `DataOutputStream` acepta como parámetro calquera clase herdada de `OutputStream`, podemos usar un obxecto `BufferedOutputStream` como parámetro de `DataOutputStream`, tamén como fixemos no exercicio anterior.

---

## Obxectivo

Desenvolver un proxecto chamado `primitiveWriteUTF` que consistirá en gravar a mesma cadea de texto tres veces consecutivas nun ficheiro chamado `texto3.txt`, utilizando o método `writeUTF`. Despois, amosaremos o tamaño do ficheiro cada vez que gravemos unha cadea, e posteriormente recuperaremos e leremos as cadeas gravadas.

### Cadea a gravar:
**"o tempo está xélido"**

---

## Metodos a usar:

- **Da clase `DataOutputStream`:**
    - `size()`: Devuelve o tamaño en bytes do ficheiro no que estamos a escribir.
    - `writeUTF(String)`: Escribe a cadea que se pasa como parámetro.

- **Da clase `DataInputStream`:**
    - `available()`: Devuelve o valor `0` se non queda nada por ler.
    - `readUTF()`: Lê unha cadea que foi gravada previamente nun ficheiro co método `writeUTF(String)`.

---

## Notas importantes:

- O método `writeUTF(String)` escribe normalmente 1 byte por cada carácter do `String` que se pasa como parámetro, pero pode escribir ata 3 bytes por carácter dependendo do carácter. Ademais, antepon a lonxitude da cadea en número de bytes (2 bytes).

  **Exemplo de cálculo:**
  Se a cadea é:  
  `"o tempo está xélido"`  
  Temos:
    - 14 caracteres normais
    - 3 espazos
    - 2 vogais con acento

  O tamaño total será:
    - 2 bytes para a lonxitude (antepoñen a cadea)
    - 14 caracteres + 3 espazos + 2 caracteres con acento (cada un ocupando 2 bytes)  
      Total = 2 + 14 + 3 + 2 * 2 = **23 bytes**

---

## Resultado esperado

Ao executar a aplicación, o resultado debería ser algo como:

Escribindo a cadea: o tempo está xélido  
Tamaño do ficheiro: 23 bytes  
Escribindo a cadea: o tempo está xélido  
Tamaño do ficheiro: 46 bytes  
Escribindo a cadea: o tempo está xélido  
Tamaño do ficheiro: 69 bytes  
Tamaño final do ficheiro: 69 bytes  
Quedan: 69 bytes por ler  
Cadea: o tempo está xélido  
Quedan: 46 bytes por ler  
Cadea: o tempo está xélido  
Quedan: 23 bytes por ler  
Cadea: o tempo está xélido  
Xa non queda nada por ler

---

## Observacións

- **Abrir o ficheiro**:  
  Podemos comprobar que, se intentamos abrir o ficheiro `texto3.txt` co editor `gedit`, non será posible. Debemos usar un editor non gráfico como `nano`, `vi`, ou `emacs`. Ademais, podemos ver o contido do ficheiro en hexadecimal ou binario utilizando as seguintes ferramentas:

    - Ver en hexadecimal:
      ```bash
      hexdump -C texto3.txt
      ```

    - Ver en binario:
      ```bash
      xxd -b texto3.txt
      ```

    - Mostrar a lonxitude en bytes do ficheiro:
      ```bash
      wc -c texto3.txt
      ```

---

## Resumo

Neste exercicio, traballamos con fluxos binarios para almacenar e recuperar tipos de datos primitivos e cadeas de texto. Usamos as clases `DataOutputStream` e `DataInputStream` para escribir e ler datos binarios de maneira eficiente, e analizamos como se garda a información en formato UTF. O uso de métodos como `writeUTF()` e `readUTF()` permite que os datos sexan escritos e lidos de forma estruturada, sen perder a súa integridade.
