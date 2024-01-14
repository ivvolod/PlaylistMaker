package net.ru.ivvolod.playlistmaker

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val trackNameView = itemView.findViewById<TextView>(R.id.trackName) // Название композиции
    private val artistNameView = itemView.findViewById<TextView>(R.id.artistName) // Имя исполнителя
    private val trackTimeView = itemView.findViewById<TextView>(R.id.trackTime) // Продолжительность трека
    private val artworkUrl100View = itemView.findViewById<ImageView>(R.id.artworkUrl100) // Ссылка на изображение обложки

    fun bind(track: Track){
        trackNameView.text = track.trackName
        artistNameView.text = track.artistName
        trackTimeView.text = track.trackTime
        val radius = dpToPx(2f, itemView.context)  // Радиус закругления
        Glide.with(itemView.context)
            .load(track.artworkUrl100)
            .placeholder(R.drawable.ic_launcher_foreground) // Добавление плейсхолдера
            .transform(RoundedCorners(radius)) //Закругление углов загружаемых изображений
            .apply(RequestOptions().fitCenter()) //Масштабирует изображение так, чтобы оно целиком помещалось в ImageView, сохраняя пропорции изображения
            .into(artworkUrl100View)
    }

    companion object{
        fun inflateFrom(parent: ViewGroup): TrackViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemView = layoutInflater.inflate(R.layout.track_view, parent, false)
            return TrackViewHolder(itemView)
        }
    }
    //Функция преобразования dp в px
    private fun dpToPx(dp: Float, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics).toInt()
    }

}