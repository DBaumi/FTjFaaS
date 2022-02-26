package at.uibk.dps;

import at.uibk.dps.function.Function;
import jContainer.invoker.ContainerInvoker;
import jFaaS.utils.PairResult;

public interface ContainerMonitor {
    PairResult<String, Long> monitoredInvoke(ContainerInvoker invoker, Function function) throws Exception;
}
