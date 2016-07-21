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

package app.dev.nick.api.android.os.storage;

import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.annotation.Nullable;

import com.nick.scalpel.Scalpel;
import com.nick.scalpel.annotation.binding.AutoWired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.dev.nick.api.BaseTest;
import app.dev.nick.api.Hook;
import dev.nick.hook.android.os.storage.StorageManagerHook;
import dev.nick.hook.android.os.storage.StorageVolumeHook;

public class StorageManagerTest extends BaseTest {

    @AutoWired
    StorageManager storageManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<Hook> onStartHook() {

        Scalpel.getInstance().wire(this);

        List<Hook> hooks = new ArrayList<>();

        StorageManagerHook storageManagerHook = new StorageManagerHook(storageManager);
        hooks.add(new Hook
                .Builder()
                .clz(StorageManager.class)
                .method("getVolumeList")
                .result(Arrays.toString(storageManagerHook.getVolumeList()))
                .build());

        for (StorageVolume v : storageManagerHook.getVolumeList()) {
            StorageVolumeHook volumeHook = new StorageVolumeHook(v, getApplicationContext());
            hooks.add(new Hook
                    .Builder()
                    .clz(StorageVolume.class)
                    .method("getDescription")
                    .result(volumeHook.getDescription())
                    .build());
            hooks.add(new Hook
                    .Builder()
                    .clz(StorageVolume.class)
                    .method("getPath")
                    .result(volumeHook.getPath())
                    .build());
            hooks.add(new Hook
                    .Builder()
                    .clz(StorageVolume.class)
                    .method("getState")
                    .result(volumeHook.getState())
                    .build());
            hooks.add(new Hook
                    .Builder()
                    .clz(StorageVolume.class)
                    .method("allowMessStorage")
                    .result(String.valueOf(volumeHook.allowMessStorage()))
                    .build());
            hooks.add(new Hook
                    .Builder()
                    .clz(StorageVolume.class)
                    .method("isEmulated")
                    .result(String.valueOf(volumeHook.isEmulated()))
                    .build());
        }

        return hooks;
    }
}
