package app.coinverse.content.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.coinverse.Enums.ContentType
import app.coinverse.Enums.FeedType
import com.google.firebase.Timestamp
import java.util.*

@Entity(tableName = "content")
data class Content(@PrimaryKey var id: String, var qualityScore: Double,
                   var contentType: ContentType, var timestamp: Timestamp, var creator: String,
                   var title: String, var previewImage: String, var description: String,
                   var url: String, var textUrl: String, var audioUrl: String, var feedType: FeedType,
                   var loadingStatus: Boolean, var savedPosition: Int, var viewCount: Double,
                   var startCount: Double, var consumeCount: Double, var finishCount: Double,
                   var organizeCount: Double, var shareCount: Double, var clearFeedCount: Double,
                   var dismissCount: Double) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readDouble(),
            ContentType.values()[parcel.readInt()],
            Timestamp((Date(parcel.readLong()))),
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            FeedType.values()[parcel.readInt()],
            parcel.readBoolean(),
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readDouble())

    constructor() : this("", 0.0, ContentType.NONE, Timestamp.now(), "",
            "", "", "", "", "", "", FeedType.NONE,
            false, 0, 0.0, 0.0, 0.0,
            0.0, 0.0, 0.0, 0.0, 0.0)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeDouble(qualityScore)
        parcel.writeInt(contentType.ordinal)
        parcel.writeLong(timestamp.toDate().time)
        parcel.writeString(creator)
        parcel.writeString(title)
        parcel.writeString(previewImage)
        parcel.writeString(description)
        parcel.writeString(url)
        parcel.writeString(textUrl)
        parcel.writeString(audioUrl)
        parcel.writeInt(feedType.ordinal)
        parcel.writeBoolean(loadingStatus)
        parcel.writeInt(savedPosition)
        parcel.writeDouble(viewCount)
        parcel.writeDouble(startCount)
        parcel.writeDouble(consumeCount)
        parcel.writeDouble(finishCount)
        parcel.writeDouble(organizeCount)
        parcel.writeDouble(shareCount)
        parcel.writeDouble(clearFeedCount)
        parcel.writeDouble(dismissCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Content> {
        override fun createFromParcel(parcel: Parcel): Content {
            return Content(parcel)
        }

        override fun newArray(size: Int): Array<Content?> {
            return arrayOfNulls(size)
        }

        fun Parcel.readBoolean() = readInt() != 0

        fun Parcel.writeBoolean(value: Boolean) = writeInt(if (value) 1 else 0)

    }
}