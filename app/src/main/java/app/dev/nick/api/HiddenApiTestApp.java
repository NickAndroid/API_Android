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

package app.dev.nick.api;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nick.scalpel.Scalpel;
import com.nick.scalpel.ScalpelApplication;
import com.nick.scalpel.core.FieldWirer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import dev.nick.logger.LoggerManager;

import static com.nick.scalpel.core.utils.ReflectionUtils.getField;
import static com.nick.scalpel.core.utils.ReflectionUtils.makeAccessible;
import static com.nick.scalpel.core.utils.ReflectionUtils.setField;

public class HiddenApiTestApp extends ScalpelApplication {
    @Override
    protected void onConfigScalpel(Scalpel scalpel) {
        super.onConfigScalpel(scalpel);
        scalpel.addFieldWirer(new LoggerWirer());
    }

    class LoggerWirer implements FieldWirer {

        @Override
        public Class<? extends Annotation> annotationClass() {
            return GetLogger.class;
        }

        @Override
        public void wire(Activity activity, Field field) {
            wire(activity.getApplicationContext(), activity, field);
        }

        @Override
        public void wire(Fragment fragment, Field field) {
            wire(fragment.getActivity().getApplicationContext(), fragment, field);
        }

        @Override
        public void wire(Service service, Field field) {
            wire(service.getApplicationContext(), service, field);
        }

        @Override
        public void wire(Context context, Object object, Field field) {
            makeAccessible(field);
            Object fieldObject = getField(field, object);
            if (fieldObject != null) return;
            GetLogger getLogger = field.getAnnotation(GetLogger.class);
            Class clz = getLogger.clz();
            if (clz == GetLogger.Null.class) clz = object.getClass();
            setField(field, object, LoggerManager.getLogger(clz));
        }

        @Override
        public void wire(View root, Object object, Field field) {
            wire(root.getContext(), object, field);
        }
    }
}
