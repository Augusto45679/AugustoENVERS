**1. Instrucciones para el proyecto y notas sobre el funcionamiento**
-----------------------------------------------------------------------------
**2. Para utilizar este proyecto clonar el URL: "https://github.com/Augusto45679/AugustoENVERS.git"**
--------
**class: "Revision"**

@GeneratedValue: Esta anotación se utiliza para especificar cómo se generarán los valores de la clave primaria. Hay varias estrategias disponibles, pero en este caso, se utiliza la estrategia GenerationType.SEQUENCE.

strategy = GenerationType.SEQUENCE: Indica que los valores de la clave primaria se generarán utilizando una secuencia de base de datos. Una secuencia es un objeto de base de datos que genera valores numéricos secuenciales.

generator = "revision_seq": Especifica el nombre del generador de secuencia que se utilizará. En este caso, se refiere a la secuencia definida por la anotación @SequenceGenerator.

@SequenceGenerator: Esta anotación se utiliza para definir una secuencia que generará valores únicos para la clave primaria.

name = "revision_seq": Especifica el nombre del generador de secuencia. Este nombre debe coincidir con el nombre utilizado en la anotación @GeneratedValue.

sequenceName = "revision_sequence": Especifica el nombre de la secuencia en la base de datos. Este es el nombre real de la secuencia que se creará o utilizará en la base de datos.

allocationSize = 1: Define el incremento entre valores consecutivos de la secuencia. En este caso, el valor se incrementa en 1 cada vez que se solicita un nuevo valor.







