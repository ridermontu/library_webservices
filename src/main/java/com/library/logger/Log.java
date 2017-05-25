package com.library.logger;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;


@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface Log {

}
