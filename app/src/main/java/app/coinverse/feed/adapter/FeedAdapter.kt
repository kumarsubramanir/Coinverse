package app.coinverse.feed.adapter

import android.view.LayoutInflater.from
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.coinverse.R.id.*
import app.coinverse.databinding.CellContentBinding.inflate
import app.coinverse.feed.models.Content
import app.coinverse.feed.models.FeedViewEventType.*
import app.coinverse.feed.models.FeedViewEvents
import app.coinverse.feed.viewmodel.FeedViewModel
import app.coinverse.utils.ADAPTER_POSITION_KEY
import kotlinx.android.synthetic.main.cell_content.view.*

private val LOG_TAG = FeedAdapter::class.java.simpleName

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Content>() {
    override fun areItemsTheSame(oldContent: Content, newContent: Content): Boolean =
            oldContent.id == newContent.id

    override fun areContentsTheSame(oldContent: Content, newContent: Content): Boolean =
            oldContent == newContent
}

class FeedAdapter(val feedViewModel: FeedViewModel, val viewEvents: FeedViewEvents)
    : PagedListAdapter<Content, FeedAdapter.ViewHolder>(DIFF_CALLBACK) {

    /**
     * Observe [ContentSelected] event in View in order to calculate [app.coinverse.feed.ContentFragment.getAdapterPosition].
     */
    val contentSelected: LiveData<ContentSelected> get() = _contentSelected
    private val _contentSelected = MutableLiveData<ContentSelected>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(inflate(from(parent.context), parent, false).apply {
                this.viewmodel = feedViewModel
            })

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { content ->
            if (content != null) holder.bind(createOnClickListener(content), content)
        }
    }

    private fun createOnClickListener(content: Content) = OnClickListener { view ->
        when (view.id) {
            preview, contentTypeLogo ->
                _contentSelected.value = ContentSelected(view.getTag(ADAPTER_POSITION_KEY) as Int, content)
            share -> viewEvents.contentShared(ContentShared(content))
            openSource -> viewEvents.contentSourceOpened(ContentSourceOpened(content.url))
        }
    }

    fun getContent(position: Int) = getItem(position)

    class ViewHolder(private var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(onClickListener: OnClickListener, data: Any) {
            binding.setVariable(BR.data, data)
            binding.setVariable(BR.clickListener, onClickListener)
            binding.root.preview.setTag(ADAPTER_POSITION_KEY, layoutPosition)
            binding.root.contentTypeLogo.setTag(ADAPTER_POSITION_KEY, layoutPosition)
            binding.executePendingBindings()
        }
    }
}