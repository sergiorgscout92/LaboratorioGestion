<%-- 
    Document   : EditarF
    Created on : 15 may. 2023, 20:05:12
    Author     : APRENDIZ
--%>

<%@page import="model.Ficha"%>
<%@page import="modelDao.FichaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="form-register">
            <form action="../ControladorFicha">
            <h4>Editar Ficha</h4>
            <%
                FichaDao fdao = new FichaDao();
                int cod = Integer.parseInt((String)request.getAttribute("codficha"));
                Ficha fi = new Ficha();
                fi=fdao.listaFichas();
            %>
            <label for="id">Edita el Código de la Ficha</label>
            <input class="controls" type="number" name="codficha" id="codficha" value="<%=fi.getCodficha()%>">
            <br>
            <br>
            <label for="id">Edita la Cantidad de Aprendices</label>
            <input class="controls" type="number" name="cantapre" id="cantapre" value="<%=fi.getCantapre()%>">
            <br>
            <br>
            <label for="documento">Edita el Código del Programa</label>
            <input class="controls" type="number" name="nombrepro" id="nombrepro" value="<%=fi.getCodprod()%>">
            <br>
            <br>
            <label for="id">Edita el Código del Aprendiz</label>
            <input class="controls" type="number" name="codaprendiz" id="codaprendiz" value="<%=fi.getCodaprendiz()%>">
            <br>
            <br>
            
            <p><input class="botons" type="submit" name="accion" value="Actualizar">
            
            </form>
        </section>
    </body>
</html>
