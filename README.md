# INTRODUCCIÓN

- [1.1. Instalación](#1-instalación)
- [1.2. Descripción](#12-descripción)
- [1.3. Funcionalidades](#13-funcionalidades)
- [1.4. Uso](#14-uso)
- [1.5. Contribuir](#15-contribuir)
- [1.6. Historia](#16)
- [1.7. Créditos y atribuciones](#17-créditos-y-atribuciones)
- [1.8. License](#18-license)
- [1.9. Changelog](#19-changelog)
- [2.0. Javadocs](#20-javadocs)

# 1. Clase Barco

**Barco**

Este es un proyecto Java que define la clase Barco que extiende la clase Vehiculo.

## 1.1. Instalación

Si hubiese un método para instalar o ejecutar el proyecto, se indicaría aquí.

## 1.2. Descripción

La clase Barco representa un vehículo acuático y se utiliza para instanciar objetos que contienen información sobre el color, la marca, el precio, la matrícula y el tipo de barco. La clase también tiene un método para arrancar el barco y establecer la hora de inicio del viaje.
Funcionalidades

## 1.3. Funcionalidades

La clase Barco tiene las siguientes funcionalidades:

    Constructor: Crea una instancia de Barco con un color, marca, precio, matrícula y tipo de barco.
    getTipoBarco(): Devuelve el tipo de barco.
    arrancar(): Arranca el barco y establece la hora de inicio del viaje. Si el barco ya está en marcha, muestra un mensaje de aviso.
    retroceder(int metros): Retrocede el barco la cantidad de metros indicada. Si el barco no está en marcha, muestra un mensaje de aviso.
    parar(): Para el barco y muestra la hora de inicio y fin del viaje. Si el barco no está en marcha, muestra un mensaje de aviso.
    avanzar(int distancia): Avanza el barco la cantidad de metros indicada. Si el barco no está en marcha, muestra un mensaje de aviso.
    imprimirDatos(): Muestra los datos del barco.

```java
Barco barco = new Barco("Azul", "Marca", "5000", "1234ABC", "Tipo de Barco");
String tipoBarco = barco.getTipoBarco();
barco.arrancar();
```

## 1.4. Uso

TODO: Cómo se debe usar el proyecto.

**Uso de la clase Barco**

Para utilizar la clase Barco, primero debe instanciar un objeto pasando los argumentos adecuados al constructor. Luego, puede llamar a los métodos getTipoBarco() y arrancar() según sea necesario.

## 1.5. Contribuir

1. Fork it!
2. Crea tu feature branch: `git checkout -b my-new-feature`
3. Haz Commit de tus cambios: `git commit -am 'Add some feature'`
4. Push al branch: `git push origin my-new-feature`
5. Submit un pull request

## 1.6. Historia

- Version 0.1 (2023-04-19) - lanzamiento inicial
- Version 0.2 (2023-04-20) - añadido método avanzar()
- Version 0.3 (2023-04-21) - añadido método retroceder()
- Version 0.4 (2023-04-22) - añadido método parar()
- Version 0.5 (2023-04-23) - añadido resto de métodos
- Version 0.6 (2023-04-24) - Pruebas unitarias y correcciones

## 1.7. Créditos y atribuciones

<p>Lead Developer:</p> 
- Antoni (@antoni_dev)
<p>Mentor:</p>
- Carlos (@blah_blah)
<p>Contributors:</p>
- Daniel (@DaVaMuViewNext)


## 1.8. License

The MIT License (MIT)

Copyright (c) 2015 Chris Kibble

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## 1.9 Changelog

- Ahora se utiliza jakarta para el acceso a DB
- Licencia añadida como LICENSE.md

## 2.0 Javadocs

- El proyecto incluye javadocs en el archivo doc/index.html

