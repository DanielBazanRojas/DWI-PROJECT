<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Estilos -->
    <script src="https://cdn.tailwindcss.com"></script>
    <style type="text/tailwindcss">
        @layer utilities {
            .content-auto {
                content-visibility: auto;
            }
        }
    </style>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body>
<div class="grid place-items-center w-full h-screen bg-cover bg-center" style="background-image: url('/assets/background.jpg');">
    <div class="bg-white/90 p-16 rounded-xl">
        <p class="text-4xl text-extrabold text-center mb-16">Iniciar Sesion</p>

        <form action="login" method="post" id="login-form" class="mb-12">
            <div class="relative my-4">
                <label class="text-black text-lg font-medium">Usuario</label>
                <input type="text" name="txtUsu" id="txtUsu" value="" class="w-full border-2 border-gray-300 rounded-xl p-4 mt-1 bg-transparent"  placeholder="Usuario">
            </div>
            <div class="relative my-4">
                <label class="text-black text-lg font-medium">Contraseña</label>
                <input type="password" name="txtPass" id="txtPass" value="" class="w-full border-2 border-gray-300 rounded-xl p-4 mt-1 bg-transparent" placeholder="******">
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox">
                        <input type="checkbox">
                        <label class="ml-2 font-medium text-base">Recuérdame</label>
                    </div>
                </div>
            </div>
            <div class="flex">
                <button type="submit" class="active:scale-[.98] w-full py-4 rounded-xl bg-amber-700 hover:bg-amber-800 text-white text-lg font-bold transition-colors" value="Ingresar">Ingresar</button>
            </div>
        </form>

    </div>
</div>
</body>
</html>