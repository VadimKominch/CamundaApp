package org.example.application.delegate;

import org.example.application.delegate.base.MyProcessAwareDelegate;
import org.example.application.delegate.base.ProcessContext;
import org.springframework.stereotype.Component;

@Component
public class ExampleDelegate extends MyProcessAwareDelegate {
    public ExampleDelegate() {
        super();
    }

    @Override
    public void execute(ProcessContext ctx) {
        System.out.println(ctx.getValue());

    }
}
