package com.lightfeather.islami180.data.inheritacne

class MajorWay:InheritacneWay() {
    private class MajorSon(heirsMap: MutableMap<AllRelation, Int>): Son(heirsMap)
    private class MajorSonsSon(heirsMap: MutableMap<AllRelation, Int>): SonsSon(heirsMap)
    private class MajorFather(heirsMap: MutableMap<AllRelation, Int>): Father(heirsMap)
    private class MajorGrandfather(heirsMap: MutableMap<AllRelation, Int>): Grandfather(heirsMap)
    private class MajorUncle(heirsMap: MutableMap<AllRelation, Int>): Uncle(heirsMap)
    private class MajorUncleSon(heirsMap: MutableMap<AllRelation, Int>): UncleSon(heirsMap)
    private class MajorMotherSons(heirsMap: MutableMap<AllRelation, Int>): MotherSons(heirsMap)
    private class MajorBrother(heirsMap: MutableMap<AllRelation, Int>): Brother(heirsMap)
    private class MajorUncleByFather(heirsMap: MutableMap<AllRelation, Int>):
        UncleByFather(heirsMap)
    private class MajorBrotherByFather(heirsMap: MutableMap<AllRelation, Int>):
        BrotherByFather(heirsMap)
    private class MajorUncleByFatherSon(heirsMap: MutableMap<AllRelation, Int>):
        UncleByFatherSon(heirsMap)
    private class MajorDaughter(heirsMap: MutableMap<AllRelation, Int>): Daughter(heirsMap)
    private class MajorDaughterOfSons(heirsMap: MutableMap<AllRelation, Int>):
        DaughterOfSons(heirsMap)
    private class MajorMother(heirsMap: MutableMap<AllRelation, Int>): Mother(heirsMap)
    private class MajorGrandmother(heirsMap: MutableMap<AllRelation, Int>): Grandmother(heirsMap)
    private class MajorSister(heirsMap: MutableMap<AllRelation, Int>): Sister(heirsMap)
    private class MajorSisterByFather(heirsMap: MutableMap<AllRelation, Int>):
        SisterByFather(heirsMap)
    private class MajorHusband(heirsMap: MutableMap<AllRelation, Int>): Husband(heirsMap)
    private class MajorWife(heirsMap: MutableMap<AllRelation, Int>): Wife(heirsMap)
    private class MajorBrotherSon(heirsMap: MutableMap<AllRelation, Int>): BrotherSon(heirsMap)
    private class MajorBrotherByFatherSon(heirsMap: MutableMap<AllRelation, Int>):
        BrotherByFatherSon(heirsMap)
    override fun calculate(map: MutableMap<AllRelation, Int>): MutableList<Realtive> {
        val output = mutableListOf<Realtive>()
        super.osba = false
        super.incer = false
        super.reclc = false
        var amount = calculateAllFractions(map)
        amount.forEach {relative->
            repeat(heirsMap[relative.key]!!){
                if(heirsMap[relative.key]!!>1) "مشترك في ${fractionMap[relative.value]}" else fractionMap[relative.value]
                output.add(Realtive(name=relative.key, arrow = if(heirsMap[relative.key]!!>1 ) "مشترك في ${fractionMap[relative.value]}" else fractionMap[relative.value]!!))
            }

        }
        amount = calculateRemainds(amount)
        if(amount.values.sum() < 24){
            super.reclc = true
            amount = recalc(amount)
        }
        println(amount)
        output.forEach{
            it.fractionPrecentage = amount[it.name]!! * 100.0 /( 24.0 * heirsMap[it.name]!!)
            if(it.fractionPrecentage == 0.0){
                it.arrow = "محجوب"
            }
        }
        if(output.sumOf { it.fractionPrecentage }>=101.0){
            super.incer = true
            val peresentage = 100.0 / output.sumOf { it.fractionPrecentage }
            output.forEach { it.fractionPrecentage *= peresentage }
        }
        return output
    }

    override fun calculateAllFractions(map: MutableMap<AllRelation, Int>):  MutableMap<AllRelation, Int> {
         val allFractions:MutableMap<AllRelation,Int> = mutableMapOf()
        map.forEach {
            if(it.value>0) {
                when (it.key) {
                    AllRelation.Son -> {
                        val son = MajorSon(map)
                        allFractions[AllRelation.Son] = son.amount()
                    }

                    AllRelation.Son_son -> {
                        val son_son = MajorSonsSon(map)
                        allFractions[AllRelation.Son_son] = son_son.amount()
                    }

                    AllRelation.Daughter -> {
                        val daughter = MajorDaughter(map)
                        allFractions[AllRelation.Daughter] = daughter.amount()
                    }

                    AllRelation.Wife -> {
                        val wife = MajorWife(map)
                        allFractions[AllRelation.Wife] = wife.amount()
                    }

                    AllRelation.Hasbend -> {
                        val hasbend = MajorHusband(map)
                        allFractions[AllRelation.Hasbend] = hasbend.amount()
                    }

                    AllRelation.Son_daughter -> {
                        val son_daughter = MajorDaughterOfSons(map)
                        allFractions[AllRelation.Son_daughter] = son_daughter.amount()
                    }

                    AllRelation.Father -> {
                        val father = MajorFather(map)
                        allFractions[AllRelation.Father] = father.amount()
                    }

                    AllRelation.Grandfather -> {
                        val grandfather = MajorGrandfather(map)
                        allFractions[AllRelation.Grandfather] = grandfather.amount()
                    }

                    AllRelation.Brother -> {
                        val brother = MajorBrother(map)
                        allFractions[AllRelation.Brother] = brother.amount()
                    }

                    AllRelation.Sister -> {
                        val sister = MajorSister(map)
                        allFractions[AllRelation.Sister] = sister.amount()
                    }

                    AllRelation.Mother -> {
                        val mother = MajorMother(map)
                        allFractions[AllRelation.Mother] = mother.amount()
                    }

                    AllRelation.Grandmother -> {
                        val grandmother = MajorGrandmother(map)
                        allFractions[AllRelation.Grandmother] = grandmother.amount()
                    }

                    AllRelation.Uncle -> {
                        val uncle = MajorUncle(map)
                        allFractions[AllRelation.Uncle] = uncle.amount()
                    }

                    AllRelation.Uncle_son -> {
                        val uncle_son = MajorUncleSon(map)
                        allFractions[AllRelation.Uncle_son] = uncle_son.amount()
                    }

                    AllRelation.Father_uncle -> {
                        val father_uncle = MajorUncleByFather(map)
                        allFractions[AllRelation.Father_uncle] = father_uncle.amount()
                    }

                    AllRelation.Father_uncle_son -> {
                        val father_uncle_son = MajorUncleByFatherSon(map)
                        allFractions[AllRelation.Father_uncle_son] = father_uncle_son.amount()
                    }

                    AllRelation.Father_brother -> {
                        val father_brother = MajorBrotherByFather(map)
                        allFractions[AllRelation.Father_brother] = father_brother.amount()
                    }

                    AllRelation.Father_brother_son -> {
                        val father_brother_son = MajorBrotherByFatherSon(map)
                        allFractions[AllRelation.Father_brother_son] = father_brother_son.amount()
                    }

                    AllRelation.Brother_son -> {
                        val brother_son = MajorBrotherSon(map)
                        allFractions[AllRelation.Brother_son] = brother_son.amount()
                    }

                    AllRelation.Mother_relatives -> {
                        val mother_relatives = MajorMotherSons(map)
                        allFractions[AllRelation.Mother_relatives] = mother_relatives.amount()
                    }

                    AllRelation.Father_sister -> {
                        val father_sister = MajorSisterByFather(map)
                        allFractions[AllRelation.Father_sister] = father_sister.amount()
                    }
                }
            }
        }
        println(allFractions)
        return allFractions
    }

    override fun calculateRemainds(output:  MutableMap<AllRelation, Int>):  MutableMap<AllRelation, Int> {
        val afterOsba: MutableMap<AllRelation, Int> = output
        output.values.forEach {
            if (it < 0)
                super.osba = true
        }
        if (!super.osba)
            return output
        var one = true
        output.values.forEach {
            if (it < -1)
                one = false
        }
        if (one) {
            output.forEach {
                if (it.value == -1) {
                    if (24 - output.values.sum() - 1 < 0)
                        afterOsba[it.key] = 0
                    else
                        afterOsba[it.key] = 24 - output.values.sum() - 1
                }

            }


        }
        else if(output.values.contains(-3)){
            if(output.values.sum()+7>=24){
                if(super.heirsMap[AllRelation.Father]!! ==1){
                    afterOsba[AllRelation.Father] = 4
                }else{
                    afterOsba[AllRelation.Grandfather] = 4
                }
            }
            else{
                if(super.heirsMap[AllRelation.Father]!! ==1){
                    afterOsba[AllRelation.Father] = 24 - output.values.sum() - 3
                }else{
                    afterOsba[AllRelation.Grandfather] = 24 - output.values.sum() - 3
                }
            }
        }
        else{
            var remain = 24 - output.values.sum() - 6
            if (remain<0)
                remain = 0
            var male = 0
            var female = 0
            output.forEach {
                if(it.value==-2)
                    male = super.heirsMap[it.key]!!
                if (it.value == -4)
                    female = super.heirsMap[it.key]!!
            }
            println("male $male female $female remain $remain")
            val arrow = remain / (2*male +female)
            output.forEach {
                if(it.value==-2)
                    afterOsba[it.key] = 2 * arrow * super.heirsMap[it.key]!!
                if (it.value == -4)
                    afterOsba[it.key] =  arrow * super.heirsMap[it.key]!!
            }
        }
        return afterOsba
    }

    override fun recalc(map:  MutableMap<AllRelation, Int>):  MutableMap<AllRelation, Int> {
        var n  =24
        var sum = map.values.sum()
        if(map.keys.contains(AllRelation.Wife)){
            n = 24 -map[AllRelation.Wife]!!
            sum -= map[AllRelation.Wife]!!
        }
        if(map.keys.contains(AllRelation.Hasbend)){
            n = 24 -map[AllRelation.Hasbend]!!
            sum -= map[AllRelation.Hasbend]!!
        }
        val afterRecalc =map
        map.forEach {
            if(it.key!=AllRelation.Wife && it.key!=AllRelation.Hasbend){
                afterRecalc[it.key] = (n * it.value)/sum
            }
        }
        return afterRecalc
    }
}