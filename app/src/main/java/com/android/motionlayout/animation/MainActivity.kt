package com.android.motionlayout.animation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var doShowPaths = false

    private val dataset: Array<DemosAdapter.Demo> = arrayOf(
        DemosAdapter.Demo(
            "Basic Example (1/3)",
            "Basic motion example using referenced ConstraintLayout files",
            R.layout.motion_01_basic
        ),
        DemosAdapter.Demo(
            "底部菜单",
            "滑动弹出底部菜单",
            R.layout.drawlayout_01
        ),
        DemosAdapter.Demo(
            "折叠按钮",
            "折叠按钮",
            R.layout.motion_03
        ),
        DemosAdapter.Demo(
            "折叠按钮02",
            "折叠按钮02",
            R.layout.motion_04
        ),
        DemosAdapter.Demo(
            "折叠按钮03",
            "折叠按钮03",
            R.layout.motion_05
        ),
        DemosAdapter.Demo(
            "登录按钮",
            "带加载进度的登录按钮",
            R.layout.motion_06
        ),
        DemosAdapter.Demo(
            "折叠菜单",
            "折叠菜单",
            R.layout.motion_07
        ),
        DemosAdapter.Demo(
            "折叠抽屉",
            "折叠抽屉",
            R.layout.motion_08
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewManager = LinearLayoutManager(this)
        viewAdapter = DemosAdapter(dataset)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        showPaths.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(p0: CompoundButton?, value: Boolean) {
        doShowPaths = value
    }

    fun start(activity: Class<*>, layoutFileId: Int) {
        val intent = Intent(this, activity).apply {
            putExtra("layout_file_id", layoutFileId)
            putExtra("showPaths", doShowPaths)
        }
        startActivity(intent)
    }
}