package CTCI1612XMLEncoding;

import java.util.List;

/** Um elemento tem atributos e, como filhos, OU outros elementos OU um valor (texto). */
public record Element(String tag, List<Attribute> attributes, List<Element> children, String value) {
    public static Element withChildren(String tag, List<Attribute> attributes, List<Element> children) {
        return new Element(tag, attributes, children, null);
    }

    public static Element withValue(String tag, List<Attribute> attributes, String value) {
        return new Element(tag, attributes, List.of(), value);
    }
}
