package app.dev.nick.api.dashboard.tile;

import android.content.Context;
import android.support.annotation.NonNull;

import app.dev.nick.api.R;
import dev.nick.tiles.tile.QuickTile;
import dev.nick.tiles.tile.QuickTileView;
import dev.nick.tiles.tile.TileListener;

public class HeadlessTile extends QuickTile {
    public HeadlessTile(@NonNull Context context, TileListener listener) {
        super(context, listener);
        this.tileView = new QuickTileView(context, this);
    }
}
