import java.util.*;

public class VotingSystem {
    Map<String, Integer> votes = new HashMap<>();
    Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, orderedVotes.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }

    public Map<String, Integer> getResultsSorted() {
        return sortedVotes;
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");

        System.out.println("Voting Results (Sorted): " + voting.getResultsSorted());
    }
}
