package net.ru.ivvolod.playlistmaker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TrackAdapter (private val tracks: List<Track>) : RecyclerView.Adapter<TrackViewHolder>() {
    private var filteredTracks: List<Track> = tracks
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        return TrackViewHolder.inflateFrom(parent)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(filteredTracks[position])
    }

    override fun getItemCount(): Int {
        return filteredTracks.size
    }
    fun filterTracks(searchText: String) {
        filteredTracks = if (searchText.isEmpty()) {
            tracks
        } else {
            tracks.filter {
                it.trackName.contains(searchText, ignoreCase = true) || it.artistName.contains(searchText, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }
}