package com.sri.algo.design;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class ApiRateLimiter {
	static class ApiRateLimitter {

		// Use ConcurrentHashMap for Thread Safety.
		Map<ApiToken, Integer> rateLimitMap = new ConcurrentHashMap<>();

		private boolean isAllowed(ApiRequest apiRequest) {

			int existingRequestCount = rateLimitMap.getOrDefault(apiRequest.getApiToken(), 0);

			if (existingRequestCount < apiRequest.getApiToken().getLicenseType().getRequestPerSecond()) {
				return true;
			}

			return false;
		}

		public boolean processRequest(ApiRequest apiRequest) {

			if (!isAllowed(apiRequest)) {
				return false;
			}

			int requestsCount = rateLimitMap.getOrDefault(apiRequest.getApiToken(), 0);
			rateLimitMap.put(apiRequest.getApiToken(), ++requestsCount);

			return true;
		}
	}

	static class ApiRequest {

		public ApiRequest(ApiToken apiToken) {
			super();
			this.apiToken = apiToken;
		}

		ApiToken apiToken;

		public ApiToken getApiToken() {
			return apiToken;
		}

	}

	static class ApiToken {
		LicenseType licenseType;
		String user;

		public LicenseType getLicenseType() {
			return licenseType;
		}

		public ApiToken(LicenseType licenseType, String user) {
			super();
			this.licenseType = licenseType;
			this.user = user;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((licenseType == null) ? 0 : licenseType.name().hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ApiToken other = (ApiToken) obj;
			if (licenseType.name() != other.licenseType.name())
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}

	}

	public static enum LicenseType {
		LOW(10), MEDIUM(20), HIGH(50);

		int requestPerSecond;

		public int getRequestPerSecond() {
			return requestPerSecond;
		}

		private LicenseType(int requestPerSecond) {
			this.requestPerSecond = requestPerSecond;
		}

		public static LicenseType getLicenseType(String license) {
			for (LicenseType licenseType : values()) {
				if (licenseType.name().equals(license)) {
					return licenseType;
				}
			}

			//
			return null;
		}

	}

	public static void main(String[] args) {

		ApiRateLimitter apiRateLimitter = new ApiRateLimitter();

		// Test with sample input LOW or MEDIUM or HIGH
		// Prints true for the requests allowed and false for the rest.
		try (Scanner sc = new Scanner(System.in)) {
			String command = sc.nextLine();
			while (command.trim().isEmpty()) {
				command = sc.nextLine();
			}

			LicenseType licenseType = LicenseType.getLicenseType(command);
			// Send 5 more requests for which you get false as output.
			for (int i = 0; i < (licenseType.getRequestPerSecond() + 5); i++) {

				ApiRequest apiRequest = new ApiRequest(new ApiToken(licenseType, "Ram"));
				System.out.println(apiRateLimitter.processRequest(apiRequest));
			}

		}

	}

}