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

package app.dev.nick.api.test.android.media;

import java.util.ArrayList;
import java.util.List;

import app.dev.nick.api.dashboard.BaseTest;
import app.dev.nick.api.model.API;
import dev.nick.hook.android.media.MediaFile;

public class MediaFileTest extends BaseTest {

    @Override
    protected List<API> onStartTest() {

        List<API> APIs = new ArrayList<>();

        APIs.add(new API.Builder()
                .clz(MediaFile.class)
                .method("getFileTypeForMimeType")
                .result(String.valueOf(MediaFile.getFileTypeForMimeType("video/mp4")))
                .build());

        return APIs;
    }
}
