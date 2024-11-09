# Proxecto: productsStream

Crear un novo proxecto denominado **productsStream** cunha clase denominada **Product** e unha clase principal, tal como se describe a continuación:

---

## a) Clase Product

A clase `Product` debe ter tres variables privadas:
- `codigo` tipo `String`
- `descricion` tipo `String`
- `prezo` tipo `Double`

O constructor por defecto introducirá:
- Cadenas nulas nas variables `codigo` e `descricion`
- Un cero no `prezo`

A clase debe ter outro constructor con pase de tres parámetros: (`codigo`, `descricion`, `prezo`).

### Métodos da clase Product

Os métodos básicos da clase permiten realizar as seguintes operacións sobre as tres variables:

- **Cambiar o código**: `setCodigo(String codigo)`
- **Obter o código**: `getCodigo()`
- **Cambiar a descrición**: `setDescricion(String descricion)`
- **Obter a descrición**: `getDescricion()`
- **Cambiar o prezo**: `setPrezo(Double prezo)`
- **Obter o prezo**: `getPrezo()`

---

## b) Clase principal

1. Crear un obxecto da clase `Product` cos argumentos: `"cod1"`, `"parafusos"`, `3.0`.
2. Gardar os valores do produto creado nun ficheiro denominado **produtos.txt** mediante os métodos adecuados de `DataOutputStream`.
3. Crear outro obxecto da clase `Product` cos argumentos: `"cod2"`, `"cravos"`, `4.0` e gardalo como anteriormente.
4. Crear outro obxecto da clase `Product` cos argumentos: `"cod3"`, `"tachas"`, `6.0` e gardalo como anteriormente.
5. Crear outro obxecto da clase `Product` cos argumentos: `"cod4"`, `"grapas"`, `2.0` e gardalo como anteriormente.
6. Gardar os valores do produto creado no ficheiro **produtos.txt**.
7. Despois, crear un obxecto tipo `Product` novo chamado `po3` sen argumentos e cargar os seus atributos a partir dos datos dos produtos gardados no ficheiro **produtos.txt** mediante `DataInputStream`, imprimindo os valores de ditos produtos.

   > Enténdese que primeiro se cargan os datos do primeiro produto lido no obxecto `po3`, se imprimen os valores, e despois se cargan os datos do seguinte produto no mesmo obxecto `po3` e se volven imprimir os seus valores.

---

## Resultado da execución

A lista de produtos gardados no ficheiro **produtos.txt** debe ser:

cod1 , parafusos , 3.0   
cod2 , cravos , 4.0   
cod3 , tachas , 6.0  
cod4 , grapas , 2.0
---

## Métodos a usar

Para gardar os datos no ficheiro **produtos.txt**, utilizar:
- O método `writeUTF` para gardar os datos do **código** e a **descrición**
- O método `writeDouble` para gardar o **prezo**