<%-- 
    Document   : EditarP
    Created on : 10/05/2023, 9:03:00 p. m.
    Author     : APRENDIZ
--%>

<%@page import="model.Programa"%>
<%@page import="modelDao.ProgramaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Programa</title>
    </head>
    <body>
        <section class="form-register">
            <form action="ControladorPrograma">
            <h4>Editar Programa</h4>
            <%
                ProgramaDao adao = new ProgramaDao();
                int id = Integer.parseInt((String)request.getAttribute("codprograma"));
                Programa pro = new Programa();
                pro=adao.listadoP(id);
            %>
            <label for="id">Editar Código:</label>
            <input class="controls" type="text" name="id" value="<%=pro.getCodprograma()%>">
            <br>
            <br>
             <label for="id">Editar Nombre</label>
            <input class="controls" type="text" name="nombrepro" value="<%=pro.getNombreprograma()%>">
            <br>
            <p><input class="botons" type="submit" name="accion" value="Actualizar">
            
            </form>
        </section>

    </body>
</html>
