/*
 * Copyright 2008-2009 the original ������(zyc@hasor.net).
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
package net.hasor.core.binder;
import java.lang.reflect.Constructor;
import javax.inject.Provider;
import net.hasor.core.RegisterInfo;
import net.hasor.core.Scope;
/**
 * 
 * @version : 2014-3-13
 * @author ������(zyc@hasor.net)
 */
public interface TypeRegister<T> extends RegisterInfo<T> {
    /**��ȡע�������*/
    public Class<T> getType();
    /**Ϊ���Ͱ�һ��ʵ�֣�����ȡ����ʵ��ʱ��ʵ��ȡ����ʵ�ֶ���*/
    public void toImpl(Class<? extends T> implementation);
    /**Ϊ���Ͱ�һ��ʵ�ֶ���*/
    public void toInstance(T instance);
    /**Ϊ���Ͱ�һ��Provider��*/
    public void toProvider(Provider<T> provider);
    /**Ϊ���Ͱ�һ����ʼ���췽����*/
    public void toConstructor(Constructor<? extends T> constructor);
    /**Ϊ���Ͱ�һ�����ơ�*/
    public void setName(String name);
    /**�����ͷ���Ϊ����ģʽ��*/
    public void setSingleton();
    /**�����ͷ�����һ���̶��������ռ��ڡ�*/
    public void setScope(Scope scope);
}