Gardar os contidos dos tres arrays seguintes nun ficheiro aleatorio (creado en modo lectura escritura) tendo en conta que cada tres elementos que ocupan a mesma posición nos arrays representan un código, unha descrición e un prezo:

```java
String[] codes = {"p1", "p2", "p3"};
String[] descricion = {"parafusos", "cravos", "tachas"};
int[] prices = {3, 4, 5};
```
Nota: ter en conta que asignaremos unha lonxitude fixa a cada rexistro. Así para o código asignaremos 3 caracteres (6 bytes), para a descrición 10 caracteres (20 bytes), e o prezo por ser un enteiro terá asignados 4 bytes, sendo o tamaño total do rexistro de 30 bytes.

Nota IMPORTANTE: a clase a usar é `RandomAccessFile` (obxecto `File`, "rw") e os seus métodos para escritura e lectura de tipos primitivos de datos (`writeChars(..)`, `writeInt(..)`, `readChar()`, `readInt()`).

Antes de gravar os datos dun rexistro deberá utilizarse un método que encha cos espazos que faltan os campos código e descrición ata completar as lonxitudes de ditos campos cun carácter calquera.
Pista: A clase `String` ten un método denominado `format` que permite dar formato a unha cadea:
String x = String.format("%" + width + "s", t).replace(' ', '0');
onde:
- `width`: é o ancho final da cadea en número de caracteres
- `t`: é a cadea
- `%`: enche con brancos pola esquerda (con `%-` enchería con brancos pola dereita)

Se ademais lle aplicamos ao método `format` o método `replace(' ', '0')` cambiará os brancos por ceros (isto é interesante se nun primeiro momento queremos ver o efecto de aplicar `format` porque os brancos non se ven na impresión pero os ceros si).

Unha vez almacenados os tres rexistros no ficheiro aleatorio deberemos ler e amosar o contido dos campos do rexistro que ocupa a posición número 2 utilizando o método `seek(int n)` da clase `RandomAccessFile` que permite posicionarnos no byte indicado dentro de dito ficheiro.

Ter en conta que ao ler o rexistro deberemos voltar a separar os seus contidos e quitarlle os brancos ás cadeas de texto para poder cargar correctamente ditos valores en variables Java adecuadas (`String`), excepto o valor que foi gravado como enteiro que simplemente debe ser convertido a enteiro mediante casteo.

É dicir, o resultado da consulta debería amosarse algo parecido a isto:  

p2  
cravos  
4  