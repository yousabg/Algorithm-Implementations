import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class ElectionSystem {
    public static void main(String[] args) {
        Random random = new Random();
        int p = random.nextInt(100);
        Election election = new Election(p);
        LinkedList<String> names = new LinkedList<>();
        //Champions from league of legends, lol
        names.add("Ashe");
        names.add("Garen");
        names.add("Lux");
        names.add("Ezreal");
        names.add("Ahri");
        names.add("Darius");
        names.add("Katarina");
        names.add("Jinx");
        names.add("Zed");
        names.add("Vayne");
        names.add("Yasuo");
        names.add("Akali");
        names.add("LeBlanc");
        names.add("Twisted Fate");
        names.add("Zoe");
        names.add("Aurelion Sol");
        names.add("Kai'Sa");
        names.add("Miss Fortune");
        names.add("Malzahar");
        names.add("Riven");

        int numCandidates = random.nextInt(names.size()) + 1;
        Set<String> selectedCandidates = new HashSet<>();
        LinkedList<String> candidates = new LinkedList<>();
        while (selectedCandidates.size() < numCandidates) {
            int index = random.nextInt(names.size());
            String candidate = names.get(index);
            if (!selectedCandidates.contains(candidate)) {
                selectedCandidates.add(candidate);
                candidates.add(candidate);
            }
        }

        election.initializeCandidates(candidates);

        System.out.println("Random votes: ");
        for (int i = 0; i < p; i++) {
            election.castRandomVote();
        }
        election.auditElection();

        election.rigElection(candidates.get(random.nextInt(candidates.size())));


        System.out.println("TOP 3 WINNERS (TOTALLY NOT RIGGED)"); //It is rigged because of the previous line
        election.getTopKCandidates(3);



    }
}
