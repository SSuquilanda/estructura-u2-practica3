
# Universidad Politécnica Salesiana

# Samantha Suquilanda & José Abad

# Descripción de Proyecto 

Se necesita desarrollar un programa para gestionar una lista de contactos telefónicos. 
Cada contacto tiene un nombre, un número de teléfono, una Colección de Correos y 
un Diccionario que almacenara las redes sociales del contacto.

El programa debe permitir agregar, buscar y eliminar 
contactos de la lista utilizando un árbol binario de búsqueda.

# Estructura del Proyecto:

*  `Clase Contacto`:  La clase contacto lo que hace es,Ofrece una manera práctica y 
	funcional de almacenar y manejar los detalles de un contacto, como su nombre, 
	número de teléfono, correos electrónicos y perfiles de redes sociales. Esta estructura 
	de datos simple pero eficaz servirá como cimiento sólido para desarrollar una lista de 
	contactos más completa y versátil en una aplicación más extensa.

* `Nodo`:  La clase Nodo es un componente esencial en la construcción de un árbol binario de búsqueda 
que almacena objetos de la clase Contacto. Cada instancia de la clase Nodo contiene un objeto de tipo 
Contacto y referencias a sus nodos hijos izquierdo y derecho. Estas referencias permiten la organización 
jerárquica de los contactos en el árbol y facilitan la ejecución eficiente de operaciones de búsqueda, 
inserción y eliminación en la estructura del árbol

* `ArbolContacto`: La clase "ArbolContacto" lo que haría seria desarrollar todas las 
	funciones esenciales para gestionar una lista de contactos utilizando un árbol binario de búsqueda. 
	Esta implementación permitirá agregar nuevos contactos de manera ordenada, eliminar contactos 
	específicos y realizar recorridos del árbol (inorden, preorden, postorden) para obtener los 
contactos ordenados de diversas formas

 

  Además en dicha clase, Se incluyen métodos para comprobar el equilibrio del árbol, 
lo cual es fundamental para garantizar una estructura de datos eficiente, y para 
calcular la altura del árbol. Además, se ha implementado la funcionalidad para agregar 
direcciones de correo electrónico y enlaces de redes sociales a los contactos existentes, 
ubicándola dentro del paquete controlador.
   
   
 * `Main (Practica_ArbolesBinarios)`:Esta clase principal constituye el punto de entrada 
del programa y se encarga de facilitar la interacción con el usuario mediante una interfaz 
sencilla para manipular un árbol binario de búsqueda que almacena contactos. Ofrece funcionalidades 
para agregar, buscar, eliminar y modificar información de los contactos, además de realizar distintos 
tipos de recorridos del árbol y proporcionar estadísticas, como el número de contactos y los niveles del árbol.
   
  # Explicación de Métodos dentro de la Clase ArbolContacto  
  
  1. `Insertar` : La inserción en un árbol binario de búsqueda se hace de forma recursiva,
    comparando el valor del nuevo elemento con los valores de los nodos existentes y
    colocándolo en el subárbol adecuado para mantener el orden. Los valores menores
    se colocan a la izquierda y los valores mayores a la derecha en cada nodo. Así, se
    garantiza que el árbol esté ordenado y optimizado para búsquedas eficientes.

 2. `inOrderRecursivo` : Realiza un recorrido inorden (inorder traversal)
    recursivo en un árbol binario de búsqueda. En este tipo de recorrido, se
    visitan los nodos en el siguiente orden: primero el subárbol izquierdo, luego
    el nodo actual y finalmente el subárbol derecho.

 3. `estaEquilibrado ` : Este método nos retorna un booleano y lo que hace es 
 llamar al método privado "verificarBalance" el cual también nos devuelve un
 valor booleano.
  
 4. `verificarBalance `: Este método es llamado por el método "estaEquilibrado
 y lo que hace es que aprovecha el método "obtenerAltura" y almacena tanto la
 altura de la parte izquierda del árbol como la de la derecha, y los utiliza 
 para calcular la diferencia, que sería la resta de ambos valores, si dicha 
 diferencia es mayor a 1 nos devolvería un valor falso y de no serlo vuelve 
 a llamar al método utilizando recursividad pero con los siguientes nodos del
 árbol

 5. `obtenerAltura` : El método en cuestión es una función recursiva destinada 
 a calcular la altura de un subárbol en un árbol binario de búsqueda. 
 La altura de un subárbol se define como el número de niveles que contiene, 
 es decir, la longitud del camino más largo desde la raíz hasta una hoja dentro 
 del subárbol.

 6. `encontrarMinimo `: Este método es una función que busca y devuelve el nodo 
 con el valor mínimo (el sucesor más pequeño) en un subárbol. Es específicamente  
 utilizado para encontrar el nodo sucesor más pequeño en el subárbol derecho de un 
 nodo dado. Este procedimiento es empleado en el caso 2 de eliminación cuando se 
 desea eliminar un nodo con dos hijos. 

 7.`buscarContactoRecursivo`: Este método permite buscar un contacto en el árbol 
 binario de búsqueda utilizando el método auxiliar llamado 
 buscarContactoRecursivo(Nodo nodo, String nombre). La búsqueda se realiza 
 de manera recursiva en el árbol, y si se encuentra el contacto con el nombre 
 specificado, el método devuelve el nodo que lo contiene. En caso de no encontrar 
 el contacto con el nombre proporcionado, el método devuelve null.

 8. `printTreeNode` : Esta función tiene la capacidad de imprimir de forma visual 
 la estructura de un árbol binario de búsqueda. La representación gráfica muestra 
 los nodos del árbol junto con las conexiones entre ellos, lo que permite visualizar 
 claramente la jerarquía y disposición de los elementos en el árbol.

 9. `postOrderRecursivo ` : Este metodo ejecuta un recorrido postorden (postorder traversal) 
 de manera recursiva en un árbol binario de búsqueda. En este tipo de recorrido, 
 los nodos se visitan siguiendo el siguiente orden: primero se exploran los subárboles 
 izquierdo y derecho y, finalmente, se visita el nodo actual.

 10. `preOrderRecursivo ` : Este metodo realiza un recorrido en preorden (preorder traversal) 
 de manera recursiva en un árbol binario de búsqueda. En este tipo de recorrido, se visita el 
 nodo actual primero, y luego se exploran los subárboles izquierdo y derecho en ese orden.

 11. `imprimirPorNiveles` : Es una función que imprime de manera visual la estructura de
    un árbol binario de búsqueda. La representación muestra los nodos del árbol
    junto con las conexiones entre ellos para visualizar la jerarquía y la
    disposición de los elementos en el árbol.

 12. `obtenerNumeroContactos` : Esta función permite obtener el número total de contactos en 
 el árbol binario de búsqueda utilizando el método auxiliar llamado obtenerNumeroContactosRecursivo(Nodo nodo). 
 El cálculo se realiza de manera recursiva contando los contactos en cada nodo y sumándolos para obtener el 
 total en todo el árbol


  13. `obtenerNumeroNiveles` : permite obtener el número total de niveles del árbol binario de búsqueda utilizando
      el método auxiliar obtenerNumeroNivelesRecursivo(Nodo nodo) que calcula de manera recursiva la altura del
      árbol contando los niveles en cada subárbol y determinando el máximo entre las alturas de los subárboles
      izquierdo y derecho para obtener el número total de niveles del árbol.

   14. `obtenerAltura` : Esta función posibilita obtener el número total de niveles del árbol binario de búsqueda 
 utilizando el método auxiliar llamado obtenerNumeroNivelesRecursivo(Nodo nodo). El cálculo se realiza de manera recursiva, 
 calculando la altura del árbol contando los niveles en cada subárbol. Luego, determina el máximo entre las alturas de los 
 subárboles izquierdo y derecho para obtener el número total de niveles del árbol..

  15.`getRaiz` : Este metodo permite obtener la raiz actual del arbol.

	# Explicacion de Metodos dentro de la Clase Main

La clase main consiste del siguiente menú: Bienvenido al sistema de Gestion de Contactos
                               --------  Menú Principal   -------
                               .1.  Agregar un nuevo contacto: 
                               .2.  Buscar contacto por su nombre: 
                               .3.  Eliminar contacto: 
                               .4.  Agregar un correo:
                               .5.  Agregar una red social:
                               .6.  Imprimir el arbol de contactos:
                               .7.  Obtener el número de contactos:
                               .8.  Obtener el número de contactos por niveles:
                               .9.  Imprimir arbol de contactos en recorrido PreOrden:
                               .10. Imprimir arbol en de contactos recorrido InOrden:
                               .11. Imprimir arbol de contactos en recorrido PostOrden:
                               .12. Imprimir arbol de contactos en recorrido por niveles:
                               .13. Salir

Del cual el usuario podrá escoger una opción la cual mediante el metodo Switch llamará a uno de los metodos del controlador
para realizar la accion seleccionada. 
