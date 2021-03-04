package at.uibk.dps;

import at.uibk.dps.exception.AuthenticationFailedException;
import at.uibk.dps.exception.MemoryExceededException;
import at.uibk.dps.exception.TimeLimitException;
import com.google.api.client.http.HttpResponseException;
import at.uibk.dps.function.Function;
import jFaaS.invokers.FaaSInvoker;


/**
 * Method to invoke Google Functions with Monitoring (using jFaas.jar)
 * Since the GoogleInvoker uses HTTPTriggers, different HTTPResponseException status codes are interpreted
 * More specific Exceptions from exception package are thrown to be handled down the line
 */
public class GoogleFunctionMonitor implements InvokeMonitor{


    @Override
    public String monitoredInvoke(FaaSInvoker invoker, Function function) throws Exception {

        String returnValue = new String();


        try{
            returnValue= invoker.invokeFunction(function.getUrl(), function.getFunctionInputs()).toString();
            assert returnValue!= null;

        } catch(HttpResponseException e){
            int statusCode = e.getStatusCode();

            if(statusCode == 403){
                System.out.println("AuthenticationFailedException");
                throw new AuthenticationFailedException(e.getMessage());
            }
            else if(statusCode== 503){
                System.out.println("MemoryExceededException");
                throw new MemoryExceededException(e.getMessage());

            }
            else if(statusCode==408){
                System.out.println("TimeLimitException");
                throw new TimeLimitException(e.getMessage());

            } else{
                System.out.println("Other HTTPException");
                throw e;

            }

        }catch(Exception e){
            System.out.println("Some other Exception");
            throw e;
        }

        return returnValue;

    }


}