package app.dev.nick.api.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import app.dev.nick.api.R;

public class NavigatorActivity extends TransactionSafeActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigator_content);
        placeFragment(R.id.container, new CategoryFragment(), null, false);
    }
}
