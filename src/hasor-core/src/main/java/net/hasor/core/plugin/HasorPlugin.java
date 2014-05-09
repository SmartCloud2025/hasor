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
package net.hasor.core.plugin;
import net.hasor.core.ApiBinder;
/**
 * 插件接口
 * @version : 2013-11-4
 * @author 赵永春(zyc@hasor.net)
 */
public interface HasorPlugin {
    /**处理插件的初始化*/
    public void loadPlugin(ApiBinder apiBinder) throws Throwable;
}