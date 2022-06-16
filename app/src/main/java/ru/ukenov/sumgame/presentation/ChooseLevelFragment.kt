package ru.ukenov.sumgame.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.ukenov.sumgame.databinding.FragmentChooseLevelBinding
import ru.ukenov.sumgame.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binging
        get() = _binding
            ?: throw RuntimeException("ChooseLevelFragment: FragmentChooseLevelBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binging.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binging) {
            buttonLevelTest.setOnClickListener { onSelectLevel(level = Level.TEST) }
            buttonLevelEasy.setOnClickListener { onSelectLevel(level = Level.EASY) }
            buttonLevelNormal.setOnClickListener { onSelectLevel(level = Level.NORMAL) }
            buttonLevelHard.setOnClickListener { onSelectLevel(level = Level.HARD) }
        }
    }

    private fun onSelectLevel(level: Level) {

        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(
                level
            )
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
