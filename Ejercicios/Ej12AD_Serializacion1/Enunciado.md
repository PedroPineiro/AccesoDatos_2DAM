## Exercicio de Serialización en Java

Crear unha clase chamada `mclase` que implemente a interfaz `Serializable`  (implements Serializable). Dita clase debe ter tres atributos:

- Unha variable `String` (nome)
- Outra variable `int` (numero1)
- Outra variable `double` (numero2)

### Paso 1: Crear a clase `mclase`

Dende  a clase principal (a do proxecto) instanciar un obxecto da clase `mclase` con tres valores: `"ola"`, `-7`, `2.7E10`, e almacenar dito obxecto nun ficheiro denominado `'serial'` mediante o método `writeObject(obxecto_a_grabar)` da clase `ObjectOutputStream` (que debe recibir como parámetro un obxecto da clase `FileOutputStream("ruta do ficheiro a escribir")`). Pecha o ficheiro.

### Paso 2: Recuperar o obxecto

Despois, crea outro obxecto baleiro da clase `mclase` e carga posteriormente os seus atributos cos valores almacenados no ficheiro `'serial'` anteriormente creado. Para isto, debes usar o método `readObject()` da clase `ObjectInputStream`, non esquecendo que debes castealo á clase `mclase`.

### Paso 3: Modificación do código

Se todo funciona correctamente, facer un cambio (deixando comentadas as liñas que modifiques para facer este cambio) e repetir a execución do proxecto. O cambio consistirá en marcar a variable tipo `int` da clase `mclase` como `transient` e comprobar que, poñamos o valor que poñamos nese campo `int` do obxecto a gardar, o resultado devolto será `0` (sería un `null` se a variable `transient` fora a de tipo `String`).

### Execución antes do cambio

```plaintext
object1: s=ola; i=-7; d=2.7E10
```
### Execución despois do cambio

```plaintext
object2: s=ola; i=0; d=2.7E10
```
Fin da comprobación: recuperanse os datos excepto i por ser transient