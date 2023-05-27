
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Programa"%>
<%@page import="modelDao.ProgramaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Listar Programa</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>PROGRAMAS REGISTRADOS EN EL SISTEMA</h1>
            <table class="table table-responsive"
            <table>
                <thead>
                    <tr>
                        <th class="text-center">CÓDIGO DEL PROGRAMA</th>
                        <th class="text-center">NOMBRE DEL PROGRAMA</th>                        
                    </tr>
                </thead>
                <%
                        ProgramaDao dao = new ProgramaDao();
                        List<Programa>listar=dao.listadopro();
                        Iterator<Programa>it=listar.iterator();
                        Programa po = null;
                        while(it.hasNext()){
                            po=it.next();
                        
                    %>
                <tbody>
                        <tr>
                            <td class="text-center"><%=po.getCodprograma()%></td>
                            <td class="text-center"><%=po.getNombreprograma()%></td>
                            
                            <td class="text-center">
                                <a class="btn btn-danger" href="../ControladorPrograma?accion=editarpro&codprograma=<%=po.getCodprograma()%>">EDITAR</a>
                                <br>
                                <a class="btn btn-warning" href="../ControladorPrograma?accion=eliminarpro&codprograma<%=po.getCodprograma()%>">ELIMINAR</a>
                            </td>
                        </tr>
                    <% } %>    
                        </tbody>
            </div>
        </div>
    </body>
</html>
