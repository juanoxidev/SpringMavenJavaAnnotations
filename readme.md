Son etiquetas que se añaden a nuestras clases, métodos, campos, variables etc en un programa Java

Sirven para añadir metadatos a nuestros programas(clases) de Java:
Los metadatos son un conjunto de datos que describen el contenido y/o propósito de un objeto.
Podes describir la naturaleza de un objeto (metadatos) con annotations nos permite utilizarlas como sustituto de los archivos XML 

Las annotations son procesadas en tiempo de compilación o también en tiempo de ejecución

Spring escanea el código de todas nuestras clases en busca de annotations, hay que preparar el XML para que Spring escanee nuestro código. 

Cuando encuentra una annotation, registra el bean de forma automática en el contenedor.

1-Preparar el XML para que Spring escanee nuestro código(clases).
En el archivo applicationContext.xml
<!-- Indicando al XML que debe escanear todas las clases de nuestro proyecto que busque las annotations -->
<!-- en el atributo base-package debemos poner el paquete donde Spring debe escanear las clases-->
<context:component-scan base-package="com.prueba.springConAnnotations"></context:component-scan>
2-Agregar annotations a nuestras clases de Java.
Spring con la annotation @Component registra el bean de esta clase, lo utilizamos llamando al id que le pasamos por parametro.
Tambien podemos directamente no ponerle un ID entre parentesis (id) y va a tomar el nombre de la clase como id pero con la primera letra como minuscula. Ej clase Comercial y la annotation Component es comercial.
@Component(“Id”)
3-Pedir el bean al contenedor.
Empleado Juan = contexto.getBean("Comercial", Empleado.class);

@Autowired: Inyección de dependencias con constructor.
1.Crear clase + interfaz a inyectar(dependencia)
2. Crear constructor para inyección en clase que lo solicite.
3. Configurar la dependencia con @Autowired

Spring busca en todo mi proyecto si hay una clase que implemente la interfaz CreacionInformeFinanciero y si la encuentra es de donde obtiene la inyección de dependencia.

Inyeccion de dependencias con Java Annotation Autowired desde un setter, con metodo norma (nomimporta que empiece con set.. da igual: y con un campo de clase. 


Que pasa si mas de una clase implementa la interfaz CreacionInformeFinanciero?? entra en juego la annotation qualifier

Annotation @Qualifier: Lo utilizaremos cuando necesitamos especificar el id de un bean en concreto.
Cuando tenemos mas de una clase que implemente la interfaz que busca Spring entonces debemos usar qualifier luego del autowired  @Qualifier("idDelBean") si no tiene ponemos el nombre de la clase con la primera letra en minúscula.

Singleton y Prototype con Annotations
Por defecto Spring trabaja en Singleton pero si abajo de la annotation component ponemos @Scope(“prototype”) el bean sera del tipo Prototype


Method Init y Destroy con Java Annotation (SOLO FUNCIONA CUANDO EL BEAN ESTA EN MODO SINGLETON) Pueden tener cualquier visibilidad, no tiene sentido que retornen otra cosa q no sea void y no deben recibir ningún argumento como parámetro.
@PostConstruct: Ejecución de código después de la creación del bean  
@PreDestroy: Ejecución de código después de apagar el contenedor Spring. contexto.close()

@Configuration
Cómo configurar Spring con código Java(config.class) prescindiendo del XML config.xml.
Creamos la clase de configuración y colocamos antes 
@Configuration
@ComponentScan("com.prueba.springConAnnotations")
leer archivo de configuracion creado en una clase java
AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(JavaConfig.class);

@Bean: Como pedir beans al contenedor de Spring con código Java prescindiendo de XML 

Para usar todo lo relacionado a Java Config hay que instalar en Maven pom.xml la dependencia:

<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>2.2.2</version>
</dependency>

@PropertySource: permite especificar la ruta al archivo externo de propiedades
@Value: permite inyectar el valor de las propiedades desde archivo externo

Creamos un archivo externo donde se contendrán las claves-valores.en la carpeta java/src y vamos poniendo las claves=valor.
ej

email=EquipoDirectivo@empresa.com.ar
nombre=Empresa S.A

Ahora debemos indicarle a la configuración realizada desde java donde se encuentra el archivo de propiedades.
@PropertySource(“classpath:datosEmpresa.propiedades”)

Luego vamos a la clase a la cual queramos insertar los valores que definimos en el archivo de propiedades por ej la clase DirectorEmpleado queremos inyectarle el valor de nombreEmpresa, creamos el atributo en la clase y antes ponemos @Value("${nombreEmpresa}") la clave entre “${}”

 Para que te tome los valores que se pusieron en el archivo de propiedades ademas debemos agregar al javaConfig el siguente Bean:

	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
