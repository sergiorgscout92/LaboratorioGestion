<!DOCTYPE html>
<html>
    <head>
        <title>Aprendiz</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Aprendiz</h1>
                <form action="../ControladorAprendiz">
                    Documento: <br>
                    <input class="form-control" type="number" name="documento"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="nombre"><br>
                    Apellido: <br>
                    <input class="form-control" type="text" name="apellido"><br>
                    Email: <br>
                    <input class="form-control" type="text" name="correo"><br>
                    Teléfono: <br>
                    <input class="form-control" type="number" name="Numero"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Registrar">
                    <a class="btn btn-warning" href="../index.jsp">Volver a Inicio</a>
                </form>
            </div>

        </div>
        
        
    </body>
</html>