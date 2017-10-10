package com.example.trungnguyen.labuit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.trungnguyen.labuit.helper.ConstantHelper
import com.example.trungnguyen.labuit.R
import com.example.trungnguyen.labuit.adapter.DishAdapter
import com.example.trungnguyen.labuit.adapter.ThumbnailAdapter
import com.example.trungnguyen.labuit.bean.Dish
import com.example.trungnguyen.labuit.bean.Thumbnail


class GridViewActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemLongClickListener {

    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long): Boolean {
        removeFoodDish(position)
        return false
    }

    override fun onClick(p0: View?) {
        addNewFoodDish()
    }

    private fun addNewFoodDish() {
        val name = etMonAn?.text.toString()
        val isPromotion = cbPromotion?.isChecked
        val chosenThumbnail = spThumbnail?.selectedItemPosition
        if (name.isEmpty()) {
            ConstantHelper.showToast(this, "Vui lòng nhập đầy đủ thông tin")
            return
        }
        mDataList.add(Dish((mThumbnailArray[chosenThumbnail!!].resId), subDishName(name), isPromotion!!))
        mFoodAdapter.notifyDataSetChanged()
        etMonAn?.setText("")
        cbPromotion?.isChecked = false
        spThumbnail?.setSelection(0)
    }

    private fun removeFoodDish(position: Int) {
        mDataList.removeAt(position)
        mFoodAdapter.notifyDataSetChanged()
    }

    private fun subDishName(name: String): String {
        return if (name.length > ConstantHelper.SUB_STRING_INDEX)
            name.substring(0, ConstantHelper.SUB_STRING_INDEX) + "..."
        else name
    }

    private var mDataList: ArrayList<Dish> = ArrayList()
    private var etMonAn: EditText? = null
    private var spThumbnail: Spinner? = null
    private var cbPromotion: CheckBox? = null
    private var gvFood: GridView? = null
    private val mThumbnailArray = arrayOf(Thumbnail.THUMBNAIL_1, Thumbnail.THUMBNAIL_2,
            Thumbnail.THUMBNAIL_3, Thumbnail.THUMBNAIL_4)
    private var mFoodAdapter = DishAdapter(this, mDataList)

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
        etMonAn = findViewById(R.id.etMonAn)
        spThumbnail = findViewById(R.id.spThumbnail)
        cbPromotion = findViewById(R.id.cbPromotion)
        gvFood = findViewById(R.id.gvMonAn)
    }
}
