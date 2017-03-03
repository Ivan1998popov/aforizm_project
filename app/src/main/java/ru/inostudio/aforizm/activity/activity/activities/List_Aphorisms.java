package ru.inostudio.aforizm.activity.activity.activities;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import ru.inostudio.aforizm.R;
import ru.inostudio.aforizm.activity.activity.adapter.OnClickListener;
import ru.inostudio.aforizm.activity.activity.adapter.RecyclerAdapter;


public class List_Aphorisms extends BasicActivity  {
    RecyclerView aforizms;
    private RecyclerView mRecyclerView;
    public RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String EXTRA_PARAM_AFORIZM_GROUP = "aforizm_group";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        aforizms = (RecyclerView) findViewById(R.id.my_recycler_view);
        rootLayout = (ViewGroup) findViewById(R.id.my_list);
        String aforizmGroup = getIntent().getStringExtra(EXTRA_PARAM_AFORIZM_GROUP);

        int aforizmResId = getResources().getIdentifier(aforizmGroup, "array", getPackageName());
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(aforizms.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        String[] aforizm = getResources().getStringArray(aforizmResId);
        ColorDrawable divcolor = new ColorDrawable(Color.BLACK);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        Adapter = new RecyclerAdapter(aforizm);
        mRecyclerView.setAdapter(Adapter);

    }
}
