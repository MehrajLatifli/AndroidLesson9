package com.example.androidlesson9

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.androidlesson9.databinding.CustomDialogBinding
import com.example.androidlesson9.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.shashank.sony.fancytoastlib.FancyToast

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            toastMes(requireContext())
        }

        binding.button2.setOnClickListener {
            fancytoastMes(requireContext())
        }

        binding.button3.setOnClickListener {
            alertDialog(requireContext())
        }

        binding.button4.setOnClickListener {
            customAlertDialog(requireContext())
        }

        binding.button5.setOnClickListener {
            Snackbar(requireView())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun toastMes(context: Context) {
        Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show()
    }

    private fun fancytoastMes(context: Context) {
        FancyToast.makeText(context, "Hello World !", FancyToast.LENGTH_LONG, FancyToast.INFO, true).show()
    }

    private fun alertDialog(context: Context) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Info")
        dialog.setMessage("Information")

        dialog.setNegativeButton("No") { _, _ ->
            Toast.makeText(context, "Selected No", Toast.LENGTH_SHORT).show()
        }

        dialog.setPositiveButton("Yes") { _, _ ->
            Toast.makeText(context, "Selected Yes", Toast.LENGTH_SHORT).show()
        }

        dialog.create().show()
    }

    private fun customAlertDialog(context: Context) {

        val dialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(context))
        val dialog = AlertDialog.Builder(context).apply {

            setView(dialogBinding.root)

        }.create()

        dialog.show()

        dialogBinding.button1.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun Snackbar(view: View) {

        com.google.android.material.snackbar.Snackbar.make(view,"Hello world", Snackbar.LENGTH_SHORT).setAction("Yes"){

            toastMes(requireContext())

        }.show()
    }
}
