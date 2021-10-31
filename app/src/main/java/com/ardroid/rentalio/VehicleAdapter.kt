package com.ardroid.rentalio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ardroid.rentalio.databinding.ItemVehicleBinding

class VehicleAdapter : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    private var listVehicle = ArrayList<VehicleModel>()
    var onItemClick: ((VehicleModel) -> Unit)? = null

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