package bib.parser.fields;

import java.util.Set;

public interface IFieldType {
    public abstract boolean typeEquals(FieldType type);

    public abstract boolean keyEquals(FieldType type);


    public abstract boolean collides(Set<FieldType> types) throws Exception;


    public abstract boolean containedIn(Set<FieldType> types);
}
