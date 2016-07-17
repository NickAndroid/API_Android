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

package app.dev.nick.hiddenapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nick.scalpel.Scalpel;
import com.nick.scalpel.annotation.binding.FindView;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class BaseTest extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_test_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showHookResult();
            }
        });
    }

    protected List<Hook> onStartHook() {
        return new ArrayList<>(0);
    }

    protected void showHookResult() {
        setTitle(getClass().getSimpleName());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new Adapter(onStartHook()));
    }

    public void scrollToTop() {
        mRecyclerView.smoothScrollToPosition(0);
    }

    private class Adapter extends RecyclerView.Adapter<TwoLinesViewHolder> {

        private final List<Hook> data;

        public Adapter(List<Hook> data) {
            this.data = data;
        }

        @Override
        public TwoLinesViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            final View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.simple_card_item, parent, false);
            return new TwoLinesViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final TwoLinesViewHolder holder, final int position) {
            final Hook item = data.get(position);
            holder.title.setText(item.getClz().getSimpleName() + "." + item.getMethod());
            holder.description.setText(item.getResult());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    static class TwoLinesViewHolder extends RecyclerView.ViewHolder {

        @FindView(id = android.R.id.title)
        TextView title;
        @FindView(id = android.R.id.text1)
        TextView description;

        public TwoLinesViewHolder(final View itemView) {
            super(itemView);
            Scalpel.getInstance().wire(itemView, this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
