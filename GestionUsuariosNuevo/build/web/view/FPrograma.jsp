
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programa</title>
    </head>
    <body>
        <h1>Registro de Programas</h1>
        <div class="col-lg-6">
            <form action="../ControladorPrograma">
                Codigo de Programa:<br>
                <input class="form-control" type="number" name="codpro"><br><br>
                Nombre del Programa:<br>
                <input class="form-control" type="text" name="nombrepro"><br><br>
                <input class="btn btn-danger" type="submit" name="accion" value="Agregar">
                <a class="btn btn-warning" href="../index.jsp">Volver a Inicio</a>
            </form> 
        </div>
    </body>
</html>
