import java.util.HashSet;
public class OTPGenerator {
// Method to generate a 6-digit OTP
public static int generateOTP() {
return (int) (Math.random() * 900000) + 100000; // Random number between100000 and 999999
}
// Method to validate if all OTPs in the array are unique
public static boolean areOTPsUnique(int[] otps) {
HashSet<Integer> uniqueOTPs = new HashSet<>();
for (int otp : otps) {
uniqueOTPs.add(otp); // Add each OTP to the set
}

return uniqueOTPs.size() == otps.length; // If size matches, all OTPs areunique
}
public static void main(String[] args) {
int[] otpArray = new int[10]; // Array to store 10 OTPs
// Generate 10 unique OTPs
for (int i = 0; i < otpArray.length; i++) {
otpArray[i] = generateOTP();
System.out.println("Generated OTP " + (i + 1) + ": " + otpArray[i]);
}
// Check if the OTPs are unique
boolean isUnique = areOTPsUnique(otpArray);
if (isUnique) {
System.out.println("\nAll OTPs are unique.");
} else {
System.out.println("\nSome OTPs are not unique.");
}
}
}

