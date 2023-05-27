<%-- 
    Document   : FormFicha
    Created on : 15 may. 2023, 19:58:11
    Author     : APRENDIZ
--%>

<%@page import="model.Programa"%>
<%@page import="model.Aprendiz"%>
<%@page import="java.util.List"%>
<%@page import="modelDao.ProgramaDao"%>
<%@page import="modelDao.AprendizDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Ficha</title>
    </head>
    <body>
        <div class="col-lg-6">
        <h1>Registro de Fichas</h1>
        <section class="form-register">
            <form action="../ControladorFicha">
            <h3>Registro de Fichas</h3>
            <input class="controls" type="text" name="codficha" placeholder="Código Ficha">
            <br>
            <br>
            <input class="controls" type="text" name="cantapre" placeholder="Cantidad de Aprendices">
            <br>
            <br>
            <div class="form-group">
                <label Nombre Programa></label>
                <select name="listapro" class="custom-select">
                    <option value="0">Seleccionar nombre del programa</option>
                    <%ProgramaDao pro = new ProgramaDao(); 
                    List<Programa> lista = pro.listadopro();%>
                <%for(Programa li:lista){%>
                <option value="<%=li.getCodprograma() %>"><%=li.getNombreprograma()%></option>
                <%}%>
                </select>
            </div>
                <br>
            <div class="form-group">
                <label Nombre Programa></label>
                <select name="listaapre" class="custom-select">
                    <option value="0">Seleccionar nombre del aprendiz</option>
                        <%AprendizDao adao = new AprendizDao();
                List<Aprendiz>list = adao.listadoA();
                %>
                <%
                for(Aprendiz li:list){%>
                <option value="<%=li.getId()%>"><%=li.getNombrea()%><%=li.getNombrea()%></option>
                <%}%>
               </select>
            </div>
            <p><input class="botons" type="submit" name="accion" value="Registrar">
                <a class="btn btn-success" href="../index.jsp">Volver a Inicio</a>
            </form>
        </section>
        </div>
    </body>
</html>
