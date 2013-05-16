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
package org.platform.freemarker;
import java.io.IOException;
import java.io.Writer;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * Freemarker模板功能提供类。
 * @version : 2013-5-6
 * @author 赵永春 (zyc@byshell.org)
 */
public interface FreemarkerManager {
    /**获取模板。*/
    public Template getTemplate(String templateName) throws TemplateException, IOException;
    /**获取模板。*/
    public void getTemplate(String templateName, Writer writer) throws TemplateException, IOException;
    /**将字符串的内容作为模板执行。*/
    public String processString(String ftlBody) throws TemplateException, IOException;
    /**将字符串的内容作为模板执行。*/
    public void processString(String ftlBody, Writer writer) throws TemplateException, IOException;
}