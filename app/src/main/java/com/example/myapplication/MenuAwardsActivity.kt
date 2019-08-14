package com.example.myapplication

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.myapplication.adapter.AwardAdapter
import com.example.myapplication.model.ModelVoucher
import kotlinx.android.synthetic.main.activity_menu_awards.*
import kotlinx.android.synthetic.main.app_bar_menu_awards.*


class MenuAwardsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var arrList:Array<ModelVoucher>
    private val fragment = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_awards)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        setActionBarTitle(getString(R.string.label_awards))

        val recyclerView = findViewById(R.id.listVoucherCards) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val vouchers = ArrayList<ModelVoucher>()
        vouchers.add(ModelVoucher("01","Vouchers","Gift Card IDR 1.000.000",500000))
        vouchers.add(ModelVoucher("02","Vouchers","Gift Card IDR 500.000",250000))
        vouchers.add(ModelVoucher("03","Products","Old Fashion Cake",100000))
        vouchers.add(ModelVoucher("04","Vouchers","Beli Tiket di TIX",200000))
        vouchers.add(ModelVoucher("05","Vouchers","Belanja Hemat Tokopedia",200000))
        vouchers.add(ModelVoucher("06","Vouchers","Discount All MAP Product",200000))
        vouchers.add(ModelVoucher("07","GiftCard","Gift Card IDR 2.000.000",1000000))
        vouchers.add(ModelVoucher("08","GiftCard","Gift Card IDR 5.000.000",2000000))
        vouchers.add(ModelVoucher("09","Products","Old Fashion Cake",100000))
        vouchers.add(ModelVoucher("10","Products","Old Meal Cake",110000))
        vouchers.add(ModelVoucher("11","Products","Old Drink Cake",120000))
        vouchers.add(ModelVoucher("12","Products","Old Fashion Cake",100000))

        val adapterVoucher = AwardAdapter(vouchers)
        recyclerView.adapter = adapterVoucher

        /*val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_awards, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_filter) run {
            val goBackToLogin = Intent(applicationContext, FilterDialog::class.java)
            startActivity(goBackToLogin)
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_home -> {
                setActionBarTitle(getString(R.string.label_awards))

                // Handle the camera action
            }
            R.id.nav_cards -> {
                setActionBarTitle(getString(R.string.label_cards))

            }
            R.id.nav_profile -> {
                setActionBarTitle(getString(R.string.label_profile))

            }
            R.id.nav_logout -> {
                val builder = AlertDialog.Builder(this@MenuAwardsActivity)
                builder.setTitle("Logout")
                builder.setMessage("Are you sure to logout ?")
                builder.setPositiveButton("Yes"){dialog, which ->
                    val goBackToLogin = Intent(applicationContext, MainActivity::class.java)
                    startActivity(goBackToLogin)
                    finish()
                    Toast.makeText(
                        this@MenuAwardsActivity,
                        resources.getString(R.string.info_logout),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                builder.setNegativeButton("No"){dialog,which ->
                    Toast.makeText(applicationContext,"Canceled Logout",Toast.LENGTH_SHORT).show()
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun setActionBarTitle(title: String) {
        supportActionBar!!.title = title
    }
}
