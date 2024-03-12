IMDB Application
Descriere
Acest cod Java este pentru o aplicație IMDB (Internet Movie Database) care permite utilizatorilor să interacționeze cu o bază de date de filme, seriale și actori. Codul include o interfață utilizator, atât în modul terminal cât și în modul cu interfață grafică, și funcționalități de gestionare a datelor. 

Funcționalități
Autentificare și Înregistrare: Utilizatorii se pot autentifica și pot accesa diferite funcții în funcție de tipul contului (Regular, Contributor, Admin).
Vizualizarea și Gestionarea Produțiilor: Utilizatorii pot vizualiza detalii despre producții, pot adăuga sau șterge producții din sistem.
Gestionarea Actorilor: Se pot adăuga sau șterge actori din sistem și pot fi vizualizate detaliile acestora.
Gestionarea Cererilor: Utilizatorii pot crea, retrage sau rezolva diverse cereri.
Interacțiunea cu Favoritele: Adăugarea sau ștergerea de actori sau producții din lista de favorite.
Gestionarea Notificărilor: Vizualizarea notificărilor pentru utilizatori.
Căutare: Funcționalitate de căutare pentru a găsi rapid actori sau producții.
Evaluarea și Comentarea: Utilizatorii pot adăuga sau șterge evaluări și comentarii pentru producții.
Moduri de Funcționare
Aplicația suportă două moduri de funcționare:

Modul Terminal: Interacțiunea se realizează prin linia de comandă.
Modul Interfață Grafică: O interfață grafică prietenoasă, care facilitează interacțiunea utilizatorilor cu aplicația.

Clase de Bază: IMDB, User, Actor, Request, Production, etc.
Gestionarea Datelor: Citirea și scrierea datelor în format JSON.
Interfață Grafică: Implementată utilizând Java Swing.

Clasa Mainn:

Punctul de intrare al aplicației.
Creează o instanță a clasei IMDB și apelează metoda run().
Clasa IMDB:

Deține listele de utilizatori, actori, cereri și producții.
Metoda run() inițializează datele și solicită utilizatorului să aleagă între modul terminal și modul cu interfață grafică.
Include metode pentru încărcarea datelor din fișiere JSON.
Include funcționalități pentru autentificarea utilizatorului, afișarea și gestionarea datelor.
Modul Terminal:

Permite utilizatorilor să efectueze diverse acțiuni, cum ar fi vizualizarea detaliilor producțiilor și actorilor, gestionarea favoritelor, crearea și retragerea cererilor, adăugarea și eliminarea utilizatorilor și producțiilor.
Interacțiunea se face prin linia de comandă.
Modul Interfață Grafică:

Utilizează Java Swing pentru a crea o interfață grafică.
Include panouri pentru autentificare și afișarea principală, cu posibilitatea de a naviga între ele.
Include liste pentru producții și actori, butoane pentru acțiuni specifice și un sistem de căutare.

Metoda runGraphicalInterfaceMode():

Creează fereastra principală (JFrame) pentru aplicație.
Utilizează un CardLayout pentru a comuta între panourile de login și cele principale.
Adaugă panourile de login și principal în fereastra și le afișează.
Metoda initializeLoginPanel():

Creează și configurează panoul de login.
Include câmpuri pentru e-mail și parolă, și un buton de login.
Atașează un ascultător la butonul de login pentru a autentifica utilizatorul.
Metoda authenticateUser():

Verifică dacă există un utilizator cu emailul și parola introduse.
Returnează utilizatorul dacă autentificarea este reușită sau null în caz contrar.
Metoda initializeMainPanel():

Creează și configurează panoul principal.
Include liste pentru producții și actori, și butoane pentru acțiuni specifice (de ex., logout și afișare detalii utilizator).
Utilizează un JSplitPane pentru a împărți vizual listele de producții și actori.
Include un panou de căutare cu un câmp de text și un buton de căutare.
Logica de Interacțiune:

Atașează ascultători la butoane și liste pentru a gestiona interacțiunile utilizatorului, cum ar fi alegerea unei producții sau a unui actor, căutarea sau delogarea.
Folosește dialoguri pentru a afișa detalii suplimentare sau mesaje de eroare.

Metode de Gestionare a Datelor:

Metode pentru afișarea detaliilor producțiilor și actorilor, gestionarea favoritelor, crearea și retragerea cererilor, și multe altele.
Gestionarea utilizatorilor și a producțiilor în sistem.
Încărcarea Datelor:

Folosește Jackson ObjectMapper pentru a deserializa datele din fișiere JSON în structuri de date Java.
Utilizarea de Scanner:

Pentru citirea intrărilor utilizatorului în modul terminal.
Autentificare și Gestionarea Sesiunii:

Permite utilizatorilor să se autentifice și păstrează detalii despre utilizatorul curent.


