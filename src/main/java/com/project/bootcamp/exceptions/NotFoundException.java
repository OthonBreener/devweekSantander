package com.project.bootcamp.exceptions;

import com.project.bootcamp.util.MessageUtil;
import sun.misc.MessageUtils;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(MessageUtil.NO_RECORDS_FOUND);
    }
}
