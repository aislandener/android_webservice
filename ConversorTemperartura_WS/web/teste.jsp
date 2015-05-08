<%-- 
    Document   : index
    Created on : 23/04/2015, 21:56:50
    Author     : lab2
--%>

<%@page import="servico.TempConvertWS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversor de Temperaturas</title>
    </head>
    <body>
        <%
            String v1 = request.getParameter("txtCelsius");
            String v2 = request.getParameter("txtFahrenheit");
            
            //referenciar
            TempConvertWS srv = new TempConvertWS();
            
            //opereções
            
            if ( v1 != null ){
                if( !v1.isEmpty()){
                    v2 = srv.celsiusToFahrenheit(v1);
                }else{
                    v1 = srv.fahrenheitToCelsius(v2);
                }
            }else{
                v1= "";
                v2= "";
            }
            
        %>
        <h1>Conversor de Temperaturas</h1>
        <form name="frmConversor" action="teste.jsp" method="post">
            <label>Celsius</label>
            <input name="txtCelsius" type="text" size="8" value="<%=v1%>"/>
            <br/>
            
            <label>Fahrenheit</label>
            <input name="txtFahrenheit" type="text" size="8" value="<%=v2%>"/>
            <br/>
            
            <input name="btnConverter" type="submit"/>
        </form>
    </body>
</html>
