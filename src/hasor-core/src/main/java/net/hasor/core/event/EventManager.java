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
package net.hasor.core.event;
import net.hasor.core.EventCallBackHook;
import net.hasor.core.EventListener;
/**
 * �ṩ�¼���������ע���ͬ���¼��첽�¼��Ĵ���������
 * @version : 2013-5-6
 * @author ������ (zyc@hasor.net)
 */
public interface EventManager {
    /**pushPhaseEvent����ע���ʱ����������յ�һ���¼�֮��ᱻ�Զ�ɾ����*/
    public void pushListener(String eventType, EventListener eventListener);
    /**����һ�������¼����¼���������*/
    public void addListener(String eventType, EventListener eventListener);
    /**ɾ��ĳ����������ע�ᡣ*/
    public void removeListener(String eventType, EventListener eventListener);
    /**ͬ����ʽ�׳��¼�������������ʱ�Ѿ�ȫ����������¼��ַ���<p>
     * ע�⣺��ĳ��ʱ��������׳��쳣ʱ���ж��¼��ַ��׳��������쳣��*/
    public void fireSyncEvent(String eventType, Object... objects);
    /**ͬ����ʽ�׳��¼�������������ʱ�Ѿ�ȫ����������¼��ַ���<p>
     * ע�⣺��ĳ��ʱ��������׳��쳣ʱ�÷������̵��쳣�������ַ��¼������̵����쳣����һ������ķ�ʽ���֡�*/
    public void fireSyncEvent(String eventType, EventCallBackHook callBack, Object... objects);
    /**�첽��ʽ�׳��¼���fireAsyncEvent�����ĵ��ò��������ʱ��ʼִ���¼�������һ�����¼�������������<p>
     * ע�⣺��ĳ��ʱ��������׳��쳣ʱ�÷������̵��쳣�������ַ��¼������̵����쳣����һ������ķ�ʽ���֡�*/
    public void fireAsyncEvent(String eventType, Object... objects);
    /**�첽��ʽ�׳��¼���fireAsyncEvent�����ĵ��ò��������ʱ��ʼִ���¼�������һ�����¼�������������<p>
     * ע�⣺��ĳ��ʱ��������׳��쳣ʱ���ж��¼��ַ�����������ִ��Ȩ�����쳣�����ӿڡ�*/
    public void fireAsyncEvent(String eventType, EventCallBackHook callBack, Object... objects);
}