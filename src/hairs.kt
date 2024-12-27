package com.lightfeather.islami180.data.inheritacne

import com.lightfeather.islami180.data.inheritacne.InheritacneWay.AllRelation
data class Realtive(val name:AllRelation, var fractionPrecentage:Double=-1.0, var arrow:String)
abstract class Hair(val hairsMap: MutableMap<AllRelation,Int>){
    abstract var blockers:Set<AllRelation>
    abstract fun isBlocked():Boolean
    abstract fun amount():Int
}
abstract class Son(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap){

    override var blockers = setOf<AllRelation>()
    override fun isBlocked():Boolean = false
    override fun amount():Int{
        return if (hairsMap[AllRelation.Daughter]!! > 0){
            -2
        } else {
            -1
        }

    }
}
abstract class SonsSon(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap){

    override var blockers = setOf(AllRelation.Son)
    override fun isBlocked():Boolean {
        return hairsMap[AllRelation.Son]!! > 0
    }
    override fun amount():Int{
        return if(isBlocked())
            0
        else if(hairsMap[AllRelation.Son_daughter]!! > 0){
            -2
        } else {
            -1
        }
    }
}
abstract class Father(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap){

    override var blockers = setOf<AllRelation>()
    override fun isBlocked():Boolean = false
    override fun amount():Int{
        return if (hairsMap[AllRelation.Son]!! > 0||hairsMap[AllRelation.Son_son]!! > 0){
            4
        } else {
            -3
        }

    }
}
abstract class Grandfather(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap){

    override var blockers = setOf(AllRelation.Father)
    override fun isBlocked():Boolean {
        return hairsMap[AllRelation.Father]!! > 0
    }
    override fun amount():Int{
        return if(isBlocked())
            0
        else if (hairsMap[AllRelation.Son]!! > 0||hairsMap[AllRelation.Son_son]!! > 0){
            4
        } else {
            -3
        }

    }
}
abstract class Husband(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf<AllRelation>()
    override fun isBlocked(): Boolean = false
    override fun amount(): Int {
        return if (hairsMap[AllRelation.Son]!! > 0 || hairsMap[AllRelation.Son_son]!! > 0
            || hairsMap[AllRelation.Daughter]!! > 0 || hairsMap[AllRelation.Son_daughter]!! > 0
        ) {
            6
        } else {
            12
        }

    }
}
abstract class Wife(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf<AllRelation>()
    override fun isBlocked(): Boolean = false
    override fun amount(): Int {
        return if (hairsMap[AllRelation.Son]!! > 0 || hairsMap[AllRelation.Son_son]!! > 0
            || hairsMap[AllRelation.Daughter]!! > 0 || hairsMap[AllRelation.Son_daughter]!! > 0
        ) {
            3
        } else {
            6
        }

    }
}
abstract class Brother(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son,AllRelation.Father,AllRelation.Grandfather)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if (hairsMap[AllRelation.Sister]!! > 0) {
            -2
        } else {
            -1
        }

    }
}
abstract class BrotherByFather(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son
        ,AllRelation.Father,AllRelation.Grandfather,AllRelation.Brother)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if (hairsMap[AllRelation.Sister]!!>0  &&
            (hairsMap[AllRelation.Daughter]!! > 0 ||hairsMap[AllRelation.Son_daughter]!! > 0))
            0
        else if (hairsMap[AllRelation.Father_sister]!! > 0) {
            -2
        } else {
            -1
        }

    }
}
abstract class BrotherSon(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son
        ,AllRelation.Father,AllRelation.Grandfather,AllRelation.Brother,AllRelation.Father_brother)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if ((hairsMap[AllRelation.Father_sister]!!>0 ||((hairsMap[AllRelation.Sister]!!>0 ) )&&
                    (hairsMap[AllRelation.Daughter]!! > 0 ||hairsMap[AllRelation.Son_daughter]!! > 0)))
            0
        else {
            -1
        }

    }
}
abstract class BrotherByFatherSon(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son,AllRelation.Brother_son
        ,AllRelation.Father,AllRelation.Grandfather,AllRelation.Brother,AllRelation.Father_brother)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if ((hairsMap[AllRelation.Father_sister]!!>0 ||((hairsMap[AllRelation.Sister]!!>0 ) )&&
                    (hairsMap[AllRelation.Daughter]!! > 0 ||hairsMap[AllRelation.Son_daughter]!! > 0)))
            0
        else {
            -1
        }

    }
}
abstract class Uncle(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son
        ,AllRelation.Father,AllRelation.Grandfather,AllRelation.Brother,
        AllRelation.Father_brother,AllRelation.Father_brother_son,AllRelation.Brother_son)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if ((hairsMap[AllRelation.Sister]!!>0||hairsMap[AllRelation.Father_sister]!!>0)  &&
            (hairsMap[AllRelation.Daughter]!! > 0 ||hairsMap[AllRelation.Son_daughter]!! > 0))
            0
        else {
            -1
        }

    }
}
abstract class UncleByFather(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son
        ,AllRelation.Father,AllRelation.Grandfather,AllRelation.Brother,
        AllRelation.Father_brother,AllRelation.Father_brother_son,
        AllRelation.Uncle,AllRelation.Brother_son)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if ((hairsMap[AllRelation.Sister]!!>0||hairsMap[AllRelation.Father_sister]!!>0)  &&
            (hairsMap[AllRelation.Daughter]!! > 0 ||hairsMap[AllRelation.Son_daughter]!! > 0))
            0
        else {
            -1
        }

    }
}
abstract class UncleSon(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son
        ,AllRelation.Father,AllRelation.Grandfather,AllRelation.Brother,
        AllRelation.Father_brother,AllRelation.Father_brother_son,
        AllRelation.Uncle,AllRelation.Father_uncle,AllRelation.Brother_son)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if ((hairsMap[AllRelation.Sister]!!>0||hairsMap[AllRelation.Father_sister]!!>0)  &&
            (hairsMap[AllRelation.Daughter]!! > 0 ||hairsMap[AllRelation.Son_daughter]!! > 0))
            0
        else {
            -1
        }

    }
}
abstract class UncleByFatherSon(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son
        ,AllRelation.Father,AllRelation.Grandfather,AllRelation.Brother,
        AllRelation.Father_brother,AllRelation.Father_brother_son,
        AllRelation.Uncle,AllRelation.Father_uncle,AllRelation.Uncle_son,
        AllRelation.Brother_son)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {
        return if(isBlocked())
            0
        else if ((hairsMap[AllRelation.Sister]!!>0||hairsMap[AllRelation.Father_sister]!!>0)  &&
            (hairsMap[AllRelation.Daughter]!! > 0 ||hairsMap[AllRelation.Son_daughter]!! > 0))
            0
        else {
            -1
        }

    }
}
abstract class Daughter(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf<AllRelation>()
    override fun isBlocked(): Boolean = false
    override fun amount(): Int {

        return if (hairsMap[AllRelation.Son]!! == 0 && hairsMap[AllRelation.Daughter]!! == 1)
            12
        else if (hairsMap[AllRelation.Son]!! == 0 && hairsMap[AllRelation.Daughter]!! >1)
            16
        else if (hairsMap[AllRelation.Son]!! > 0 )
            -4
        else {
            -1
        }

    }
}
abstract class DaughterOfSons(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {

        if (hairsMap[AllRelation.Son_son]!! == 0 && hairsMap[AllRelation.Daughter]!! >= 2)
            return 0
        else if (hairsMap[AllRelation.Son]!! == 0 && hairsMap[AllRelation.Daughter]!! ==0
            && hairsMap[AllRelation.Son_son]!! == 0
            && hairsMap[AllRelation.Son_daughter]!! == 1)
            return 12
        else if (hairsMap[AllRelation.Son]!! == 0 && hairsMap[AllRelation.Daughter]!! ==0
            && hairsMap[AllRelation.Son_son]!! == 0
            && hairsMap[AllRelation.Son_daughter]!! > 1)
            return 16
        else if (hairsMap[AllRelation.Son]!! == 0 && hairsMap[AllRelation.Daughter]!! ==1
            && hairsMap[AllRelation.Son_son]!! == 0
            && hairsMap[AllRelation.Son_daughter]!! >= 1)
            return 4
        else if (hairsMap[AllRelation.Son]!! > 0  && hairsMap[AllRelation.Son_son]!! >= 1
            && hairsMap[AllRelation.Son_daughter]!! >= 1)
            return -4
        else {
            return -1
        }

    }
}
abstract class Mother(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf<AllRelation>()
    override fun isBlocked(): Boolean = false
    override fun amount(): Int {

        if (hairsMap[AllRelation.Son]!! >= 1 || hairsMap[AllRelation.Daughter]!! >= 1
            || hairsMap[AllRelation.Son_son]!! >= 1
            || hairsMap[AllRelation.Son_daughter]!! >= 1
            || (hairsMap[AllRelation.Brother]!! + hairsMap[AllRelation.Brother]!!
                    + hairsMap[AllRelation.Father_brother]!!  + hairsMap[AllRelation.Father_sister]!!
                    + hairsMap[AllRelation.Mother_relatives]!!) > 1)
            return 4
        else if(hairsMap[AllRelation.Son]!! == 0 && hairsMap[AllRelation.Daughter]!! == 0
            && hairsMap[AllRelation.Son_son] !! ==0 && hairsMap[AllRelation.Son_daughter]!! == 0
            && ((hairsMap[AllRelation.Brother]!! == 0 && hairsMap[AllRelation.Sister]!! ==0)
                    || (hairsMap[AllRelation.Brother]!! == 1 && hairsMap[AllRelation.Sister]!! ==0)
                    || (hairsMap[AllRelation.Brother]!! == 0 && hairsMap[AllRelation.Sister]!! ==1)))
            return 8
        else {
            return -1
        }

    }
}
abstract class Grandmother(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Mother)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {

        return if (isBlocked())
            0
        else if (hairsMap[AllRelation.Grandmother]!! == hairsMap.values.sum()) {
            -1
        } else {
            4
        }

    }
}
abstract class Sister(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son,AllRelation.Father,AllRelation.Grandfather)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {

        return if (isBlocked())
            0
        else if (hairsMap[AllRelation.Brother]!! == 0 && hairsMap[AllRelation.Daughter]!! == 0
            && hairsMap[AllRelation.Sister]!! == 1 && hairsMap[AllRelation.Son_daughter]!! == 0 ) {
            12
        } else if (hairsMap[AllRelation.Brother]!! == 0 && hairsMap[AllRelation.Daughter]!! == 0
            && hairsMap[AllRelation.Sister]!! > 1 && hairsMap[AllRelation.Son_daughter]!! == 0 ) {
            16
        } else if (hairsMap[AllRelation.Brother]!! >= 1)
            -4
        else {
            -1
        }
    }
}
abstract class SisterByFather(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son,AllRelation.Father,
        AllRelation.Grandfather,AllRelation.Brother)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {

        if (isBlocked())
            return 0
        else if (hairsMap[AllRelation.Sister]!! > 0 &&
            (hairsMap[AllRelation.Son_daughter]!! > 0 || hairsMap[AllRelation.Daughter]!! > 0))
            return 0
        else if (hairsMap[AllRelation.Father_brother]!! == 0 && hairsMap[AllRelation.Daughter]!! == 0
            && hairsMap[AllRelation.Sister]!! == 0 && hairsMap[AllRelation.Son_daughter]!! == 0
            && hairsMap[AllRelation.Father_sister]!! == 1) {
            return 12
        }   else if (hairsMap[AllRelation.Father_brother]!! == 0 && hairsMap[AllRelation.Daughter]!! == 0
            && hairsMap[AllRelation.Sister]!! == 0 && hairsMap[AllRelation.Son_daughter]!! == 0
            && hairsMap[AllRelation.Father_sister]!! > 1) {
            return 16
        }
        else if (hairsMap[AllRelation.Father_brother]!! == 0 && hairsMap[AllRelation.Daughter]!! == 0
            && hairsMap[AllRelation.Sister]!! == 1 && hairsMap[AllRelation.Son_daughter]!! == 0) {
            return 4
        }
        else if (hairsMap[AllRelation.Father_brother]!! >= 1)
            return -4
        else {
            return -1
        }
    }

}
abstract class MotherSons(hairsMap: MutableMap<AllRelation,Int>): Hair(hairsMap) {

    override var blockers = setOf(AllRelation.Son,AllRelation.Son_son,AllRelation.Father,
        AllRelation.Grandfather,AllRelation.Daughter,AllRelation.Son_daughter)
    override fun isBlocked(): Boolean {
        blockers.forEach {
            if (hairsMap[it]!! > 0) {
                return true
            }
        }
        return false
    }
    override fun amount(): Int {

        return if (isBlocked())
            0
        else if (hairsMap[AllRelation.Mother_relatives]!! == hairsMap.values.sum())
            -1
        else if (hairsMap[AllRelation.Mother_relatives]!! >1)
            8
        else {
            4
        }
    }
}