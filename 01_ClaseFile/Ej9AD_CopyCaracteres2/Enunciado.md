## BufferedWriter e PrintWriter

**BufferedWriter** permite crear un buffer usando como argumento calquera obxecto heredado da clase `Writer`, como `FileWriter`.

**PrintWriter** admite tamén como argumento calquera obxecto heredado da clase `Writer`, como `FileWriter` ou `BufferedWriter`, e permite escribir datos no fluxo de saída como tiras de caracteres usando os métodos `print(argument)` e `println(argument)`.

- **print(argument)** escribe a representación en modo carácter do argumento.
- **println(argument)** escribe a representación en modo carácter do argumento seguido dun carácter de retorno de liña.

---

## BufferedReader

**BufferedReader** permite crear un buffer usando como argumento calquera obxecto heredado da clase `Reader`, como `FileReader`. Dispoñemos dos seguintes métodos:

- **readLine()**: Lée unha liña de texto e a retorna como un `String`. Cando chega ao final do ficheiro, retorna `null`.
- **read()**: Lée un só carácter e retorna un `int` que representa o código ASCII para ese carácter. Cando intenta ler despois do fin do ficheiro, retorna un `-1`.

---

## Aplicación

Desenvolver o que se pide no exercicio anterior (copycaracteres) pero agora utilizando os seguintes métodos:

- **readLine()** da clase `BufferedReader`.
- **println(argument)** da clase `PrintWriter`, que a súa vez fará uso de `BufferedWriter`.
