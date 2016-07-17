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

package dev.nick.hook.android.os.storage;

import android.content.Context;
import android.os.storage.StorageVolume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dev.nick.hook.ApiHook;
import dev.nick.hook.utils.ReflectionUtils;

@SuppressWarnings("TryWithIdenticalCatches")
public class StorageVolumeHook extends ApiHook<StorageVolume> {

    public StorageVolumeHook(StorageVolume base, Context context) {
        super(base, context);
    }

    public String getPath() {
        Method getPath = ReflectionUtils.findMethod(StorageVolume.class, "getPath");
        ReflectionUtils.makeAccessible(getPath);
        try {
            return (String) getPath.invoke(mBase);
        } catch (IllegalAccessException e) {
            mLogger.trace(e);
        } catch (InvocationTargetException e) {
            mLogger.trace(e);
        }
        return null;
    }

    public String getState() {
        Method getPath = ReflectionUtils.findMethod(StorageVolume.class, "getState");
        ReflectionUtils.makeAccessible(getPath);
        try {
            return (String) getPath.invoke(mBase);
        } catch (IllegalAccessException e) {
            mLogger.trace(e);
        } catch (InvocationTargetException e) {
            mLogger.trace(e);
        }
        return null;
    }

    public boolean isEmulated() {
        Method getPath = ReflectionUtils.findMethod(StorageVolume.class, "isEmulated");
        ReflectionUtils.makeAccessible(getPath);
        try {
            return (Boolean) getPath.invoke(mBase);
        } catch (IllegalAccessException e) {
            mLogger.trace(e);
        } catch (InvocationTargetException e) {
            mLogger.trace(e);
        }
        return Boolean.FALSE;
    }

    public boolean allowMessStorage() {
        Method getPath = ReflectionUtils.findMethod(StorageVolume.class, "allowMassStorage");
        ReflectionUtils.makeAccessible(getPath);
        try {
            return (Boolean) getPath.invoke(mBase);
        } catch (IllegalAccessException e) {
            mLogger.trace(e);
        } catch (InvocationTargetException e) {
            mLogger.trace(e);
        }
        return Boolean.FALSE;
    }

    public String getDescription() {
        Method getPath = ReflectionUtils.findMethod(StorageVolume.class, "getDescription", Context.class);
        ReflectionUtils.makeAccessible(getPath);
        try {
            return (String) getPath.invoke(mBase, mContext);
        } catch (IllegalAccessException e) {
            mLogger.trace(e);
        } catch (InvocationTargetException e) {
            mLogger.trace(e);
        }
        return null;
    }
}
