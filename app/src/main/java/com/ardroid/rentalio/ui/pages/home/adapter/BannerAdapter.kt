package com.ardroid.rentalio.ui.pages.home.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ardroid.rentalio.R
import com.ardroid.rentalio.domain.BannerModel
import com.bumptech.glide.Glide

class BannerAdapter(private val bannerListItem: List<BannerModel>) : RecyclerView.Adapter<BannerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner_slider, parent, false)

        return BannerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bannerListItem.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerItem = bannerListItem[position]
        holder.bind(bannerItem)
    }

}

class BannerViewHolder(private val view: View): RecyclerView.ViewHolder(view){
    private val bannerImageView: ImageView = view.findViewById(R.id.banner_image_view)

    fun bind(bannerItem: BannerModel){
        Glide.with(view.context)
            .load(bannerItem.image)
            .into(bannerImageView)
    }
}