package com.codeabovelab.dm.common.format;

import com.codeabovelab.dm.common.metatype.MetatypeInfo;
import org.springframework.format.Formatter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


@FormatterInfo(metatypes = @MetatypeInfo(name = CommonMetatypeKeys.NAME_PHONE, type = Long.class))
public class PhoneFormatter implements Formatter<Long> {


    private static final long MAX_PHONE = 99999_99999_99999L;
 
    private static final boolean allowedchars[] = new boolean[128];
    static {
        allowedchars[' '] =
          allowedchars['-'] =
          allowedchars['('] =
          allowedchars[')'] =
          allowedchars['+'] =
            true;
    }
    private final NumberFormat numberFormat = new DecimalFormat();

    @Override
    public Long parse(String text, Locale locale) throws ParseException {
        int pos = 0;
        char c;
        long res = 0;
        while(pos < text.length()) {
            c = text.charAt(pos);
            pos++;
            if(c < 127 && allowedchars[c]) {
                continue;
            }
            if(Character.isDigit(c)) {
                res = res * 10L + (long)(c - '0');
            } else {
                throw new FormatterException("Unexpected char at " + (pos - 1) + " in: " + text);
            }
            checkBounds(res);
        }
        return res;
    }

    @Override
    public String print(Long object, Locale locale) {
        if(object == null) {
            throw new FormatterException("Value is null.");
        }
        long number = object;
        checkBounds(number);
        return numberFormat.format(number);
    }

    private void checkBounds(long number) {
        if(number < 0L || number > MAX_PHONE) {
            throw new FormatterException("Value is out of bounds (0:" + MAX_PHONE + ").");
        }
    }
}
