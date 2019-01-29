<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - Xml Generator</title>
    </head>
    <body>
        <div class="card-content">
            
            <form action="index.jsp" method="POST">
                
                <div class="file-field input-field">

                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text" name="ruta" size="50">
                    </div>
                    
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text" name="archivo" size="50">
                    </div>
                </div>
                <br/>
                <input class="btn waves-effect waves-light" name="enviar" type="submit" value="">
            </form>
            
        </div>
        
    </body>
</html>
