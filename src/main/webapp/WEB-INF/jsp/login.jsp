<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            color: #fff;
        }

        body {
            width: 100vw;
            height: 100vh;
            background: #081b29;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        /* Estructura principal de la página */
        .wrapper {
            position: relative;
            width: 900px; /* Ajustado el tamaño total */
            height: 500px;
            display: grid;
            grid-template-columns: 1fr 1fr; /* Coloca el formulario y el banner lado a lado */
            border: 3px solid #00ffff;
            box-shadow: 0 0 50px 0 #00a6bc;
            border-radius: 10px;
        }

        /* Estilo para el formulario */
        .form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .title {
            font-size: 35px;
            margin-bottom: 20px;
        }

        .inp {
            padding-bottom: 10px;
            border-bottom: 2px solid #eee;
        }

        .input {
            border: none;
            outline: none;
            background: none;
            width: 260px;
            margin-top: 40px;
            padding-right: 10px;
            font-size: 17px;
            color: #0ef;
            border-bottom: 2px solid #0ef;
        }

        .submit {
            border: none;
            outline: none;
            width: 288px;
            margin-top: 25px;
            padding: 10px 0;
            font-size: 20px;
            border-radius: 40px;
            letter-spacing: 1px;
            cursor: pointer;
            background: linear-gradient(45deg, #0ef, #c800ff);
            color: white;
            transition: background 0.3s ease;
        }

        .submit:hover {
            background: linear-gradient(45deg, #c800ff, #0ef);
        }

        .footer {
            margin-top: 30px;
            letter-spacing: 0.5px;
            font-size: 14px;
        }

        .link {
            color: #0ef;
            text-decoration: none;
        }

        /* Estilo para el banner de bienvenida */
        .banner {
            position: absolute;
            top: 0;
            right: 0;
            width: 450px;
            height: 390px;
            background: linear-gradient(to right, #0ef, #c800ff);
            clip-path: polygon(0 0, 100% 0, 100% 100%, 60% 100%);
            padding-right: 70px;
            text-align: right;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: flex-end;
            border-radius: 10px;
        }

        .wel_text {
            font-size: 40px;
            margin-top: -50px;
            line-height: 50px;
        }

        .para {
            margin-top: 10px;
            font-size: 18px;
            line-height: 24px;
            letter-spacing: 1px;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .wrapper {
                width: 90vw;
                height: auto;
                grid-template-columns: 1fr;
                grid-template-rows: auto auto;
                justify-items: center;
                border-radius: 10px;
            }

            .banner {
                position: relative;
                clip-path: none;
                width: 100%;
                height: 60px;
                padding: 0;
                text-align: center;
                display: flex;
                justify-content: center;
                align-items: center;
                border-radius: 10px;
            }

            .form {
                width: 100%;
                padding: 20px;
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .title {
                font-size: 28px;
                margin-bottom: 20px;
            }

            .input {
                width: 90%;
                padding: 10px;
            }

            .submit {
                width: 90%;
            }

            .wel_text {
                font-size: 24px;
                text-align: center;
                margin-top: 25px;
            }

            .para {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>

    <div class="wrapper">
        <!-- Formulario de login -->
        <form id="login-form" class="form" action="/login" method="POST">
            <h1 class="title">Inicio</h1>

            <!-- Mostrar error si las credenciales son incorrectas -->
            <c:if test="${not empty error}">
                <div style="color: red; text-align: center;">
                    <span>${error}</span>
                </div>
            </c:if>

            <!-- Input para email o nick -->
            <div class="inp">
                <input type="text" id="emailOrNick" name="emailOrNick" class="input" placeholder="Email o Nickname" required>
            </div>

            <!-- Input para contraseña -->
            <div class="inp">
                <input type="password" id="password" name="password" class="input" placeholder="Contraseña" required>
            </div>

            <!-- Botón para iniciar sesión -->
            <button type="submit" class="submit">Iniciar sesión</button>

            <p class="footer">¿No tienes cuenta? <a href="#" class="link">Por favor, Regístrate</a></p>
        </form>

        <!-- Banner de bienvenida -->
        <div class="banner">
            <h1 class="wel_text">Bienvenid@</h1>
        </div>
    </div>

</body>
</html>
