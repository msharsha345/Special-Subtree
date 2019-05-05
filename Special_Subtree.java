package com.epam.task5;


import java.util.*;

public class Special_Subtree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        ArrayList<Edge> Q = new ArrayList<Edge>();
        PriorityQueue<Integer> nodes = new PriorityQueue<Integer>();
        Edge edge = null;
        for (int i = 0; i < M; i++) {
            edge = new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            Q.add(edge);
        }
        Collections.sort(Q);
        int S = scanner.nextInt();
        nodes.add(S);
        int weight = 0;
        while (nodes.size() < N) {
            for (Edge e : Q) {
                if ((nodes.contains(e.getSource()) && !nodes.contains(e.getDestination()))
                    || ((!nodes.contains(e.getSource()) && nodes.contains(e.getDestination())))){
                    edge = e;
                    Q.remove(e);
                    break;
                }
            }
            if (!nodes.contains(edge.getDestination())) nodes.add(edge.getDestination());
            else nodes.add(edge.getSource());
            weight += edge.getWeight();
        }
        System.out.println(weight);
        scanner.close();
    }
    
    static class Edge implements Comparable {
        int source;
        int destination;
        int weight;
        
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public int getSource(){return source;}
        public int getDestination(){return destination;}
        public int getWeight(){return weight;}
        @Override public int compareTo(Object O) {
            return this.weight - ((Edge)O).getWeight();
        }
        @Override public String toString() {
            return "(" + getSource() + ", " + getDestination() + ", " + getWeight() + ")";
        }
    }
}
