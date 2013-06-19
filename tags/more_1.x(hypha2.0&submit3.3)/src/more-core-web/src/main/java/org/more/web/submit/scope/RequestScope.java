/*
 * Copyright 2008-2009 the original author or authors.
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
package org.more.web.submit.scope;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import org.more.util.attribute.IAttribute;
import org.more.util.attribute.TransformToMap;
import org.more.web.submit.WebHelper;
/**
 * �����ṩHttpServletRequest��{@link IAttribute IAttribute�ӿ�}�Ĵ�����
 * @version 2009-12-28
 * @author ������ (zyc@byshell.org)
 */
public class RequestScope implements IAttribute<Object> {
    public static final String Name = "Request";
    //
    protected HttpServletRequest getHttpRequest() {
        return WebHelper.getHttpRequest();
    };
    public boolean contains(String name) {
        return this.getHttpRequest().getAttribute(name) != null;
    };
    public void setAttribute(String name, Object value) {
        this.getHttpRequest().setAttribute(name, value);
    };
    public Object getAttribute(String name) {
        return this.getHttpRequest().getAttribute(name);
    };
    public void removeAttribute(String name) {
        this.getHttpRequest().removeAttribute(name);
    };
    public String[] getAttributeNames() {
        Vector<String> v = new Vector<String>(0);
        Enumeration<?> attEnum = this.getHttpRequest().getAttributeNames();
        while (attEnum.hasMoreElements())
            v.add(attEnum.nextElement().toString());
        String[] ns = new String[v.size()];
        v.toArray(ns);
        return ns;
    };
    public void clearAttribute() {
        String[] ns = this.getAttributeNames();
        for (int i = 0; i < ns.length; i++)
            this.removeAttribute(ns[i]);
    };
    public Map<String, Object> toMap() {
        return new TransformToMap<Object>(this);
    };
};