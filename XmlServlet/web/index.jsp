<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - Xml Generator</title>

        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"/>

    </head>
    <body>
        <div class="row">
            <form action="XmlServlet" method="get" class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <input  id="ruta" class="validate" placeholder="C:\\" type="text" name="ruta">
                        <label for="ruta">Ruta:</label>
                    </div>

                    <div class="input-field col s6">
                        <input id="archivo" class="validate" placeholder="MyXML" type="text" name="archivo">
                        <label for="archivo">Nombre Archivo:</label>
                    </div>
                </div>
                <br/>
                <input name="enviar" class="waves-effect waves-light btn" 
                       type="submit" value="Generar xml">
            </form>
        </div>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </body>
</html>
