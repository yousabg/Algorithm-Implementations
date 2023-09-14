import java.util.*;

public class Election {
    LinkedList<String> candidates;
    int[] votes;
    int p;
    int voteCount;

    public Election(int p) {
        this.p = p;
        voteCount = 0;
    }

    public void initializeCandidates(LinkedList<String> candidates) {
        //O(n) time complexity where n = size of votes array because for loop iterates over it.
        // Space is O(n) where n = size of votes because here we actually allocate space for the votes array.
        this.candidates = candidates;
        votes = new int[candidates.size()];
        for (int i = 0; i < votes.length; i++) {
            votes[i] = 0;
        }
    }

    public void castVote(String candidate) {
        //Time is O(n) where n = size of candidates because we only iterate over that.
        //Space is O(1) since we only change 1 value in the array always
        if (voteCount > p) {
            return;
        }
        voteCount++;
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).equals(candidate)) {
                votes[i]++;
                break;
            }
        }
    }

    void votesify(LinkedList<String> candidates, int[] votes, int i) {
        //This is the same as heapify, so time is O(log n) and space is O(1)
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < votes.length && votes[left] > votes[largest]) {
            largest = left;
        }
        if (right < votes.length && votes[right] > votes[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = votes[i];
            String temp2 = candidates.get(i);
            votes[i] = votes[largest];
            candidates.set(i, candidates.get(largest));
            votes[largest] = temp;
            candidates.set(largest, temp2);
            votesify(candidates, votes, largest);
        }
    }

    public void castRandomVote() {
        //Same as castVote but this is random, so doesn't need for loop. Space is O(1) and Time is O(1)
        if (voteCount > p) {
            return;
        }
        voteCount++;
        Random random = new Random();
        int randomNum = random.nextInt(candidates.size());
        votes[randomNum]++;
    }

    public void rigElection(String candidate) {
        //Time complexity is O(nlogn * m) because of the while loop, Space complexity is O(1) because everything is created outside of the method
        int candidateIndex = -1;
        for (int i = 0; i < candidates.size(); i++) { //Getting candidate index, worst time is O(n)
            if (candidates.get(i).equals(candidate)) {
                candidateIndex = i;
                break;
            }
        }
        if (candidateIndex == -1) {
            System.out.println("Not a candidate");
            return;
        }
        int votesLeft = p - voteCount;
        votes[candidateIndex] += votesLeft;
        for (int i = votes.length / 2 - 1; i >= 0; i--) { //time complexity of O(n/2 * logn) or O(nlogn)
            votesify(candidates, votes, i);
        } while (!candidates.get(0).equals(candidate)) { //Time complexity is O(nlogn * m) where n = length of votes array and m = number of iterations needed for the candidate to get to the front from increasing their votecount.
            votes[0]--;
            votes[candidateIndex]++;
            for (int i = votes.length / 2 - 1; i >= 0; i--) { //time complexity of O(nlogn)
                votesify(candidates, votes, i);
            }
            for (int i = 0; i < candidates.size(); i++) { //time complexity of O(n)
                if (candidates.get(i).equals(candidate)) {
                    candidateIndex = i;
                    break;
                }
            }
        }

    }

    public void getTopKCandidates(int i) { //Same complexity as auditElection
        auditElection(i);
    }

    public void auditElection(int m) { //Time complexity of O(m*n), Space complexity of O(n) since we make 2 data structures to copy the current ones.
        int[] temp = new int[votes.length];
        LinkedList<String> tempCand = new LinkedList<>();
        for (int i = 0; i < votes.length; i++) { //O(n) where n = votes length
            temp[i] = votes[i];
            tempCand.add(candidates.get(i));
        }

        for (int j = 0; j < m; j++) { //O(m*n) where m = length of input
            for (int k = votes.length / 2 - 1; k >= 0; k--) {
                votesify(candidates, votes, k);
            }
            System.out.println(candidates.get(0) + " - " + votes[0]);
            votes[0] = -1;

        }
        votes = temp;
        candidates = tempCand;


    }

    public void auditElection() { //Same complexity as auditElection
        auditElection(votes.length);
    }


}
