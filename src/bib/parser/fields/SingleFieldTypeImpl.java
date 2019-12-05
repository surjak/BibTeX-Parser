package bib.parser.fields;

import java.util.Objects;
import java.util.Set;

public class SingleFieldTypeImpl implements IFieldType{

    private FieldType type;

    public SingleFieldTypeImpl(FieldType type) {
        this.type = type;
    }

    @Override
    public boolean typeEquals(FieldType type) {
        return this.type==type;
    }

    @Override
    public boolean keyEquals(FieldType type) {
        return type==this.type;
    }

    @Override
    public boolean collides(Set<FieldType> types) {
        return false;
    }

    @Override
    public boolean containedIn(Set<FieldType> types) {
        return types.contains(type);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if(o.getClass() != SingleFieldTypeImpl.class && o.getClass() != MultipleFieldTypeImpl.class) return false;
        IFieldType that = (IFieldType) o;
        return that.keyEquals(this.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
