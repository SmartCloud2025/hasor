/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
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
package net.hasor.core.context.factorys.hasor;
import net.hasor.core.context.factorys.DefaultRegisterInfoAdapter;
import org.more.classcode.ClassEngine;
/**
 * 
 * @version : 2014年7月4日
 * @author 赵永春(zyc@hasor.net)
 */
public class HasorRegisterInfoAdapter<T> extends DefaultRegisterInfoAdapter<T> {
    //
    public HasorRegisterInfoAdapter() {
        super();
    }
    public HasorRegisterInfoAdapter(Class<T> bindingType) {
        super(bindingType);
    }
    //
    private ClassEngine engine = null;
    /**获取用于创建Bean的 Engine。*/
    public ClassEngine buildEngine() {
        if (this.engine == null) {
            Class<?> superType = this.getSourceType();
            superType = (superType == null) ? this.getBindType() : superType;
            this.engine = new ClassEngine(superType);
        }
        return this.engine;
    }
}