package com.example.myapplication.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Ranking
import com.example.myapplication.models.RankingData
import com.example.myapplication.room.RankingDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RankingViewModel(private val rankingDao: RankingDao): ViewModel() {



    fun getRanking() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                RankingData.rankingList = rankingDao.getRanking()
            }
        }
    }

    fun addRanking(ranking: Ranking) {
        viewModelScope.launch {
            rankingDao.insertRanking(ranking)
        }
    }
}