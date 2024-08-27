package com.games.colormix.data


data class LevelQuest(
    val block: BlockType = BlockType.Empty,
    val amount: Int,
    val multiBlock: Int? = null
)

fun LevelQuest.getMoveEstimation(): Int {
    if (this.block == BlockType.Box || this.block == BlockType.FallingBox) {
        return 0
    }
    val factor = if (this.multiBlock != null) multiBlock.toDouble() * 0.5 else 0.75

    return (amount * factor).toInt()
}
