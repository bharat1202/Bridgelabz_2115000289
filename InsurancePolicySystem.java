import java.util.*;

class Policy {
    String policyNumber, policyholderName, expiryDate, coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + "', Holder='" + policyholderName + "', Expiry='" + expiryDate +
               "', Type='" + coverageType + "', Premium=" + premiumAmount + "}";
    }
}

public class InsurancePolicySystem {
    Map<String, Policy> policies = new HashMap<>();
    Map<String, Policy> orderedPolicies = new LinkedHashMap<>();
    TreeMap<String, Policy> sortedByExpiry = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policies.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedByExpiry.put(policy.expiryDate, policy);
    }

    public Policy getPolicy(String policyNumber) {
        return policies.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon(String currentDate) {
        return new ArrayList<>(sortedByExpiry.tailMap(currentDate).values());
    }

    public List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : policies.values()) {
            if (p.policyholderName.equals(holder)) result.add(p);
        }
        return result;
    }

    public void removeExpiredPolicies(String currentDate) {
        sortedByExpiry.headMap(currentDate).clear();
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        system.addPolicy(new Policy("P123", "Alice", "2025-06-10", "Health", 5000));
        system.addPolicy(new Policy("P124", "Bob", "2024-03-15", "Auto", 4000));

        System.out.println("Policy Details: " + system.getPolicy("P123"));
        System.out.println("Expiring Policies: " + system.getPoliciesExpiringSoon("2024-06-01"));
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));
    }
}
