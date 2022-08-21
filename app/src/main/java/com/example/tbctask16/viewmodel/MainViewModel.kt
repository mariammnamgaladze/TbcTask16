package com.example.tbctask16.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.tbctask16.Source
import com.example.tbctask16.model.RetrofitObj

class MainViewModel: ViewModel() {

    fun info() = Pager(
        config = PagingConfig(pageSize = 1),
        pagingSourceFactory = { Source(RetrofitObj.UserRepository()) }
    ).flow

}