package com.example.fishermanhandbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    var navView: NavigationView? = null
    var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)

        navView = findViewById(R.id.nav_view)
        navView?.setNavigationItemSelectedListener(this)

        val myRcView = findViewById<RecyclerView>(R.id.myRcView)
        myRcView.hasFixedSize()
        myRcView.layoutManager = LinearLayoutManager(this)

        //Создаем список элементов для адаптера
        var list = ArrayList<ListItem>()
        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_content),
                getImageId(R.array.fish_image_array)
            )
        )
        adapter = MyAdapter(list, this)
        myRcView.adapter = adapter
    }

    //Реализуем слушатели для каждой позиции меню
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_fish -> {
                Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.fish),
                        resources.getStringArray(R.array.fish_content),
                        getImageId(R.array.fish_image_array)
                    )
                )
            }
            R.id.id_na -> {
                Toast.makeText(this, "Id na", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.bait),
                        resources.getStringArray(R.array.bait_content),
                        getImageId(R.array.bait_image_array)
                    )
                )
            }
            R.id.id_sna -> {
                Toast.makeText(this, "Id sna", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.fishingGear),
                        resources.getStringArray(R.array.fishingGear_content),
                        getImageId(R.array.fishingGear_image_array)
                    )
                )
            }
            R.id.id_history -> {
                Toast.makeText(this, "Id history", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.history),
                        resources.getStringArray(R.array.history_content),
                        getImageId(R.array.history_image_array)
                    )
                )
            }
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }


    //Заполняем List для Adapter'а из элементов массивов нашего ресурса array.xml
    fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (n in titleArray.indices) {
            var newListItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(newListItem)
        }
        return listItemArray
    }

    // Конвертер значений типа: @drawable/som в Int значения
    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}