package com.lightfeather.islami180.data.inheritacne


interface Inheritacne {
     fun putSon()
     fun  putDaughter()
     fun  putSon_son()
     fun  putWife()
     fun  putHasbend()
     fun  putSonDaughter()
     fun  putFather()
     fun  putGrandfather()
     fun  putBrother()
     fun  putSister()
     fun  putMother()
     fun  putGrandmother()
     fun  putUncle()
     fun  putUncleSon()
     fun  putFatherUncle()
     fun  putFatherUncleSon()
     fun  putFatherBrother()
     fun  putFatherBrotherSon()
     fun  putBrotherSon()
     fun  putMothersRelatives()
     fun  putFatherSister()
     fun  calculate() : MutableList<Realtive>
     fun isReDivided(): Boolean
     fun isOverFlow(): Boolean
}