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
package org.more.core.classcode;
/**
 * 类名生成策略，该接口在ClassEngine.builderClass期间调用。用于决定新类的类名和所属包。
 * @version 2010-9-3
 * @author 赵永春 (zyc@byshell.org)
 */
public interface ClassNameStrategy extends BaseStrategy {
    /**获取新类的类名。*/
    public String generateName(Class<?> superClass);
};