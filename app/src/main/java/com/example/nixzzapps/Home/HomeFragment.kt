package com.example.nixzzapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.nixzzapps.AuthActivity
import com.example.nixzzapps.Home.Pertemuan_9.NinthActivity
import com.example.nixzzapps.Home.pertemuan_10.TenthActivity
import com.example.nixzzapps.Home.pertemuan_13.ThirteenthActivity
import com.example.nixzzapps.Home.pertemuan_3.ThirdActivity
import com.example.nixzzapps.Home.pertemuan_4.FourthActivity
import com.example.nixzzapps.Home.pertemuan_7.SeventhActivity
import com.example.nixzzapps.R
import com.example.nixzzapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /** Hapus yang lama */
        //return inflater.inflate(R.layout.fragment_message, container, false)
        /** Ganti menjadi versi binding */
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar2)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            startActivity(intent)

            /*tambahkan bagian berikut*/
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)

            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit {
                        clear()
                    }

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()

                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()

        }

        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }
        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToThirteenth.setOnClickListener {
            val intent = Intent(requireContext(), ThirteenthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToThird.setOnClickListener {
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}