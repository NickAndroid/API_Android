package app.dev.nick.api.dashboard;

import android.content.Intent;
import android.media.AudioManager;
import android.support.annotation.NonNull;

import java.util.List;

import app.dev.nick.api.R;
import app.dev.nick.api.dashboard.tile.HeadlessTile;
import app.dev.nick.api.test.android.media.AudioManagerTest;
import app.dev.nick.api.test.android.media.MediaFileTest;
import app.dev.nick.api.test.android.os.storage.StorageManagerTest;
import dev.nick.tiles.tile.Category;
import dev.nick.tiles.tile.DashboardFragment;
import dev.nick.tiles.tile.EmptyActionTileView;
import dev.nick.tiles.tile.QuickTile;
import dev.nick.tiles.tile.TileListener;

public class CategoryFragment extends DashboardFragment {

    @Override
    protected void onCreateDashCategories(List<Category> categories) {
        super.onCreateDashCategories(categories);

        /* Audio */
        Category audio = new Category();
        audio.title = "Audio";

        // AudioManager
        HeadlessTile audioManagerTile = new HeadlessTile(getActivity(), new TileListener() {
            @Override
            public void onTileClick(@NonNull QuickTile tile) {
                startActivity(new Intent(getActivity(), AudioManagerTest.class));
            }
        });
        audioManagerTile.iconRes = R.drawable.ic_mic_black_24dp;
        audioManagerTile.title = "AudioManager";
        audio.addTile(audioManagerTile);

        // AudioSystem
        HeadlessTile audioSystem = new HeadlessTile(getActivity(), new TileListener() {
            @Override
            public void onTileClick(@NonNull QuickTile tile) {

            }
        });
        audioSystem.iconRes = R.drawable.ic_volume_down_black_24dp;
        audioSystem.title = "AudioSystem";
        audio.addTile(audioSystem);

        /* Media */
        Category media =new Category();
        media.title = "Media";

        HeadlessTile mediaFile = new HeadlessTile(getActivity(), new TileListener() {
            @Override
            public void onTileClick(@NonNull QuickTile tile) {
                startActivity(new Intent(getActivity(), MediaFileTest.class));
            }
        });
        mediaFile.iconRes = R.drawable.ic_image_black_24dp;
        mediaFile.title = "MediaFile";
        media.addTile(mediaFile);

         /* Storage */
        Category storage =new Category();
        storage.title = "Storage";

        HeadlessTile storageManager = new HeadlessTile(getActivity(), new TileListener() {
            @Override
            public void onTileClick(@NonNull QuickTile tile) {
                startActivity(new Intent(getActivity(), StorageManagerTest.class));
            }
        });
        storageManager.iconRes = R.drawable.ic_save_black_24dp;
        storageManager.title = "StorageManager";
        storage.addTile(storageManager);

        categories.add(audio);
        categories.add(media);
        categories.add(storage);
    }
}
