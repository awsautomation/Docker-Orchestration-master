
package com.codeabovelab.dm.cluman.objprinter;

import com.codeabovelab.dm.common.utils.pojo.PojoClass;
import com.codeabovelab.dm.common.utils.pojo.Property;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class implement {@link CharSequence} for workaround bug in converter: https://jira.spring.io/browse/SPR-14655
 */
class LazyObjectPrinter implements CharSequence {

    private final Object obj;
    private final ObjectPrinterFactory printerFactory;
    private String res;

    LazyObjectPrinter(ObjectPrinterFactory printerFactory, Object obj) {
        this.printerFactory = printerFactory;
        this.obj = obj;
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    @Override
    public String toString() {
        if(res == null) {
            try {
                print();
            } catch (Exception e) {
                res = obj.toString();
            }
        }
        return res;
    }

    private void print() {
        StringBuilder sb = new StringBuilder();
        PojoClass pojoClass = new PojoClass(obj.getClass());
        List<Property> props = new ArrayList<>(pojoClass.getProperties().values());
        props.sort(Comparator.comparing(Property::getName));
        for(Property prop: props) {
            if(prop.getDeclaringClass() == Object.class) {
                continue;
            }
            ObjPrint opa = prop.getAnnotation(ObjPrint.class);
            if(opa != null && opa.ignore()) {
                continue;
            }
            if(sb.length() > 0) {
                sb.append("\n");
            }
            String name = prop.getName();
            sb.append("\t").append(name).append(" = \t");
            Object val = prop.get(obj);
            printerFactory.print(val, sb);
        }
        res = sb.toString();
    }
}
