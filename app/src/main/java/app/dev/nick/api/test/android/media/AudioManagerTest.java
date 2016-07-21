package app.dev.nick.api.test.android.media;

import android.media.AudioManager;

import com.nick.scalpel.Scalpel;
import com.nick.scalpel.annotation.binding.AutoWired;

import java.util.ArrayList;
import java.util.List;

import app.dev.nick.api.dashboard.BaseTest;
import app.dev.nick.api.model.API;

public class AudioManagerTest extends BaseTest {

    @AutoWired
    AudioManager audioManager;

    @Override
    protected List<API> onStartTest() {

        Scalpel.getInstance().wire(this);

        List<API> apis = new ArrayList<>();

        API isBluetoothA2dpOn = new API.Builder()
                .clz(AudioManager.class)
                .method("isBluetoothA2dpOn")
                .result(String.valueOf(audioManager.isBluetoothA2dpOn()))
                .build();
        apis.add(isBluetoothA2dpOn);

        API playSoundEffect = new API.Builder()
                .clz(AudioManager.class)
                .result("Click")
                .action(new Runnable() {
                    @Override
                    public void run() {
                        audioManager.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                    }
                })
                .method("playSoundEffect")
                .build();
        apis.add(playSoundEffect);

        return apis;
    }
}
