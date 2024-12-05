# Documentación Técnica 

Este proyecto es una aplicación web desarrollada con **Spring Boot** que utiliza **Java Server Pages (JSP)** como motor de plantillas. El objetivo de la aplicación es proporcionar una solución sencilla y escalable para gestionar dispositivos o recursos en un entorno empresarial. A través de una interfaz de usuario web, los administradores pueden visualizar, crear, editar y eliminar dispositivos conectados a la red.

La aplicación se estructura como una aplicación web empaquetada en un archivo **WAR**, lo que facilita su despliegue en servidores de aplicaciones como **Tomcat**. Utiliza las principales características de **Spring Boot** para simplificar la configuración y gestión del ciclo de vida de la aplicación, además de integrarse con una base de datos para almacenar la información de los dispositivos.

La arquitectura de la aplicación está compuesta por tres capas principales:

- **Capa de presentación**: Una interfaz de usuario basada en JSP para facilitar la interacción con el sistema.
- **Capa de lógica de negocio**: Implementada con Spring Boot, se encarga de procesar las solicitudes del usuario y gestionar la comunicación con la base de datos.
- **Capa de persistencia**: Gestionada por **JPA** (Java Persistence API) para almacenar y recuperar la información relacionada con los dispositivos.

## Controladores

La carpeta **`com.example.suerte.controller`** contiene las clases encargadas de manejar las solicitudes HTTP y redirigir a las vistas correspondientes. A continuación se describe el controlador principal, **LoginController**, que gestiona la autenticación de los usuarios en la aplicación.

### **LoginController.java**

El `LoginController` es responsable de manejar las peticiones relacionadas con el inicio y cierre de sesión del usuario, así como la visualización de las páginas de bienvenida y login. La clase está anotada con `@Controller` para indicar que es un controlador de Spring MVC.

#### Dependencias

El controlador hace uso de varias dependencias:

- **UserService**: Un servicio que se encarga de la lógica de autenticación de los usuarios.
- **UserLoginDTO**: Una clase de transferencia de datos (DTO) que representa la información del usuario autenticado.
- **HttpSession**: Para gestionar la sesión del usuario y mantener su estado mientras navega por la aplicación.

#### Métodos

1. **`showMainPage`**:
   - **URL**: `/`
   - **Método**: `GET`
   - **Descripción**: Redirige a la página de bienvenida `/welcome` al acceder a la raíz de la aplicación.

2. **`showLoginPage`**:
   - **URL**: `/login`
   - **Método**: `GET`
   - **Descripción**: Muestra la página de login donde los usuarios pueden ingresar sus credenciales (email o nickname y contraseña).

3. **`showWelcomePage`**:
   - **URL**: `/welcome`
   - **Método**: `GET`
   - **Descripción**: Muestra la página de bienvenida si el usuario está autenticado. Si no, se muestra un mensaje de error indicando que el usuario debe iniciar sesión.

4. **`login`**:
   - **URL**: `/login`
   - **Método**: `POST`
   - **Descripción**: Maneja la autenticación del usuario. Verifica las credenciales proporcionadas (email o nickname y contraseña). Si son correctas, guarda los datos del usuario en la sesión y redirige a la página de bienvenida. Si son incorrectas, muestra un mensaje de error.

5. **`logout`**:
   - **URL**: `/logout`
   - **Método**: `GET`
   - **Descripción**: Invalida la sesión actual del usuario y lo redirige a la página principal (raíz).

#### Flujo de Trabajo

1. El usuario accede a la página principal ("/") y es redirigido a la página de bienvenida si ya está autenticado.
2. Si el usuario no está autenticado, accede a la página de login en `/login`, donde puede ingresar sus credenciales.
3. Si las credenciales son correctas, se inicia una nueva sesión y el usuario es redirigido a la página de bienvenida.
4. Si el usuario desea cerrar sesión, puede acceder a `/logout`, lo que invalidará su sesión y lo llevará nuevamente a la página principal.

## Modelos

La carpeta **`com.example.suerte.model`** contiene las clases que representan los datos utilizados en la aplicación. A continuación se describe el modelo **LoginRequest**, que se utiliza para almacenar las credenciales de inicio de sesión del usuario.

### **LoginRequest.java**

La clase **`LoginRequest`** representa una solicitud de inicio de sesión con las credenciales del usuario (email, contraseña y nickname). Esta clase se utiliza para recibir y validar los datos de autenticación enviados por el usuario a través de la interfaz de login.

#### Campos

- **email**: Representa la dirección de correo electrónico del usuario (opcional, ya que también se puede usar el nickname).
- **password**: La contraseña del usuario.
- **nickUser**: Representa el nickname del usuario (opcional, en caso de que el usuario decida usar el nickname en lugar del email).

#### Constructor

El constructor inicializa los campos de la clase, verificando si el email o el nickname están vacíos o nulos. Si alguno de estos campos está vacío o nulo, se asigna el valor `null`.

#### Métodos

- **getEmail**: Retorna el valor del email del usuario.
- **setEmail**: Permite asignar un valor al campo email.
- **getPassword**: Retorna el valor de la contraseña del usuario.
- **setPassword**: Permite asignar un valor a la contraseña.
- **getNickUser**: Retorna el valor del nickname del usuario.
- **setNickUser**: Permite asignar un valor al campo nickname.

### **UserLoginDTO.java**

La clase **`UserLoginDTO`** es un objeto de transferencia de datos (DTO) que se utiliza para representar la información del usuario después de que ha iniciado sesión. Este modelo contiene los datos relevantes que se manejarán durante la sesión del usuario, como su correo electrónico, nickname, contraseña y un campo que indica si el usuario tiene permisos de administrador.

#### Campos

- **email**: El correo electrónico del usuario.
- **password**: La contraseña del usuario, que generalmente no se transfiere para su visualización una vez que el usuario se ha autenticado.
- **nickUser**: El nickname del usuario, que puede ser utilizado como una alternativa al correo electrónico.
- **isAdmin**: Un campo booleano que indica si el usuario tiene permisos de administrador.

#### Métodos

- **getEmail**: Retorna el correo electrónico del usuario.
- **setEmail**: Permite asignar un correo electrónico al usuario.
- **getPassword**: Retorna la contraseña del usuario (aunque normalmente no se usa después de la autenticación).
- **setPassword**: Permite asignar una contraseña al usuario.
- **getNickUser**: Retorna el nickname del usuario.
- **setNickUser**: Permite asignar un nickname al usuario.
- **isAdmin**: Retorna un valor booleano que indica si el usuario es un administrador.
- **setAdmin**: Permite asignar el valor de administrador.

 
