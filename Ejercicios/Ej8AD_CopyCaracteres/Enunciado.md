# Traballo con fluxos de caracteres

Imos traballar con fluxos de caracteres para o cal imos seguir a utilizar as clases da xerarquía `Writer`.

### `FileWriter`

A clase `FileWriter` permite que conectemos o fluxo de caracteres a un ficheiro en modo escritura.

## Aplicación:

Utilizando exclusivamente os métodos `read()` e `write()` das clases `FileReader` e `FileWriter`, copiaremos o contido dun ficheiro de texto denominado `texto1.txt` noutro denominado `texto2.txt`.

### Notas:
- `read()` retorna un caracter como un `int`. Se se tenta ler fóra do ficheiro, léese un `-1`.
- `write(int c)` onde `c` é un `int` que representa o carácter a ser escrito.

### Contido de `texto1.txt`

O contido do ficheiro `texto1.txt` pódese crear con calquera editor de texto plano. O seu contido debe ser o seguinte:

a arbore  
o libro  
o neno  

Este exercicio é moi parecido ao `copybytestexto`, coa diferenza de que a unidade mínima de información aquí é un **carácter** e non un **byte**.
