package lib.kalu.camerax.model;

import android.net.Uri;

import java.io.Serializable;

/**
 * description: 图库数据库数据
 * created by kalu on 2021-03-03
 */
public final class MediaModel implements Serializable {

    private Uri uri;
    private long date;
    private boolean isVideo;

    public MediaModel() {
    }

    public MediaModel(Uri uri, long date, boolean isVideo) {
        this.uri = uri;
        this.date = date;
        this.isVideo = isVideo;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}
