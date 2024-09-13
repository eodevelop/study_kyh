package hello.advanced.trace.template;

import hello.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate {
    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }


}
