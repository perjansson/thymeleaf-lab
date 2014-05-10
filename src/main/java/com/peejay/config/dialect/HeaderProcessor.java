package com.peejay.config.dialect;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;

public class HeaderProcessor extends AbstractTextChildModifierAttrProcessor {

    protected HeaderProcessor() {
        super("header");
    }

    @Override
    protected String getText(Arguments arguments, Element element, String attributeName) {
        return element.getAttributeValue(attributeName);
    }

    @Override
    public int getPrecedence() {
        return 100000;
    }

}
