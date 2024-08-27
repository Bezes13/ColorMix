package com.games.colormix.data

data class LevelInfo(
    val quests: List<LevelQuest> = listOf(),
    val specialBlocks: List<SpecialBlockPlacement> = listOf(),
    val moves: Int = 100,
    val level: Int = 100
)

fun LevelInfo.generateObjectDefinition(): String {
    val questsString = this.quests.joinToString(prefix = "listOf(", postfix = ")") {
        "LevelQuest(BlockType.${it.block}, ${it.amount}, ${it.multiBlock})"
    }
    val specialBlocksString =
        this.specialBlocks.joinToString(prefix = "listOf(", postfix = ")") {
            "SpecialBlockPlacement(BlockType.${it.specialType}, Pair(${it.pos.first},${it.pos.second}))"
        }
    return """
        LevelInfo(
            quests = $questsString,
            specialBlocks = $specialBlocksString
        ),
    """.trimIndent()
}

fun LevelInfo.estimateMoves(): Int {
    var moves = 1
    this.quests.forEach { moves += it.getMoveEstimation() }
    moves += this.specialBlocks.filter { it.specialType == BlockType.Blocker }.size
    moves += (this.specialBlocks.filter { it.specialType == BlockType.Box }.size * 1.5).toInt()
    moves += (this.specialBlocks.filter { it.specialType == BlockType.FallingBox }.size * 1)
    return moves
}
