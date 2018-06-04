package com.target.dealbrowserpoc.dealbrowser.data.services

import com.target.dealbrowserpoc.dealbrowser.data.models.DealMetaData
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by rohilchodankar on 6/3/18.
 */
interface DealService {
  @GET("api/deals")
  fun getDealsList(): Single<DealMetaData>
}