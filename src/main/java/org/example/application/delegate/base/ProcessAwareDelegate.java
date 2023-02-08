package org.example.application.delegate.base;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.function.Function;

public abstract class ProcessAwareDelegate<T extends AbstractProcessContext> implements JavaDelegate {
    private final Function<DelegateExecution, T> contextCreator;

    public ProcessAwareDelegate(Function<DelegateExecution, T> contextCreator) {
        this.contextCreator = contextCreator;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execute(contextCreator.apply(execution));
    }

    protected abstract void execute(T ctx);
}
