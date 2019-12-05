package bib.parser.fields;

import java.util.Objects;
import java.util.Set;

public class MultipleFieldTypeImpl implements IFieldType {
private FieldType fieldType1;
private FieldType fieldType2;

    public MultipleFieldTypeImpl(FieldType fieldType1, FieldType fieldType2) {
        this.fieldType1 = fieldType1;
        this.fieldType2 = fieldType2;
    }

    @Override
    public boolean typeEquals(FieldType type) {

            return type == this.fieldType1 || type == this.fieldType2;
    }

    @Override
    public boolean keyEquals(FieldType type) {
        return type == this.fieldType1;
    }

    @Override
    public boolean collides(Set<FieldType> types) throws Exception {
        if(types.contains(fieldType1) && types.contains(fieldType2))
            throw new Exception("dwa typy zostaly podane");
        return false;

    }

    @Override
    public boolean containedIn(Set<FieldType> types) {

            return types.contains(fieldType1) || types.contains(fieldType2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if(o.getClass() != SingleFieldTypeImpl.class && o.getClass() != MultipleFieldTypeImpl.class) return false;
        IFieldType that = (IFieldType) o;
        return that.keyEquals(this.fieldType1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldType1, fieldType2);
    }
}
