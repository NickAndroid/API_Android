package app.dev.nick.api.test.android.media;

import android.media.AudioManager;
import android.os.Build;

import com.nick.scalpel.Scalpel;
import com.nick.scalpel.annotation.binding.AutoWired;

import java.util.ArrayList;
import java.util.List;

import app.dev.nick.api.dashboard.BaseTest;
import app.dev.nick.api.model.API;
import app.dev.nick.api.model.Result;

public class AudioManagerTest extends BaseTest {

    @AutoWired
    AudioManager audioManager;

    @Override
    protected List<API> onStartTest() {

        Scalpel.getInstance().wire(this);

        List<API> apis = new ArrayList<>();

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("isBluetoothA2dpOn")
                .result(String.valueOf(audioManager.isBluetoothA2dpOn()))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("isBluetoothScoAvailableOffCall")
                .result(String.valueOf(audioManager.isBluetoothScoAvailableOffCall()))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("isBluetoothScoOn")
                .result(String.valueOf(audioManager.isBluetoothScoOn()))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("isMicrophoneMute")
                .result(String.valueOf(audioManager.isMicrophoneMute()))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("isMusicActive")
                .result(String.valueOf(audioManager.isMusicActive()))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("isSpeakerphoneOn")
                .result(String.valueOf(audioManager.isSpeakerphoneOn()))
                .build());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            apis.add(new API.Builder()
                    .clz(AudioManager.class)
                    .method("isStreamMute:" + "STREAM_ALARM")
                    .result(String.valueOf(audioManager.isStreamMute(AudioManager.STREAM_ALARM)))
                    .build());
            apis.add(new API.Builder()
                    .clz(AudioManager.class)
                    .method("isStreamMute:" + "STREAM_DTMF")
                    .result(String.valueOf(audioManager.isStreamMute(AudioManager.STREAM_DTMF)))
                    .build());
            apis.add(new API.Builder()
                    .clz(AudioManager.class)
                    .method("isStreamMute:" + "STREAM_MUSIC")
                    .result(String.valueOf(audioManager.isStreamMute(AudioManager.STREAM_MUSIC)))
                    .build());
            apis.add(new API.Builder()
                    .clz(AudioManager.class)
                    .method("isStreamMute:" + "STREAM_NOTIFICATION")
                    .result(String.valueOf(audioManager.isStreamMute(AudioManager.STREAM_NOTIFICATION)))
                    .build());
            apis.add(new API.Builder()
                    .clz(AudioManager.class)
                    .method("isStreamMute:" + "STREAM_RING")
                    .result(String.valueOf(audioManager.isStreamMute(AudioManager.STREAM_RING)))
                    .build());
            apis.add(new API.Builder()
                    .clz(AudioManager.class)
                    .method("isStreamMute:" + "STREAM_SYSTEM")
                    .result(String.valueOf(audioManager.isStreamMute(AudioManager.STREAM_SYSTEM)))
                    .build());
            apis.add(new API.Builder()
                    .clz(AudioManager.class)
                    .method("isStreamMute:" + "STREAM_VOICE_CALL")
                    .result(String.valueOf(audioManager.isStreamMute(AudioManager.STREAM_VOICE_CALL)))
                    .build());
        }

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getStreamMaxVolume:" + "STREAM_ALARM")
                .result(String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM)))
                .build());
        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getStreamMaxVolume:" + "STREAM_ALARM")
                .result(String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_DTMF)))
                .build());
        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getStreamMaxVolume:" + "STREAM_ALARM")
                .result(String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)))
                .build());
        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getStreamMaxVolume:" + "STREAM_ALARM")
                .result(String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION)))
                .build());
        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getStreamMaxVolume:" + "STREAM_ALARM")
                .result(String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING)))
                .build());
        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getStreamMaxVolume:" + "STREAM_ALARM")
                .result(String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM)))
                .build());
        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getStreamMaxVolume:" + "STREAM_ALARM")
                .result(String.valueOf(audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL)))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("isVolumeFixed")
                .result(String.valueOf(audioManager.isVolumeFixed()))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getMode")
                .result(String.valueOf(audioManager.getMode()))
                .build());

        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .method("getRingerMode")
                .result(String.valueOf(audioManager.getRingerMode()))
                .build());


        apis.add(new API.Builder()
                .clz(AudioManager.class)
                .action(new API.Action() {
                    @Override
                    public void run(API api) {
                        audioManager.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                        api.setResult(Result.PASS.name());
                    }
                })
                .method("playSoundEffect")
                .build());

        return apis;
    }
}
