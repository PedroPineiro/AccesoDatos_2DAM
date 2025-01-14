# Introdución a arquivos e directorios

Java dispón da clase `File` (paquete `java.io.File`) que permite realizar operacións relativas a directorios e arquivos (ou ficheiros).

### Clase `java.io.File`

**Constructor**:
- `File(String path)`: Crea un obxecto `File` que representa un arquivo ou directorio.

**Métodos**:
- `exists()`: Verifica se o arquivo ou directorio existe.
- `canRead()`: Verifica se o arquivo ou directorio se pode ler.
- `canWrite()`: Verifica se o arquivo ou directorio se pode escribir.
- `isDirectory()`: Comproba se o obxecto é un directorio.
- `isFile()`: Comproba se o obxecto é un ficheiro.
- `getName()`: Obtén o nome do arquivo ou directorio.
- `getPath()`: Obtén a ruta do arquivo ou directorio.
- `getAbsolutePath()`: Obtén a ruta absoluta do arquivo ou directorio.
- `length()`: Obtén a lonxitude do arquivo en bytes.
- `lastModified()`: Obtén a data de modificación do arquivo.
- `listRoots()`: Lista as raíces do sistema de ficheiros.
- `listFiles()`: Lista os arquivos ou subdirectorios dun directorio.
- `list()`: Lista os nomes dos arquivos ou subdirectorios dun directorio.
- `setReadOnly()`: Fai que un ficheiro sexa só lectura.
- `createNewFile()`: Crea un novo ficheiro no sistema de arquivos.
- `setWritable(true)`: Permite a escritura nun ficheiro.
- `delete()`: Elimina un arquivo ou directorio.
- `mkdir()`: Crea un directorio.

## OBXECTIVO:

Desenvolver un proxecto chamado "arquivos" que realice as tarefas especificadas a continuación.

Todas as tarefas deste exercicio deben desenvolverse utilizando a clase `File`, o seu constructor e os seus métodos.

## 1) Método `eDirectorio(cadea)`
Detecta se unha cadea dada corresponde a un directorio. A cadea debe ser un `String` que contenga a ruta absoluta do directorio. Imprimirá:
- `É un directorio` ou
- `Non é un directorio`

## 2) Método `eFicheiro(cadea)`
Comproba se unha cadea dada corresponde a un ficheiro. A cadea debe ser un `String` que contenga a ruta absoluta do ficheiro. Imprimirá:
- `É un ficheiro` ou
- `Non é un ficheiro`

## 3) Método `creaDirectorio(String)`
Crea un directorio a partir da ruta absoluta do mesmo. O directorio só se creará cando non exista previamente.

## 4) Método `creaFicheiro(dirName, fileName)`
Crea un ficheiro nun directorio xa existente. Os dous parámetros son `String` que indican o nome do directorio e do ficheiro. O ficheiro só se creará cando non exista previamente.

## 5) Método `modoAcceso(dirName, fileName)`
Dado o nome dun directorio e un ficheiro, este método debe imprimir:
- `"Escritura sí"` se se pode escribir no ficheiro.
- `"Escritura non"` se non se pode escribir.
- `"Lectura sí"` se se pode ler no ficheiro.
- `"Lectura non"` se non se pode ler.

## 6) Método `calculaLonxitude(dirName, fileName)`
Dado un directorio e un ficheiro, este método debe imprimir a lonxitude en bytes do ficheiro.

## 7) Método `mLectura(dirName, fileName)`
Dado un directorio e un ficheiro, este método debe configurar o ficheiro en modo "só lectura".

## 8) Método `mEscritura(dirName, fileName)`
Dado un directorio e un ficheiro, este método debe permitir escribir no ficheiro.

## 9) Método `borraFicheiro(dirName, fileName)`
Dado un directorio e un ficheiro, debe eliminar o ficheiro se existe. Se non existe, debe imprimir "Ficheiro inexistente".

## 10) Método `borraDirectorio(dirName)`
Dado un directorio, debe eliminar o directorio se existe. Se non existe ou non se pode eliminar, debe imprimir "Ruta inexistente ou con descendencia".

## 11) Método `mContido(dirName)`
Amosa os arquivos e directorios de primeiro nivel dun directorio dado.

## 12) (Opcional) Método `recur(File)`
Amosa arquivos e subdirectorios dun directorio dado de maneira recursiva.

---

## Usando os métodos creados anteriormente:

### 1) Crear o directorio 'arquivosdir' na ruta '/home/postgres/NetBeansProjects/arquivos/'
Comprobar se é un directorio usando o método `eDirectorio`.

### 2) Crear o arquivo `Products1.txt` no directorio 'arquivosdir'.
Comprobar se é un ficheiro usando o método `eFicheiro`.

### 3) Crear o directorio 'subdir' na ruta '/home/postgres/NetBeansProjects/arquivos/arquivosdir/' e crear o ficheiro `Products2.txt` no directorio 'subdir'.

### 4) Amosar arquivos e subdirectorios de primeiro nivel da ruta '/home/postgres/NetBeansProjects/arquivos/arquivosdir/'.

**Resultado esperado:**

Products1.txt
subdir

### 5) Amosar a seguinte información sobre o arquivo `Products1.txt`:
- Se se pode ou non escribir nel.
- Se se pode ou non ler del.
- A súa lonxitude en bytes.

Despois, editar o ficheiro manualmente e amosar a súa nova lonxitude en bytes.

### 6) Forzar a que o arquivo `Products1.txt` sexa de só lectura. Verificar que non se pode escribir nel.

### 7) Forzar a que o arquivo volva ser de escritura. Verificar que se pode escribir de novo nel.

### 8) Borrar o arquivo `Products1.txt` e comprobar manualmente que foi borrado.

### 9) Borrar o resto de arquivos e directorios creados.