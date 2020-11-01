package com.sample.redditmini.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sample.redditmini.R
import com.sample.redditmini.adapter.TopicAdapter
import com.sample.redditmini.databinding.FragmentHomeBinding
import com.sample.redditmini.model.Topic
import com.sample.redditmini.util.BaseFragment
import com.sample.redditmini.viewModel.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment: BaseFragment<FragmentHomeBinding>(), TopicAdapter.TopicAdapterListener {
    override fun getLayoutParams(): Int  = R.layout.fragment_home

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var topicsAdapter:TopicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as? AppCompatActivity)?.supportActionBar?.title =
            getString(R.string.topics)

        topicsAdapter = TopicAdapter(this)

        binding?.let {
            it.viewModel = viewModel
            it.lifecycleOwner = this

            it.rvTopics.adapter = topicsAdapter
        }

        arguments?.let {
            val bundle = HomeFragmentArgs.fromBundle(it)
            if (bundle.toBundle().containsKey("topics")){
                viewModel.allTopics.clear()
                bundle.topics?.let {topics ->
                    viewModel.allTopics.clear()
                    viewModel.allTopics.addAll(topics.toList())
                    topicsAdapter.setData(topics.toList())
                }
            }
            else{
                viewModel.getTopics()
            }
        }?: kotlin.run {
            viewModel.getTopics()
        }

        viewModel.topicSuccessLiveData.observe(viewLifecycleOwner, Observer {topics ->
            viewModel.emptyStateLiveData.value = topics.isNullOrEmpty()
            viewModel.allTopics.clear()
            viewModel.allTopics.addAll(topics)
            topicsAdapter.setData(topics)

        })

        viewModel.topicFailureLiveData.observe(viewLifecycleOwner, Observer {isFailed ->
            isFailed?.let {
                activity?.let {
                    Toast.makeText(it, "Oops! something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_post ->{
                val bundle = Bundle().apply {
                    putInt("size",viewModel.allTopics.size + 1)
                    putParcelableArrayList("topics", viewModel.allTopics)
                }
                findNavController().navigate(R.id.action_homeFragment_to_createFragment,bundle)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onItemClick(item: Topic) {
        val bundle = Bundle().apply {
            putParcelable("topic", item)
        }
        findNavController().navigate(R.id.action_homeFragment_to_viewPostFragment,bundle)
    }

    override fun onUpVote(item: Topic) {
        for (topic in viewModel.allTopics){
            if (item.id == topic.id){
                topic.upVote +=1
                break
            }
        }
        topicsAdapter.setData(viewModel.allTopics)
    }

    override fun onDownVote(item: Topic) {
        for (topic in viewModel.allTopics){
            if (item.id == topic.id){
                topic.downVote -=1
                break
            }
        }
        topicsAdapter.setData(viewModel.allTopics)
    }


}