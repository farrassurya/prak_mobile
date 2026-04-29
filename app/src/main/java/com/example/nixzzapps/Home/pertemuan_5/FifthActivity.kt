package com.example.nixzzapps.Home.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.nixzzapps.R
import com.example.nixzzapps.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ==========================================
        // MULAI IMPROVISASI: INISIALISASI TOOLBAR
        // ==========================================
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        // ==========================================
        // AKHIR IMPROVISASI
        // ==========================================

        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        // ==========================================
        // MULAI IMPROVISASI: KONFIGURASI SEARCHVIEW
        // ==========================================
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as? SearchView
        searchView?.queryHint = "Cari sesuatu..."
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@FifthActivity, "Mencari: $query", Toast.LENGTH_SHORT).show()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        // ==========================================
        // AKHIR IMPROVISASI
        // ==========================================

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // ==========================================
        // MULAI IMPROVISASI: HANDLING OPTION MENU
        // ==========================================
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_share -> {
                Toast.makeText(this, "Membuka Menu Berbagi...", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_profile -> {
                Toast.makeText(this, "Membuka Profil Pengguna", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "Aplikasi Nixzz Versi 1.0", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout -> {
                Toast.makeText(this, "Anda telah keluar", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        // ==========================================
        // AKHIR IMPROVISASI
        // ==========================================
    }
}
