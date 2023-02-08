package org.example.application.delegate.base;

public abstract class MyProcessAwareDelegate extends ProcessAwareDelegate<ProcessContext>{

    public MyProcessAwareDelegate() {
        super(ProcessContext::new);
    }
}
