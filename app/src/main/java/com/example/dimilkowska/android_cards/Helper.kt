package com.example.dimilkowska.android_cards

import java.util.*


fun RemoveAccountSeparators(account:String): String {
    var res = account.replace(" ", "")
    res = res.replace("-", "")
    return res
}

fun AddAccountSeparators(account:String): String {
    var res: String = ""
    for(i in account.indices){
        if (((i%4)==0) && (i>0)) res += " ";
        res += account[i]
    }
    return res
}

fun getfirstPeriodDay(period: Int): Long {

    var result: Long = System.currentTimeMillis()
    val timestamp = System.currentTimeMillis()
    if (period == 7) {
        val calendar = Calendar.getInstance()
        calendar.clear()
        calendar.timeInMillis = timestamp
        while (calendar.get(Calendar.DAY_OF_WEEK) > calendar.firstDayOfWeek) {
            calendar.add(Calendar.DATE, -1) // Substract 1 day until first day of week.
        }
        result = calendar.timeInMillis
    } else if (period == 30) {
        val calendar = Calendar.getInstance()
        calendar.clear()
        calendar.timeInMillis = timestamp
        while (calendar.get(Calendar.DATE) > 1) {
            calendar.add(Calendar.DATE, -1) // Substract 1 day until first day of month.
        }
        result = calendar.timeInMillis
    }
    return result

}
