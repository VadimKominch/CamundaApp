package org.example.application.delegate.base;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class AbstractProcessContext {
    private final DelegateExecution scope;

    public AbstractProcessContext(DelegateExecution scope) {
        this.scope = scope;
    }

    protected <T> void setVariable(String name , T value) {
        scope.setVariable(name, value);
    }

    protected <V> V getVariable(String name) {
      return (V)scope.getVariable(name);
    }

    protected <V> V getVariableAssertNotNull(String name) {
        V obj = getVariable(name);
        if(obj == null)
            throw new IllegalStateException("Variable $name is null");
        else
            return obj;
    }
}
