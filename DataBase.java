package Project_7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {
    private List<Magazine> magazines;
    private List<Streaming> streamings;
    private List<Freemium> freemiums;

    public DataBase() {
        this.magazines = new LinkedList<>();
        this.streamings = new LinkedList<>();
        this.freemiums = new LinkedList<>();
    }

    public void add_magazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public void removeMagazine(Magazine magazine) {
        magazines.remove(magazine);
    }

    public Magazine getMagazine(int index) {
        return magazines.get(index);
    }

    public List<Magazine> getAllMagazines() {
        return magazines;
    }

    public void updateMagazine(Magazine magazine, int index) {
        magazines.set(index, magazine);
    }

    public void addStreaming(Streaming streaming) {
        streamings.add(streaming);
    }

    public List<Streaming> getAllStreamings() {
        return streamings;
    }

    public void updateStreaming(Streaming streaming, int index) {
        streamings.set(index, streaming);
    }

    public void addFreemium(Freemium freemium) {
        freemiums.add(freemium);
    }


    public List<Freemium> getAllFreemiums() {
        return freemiums;
    }

    public void updateFreemium(Freemium freemium, int index) {
        freemiums.set(index, freemium);
    }

    public void viewAllSubscriptions() {
        System.out.println("All Subscriptions:");
        System.out.println("------------------");

        System.out.println("Magazines:");
        for (Magazine magazine : getAllMagazines()) {
            System.out.println("Name: " + magazine.getName());
            System.out.println("Delivery Type: " + magazine.getDeliveryType());
            System.out.println("Status: " + magazine.getStatus());
            System.out.println("Start date " + magazine.getStartDate());
            System.out.println("End date " + magazine.getEndDate());
            System.out.println();
        }

        System.out.println("Streaming Information: ");
        for (Streaming streaming : getAllStreamings()) {
            System.out.println("Name: " + streaming.getName());
            System.out.println("Device Limit: " + streaming.getDeviceLimit());
            System.out.println("Plan: " + streaming.getPlan());
            System.out.println("Status: " + streaming.getStatus());
            System.out.println("Start date " + streaming.getStartDate());
            System.out.println("End date " + streaming.getEndDate());
            System.out.println();
        }

        System.out.println("Freemiums Information: ");
        for (Freemium freemium : getAllFreemiums()) {
            System.out.println("Name: " + freemium.getName());
            System.out.println("Trial Period: " + freemium.getTrialPeriod());
            System.out.println("Status: " + freemium.getStatus());
            System.out.println("Start date " + freemium.getStartDate());
            System.out.println("End date " + freemium.getEndDate());
            System.out.println();
        }
    }
    public List<Magazine> searchMagazines(String name){
        return magazines.stream()
        .filter(magazine -> magazine.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    }
    public List<Streaming> searchStreaming(String name){
        return streamings.stream()
        .filter(streaming -> streaming.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    }
    public List<Freemium> searchFreemiums(String name){
        return freemiums.stream()
        .filter(freemium -> freemium.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    }
    public List<Magazine> filterMagazines(String status){
        return magazines.stream()
        .filter(magazine -> magazine.getDeliveryType().toLowerCase().equals(status.toLowerCase()))
        .collect(Collectors.toList());
    }
    public List<Streaming> filterStreaming(String status){
        return streamings.stream()
        .filter(streaming -> streaming.getPlan().toLowerCase().equals(status.toLowerCase()))
        .collect(Collectors.toList());
    }
    public List<Freemium> filterFreemiums(String status){
        return freemiums.stream()
        .filter(freemium -> freemium.getName().toLowerCase().equals(status.toLowerCase()))
        .collect(Collectors.toList());
    }
}