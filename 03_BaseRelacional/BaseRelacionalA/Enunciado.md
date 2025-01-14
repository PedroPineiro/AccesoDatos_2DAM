# Ejercicio: Conexión Java a PostgreSQL para operaciones CRUD

Se trata de conectar desde Java a PostgreSQL para realizar operaciones de consulta y manipulación de datos en tablas (SELECT, INSERT, UPDATE, DELETE).

---

## PARTE 1

1. Desde el cliente `psql`, lanzar el script `produtos.sql` como usuario `postgres` contra la base de datos `postgres`:

```
psql postgres
\i <ruta del archivo produtos.sql>
```

Esto creará una tabla llamada productos con la siguiente estructura:

CODIGO : VARCHAR2(3) PRIMARY KEY  
DESCRICION : VARCHAR2(15)  
PREZO : INTEGER  
DATAC : DATE  

Comprobar desde psql que la tabla se creó correctamente:
```sql	
\d produtos
```

## PARTE 2: APLICACIÓN `baserelacionalA`

- Añadir el driver de PostgreSQL a la librería del proyecto (se encuentra en la ruta `/home/postgres/programas/postgres....jar`).
- Importar manualmente el paquete `java.sql.*`, es decir:

  ```java
  import java.sql.*;
  ```
- Crear un método llamado `conexion` que devuelva un objeto de tipo `Connection` llamado `conn` que se conecte a la base de datos `postgres` mediante el usuario `postgres` y la contraseña `postgres`. El objeto `Connection` se crea de la siguiente forma:

  ```java
  String driver = "jdbc:postgresql:";
  String host = "//localhost:"; // también podría ser una IP como "192.168.1.14"
  String porto = "5432";
  String sid = "postgres";
  String usuario = "postgres";
  String password = "postgres";
  String url = driver + host + porto + "/" + sid;
  Connection conn = DriverManager.getConnection(url, usuario, password);
  ```
- Crear un método llamado `insireProduto` que permita insertar en la tabla `produtos` una fila, pasándole como parámetros el código, el nombre, el precio y la fecha de caducidad de un producto.

- Crear un método llamado `listaProdutos` que muestre el contenido de los registros que hay en la base de datos. (Debe usarse un `ResultSet` para volcar el contenido de los registros).

- Crear un método llamado `listaProdutoPorCodigo` que muestre el contenido del registro cuyo código de producto se pase por parámetro.

- Crear un método llamado `actualizaPre` tal que, pasándole el código y el precio de un registro, actualice el campo `prezo` del registro correspondiente a dicho código.

- Crear un método llamado `eliminaProduto` tal que, pasándole el código de un registro, elimine el registro correspondiente a dicho código.

### COMPROBACIÓN:

- Insertar varios registros en la tabla mediante el método `insireProduto` creado anteriormente, usando sentencias SQL estándar. Los registros a insertar son:

   ```
   p1 , parafusos, 3, 27/12/2020  
   p2 , cravos , 4, 6/4/2020  
   p3, tachas, 6, 3/7/2020  
   ```


- Comprobar desde `sqlplus` que los registros fueron creados y que podemos actualizar o borrar alguno de ellos usando los métodos creados anteriormente, es decir:

  1. Leer los registros de la tabla `produtos` mediante el método `listaProdutos()`.
  2. Modificar el registro de código `p2` poniéndole el precio al doble de lo que tiene actualmente.
  3. Borrar el registro de código `p3`.

### Nota: Realizar todas las comprobaciones necesarias para asegurar que todas las tareas mencionadas funcionan correctamente.

### Métodos necesarios para desarrollar esta aplicación:

Para insertar, borrar o modificar datos, debemos crear previamente un objeto `Statement` mediante el método `createStatement()` del objeto `Connection`. Luego, dependiendo de la operación que queramos realizar, elegiremos uno de los siguientes métodos del objeto `Statement`:

- **Insertar:** Método `executeUpdate("orden_de_insercion_sql")`
- **Consultar (mediante `ResultSet` forward_only, read_only (por defecto)):** Crear un objeto `ResultSet` a partir de aplicar el método `executeQuery("consulta")` al objeto `Statement` y recorrerlo con un bucle. El método para recorrer un objeto `ResultSet` (`r`) es invocar su método `next()`. Ejemplo:
  ```java
  while (r.next()) {  }...
    ```
- borrar : metodo executeUpdate("orde_de_borrado_sql")
- modificar: metodo executeUpdate("orde_de_modificacion_sql")

### **NOTA importante:**

- Para convertir una fecha en formato `String` a `Date`:
```java
Date d = Date.valueOf(data);
```
- Para pasar una data en formato cadea (String) a  java.sql.Date :
```java
SimpleDateFormat format = new SimpleDateFormat("ddMMYYYY");
java.util.Date di;
di = format.parse("28022021");
java.sql.Date df = new java.sql.Date(di.getTime());
insireProduto("p5", "cepillos", 6.0, df);
```
