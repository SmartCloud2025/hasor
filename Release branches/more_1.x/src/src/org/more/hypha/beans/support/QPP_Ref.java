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
package org.more.hypha.beans.support;
import org.more.hypha.beans.ValueMetaData;
import org.more.hypha.beans.define.QuickProperty_ValueMetaData;
import org.more.hypha.beans.define.Relation_ValueMetaData;
/**
 * ��������Bean����ֵ��������
 * @version 2010-9-23
 * @author ������ (zyc@byshell.org)
 */
public class QPP_Ref implements QuickPropertyParser {
    /**��ͼ������Ϊ{@link Relation_ValueMetaData}�������ʧ�ܷ���null��*/
    public ValueMetaData parser(QuickParserEvent event) {
        //1.����Ƿ���Խ���
        QuickProperty_ValueMetaData meta = event.getOldMetaData();
        if (meta.getRefBean() == null)
            return null;
        //2.���н���
        Relation_ValueMetaData newMETA = new Relation_ValueMetaData();
        newMETA.setRefBean(meta.getRefBean());
        newMETA.setRefBean(meta.getRefScope());
        return newMETA;
    }
}