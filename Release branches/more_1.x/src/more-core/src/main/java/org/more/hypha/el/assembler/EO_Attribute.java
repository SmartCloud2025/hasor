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
package org.more.hypha.el.assembler;
import org.more.core.error.DefineException;
import org.more.hypha.ApplicationContext;
import org.more.hypha.ELObject;
import org.more.util.attribute.IAttribute;
import org.more.util.attribute.TransformToMap;
/**
 * EL�ж�ӦΪ{@link ApplicationContext context}�����Map��ʽ����֧�ָ�ֵ������
 * Date : 2011-4-11
 * @author ������ (zyc@byshell.org)
 */
public class EO_Attribute implements ELObject {
    private ApplicationContext context = null;
    public void init(ApplicationContext context, IAttribute flash) {
        this.context = context;
    };
    public boolean isReadOnly() {
        return true;
    };
    public void setValue(Object value) {
        throw new DefineException("��֧�ֵĸ�ֵ������");
    };
    public Object getValue() {
        return new ContextObject(this.context);//��Contextת��Ϊmap����
    };
};
class ContextObject extends TransformToMap {
    public ContextObject(ApplicationContext context) {
        super(context);
    }
    public Object get(Object key) {
        return super.get(key);
    }
    public Object put(String key, Object value) {
        return super.put(key, value);
    };
};