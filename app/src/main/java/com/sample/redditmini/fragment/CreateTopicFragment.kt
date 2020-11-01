package com.sample.redditmini.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.sample.redditmini.R
import com.sample.redditmini.databinding.FragmentCreateTopicBinding
import com.sample.redditmini.model.Topic
import com.sample.redditmini.util.BaseFragment
import com.sample.redditmini.util.hideKeyboard
import com.sample.redditmini.viewModel.CreateTopicViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CreateTopicFragment: BaseFragment<FragmentCreateTopicBinding>() {
    override fun getLayoutParams(): Int = R.layout.fragment_create_topic

    private val viewModel: CreateTopicViewModel by viewModel()
    private var position = 0
    private var allTopics = ArrayList<Topic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_clear_24px)
        (activity as? AppCompatActivity)?.supportActionBar?.title = getString(R.string.save)

        arguments?.let {
            position = it.getInt("size")
            allTopics = it.getParcelableArrayList<Topic>("topics") as ArrayList<Topic>
        }

        binding?.let {
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_post, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
            R.id.action_post -> {
                return if (viewModel.title.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), R.string.title_empty_error, Toast.LENGTH_LONG)
                        .show()
                    false
                } else{
                    view?.hideKeyboard()
                    allTopics.add(viewModel.saveTopic(position))
                    val action = CreateTopicFragmentDirections.actionCreateFragmentToHomeFragment(allTopics.toTypedArray())
                    findNavController().navigate(action)
                    true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}