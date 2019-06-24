package aleksandar.moviesdatabase.listeners;

import android.view.View;

public interface OnMovieClickListener {

        public void onMovieClick(View view, int position);

        public void onFavourite(View view);
}
