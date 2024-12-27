package com.lightfeather.islami180.data.inheritacne


abstract class InheritacneWay {
    enum class AllRelation {
        Son,
        Son_son,
        Daughter,
        Wife,
        Hasbend,
        Son_daughter,
        Father,
        Grandfather,
        Brother,
        Sister,
        Mother,
        Grandmother,
        Uncle,
        Uncle_son,
        Father_uncle,
        Father_uncle_son,
        Father_brother,
        Father_brother_son,
        Brother_son,
        Mother_relatives,
        Father_sister

    }
    var osba = false
    var incer = false
    var reclc = false

    val heirsMap : MutableMap<AllRelation,Int> = mutableMapOf(
        AllRelation.Son to 0,
        AllRelation.Son_son to 0,
        AllRelation.Daughter to 0,
        AllRelation.Wife to 0,
        AllRelation.Hasbend to 0,
        AllRelation.Son_daughter to 0,
        AllRelation.Father to 0,
        AllRelation.Grandfather to 0,
        AllRelation.Brother to 0,
        AllRelation.Sister to 0,
        AllRelation.Mother to 0,
        AllRelation.Grandmother to 0,
        AllRelation.Uncle to 0,
        AllRelation.Uncle_son to 0,
        AllRelation.Father_uncle to 0,
        AllRelation.Father_uncle_son to 0,
        AllRelation.Father_brother to 0,
        AllRelation.Father_brother_son to 0,
        AllRelation.Brother_son to 0,
        AllRelation.Mother_relatives to 0,
        AllRelation.Father_sister to 0
    )

    val fractionMap : MutableMap<Int,String> = mutableMapOf(
        3 to "الثمن",
        4 to "السدس",
        6 to "الربع",
        8 to "الثلث",
        12 to "النصف",
        16 to "الثلثين",
        0 to "محجوب",
        -1 to "الباقي تعصيبا",
        -3 to "السدس + الباقي",
        -2 to "الباقي للذكر مثل حظ الانثيين",
        -4 to "الباقي للذكر مثل حظ الانثيين"
    )
    abstract fun calculate(map: MutableMap<AllRelation, Int>): MutableList<Realtive>

    abstract fun calculateAllFractions(map: MutableMap<AllRelation,Int>): MutableMap<AllRelation,Int>
    abstract fun calculateRemainds(output : MutableMap<AllRelation,Int>): MutableMap<AllRelation,Int>
    abstract fun recalc(map: MutableMap<AllRelation,Int>): MutableMap<AllRelation,Int>


}