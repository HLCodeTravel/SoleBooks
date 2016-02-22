package com.blanke.solebook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.blanke.solebook.bean.BookColumn;
import com.blanke.solebook.core.columnitem.ColumnItemFragment;
import com.blanke.solebook.core.columnitem.ColumnItemFragment_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blanke on 16-2-22.
 */
public class ColumnFragmentAdapter extends FragmentPagerAdapter {
    List<BookColumn> bookColumns;

    public ColumnFragmentAdapter(FragmentManager fm) {
        super(fm);
        bookColumns = new ArrayList<>();
    }

    public void addTab(BookColumn bookColumn) {
        bookColumns.add(bookColumn);
    }

    @Override
    public Fragment getItem(int position) {
        return ColumnItemFragment_.builder()
                .arg(ColumnItemFragment.ARG_BOOKCOLUMN, bookColumns.get(position))
                .build();
    }

    @Override
    public int getCount() {
        return bookColumns != null ? bookColumns.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return bookColumns.get(position).getName();
    }
}