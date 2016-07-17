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

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dev.nick.hook.ApiHook;
import dev.nick.hook.utils.ReflectionUtils;

@SuppressWarnings("TryWithIdenticalCatches")
public class StorageManagerHook extends ApiHook<StorageManager> {

    public StorageManagerHook(StorageManager storageManager) {
        super(storageManager, null);
    }

    public StorageVolume[] getVolumeList() {
        StorageVolume[] storageVolumes = null;
        Method getList = ReflectionUtils.findMethod(StorageManager.class, "getVolumeList");
        ReflectionUtils.makeAccessible(getList);
        try {
            storageVolumes = (StorageVolume[]) getList.invoke(mBase);
        } catch (IllegalAccessException e) {
            mLogger.trace(e);
        } catch (InvocationTargetException e) {
            mLogger.trace(e);
        }
        return storageVolumes;
    }

}
