/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Aislan
 */
@WebService(serviceName = "TempConvertWS")
public class TempConvertWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "celsiusToFahrenheit")
    public String celsiusToFahrenheit(
        @WebParam(name = "celsius")String celsius){
        
        float fah, cel = Float.parseFloat(celsius);
        
        fah = (cel * (float) 1.8) + 32;
        
        return Float.toString(fah);
    }
    
    @WebMethod(operationName = "fahrenheitToCelsius")
    public String fahrenheitToCelsius(
            @WebParam(name = "fahrenheit")String fahrenheit){
        
        float cel, fah = Float.parseFloat(fahrenheit);
        
        
        cel = (fah - 32) / (float) 1.8;
        
        
        return Float.toString(cel);
    }
}
