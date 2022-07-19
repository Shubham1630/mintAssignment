package com.srp.assignment

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class Helpers {


    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun convertTime(date: String?): String {
            val zonedDateTime = ZonedDateTime.parse(date)
            val dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy")

            return dtf.format(zonedDateTime)
        }


    }


}