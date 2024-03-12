package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class Mainn {
public static void main(String[] args) throws IOException {
        IMDB imdbApp = new IMDB();
        imdbApp.run();
        }
        }
public class IMDB {
    public List<User> users;
    public List<Actor> actors;
    public List<Request> requests;
    public List<Production> productions;

    private IMDB imdb;

    public IMDB getInstance(){

        if(imdb == null)
            imdb = new IMDB();
        return imdb;
    }

    private User current;
    public void run() {
        try {
            users = loadUsers("src/main/resources/input/accounts.json");
        } catch (IOException e) {
            System.out.println("fail");
            e.printStackTrace();
        }
        //printAllEmails();

        try {
            actors = loadActors("src/main/resources/input/actors.json");
            //actors.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("fail");
            e.printStackTrace();
        }
        //printActorNames(actors);


        try {
            requests = loadRequests("src/main/resources/input/requests.json");
            //requests.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("fail");
            e.printStackTrace();
        }
        //printAllRequestTypes(requests);

        try {
            productions = loadProductions("src/main/resources/input/production.json");
            //productions.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("fail");
            e.printStackTrace();
        }
        //printProductionTitles();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Alegeți modul de utilizare al aplicației (1 pentru terminal, 2 pentru interfață grafică):");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                runTerminalMode();
                break;
            case 2:
                runGraphicalInterfaceMode();
                break;
            default:
                System.out.println("Opțiune invalidă. Vă rugăm să alegeți 1 sau 2.");
                break;
        }

    }


    public void runTerminalMode() {
        User currentUser;
        int action;
        boolean runApp = true;

        while (runApp) {
            currentUser = null;
            currentUser = authenticateUser();
            if (currentUser != null) {
                System.out.println("Welcome back, " + currentUser.getUsername());
                System.out.println("User experience:" + currentUser.getExperience());
            }

            do {
                System.out.println("Choose action:");
                System.out.println("1) View productions details");
                System.out.println("2) View actors details");
                System.out.println("3) View notifications");
                System.out.println("4) Search for actor/movie/series");
                System.out.println("5) Add/Delete actor/movie/series to/from favorites");
                System.out.println("6) Add/Delete request");
                System.out.println("7) Add/Delete user");
                System.out.println("8) Add/Delete actor/movie/series from system");
                System.out.println("9) Update Movie Details");
                System.out.println("10) Update Actor Details");
                System.out.println("11) Solve a request");
                System.out.println("12) Add/Delete rating");
                System.out.println("13) Logout");
                System.out.println("14) Exit Application");
                System.out.print("Enter choice (1-14): ");

                Scanner scannerr = new Scanner(System.in);
                action = scannerr.nextInt();

                switch (action) {
                    case 1:
                        printAllProductionDetails();
                        break;
                    case 2:
                        printAllActorDetails(actors);
                        break;
                    case 3:
                        printUserNotifications(currentUser);
                        break;
                    case 4:
                        Scanner scannerNew4 = new Scanner(System.in);
                        System.out.print("Enter search term: ");
                        String searchTerm = scannerNew4.nextLine();
                        search(searchTerm);
                        break;
                    case 5:
                        Scanner scannerNew5 = new Scanner(System.in);
                        modifyFavorites(currentUser, scannerNew5);
                        break;
                    case 6:
                        if (currentUser.getuserType() != AccountType.Admin){
                            Scanner scannerNew6 = new Scanner(System.in);
                            handleRequest(currentUser, scannerNew6, requests);
                        }
                        else System.out.println("Nu-i voie:))");
                        break;
                    case 7:
                        //Add/Delete user
                        if (currentUser.getuserType() != AccountType.Regular){
                            Scanner scannerNew7 = new Scanner(System.in);
                            manageUsers(scannerNew7);
                        }
                        else System.out.println("Nu-i voie");
                        break;
                    case 8:
                        //Add/Delete actor/movie/series from system
                        if (currentUser.getuserType() != AccountType.Regular){
                            Scanner scannerNew8 = new Scanner(System.in);
                            manageProductionOrActors(scannerNew8);
                        }
                        else System.out.println("Nu-i voie");
                        break;
                    case 9:
                        //Update Movie Details
                        System.out.println("Nu este implementat");
                        break;
                    case 10:
                        //Update Actor Details
                        System.out.println("Nu este implementat");
                        break;
                    case 11:
                        //Solve a request
                        printAllRequestTypes(requests);
                        break;
                    case 12:
                        //Add/Delete rating
                        if(currentUser.getuserType() != AccountType.Admin && currentUser.getuserType() != AccountType.Contributor){
                            Scanner newScanner12 = new Scanner(System.in);
                            addOrDeleteRating(newScanner12, currentUser);
                        }
                        break;
                    case 13:
                        currentUser.logout();
                        System.out.println("You have been logged out.");
                        break;
                    case 14:
                        System.out.println("Exiting application...");
                        runApp = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                        break;
                }
            } while (action != 13 && runApp); // Continue until the user chooses to logout or exit the application
        }
    }

    private void runGraphicalInterfaceMode() {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("IMDB Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);

        // Create a card layout to switch between login and main panels
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize login panel (method not shown, needs to be implemented)
        JPanel loginPanel = initializeLoginPanel(cardPanel, cardLayout);

        // Initialize main panel (method not shown, needs to be implemented)
        JPanel mainPanel = initializeMainPanel(cardPanel, cardLayout);

        // Add panels to card panel
        cardPanel.add(loginPanel, "Login");
        cardPanel.add(mainPanel, "Main");

        // Add card panel to frame
        frame.add(cardPanel);

        // Display the window
        frame.setVisible(true);
    }


    protected JPanel initializeLoginPanel(JPanel cardPanel, CardLayout cardLayout) {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2)); // Grid layout for organized components

        // Create email and password fields
        JTextField emailField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        // Create login button
        JButton loginButton = new JButton("Login");

        // Add components to panel
        loginPanel.add(new JLabel("Email:"));
        loginPanel.add(emailField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);

        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Call authenticateUser method from IMDB class
                User authenticatedUser = authenticateUser(email, password);
                current = authenticateUser(email, password);
                if (authenticatedUser != null) {
                    // Switch to main panel upon successful login
                    cardLayout.show(cardPanel, "Main");
                } else {
                    JOptionPane.showMessageDialog(loginPanel, "Authentication failed. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return loginPanel;
    }

    public User authenticateUser(String email, String password) {
        for (User user : users) {
            if (user.getinformation().getCredentials().getEmail().equalsIgnoreCase(email) &&
                    user.getinformation().getCredentials().getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }



    private JPanel initializeMainPanel(JPanel cardPanel, CardLayout cardLayout) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create lists for productions and actors
        JList<String> productionList = new JList<>(getProductionTitles());
        JList<String> actorList = new JList<>(getActorNames());

        // Create a panel for the logout button
        JPanel logoutPanel = new JPanel();
        JButton logoutButton = new JButton("Logout");
        logoutPanel.add(logoutButton);

        // Create a panel for the user details button
        JPanel userDetailsPanel = new JPanel();
        JButton userDetailsButton = new JButton("Show User Details");
        userDetailsPanel.add(userDetailsButton);

        // Set up the layout and add the lists
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(productionList), new JScrollPane(actorList));
        mainPanel.add(splitPane, BorderLayout.CENTER);

        // Search panel components
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Add search panel to the main panel
        mainPanel.add(searchPanel, BorderLayout.EAST);

        // Add logout panel to the main panel
        mainPanel.add(logoutPanel, BorderLayout.SOUTH);

        // Add action listener to the user details button
        userDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (current != null) {
                    String userDetails = formatUserDetails(current);
                    JOptionPane.showMessageDialog(mainPanel, userDetails);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "No user is currently logged in.");
                }
            }
        });

        // Add action listener to the logout button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch back to the login panel
                cardLayout.show(cardPanel, "Login");
            }
        });

        // Add selection listener for productions
        productionList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedTitle = productionList.getSelectedValue();
                displayProductionDetails(selectedTitle);
            }
        });

        // Add selection listener for actors
        actorList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedName = actorList.getSelectedValue();
                displayActorDetails(selectedName);
            }
        });

        // Add userDetailsPanel to the main panel
        mainPanel.add(userDetailsPanel, BorderLayout.NORTH);

        searchButton.addActionListener(e -> performSearch(searchField.getText(), productionList, actorList));

        return mainPanel;
    }

    public void usersss() {
        IMDB instance = getInstance();
    }

    private String formatUserDetails(User user) {
        // Format and return the user details
        return "Username: " + user.getUsername() + "\n" +
                "Experience: " + user.getExperience() + "\n" +
                // Include other details from the User object
                "Name: " + user.getinformation().getName() + "\n" +
                "Country: " + user.getinformation().getCountry() + "\n" +
                "Age: " + user.getinformation().getAge() + "\n" +
                "Gender: " + user.getinformation().getGender() + "\n" +
                "BirthDate: " + user.getinformation().getBirthDate() + "\n";
    }

    private void performSearch(String searchTerm, JList<String> productionList, JList<String> actorList) {

        List<String> filteredProductionTitles = getProductions().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(searchTerm.toLowerCase()))
                .map(Production::getTitle)
                .collect(Collectors.toList());
        productionList.setListData(new Vector<>(filteredProductionTitles));

        List<String> filteredActorNames = getActors().stream()
                .filter(a -> a.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .map(Actor::getName)
                .collect(Collectors.toList());
        actorList.setListData(new Vector<>(filteredActorNames));
    }

    private String[] getProductionTitles() {
        return getProductions().stream().map(Production::getTitle).toArray(String[]::new);
    }

    private String[] getActorNames() {
        return getActors().stream().map(Actor::getName).toArray(String[]::new);
    }

    private void displayProductionDetails(String title) {
        // Find the production and display its details
        Production production = findProductionByTitle(title);
        if (production != null) {
            // Display details in a dialog or a new panel
            JOptionPane.showMessageDialog(null, production.getDetails()); // Simplified for example
        }
    }

    private void displayActorDetails(String name) {
        // Find the actor and display their details
        Actor actor = findActorByName(name);
        if (actor != null) {
            // Display details in a dialog or a new panel
            JOptionPane.showMessageDialog(null, actor.getDetails()); // Simplified for example
        }
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Actor> getActors(){
        return actors;
    }

    public Production findProductionByTitle(String title) {
        for (Production production : productions) {
            if (production.getTitle().equalsIgnoreCase(title)) {
                return production;
            }
        }
        return null; // Return null if no production is found with the given title
    }

    public Actor findActorByName(String name){
        for (Actor actor : actors){
            if(actor.getName().equalsIgnoreCase(name)){
                return actor;
            }
        }
        return null;
    }


    private User authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introduceți e-mail: ");
            String email = scanner.nextLine();
            System.out.print("Introduceți parola: ");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.getinformation().getCredentials().getEmail().equalsIgnoreCase(email) &&
                        user.getinformation().getCredentials().getPassword().equals(password)) {
                    System.out.println("Autentificare reușită.");
                    return user;
                }
            }
            System.out.println("Autentificare eșuată. Vă rugăm să încercați din nou.");
        }
    }

    public void printAllEmails() {
        if (users != null) {
            System.out.println("Adrese de e-mail ale utilizatorilor:");
            for (User user : users) {
                User.Information info = user.getinformation();
                if (info != null && info.getCredentials() != null) {
                    String email = info.getCredentials().getEmail();
                    System.out.println(email);
                }
            }
        } else {
            System.out.println("Nu există utilizatori încărcați.");
        }
    }
    public void printProductionTitles() {
        if (productions != null) {
            productions.forEach(production -> System.out.println(production.getTitle()));
        } else {
            System.out.println("No productions available.");
        }
    }

    public void printAllRequestTypes(List<Request> requests) {
        if (requests == null || requests.isEmpty()) {
            System.out.println("There are no requests to display.");
            return;
        }

        System.out.println("All request types:");
        for (Request request : requests) {
            System.out.println(request.getType());
        }
    }

    public void printAllProductionDetails() {
        if (productions != null) {
            for (Production production : productions) {
                System.out.println("Title: " + production.getTitle());
                if(production instanceof Movie)
                    System.out.println("Type: Movie");
                if(production instanceof Series)
                    System.out.println("Type: Series");
                System.out.println("Directors: " + String.join(", ", production.getDirectors()));
                System.out.println("Actors: " + String.join(", ", production.getActors()));
                System.out.println("Genres: " + production.getGenres().stream().map(Genre::toString).collect(Collectors.joining(", ")));
                System.out.println("Plot: " + production.getPlot());
                System.out.println("Average Rating: " + production.getAverageRating());
                if(production instanceof Movie) {
                    System.out.println("Duration: " + ((Movie) production).getDuration());
                    System.out.println("ReleaseYear: " + ((Movie) production).getReleaseYear());
                }
                if(production instanceof Series) {
                    System.out.println("ReleaseYear: " + ((Series) production).getReleaseYear());
                    System.out.println("NumSeasons: " + ((Series) production).getNumberOfSeasons());
                    System.out.println("Seasons and Episodes:");
                    for (Map.Entry<String, List<Episode>> seasonEntry : ((Series) production).getSeasons().entrySet()) {
                        System.out.println("Season: " + seasonEntry.getKey());
                        for (Episode episode : seasonEntry.getValue()) {
                            System.out.println("\tEpisode Name: " + episode.getName());
                            System.out.println("\tDuration: " + episode.getDuration());
                            if (episode.getAdditionalDetails() != null && !episode.getAdditionalDetails().isEmpty()) {
                                System.out.println("\tAdditional Details: " + episode.getAdditionalDetails());
                            }
                        }
                    }
                }
                System.out.println("------------------------------");
            }
        } else {
            System.out.println("No productions available.");
        }
    }
    public static void printActorNames(List<Actor> actors) {
        if (actors == null || actors.isEmpty()) {
            System.out.println("Lista este goală sau nu există.");
            return;
        }

        System.out.println("Numele actorilor din listă:");
        for (Actor actor : actors) {
            System.out.println(actor.getName());
        }
    }

    private static void printAllActorDetails(List<Actor> actors) {
            if (actors == null || actors.isEmpty()) {
                System.out.println("The actor list is empty or does not exist.");
                return;
            }

            System.out.println("Actor details:");
            for (Actor actor : actors) {
                System.out.println("Name: " + actor.getName());
                System.out.println("Biography: " + actor.getBiography());
                //System.out.println("Performances: " + actor.getPerformances().toString());
                if (actor.getPerformances() != null && !actor.getPerformances().isEmpty()) {
                    System.out.println("Performances:");
                    for (Actor.Performance performance : actor.getPerformances()) {
                        System.out.println("\tTitle: " + performance.title);
                        System.out.println("\tType: " + performance.type);
                    }
                } else {
                    System.out.println("No performances available for this actor.");
                }
                System.out.println("------------------------------");
            }
    }

    protected static void printUserNotifications(User currentUser) {
        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }

        List<String> notifications = currentUser.getNotifications();
        if (notifications == null || notifications.isEmpty()) {
            System.out.println("There are no notifications for the user.");
        } else {
            System.out.println("Notifications for " + currentUser.getUsername() + ":");
            for (String notification : notifications) {
                System.out.println(notification);
            }
        }
    }

    public void search(String searchTerm) {
        boolean found = false;

        // Search in productions
        for (Production production : productions) {
            if (production.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Found in productions: " + production.getTitle());
                found = true;
                break; // Remove this if you want to find all occurrences
            }
        }

        // Search in actors
        for (Actor actor : actors) {
            if (actor.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Found in actors: " + actor.getName());
                found = true;
                break; // Remove this if you want to find all occurrences
            }
        }

        if (!found) {
            System.out.println("No results found for: " + searchTerm);
        }
    }

    public void modifyFavorites(User currentUser, Scanner scanner) {
        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }

        System.out.println("Choose action:");
        System.out.println("1) Add to favorites");
        System.out.println("2) Remove from favorites");
        System.out.print("Enter choice (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        System.out.print("Enter the title of the production or name of the actor: ");
        String titleOrName = scanner.nextLine();

        switch (choice) {
            case 1:
                boolean existsInProductions = productions.stream()
                        .anyMatch(production -> production.getTitle().equalsIgnoreCase(titleOrName));
                boolean existsInActors = actors.stream()
                        .anyMatch(actor -> actor.getName().equalsIgnoreCase(titleOrName));
                if (existsInProductions || existsInActors) {
                    if (!currentUser.getFavorites().contains(titleOrName)) {
                        currentUser.getFavorites().add(titleOrName);
                        System.out.println(titleOrName + " has been added to your favorites.");
                    } else {
                        System.out.println(titleOrName + " is already in your favorites.");
                    }
                } else {
                    System.out.println("This title or name does not exist in our database.");
                }
                break;
            case 2:
                // Remove from favorites logic
                if (currentUser.getFavorites().contains(titleOrName)) {
                    currentUser.getFavorites().remove(titleOrName);
                    System.out.println(titleOrName + " has been removed from your favorites.");
                } else {
                    System.out.println(titleOrName + " was not found in your favorites.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public void handleRequest(User currentUser, Scanner scanner, List<Request> requests) {
        System.out.println("Choose action:");
        System.out.println("1) Create a new request");
        System.out.println("2) Withdraw a request");
        System.out.print("Enter choice (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        switch (choice) {
            case 1:
                // Logic to create a new request
                createRequest(currentUser, scanner, requests);
                break;
            case 2:
                // Logic to withdraw a request
                withdrawRequest(currentUser, scanner, requests);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void createRequest(User currentUser, Scanner scanner, List<Request> requests) {
        System.out.print("Enter request type: ");
        System.out.println("DELETE_ACCOUNT, ACTOR_ISSUE, MOVIE_ISSUE, OTHERS");
        String type = scanner.nextLine();
        System.out.print("Enter request description: ");
        String description = scanner.nextLine();
        System.out.println("Date: (Format YYYY-MM-DDTHH:MM:SS)");
        String date = scanner.nextLine();

        Request newRequest = new Request(stringToRequestType(type), date, currentUser.getUsername(), "ADMIN", description);
        requests.add(newRequest);
        System.out.println("Request created successfully.");
        printAllRequestTypes(requests);
    }

    public static RequestTypes stringToRequestType(String str) {
        try {
            return RequestTypes.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle the case where the string does not match any enum constants
            System.out.println("Invalid request type: " + str);
            return null;
        }
    }

    private void withdrawRequest(User currentUser, Scanner scanner, List<Request> requests) {
        System.out.print("Enter the type of the request to withdraw: ");
        String type = scanner.nextLine();

        // Convert the string type to the enum type
        RequestTypes requestType = stringToRequestType(type);
        if (requestType == null) {
            System.out.println("Invalid request type.");
            return;
        }

        boolean found = false;
        Iterator<Request> iterator = requests.iterator();
        while (iterator.hasNext()) {
            Request request = iterator.next();
            if (request.getRequestingUser().equals(currentUser.getUsername()) && request.getType() == requestType) {
                iterator.remove();
                found = true;
            }
        }

        if (found) {
            System.out.println("Your requests of type " + type + " have been withdrawn.");
        } else {
            System.out.println("No requests of type " + type + " found for your user.");
        }
    }

    private void manageUsers(Scanner scanner) {
        System.out.println("Choose action:");
        System.out.println("1) Add a user");
        System.out.println("2) Remove a user");
        System.out.print("Enter choice (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consuming the newline left-over

        switch (choice) {
            case 1:
                // Add a user logic
                System.out.print("Enter user type (Admin/Regular/Contributor): ");
                String userType = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                User newUser = UserFactory.createUser(userType, email, password);
                if (newUser != null) {
                    users.add(newUser);
                    System.out.println("New user added.");
                } else {
                    System.out.println("Invalid user type.");
                }
                break;
            case 2:
                // Remove a user logic
                System.out.print("Enter email of the user to remove: ");
                String userEmail = scanner.nextLine();

                Optional<User> userToRemove = users.stream()
                        .filter(user -> user.getCredentials().getEmail().equals(userEmail))
                        .findFirst();

                if (userToRemove.isPresent()) {
                    users.remove(userToRemove.get());
                    System.out.println("User removed.");
                    printAllEmails();
                } else {
                    System.out.println("User not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void manageProductionOrActors(Scanner scanner) {
        System.out.println("Choose action:");
        System.out.println("1) Add actor");
        System.out.println("2) Remove actor");
        System.out.println("3) Add production");
        System.out.println("4) Remove production");
        System.out.print("Enter choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        switch (choice) {
            case 1:
                // Logic to add an actor
                addActor(scanner);
                printActorNames(actors);
                break;
            case 2:
                // Logic to remove an actor
                removeActor(scanner);
                printActorNames(actors);
                break;
            case 3:
                // Logic to add a production (movie/series)
                System.out.println("Neimplementat");
                printProductionTitles();
                break;
            case 4:
                // Logic to remove a production
                removeProduction(scanner);
                printProductionTitles();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void addActor(Scanner scanner) {
        System.out.print("Enter actor's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter actor's biography: ");
        String biography = scanner.nextLine();
        Actor newActor = new Actor(name, biography, new ArrayList<>());
        actors.add(newActor);
        System.out.println("Actor added successfully.");
    }

    private void removeActor(Scanner scanner) {
        System.out.print("Enter actor's name to remove: ");
        String nameToRemove = scanner.nextLine();
        boolean removed = actors.removeIf(actor -> actor.getName().equalsIgnoreCase(nameToRemove));
        if (removed) {
            System.out.println("Actor removed successfully.");
        } else {
            System.out.println("Actor not found.");
        }
    }

    private void removeProduction(Scanner scanner) {
        System.out.print("Enter production title to remove: ");
        String titleToRemove = scanner.nextLine();
        boolean removed = productions.removeIf(production -> production.getTitle().equalsIgnoreCase(titleToRemove));
        if (removed) {
            System.out.println("Production removed successfully.");
        } else {
            System.out.println("Production not found.");
        }
    }

    private void addOrDeleteRating(Scanner scanner, User user) {
        System.out.println("Experience user:" + user.getExperience());
        System.out.print("Enter the title of the production: ");
        String productionTitle = scanner.nextLine();

        // Caută producția
        Production selectedProduction = productions.stream()
                .filter(production -> production.getTitle().equalsIgnoreCase(productionTitle))
                .findFirst()
                .orElse(null);

        if (selectedProduction == null) {
            System.out.println("Production not found.");
            return;
        }

        System.out.println("Do you want to (1) Add or (2) Delete a rating?");
        int action = scanner.nextInt();
        scanner.nextLine(); // Consumă newline-ul rămas

        switch (action) {
            case 1:
                // Adaugă rating
                Optional<Rating> existingRating = selectedProduction.getRatings().stream()
                        .filter(rating -> rating.getUsername().equals(user.getUsername()))
                        .findFirst();

                if (existingRating.isPresent()) {
                    System.out.println("You have already rated this production.");
                } else {
                    user.highExperience();
                    System.out.print("Enter your rating (1-10): ");
                    int ratingValue = scanner.nextInt();
                    scanner.nextLine(); // Consumă newline-ul rămas

                    System.out.print("Enter your comment: ");
                    String comment = scanner.nextLine();

                    Rating newRating = new Rating(user.getUsername(), ratingValue, comment);
                    selectedProduction.getRatings().add(newRating);
                    System.out.println("Rating added successfully.");
                }
                break;
            case 2:
                // Șterge rating
                boolean removed = selectedProduction.getRatings().removeIf(rating -> rating.getUsername().equals(user.getUsername()));
                if (removed) {
                    System.out.println("Your rating has been removed.");
                    user.lowExperience();
                } else {
                    System.out.println("You have not rated this production.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        // Afișează toate ratingurile pentru producția respectivă
        System.out.println("Experience user:" + user.getExperience());
        System.out.println("All ratings for " + productionTitle + ":");
        selectedProduction.getRatings().forEach(rating ->
                System.out.println("User: " + rating.getUsername() + ", Rating: " + rating.getScore() + ", Comment: " + rating.getComments()));
    }



    public List<User> loadUsers(String filePath) throws IOException{
        // Citirea conținutului fișierului JSON
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        // Crearea unui ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // Deserializarea JSON-ului într-o listă de obiecte User
        List<User> users = objectMapper.readValue(content, new TypeReference<List<User>>(){});
        return users;
    }
    private static List<Actor> loadActors(String fileName) throws IOException {
        // Citirea conținutului fișierului JSON
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        // Crearea unui ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // Deserializarea JSON-ului într-o listă de obiecte
        List<Actor> actors = objectMapper.readValue(content,
                objectMapper.getTypeFactory().constructCollectionType(List.class, Actor.class));
        return actors.stream().map(actor -> new Actor(actor.getName(), actor.getBiography(), actor.getPerformances())).collect(Collectors.toList());
    }
    private static List<Request> loadRequests(String fileName) throws IOException {
        // Citirea conținutului fișierului JSON
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        // Crearea unui ObjectMapper si inregistrarea modulului pentru JavaTime
        ObjectMapper objectMapper = new ObjectMapper();
        // Deserializarea JSON-ului într-o lista de obiecte Request
        List<Request> requests = objectMapper.readValue(content, new TypeReference<List<Request>>(){});

        return requests;

    }
    private static List<Production> loadProductions(String fileName) throws IOException {
        // Citirea conținutului fișierului JSON
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        // Crearea unui ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        // Deserializarea JSON-ului într-o listă de obiecte
        List<Production> productions = objectMapper.readValue(content,
                typeFactory.constructCollectionType(List.class, Production.class));
        return productions;
    }
}