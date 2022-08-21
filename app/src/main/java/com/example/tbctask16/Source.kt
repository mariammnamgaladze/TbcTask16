package com.example.tbctask16

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tbctask16.model.DataModel
import com.example.tbctask16.model.RetrofitObj

class Source (
    private val userRepository: RetrofitObj.UserRepository
) : PagingSource<Int, DataModel.UserData>() {

    override fun getRefreshKey(state: PagingState<Int, DataModel.UserData>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataModel.UserData> {

        val page: Int = params.key ?: 1

        userRepository.getInfo(page)?.let {
            return LoadResult.Page(
                it.data ?: emptyList(),
                if (page > 1) page - 1 else null,
                if (page < it.totalPages!!) page + 1 else null
            )
        }

        return LoadResult.Error(Exception())

    }
}