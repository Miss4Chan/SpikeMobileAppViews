package pt.ipleira.firstdemoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import pt.ipleira.firstdemoapp.databinding.FragmentLandingBinding

class LandingFragment : Fragment() {

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLandingBinding.inflate(inflater, container, false)

        viewModel.playedGames.observe(viewLifecycleOwner) { played ->
            updateGameStats(binding, played, viewModel.wonGames.value ?: 0)
        }

        viewModel.wonGames.observe(viewLifecycleOwner) { won ->
            updateGameStats(binding, viewModel.playedGames.value ?: 0, won)
        }

        binding.playButton.setOnClickListener {
            viewModel.incrementPlayedGames()
            // Navigate to the game fragment
            findNavController().navigate(R.id.action_landingFragment_to_gameFragment)
        }

        return binding.root
    }

    private fun updateGameStats(binding: FragmentLandingBinding, played: Int, won: Int) {
        binding.gameStats.text = "Played games: $played | Won games: $won"
    }
}