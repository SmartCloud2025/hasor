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
package org.more.core.json.check;
import java.util.Collection;
import org.more.core.json.JsonCheck;
/**
 * �������Լ����ϵļ��
 * @version : 2011-9-28
 * @author ������ (zyc@byshell.org)
 */
public class ArrayCheck implements JsonCheck {
    public boolean checkToString(Object source) {
        if (source == null)
            return false;
        Class<?> sourceType = source.getClass();
        if (sourceType.isArray() == true || source instanceof Collection)
            return true;
        else
            return false;
    }
    public boolean checkToObject(String source) {
        if (source.charAt(0) == '[')
            return true;
        return false;
    }
}