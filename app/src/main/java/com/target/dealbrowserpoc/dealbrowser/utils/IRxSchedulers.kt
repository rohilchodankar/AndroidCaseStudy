package com.target.dealbrowserpoc.dealbrowser.utils

import io.reactivex.Scheduler

interface IRxSchedulers {
  fun main(): Scheduler
  fun io(): Scheduler
}