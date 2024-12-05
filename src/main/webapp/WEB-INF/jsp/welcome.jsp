<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            color: #fff;
        }

        body {
            background: #081b29;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }

        /* Cabecera */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            padding: 20px;
            box-sizing: border-box;
            background-color: #1e2a35;
        }

        .logo img {
            height: 40px;
        }

        .center-content {
            display: flex;
            justify-content: center;
            flex-grow: 1;
            align-items: center;
        }

        .center-content a, .center-content span {
            margin: 0 10px;
            color: #fff;
        }

        /* Estilos para los enlaces de inicio/cierre de sesión */
        a {
            text-decoration: none;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
        }

        /* Contenido de bienvenida */
        .welcome-wrapper {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 100%;
            max-width: 900px;
            height: 400px;
            background: #2a3c56;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            margin-top: 20px;
            padding: 20px;
            text-align: center;
        }

        .welcome-title {
            font-size: 32px;
            margin-bottom: 20px;
            color: #00FFFF;
        }

        .message {
            font-size: 18px;
            margin-bottom: 30px;
            color: #ccc;
        }

        .start-btn {
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 30px;
            background: linear-gradient(to right, #0ef, #c800ff);
            border: none;
            color: #fff;
            cursor: pointer;
            text-align: center;
            transition: background 0.3s ease;
            
        }

        .start-btn:hover {
            background: linear-gradient(to right, #c800ff, #0ef);
        }

        .welcome-banner {
            width: 250px;
            height: 100px;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fff;
            text-align: center;
            font-size: 24px;
        }

        /* Diseño responsivo */
        @media (max-width: 768px) {
            header {
                padding: 15px;
            }

            .center-content {
                flex-grow: 1;
                justify-content: space-evenly;
                text-align: center;
            }

            .welcome-wrapper {
                width: 90%;
                height: auto;
                padding: 25px;
            }

            .welcome-title {
                font-size: 24px;
            }

            .message {
                font-size: 16px;
            }

            .start-btn {
                width: 100%;
                padding: 12px;
                font-size: 16px;
            }

            .welcome-banner {
                width: 100%;
                height: 120px;
                font-size: 20px;
            }
        }
    </style>
</head>
<body>
    <!-- Cabecera con el logo, saludo y botones de sesión -->
    <header>
    <div class="logo">
        <a href="/suerte">
            <img src="/images/default-logo.png" alt="Logo">
        </a>
    </div>
    <div class="center-content">
        <!-- Verifica si el usuario está logueado y muestra contenido acorde -->
        <c:if test="${usuario != ''}">
            <!-- Mostrar solo si el usuario es admin -->
            <a href="/add-user" style="${param.admin ? '' : 'display:none;'}">Ir a la administración</a>

            <!-- Mostrar solo si el usuario NO es admin -->
            <a style="${param.admin ? 'display:none;' : ''}">Hola ${usuario.nombre}</a>
        </c:if>
    </div>

    <!-- Botón de login o logout dependiendo del estado -->
    <div>
        <c:if test="${usuario != ''}">
            <a href="/logout">Cerrar sesión</a>
        </c:if>

        <c:if test="${usuario == ''}">
            <a href="/login">Iniciar sesión</a>
        </c:if>
    </div>
</header>

    <!-- Contenedor de bienvenida con mensaje y banner -->
    <div class="welcome-wrapper">
        <div class="welcome-title">¡Bienvenido de nuevo!</div>
        <div class="message">
            Estamos encantados de tenerte con nosotros. Aquí puedes empezar a explorar nuestra página.
        </div>
        <button class="start-btn" onclick="window.location.href='/home'">Comenzar</button>
        <br>
        <div class="welcome-banner">
            Tu suerte te espera, mirastes al abismo y el abismo te devolvio la mirada
        </div>
    </div>
</body>
</html>
