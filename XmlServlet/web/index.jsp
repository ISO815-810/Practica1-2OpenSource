<%-- 
    Document   : index
    Created on : 29-ene-2019, 15:08:34
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card-content">
            <form action="index.jsp" method="POST">
                <div class="file-field input-field">
                    <div class="btn">
                        <span>Archivo</span>
                        <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text" name="file" size="50">
                    </div>
                </div>
                <br/>
                <input class="btn waves-effect waves-light" name="enviar" type="submit" value="Leer Archivo">
            </form>

            <%
                /*
                if (request.getParameter("enviar") != null) {
                    String nombreArchivo = request.getParameter("file").toString();
                    File archivo = new File("C://Users/Carlos/Desktop/PROGRAMACION Y DESARROLLO/JAVA/Proyectos JAVA/APAP/web/archivos/" + nombreArchivo);
                    if (archivo.exists()) {
                        LeerArchivo la = new LeerArchivo();
                        LeerArchivo.muestraContenido("C://Users/Carlos/Desktop/PROGRAMACION Y DESARROLLO/JAVA/Proyectos JAVA/APAP/web/archivos/" + nombreArchivo);
                 */
            %>        

            <script>
                alert('Archivo leido correctamente.');
            </script>

            <%
 /*              
                }
            else {
                 */
            %>        

            <script>
                alert('Ponga el archivo en la carpeta correspondiente.');
            </script>

            <% /*
                }
                }
                 */
            %>

        </div>
    </body>
</html>
