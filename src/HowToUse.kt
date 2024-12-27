package com.lightfeather.islami180.data.inheritacne
    fun main() {
        val inhertanceFactory = InheritacneFactory()
        val inhertance = inhertanceFactory.createInhertance(InheritacneFactory.Companion.InhertanceWays.MajorWay) // MajorWay = مذهب الجمهور
        inhertance.apply {
            putSon()
            putHasbend()
            putFather()
        }
        println(inhertance.calculate())   // حساب التركة
        println(inhertance.isOverFlow())  //  هل المسألة بها عول
        println(inhertance.isReDivided()) //  هل المسألة بها رد
    }