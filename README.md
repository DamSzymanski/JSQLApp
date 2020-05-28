# JSQLApp
## JSQLApp – uniwersalny manager baz danych
### Description
JSQLApp jest aplikacją okienkową dającą użytkownikowi możliwość połączenia i wykonywania operacji z silnika bazodanowego SQLSever oraz MYSQL w ramach jednego programu. Powstała ona z wykorzystaniem rodziny technologii języka Java w wersji 8, Java FX oraz biblioteki Sqljdbc. Dynamicznie generuje widok danych z wybranych przez użytkownika tabel umożliwiając ich edycję, usuwanie, a także dodawanie nowych rekordów. Użytkownik uruchamiając aplikację dla danego silnika musi posiadać w nim użytkownika z odpowiednimi uprawnieniami. JSQL jest lekk, intuicyjną aplikacją, dostępną dla każdego.  
### Autorzy
1. Jakub Sarnowski
2. Damian Szymański
### Licencja
Aplikacja została udostępniona na podstawie licencji MIT.
https://opensource.org/licenses/mit-license.php
### Specyfikacja wymagań
#### Wymagania funkcjonalne
1. Autoryzacja użytkownika
   a) Użytkownik wybiera silnik bazodanowy, wprowadza dane użytkownika bazodanowego, wciska przycisk logowania, a po poprawnej autoryzacji zostaje mu zaprezentowany widok wyboru bazy danych i tabeli.
   b) Wejście - wybór silnika oraz nazwa użytkownika i hasło
   c) Wyjście - widok z wyborem bazy danych i tabeli
2. Wybór bazy i tabeli
   a) Użytkownik wybiera bazę danych i tabelę, wciska przycisk, wskutek czego zostaje mu zaprezentowany widok z tabelą zawierającą dane
   b) Wejście - wybór bazy i tabeli, 
   c) Wyjście - widok z danymi dla wybranej tabeli
3. Usuwanie rekordu
   a) Użytkownik klika pole warunkujące usunięcie rekordu, po czym wciska przycisk "Delete". Po udanej operacji zwracany jest komunikat. Gdy użytkownik nie wybierze pola, zwracany jest informujący komunikat.
   b) Wejście - wybór pola warunkującego i kliknięcie przycisku, 
   c) Wyjście - komunikat z informacją dla użytkownika
4.  Aktualizowanie rekordu
   a) Użytkownik klika pole warunkujące usunięcie rekordu, po czym wciska przycisk "Update". Pojawia się pole, gdzie użytkownik uzupełnia dane rekordu. Po zapisie lub braku wyboru pola warunkujacego, zwracany jest stosowny komunikat.
   b) Wejście - wybór pola warunkującego i kliknięcie przycisku, aktualizacja danych i wciśnięcie przycisku "Save" 
   c) Wyjście - komunikat z informacją dla użytkownika, zamkniecie okna edycji 
5.  Dodawanie rekordu
   a) Użytkownik klika przycisk "Add new row". Pojawia się pole, gdzie użytkownik uzupełnia dane rekordu. Po zapisie, zwracany jest stosowny komunikat.
   b) Wejście - kliknięcie przycisku, wprowadzenie danych i wciśnięcie przycisku "Save" 
   c) Wyjście - komunikat z informacją dla użytkownika, zamkniecie okna edycji 
6. Wylogowanie
   a) Użytkownik z menu kontekstowego wybiera przycisk "Logout". Okna z widokami zostają zamknięte, a użytkownikowi pojawia się widok logowania
   b) Wejście - kliknięcie przycisku
   c) Wyjście - widok logownaia
7. Widok "About"
   a) Użytkownik z menu kontekstowego wybiera przycisk "About". Pojawia się widok 
   b) Wejście - kliknięcie przycisku
   c) Wyjście - widok o autorach
   
#### Wymagania niefunkcjonalne
1. Program przeznaczony dla pojedynczego użytkownika
2. Program nie powinien widocznie obciążać zasobów sprzętowych
3. Program darmowy, dostępny dla każdego, kod otwarty
4. Konieczne działanie na systemie operacyjnym Windows 10, jeśli nie opóźnia to prac, także na poprzednich wersjach systemów Microsoft
5. Wstępna wersja programu gotowa do 02.06.2020
6. Intuicyjny interfejs, zrozumiały także dla osoby niezaznajomionej w tematach informatycznych
## Architektura oprogramowania

## Testy
### Scenariusze
### Sprawozdanie z testów
