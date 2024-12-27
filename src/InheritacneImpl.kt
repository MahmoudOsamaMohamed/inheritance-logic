package com.lightfeather.islami180.data.inheritacne


class InheritacneImpl(private val inheritacneWay: InheritacneWay):Inheritacne {
    override fun putSon() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Son] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Son]!! + 1
    }

    override fun putDaughter() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Daughter] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Daughter]!! + 1
    }

    override fun putSon_son() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Son_son] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Son_son]!! + 1
    }

    override fun putWife() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Wife] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Wife]!! + 1
    }

    override fun putHasbend() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Hasbend] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Hasbend]!! + 1
    }

    override fun putSonDaughter() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Son_daughter] =    inheritacneWay.heirsMap[InheritacneWay.AllRelation.Son_daughter]!! + 1
    }

    override fun putFather() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father]!! + 1
    }

    override fun putGrandfather() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Grandfather] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Grandfather]!! + 1
    }

    override fun putBrother() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Brother] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Brother]!! + 1
    }

    override fun putSister() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Sister] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Sister]!! + 1
    }

    override fun putMother() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Mother] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Mother]!! + 1
    }

    override fun putGrandmother() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Grandmother] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Grandmother]!! + 1
    }

    override fun putUncle() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Uncle] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Uncle]!! + 1
    }

    override fun putUncleSon() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Uncle_son] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Uncle_son]!! + 1
    }

    override fun putFatherUncle() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_uncle] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_uncle]!! + 1
    }

    override fun putFatherUncleSon() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_uncle_son] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_uncle_son]!! + 1
    }

    override fun putFatherBrother() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_brother] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_brother]!! + 1
    }

    override fun putFatherBrotherSon() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_brother_son] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_brother_son]!! + 1
    }

    override fun putBrotherSon() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Brother_son] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Brother_son]!! + 1
    }

    override fun putMothersRelatives() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Mother_relatives] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Mother_relatives]!! + 1
    }

    override fun putFatherSister() {
        inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_sister] = inheritacneWay.heirsMap[InheritacneWay.AllRelation.Father_sister]!! + 1
    }

    override fun calculate(): MutableList<Realtive> {
        val mirath = inheritacneWay.calculate(inheritacneWay.heirsMap)

        return mirath
    }

    override fun isReDivided(): Boolean {
        return inheritacneWay.reclc
    }

    override fun isOverFlow(): Boolean {
        return inheritacneWay.incer
    }
}