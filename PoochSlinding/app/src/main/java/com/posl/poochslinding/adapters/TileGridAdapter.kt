package com.posl.poochslinding.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageButton

class TileGridAdapter(
    private val tileImages: ArrayList<ImageButton>,
    private val tileWidth: Int,
    private val tileHeight: Int
) : BaseAdapter() {

    override fun getCount(): Int {
        return tileImages.size
    }

    // Get the data item associated with the specified position in the data set.
    override fun getItem(position: Int): Any {
        return tileImages[position]
    }

    // Get the row ID associated with the specified position in the list.
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Get a View that displays the data at the specified position in the data set. You can either
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val tileView: ImageButton = if (convertView == null) {
            tileImages[position]
        } else {
            convertView as ImageButton
        }
        tileView.layoutParams = AbsListView.LayoutParams(tileWidth, tileHeight)
        return tileView
    }
}