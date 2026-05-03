# Music Library 🎵

A CLI-based Java application to manage your personal music collection — add songs, create playlists, and search your library from the terminal.

---

## Features

- Add and remove songs from your library
- Create and manage playlists
- Search and filter songs by title, artist, or genre
- Runs fully in the terminal (no GUI)
- Docker support for easy setup

---

## Project Structure

```
├── Dockerfile
├── README.md
└── src
    ├── Artist.java
    ├── Comparator.java
    ├── LibraryUtils.java
    ├── Main.java
    ├── Media.java
    ├── out
    │   ├── Artist.class
    │   ├── LibraryUtils.class
    │   ├── Main.class
    │   ├── Media.class
    │   ├── Playable.class
    │   ├── Playlist.class
    │   ├── PodcastEp.class
    │   ├── Song.class
    │   ├── sortByduration.class
    │   └── sortByreleaseYear.class
    ├── Playable.java
    ├── Playlist.java
    ├── PodcastEp.java
    └── Song.java

```

---

## Getting Started

### Requirements

- Java 17+
- Docker *(optional)*

### Run Locally

```bash
git clone https://github.com/your-username/music-library.git
cd music-library
javac -d out src/*.java
java -cp out Tester
```

### Run with Docker 🐳

```bash
docker build -t music-library . #run from directory
docker run -it music-library
```
### Debuuging from bash in container

```bash
 docker run -it music-library /bin/bash
```

---

## Sample Output:
```
 ________________________________________________________
|   Artist Created                                       |
|________________________________________________________|

 Name                      Country         Followers
 --------------------------------------------------------
 Atif Aslam                Pakistan        230.32M
 Arijit Singh              India           73.00M
 Atif Aslam                Pakistan        1.34M
 Steave                    Unknown         953.34M
 Rahat Fateh Ali Khan      Pakistan        45.08M

 ________________________________________________________
| 9.2  ||  Building heterogeneous ArrayList<Media>       |
|________________________________________________________|


  Songs created:
  #   | Title                                    Artist                                   Genre      Year
 --------------------------------------------------------------------------------------------------------------------------------------------
  1   | Dil Lagi                                 Artist: Rahat Fateh Ali Khan             Sad        2019
  2   | Dil Lagi (Romantic Version)              Artist: Arijit Singh                     Romantic   2020
  3   | Dil Lagi (Romantic Version)              Artist: Arijit Singh                     Romantic   2020
  4   | The End of Beginning                     Artist: Steave                           Emotional  2018
  5   | Tum Hi Ho                                Artist: Atif Aslam                       Romantic   2013
  6   | Tera Hona                                Artist: Atif Aslam                       Romantic   2022
  7   | Shape of You                             Artist: Steave                           Pop        2017
  8   | Bohemian Rhapsody                        Artist: Steave                           Rock       1975
  9   | Kun Faya Kun                             Artist: Arijit Singh                     Sufi       2011

  Podcast created:
  #   | Title                                         Show                                          Ep No
 --------------------------------------------------------------------------------------------------------------------------------------------
  1   | Tech Talk: Future of CyberSecurity            Tech Talk                                     7   
  2   | Mind Matters: Sleep Science                   Mind Matters                                  12  
  3   | Podcast No. 1: Intro to Python                Podcast                                       3   
```
## Contributing

1. Fork the repo
2. Create a branch (`git checkout -b feature/your-feature`)
3. Commit your changes
4. Open a Pull Request

---
Student: 'Hanan Qaisar' <br>
Status:  'Actively learning' <br>

## License

MIT License
---
> Every song tells a story — listen closely
---
