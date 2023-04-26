package ru.netology.quamid59.java12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager movieManager;

    @BeforeEach
    public void setUp() {
        movieManager = new MovieManager();
    }

    @Test
    public void testAdd() {
        Movie movie1 = new Movie(1, "The Godfather");
        Movie movie2 = new Movie(2, "The Shawshank Redemption");
        movieManager.add(movie1);
        movieManager.add(movie2);
        assertArrayEquals(new Movie[]{movie1, movie2}, movieManager.getMovies());
    }

    @Test
    public void testFindLastWithMoreMoviesThanCount() {
        Movie[] movies = new Movie[15];
        for (int i = 0; i < 15; i++) {
            movies[i] = new Movie(i + 1, "Movie " + (i + 1));
            movieManager.add(movies[i]);
        }
        movieManager.setCountMovies(10);
        movieManager.findLast();
        assertArrayEquals(new Movie[]{movies[14], movies[13], movies[12], movies[11], movies[10], movies[9], movies[8], movies[7], movies[6], movies[5]}, movieManager.getMoviesReverse());
    }

    //
    @Test
    public void testFindLastWithLessMoviesThanCount() {
        Movie[] movies = new Movie[8];
        for (int i = 0; i < 8; i++) {
            movies[i] = new Movie(i + 1, "Movie " + (i + 1));
            movieManager.add(movies[i]);
        }
        movieManager.setCountMovies(10);
        movieManager.findLast();
        assertArrayEquals(new Movie[]{movies[7], movies[6], movies[5], movies[4], movies[3], movies[2], movies[1], movies[0]}, movieManager.getMoviesReverse());
    }

    //
    @Test
    public void testMovieManagerConstructor() {
        // Check that the countMovies field is set correctly in the constructor
        movieManager = new MovieManager(5);
        assertEquals(5, movieManager.getCountMovies());
    }

    @Test
    public void testSetMovies() {
        Movie movie1 = new Movie(1, "The Godfather");
        Movie movie2 = new Movie(2, "The Shawshank Redemption");
        Movie[] movies = {movie1, movie2};
        movieManager.setMovies(movies);
        assertArrayEquals(movies, movieManager.getMovies());
    }

    @Test
    public void testSetMoviesReverse() {
        Movie movie1 = new Movie(1, "The Godfather");
        Movie movie2 = new Movie(2, "The Shawshank Redemption");
        Movie[] moviesReverse = {movie1, movie2};
        movieManager.setMoviesReverse(moviesReverse);
        assertArrayEquals(moviesReverse, movieManager.getMoviesReverse());
    }

    @Test
    public void testFindAll() {
        // Тестирование метода findAll()
        Movie[] movies = new Movie[5];
        for (int i = 0; i < 5; i++) {
            movies[i] = new Movie(i + 1, "Movie " + (i + 1));
            movieManager.add(movies[i]);
        }
        movieManager.setMoviesReverse(movies);
        assertArrayEquals(new Movie[0], movieManager.findAll());
    }

    @Test
    public void testGetId() {
        // Тестирование метода getId()
        Movie movie = new Movie(1, "The Godfather");
        assertEquals(1, movie.getId());
    }

    @Test
    public void testSetId() {
        // Тестирование метода setId(int id)
        Movie movie = new Movie("M1", "The Godfather");
        movie.setId(1);
        assertEquals(1, movie.getId());
    }

    @Test
    public void testGetMovieName() {
        // Тестирование метода getMovieName()
        Movie movie = new Movie(1, "The Godfather");
        assertEquals("The Godfather", movie.getMovieName());
    }

    @Test
    public void testSetMovieName() {
        // Тестирование метода setMovieName(String movieName)
        Movie movie = new Movie(1, "The Godfather");
        movie.setMovieName("The Shawshank Redemption");
        assertEquals("The Shawshank Redemption", movie.getMovieName());
    }

    @Test
    public void testGet() {
        // Создаем объект Movie
        Movie movie = new Movie(1, "The Godfather");

        // Проверяем, что метод get() возвращает корректное значение поля id
        assertEquals(1, movie.get());
    }

}

