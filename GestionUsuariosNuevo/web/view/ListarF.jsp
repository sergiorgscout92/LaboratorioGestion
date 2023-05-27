<%-- 
    Document   : ListarF
    Created on : 15 may. 2023, 20:05:03
    Author     : APRENDIZ
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.Ficha"%>
<%@page import="java.util.List"%>
<%@page import="modelDao.FichaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Fichas</title>
    </head>
    <body>
        <div class="container">
            <h1>APRENDICES REGISTRADOS EN EL SISTEMA</h1>
            <table class="table table-responsive"
            <table>
                <thead>
                    <tr>
                        <th class="text-center">CÓDIGO DE FICHA</th>
                        <th class="text-center">CANTIDAD DE APRENDICES</th>
                        <th class="text-center">NOMBRE DEL PROGRAMA</th>
                        <th class="text-center">NOMBRE DEL APRENDIZ</th>
                    </tr>
                </thead>
                
                    <%
                        FichaDao dao = new FichaDao();
                        List<Ficha>listar=dao.listaFichas();
                        Iterator<Ficha>it=listar.iterator();
                        Ficha fi = null;
                        while(it.hasNext()){
                            fi=it.next();
                        
                    %>
                    <tbody>
                        <tr>
                            <td class="text-center"><%=fi.getCodficha()%></td>
                            <td class="text-center"><%=fi.getCantapre()%></td>
                            <td class="text-center"><%=fi.getNombrepro()%></td>
                            <td class="text-center"><%=fi.getNombreA()%></td>
                            

                            <td class="text-center">
                                <a class="btn btn-danger" href="../ControladorFicha?accion=editarFi&codficha=<%=fi.getCodficha()%>">EDITAR</a>
                                <a class="btn btn-warning" href="../ControladorFicha?accion=eliminarFi&codficha=<%=fi.getCodficha()%>">ELIMINAR</a>
                            </td>
                        </tr>
                    <% } %>    
                        </tbody>
            </table>
        </div>
    </body>
</html>
