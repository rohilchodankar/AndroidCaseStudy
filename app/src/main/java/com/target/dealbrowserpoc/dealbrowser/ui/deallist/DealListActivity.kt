package com.target.dealbrowserpoc.dealbrowser.ui.deallist

import android.annotation.TargetApi
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.target.dealbrowserpoc.dealbrowser.AppConstants
import com.target.dealbrowserpoc.dealbrowser.AppConstants.GRID
import com.target.dealbrowserpoc.dealbrowser.AppConstants.LIST
import com.target.dealbrowserpoc.dealbrowser.R
import com.target.dealbrowserpoc.dealbrowser.data.models.Deal
import com.target.dealbrowserpoc.dealbrowser.databinding.ActivityDealListBinding
import com.target.dealbrowserpoc.dealbrowser.ui.base.BaseActivity
import com.target.dealbrowserpoc.dealbrowser.ui.dealdetails.DealDetailsActivity
import com.target.dealbrowserpoc.dealbrowser.ui.decorators.SimpleDividerItemDecoration
import com.target.dealbrowserpoc.dealbrowser.ui.decorators.SpacesItemDecoration
import javax.inject.Inject

class DealListActivity : BaseActivity<ActivityDealListBinding, DealListActivityViewModel>(),DealListAdapter.DealAdapterCallback {

  @Inject
  lateinit var dealListAdapter: DealListAdapter

  override fun getViewModelClass(): Class<DealListActivityViewModel> {
    return DealListActivityViewModel::class.java
  }

  override fun layoutId() = R.layout.activity_deal_list


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.loadDeals()
    viewModel.dealMetaData.observe(this, Observer { dealMetaData ->
      dealMetaData?.let {
        dealListAdapter.dealList = dealMetaData.deal
        dealListAdapter.dealAdapterCallback =  this
        dealListAdapter.notifyDataSetChanged()
      }
    })

    viewModel.progressIndicatorState.observe(this, Observer {
      it?.let {
        binding.show = it
      }
    })
    determineDealContentStyle()
  }


  private fun showDetailsListViewVertical(){
    binding.recyclerDetailsList.let {
      it.layoutManager = LinearLayoutManager(this)
      it.addItemDecoration(SimpleDividerItemDecoration(this))
      it.adapter = dealListAdapter

    }
  }

  private fun showDetailsListViewGrid(){
    binding.recyclerDetailsList.let {
      it.layoutManager = GridLayoutManager(this,2)
      it.addItemDecoration(SpacesItemDecoration(10))
      it.adapter = dealListAdapter

    }
  }


  @TargetApi(VERSION_CODES.LOLLIPOP)
  override fun navigateToDealDetails(deal: Deal,imageView: ImageView) {
    val intent = Intent(this,DealDetailsActivity::class.java)
    intent.putExtra(AppConstants.INTENT_EXTRA_DEAL,deal)
    if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
      val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, imageView.transitionName).toBundle()
      startActivity(intent,options)
    } else {
      startActivity(intent)
    }
  }


  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
     menuInflater.inflate(R.menu.menu_main,menu)
     menu?.let {
      val styleMenu = it.findItem(R.id.action_content_style)
       if(viewModel.prefsUtils.userContentStylePreferences == GRID)
         setMenuIcon(styleMenu,R.drawable.list)
       else
         setMenuIcon(styleMenu,R.drawable.grid)
     }
     return true
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    return when(item?.itemId){
      R.id.action_content_style -> {
        if(viewModel.prefsUtils.userContentStylePreferences == GRID){
          viewModel.prefsUtils.userContentStylePreferences = LIST
          setMenuIcon(item!!,R.drawable.list)
        }else {
              viewModel.prefsUtils.userContentStylePreferences = GRID
              setMenuIcon(item!!,R.drawable.grid)
        }
        invalidateOptionsMenu()
        determineDealContentStyle()

        return true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun determineDealContentStyle(){
    if(viewModel.prefsUtils.userContentStylePreferences == LIST){
      showDetailsListViewVertical()
    }else{
      showDetailsListViewGrid()
    }
  }

  private fun setMenuIcon(menuItem: MenuItem,drawableId : Int){
    menuItem.setIcon(drawableId)
  }
}
