package com.xiesu.commonbase.except;

/**
 * 可向调用者公开的异常，对于不可向外部暴露的异常（例如：IOEXception_RunTimeException），则应该被拦截，打印日常信息，但对外部隐藏异常内容，显示系统内部错误即可。
 * 具体拦截
 */
public class ExposedException extends RuntimeException {
   public ExposedException(){};
}
