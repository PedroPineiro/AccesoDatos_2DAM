# Exercicio de Fluxos Binarios con Tipos Primitivos e Strings

Neste exercicio seguiremos tratando os fluxos binarios de datos, pero agora tratando-os como soporte de tipos de dato primitivos e valores String.

## DataInputStream
DataInputStream dispoñen dunha serie de métodos para que, partindo de fluxos binarios de datos, poidamos ler tipos primitivos de datos e valores String.

## DataOutputStream
DataOutputStream dispoñen dunha serie de métodos para que, partindo de fluxos binarios de datos, poidamos escribir tipos primitivos de datos e valores String que previamente foron codificados nestes fluxos mediante DataInputStream.

### Uso de BufferedInputStream e BufferedOutputStream

Dado que `DataInputStream` admite como parámetro calquera clase herdada de `InputStream`, e `BufferedInputStream` cumpre este requisito, o único que temos que facer para poder usar os métodos de `DataInputStream` é pasarlle como parámetro un obxecto `BufferedInputStream` coma o traballado no exercicio anterior.

Dado que `DataOutputStream` admite como parámetro calquera clase herdada de `OutputStream`, e `BufferedOutputStream` tamén cumpre este requisito, o único que temos que facer para poder usar os métodos de `DataOutputStream` é pasarlle como parámetro un obxecto `BufferedOutputStream` coma o traballado no exercicio anterior.

---

## APLICACIÓN

Propoñovos un exercicio que consistirá en gravar unha mesma cadea de texto tres veces usando dous métodos distintos (`writeUTF` e `writeChars`) nun ficheiro denominado `text6.dat` para posteriormente recuperalos.

**Lembrade que**:

- Para recuperar unha cadea gravada con `writeUTF` debedes usar `readUTF`.
- Pero para recuperar unha cadea escrita con `writeChars` debedes usar `readChar()`, que só lê un carácter de cada vez. Isto implica que debedes usar un bucle que faga tantas lecturas como caracteres ten a cadea orixinal.

### Cadea a Grabar:
Cadea: **“Está en casa”**

1. A primeira vez debe gravarse usando `writeUTF(String)`.
2. A segunda usando `writeChars(String)`.
3. A terceira usando de novo `writeUTF(String)`.

---

## Resultado da Execución

O resultado da execución debería ser o seguinte:

writeUTF escribindo: Está en casa  
bytes totais escritos: 15 bytes  

writeChars escribindo: Está en casa   
bytes totais escritos: 39 bytes  

writeUTF escribindo: Está en casa   
bytes totais escritos: 54 bytes  

bytes totais por ler = 54 bytes  

lemos a primeira cadea en UTF: Está en casa   
numero de bytes por ler: 39 bytes.  

lemos a segunda cadea con readChar() en bucle: Está en casa   
numero de bytes por ler: 15  

lemos a terceira cadea mediante readUTF: Está en casa   
numero de bytes por ler: 0  

---

### Notas:

Podemos comprobar que se intentamos abrir o ficheiro de texto co editor `gedit` non o permite. Debemos usar **nano**, **vi**, **emacs** ou outro editor non gráfico para comprobar a forma en que foron gravadas as cadeas.
