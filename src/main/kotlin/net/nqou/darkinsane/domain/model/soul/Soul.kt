package net.nqou.darkinsane.domain.model.soul

import kotlin.math.floor
import kotlin.math.sqrt

data class Soul(
    val strength: Long,
    val intelligence: Long,
    val vitality: Long,
    val mind: Long,
    val dexterity: Long,
    val speed: Long,
) {
    val physicalAttack: Long by lazy { physicalAttack() }
    val physicalDefense: Long by lazy { physicalDefense() }
    val magicAttack: Long by lazy { magicAttack() }
    val magicDefense: Long by lazy { magicDefense() }
    val hitRate: Long by lazy { hitRate() }
    val weight: Long by lazy { weight() }
    val hitPoint: Long by lazy { hitPoint() }
    val specialPoint: Long by lazy { specialPoint() }


    /**
     * 物理攻撃力
     */
    private fun physicalAttack(): Long {
        val power = 100 + strength * 3 + vitality + dexterity
        val rate = intelligence + mind
        return strength + floor(10.0 * power / rate).toLong()
    }

    /**
     * 物理防御力
     */
    private fun physicalDefense(): Long {
        val power = 100 + vitality * 3 + strength + speed
        val rate = intelligence + mind
        return vitality + floor(7.0 * power / rate).toLong()
    }

    /**
     * 魔法攻撃力
     */
    private fun magicAttack(): Long {
        val power = 100 + intelligence * 3 + mind + dexterity
        val rate = strength + vitality
        return intelligence + floor(10.0 * power / rate).toLong()
    }

    /**
     * 魔法防御力
     */
    private fun magicDefense(): Long {
        val power = 100 + mind * 3 + intelligence + speed
        val rate = strength + vitality
        return mind + floor(7.0 * power / rate).toLong()
    }

    /**
     * 命中率
     */
    private fun hitRate(): Long {
        val power = 100 + dexterity * 4 + speed
        val rate = strength + vitality + intelligence + mind
        return dexterity + floor(5.0 * power / rate).toLong()
    }

    /**
     * 重量
     */
    private fun weight(): Long {
        val baseWeight = 100 * 100 + vitality
        val deadWeight = 100 + vitality * 3 + strength * 2 + intelligence + mind
        val acceleration = speed * 4 + dexterity * 2
        return floor(sqrt(1.0 * baseWeight * deadWeight / acceleration)).toLong()
    }

    /**
     * 生命力
     */
    private fun hitPoint(): Long {
        return vitality * 2 + strength + speed
    }

    /**
     * 特殊能力
     */
    private fun specialPoint(): Long {
        return mind * 2 + intelligence + dexterity * 2
    }
}
