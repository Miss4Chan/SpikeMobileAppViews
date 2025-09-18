package pt.ipleira.firstdemoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import pt.ipleira.firstdemoapp.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGameBinding.inflate(inflater, container, false)

        binding.toggleButton1.setOnCheckedChangeListener { _, isChecked1 ->
            val isChecked2 = binding.toggleButton2.isChecked
            if (isChecked1 && isChecked2) {
                viewModel.incrementWonGames()
                findNavController().popBackStack()
            }
        }

        binding.toggleButton2.setOnCheckedChangeListener { _, isChecked2 ->
            val isChecked1 = binding.toggleButton1.isChecked
            if (isChecked1 && isChecked2) {
                viewModel.incrementWonGames()
                findNavController().popBackStack()
            }
        }

        return binding.root
    }
}