/*
 * Copyright (c) 2016 Nick Guo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.dev.nick.hiddenapi;

public class Hook {

    private Class clz;
    private String method;
    private String result;
    private String[] params;

    private Hook(Class clz, String method, String[] params, String result) {
        this.clz = clz;
        this.method = method;
        this.params = params;
        this.result = result;
    }

    public Class getClz() {
        return clz;
    }

    public String getMethod() {
        return method;
    }

    public String[] getParams() {
        return params;
    }

    public String getResult() {
        return result;
    }

    public static class Builder {
        private Class clz;
        private String method;
        private String result;
        private String[] params;

        public Builder clz(Class clz) {
            this.clz = clz;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder param(String... params) {
            this.params = params;
            return this;
        }

        public Builder result(String result) {
            this.result = result;
            return this;
        }

        public Hook build() {
            return new Hook(clz, method, params, result);
        }
    }
}
