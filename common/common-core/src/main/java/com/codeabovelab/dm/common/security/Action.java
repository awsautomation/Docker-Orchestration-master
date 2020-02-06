

package com.codeabovelab.dm.common.security;

import org.springframework.security.acls.domain.AclFormattingUtils;
import org.springframework.security.acls.model.Permission;

/**
 */
public enum Action implements Permission {
    CREATE(2),
    READ(0),
    UPDATE(1),
    DELETE(3),
    //to DELETE we save order same BasePermission
    EXECUTE(4),
    /**
     * Permission to change internal structure or enclosing items
     */
    ALTER_INSIDE(5),
    ;

    private final int mask;
    private final char c;

    Action(int position) {
        this.mask = 1 << position;
        c = name().charAt(0);
    }

    /**
     * Letter that identity action
     * @return
     */
    public char getLetter() {
        return c;
    }

    @Override
    public int getMask() {
        return mask;
    }

    @Override
    public String getPattern() {
        return AclFormattingUtils.printBinary(mask, c);
    }

    public static Action fromLetter(char c) {
        for(Action action: values()) {
            if(action.getLetter() == c) {
                return action;
            }
        }
        return null;
    }
}
