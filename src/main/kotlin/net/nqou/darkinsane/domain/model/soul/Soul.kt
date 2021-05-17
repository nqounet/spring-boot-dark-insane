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
        val power: Long = 100 + strength * 3 + vitality + dexterity
        val rate: Long = intelligence + mind
        val ppr: Long = power / rate
        return strength + 10 * ppr
    }

    /**
     * 物理防御力
     */
    private fun physicalDefense(): Long {
        val power: Long = 100 + vitality * 3 + strength + speed
        val rate: Long = intelligence + mind
        val ppr: Long = power / rate
        return vitality + 7 * ppr
    }

    /**
     * 魔法攻撃力
     */
    private fun magicAttack(): Long {
        val power: Long = 100 + intelligence * 3 + mind + dexterity
        val rate: Long = strength + vitality
        val ppr: Long = power / rate
        return intelligence + 10 * ppr
    }

    /**
     * 魔法防御力
     */
    private fun magicDefense(): Long {
        val power: Long = 100 + mind * 3 + intelligence + speed
        val rate: Long = strength + vitality
        val ppr: Long = power / rate
        return mind + 7 * ppr
    }

    /**
     * 命中率
     */
    private fun hitRate(): Long {
        val power: Long = 100 + dexterity * 4 + speed
        val rate: Long = strength + vitality + intelligence + mind
        val ppr: Long = power / rate
        return dexterity + 5 * ppr
    }

    /**
     * 重量
     */
    private fun weight(): Long {
        val baseWeight: Long = 100 * 100 + vitality // 肉
        val deadWeight: Long = 100 + vitality * 3 + strength * 2 + intelligence + mind // 骨
        val acceleration: Long = speed * 4 + dexterity * 2 // 動かす力
        val bda: Double = 1.0 * baseWeight * deadWeight / acceleration
        return floor(sqrt(bda)).toLong()
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
