package com.trkj.tsm.aspect.aop;

import net.bytebuddy.asm.Advice;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface OpjournalAnnotation {
    String message();
}
