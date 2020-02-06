

package com.codeabovelab.dm.common.format;

import com.codeabovelab.dm.common.utils.Key;
import org.springframework.format.Formatter;

import java.util.Set;


public interface SelfDescribedFormatter<T> extends Formatter<T> {
   
    Set<Key<?>> getHandledMetatypes();
}
