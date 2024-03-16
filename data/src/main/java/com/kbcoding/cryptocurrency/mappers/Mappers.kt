package com.kbcoding.cryptocurrency.mappers

import com.kbcoding.cryptocurrency.api.dto.CoinDetailDto
import com.kbcoding.cryptocurrency.api.dto.CoinDto
import com.kbcoding.cryptocurrency.api.dto.TeamMemberDto
import com.kbcoding.cryptocurrency.model.Coin
import com.kbcoding.cryptocurrency.model.CoinDetail
import com.kbcoding.cryptocurrency.model.TeamMember

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team.map { it.toTeamMember() }
    )
}

fun TeamMemberDto.toTeamMember(): TeamMember {
    return TeamMember(
        id = id,
        name = name,
        position = position
    )
}