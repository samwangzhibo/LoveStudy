package com.example.wangzhibo.lovestudy.view.recyclerview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangzhibo.lovestudy.R;
import com.example.wangzhibo.lovestudy.Utils;

public class TestRecyclerViewActivity extends AppCompatActivity {

  private RecyclerView mRecyclerView;

  public static Intent createIntent(Context context) {
    return new Intent(context, TestRecyclerViewActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_recycler_view);
    mRecyclerView = findViewById(R.id.recycler_view);
    mRecyclerView.setLayoutManager(new GridLayoutManager(TestRecyclerViewActivity.this, 3, LinearLayoutManager.VERTICAL, false));
    List<Integer> data = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      data.add(i);
    }
    mRecyclerView.setAdapter(new MyRecyclerAdapter(data));
//    mRecyclerView.addItemDecoration(new GridMarginItemDecoration(3, Utils.dip2px(getApplicationContext(), 50)));

    mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
      @Override
      public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int column = position % 3;
//        if (column == 0){
//          outRect.set(0, 0,
//              Utils.dip2px(getApplicationContext(), 25),
//              Utils.dip2px(getApplicationContext(), 50));
//        }
//        else if (column == 2){
//          outRect.set(Utils.dip2px(getApplicationContext(), 25), 0,
//              0,
//              Utils.dip2px(getApplicationContext(), 50));
//        }
//        else
          {
          outRect.set(Utils.dip2px(getApplicationContext(), 25), 0,
              Utils.dip2px(getApplicationContext(), 25),
              Utils.dip2px(getApplicationContext(), 50));
        }
      }
    });

  }

  public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Integer> mData;

    public MyRecyclerAdapter(List<Integer> data) {
      mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new MyViewHolder(LayoutInflater.from(TestRecyclerViewActivity.this)
          .inflate(R.layout.recyclerview_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.onBind(mData.get(position));
    }

    @Override
    public int getItemCount() {
      return mData == null ? 0 : mData.size();
    }
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public MyViewHolder(View itemView) {
      super(itemView);
      tv = itemView.findViewById(R.id.tv);
    }

    public void onBind(int i) {
      tv.setText(i + "");
    }

  }


}
