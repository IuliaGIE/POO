package org.example;

import java.util.*;

abstract class Staff<T extends Comparable<T>> extends User<T> implements StaffInterface {
    private List<Request> personalRequests;
    private SortedSet<T> managedItems;

    public Staff(Information userInfo, AccountType accountType) {
        super(userInfo, accountType);
        this.personalRequests = new ArrayList<>();
        this.managedItems = new TreeSet<>();
    }

    @Override
    public void addProductionSystem(Production p) {
        managedItems.add((T) p);
    }

    @Override
    public void addActorSystem(Actor a) {
        managedItems.add((T) a);
    }

    @Override
    public void removeProductionSystem(String name) {
        managedItems.removeIf(item -> item instanceof Production && ((Production) item).getTitle().equals(name));
    }

    @Override
    public void removeActorSystem(String name) {
        managedItems.removeIf(item -> item instanceof Actor && ((Actor) item).getName().equals(name));
    }

    @Override
    public void updateProduction(Production p) {
        managedItems.removeIf(item -> item instanceof Production && ((Production) item).getTitle().equals(p.getTitle()));
        managedItems.add((T) p);
    }

    @Override
    public void updateActor(Actor a) {
        managedItems.removeIf(item -> item instanceof Actor && ((Actor) item).getName().equals(a.getName()));
        managedItems.add((T) a);
    }

    public void resolveRequest(Request r) {
        personalRequests.remove(r);
    }

    public void updatePersonalRequestList() {
        List<Request> newRequests = fetchRequestsFromCentralSystem();
        personalRequests.clear();
        personalRequests.addAll(newRequests);
    }

    private List<Request> fetchRequestsFromCentralSystem() {
        return new ArrayList<>();
    }
}
