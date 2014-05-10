package com.peejay.config.dialect;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

public class PeejayDialect extends AbstractDialect {

    @Override
    public String getPrefix() {
        return "peejay";
    }

    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new HeaderProcessor());
        return processors;
    }
}
