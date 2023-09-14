import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ConversionProblem {
    public static void main(String[] args) {
        String[][] rates = {{"USD", "JPY", "10"},
                {"USD", "AUD", "1.45"},
                {"JPY", "COP", "1.3"},
                {"AUD", "COP", "0.3"},
                {"JPY", "CAN", "4.3"},
                {"AUD", "MXP", "2.3"},
                {"MXP", "CAN", "1"},
                {"USD", "BTC", "100"}, {"BTC", "COP", "9"}};
        String[] toFrom = {"USD", "COP"};


        System.out.println(bestConversionFinder(toFrom, rates));
    }

    private static Double bestConversionFinder(String[] toFrom, String[][] rates) {
        ArrayList<Vertex> countries = new ArrayList<>();
        Vertex countryOne;
        Vertex countryTwo;
        Edge newRate;
        for (String[] rate: rates) { //Here I am setting up the directed graph
            countryOne = new Vertex(rate[0]);
            countryTwo = new Vertex(rate[1]);
            for (Vertex country: countries) { //I am checking to see if the country has previously been added, if so I make
                //the country equal to the one already added so that the edges are the same. This is O(mV) time, where
                //m = number of rows in rates and V = number of countries in the arraylist countries at the present time.
                if (country.country.equals(countryOne.country)) {
                    countryOne = country;
                } else if (country.country.equals(countryTwo.country)) {
                    countryTwo = country;
                }
            }
            newRate = new Edge(Double.parseDouble(rate[2]), countryOne, countryTwo);
            countryOne.addRates(newRate);
            countries.remove(countryOne); //removing old countryone and countrytwo to add the new ones
            countries.remove(countryTwo);
            countries.add(countryOne);
            countries.add(countryTwo);

        }
        Vertex to = null;
        Vertex from = null;
        for (Vertex country: countries) { //setting up the to and from vertex based on the parameters. O(V) time
            if (country.country.equals(toFrom[0])) {
                from = country;
            } else if (country.country.equals(toFrom[1])) {
                to = country;
            }
        }

        LinkedList<Vertex> frontierQueue = new LinkedList<>();
        HashSet<Vertex> discoveredSet = new HashSet<>();
        HashMap<Vertex, Double> checkedRates = new HashMap<>();

        frontierQueue.push(from);
        checkedRates.put(from, 1.0);

        Vertex adjacentVertex;
        Vertex current;
        double rate = 0.0;
        while (frontierQueue.size() > 0) { //variation of djisktra to check for the path with the greatest product.
            //Total time complexity would be O(V^2 + E), as it is a simple variation of djikstra
            current = frontierQueue.remove();
            for (Edge edge: current.getRates()) { //checks adjacent edges, O(E) time.
                adjacentVertex = edge.to;
                rate = edge.rate;
                if (!discoveredSet.contains(adjacentVertex)) {
                    frontierQueue.add(adjacentVertex);
                    discoveredSet.add(adjacentVertex);
                    checkedRates.put(adjacentVertex, checkedRates.get(current) * rate);
                    adjacentVertex.setPrevious(current);
                } else if (checkedRates.get(adjacentVertex) < checkedRates.get(current) * rate) {
                    checkedRates.put(adjacentVertex, checkedRates.get(current) * rate);
                }
            }
        }

        Vertex vertex = to;
        System.out.println(vertex.country);
        while (vertex != from) { //O(p) time where p = number of vertex in the path to the greatest currency between to and from
            System.out.println(vertex.previous.country);
            vertex = vertex.previous;
        }
        return checkedRates.get(to);
    }
    //The time complexity of this code is O(mV + V + V^2 + E), which is the same as O(mV + V^2 + E).
    //The space complexity is O(V). We have 4 datasets here: countries, frontierQueue, discoveredSet, and checkedRates.
    //Each of these datasets have the potential to hold up to V elements, where V = number of countries.
}

class Vertex {
    String country;
    ArrayList<Edge> rates;
    Vertex previous;

    public Vertex(String country) {
        this.country = country;
        rates = new ArrayList<>();
    }

    public void addRates(Edge rate) {
        rates.add(rate);
    }

    public ArrayList<Edge> getRates() {
        return rates;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }
}

class Edge {
    double rate;
    Vertex from;
    Vertex to;

    public Edge(double rate, Vertex from, Vertex to) {
        this.rate = rate;
        this.from = from;
        this.to = to;
    }
}
