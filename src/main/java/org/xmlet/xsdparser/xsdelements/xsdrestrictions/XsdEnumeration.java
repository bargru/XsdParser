package org.xmlet.xsdparser.xsdelements.xsdrestrictions;

import org.xmlet.xsdparser.core.XsdParserCore;
import org.xmlet.xsdparser.core.utils.ParseData;
import org.xmlet.xsdparser.xsdelements.XsdAbstractElement;
import org.xmlet.xsdparser.xsdelements.elementswrapper.ReferenceBase;
import org.xmlet.xsdparser.xsdelements.visitors.XsdAbstractElementVisitor;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.function.Function;

/**
 * Represents a value that a given XSD type is allowed to take. The value is defined as a {@link String}.
 */
public class XsdEnumeration extends XsdStringRestrictions {

    public static final String XSD_TAG = "xsd:enumeration";
    public static final String XS_TAG = "xs:enumeration";

    private XsdEnumeration(@NotNull XsdParserCore parser, @NotNull Map<String, String> elementFieldsMapParam, @NotNull Function<XsdAbstractElement, XsdAbstractElementVisitor> visitorFunction) {
        super(parser, elementFieldsMapParam, visitorFunction);
    }

    @Override
    public void accept(XsdAbstractElementVisitor xsdAbstractElementVisitor) {
        super.accept(xsdAbstractElementVisitor);
        xsdAbstractElementVisitor.visit(this);
    }

    public static ReferenceBase parse(@NotNull ParseData parseData){
        return ReferenceBase.createFromXsd(new XsdEnumeration(parseData.parserInstance, convertNodeMap(parseData.node.getAttributes()), parseData.visitorFunction));
    }
}