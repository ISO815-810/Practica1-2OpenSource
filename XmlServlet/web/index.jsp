<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - Xml Generator</title>
    </head>
    <body>
        <div >
            <form action="XmlServlet" method="get">
                <div >
                    <div>
                        Ruta: <input class="file-path validate" type="text" name="ruta">
                    </div>

                    <div >
                       Nombre Archivo: <input class="file-path validate" type="text" name="archivo">
                    </div>
                </div>
                <br/>
                <input name="enviar" type="submit" value="Generar xml">
            </form>
        </div>
    </body>
</html>
