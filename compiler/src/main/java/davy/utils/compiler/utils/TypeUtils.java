package davy.utils.compiler.utils;

import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import static davy.utils.compiler.utils.Consts.PARCELABLE;

public class TypeUtils {

    private Types types;
    private Elements elements;
    private TypeMirror parcelableType;

    public TypeUtils(Types types, Elements elements) {
        this.types = types;
        this.elements = elements;

        parcelableType = this.elements.getTypeElement(PARCELABLE).asType();
    }
}
