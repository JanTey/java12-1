package ru.netology.quamid59.java12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovieManagerTest {
    private MovieManager movieManager;
    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    public void setUp() {
        movieManager = new MovieManager();
        movie1 = mock(Movie.class);
        movie2 = mock(Movie.class);
    }


    @Test
    public void testAdd() {
        // Вызываем метод add() на movieManager с передачей movie1 и movie2
        movieManager.add(movie1);
        movieManager.add(movie2);

        // Проверяем, что массив movies в movieManager содержит movie1 и movie2
        assertArrayEquals(new Movie[]{movie1, movie2}, movieManager.getMovies());
    }

    @Test
    public void testFindLastWithMoreMoviesThanCount() {
        // Создаем массив из 15 заглушек Movie
        Movie[] movies = new Movie[15];
        for (int i = 0; i < 15; i++) {
            movies[i] = mock(Movie.class);
            movieManager.add(movies[i]);
        }

        // Устанавливаем значение countMovies в 10
        movieManager.setCountMovies(10);

        // Мокируем вызов метода getMovieName() на каждом объекте Movie в массиве movies,
        // чтобы возвращалось значение "Movie i" для каждого объекта, где i - индекс элемента в массиве
        for (int i = 0; i < movies.length; i++) {
            when(movies[i].getMovieName()).thenReturn("Movie " + i);
        }

        // Вызываем метод findLast() на movieManager
        movieManager.findLast();

        // Проверяем, что метод getMoviesReverse() возвращает массив movies с ожидаемыми значениями
        // assertArrayEquals(new Movie[]{movies[14], movies[13], movies[12], movies[11], movies[10], movies[9], movies[8], movies[7], movies[6], movies[5]}, movieManager.getMoviesReverse());
        assertArrayEquals(new Movie[]{movies[14], movies[13], movies[12], movies[11], movies[10], movies[9], movies[8], movies[7], movies[6], movies[5]}, movieManager.getMovies());
    }

    //
    @Test
    public void testFindLastWithLessMoviesThanCount() {
        // Создаем массив из 8 заглушек Movie
        Movie[] movies = new Movie[8];
        for (int i = 0; i < 8; i++) {
            movies[i] = mock(Movie.class);
            movieManager.add(movies[i]);
        }

        // Устанавливаем значение countMovies в 10
        movieManager.setCountMovies(10);

        // Мокируем вызов метода getMovieName() на каждом объекте Movie в массиве movies,
        // чтобы возвращалось значение "Movie i" для каждого объекта, где i - индекс элемента в массиве
        for (int i = 0; i < movies.length; i++) {
            when(movies[i].getMovieName()).thenReturn("Movie " + i);
        }

        // Вызываем метод findLast() на movieManager
        movieManager.findLast();

        // Проверяем, что метод getMoviesReverse() возвращает массив movies с ожидаемыми значениями
        //  assertArrayEquals(new Movie[]{movies[7], movies[6], movies[5], movies[4], movies[3], movies[2], movies[1], movies[0]}, movieManager.getMoviesReverse());
        assertArrayEquals(new Movie[]{movies[7], movies[6], movies[5], movies[4], movies[3], movies[2], movies[1], movies[0]}, movieManager.getMovies());
    }

    //
    @Test
    public void testMovieManagerConstructor() {
        // Проверяем, что поле countMovies устанавливается правильно в конструкторе
        movieManager = Mockito.spy(new MovieManager(5));
        assertEquals(5, movieManager.getCountMovies());
    }

    @Test
    public void testSetMovies() {
        // Создаем заглушки (mock) объектов класса Movie
        Movie movie1 = Mockito.mock(Movie.class);
        Movie movie2 = Mockito.mock(Movie.class);
        Movie[] movies = {movie1, movie2};

        // Устанавливаем массив movies в movieManager с использованием метода setMovies()
        movieManager.setMovies(movies);

        // Проверяем, что массив movies в movieManager установлен правильно
        assertArrayEquals(movies, movieManager.getMovies());
    }

    //  @Test
    //  public void testSetMoviesReverse() {
    // Создаем заглушки (mock) объектов класса Movie
    //       Movie movie1 = Mockito.mock(Movie.class);
    //      Movie movie2 = Mockito.mock(Movie.class);
    //       Movie[] moviesReverse = {movie1, movie2};

    // Устанавливаем массив фильмов в обратном порядке в movieManager с использованием метода setMoviesReverse()
    //     movieManager.setMoviesReverse(moviesReverse);

    // Проверяем, что массив фильмов в movieManager установлен правильно
    //      assertArrayEquals(moviesReverse, movieManager.getMoviesReverse());
    //   }

    @Test
    public void testFindAll() {
        // Создаем mock-объекты для класса Movie
        Movie[] movies = new Movie[5];
        for (int i = 0; i < 5; i++) {
            movies[i] = Mockito.mock(Movie.class);
            movieManager.add(movies[i]);
        }

        // Устанавливаем массив фильмов в обратном порядке в movieManager
        //   movieManager.setMoviesReverse(movies);
        movieManager.setMovies(movies);

        // Проверяем, что метод findAll() возвращает пустой массив фильмов
        assertArrayEquals(new Movie[0], movieManager.findAll());
    }

    @Test
    public void testGetId() {
        // Создаем заглушку (mock) объекта класса Movie
        Movie movie = mock(Movie.class);

        // Устанавливаем поведение заглушки
        when(movie.getId()).thenReturn(1);

        // Проверяем, что метод getId() возвращает ожидаемое значение
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
        // Создаем заглушку (mock) объекта класса Movie
        Movie movie = mock(Movie.class);

        // Устанавливаем поведение заглушки
        when(movie.getMovieName()).thenReturn("The Godfather");

        // Вызываем метод getMovieName() на заглушке
        String movieName = movie.getMovieName();

        // Проверяем, что метод getMovieName() возвращает ожидаемое значение
        assertEquals("The Godfather", movieName);
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

    ///////

    @Test
    public void testFindLastReturnsCountMovies() {
        // Arrange
        MovieManager movieManager = new MovieManager(2);
        Movie movie1 = new Movie(1, "Movie 1");
        Movie movie2 = new Movie(2, "Movie 2");
        movieManager.add(movie1);
        movieManager.add(movie2);

        // Act
        Movie[] result = movieManager.findLast();

        // Assert
        assertArrayEquals(new Movie[]{movie2, movie1}, result);
    }

    @Test
    public void testFindLastReturnsAllMoviesIfCountMoviesIsGreaterThanMoviesLength() {
        // Arrange
        MovieManager movieManager = new MovieManager(3);
        Movie movie1 = new Movie(1, "Movie 1");
        Movie movie2 = new Movie(2, "Movie 2");
        movieManager.add(movie1);
        movieManager.add(movie2);

        // Act
        Movie[] result = movieManager.findLast();

        // Assert
        assertArrayEquals(new Movie[]{movie2, movie1}, result);
    }

    @Test
    public void testFindLastReturnsEmptyArrayIfMoviesIsEmpty() {
        // Arrange
        MovieManager movieManager = new MovieManager(3);

        // Act
        Movie[] result = movieManager.findLast();

        // Assert
        assertArrayEquals(new Movie[0], result);
    }

    @Test
    public void testFindLastReturnsAllMoviesIfCountMoviesIsGreaterThanMoviesLength2() {
        // Arrange
        MovieManager movieManager = new MovieManager(3);
        Movie movie1 = new Movie(1, "Movie 1");
        Movie movie2 = new Movie(2, "Movie 2");
        movieManager.add(movie1);
        movieManager.add(movie2);

        // Act
        movieManager.setCountMovies(4);
        Movie[] result = movieManager.findLast();

        // Assert
        assertArrayEquals(new Movie[]{movie2, movie1}, result);
    }

}
