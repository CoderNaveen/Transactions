# Transactions

The Transactions App is a simple application that allows users to track their expenses and income. It provides a user-friendly interface to add, view, and calculate the total amount of transactions.

## Features

- Add new transactions with details such as type (expense or income) and amount.
- View a list of all transactions in a RecyclerView.
- Calculate and display the total amount of expenses and income separately.
- Data is saved locally using Room Database.
- Follows the Clean Architecture principles for a modular and maintainable codebase.
- Implements the MVVM (Model-View-ViewModel) architectural pattern for separation of concerns.

## Technology Stack

- Android SDK
- Kotlin
- Room Database
- RecyclerView
- MVVM architectural pattern
- Clean Architecture principles

## Project Structure

The project follows a structured directory layout based on Clean Architecture and MVVM patterns:

- `app`: Contains the application-level code and resources.
  - `data`: Handles data operations such as local data storage and remote API integration.
    - `local`: Manages local data storage using Room Database and related classes.
    - `repository`: Implements the repository pattern for data access and management.
  - `domain`: Defines the core business logic, including the transaction model and use cases.
  - `presentation`: Contains UI-related components, including adapters, dialogs, and view models.
    - `adapter`: Manages the RecyclerView adapter for displaying the list of transactions.
    - `dialog`: Provides the dialog fragment for adding transactions.
    - `util`: Contains utility classes for input validation and formatting.
    - `viewmodel`: Implements the view models to handle data binding and user interactions.
  - `util`: Contains utility classes used throughout the application.

## Getting Started

To get started with the Transaction Tracker App, follow these steps:

1. Clone the repository: `git clone https://github.com/CoderNaveen/Transactions.git`
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request. Make sure to follow the project's coding conventions and guidelines.

## License

This project is licensed under the [MIT License](LICENSE).
