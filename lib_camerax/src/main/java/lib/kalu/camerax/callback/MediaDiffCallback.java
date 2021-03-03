package lib.kalu.camerax.callback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import lib.kalu.camerax.model.MediaModel;

public class MediaDiffCallback extends DiffUtil.ItemCallback<MediaModel> {

    @Override
    public boolean areItemsTheSame(@NonNull MediaModel oldItem, @NonNull MediaModel newItem) {
        String olds = oldItem.getUri().getPath();
        String news = newItem.getUri().getPath();
        return null != olds && olds.length() > 0 && null != news & news.length() > 0 && olds.equals(news);
    }

    @Override
    public boolean areContentsTheSame(@NonNull MediaModel oldItem, @NonNull MediaModel newItem) {
        String olds = oldItem.getUri().getPath();
        String news = newItem.getUri().getPath();
        return null != olds && olds.length() > 0 && null != news & news.length() > 0 && olds.equals(news);
    }
}
