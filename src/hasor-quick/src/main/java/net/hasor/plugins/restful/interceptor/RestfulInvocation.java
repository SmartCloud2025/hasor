/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.plugins.restful.interceptor;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.hasor.core.AppContext;
import net.hasor.plugins.restful.support.RestfulInvoke;
import org.aopalliance.intercept.MethodInvocation;
/***
 * 
 * @version : 2013-9-26
 * @author 赵永春(zyc@hasor.net)
 */
public final class RestfulInvocation {
    private RestfulInvoke    restfulService;
    private MethodInvocation invocation;
    //
    public RestfulInvocation(RestfulInvoke restfulService, MethodInvocation invocation) {
        this.restfulService = restfulService;
        this.invocation = invocation;
    }
    /**获取{@link HttpServletRequest}对象*/
    public HttpServletRequest getRequest() {
        return this.restfulService.getRequest();
    };
    /**获取{@link HttpServletResponse}对象*/
    public HttpServletResponse getResponse() {
        return this.restfulService.getResponse();
    };
    /**获取{@link AppContext}对象*/
    public AppContext getAppContext() {
        return this.restfulService.getDefine().getAppContext();
    };
    /**获取ActionInvoke*/
    public RestfulInvoke getService() {
        return restfulService;
    };
    /**获取ActionInvoke*/
    public Method getControllerMethod() {
        return this.invocation.getMethod();
    };
    /**调用目标*/
    public Object proceed() throws Throwable {
        return invocation.proceed();
    };
    /**使用指定的 req res 调用*/
    public Object proceed(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return this.proceed();
    };
}