package com.example.app;

public class Application {
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("GitHub MCP Demo Application");
        System.out.println("================================");
        System.out.println("Application started successfully!");
        System.out.println("Version: 1.0.0");
        System.out.println("================================");
        
        // Start a simple server or application logic
        startServer();
    }
    
    private static void startServer() {
        System.out.println("Server is running on port 8080...");
        try {
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Application stopped");
        }
    }
}