package com.lightfeather.islami180.data.inheritacne
class InheritacneFactory {
    fun createInhertance( inhertanceWay: InhertanceWays): Inheritacne {
       return when (inhertanceWay) {
            InhertanceWays.MajorWay -> InheritacneImpl(MajorWay())

        }

    }
    companion object {
        enum class InhertanceWays {
            MajorWay
        }
    }
}