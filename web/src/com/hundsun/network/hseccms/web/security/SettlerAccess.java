package com.hundsun.network.hseccms.web.security;

import com.hundsun.network.hseccms.security.PermissionEnum;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SettlerAccess
{
  public abstract PermissionEnum[] value();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.security.SettlerAccess
 * JD-Core Version:    0.6.0
 */