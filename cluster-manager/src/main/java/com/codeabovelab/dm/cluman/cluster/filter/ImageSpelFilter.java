
package com.codeabovelab.dm.cluman.cluster.filter;

import com.codeabovelab.dm.cluman.cluster.registry.ImageFilterContext;
import com.codeabovelab.dm.cluman.model.ImageDescriptor;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * SpEL string which applied to images. It evaluated over object with 'tag(name)' and 'label(key, val)' functions,
 * also it has 'r(regexp)' function which can combined with other, like: <code>'tag(r(".*_dev")) or label("dev", "true")'</code>.
 */
public class ImageSpelFilter extends SpelFilter<ImageFilterContext> {

    public static final String PROTO = "spel-image";
    private final String expr;

    public ImageSpelFilter(String expr) {
        super(expr);
        this.expr = PROTO + ":" + expr;
    }

    @Override
    public String getExpression() {
        return expr;
    }

    @Override
    protected boolean innerTest(ImageFilterContext ifc) {
        Object value = getExpr().getValue(new ImageRootObject(ifc));
        return value != null && (value instanceof Boolean? (Boolean)value : true);
    }

    static class ImageRootObject {

        private final ImageFilterContext ifc;

        public ImageRootObject(ImageFilterContext ifc) {
            this.ifc = ifc;
        }

        public boolean tag(Object arg) {
            final String tag = ifc.getTag();
            return applyPattern(arg, tag);
        }

        private boolean applyPattern(Object pattern, String value) {
            if(pattern instanceof String) {
                return value.equals(pattern);
            } else if (pattern instanceof Pattern) {
                return ((Pattern)pattern).matcher(value).matches();
            }
            return Objects.equals(pattern, value);
        }

        public boolean label(String key, Object valuePattern) {
            ImageDescriptor image = ifc.getImage();
            Map<String, String> labels = image.getContainerConfig().getLabels();
            String value = labels.get(key);
            return applyPattern(valuePattern, value);
        }

        public Pattern r(String regex) {
            return Pattern.compile(regex);
        }
    }

}
