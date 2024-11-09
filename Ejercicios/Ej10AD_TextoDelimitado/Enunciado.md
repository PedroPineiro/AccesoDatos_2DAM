# Exercicio: Grabar e ler un ficheiro delimitado

Neste exercicio, imos gravar nun ficheiro de texto delimitado utilizando os métodos `print` e `println` da clase `PrintWriter`. O ficheiro contendrá os datos de tres arrays que representan os campos dun rexistro dunha táboa de produtos, onde cada produto ten un código, unha descrición e un prezo.

## Arrays de datos:

```java
String[] cod = {"p1", "p2", "p3"};
String[] desc = {"parafusos", "cravos", "tachas"};
int[] prezo = {3, 4, 5};
```
Cada tres elementos que ocupan a mesma posición nos arrays representan os campos dun rexistro.

## Instruccións:
Graba os datos nun ficheiro de texto utilizando PrintWriter e como delimitador de campos usa o tabulador (\t). Utiliza o método println() para separar os rexistros con saltos de liña.
Despois de gravar os valores, léelos de novo rexistro a rexistro utilizando BufferedReader e FileReader.
Utiliza a función split() para separar os valores de cada rexistro.
Imprime os datos de cada rexistro de forma separada como se amosa a continuación.
O fin do ficheiro pode detectarse cando o método readLine() devolva null.

Pista para o formato de prezo:
Se observas o resultado impreso, verás que os prezos están escritos co símbolo €. Pódese investigar como facer isto utilizando a clase NumberFormat e o seu método getCurrencyInstance() para dar formato monetario ao número.

### Resultado da lectura:

Código:      p1  
Descrición: parafusos  
Prezo:       3,00 €  

Código:      p2  
Descrición: cravos  
Prezo:       4,00 €  

Código:      p3  
Descrición: tachas  
Prezo:       5,00 €  

### Nota:
A función split() de Java pode usarse para separar unha cadea de texto en partes mediante un delimitador (neste caso, tabuladores). Un exemplo de uso é: linea.split("\t").
O formato monetario pode ser aplicado usando NumberFormat.getCurrencyInstance() para mostrar o prezo correctamente con símbolo €.