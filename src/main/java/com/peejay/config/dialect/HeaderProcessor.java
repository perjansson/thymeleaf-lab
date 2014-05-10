package com.peejay.config.dialect;

import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

public class HeaderProcessor extends AbstractTextChildModifierAttrProcessor {

    protected HeaderProcessor() {
        super("header");
    }

    @Override
    protected String getText(Arguments arguments, Element element, String attributeName) {
        final Configuration configuration = arguments.getConfiguration();
        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        final String attributeValue = element.getAttributeValue(attributeName);
        final IStandardExpression expression = parser.parseExpression(configuration, arguments, attributeValue);
        return (String) expression.execute(configuration, arguments);
    }

    @Override
    public int getPrecedence() {
        return 100000;
    }

}
