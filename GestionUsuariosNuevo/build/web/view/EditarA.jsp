<%-- 
    Document   : EditarA
    Created on : 8/05/2023, 8:42:03 p. m.
    Author     : APRENDIZ
--%>

<%@page import="model.Aprendiz"%>
<%@page import="modelDao.AprendizDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Aprendiz</title>
    </head>
    <body>
        <section class="form-register">
            <form action="../ControladorAprendiz">
            <h4>Editar Aprendiz</h4>
            <%
                AprendizDao ape = new AprendizDao();
                int id = Integer.parseInt((String)request.getAttribute("id"));
                Aprendiz ap = new Aprendiz();
                ap=ape.list(id);
            %>
            <label for="id">Edita tu Id</label>
            <input class="controls" type="text" name="id" id="id" value="<%=ap.getId()%>">
            <br>
            <br>
            <label for="documento">Edita tu Documento</label>
            <input class="controls" type="text" name="documento" id="documento" value="<%=ap.getDocumentoa()%>">
            <br>
            <br>
            <label for="nombre">Edita tu Nombre</label>
            <input class="controls" type="text" name="nombre" id="nombre" value="<%=ap.getNombrea()%>">
            <br>
            <br>
            <label for="apellido">Edita tu Apellido</label>
            <input class="controls" type="text" name="apellido" id="apellido" value="<%=ap.getApellidoa()%>">
            <br>
            <br>
            <label for="correo">Edita tu Email</label>
            <input class="controls" type="email" name="correo" id="correo" value="<%=ap.getCorreoa()%>">
            <br>
            <br>
            <label for="Numero">Edita tu Teléfono</label>
            <input class="controls" type="text" name="Numero" id="Numero" value="<%=ap.getTelefonoa()%>">
            
            
            <p><input class="botons" type="submit" name="accion" value="Actualizar">
            
            </form>
        </section>
    </body>
</html>
