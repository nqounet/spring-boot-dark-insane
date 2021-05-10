package net.nqou.darkinsane.domain.model.soul

import io.kotest.core.spec.style.BehaviorSpec

class SoulTest : BehaviorSpec({

    Given("ソウルが作成できる") {
        When("ソウルを作成するとき") {
            val soul: Soul = TestSoulFactory.create()
            Then("ソウルの値を確認する") {
                println(soul.strength)
                println(soul.intelligence)
                println(soul.vitality)
                println(soul.mind)
                println(soul.dexterity)
                println(soul.speed)
                println(soul.physicalAttack)
                println(soul.physicalDefense)
                println(soul.magicAttack)
                println(soul.magicDefense)
                println(soul.hitRate)
                println(soul.weight)
                println(soul.hitPoint)
                println(soul.specialPoint)
            }
        }
    }
})
