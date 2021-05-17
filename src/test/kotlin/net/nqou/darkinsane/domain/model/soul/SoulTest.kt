package net.nqou.darkinsane.domain.model.soul

import io.kotest.core.spec.style.BehaviorSpec

class SoulTest : BehaviorSpec({

    Given("ソウルが作成できる") {
        When("ソウルを作成するとき") {
            val soul: Soul = TestSoulFactory.create()
            Then("ソウルの値を確認する") {
                println("str: ${soul.strength}")
                println("int: ${soul.intelligence}")
                println("vit: ${soul.vitality}")
                println("min: ${soul.mind}")
                println("dex: ${soul.dexterity}")
                println("spd: ${soul.speed}")
                println("pa: ${soul.physicalAttack}")
                println("pd: ${soul.physicalDefense}")
                println("ma: ${soul.magicAttack}")
                println("md: ${soul.magicDefense}")
                println("hit: ${soul.hitRate}")
                println("wgt: ${soul.weight}")
                println("hp: ${soul.hitPoint}")
                println("sp: ${soul.specialPoint}")
            }
        }
    }
})
