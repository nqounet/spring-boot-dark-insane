package net.nqou.darkinsane.domain.model.soul

import com.github.javafaker.Faker

object TestSoulFactory {
    val faker = Faker()

    fun create(
        strength: Long = faker.number().randomNumber(2, true),
        intelligence: Long = faker.number().randomNumber(2, true),
        vitality: Long = faker.number().randomNumber(2, true),
        mind: Long = faker.number().randomNumber(2, true),
        dexterity: Long = faker.number().randomNumber(2, true),
        speed: Long = faker.number().randomNumber(2, true),
    ): Soul {
        return Soul(
            strength = strength,
            intelligence = intelligence,
            vitality = vitality,
            mind = mind,
            dexterity = dexterity,
            speed = speed,
        )
    }
}
