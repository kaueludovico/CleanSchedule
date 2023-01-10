package com.bigrocket.housekeeper.resources

import com.bigrocket.housekeeper.model.Address
import com.bigrocket.housekeeper.model.Schedule

class DataSourceSchedules {
    companion object {
        fun createSchedules(schedule: Schedule, callback: (schedule: ArrayList<Schedule>) -> Unit){
            var list = ArrayList<Schedule>()
            list.add(schedule)
            callback(list)
        }
    }
}