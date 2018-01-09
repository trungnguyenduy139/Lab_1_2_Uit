package com.example.trungnguyen.labuit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.trungnguyen.labuit.R
import com.example.trungnguyen.labuit.adapter.DishAdapter
import com.example.trungnguyen.labuit.adapter.ThumbnailAdapter
import com.example.trungnguyen.labuit.bean.Dish
import com.example.trungnguyen.labuit.bean.Thumbnail
import com.example.trungnguyen.labuit.helper.UtilHelper


class GridViewActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemLongClickListener {

    private val mDataList: ArrayList<Dish> = ArrayList()
    private var etFood: EditText? = null
    private var spThumbnail: Spinner? = null
    private var cbPromotion: CheckBox? = null
    private var gvFood: GridView? = null
    private val mFoodAdapter = DishAdapter(this, mDataList)

    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long): Boolean {
        removeFoodDish(position)
        return false
    }

    override fun onClick(p0: View?) {
        addNewFoodDish()
    }

    private fun addNewFoodDish() {
        val name = etFood?.text.toString()
        val isPromotion = cbPromotion?.isChecked
        val tempObj = spThumbnail?.selectedItem
        val chosenThumbnail: Thumbnail?
        if (tempObj is Thumbnail)
            chosenThumbnail = tempObj as Thumbnail
        else return
        if (name.isEmpty()) {
            UtilHelper.showMsg(this, "Vui lòng nhập đầy đủ thông tin")
            return
        }
        mDataList.add(Dish(chosenThumbnail.resId, name, isPromotion!!))
        mFoodAdapter.notifyDataSetChanged()
        etFood?.setText("")
        cbPromotion?.isChecked = false
        spThumbnail?.setSelection(0)
    }

    private fun removeFoodDish(position: Int) {
        if (position < 0) return
        mDataList.removeAt(position)
        mFoodAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        initViews()
        setupAdapter()
    }

    private fun setupAdapter() {
        val thumbnailAdapter = ThumbnailAdapter(this, R.layout.item_thubnail,
                arrayOf(Thumbnail.THUMBNAIL_1, Thumbnail.THUMBNAIL_2,
                        Thumbnail.THUMBNAIL_3, Thumbnail.THUMBNAIL_4))
        spThumbnail?.adapter = thumbnailAdapter
        val btAdd = findViewById<Button>(R.id.btAddThumb)
        btAdd.setOnClickListener(this)
        gvFood?.onItemLongClickListener = this
        gvFood?.adapter = mFoodAdapter
    }

    private fun initViews() {
        etFood = findViewById(R.id.etMonAn)
        spThumbnail = findViewById(R.id.spThumbnail)
        cbPromotion = findViewById(R.id.cbPromotion)
        gvFood = findViewById(R.id.gvMonAn)
    }
}
