package bib.parser.fields;

import java.util.Set;

public interface IFieldType {
    public boolean typeEquals(FieldType type);

    public boolean keyEquals(FieldType type);


    public boolean collides(Set<FieldType> types) throws Exception;


    public boolean containedIn(Set<FieldType> types);
}
