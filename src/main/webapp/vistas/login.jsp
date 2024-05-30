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
<div class="grid place-items-center w-full h-screen bg-[url('https://scontent-lim1-1.xx.fbcdn.net/v/t39.30808-6/373456018_789309336341539_2355573434824480551_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEMF-Q3ZmdkANaC87H2FM1939mapYacWXnf2ZqlhpxZeaUN_5a2EYR6wHaIhq9o5mfJANRkav9jrV95pZHBuZLp&_nc_ohc=wykaWI3zGO4Q7kNvgE749vA&_nc_ht=scontent-lim1-1.xx&oh=00_AYBodL9cNkn4cTSMr3gzucWU_fWMfC2teJOF97EfNFfIkw&oe=665DFE19')] bg-cover bg-center">
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
<script type="text/javascript">
    var status = document.getElementById("status").value;
    if(status == "failed"){
        swal("Error", "Usuario o contraseña incorrectos", "Hubo un error al iniciar sesion");
    }
</script>
</body>
</html>