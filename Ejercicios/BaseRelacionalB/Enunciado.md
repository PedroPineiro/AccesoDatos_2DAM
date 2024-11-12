## **baserelacionalB**

A partir da táboa `produtos` creada no exercicio **baserelacionalA** e utilizando un `ResultSet` de tipo **"scrollable, updatable"** que devolva todas as filas da táboa, desenvolver catro métodos que permitan:

- **Listar o contido completo do `ResultSet`**.
- **Actualizar desde dentro do `ResultSet`**: por exemplo, a fila do produto `p2`, facendo que o seu prezo pase a ser 8.
- **Inserir desde dentro do `ResultSet`** unha fila de valores: por exemplo, o produto `p4`, martelo, 20.
- **Borrar**: por exemplo, a fila de código `p3`, tamén desde dentro do `ResultSet`.

### **Consulta con posibilidade de actualizar o resultado**

Lembrar que para consultar con posibilidade de actualizar o resultado da consulta, debemos usar un obxecto `Statement` creado con as opcións **"scrollable, updatable"**. A continuación, aplicamos o método `executeQuery("consulta")` para obter o `ResultSet`. Así:

```java
Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = statement.executeQuery("SELECT produtos.* FROM produtos");
```
## **Pasos para insertar un rexistro dentro do `ResultSet`:**

1. Invocar o método `moveToInsertRow()` do obxecto `ResultSet`.
2. Introducir valores nos campos do rexistro que queremos inserir.
3. Usar o método `updateString("nome_campo", valor)` para actualizar campos de tipo **String**, ou `updateInt("nome_campo", valor)` para campos de tipo **Integer**.
4. Para inserir a fila, invocar o método `insertRow()` do obxecto `ResultSet`.

```java
rs.moveToInsertRow();  // Preparar para inserir unha nova fila
rs.updateString("CODIGO", "p4");
rs.updateString("DESCRICION", "martelo");
rs.updateInt("PREZO", 20);
rs.insertRow();  // Inserir a nova fila
```
## **Pasos para actualizar un rexistro no `ResultSet`**:

Unha vez situado na fila que queremos modificar no `ResultSet`, os pasos a seguir son:

1. **Actualizar un campo**: Invocar o método `updateString("nome_campo", valor)` para campos de tipo **String**, ou `updateInt("nome_campo", valor)` para campos de tipo **Integer**.

   Exemplo:
   ```java
   rs.updateString("DESCRICION", "martelo");  // Actualizar o campo DESCRICION
   rs.updateInt("PREZO", 8);  // Actualizar o campo PREZO
    ```
## **Pasos para borrar un rexistro no `ResultSet`**:

1. **Borrar o rexistro**: Unha vez situado no rexistro que queremos borrar, invocar o método `deleteRow()` para eliminar a fila do `ResultSet`.

   Exemplo:
   ```java
   rs.deleteRow();  // Borrar a fila onde está situado o cursor
    ```
## **Algunhas funcións do `ResultSet` (scrollable e updatable)**:

- `first()`: Mover o cursor á primeira fila do obxecto `ResultSet`.
- `last()`: Mover o cursor á última fila do obxecto `ResultSet`.
- `isLast()`: Retorna `true` se estamos posicionados na última fila do obxecto `ResultSet`.
- `close()`: Pechar o `ResultSet` unha vez finalizado o uso.
- `next()`: Mover o cursor á seguinte fila do obxecto `ResultSet`.
- `previous()`: Mover o cursor á fila anterior ao rexistro actual do obxecto `ResultSet`.

### **IMPORTANTE**:

A consulta de todos os campos dunha fila debe facerse explicitando o nome da táboa antes do `*`, es decir:

```sql
SELECT produtos.* FROM produtos ...
```
