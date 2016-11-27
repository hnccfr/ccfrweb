package com.hundsun.eclp.security;

import com.hundsun.eclp.enums.PermissionEnum;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminAccess
{
  public abstract PermissionEnum[] value();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.security.AdminAccess
 * JD-Core Version:    0.6.0
 */