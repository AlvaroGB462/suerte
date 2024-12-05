<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Usuario</title>
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
            width: 900px;
            height: auto;
            display: grid;
            grid-template-columns: 1fr 1fr;
            border: 3px solid #00ffff;
            box-shadow: 0 0 50px 0 #00a6bc;
            border-radius: 10px;
            padding: 20px;
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
            margin-bottom: 20px;
        }

        .input {
            border: none;
            outline: none;
            background: none;
            width: 260px;
            padding: 10px;
            font-size: 17px;
            color: #0ef;
            border-bottom: 2px solid #0ef;
        }

        .submit {
            border: none;
            outline: none;
            width: 288px;
            padding: 10px 0;
            font-size: 20px;
            border-radius: 40px;
            letter-spacing: 1px;
            cursor: pointer;
            background: linear-gradient(45deg, #0ef, #c800ff);
            color: white;
            transition: background 0.3s ease;
            margin-top: 20px;
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

        /* Responsive Design */
        @media (max-width: 768px) {
            .wrapper {
                width: 90vw;
                height: auto;
                grid-template-columns: 1fr;
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
        }
    </style>
</head>
<body>

    <div class="wrapper">
        <!-- Formulario para agregar un usuario -->
        <form class="form" action="${pageContext.request.contextPath}/add-user" method="post" enctype="multipart/form-data">
    <h1 class="title">Formulario de Registro</h1>

    <!-- Campos de formulario -->
    <div class="inp">
        <input type="text" id="nickUser" name="nickUser" class="input" placeholder="Nick Usuario" required>
    </div>

    <div class="inp">
        <input type="text" id="nameUser" name="nameUser" class="input" placeholder="Nombre" required>
    </div>

    <div class="inp">
        <input type="password" id="passwordUser" name="passwordUser" class="input" placeholder="Contraseña" required>
    </div>

    <div class="inp">
        <input type="text" id="dni" name="dni" class="input" placeholder="DNI" required>
    </div>

    <div class="inp">
        <input type="email" id="email" name="email" class="input" placeholder="Correo Electrónico" required>
    </div>

    <div class="inp">
        <input type="text" id="address" name="address" class="input" placeholder="Dirección">
    </div>

    <div class="inp">
        <input type="text" id="imgUser" name="imgUser" class="input" placeholder="Imagen de Usuario (URL)">
    </div>

    <div class="inp">
        <label for="admin" class="input">Es Administrador:</label>
        <input type="checkbox" id="admin" name="admin">
    </div>

    <div class="inp">
        <input type="number" id="idClub" name="idClub" class="input" placeholder="ID del Club">
    </div>

    <button type="submit" class="submit">Agregar Usuario</button>
</form>

        <!-- Banner de bienvenida -->
        <div class="banner">
            <h1 class="wel_text">Bienvenid@</h1>
        </div>
    </div>

</body>
</html>
