# Dokumentacja Aplikacji Melon Dashboard
## Przegląd
 Melon Dashboard to aplikacja webowa służąca do agregacji i wizualizacji danych o aktywności użytkowników pochodzących z różnych systemów, począwszy od Pipedrive. Aplikacja umożliwia przeglądanie informacji o liczbie zamkniętych dealów, filtrowanie i sortowanie danych, a także generowanie dynamicznych wykresów.

## Technologie

* Java Spring Boot: Framework do tworzenia aplikacji webowych.
* Thymeleaf: Silnik szablonów do generowania dynamicznych widoków HTML.
* MySQL: Baza danych do przechowywania danych użytkowników i innych informacji.
* Spring Security: Framework do zarządzania uwierzytelnianiem i autoryzacją użytkowników.
* Spring Data JPA: Uproszczenie interakcji z bazą danych.
* Lombok: Biblioteka do automatycznego generowania kodu (gettery, settery, konstruktory itp.).
* Chart.js: Biblioteka JavaScript do tworzenia interaktywnych wykresów.

## Architektura
### Kontrolery:

* HomeController: Obsługa strony głównej.
* DashboardController: Obsługa dashboardu z danymi.
* RegistrationController: Obsługa rejestracji i logowania.

### Serwisy:
* PipedriveService: Komunikacja z API Pipedrive.
* DashboardService: Agregacja i przetwarzanie danych.
* CustomUserDetailsServices: Logika uwierzytelniania.

### Modele:
* User: Reprezentacja użytkownika aplikacji.
* PipedriveUser: Reprezentacja użytkownika w Pipedrive.
* PipedriveResponse: Odpowiedź z API Pipedrive.

### Repozytoria:
* UserRepository: Interakcja z bazą danych dla użytkowników.

### Konfiguracja:
* PipedriveConfig: Konfiguracja połączenia z API Pipedrive.
* SecurityConfig: Konfiguracja zabezpieczeń.

## Funkcjonalności
1. Integracja z Pipedrive: Pobieranie danych o użytkownikach i ich aktywnościach.
2. Uwierzytelnienie i autoryzacja: Rejestracja, logowanie, zarządzanie dostępem.
3. Dashboard: Wyświetlanie danych, filtrowanie, sortowanie, wykresy.
## Planowane moduły
* Integracja z innymi systemami: Google Workspace, iFaktura itp.
* Eksport danych: CSV, Excel.
* Powiadomienia: O nowych danych lub zmianach.
* Personalizacja wykresów: Dostosowywanie wyglądu wykresów.
##Dalszy rozwój
* Refaktoryzacja kodu: Poprawa czytelności i struktury.
* Obsługa błędów: Centralne zarządzanie wyjątkami.
* Bezpieczeństwo: Hasła, "zapamiętaj mnie", ochrona przed CSRF.
* Testy: Jednostkowe i integracyjne.
* Optymalizacja: Zapytania do bazy danych, wydajność.
