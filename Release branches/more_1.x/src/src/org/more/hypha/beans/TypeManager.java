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
package org.more.hypha.beans;
import java.util.ArrayList;
import org.more.hypha.beans.define.Simple_ValueMetaData;
import org.more.hypha.beans.define.Simple_ValueMetaData.PropertyType;
import org.more.util.attribute.AttBase;
/**
 * 类型解析器，将字符串值解析为指定的类型。
 * @version 2010-10-10
 * @author 赵永春 (zyc@byshell.org)
 */
public class TypeManager {
    private ArrayList<TypeParser> parserList = new ArrayList<TypeParser>(); //属性快速解析器定义
    /**注册一个快速属性值解析器。*/
    public synchronized void regeditTypeParser(TypeParser parser) {
        if (parser == null)
            throw new NullPointerException("参数不能为空。");
        if (this.parserList.contains(parser) == false)
            this.parserList.add(parser);
    }
    /**取消一个快速属性值解析器的注册。*/
    public synchronized void unRegeditTypeParser(TypeParser parser) {
        if (parser == null)
            throw new NullPointerException("参数不能为空。");
        if (this.parserList.contains(parser) == true)
            this.parserList.remove(parser);
    }
    /**将属性值解析为某一特定类型的值，将value表述的值转换成指定的元信息描述。如果toType参数为空则使用String.class代替。*/
    public synchronized ValueMetaData parserType(String value, AttBase att, AbstractPropertyDefine property) {
        ValueMetaData valueMETADATA = null;
        for (TypeParser tp : parserList) {
            valueMETADATA = tp.parser(value, att, property);
            if (valueMETADATA != null)
                return valueMETADATA;
        }
        /**使用默认值null*/
        Simple_ValueMetaData simple = new Simple_ValueMetaData();
        simple.setValueMetaType(PropertyType.Null);
        simple.setValue(null);
        return simple;
    }
}
