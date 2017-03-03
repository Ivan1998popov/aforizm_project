package ru.inostudio.aforizm.activity.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import java.util.List;

import ru.inostudio.aforizm.R;

/**
 * Created by Kirill on 16.05.2016.
 */
public class ColorAdapter extends ArrayAdapter {
    private Context context;
    private int resourseId;
    private List<Integer> colorIdList;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public ColorAdapter(Context context,
                        int resourseId,
                        List<Integer> colorIdList) {
        super(context, resourseId, colorIdList);
        this.context = context;
        this.resourseId = resourseId;
        this.colorIdList = colorIdList;
    }

    @Override
    public View getView(final int pisition, View contentView, ViewGroup viewGroup) {
        ColorViewHolder colorViewHolder;
        View row = contentView;
        if (row == null) {
            LayoutInflater inflanter = LayoutInflater.from(context);
            row = inflanter.inflate(resourseId, viewGroup, false);

            colorViewHolder = new ColorViewHolder();
            colorViewHolder.colorView = row.findViewById(R.id.color_item);
            row.setTag(colorViewHolder);
        } else {
            colorViewHolder = (ColorViewHolder) row.getTag();

        }
        final int color = colorIdList.get(pisition);
        colorViewHolder.colorView.setBackgroundColor(color);
        colorViewHolder.colorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(pisition);
                }
            }

        });
        return row;

    }

    public class ColorViewHolder {
        View colorView;
    }
}
