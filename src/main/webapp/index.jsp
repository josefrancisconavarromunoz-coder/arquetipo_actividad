<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Registro" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta Alumnos</title>
</head>
<body>

    <h1>Listado de Alumnos</h1>

    <form action="registros" method="GET">
        <input type="submit" value="Consultar Alumnos">
    </form>

    <br><br>

    <%
        List<Registro> registros = (List<Registro>) request.getAttribute("registros");
        if (registros != null) {
    %>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Dirección</th>
            </tr>
            <% for (Registro r : registros) { %>
                <tr>
                    <td><%= r.getId() %></td>
                    <td><%= r.getNombre() %></td>
                    <td><%= r.getApellido() %></td>
                    <td><%= r.getEmail() %></td>
                    <td><%= r.getTelefono() %></td>
                    <td><%= r.getDireccion() %></td>
                </tr>
            <% } %>
        </table>
    <% } %>

</body>
</html>