## Exercicio: Serialización de Obxectos

Utilizando a **serialización de obxectos** e partindo do array seguinte:

```java
String[] cod = {"p1", "p2", "p3"};
String[] desc = {"parafusos", "cravos", "tachas"};
int[] prezo = {3, 4, 5};
```

Crea tres obxectos tipo `Product` (esta clase xa a tes feita nun exercicio anterior: `productStream`) e almacenaos nun ficheiro secuencial binario (`FileOutputStream`) utilizando os métodos adecuados da clase `ObjectOutputStream`.

O obxectivo, coma sempre, é que despois de escritos, poidas leelos dende dito ficheiro e imprimilos. Facer este exercicio utilizando un **bucle `while`** para ler os obxectos almacenados. Supóñese que non sabemos cantos obxectos hai almacenados.

### Nota:

O método `close()` do `ObjectOutputStream` non mete un `null` cando se executa dito método, polo que se usamos un bucle `while` para ler os obxectos ata o final, non temos forma de saber onde remata, e isto pode dar lugar ao erro:
`/Exception during deserialization: java.io.EOFException`

O que podemos facer é gardar un `null` xusto antes de lanzar o `close()` do `ObjectOutputStream`. Deste xeito, cando leamos os obxectos, podemos preguntar se o obxecto lido é un `null` para deter o bucle de lectura.

Outra opción sería usar o método `available()` para ver canto queda por ler do ficheiro. Se non queda nada, rematamos e xa está. Pero **CUIDADO**: o método `available()` da clase `ObjectInputStream` non devolve o número de bytes que quedan por ler, senón o número de bytes bloqueados. Podemos usar o método `available()` da clase `FileInputStream`, porque ao fin e ao cabo, `ObjectInputStream` está lendo os obxectos serializados a través de dita clase.
