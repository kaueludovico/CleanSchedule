package com.bigrocket.housekeeper.resources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bigrocket.housekeeper.R
import com.bigrocket.housekeeper.model.Address
import com.bigrocket.housekeeper.model.Schedule
import kotlinx.android.synthetic.main.res_item_service.view.*

class ListScheduleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var items: List<Schedule>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListScheduleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_service, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ListScheduleViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(list: List<Schedule>) {
        this.items = list
    }

    class ListScheduleViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val scheduleType = itemView.textViewTypeService
        private val scheduleDate = itemView.textViewDate
        private val scheduleAddress = itemView.textViewAddess

        fun bind(schedule: Schedule) {
            scheduleType.text = "${schedule.type}"
            scheduleDate.text = schedule.date
            scheduleAddress.text = concatenateAddress(schedule.address)
        }

        fun concatenateAddress(address: Address) : String {
            var concatenate = "" +
                    "${address.street}, " +
                    "${address.number} - " +
                    "${address.district}, " +
                    "${address.city}, " +
                    "${address.state} - " +
                    "${address.country}"
            return concatenate
        }
    }
}