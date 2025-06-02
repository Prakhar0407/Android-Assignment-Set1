# Android-Assignment-Set1

# Book Review App

This is a simple Android Book Review App built using Java and MVVM architecture.

## Features

- View a list of books with title, author, and a placeholder thumbnail.
- Click on a book to see full details including description and rating.
- Mark books as favorites.
- Favorite books are stored using Room (SQLite) and can be viewed offline.

## Technologies Used

- Java
- MVVM Architecture
- LiveData
- Room (SQLite)
- Manual JSON parsing (local JSON file used as mock API)
- No external libraries for image loading

## Project Structure

- ui/ - Contains activities for book list and detail views.
- viewmodel/ - Contains ViewModel for managing UI data.
- data/
  - model/ - Contains Book entity.
  - local/ - Contains Room database and DAO.
  - remote/ - Contains fake API service to load data from assets.

## How to Run

1. Open the project in Android Studio.
2. Place a placeholder image.
3. Build and run the app on an emulator or physical device.

## Notes

- The book list is loaded from a local JSON file located in the `assets` folder.
- All favorited books are saved in Room and accessible offline.