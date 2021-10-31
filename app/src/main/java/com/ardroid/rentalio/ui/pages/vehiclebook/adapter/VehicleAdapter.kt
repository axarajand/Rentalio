package com.ardroid.rentalio.ui.pages.vehiclebook.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ardroid.rentalio.R
import com.ardroid.rentalio.databinding.ItemVehicleBinding
import com.ardroid.rentalio.domain.VehicleModel

class VehicleAdapter : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    private var listVehicle = ArrayList<VehicleModel>()
    var onItemClick: ((VehicleModel) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setVehicle(newListVehicle: List<VehicleModel>?) {
        if (newListVehicle == null) return
        listVehicle.clear()
        listVehicle.addAll(newListVehicle)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VehicleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_vehicle, parent, false)
        )

    override fun getItemCount(): Int = listVehicle.size

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bind(listVehicle[position])
    }

    inner class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemVehicleBinding.bind(itemView)
        fun bind(vehicle: VehicleModel) {
            with(binding) {
                vehicleImg.setImageResource(vehicle.image)
                vehicleName.text = vehicle.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listVehicle[adapterPosition])
            }
        }
    }
}