package org.example.application.delegate.base;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class ProcessContext extends AbstractProcessContext {

    public ProcessContext(DelegateExecution scope) {
        super(scope);
    }

    public double getValue() {
        return getVariableAssertNotNull("value");
    }
}
