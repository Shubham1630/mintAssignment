package com.srp.assignment.adapter

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.srp.assignment.utils.Helpers
import com.srp.assignment.R
import com.srp.assignment.model.okHttpIssues.SquareIssuesDataClassItem
import kotlinx.android.synthetic.main.item_issues.view.*


private const val TAG = "IssuesAdapter"

class IssuesAdapter(
    val context: Context,
    private val issuesList: List<SquareIssuesDataClassItem>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<IssuesAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_issues, parent, false)
        )
    }

    override fun getItemCount() = issuesList.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = issuesList[position]

        holder.itemView.setOnClickListener {
            Log.i(TAG, "Tapped on position $position")
            onClickListener.onItemClick(position)
        }

        holder.bind(restaurant)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(issuesList: SquareIssuesDataClassItem) {
            itemView.tvName.text = issuesList.title
            itemView.tvNumReviews.text =
                if (issuesList.body != null && issuesList.body?.length >= 200)
                    issuesList.body?.subSequence(0, 200) ?: "" else ""
            itemView.tvAddress.text = issuesList.user?.login
            itemView.tvCategory.text = Helpers.convertTime(issuesList.updatedAt)
            Glide.with(context)
                .load(issuesList.user?.avatarUrl)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(20)))
                .into(itemView.imageViewItemRestaurant)
        }
    }
}
