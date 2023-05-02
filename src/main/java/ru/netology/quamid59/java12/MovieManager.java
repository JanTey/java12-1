package ru.netology.quamid59.java12;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    //private Movie[] moviesReverse = new Movie[0];
    private int countMovies = 5;//счетчик кол-ва выводимых фильмов для метода findLast

    public MovieManager() {
    }

    public MovieManager(int countMovies) {
        this.countMovies = countMovies;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public int getCountMovies() {
        return countMovies;
    }

    public void setCountMovies(int countMovies) {
        this.countMovies = countMovies;
    }

    //добавление фильма в конец массива
    public void add(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[movies.length] = movie;
        movies = tmp;
    }

    //вывод всех фильмов в порядке добавления
    public Movie[] findAll() {
        getMovies();
        return new Movie[0];
    }

    //вывод n фильмов в обратном порядке (по умолчанию n = 5)
    // public void findLast() {
    //   if (countMovies > movies.length) { //проверка, что n не больше нашего массива с фильмами
    //countMovies =movies.length;

    //   }
    //   Movie[] tmp = new Movie[countMovies];
    //   for (int i = 0, j = movies.length - 1; i < countMovies; i++, j--) {
    //       tmp[i] = movies[j];
    //   }
    //  moviesReverse = tmp;
    //   movies = tmp;
    // }
    public Movie[] findLast() {
        int limit = countMovies;
        if (limit > movies.length) {
            limit = movies.length;
        }
        Movie[] tmp = new Movie[limit];
        //    for (int i = 0, j = movies.length - 1; i < limit; i++, j--) {
        //      tmp[i] = movies[j];
        // }

        for (int i = 0; i < limit; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        movies = tmp;
        return tmp;
    }

}
