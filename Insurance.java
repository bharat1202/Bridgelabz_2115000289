import java.text.SimpleDateFormat;
import java.util.*;

// Insurance Policy Class
class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + 
               ", Expiry: " + expiryDate + ", Type: " + coverageType + ", Premium: " + premiumAmount;
    }
}

// Policy Management Class
class PolicyManager {
    private Set<InsurancePolicy> hashSet = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSet = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nHashSet Policies (Unordered):");
        hashSet.forEach(System.out::println);

        System.out.println("\nLinkedHashSet Policies (Insertion Order):");
        linkedHashSet.forEach(System.out::println);

        System.out.println("\nTreeSet Policies (Sorted by Expiry Date):");
        treeSet.forEach(System.out::println);
    }

    public Set<InsurancePolicy> getTreeSet() {
        return treeSet;
    }
}

// Policy Retrieval Class
class PolicyRetrieval {
    private Set<InsurancePolicy> treeSet;

    public PolicyRetrieval(Set<InsurancePolicy> treeSet) {
        this.treeSet = treeSet;
    }

    public List<InsurancePolicy> getExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date today = new Date();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = calendar.getTime();

        for (InsurancePolicy policy : treeSet) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByCoverage(String type) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : treeSet) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                result.add(policy);
            }
        }
        return result;
    }
}

// Duplicate Finder Class
class DuplicateFinder {
    public static Set<String> findDuplicatePolicies(List<InsurancePolicy> policies) {
        Set<String> uniquePolicyNumbers = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (InsurancePolicy policy : policies) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy.getPolicyNumber());
            }
        }
        return duplicates;
    }
}

// Performance Testing Class
class PerformanceTest {
    public static void comparePerformance() {
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();

        int numPolicies = 100000;
        Random random = new Random();
        Date expiry = new Date();

        long startTime, endTime;

        // Adding policies
        startTime = System.nanoTime();
        for (int i = 0; i < numPolicies; i++) {
            hashSet.add(new InsurancePolicy("P" + i, "Holder" + i, expiry, "Auto", 500 + random.nextDouble() * 1000));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < numPolicies; i++) {
            linkedHashSet.add(new InsurancePolicy("P" + i, "Holder" + i, expiry, "Auto", 500 + random.nextDouble() * 1000));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < numPolicies; i++) {
            treeSet.add(new InsurancePolicy("P" + i, "Holder" + i, expiry, "Auto", 500 + random.nextDouble() * 1000));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (endTime - startTime) + " ns");

        // Searching for a policy
        InsurancePolicy sample = new InsurancePolicy("P50000", "Holder50000", expiry, "Auto", 700);
        startTime = System.nanoTime();
        hashSet.contains(sample);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSet.contains(sample);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSet.contains(sample);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + " ns");
    }
}

public class Insurance {
    public static void main(String[] args) throws Exception {
        PolicyManager manager = new PolicyManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        manager.addPolicy(new InsurancePolicy("P001", "Alice", sdf.parse("2025-06-15"), "Health", 1200));
        manager.addPolicy(new InsurancePolicy("P002", "Bob", sdf.parse("2024-03-10"), "Auto", 800));
        manager.addPolicy(new InsurancePolicy("P003", "Charlie", sdf.parse("2024-04-05"), "Home", 950));
        manager.addPolicy(new InsurancePolicy("P002", "David", sdf.parse("2025-07-10"), "Auto", 1000)); // Duplicate policy number

        manager.displayAllPolicies();

        PolicyRetrieval retrieval = new PolicyRetrieval(manager.getTreeSet());
        System.out.println("\nPolicies Expiring Soon:");
        retrieval.getExpiringSoon().forEach(System.out::println);

        System.out.println("\nAuto Insurance Policies:");
        retrieval.getPoliciesByCoverage("Auto").forEach(System.out::println);

        List<InsurancePolicy> allPolicies = new ArrayList<>(manager.getTreeSet());
        Set<String> duplicatePolicies = DuplicateFinder.findDuplicatePolicies(allPolicies);
        System.out.println("\nDuplicate Policy Numbers: " + duplicatePolicies);

        PerformanceTest.comparePerformance();
    }
}
