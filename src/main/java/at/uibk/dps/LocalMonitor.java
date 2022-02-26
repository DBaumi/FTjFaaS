package at.uibk.dps;

import at.uibk.dps.exception.*;
import at.uibk.dps.function.Function;
import jContainer.helper.Stopwatch;
import jContainer.invoker.ContainerInvoker;
import jFaaS.utils.PairResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalMonitor implements ContainerMonitor {

    final static Logger logger = LoggerFactory.getLogger(LocalMonitor.class);

    @Override
    public PairResult<String, Long> monitoredInvoke(ContainerInvoker invoker, Function function) throws Exception {
        PairResult<String, Long> result = null;
        Stopwatch monitoredInvokation = new Stopwatch(false);

        try {
            result = invoker.invokeFunction(function.getUrl(), function.getFunctionInputs());
            assert result != null;
        } catch (Exception e) {
            String additionalInfo = "Exception " + e.getCause().toString() + " in function '" + function.getName() + "' was caught: ";
            String exceptionMessage = e.getMessage();

            // docker engine
            if(exceptionMessage.contains("docker_engine")) {
                throw new NoRunningDockerEngineException(additionalInfo + "Please start your local docker engine (Docker Desktop)!");
            }

            // missing credentials file
            else if(exceptionMessage.contains("credentials.properties")) {
                throw new MissingCredentialsFileException(additionalInfo + "Please check if the 'credentials.properties' file in the same directory you started the EE execution!");
            }

            // missing jar for function
            else if(exceptionMessage.contains("File")) {
                throw new MissingJarFileException(additionalInfo + "Please check if the 'jars' folder (defined in 'credentials.properties' or fallback directory './jars/') has a JAR file with the same name as the function in the workflow!");
            }

            // missing mandatory credentials property
            else if(exceptionMessage.contains("Key") && exceptionMessage.contains("is not set")) {
                throw new MissingMandatoryKeyInCredentialsFileException(additionalInfo + "Please check your 'credentials.properties' file and fill it with all mandatory information!");
            }

            // wrong image
            else if(exceptionMessage.contains("Empty result in container!")) {
                throw new EmptyContainerResultException(additionalInfo + "Please check the provided 'docker_image' in resource field or provided properties regarding docker!");
            }

            // wrong resource link for function
            else if(exceptionMessage.contains("local execution")){
                throw new InvalidResourceContainerException(additionalInfo + "Please check the provided resource link for execution as container!");
            }
        }

        logger.info("Monitored invocation took {}ms", monitoredInvokation.getElapsedTime());
        return result;
    }
}